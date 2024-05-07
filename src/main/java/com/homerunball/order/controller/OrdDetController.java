package com.homerunball.order.controller;

import com.homerunball.cart.dao.CartDao;
import com.homerunball.cart.domain.CartDto;
import com.homerunball.order.dao.OrdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class OrdDetController {
    @Autowired
    CartDao cartDao;
    @Autowired
    OrdDao ordDao;
    @GetMapping("/orderDetail")
    public String orderDetail(String od_id,String c_id, Model m){
        try {
            /*List<OrdDto> list = ordDao.selectOdId(od_id);
            System.out.println(list);*/
            List<CartDto> list = cartDao.selectUser(c_id);

            System.out.println(list);

            /*System.out.println("[controller]ordDto = " + ordDto);*/
            m.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "orderList";
    }
}
