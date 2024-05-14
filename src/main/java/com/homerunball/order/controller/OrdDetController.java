package com.homerunball.order.controller;

import com.homerunball.cart.dao.CartDao;
import com.homerunball.cart.domain.CartDto;
import com.homerunball.order.dao.OrderDetDao;
import com.homerunball.order.domain.OrderDetDto;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class OrdDetController {
    @Autowired
    OrderDetDao orderdetDao;
    @Autowired
    CartDao cartDao;
    @GetMapping("/orderDetail")
    public String orderDetail(Model m, HttpSession session, HttpServletRequest request) {
        if(!loginCheck(request))
            return "redirect:/login?toURL="+request.getRequestURI();
        int c_id = (int)session.getAttribute("c_id");
        try {

            List<CartDto> list = cartDao.selectUser(c_id);
            System.out.println("list=" + list);
            m.addAttribute("list",list);
            OrderDetDto ord_det = new OrderDetDto(c_id);
            orderdetDao.insert(ord_det);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "orderList";
    }
    private boolean loginCheck(HttpServletRequest request){
        HttpSession session = request.getSession();
        return session.getAttribute("c_id") != null;
    }
}
