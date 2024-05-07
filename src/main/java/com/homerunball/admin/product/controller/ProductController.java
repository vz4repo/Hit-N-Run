package com.homerunball.admin.product.controller;

import com.homerunball.admin.product.domain.ProductDto;
import com.homerunball.admin.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
    @Autowired
    private ProductService productService;

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
            e.printStackTrace();
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
    public String register(ProductDto productDto, RedirectAttributes rattr, Model m) {
        /* 입력한 제조년월에 포함된 "-"를 ""로 교체한다. */
        productDto.setPd_mnf_date(productDto.getPd_mnf_date().replace("-",""));

        /* 제품 특성에 포함된 ","를 ""로 교체한다. */
        productDto.setPd_chr_cd(productDto.getPd_chr_cd().replace(",",""));

        /* 제품의 카테고리는 제품 유형 + 제품 상세 유형 + 브랜드 코드로 구성된다. */
        String category = productDto.getPd_type_cd() + productDto.getPd_type_det_cd() + productDto.getBrd_cd();
        productDto.setCtg(category);

        /* 이미지의 경우 경로를 지정해준다. */
        String fileRoot = productDto.getPd_type_cd();
        productDto.setMn_img_fn(fileRoot + productDto.getMn_img_fn());
        productDto.setDet_img_fn(fileRoot + productDto.getDet_img_fn());

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

            /* productRegister에서 입력받은 productDto를 사용해서 새로운 제품을 추가한다. */
            if (productService.create(productDto) != 1)
                throw new Exception("Register failed.");

            rattr.addFlashAttribute("msg", "제품이 정상적으로 등록되었습니다.");
            return "redirect:/admin/product/list";
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            m.addAttribute(productDto);
            m.addAttribute("msg", "제품ID가 중복되었습니다.");
            return "/admin/product/productRegister";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(productDto);
            m.addAttribute("msg", "제품이 정상적으로 등록되지 않았습니다.");
            return "/admin/product/productRegister";
        }
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
            e.printStackTrace();
            return "errorPage";
        }
        return "/admin/product/productManage";
    }

    /*선택된 제품에 대한 수정사항을 반영한다.*/
    @PostMapping("/manage")
    public String manage(ProductDto productDto, @RequestParam("productNumber") String productNumber, @RequestParam("changeContent") String changeContent, @RequestParam("popupInput") String popupInput, RedirectAttributes rattr, Model m) {
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

            /*변경된 컬럼과 값을 저장하기 위해 map타입의 productMap 선언*/
            Map<String, Object> productMap = new HashMap<>();
            productMap.put(changeContent, popupInput);

            /*productMap에 선택된 pd_id도 저장한다.*/
            productMap.put("pd_id", productList);

            productService.modifyContent(productMap);
            rattr.addFlashAttribute("msg", "제품의 내용을 성공적으로 수정하였습니다.");
        } catch (DataIntegrityViolationException e) {
          m.addAttribute(productDto);
          m.addAttribute("msg", "수정할 값을 잘못 입력하셨습니다.");
          return "redirect:/admin/product/manage";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(productDto);
            m.addAttribute("msg", "제품의 내용을 수정하는 데 실패하였습니다.");
            return "errorPage";
        }
        return "redirect:/admin/product/manage";
    }

    @GetMapping("/manage/exposure")
    public String productExposure(ProductDto productDto, @RequestParam("productNumber") String productNumber, Model m, RedirectAttributes rattr) {
        List<String> productList = new ArrayList<>();
        try {
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

            m.addAttribute("productListSize", productList.size());
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(productDto);
            m.addAttribute("msg", "에러가 발생했습니다.");
            return "errorPage";
        }

        return "/admin/product/managePopup/productExposureManage";
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
            e.printStackTrace();
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
            System.out.println("pdIds = " + pdIds);
            System.out.println("pdIds.length() = " + pdIds.length());

            /*만약 선택된 제품이 없다면 선택된 제품이 없다는 메시지 보내기*/
            if(pdIds == "") {
                rattr.addFlashAttribute("msg", "선택된 제품이 없습니다.");
                return "redirect:/admin/product/showHiddenProductList";
            }

            /*selectedProduct: pdIds를 리스트의 형식으로 저장하는 변수*/
            List<String> selectedProduct = List.of(pdIds.split(","));
            System.out.println("selectedProduct = " + selectedProduct);
            System.out.println("selectedProduct.size() = " + selectedProduct.size());

            /*선택된 제품들을 다시 진열한다.*/
            productService.showProduct(selectedProduct);

            /*제품이 정상적으로 진열되면 showHiddenProductList페이지에서 알려준다.*/
            rattr.addFlashAttribute("msg", "제품이 정상적으로 진열되었습니다.");
        } catch (Exception e) {
            /*에러가 발생하면 에러페이지로 이동한다.*/
            e.printStackTrace();
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
            e.printStackTrace();
            m.addAttribute(productDto);
            m.addAttribute("msg", "에러가 발생했습니다.");
            return "errorPage";
        }
        return "redirect:/admin/product/list";
    }
}