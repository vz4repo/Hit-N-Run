<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <div class="top_header">
        <ul class="top_header_ul">
            <a href="#"><li>고객센터</li></a>
            <a href="#"><li>관심</li></a>
            <a href="#"><li>알림</li></a>
            <a href="/login"><li>로그인</li></a>
        </ul>
    </div>
    <div class="main_header">
        <a href="/"><h1>HOME RUN</h1></a>
        <div>
            <ul class="main_header_ul">
                <a href="/"><li>HOME</li></a>
                <a href="#"><li><i class="fa fa-search fa-lg"></i></li></a> <%--검색--%>
                <a href="/cart/list"><li><i class="fas fa-shopping-cart fa-lg"></i></li></a> <%--cart--%>
                <a href="/mypage/add"><li><i class="far fa-user fa-lg"></i></li></a> <%--mypage--%>

            </ul>
        </div>
    </div>
    <div class="bottom_header">
        <ul>
            <a href="#"><li>RECTO</li></a>
            <a href="#"><li>추천</li></a>
            <a href="#"><li>랭킹</li></a>
            <a href="#"><li>럭셔리</li></a>
            <a href="#"><li>남성</li></a>
            <a href="#"><li>여성</li></a>
            <a href="#"><li>발견</li></a>
        </ul>
    </div>
</header>
