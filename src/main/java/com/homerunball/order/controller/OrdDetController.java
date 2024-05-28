package com.homerunball.order.controller;

import com.homerunball.cart.dao.CartDao;
import com.homerunball.cart.domain.CartDto;
import com.homerunball.order.dao.OrderDetDao;
import com.homerunball.order.domain.OrderDetDto;

import com.homerunball.order.service.OrderDetService;
import com.homerunball.payment.domain.PaymentDto;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  /* 주문 상세 페이지 */
  @GetMapping("/orderDetail")
  public String orderDetail(Model m, HttpSession session, HttpServletRequest request) {
    try {
      int c_id = (int) session.getAttribute("c_id");
      List<OrderDetDto> list = orderdetDao.select(c_id);

      /*재고테이블이랑 조인해서 삭제될것*/
//      List<CartDto> imglist = cartDao.getStk(c_id);
//// CartDto를 map에 넣어 줌
//      Map<String, CartDto> imgMap = new HashMap<>();
//      for (CartDto img : imglist) {
//        imgMap.put(img.getPd_id(), img);
//      }
//      // map에 넣어준걸 다시  orderdetDto에 넣어 줌
//      for (OrderDetDto order : list) {
//        CartDto matchedCart = imgMap.get(order.getPd_id());
//        if (matchedCart != null) {
//          order.setCartDto(matchedCart);
//        }
//      }
//      List<CartDto> Imglist =cartDao.getStk(c_id);
      m.addAttribute("list", list);
//      m.addAttribute("Imglist",Imglist);
      System.out.println("list" + list);
//      System.out.println("Imglist" + Imglist);

    } catch (Exception e) {
      e.printStackTrace();
      m.addAttribute("errorMessage", "[주문 상세 정보]");
      return "errorPageCust"; // 에러 페이지로 이동
    }
    return "orderdetail";
  }

  /* 주문취소신청하면 ord_det.ord_stat_cd='04' update */
  @PostMapping("/order/cancel")
  public String updateOrderStatus(Model model
      , BigInteger od_id
      , HttpSession session
      , String pd_id
      , String pd_clsf_cd  ) {
    /* 비로그인 고객이 배송취소를 하면 생기는 오류 */
    /* 고객번호 c_id가 세션에 있는지 확인 */
    Object c_idObj = session.getAttribute("c_id");
    if (c_idObj == null) {
      return "redirect:/";
    }
    int c_id = (Integer) c_idObj;

    OrderDetDto orderDetDto = new OrderDetDto(od_id, c_id, pd_id, pd_clsf_cd);
    try {
      /* TODO: 취소는 1건 나와야 한다*/
      orderdetDao.updateOrderStatus(orderDetDto);
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("errorMessage", "[주문 취소]");
      return "errorPageCust"; // 에러 페이지로 이동    }
    }
      return "redirect:/orderDetail";
  }

  /* 날짜 범위에 따른 주문내역 조회 */
  @GetMapping(value = "/order/list")
  @ResponseBody
  public List<OrderDetDto> getOrderList(@SessionAttribute(name = "c_id") int c_id
      , @RequestParam("fromDate") String fromDate
      , @RequestParam("toDate") String toDate) {

    System.out.printf("c_id: %d, fromDate: %s, toDate: %s", c_id, fromDate, toDate);

    return orderDetService.selectOrderHistoryWithDateRange(c_id, fromDate, toDate);
  }
}
