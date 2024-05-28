<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <title>My Page</title>

    <style>
        body {
            font-family: "IBM Plex Sans KR", sans-serif;
        }

        #myPage {
            margin: auto;
            width: 900px;
        }
        .none {
            text-decoration: none;
            cursor: pointer;
            font-size: 12px;
            text-align: center;
            color: dimgray;
            font-weight: bold;
        }

        .myPageH {
            border-bottom: 1px solid #ccc;
            font-size: 13px;
            margin-top: 40px;
            margin-bottom: 60px;
            text-align: center;
            color: dimgray;
            font-weight: bold;
        }

        .sp {
            font-size: 15px;
            margin: 40px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .one {
            display: flex;
            justify-content: center;
            margin-top: -15px
        }

        .one1 {
            margin-top: -15px;
            display: flex;
            justify-content: center;
        }

        .ma {
            margin-bottom: 11px;
        }

        .ma2 {
            font-size: 10px;
        }

        #oneMonth {
            font-size: 11px;
            display: flex;
            justify-content: center;
            font-weight: bold;
        }

        #tong {
            margin-top: 50px;
        }

        .date {
            font-size: 12px;
            margin-bottom: 10px;
            color: gray;
        }

        #title1 {
            /*font-size: 13px;*/
            text-align: center;
            /*color: dimgray;*/
            font-weight: bold;
            /*cursor: pointer;*/
            /*text-decoration: none;*/
            /*color: dimgray;*/
            /*color: #000;*/
        }

        #title2{
            cursor: pointer;
            text-decoration: none;
            color: dimgray;
            font-size: 13px;
        }

    </style>

    <link href="<c:url value='/css/reset.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/search.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>

</head>

<body>
<jsp:include page="header.jsp"/>
<div id="myPage">
    <p id="title1"><a id="title2" href="/mypage/list"><%=session.getAttribute("c_name")%>님의 MY PAGE</a></p>
    <div class="one1">
        <div class="sp">
            <span class="date">등급</span>
            <span class="ma2">
                    <%=session.getAttribute("grd_name")%>
                </span>
        </div>
        <div class="sp">
            <span class="date">누적 금액</span>
            <span class="ma2">
                    <%=session.getAttribute("tot_amt")%>원
                </span>
        </div>
        <div class="sp">
            <span class="date">찜</span>
            <span class="ma2">0개</span>
        </div>
        <div class="sp">
            <span class="date">쿠폰</span>
            <span class="ma2">0개</span>
        </div>
        <div class="sp">
            <span class="date">적립금</span>
            <span class="ma2">0원</span>
        </div>
    </div>

    <div class="one">
        <div class="sp">
            <span><a class="none" href="/orderDetail">Order List</a></span>
        </div>
        <div class="sp">
            <span><a class="none" onclick="test()">Wish List</a></span>
        </div>
        <div class="sp">
            <span><a class="none" onclick="test()">Recently Viewed</a></span>
        </div>
        <div class="sp">
            <span><a class="none" onclick="test()">Address</a></span>
        </div>
        <div class="sp">
            <span><a class="none" href="/mypage/info">Edit Proflie</a></span>
        </div>
        <div class="sp">
            <span><a class="none" href="/mypage/pwdEdit">Change Pwd</a></span>
        </div>
    </div>

    <p class="myPageH">ACCOUNT<br><br><br></p>
    <div id="tong">
        <p id="oneMonth">나의 주문처리 현황 (최근 1개월 기준)</p>

        <div class="one">
            <div class="sp">
                <span class="ma">입금전</span>
                <span class="ma2">0</span>
            </div>
            <div class="sp">
                <span class="ma">결제 완료</span>
                <span class="ma2">0</span>
            </div>
            <div class="sp">
                <span class="ma">배송 준비중</span>
                <span class="ma2">0</span>
            </div>

            <div class="sp">
                <span class="ma">배송중</span>
                <span class="ma2">0</span>
            </div>
            <div class="sp">
                <span class="ma">배송완료</span>
                <span class="ma2">0</span>
            </div>
        </div>
    </div><br><br>

</div>
<jsp:include page="footer.jsp" flush="false" />

<script>


    function test(){
        alert("테스트중입니다")
    }
</script>

</body>

