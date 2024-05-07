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

    @PostMapping("/login")
    public String login(String c_email, String c_pwd, String toURL, String rememberEmail, HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes Successful) throws Exception {
        if(!loginCheck(c_email, c_pwd)) {

//            model.addAttribute("msg", "아이디 또는 비밀번호를 잘못 입력했습니다.");
            Successful.addFlashAttribute("loginTry", "loginFail");
            return "redirect:/login";
//            return "loginForm";

        }
        HttpSession session = request.getSession();
        session.setAttribute("c_email", c_email);

        if(rememberEmail != null) {
            Cookie idcookie = new Cookie("c_email", c_email);
            idcookie.setMaxAge(3600);
            response.addCookie(idcookie);
        }else {

            Cookie idcookie = new Cookie("c_email","");
            idcookie.setMaxAge(0);
            response.addCookie(idcookie);

        }

        toURL =  toURL==null || toURL.equals("") ? "/" : toURL;
                return "redirect:"+toURL;
//        return "/cart/list";
    }

    private boolean loginCheck(String c_email, String c_pwd) {
        CustDto custDto = null;

        try {
            custDto = custDao.selectCust(c_email);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return custDto!=null && custDto.getC_pwd().equals(c_pwd);
    }



}