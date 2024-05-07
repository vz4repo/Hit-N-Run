package com.homerunball.order.controller;

import com.homerunball.cart.dao.CartDao;
import com.homerunball.cart.domain.CartDto;
import com.homerunball.order.dao.OrdDao;
import com.homerunball.order.domain.OrdDto;
import com.homerunball.order.service.OrdService;
import freemarker.ext.beans.StringModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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



    @PostMapping("/order")
    public String order(Model m, HttpSession session, HttpServletRequest request){
        if(!loginCheck(request))
            return "redirect:/login?toURL="+request.getRequestURI();
        String c_id = (String)session.getAttribute("c_id");
        try {

            List<CartDto> list = cartDao.selectUser(c_id);
            m.addAttribute("list",list);
            OrdDto dto = new OrdDto(c_id);
            ordDao.insert(dto);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "order";
    }

    private boolean loginCheck(HttpServletRequest request){
        HttpSession session = request.getSession();
        return session.getAttribute("c_id") != null;
    }
}
