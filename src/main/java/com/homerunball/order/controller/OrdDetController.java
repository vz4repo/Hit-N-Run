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

  /* 주문 상세 페이지 */
  @GetMapping("/orderDetail")
  public String orderDetail(Model m, HttpSession session, HttpServletRequest request) {
    try {
      int c_id = (int) session.getAttribute("c_id");
      List<OrderDetDto> list = orderdetDao.select(c_id);
      m.addAttribute("list", list);
    } catch (Exception e) {
      e.printStackTrace();
      m.addAttribute("errorMessage", "[주문 상세 정보]");
      return "errorPageCust"; // 에러 페이지로 이동
    }
    return "orderdetail";
  }

  /* 날짜 범위에 따른 주문내역 조회 */
  @GetMapping(value = "/order/list")
  @ResponseBody
  public List<OrderDetDto> getOrderList(@SessionAttribute(name = "c_id") int c_id
      , @RequestParam("fromDate") String fromDate
      , @RequestParam("toDate") String toDate) {
    return orderDetService.selectOrderHistoryWithDateRange(c_id, fromDate, toDate);
  }
}
