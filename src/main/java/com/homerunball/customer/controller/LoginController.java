package com.homerunball.customer.controller;


import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.homerunball.customer.dao.CustDao;
import com.homerunball.customer.domain.CustDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*컨트롤러 선언*/
@Controller
public class LoginController {
    /*CustDto 주입*/
    @Autowired
    CustDao custDao;

    /*겟맵핑으로 로그인폼 이동*/
    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    /*겟맵핑 로그아웃시 세션 삭제*/
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String c_email, String c_pwd, String rememberEmail, HttpServletRequest request, HttpServletResponse response, RedirectAttributes msg) throws Exception {
        if (!validateLogin(c_email, c_pwd, request)) {
            /*RedirectAttributes의 속성 addFlashAttribute를 통해 로그인 실패시 출력할 수 있는 변수와 공간을 저장*/
            msg.addFlashAttribute("loginFail", "msg");
            return "redirect:/login";
        }

         /*성공한 경우 세션에서 이전 URL을 가져옴*/
        HttpSession session = request.getSession();
        String toURL = (String) session.getAttribute("toURL");

        /*이전 URL이 있으면 해당 페이지로 리다이렉트, 없으면 인덱스*/
        toURL = (toURL != null && !toURL.isEmpty()) ? toURL : "/";

         /*로그인 후에는 이전 URL을 세션에서 삭제합니다.*/
        session.removeAttribute("toURL");

        if (rememberEmail != null) {
            /*리멤버이메일 체크박스를 클릭시 c_email 쿠기 생성*/
            Cookie idcookie = new Cookie("c_email", c_email);
            idcookie.setMaxAge(3600);
            response.addCookie(idcookie);
        } else {
            Cookie idcookie = new Cookie("c_email", "");
            idcookie.setMaxAge(0);
            response.addCookie(idcookie);
        }

        return "redirect:" + toURL;
    }



    /*서비스로 빼도*/
    private boolean validateLogin(String c_email, String c_pwd, HttpServletRequest request) {

        try {
            /*db에 있는 이메일을 Dto에 대입*/
            CustDto custDto = custDao.selectEmail(c_email);
            /*dto가 가져온 비밀번호와 내가 입력한 비밀번호와 같지 않다면 로그인 실패*/

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (!encoder.matches(c_pwd, custDto.getC_pwd())) {
                return false;
            }

            /*로그인 성공시 updateLoginDate 메서드 실행*/
            custDao.updateLoginDt(c_email);
            /*새로운 세션 생성*/
            HttpSession session = request.getSession();
            /*session 변수에 DB에 있는 c_id(custDto.getC_id())를 c_id 이름으로 저장*/
            session.setAttribute("c_id", custDto.getC_id());
            /*예외 발생시 로그인 실패*/
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        /*예외 없으면 로그인 성공*/
        return true;
    }
}