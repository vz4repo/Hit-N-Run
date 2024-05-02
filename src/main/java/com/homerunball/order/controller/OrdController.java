package com.homerunball.order.controller;

import com.homerunball.cart.dao.CartDao;
import com.homerunball.cart.domain.CartDto;
import com.homerunball.order.dao.OrdDao;
import com.homerunball.order.service.OrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/")
public class OrdController {
    @Autowired
    OrdService ordService;
    @Autowired
    OrdDao ordDao;
    @Autowired
    CartDao cartDao;


    /*cartDao의 정보를 가져와 출력한다*/
    @GetMapping("/order")
    public String read(String od_id,String c_id, Model m){
        try {
            /*List<OrdDto> list = ordDao.selectOdId(od_id);*/

            /*장바구니 select를 가져옴*/
            List<CartDto> list = cartDao.selectUser(c_id);

            /*System.out.println("[controller]ordDto = " + ordDto);*/
            m.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "order";
    }
}
