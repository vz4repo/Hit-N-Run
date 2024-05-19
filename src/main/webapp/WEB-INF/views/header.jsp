<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="loginOutLink" value="${sessionScope.c_id==null ? '/login' : '/logout'}"/>
<c:set var="loginOut" value="${sessionScope.c_id==null ? '로그인' : '로그아웃'}"/>

<header>
    <div class="top_header">
        <ul class="top_header_ul">
            <a href="#"><li>고객센터</li></a>
            <a href="#"><li>관심</li></a>
            <a href="#"><li>알림</li></a>
            <a id="logoutLink" href="<c:url value='${loginOutLink}'/>"><li>${loginOut}</li></a>
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
        <jsp:include page="nav.jsp"/>
    </div>
</header>
