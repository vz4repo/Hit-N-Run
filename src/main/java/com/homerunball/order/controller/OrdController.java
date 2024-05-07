package com.homerunball.order.controller;

import com.homerunball.cart.dao.CartDao;
import com.homerunball.cart.domain.CartDto;
import com.homerunball.order.dao.OrdDao;
import com.homerunball.order.domain.OrdDto;
import com.homerunball.order.service.OrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
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
//    @Autowired
//    OrdDto ordDto;

//    @GetMapping("/orderDetail")
//    public String orderDetail(String od_id,String c_id, Model m){
//        try {
//            /*List<OrdDto> list = ordDao.selectOdId(od_id);
//            System.out.println(list);*/
//            //장바구니 select를 가져옴
//            List<CartDto> list = cartDao.selectUser(c_id);
//
//            /*System.out.println("[controller]ordDto = " + ordDto);*/
//            m.addAttribute("list",list);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "orderList";
//    }

    @PostMapping ("/order")
    public String order(String c_id, Model m, HttpSession session, HttpServletRequest request){
        if(!loginCheck(request))
            return "redirect:/login?toURL="+request.getRequestURI();
        System.out.println("get:"+c_id);
        try {
            List<CartDto> list = cartDao.selectUser(c_id);
            System.out.println("list=" + list);


            OrdDto ordDto = new OrdDto(c_id);
            ordDao.insert(ordDto);



            // 장바구니 정보를 모델에 추가
            m.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "order";
    }

    /*@PostMapping("/order")
    public String order(String c_id, Model m, HttpServletRequest request){

        System.out.println("post:"+c_id);
        try {
            OrdDto ordDto = new OrdDto(c_id);

            ordDao.insert(ordDto);

            System.out.println("====" + ordDto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "order";
    }*/



    private boolean loginCheck(HttpServletRequest request){
        HttpSession session = request.getSession();
        return session.getAttribute("c_email") != null;
    }
}