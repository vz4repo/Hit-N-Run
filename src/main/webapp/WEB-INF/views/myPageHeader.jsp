<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet" />

    <title>My Page</title>

    <style>
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

        .ma2 {
            font-size: 10px;
            color: black;
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
        }

        #title2{
            cursor: pointer;
            text-decoration: none;
            color: dimgray;
            font-size: 13px;
        }

    </style>

</head>

<body>
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
</div>

<script>


    function test(){
        alert("테스트중입니다!")
    }
</script>

</body>

