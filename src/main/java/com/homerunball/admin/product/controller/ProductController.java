package com.homerunball.admin.product.controller;

import com.homerunball.admin.product.ProductDto;
import com.homerunball.admin.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /*
    대시보드로 이동하는 메서드
     */
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "productDashboard";
    }

    /*
    등록된 제품을 출력하는 메서드
    productList: 등록된 제품을 모두 저장한다.
    productCount: 등록된 제품의 전체 개수를 센다.
     */
    @GetMapping("/list")
    public String list(Model m) {
        try {
            List<ProductDto> productList = productService.getAllProducts();
            int productCount = productService.getAllCount();
            m.addAttribute("productList", productList);
            m.addAttribute("productCount", productCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "productList";
    }

    /*
    제품 등록 화면을 보여주기 위한 메서드
     */
    @GetMapping("/register")
    public String register(Model m) {
        return "productRegister";
    }

    /*
    제품 등록 화면으로 입력한 제품 정보를 DB에 저장하기 위한 메서드
    추가할 제품이 한개가 아니라면 에러가 발생한다.
    에러가 발생하면 productRegister페이지로 이동한다.
    추가할 제품이 한 개라면 제품을 추가한 뒤에 productList로 이동한다.
     */
    @PostMapping("/register")
    public String register(ProductDto productDto, RedirectAttributes rattr, Model m, @RequestParam("maxQty") int maxQty) {
        System.out.println("admin/product/register 도착했다");

        /* productRegister에서 입력한 maxQty를 최대 주문 수량의 값으로 저장한다. */
        System.out.println("maxQty=" + maxQty);
        productDto.setMax_od_qty(maxQty);

        /* 입력한 제조년월에 포함된 "-"를 ""로 교체한다. */
        productDto.setPd_mnf_date(productDto.getPd_mnf_date().replace("-",""));

        /* 제품 특성에 포함된 ","를 ""로 교체한다. */
        productDto.setPd_chr_cd(productDto.getPd_chr_cd().replace(",",""));

        /* 제품의 카테고리는 제품 유형 + 제품 상세 유형 + 브랜드 코드로 구성된다. */
        String category = productDto.getPd_type_cd() + productDto.getPd_type_det_cd() + productDto.getBrd_cd();
        productDto.setCtg(category);

        /* 입력한 제품 아이디 뒤에 컬러 코드를 붙인다. */
        String pdId = productDto.getPd_id() + "-" + productDto.getClr_cd();
        productDto.setPd_id(pdId);

        try {
            if (productService.create(productDto) != 1)
                throw new Exception("Register failed.");

            rattr.addFlashAttribute("msg", "WRT_OK");
            return "redirect:/admin/product/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(productDto);
            m.addAttribute("mode", "new");
            m.addAttribute("msg", "WRT_ERR");
            return "productRegister";
        }
    }

    @GetMapping("/manage")
    public String manage(Model m) {
        return "productManage";
    }
}