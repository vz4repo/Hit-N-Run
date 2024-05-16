//package com.homerunball.customer;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//
//@WebFilter(urlPatterns="/*")
//public class loginFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    /*필터 대신 핸들러 인터셉터 알아보기 (로그인 체크 사용안해도됨)*/
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//       /*  1. 전처리 작업*/
//        long startTime = System.currentTimeMillis();
//
//        /* 2. 서블릿 또는 다음 필터를 호출*/
//        chain.doFilter(request, response);
//
//        /* 3. 후처리 작업*/
//        HttpServletRequest req = (HttpServletRequest)request;
//        String referer = req.getHeader("referer");
//        String method = req.getMethod();
//        System.out.print("["+referer+"] -> " + method + "["+req.getRequestURI()+"]");
//        System.out.println(" 소요시간="+(System.currentTimeMillis()-startTime)+"ms");
//    }
//
//    @Override
//    public void destroy() {
//    }
//
//}