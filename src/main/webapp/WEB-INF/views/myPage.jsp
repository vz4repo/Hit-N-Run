<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet" />
    <link rel="icon" type="image/x-icon" href="/img/icon_logo.png">
    <link href="<c:url value='/css/reset.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/search.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

    <title>My Page</title>

    <style>
        .myPageH {
            border-bottom: 1px solid #ccc;
            width: 800px;
            font-size: 14px;
            margin: auto;
            margin-top: 40px;
            margin-bottom: 60px;
            text-align: center;
            color: dimgray;
            font-weight: bold;
        }

        .sp {
            font-size: 16px;
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

        .ma {
            margin-bottom: 10px;
        }

        .ma2 {
            font-size: 11px;
        }

        #oneMonth {
            font-size: 12px;
            display: flex;
            justify-content: center;
            font-weight: bold;
        }

        #oneMonth2 {
            font-size: 12px;
            display: flex;
            justify-content: center;
            font-weight: bold;
        }

        #oneMonth3 {
            font-size: 12px;
            display: flex;
            justify-content: center;
            font-weight: bold;
        }

        #tong {
            margin-top: 50px;
        }
    </style>

</head>

<body>
<jsp:include page="header.jsp"/>
<jsp:include page="myPageHeader.jsp"/>

    <p class="myPageH">주문 내역<br><br><br></p>
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

        <p class="myPageH">리뷰 내역<br><br><br></p>

        <p id="oneMonth2">나의 리뷰처리 현황 (최근 1개월 기준)</p>

        <div class="one">
            <div class="sp">
                <span class="ma">일반 리뷰</span>
                <span class="ma2">0</span>
            </div>
            <div class="sp">
                <span class="ma">사진 리뷰</span>
                <span class="ma2">0</span>
            </div>

            <div class="sp">
            <span class="ma">작성 가능한 리뷰</span>
            <span class="ma2">0</span>
        </div>
            <div class="sp">
                <span class="ma">승인 대기</span>
                <span class="ma2">0</span>
            </div>
            <div class="sp">
                <span class="ma">승인 완료</span>
                <span class="ma2">0</span>
            </div>
        </div>

        <p class="myPageH">문의 내역<br><br><br></p>

        <p id="oneMonth3">나의 문의처리 현황 (최근 1개월 기준)</p>

        <div class="one">

            <div class="sp">
                <span class="ma">1:1 문의</span>
                <span class="ma2">0</span>
            </div>

            <div class="sp">
                <span class="ma">상품 문의</span>
                <span class="ma2">0</span>
            </div>
            <div class="sp">
                <span class="ma">SNS 문의</span>
                <span class="ma2">0</span>
            </div>
            <div class="sp">
                <span class="ma">문의 답변</span>
                <span class="ma2">0</span>
            </div>
        </div><br><br>


    </div>
</div>
<jsp:include page="footer.jsp" flush="false" />

<script>
    function test(){
        alert("테스트중입니다")
    }
</script>

</body>

