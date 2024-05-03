package com.homerunball.admin.stock.controller;

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

    /*등록된 재고 전체를 조회하는 메서드*/
    @GetMapping("/list")
    public String list(Model model) {
        try{
            List<StockDto> stockList = stockService.getList();
            model.addAttribute("stockList", stockList);

        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("msg", "LIST_ERR");
            return "errorPage";
        }

        return "/admin/stock/stockList";
    }

    /*
    재고
    */


//    GetMapping("")


}
