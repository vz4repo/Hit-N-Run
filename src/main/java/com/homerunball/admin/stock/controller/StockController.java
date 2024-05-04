package com.homerunball.admin.stock.controller;

import com.homerunball.admin.product.domain.ProductDto;
import com.homerunball.admin.product.service.ProductService;
import com.homerunball.admin.stock.domain.StockDto;
import com.homerunball.admin.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/stock")
public class StockController {

    @Autowired
    private StockService stockService;
    @Autowired
    private ProductService productService;

    /*등록된 재고 전체를 조회하는 메서드*/
    @GetMapping("/list")
    public String list(Model model) {
        try{
            List<StockDto> stockList = stockService.getList();
            /*productList: 등록된 제품을 모두 저장한다.*/
            List<ProductDto> productList = productService.getAllProducts();
            /*productCount: 등록된 제품의 전체 개수를 센다.*/
            model.addAttribute("productList", productList);
            model.addAttribute("stockList", stockList);

        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("msg", "LIST_ERR");
            return "errorPage";
        }
        return "/admin/stock/stockList";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "/admin/stock/stockRegister";
    }

    /*선택한 상품 재고관리 버튼 클릭 -> 재고 등록 페이지로 이동*/

    /*상품목록 검색하는 기능 -> 검색해서 내가 원하는 상품 목록 조회 -> 선택한 상품 재고 등록 or 수정*/
}
