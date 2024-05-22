<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="loginOutLink" value="${sessionScope.c_id==null ? '/login' : '/logout'}"/>
<c:set var="loginOut" value="${sessionScope.c_id==null ? '로그인' : '로그아웃'}"/>

<header class="cart__header">
    <div class="top_header">
        <ul class="top_header_ul">
            <a class="cart_link"  href="#"><li>고객센터</li></a>
            <a class="cart_link" href="#"><li>관심</li></a>
            <a class="cart_link" href="#"><li>알림</li></a>
            <li><a class="cart_link" id="logoutLink" href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
        </ul>
    </div>
    <div class="main_header">
<%--        <a class="cart_link" href="/"><h1>HOME RUN</h1></a>--%>
        <a href="/"><img src="/img/homerunball_logo.png" style="width:200px"></a>
        <div>
            <ul class="main_header_ul">
                <a class="cart_link" href="/"><li>HOME</li></a>
                <a class="cart_link" href="#"><li><i class="fa fa-search fa-lg"></i></li></a> <%--검색--%>
                <a class="cart_link" href="/cart/list"><li><i class="fas fa-shopping-cart fa-lg"></i></li></a> <%--cart--%>
                <a class="cart_link" href="/mypage/list"><li><i class="far fa-user fa-lg"></i></li></a> <%--mypage--%>
            </ul>
        </div>
    </div>

    <div class="bottom_header">
        <jsp:include page="nav.jsp"/>
    </div>
</header>

<script>
    window.onload = function() {
        if("${sessionScope.c_id}" !== "") {
            document.getElementById('logoutLink').addEventListener('click', function(event) {
                event.preventDefault();
                if (confirm('정말로 로그아웃을 하시겠습니까?')) {
                    window.location.href = event.target.href;
                    alert('로그아웃이 되셨습니다.');
                }
            });
        }
    };

</script>
