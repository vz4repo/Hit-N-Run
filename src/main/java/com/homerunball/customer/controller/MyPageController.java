package com.homerunball.customer.controller;


import com.homerunball.customer.dao.CustDao;
import com.homerunball.customer.domain.CustDto;
import com.homerunball.customer.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
    @Autowired
    CustDao custDao;

    @Autowired
    CustService custService;

    @GetMapping("/list")
    /*세션 속성에 저장되어있는 c_id를 가져와서 c_id 변수로 지정함*/
    public String myPage(@SessionAttribute("c_id") int c_id, HttpServletRequest request) {

        HttpSession session = request.getSession();

        if (!loginCheck(request)) {
            return "redirect:/login?toURL=" + request.getRequestURI();
        }

        CustDto custDto = custDao.grdNameJoin(c_id);

//        CustDto custDto = custDao.grdNameJoin(Integer.parseInt((String) session.getAttribute("c_id")));

        if(custDto != null){
            session.setAttribute("c_name", custDto.getC_name());
            session.setAttribute("grd_name", custDto.getGrd_name());
            session.setAttribute("tot_amt", custDto.getTot_amt());
            session.setAttribute("reg_dt", custDto.getReg_dt());
            session.setAttribute("login_dt", custDto.getLogin_dt());
        }

        return "myPage";
    }

    @GetMapping("/info")
    public String myPageInfo(@SessionAttribute("c_id") int c_id, HttpServletRequest request) {
        HttpSession session = request.getSession();

        CustDto custDto = custDao.selectID(c_id);


        if (custDto != null) {
            session.setAttribute("c_email", custDto.getC_email());
            session.setAttribute("c_pwd", custDto.getC_pwd());
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
        }
        return "myPageInfo";
    }
//
    @PostMapping("/info")
    public String modify(@SessionAttribute("c_id") int c_id, String c_pwd, String c_zip, String c_road_a, String c_jibun_a, String c_det_a, String c_ext_a, String c_phn, String sms_agr, String email_agr) {
       CustDto custDto = custDao.selectID(c_id);

        custDto.setC_pwd(c_pwd);
        custDto.setC_zip(c_zip);
        custDto.setC_road_a(c_road_a);
        custDto.setC_jibun_a(c_jibun_a);
        custDto.setC_det_a(c_det_a);
        custDto.setC_ext_a(c_ext_a);
        custDto.setC_phn(c_phn);
        custDto.setSms_agr(sms_agr);
        custDto.setEmail_agr(email_agr);
        custDao.updateAll(custDto);

        System.out.println("업데이트 정보 = " + custDto);

       return "redirect:/mypage/list";
    }



//    @PostMapping("/info")
//    public String modify(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        CustDto custDto = custDao.selectID(Integer.parseInt((String) session.getAttribute("c_id")));
//        custDao.updateAll(custDto);
//        return "redirect:/mypage/list";
//    }

    private boolean loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("c_id") != null;
    }

}