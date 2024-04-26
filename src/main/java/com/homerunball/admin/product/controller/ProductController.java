package com.homerunball.admin.product.controller;

import com.homerunball.admin.product.ProductDto;
import com.homerunball.admin.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "productDashboard";
    }

    @GetMapping("/list")
    public String list(Model m) {
        try {
            List<ProductDto> productList = productService.getAllProducts();
            int productCount = productService.getCount();
            m.addAttribute("productList", productList);
            m.addAttribute("productCount", productCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "productList";
    }

    @GetMapping("/register")
    public String register(Model m) {
        return "productRegister";
    }

    @PostMapping("/register")
    public String register() {
        return "productList";
    }

    @GetMapping("/manage")
    public String manage(Model m) {
        return "productManage";
    }


}