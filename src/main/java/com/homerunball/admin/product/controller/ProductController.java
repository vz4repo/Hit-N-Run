package com.homerunball.admin.product.controller;

import com.homerunball.admin.product.domain.ProductDto;
import com.homerunball.admin.product.service.ProductService;
import com.homerunball.admin.stock.service.StockService;
import java.io.File;
import java.io.IOException;
import javax.servlet.FilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Value("#{properties['upload.path']}")
    private String uploadPath;

    /*대시보드로 이동하는 메서드*/
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "/admin/product/productDashboard";
    }

    /*등록된 제품을 출력하는 메서드*/
    @GetMapping("/list")
    public String list(Model m) {
        try {
            /*productList: 등록된 제품을 모두 저장한다.*/
            List<ProductDto> productList = productService.getAllProducts();
            /*productCount: 등록된 제품의 전체 개수를 센다.*/
            int productCount = productService.getAllCount();
            m.addAttribute("productList", productList);
            m.addAttribute("productCount", productCount);
        } catch (Exception e) {
            return "errorPage";
        }
        return "/admin/product/productList";
    }

    /*
    제품 등록 화면을 보여주기 위한 메서드
     */
    @GetMapping("/register")
    public String register(Model m) {
        return "/admin/product/productRegister";
    }

    /*
    제품 등록 화면으로 입력한 제품 정보를 DB에 저장하기 위한 메서드
    추가할 제품이 한개가 아니라면 에러가 발생한다.
    에러가 발생하면 productRegister페이지로 이동한다.
    추가할 제품이 한 개라면 제품을 추가한 뒤에 productList로 이동한다.
     */
    @PostMapping("/register")
    public String register(ProductDto productDto, RedirectAttributes rattr, Model m,
        @RequestPart("mn_img_f") MultipartFile mainImage,
        @RequestPart("det_img_f") MultipartFile detailImage) {

        /* 입력한 제조년월에 포함된 "-"를 ""로 교체한다. */
        productDto.setPd_mnf_date(productDto.getPd_mnf_date().replace("-",""));

        /* 제품 특성에 포함된 ","를 ""로 교체한다. */
        productDto.setPd_chr_cd(productDto.getPd_chr_cd().replace(",",""));

        /* 제품의 카테고리는 제품 유형 + 제품 상세 유형 + 브랜드 코드로 구성된다. */
        String category = productDto.getPd_type_cd() + productDto.getPd_type_det_cd() + productDto.getBrd_cd();
        productDto.setCtg(category);

        try {
            /*
            pd_type_cd에 해당하는 로우 수가 0개라면
                serialNumber값은 000001이 되게 한다.
            pd_type_cd에 해당하는 로우 수가 0개가 아니고
                이전 제품과 동일한 제품으로 체크되어 있으면
                    max와 동일한 값이 시리얼 넘버가 된다.
                이전 제품과 다른 새로운 제품으로 체크되어 있다면
                    max에 +1한 값이 시리얼 넘버가 된다.
            */
            String serialNumber = "";
            if (productService.countProductType(productDto.getPd_type_cd()) == 0) {
                serialNumber = String.format("%06d", 1);
            } else {
                /* biggestSerialNumber: 제품 유형 중 가장 큰 숫자를 저장하는 변수 */
                int biggestSerialNumber = productService.findBiggestSerialNumber(productDto.getPd_type_cd());
                String getpdId = productDto.getPd_id();
                if (getpdId.equals("same")) {
                    serialNumber = String.format("%06d", biggestSerialNumber);
                } else if (getpdId.equals("new")) {
                    serialNumber = String.format("%06d", biggestSerialNumber+1);
                }
            }

            /*
            시리얼 넘버 앞에는 제품 유형 코드를 붙인다.
            시리얼 넘버 뒤에는 컬러 코드를 붙인다.
            */
            String pdId = productDto.getPd_type_cd() + serialNumber + "-" + productDto.getClr_cd();
            productDto.setPd_id(pdId);

            /*만약 판매 예정일이 제품 제조년월보다 과거면 에러가 발생한다.*/

            /* 이미지 업로드 */
//          path : <properties.upload.path>/<pd_type_cd>/main/<mn_img_fn>
            String mainImagePath = uploadFile(mainImage);
            productDto.setMn_img_fn(mainImage.getOriginalFilename());

//          path : <properties.upload.path>/<pd_type_cd>/detail/<mn_img_fn>
            String detailImagePath = uploadFile(detailImage);
            productDto.setDet_img_fn(detailImage.getOriginalFilename());

            /* productRegister에서 입력받은 productDto를 사용해서 새로운 제품을 추가한다. */
            if (productService.create(productDto) != 1) throw new Exception("Register failed.");

            rattr.addFlashAttribute("msg", "제품이 정상적으로 등록되었습니다.");
            return "redirect:/admin/product/list";
        } catch (DuplicateKeyException e) {
            m.addAttribute(productDto);
            m.addAttribute("msg", "제품ID가 중복되었습니다.");
            return "/admin/product/productRegister";
        } catch (Exception e) {
            m.addAttribute(productDto);
            m.addAttribute("msg", "제품이 정상적으로 등록되지 않았습니다.");
            return "/admin/product/productRegister";
        }
    }

    /* 2024.05.25 [혁락] 파일 업로드 */
    private String uploadFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("파일이 비었습니다.");
        }

        /* TODO: 여기서도 exception 가능성 있는지 확인 필요 */
        File targetFile = new File(uploadPath + File.separator + file.getOriginalFilename());
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            throw new IOException("파일 업로드 실패 !!");
        }
        return targetFile.getAbsolutePath();
    }

    /*제품 관리 페이지로 이동한다.*/
    @GetMapping("/manage")
    public String manage(Model m) {
        try {
            /*productList: 등록된 제품을 모두 저장한다.*/
            List<ProductDto> productList = productService.getAllProducts();
            /*productCount: 등록된 제품의 전체 개수를 센다.*/
            int productCount = productService.getAllCount();
            m.addAttribute("productList", productList);
            m.addAttribute("productCount", productCount);
        } catch (Exception e) {
            return "errorPage";
        }
        return "/admin/product/productManage";
    }

    /*선택된 제품에 대한 수정사항을 반영한다.*/
    @PostMapping("/manage")
    public String manage(ProductDto productDto, @RequestParam("productList") String productID, String selectedContent, RedirectAttributes rattr, HttpServletRequest request, Model m, String pd_chr_cd) {
        /*이전 페이지의 url을 referer에 저장한다.*/
        String referer = request.getHeader("Referer");
        System.out.println("referer = " + referer);
        try {
            /*
            productNumber가 selectedProduct라면
                pd_Id에 선택된 제품 List로 저장한다.
            productNumber가 allProduct라면
                pd_Id에 모든 제품을 List로 저장한다.

            changeContent에 저장된 값을 map의 key로 설정한다.
            request에서 popupInput에 저장된 값을 value로 설정한다.

            성공하면 성공했다는 메시지를 보내고, 제품 수정 페이지로 이동한다.
            실패하면 실패했다는 메시지를 보내고, 에러 페이지로 이동한다.
            */

            /*변경된 컬럼과 값, 제품ID를 저장하기 위해 map타입의 productMap 선언한다.*/
            Map<String, Object> productMap = new HashMap<>();

            /*선택된 제품ID를 저장하기 위한 List타입의 productList를 선언한다.*/
            List<String> productList = new ArrayList<>();
            /*productID를 ","를 기준으로 분리해서 String 타입의 배열 productArr에 저장한다.*/
            String[] productArr = productID.split(",");
            for (int i = 0; i < productArr.length; i++) {
                String product = productArr[i].trim();
                productList.add(product);
            }

            /*selectedContent를 저장할 list타입의 selectedContentList 변수를 선언한다.*/
            List<String> selectedContentList = new ArrayList<>();
            /*productExposureMangage에서 selectedContent를 가져와서 배열 contentArr에 하나씩 저장한다.*/
            String[] contentArr = selectedContent.split(",");
            /*contentArr의 원소를 selectedContentList에 하나씩 추가한다.*/
            for(int i = 0;i<contentArr.length;i++) {
                selectedContentList.add(contentArr[i]);
            }

            /*선택된 변경 항목을 selectedContentList에 있는 문자열을 반복하는 iterator을 선언한다.*/
            Iterator<String> iterator = selectedContentList.iterator();
            while (iterator.hasNext()) {
                /*변경할 항목을 changeContent에 저장한다.*/
                String changeContent = iterator.next().trim();
                String changeStringValue = "";

                /*만약 changeContent가 pd_chr_cd라면*/
                if (changeContent.equals("pd_chr_cd")) {
                    /* 제품 특성에 포함된 ","를 ""로 교체한다. */
                    changeStringValue = pd_chr_cd.replace(",","");
                    /*productMap에 key는 changeContent, value는 changeStringValue에 저장한다.*/
                    productMap.put(changeContent, changeStringValue);
                } else { /*만약 changeContent가 pd_chr_cd, min_od_qty, max_od_qty, wgh가 아니라면*/
                    /*productExposureManage페이지에서 changeContent를 name으로 갖는 파라미터를 changeStringValue에 저장한다.*/
                    changeStringValue = request.getParameter(changeContent);
                    /*productMap에 key는 changeContent, value는 changeStringValue에 저장한다.*/
                    productMap.put(changeContent, changeStringValue);
                }
                /*만약 changeStringValue가 null이라면 에러 발생*/
                if (changeStringValue == null || changeStringValue.equals("")) throw new IllegalArgumentException();
//                /*productMap에 key는 changeContent, value는 changeStringValue에 저장한다.*/
//                productMap.put(changeContent, changeStringValue);
            }

            /*제품의 카테고리를 변경해준다.*/
            String category = productDto.getPd_type_cd() + productDto.getPd_type_det_cd() + productDto.getBrd_cd();
            productDto.setCtg(category);
            productMap.put("ctg", category);

            /*productMap에 선택된 pd_id를 저장한다.*/
            productMap.put("pd_id", productList);

            Iterator iteratorMap = productMap.entrySet().iterator();
            while (iteratorMap.hasNext()) {
                Map.Entry entry = (Map.Entry) iteratorMap.next();
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            productService.modifyContent(productMap);
            rattr.addFlashAttribute("msg", "제품의 내용을 성공적으로 수정하였습니다.");
        } catch (IllegalArgumentException e) {
            rattr.addFlashAttribute("productList", productID);
            rattr.addFlashAttribute("selectedContent", selectedContent);
            rattr.addFlashAttribute(productDto);
            rattr.addFlashAttribute("msg", "체크한 항목에 값을 입력해주세요.");
            /*return "redirect:/admin/product/manage";*/
            /*이전 페이지로 이동한다.*/
            return "redirect:"+referer;
        } catch (DataIntegrityViolationException e) {
            rattr.addFlashAttribute(productDto);
            rattr.addFlashAttribute("msg", "수정할 값을 잘못 입력하셨습니다.");
            return "redirect:/admin/product/manage";
        } catch (Exception e) {
            m.addAttribute(productDto);
            m.addAttribute("msg", "제품의 내용을 수정하는 데 실패하였습니다.");
            return "errorPage";
        }
        return "redirect:/admin/product/manage";
    }

    @GetMapping("/manage/exposure")
    public String productExposure(ProductDto productDto, Model m) {
        return "/admin/product/managePopup/productExposureManage";
    }

    /*제품의 표시 설정을 변경하기 위한 메서드*/
    @PostMapping("/manage/exposure")
    public String productExposure(ProductDto productDto, String productNumber, Model m, RedirectAttributes rattr) {
        /*
        productNumber가 selectedProduct라면
            pd_Id에 선택된 제품 List로 저장한다.
        productNumber가 allProduct라면
            pd_Id에 모든 제품을 List로 저장한다.

        changeContent에 저장된 값을 map의 key로 설정한다.
        request에서 popupInput에 저장된 값을 value로 설정한다.

        성공하면 성공했다는 메시지를 보내고, 제품 수정 페이지로 이동한다.
        실패하면 실패했다는 메시지를 보내고, 에러 페이지로 이동한다.
        */
        try {
            List<String> productList = new ArrayList<>();
            if (productNumber.equals("selectedProduct")) {
                /*만약 선택된 제품이 없다면 제품을 선택해달라는 메시지를 보낸다.*/
                if (productDto.getPd_id() == "") {
                    rattr.addFlashAttribute("msg", "수정할 제품을 선택해주세요.");
                    return "redirect:/admin/product/manage";
                }

                String[] pdArr = productDto.getPd_id().split(",");
                for(int i = 0;i<pdArr.length;i++) {
                    productList.add(pdArr[i]);
                }
            } else if (productNumber.equals("allProduct")) {
                int productSize = productService.getAllProducts().size();
                for (int i=0; i<productSize; i++) {
                    String pdId = productService.getAllProducts().get(i).getPd_id();
                    productList.add(pdId);
                }
            }

            /*list인 productList를 문자열로 변환해서 모델에 추가한다.*/
            String productListToString = productList.toString().substring(1, productList.toString().length()-1);
            m.addAttribute("selectedProductCount", productList.size());
            m.addAttribute("productList", productListToString);
        } catch (Exception e) {
            m.addAttribute(productDto);
            m.addAttribute("msg", "에러가 발생했습니다.");
            return "errorPage";
        }

        return "/admin/product/managePopup/productExposureManage";
    }

    /*제품의 기초 정보를 수정하기 위한 메서드*/
    @PostMapping("/manage/basicInformation")
    public String manageBasicInformation(ProductDto productDto, String productNumber, Model m, RedirectAttributes rattr) {
        /*
        productNumber가 selectedProduct라면
            pd_Id에 선택된 제품 List로 저장한다.
        productNumber가 allProduct라면
            pd_Id에 모든 제품을 List로 저장한다.

        changeContent에 저장된 값을 map의 key로 설정한다.
        request에서 popupInput에 저장된 값을 value로 설정한다.

        성공하면 성공했다는 메시지를 보내고, 제품 수정 페이지로 이동한다.
        실패하면 실패했다는 메시지를 보내고, 에러 페이지로 이동한다.
        */
        try {
            List<String> productList = new ArrayList<>();
            if (productNumber.equals("selectedProduct")) {
                /*만약 선택된 제품이 없다면 제품을 선택해달라는 메시지를 보낸다.*/
                if (productDto.getPd_id() == "") {
                    rattr.addFlashAttribute("msg", "수정할 제품을 선택해주세요.");
                    return "redirect:/admin/product/manage";
                }

                String[] pdArr = productDto.getPd_id().split(",");
                for(int i = 0;i<pdArr.length;i++) {
                    productList.add(pdArr[i]);
                }
            } else if (productNumber.equals("allProduct")) {
                int productSize = productService.getAllProducts().size();
                for (int i=0; i<productSize; i++) {
                    String pdId = productService.getAllProducts().get(i).getPd_id();
                    productList.add(pdId);
                }
            }

            /*list인 productList를 문자열로 변환해서 모델에 추가한다.*/
            String productListToString = productList.toString().substring(1, productList.toString().length()-1);
            m.addAttribute("selectedProductCount", productList.size());
            m.addAttribute("productList", productListToString);
        } catch (Exception e) {
            m.addAttribute(productDto);
            m.addAttribute("msg", "에러가 발생했습니다.");
            return "errorPage";
        }

        return "/admin/product/managePopup/manageBasicInformation";
    }

    /*판매 정보를 수정하기 위한 메서드*/
    @PostMapping("/manage/salesInformation")
    public String manageSalesInformation(ProductDto productDto, String productNumber, Model m, RedirectAttributes rattr) {
        /*
        productNumber가 selectedProduct라면
            pd_Id에 선택된 제품 List로 저장한다.
        productNumber가 allProduct라면
            pd_Id에 모든 제품을 List로 저장한다.

        changeContent에 저장된 값을 map의 key로 설정한다.
        request에서 popupInput에 저장된 값을 value로 설정한다.

        성공하면 성공했다는 메시지를 보내고, 제품 수정 페이지로 이동한다.
        실패하면 실패했다는 메시지를 보내고, 에러 페이지로 이동한다.
        */
        try {
            List<String> productList = new ArrayList<>();
            if (productNumber.equals("selectedProduct")) {
                /*만약 선택된 제품이 없다면 제품을 선택해달라는 메시지를 보낸다.*/
                if (productDto.getPd_id() == "") {
                    rattr.addFlashAttribute("msg", "수정할 제품을 선택해주세요.");
                    return "redirect:/admin/product/manage";
                }

                String[] pdArr = productDto.getPd_id().split(",");
                for(int i = 0;i<pdArr.length;i++) {
                    productList.add(pdArr[i]);
                }
            } else if (productNumber.equals("allProduct")) {
                int productSize = productService.getAllProducts().size();
                for (int i=0; i<productSize; i++) {
                    String pdId = productService.getAllProducts().get(i).getPd_id();
                    productList.add(pdId);
                }
            }

            /*list인 productList를 문자열로 변환해서 모델에 추가한다.*/
            String productListToString = productList.toString().substring(1, productList.toString().length()-1);
            m.addAttribute("selectedProductCount", productList.size());
            m.addAttribute("productList", productListToString);
        } catch (Exception e) {
            m.addAttribute(productDto);
            m.addAttribute("msg", "에러가 발생했습니다.");
            return "errorPage";
        }

        return "/admin/product/managePopup/manageSalesInformation";
    }

    /*이미지를 등록한 내용을 수정하기 위한 메서드*/
    @PostMapping("/manage/imageRegistration")
    public String manageImageRegistration(ProductDto productDto, String productNumber, Model m, RedirectAttributes rattr) {
        /*
        productNumber가 selectedProduct라면
            pd_Id에 선택된 제품 List로 저장한다.
        productNumber가 allProduct라면
            pd_Id에 모든 제품을 List로 저장한다.

        changeContent에 저장된 값을 map의 key로 설정한다.
        request에서 popupInput에 저장된 값을 value로 설정한다.

        성공하면 성공했다는 메시지를 보내고, 제품 수정 페이지로 이동한다.
        실패하면 실패했다는 메시지를 보내고, 에러 페이지로 이동한다.
        */
        try {
            List<String> productList = new ArrayList<>();
            if (productNumber.equals("selectedProduct")) {
                /*만약 선택된 제품이 없다면 제품을 선택해달라는 메시지를 보낸다.*/
                if (productDto.getPd_id() == "") {
                    rattr.addFlashAttribute("msg", "수정할 제품을 선택해주세요.");
                    return "redirect:/admin/product/manage";
                }

                String[] pdArr = productDto.getPd_id().split(",");
                for (String s : pdArr) {
                    productList.add(s);
                }
            } else if (productNumber.equals("allProduct")) {
                int productSize = productService.getAllProducts().size();
                for (int i=0; i<productSize; i++) {
                    String pdId = productService.getAllProducts().get(i).getPd_id();
                    productList.add(pdId);
                }
            }

            /*list인 productList를 문자열로 변환해서 모델에 추가한다.*/
            String productListToString = productList.toString().substring(1, productList.toString().length()-1);
            m.addAttribute("selectedProductCount", productList.size());
            m.addAttribute("productList", productListToString);
        } catch (Exception e) {
            m.addAttribute(productDto);
            m.addAttribute("msg", "에러가 발생했습니다.");
            return "errorPage";
        }

        return "/admin/product/managePopup/manageImageRegistration";
    }

    /*진열하지 않은 제품들의 목록을 보여준다.*/
    @GetMapping("/showHiddenProductList")
    public String showHiddenProductList(Model m) {
        try {
            /*진열하지 않은 제품만 선택하여 deleteProductList에 리스트로 저장한다.*/
            List<ProductDto> hiddenProductList = productService.getAllOutProducts();

            /*진열하지 않은 제품의 수를 세어서 deleteProductCount에 저장한다.*/
            int hiddenProductCount = hiddenProductList.size();
            m.addAttribute("hiddenProductList", hiddenProductList);
            m.addAttribute("hiddenProductCount", hiddenProductCount);
        } catch (Exception e) {
            /*에러가 발생하면 에러 페이지로 이동한다.*/
            return "errorPage";
        }
        return "/admin/product/showHiddenProduct";
    }

    /*진열이 제외된 제품들을 다시 진열한다.*/
    @PostMapping("/restoreExcludedProduct")
    public String restoreExcludedProduct(ProductDto productDto, RedirectAttributes rattr, Model m) {
        try {
            /*pdIds: 선택된 제품ID(pd_id)들을 문자열로 저장하기 위한 변수*/
            String pdIds = productDto.getPd_id();

            /*만약 선택된 제품이 없다면 선택된 제품이 없다는 메시지 보내기*/
            if(pdIds == "") {
                rattr.addFlashAttribute("msg", "선택된 제품이 없습니다.");
                return "redirect:/admin/product/showHiddenProductList";
            }

            /*selectedProduct: pdIds를 리스트의 형식으로 저장하는 변수*/
            List<String> selectedProduct = List.of(pdIds.split(","));

            /*선택된 제품들을 다시 진열한다.*/
            productService.showProduct(selectedProduct);

            /*제품이 정상적으로 진열되면 showHiddenProductList페이지에서 알려준다.*/
            rattr.addFlashAttribute("msg", "제품이 정상적으로 진열되었습니다.");
        } catch (Exception e) {
            /*에러가 발생하면 에러페이지로 이동한다.*/
            m.addAttribute(productDto);
            m.addAttribute("msg", "에러가 발생했습니다.");
            return "errorPage";
        }
        return "redirect:/admin/product/showHiddenProductList";
    }

    /*진열하고 있지 않은 제품들 중에서 선택된 제품들을 삭제한다.*/
    @PostMapping("/deleteExcludedProduct")
    public String deleteExcludedProduct(ProductDto productDto, RedirectAttributes rattr, Model m) {
        try {
            /*pdIds: 선택된 제품ID(pd_id)들을 문자열로 저장하기 위한 변수*/
            String pdIds = productDto.getPd_id();

            /*만약 선택된 제품이 없다면 선택된 제품이 없다는 메시지 보내기*/
            if(pdIds == "") {
                rattr.addFlashAttribute("msg", "선택된 제품이 없습니다.");
                return "redirect:/admin/product/showHiddenProductList";
            }

            /*selectedProduct: pdIds를 리스트의 형식으로 저장하는 변수*/
            List<String> selectedProduct = List.of(pdIds.split(","));

            /*선택된 제품들을 삭제한다.*/
            productService.removeSelectedProduct(selectedProduct);
            /*제품이 정상적으로 삭제되면 productList페이지에서 알려준다.*/
            rattr.addFlashAttribute("msg", "제품이 정상적으로 제거되었습니다.");
        } catch (Exception e) {
            /*에러가 발생하면 에러페이지로 이동한다.*/
            m.addAttribute(productDto);
            m.addAttribute("msg", "에러가 발생했습니다.");
            return "errorPage";
        }
        return "redirect:/admin/product/list";
    }
}