package com.homerunball.admin.product.controller;

import com.homerunball.admin.product.domain.ProductDto;
import com.homerunball.admin.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

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
    public String register(ProductDto productDto, RedirectAttributes rattr, Model m, @RequestParam("pd_id") String pd_id, HttpSession session) {
        /* 입력한 제조년월에 포함된 "-"를 ""로 교체한다. */
        productDto.setPd_mnf_date(productDto.getPd_mnf_date().replace("-",""));

        /* 제품 특성에 포함된 ","를 ""로 교체한다. */
        productDto.setPd_chr_cd(productDto.getPd_chr_cd().replace(",",""));

        /* 제품의 카테고리는 제품 유형 + 제품 상세 유형 + 브랜드 코드로 구성된다. */
        String category = productDto.getPd_type_cd() + productDto.getPd_type_det_cd() + productDto.getBrd_cd();
        productDto.setCtg(category);

        /* 이미지의 경우 경로를 지정해준다. */
        String fileRoot = "src/main/resources/img/" + productDto.getPd_type_cd();
        productDto.setMn_img_fn(fileRoot + "/mainImg/" + productDto.getMn_img_fn());
        productDto.setDet_img_fn(fileRoot + "/detailImg/" + productDto.getDet_img_fn());

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
                if (pd_id.equals("same")) {
                    serialNumber = String.format("%06d", biggestSerialNumber);
                } else if (pd_id.equals("new")) {
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
        return "/admin/product/productManage";
    }

    /*진열하지 않은 제품들의 목록을 보여준다.*/
    @GetMapping("/deleteProductList")
    public String deleteProductList(Model m) {
        try {
            /*진열하지 않은 제품만 선택하여 deleteProductList에 리스트로 저장한다.*/
            List<ProductDto> deleteProductList = productService.getAllOutProducts();

            /*진열하지 않은 제품의 수를 세어서 deleteProductCount에 저장한다.*/
            int deleteProductCount = deleteProductList.size();
            m.addAttribute("deleteProductList", deleteProductList);
            m.addAttribute("deleteProductCount", deleteProductCount);
        } catch (Exception e) {
            /*에러가 발생하면 에러 페이지로 이동한다.*/
            e.printStackTrace();
            return "errorPage";
        }
        return "/admin/product/showDeleteProduct";
    }


    @PostMapping("/restoreExcludedProduct")
    public String restoreExcludedProduct(ProductDto productDto, Model m) {
        try {
            System.out.println("productDto.getPd_id() = " + productDto.getPd_id());
            String pdIds = productDto.getPd_id();
            List<String> selectedProduct = List.of(pdIds.split(","));
            productService.showProduct(selectedProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return "errorPage";
        }
        return "redirect:/admin/product/list";
    }
}