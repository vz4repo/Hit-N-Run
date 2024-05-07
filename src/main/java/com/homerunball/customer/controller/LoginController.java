package com.homerunball.customer.controller;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.homerunball.customer.dao.CustDao;
import com.homerunball.customer.domain.CustDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("/login")
public class LoginController {
    @Autowired
    CustDao custDao;

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    //    로그인체크를 c_id로 바꾸면 404에러
    @PostMapping("/login")
    public String login(String c_email, String c_pwd, String toURL, String rememberEmail, HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes Successful) throws Exception {
        if (!loginCheck(c_email, c_pwd, request)) {
//        if(!loginCheck(c_id, c_pwd)) {


            Successful.addFlashAttribute("loginTry", "loginFail");
            return "redirect:/login";
        }
//        HttpSession session = request.getSession();
//        session.setAttribute("c_email", c_email);

//        HttpSession session = request.getSession();
//        session.setAttribute("c_id", c_id);

        if (rememberEmail != null) {
            Cookie idcookie = new Cookie("c_email", c_email);
            idcookie.setMaxAge(3600);
            response.addCookie(idcookie);
        } else {

            Cookie idcookie = new Cookie("c_email", "");
            idcookie.setMaxAge(0);
            response.addCookie(idcookie);

        }

        toURL = toURL == null || toURL.equals("") ? "/" : toURL;
        return "redirect:" + toURL;
    }


    private boolean loginCheck(String c_email, String c_pwd, HttpServletRequest request) {

        CustDto custDto = null;

        try {
            custDto = custDao.selectEmail(c_email);
            if (!(custDto.getC_pwd().equals(c_pwd))) {
                return false;
            }
            custDao.updateLoginDate(c_email);
            HttpSession session = request.getSession();
            session.setAttribute("c_id", custDto.getC_id());
            System.out.println("custDto = " + custDto);
            System.out.println("custDto.getC_id() = " + custDto.getC_id());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
//        return custDto != null && custDto.getC_pwd().equals(c_pwd);
    }
}

//    private boolean loginCheck(int c_id, String c_pwd) {
//        CustDto custDto = null;
//
//        try {
//            custDto = custDao.selectID(c_id);
////            custDao.updateLoginDate(c_id);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//
//        return custDto!=null && custDto.getC_pwd().equals(c_pwd);
//    }
//}