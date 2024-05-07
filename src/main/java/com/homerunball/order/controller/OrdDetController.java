package com.homerunball.order.controller;


import com.homerunball.order.dao.OrderDetDao;
import com.homerunball.order.domain.OrderDetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ord")
public class OrdDetController {
    @Autowired
    OrderDetDao orderDetDao;

    @GetMapping("/detail")
    public String orderDetailForm(int od_det_seqnum, int od_id, Model m){
        try{
            List<OrderDetDto> list = orderDetDao.select(od_det_seqnum,od_id);
            System.out.println(list);

            m.addAttribute("list", list);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "orderdetail";
    }
}