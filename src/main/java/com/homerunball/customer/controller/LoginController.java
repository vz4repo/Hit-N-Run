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

    /*겟맵핑 login의 포스트맵핑*/
    @PostMapping("/login")
    public String login(String c_email, String c_pwd, String toURL, String rememberEmail, HttpServletRequest request, HttpServletResponse response, RedirectAttributes msg) throws Exception {
        if (!validateLogin(c_email, c_pwd, request)) {

            /*RedirectAttributes의 속성 addFlashAttribute를 통해 로그인 실패시 출력할 수 있는 변수와 공간을 저장*/
            msg.addFlashAttribute("loginFail", "msg");
            return "redirect:/login";
        }

        /*리멤버이메일 체크박스를 클릭시 c_email 쿠기 생성*/
        if (rememberEmail != null) {
            Cookie idcookie = new Cookie("c_email", c_email);
            /*이 쿠기는 1시간동안 유지됨*/
            idcookie.setMaxAge(3600);
            /*이 쿠키를 http 브라우저에 저장*/
            response.addCookie(idcookie);
        } else {

           /* 체크박스 클릭안할시 쿠기 없음*/
            Cookie idcookie = new Cookie("c_email", "");
            idcookie.setMaxAge(0);
            response.addCookie(idcookie);

        }

        /*toURL이 null이거나 공백일때 인덱스로 반환하고 그거 아니라면 toURL로 반환*/
        toURL = toURL == null || toURL.equals("") ? "/" : toURL;
        /*toURL로 리다이렉트*/
         return "redirect:" + toURL;
    }


    private boolean validateLogin(String c_email, String c_pwd, HttpServletRequest request) {

        try {
            /*db에 있는 이메일을 Dto에 대입*/
            CustDto custDto = custDao.selectEmail(c_email);
            /*dto가 가져온 비밀번호와 내가 입력한 비밀번호와 같지 않다면 로그인 실패*/

           BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (!encoder.matches(c_pwd, custDto.getC_pwd())) {
                return false;
            }

//            if (!(custDto.getC_pwd().equals(c_pwd))) { return false; }

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