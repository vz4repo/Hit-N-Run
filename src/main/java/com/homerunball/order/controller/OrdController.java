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
    public String order(Integer rtl_prc, Model m, HttpSession session, HttpServletRequest request){
        if(!loginCheck(request))
            return "redirect:/login?toURL="+request.getRequestURI();
        int c_id = (int)session.getAttribute("c_id");
        try {
            List<CartDto> list = cartDao.selectUser(c_id);
            List<OrdAndStkDto> stkList = orderAndStkDao.getcartItem(c_id);


            System.out.println("list = " +list);
            System.out.println("stkList=" + stkList);


            System.out.println(rtl_prc);

            OrderDetDto ord_det = new OrderDetDto();
            /*list*/
            for (CartDto cart : list){
                ord_det.setPd_id(cart.getPd_id());
                ord_det.setPd_clsf_cd(cart.getPd_clsf_code());
            }
            for (OrdAndStkDto stk : stkList) {

                ord_det.setPd_name(stk.getPd_name()); // 상품 이름
                ord_det.setSls_prc(stk.getSls_prc()); // 상품 갸격
                ord_det.setOd_qty(stk.getCart_cnt()); // 주문 수량
                ord_det.setC_id(stk.getC_id()); // 주문한 사용자의 ID

              orderdetDao.insert(ord_det);
            }


            OrdDto ord = new OrdDto();
                ord.setC_id(ord_det.getC_id());
                ord.setRtl_prc(rtl_prc);
                ord.setRtl_prc(1);
                ord.setOd_pd_qty(10);
                ord.setOd_tot_qty(20);
                ord.setOd_pay_amt(50000);

                ordDao.insert(ord);

            System.out.println("ord_det.getC_id()" +ord_det.getC_id());
            System.out.println("rtl_prc" +rtl_prc);
            System.out.println(ord);

            m.addAttribute("list", list);
            m.addAttribute("stkList", stkList);



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
