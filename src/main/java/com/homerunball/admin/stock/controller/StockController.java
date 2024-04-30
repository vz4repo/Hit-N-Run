package com.homerunball.admin.stock.controller;

import com.homerunball.admin.stock.dto.StockDto;
import com.homerunball.admin.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/list")
    public String list(Model model) {
        try{
            List<StockDto> list = stockService.getList();
            model.addAttribute("list", list);

        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("mag", "LIST_ERR");
        }

        return "stockList";
    }


}
