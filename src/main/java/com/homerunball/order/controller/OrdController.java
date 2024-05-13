package com.homerunball.order.controller;

import com.homerunball.cart.dao.CartDao;
import com.homerunball.cart.domain.CartDto;
import com.homerunball.order.dao.OrdDao;
import com.homerunball.order.dao.OrderAndStkDao;
import com.homerunball.order.dao.OrderDetDao;
import com.homerunball.order.domain.OrdAndStkDto;
import com.homerunball.order.domain.OrdDto;
import com.homerunball.order.domain.OrderDetDto;
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
    @Autowired
    OrderDetDao orderdetDao;
    @Autowired
    OrderAndStkDao orderAndStkDao;


    @PostMapping("/order")
    public String order(Model m, HttpSession session, HttpServletRequest request){
        if(!loginCheck(request))
            return "redirect:/login?toURL="+request.getRequestURI();
        int c_id = (int)session.getAttribute("c_id");
        try {
            List<CartDto> list = cartDao.selectUser(c_id);
            List<OrdAndStkDto> stkList = orderAndStkDao.getcartItem(c_id);

            System.out.println("stkList=" + stkList);

            m.addAttribute("list", list);
            m.addAttribute("stkList", stkList);



            OrderDetDto ord_det = new OrderDetDto(c_id);
//            ord_det.setC_id(c_id);


            for (OrdAndStkDto item : stkList) {
//                OrderDetDto ord_det = new OrderDetDto();
                ord_det.setPd_name(item.getPd_name()); // 상품 이름
                ord_det.setSlg_prc(item.getSls_prc()); // 상품 갸격
//                ord_det.setCart_cnt(item.getCart_cnt()); // 주문 수량
                ord_det.setC_id(item.getC_id()); // 주문한 사용자의 ID

//                orderdetDao.insert(ord_det); // 생성된 OrderDetDto 객체를 데이터베이스에 삽입
            }

            orderdetDao.insert(ord_det);

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
