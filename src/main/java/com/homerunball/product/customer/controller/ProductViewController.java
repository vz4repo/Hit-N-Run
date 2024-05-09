package com.homerunball.product.customer.controller;

import com.homerunball.product.customer.domain.ProductViewDto;
import com.homerunball.product.customer.domain.StockViewDto;
import com.homerunball.product.customer.service.ProductViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product")
public class ProductViewController {
    @Autowired
    ProductViewService productViewService;

    @GetMapping("/item")
    public String item(HttpServletRequest request,
                       Model m) throws Exception {
        String pd_id = request.getParameter("pd_id");
        String pd_clsf_cd = request.getParameter("pd_clsf_cd");

        ProductViewDto prd = productViewService.read(pd_id);
        StockViewDto stkInfo = productViewService.readStkInfo(pd_id);
        StockViewDto stkOptInfo = productViewService.readStkOptInfo(pd_id, pd_clsf_cd);

        m.addAttribute("prd", prd);
        m.addAttribute("stkInfo", stkInfo);
        m.addAttribute("stkOptInfo", stkOptInfo);
        return "productItem";}
}

