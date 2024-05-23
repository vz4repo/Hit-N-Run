<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet" />
    <link href="<c:url value='/css/reset.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>
    <title>My Page</title>
</head>
<style>
    * {
        font-family: "IBM Plex Sans KR", sans-serif;
        font-weight: 400;
        font-style: normal;
    }

    #myPage {
        margin: auto;
        width: 350px;
        padding: 20px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
    }

    #myPage li a {
        text-decoration: none;
        color: black;
    }

    #myPage li a:hover {
        background-color: #ddd;
    }

    #myPage p {
        font-size: 13px;
    }

    #myPage ul {
        list-style-type: none;
        padding: 0;
    }

    #myPage li {
        margin-bottom: 10px;
        cursor: pointer;
        font-size: 13px;
    }

    #myPage h5 {
        border-bottom: 1px solid #ccc;
        padding-bottom: 5px;
    }

    #myPage ul {
        display: block;
    }
</style>

<body>
<jsp:include page="header.jsp"/>
<div id="myPage">
    <p>
        <%= session.getAttribute("c_name") %>님의 MY PAGE
    </p>
    <p>
        <span style="float: left;">등급:</span>
        <span style="float: right;"><%=session.getAttribute("grd_name")%></span><br>
        <span style="float: left;">누적 금액:</span>
        <span style="float: right;"><%=session.getAttribute("tot_amt")%>원(test)</span><br>
        <span style="float: left;">가입 날짜:</span>
        <span style="float: right;"><%= session.getAttribute("reg_dt")%></span><br>
        <span style="float: left;">최근 로그인:</span>
        <span style="float: right;"><%= session.getAttribute("login_dt")%></span><br>
    </p>
    <h5>INFO</h5>
    <ul>
        <li><a href="/mypage/info">개인정보 관리</a></li>
        <li><a href="/mypage/pwdEdit">비밀번호 변경</a></li>
        <li><a href="#">배송지 관리</a></li>
        <li><a onclick="test()">회원탈퇴</a></li>
    </ul>

    <h5>ORDER</h5>
    <ul>
        <li><a href="/orderDetail">주문/배송조회</a></li>
    </ul>

    <h5>ACTIVITY</h5>

    <ul>
        <li><a onclick="test()">리뷰 내역</a></li>
        <li><a onclick="test()">1:1 문의내역</a></li>
        <li><a onclick="test()">제품 문의내역</a></li>
    </ul>
</div>
<jsp:include page="footer.jsp" flush="false" />

<script>
    let pwdClear = "${pwdClear}"
    if(pwdClear==="pwdMsg2") {
        alert("비밀번호 변경에 성공했습니다.")
    }

    function test(){
        alert("테스트중입니다!")
    }
</script>

</body>