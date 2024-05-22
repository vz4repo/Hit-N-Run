package com.homerunball.order.controller;

import com.homerunball.cart.dao.CartDao;
import com.homerunball.cart.domain.CartDto;
import com.homerunball.order.dao.OrderDetDao;
import com.homerunball.order.domain.OrderDetDto;

import com.homerunball.order.service.OrderDetService;
import com.homerunball.payment.domain.PaymentDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class OrdDetController {
    @Autowired
    OrderDetService orderDetService;
    @Autowired
    OrderDetDao orderdetDao;
    @Autowired
    CartDao cartDao;

    @GetMapping("/orderDetail")
    public String orderDetail(Model m, HttpSession session, HttpServletRequest request) {
        /*세션에서 c_id를 가져옴*/
        Integer cIdObject = (Integer) session.getAttribute("c_id");
         /*c_id가 null이 아니면 값을 사용하고, null이면 기본값 -1을 사용*/
        int c_id = (cIdObject != null) ? cIdObject : -1;

        try {
            List<OrderDetDto> list = orderdetDao.select(c_id);
            List<CartDto> imglist = cartDao.getStk(c_id);


            // CartDto를 map에 넣어 줌
            Map<String, CartDto> imgMap = new HashMap<>();
            for (CartDto img : imglist) {
                imgMap.put(img.getPd_id(), img);
            }

            // map에 넣어준걸 다시  orderdetDto에 넣어 줌
            for (OrderDetDto order : list) {
                CartDto matchedCart = imgMap.get(order.getPd_id());
                if (matchedCart != null) {
                    order.setCartDto(matchedCart);
                }
            }

            System.out.println("aaa" + list);

            m.addAttribute("list", list);



          /*  List<OrderDetDto> list = orderdetDao.select(c_id);
            List<CartDto> Imglist =cartDao.getStk(c_id);
//            List<CartDto> list = cartDao.selectUser(c_id);
            System.out.println("aaa=" + list);

            m.addAttribute("list",list);
            m.addAttribute("Imglist",Imglist);*/

         /*   System.out.println();
            System.out.println("bbb" + Imglist);*/
            /*OrderDetDto ord_det = new OrderDetDto(c_id);
            orderdetDao.insert(ord_det);*/

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "orderdetail";
    }

    /* 날짜 범위에 따른 주문내역 조회 */
    @GetMapping(value = "/order/list")
    @ResponseBody
    public List<OrderDetDto> getOrderList( @SessionAttribute(name = "c_id") int c_id
        , @RequestParam("fromDate") String fromDate
        , @RequestParam("toDate") String toDate) {
        return orderDetService.selectOrderHistoryWithDateRange(c_id, fromDate, toDate);
    }
}
