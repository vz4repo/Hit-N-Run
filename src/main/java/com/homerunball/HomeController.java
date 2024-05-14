package com.homerunball;

import com.homerunball.admin.product.domain.MainProductDto;
import com.homerunball.admin.product.service.MainProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private MainProductService mainProductService;

    @RequestMapping("/")
    public String main(Model m) {
        try {
            /*productList: 등록된 제품을 모두 저장한다.*/
            List<MainProductDto> mainProductList = mainProductService.getAllNewSalesProduct();
            int mainProductNumber = mainProductList.size();
            m.addAttribute("mainProductList", mainProductList);
            m.addAttribute("mainProductNumber", mainProductNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return "errorPage";
        }
        return "index";
    }
}