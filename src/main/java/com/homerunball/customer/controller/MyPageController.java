package com.homerunball.customer.controller;


import com.homerunball.customer.dao.CustDao;
import com.homerunball.customer.domain.CustDto;
import com.homerunball.customer.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
    @Autowired
    CustDao custDao;

    @Autowired
    CustService custService;

    @GetMapping("/add")
    public String myPage(HttpServletRequest request) {

        HttpSession session = request.getSession();

        if (!loginCheck(request)) {
            return "redirect:/login?toURL=" + request.getRequestURI();
        }

        CustDto custDto = null;
        Integer custId = (Integer) session.getAttribute("c_id");
        if (custId != null) {
        custDto = custDao.selectID(custId);
        }
//
//        HttpSession session = request.getSession();
//        String c_email = (String) session.getAttribute("c_email");
//        CustDto custDto = custDao.selectEmail(c_email);

        if (custDto != null) {
            session.setAttribute("c_email", custDto.getC_email());
            session.setAttribute("c_name", custDto.getC_name());
            session.setAttribute("c_zip", custDto.getC_zip());
            session.setAttribute("c_road_a", custDto.getC_road_a());
            session.setAttribute("c_jibun_a", custDto.getC_jibun_a());
            session.setAttribute("c_det_a", custDto.getC_det_a());
            session.setAttribute("c_ext_a", custDto.getC_ext_a());
            session.setAttribute("c_phn", custDto.getC_phn());
            session.setAttribute("c_gnd", custDto.getC_gnd());
            session.setAttribute("c_birth", custDto.getC_birth());
            session.setAttribute("sms_agr", custDto.getSms_agr());
            session.setAttribute("email_agr", custDto.getEmail_agr());
//            session.setAttribute("c_birth", custDto.getC_birth());
//            session.setAttribute("c_birth", custDto.getC_birth());
            session.setAttribute("reg_date", custDto.getReg_date());
            session.setAttribute("c_grd_cd", custDto.getC_grd_cd());
            session.setAttribute("login_dt", custDto.getLogin_dt());
        }

        return "myPage";
    }

    @GetMapping("/info")
    public String myPageInfo(HttpServletRequest request) {

        if (!loginCheck(request)) {
            return "redirect:/login?toURL=" + request.getRequestURI();
        }

//        HttpSession session = request.getSession();
//        String c_email = (String) session.getAttribute("c_email");
//


//        HttpSession session = request.getSession();
//        String c_id = (String) session.getAttribute("c_id");


        return "myPageInfo";
    }

    @GetMapping(value = "pay")
    public String myPayInfo() {
        return "payList";
    }

    private boolean loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("c_id") != null;
    }

}