package com.homerunball.customer.controller;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class CustInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("c_id") == null) {
            response.sendRedirect("/login?toURL=" + request.getRequestURI());
            return false;   // 컨트롤러 핸들러로 요청 전달하지 않음
        }
        return true;      // 컨트롤러 핸들러로 요청 전달
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 요청 처리 후 수행
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        // 요청 처리 완료 후  수행
    }

}



