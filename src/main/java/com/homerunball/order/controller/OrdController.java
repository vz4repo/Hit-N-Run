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
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    public String order(OrderDetDto orderDetDto, OrdDto ordDto, Model m, HttpSession session, HttpServletRequest request){
        if(!loginCheck(request))
            return "redirect:/login?toURL="+request.getRequestURI();
        int c_id = (int)session.getAttribute("c_id");
        try {
//            List<CartDto> list = cartDao.selectUser(c_id);
            List<CartDto> list =cartDao.getStk(c_id);
           /* List<OrdAndStkDto> stkList = orderAndStkDao.getcartItem(c_id);*/

            System.out.println("list = " +list);

//            OrderDetDto ord_det = new OrderDetDto();
//            OrdDto ord = new OrdDto();

            System.out.println(orderDetDto);

            System.out.println("od_stat_cd=" + orderDetDto.getOd_stat_cd());



            /*장바구니에서 data 가져와서 order_det 테이블에 insert */
            for (CartDto cart : list){
                orderDetDto.setPd_id(cart.getPd_id());
                orderDetDto.setPd_clsf_cd(cart.getPd_clsf_code());
                orderDetDto.setPd_name(cart.getPd_name());
                orderDetDto.setSls_prc(cart.getSls_prc());
                orderDetDto.setOd_qty(cart.getCart_cnt());
                orderDetDto.setC_id(cart.getC_id());

                orderdetDao.insert(orderDetDto);
            }
            System.out.println("od_stat_cd" + orderDetDto.getOd_stat_cd());

            int totalpd_qty = 0;
            int totalqty = 0;
            int totalamount = 0;
            int totalrtlamount = 0;

            /*중복 안돼는 set을 만든다*/
            Set<String> od_pd_qtyid = new HashSet<>(); 

            for (CartDto cart : list) {
                /*제품 가지 수*/
                od_pd_qtyid.add(cart.getPd_id());     /*set에 상품 id를 넣어서 for문 돌려줌*/

                /*주문 총 수량 구하기*/
                totalqty += cart.getCart_cnt();

                /*주문 총 금액 구하기*/
                int itemtotal = cart.getSls_prc() * cart.getCart_cnt();
                totalamount += itemtotal;

                /*주문 총 소비자가 구하기*/
                totalrtlamount += cart.getRtl_prc();
            }

            /*상품 id를 담은 set(od_pd_qtyid)의 사이즈를 담아줌*/
            totalpd_qty = od_pd_qtyid.size();


            ordDto.setC_id(orderDetDto.getC_id());
            ordDto.setOd_pd_qty(totalpd_qty);
            ordDto.setOd_tot_qty(totalqty);
            ordDto.setOd_pay_amt(totalamount);
            ordDto.setRtl_prc(totalrtlamount);

            ordDao.insert(ordDto);

            System.out.println("ord_det.getC_id()" +orderDetDto.getC_id());
            System.out.println(list+"===========================");

            m.addAttribute("list", list);
            /*m.addAttribute("stkList", stkList);*/

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
