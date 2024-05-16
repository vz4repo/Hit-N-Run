<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/header.css'/>" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" />
    <title>Home-Run</title>
</head>
<body>
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
</body>
</html>