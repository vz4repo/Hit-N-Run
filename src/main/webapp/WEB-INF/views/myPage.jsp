<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet" />

    <title>My Page</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }

        #myPage {
            margin: auto;
            width: 350px;
            padding: 20px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        }

        .none {
            text-decoration: none;
            color: black;
        }

        .custInfo {
            font-size: 15px;
            margin-top: 10px;
            margin-bottom: 10px;
        }

        .myPageUl {
            list-style-type: none;
            display: block;
            padding: 0;
        }

        .myPageLi {
            margin-bottom: 10px;
            cursor: pointer;
            font-size: 14px;
        }

        .myPageH {
            border-bottom: 1px solid #ccc;
            padding-bottom: 5px;
            font-weight: bold;
            font-size: 15px;
        }

        .sp{
            font-size: 13px;
            margin-top: 6px;
            margin-bottom: 6px;
        }

    </style>
    <link href="<c:url value='/css/reset.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>

</head>

<body>
<jsp:include page="header.jsp"/>
<div id="myPage">

    <p class="custInfo">
        <%= session.getAttribute("c_name") %>님의 MY PAGE
    </p><br>
<%--    <p class="custInfo">--%>
        <div class="sp"><span style="float: left;">등급:</span>
        <span style="float: right;">
                <%=session.getAttribute("grd_name")%>
            </span></div><br>

    <div class="sp"> <span style="float: left;">누적 금액:</span>
        <span style="float: right;">
                <%=session.getAttribute("tot_amt")%>원
            </span></div><br>
    <div class="sp"> <span style="float: left;">가입 날짜:</span>
        <span style="float: right;">
                <%= session.getAttribute("reg_dt")%>
            </span></div><br>
    <div class="sp"><span style="float: left;">최근 로그인:</span>
        <span style="float: right;">
                <%= session.getAttribute("login_dt")%>
            </span></div><br>
<%--    </p>--%>
    <br>


    <h5 class="myPageH">INFO</h5><br>
    <ul class="myPageUl">
        <li class="myPageLi"><a class="none" href="/mypage/info">개인정보 관리</a></li>
        <li class="myPageLi"><a class="none" href="/mypage/pwdEdit">비밀번호 변경</a></li>
        <li class="myPageLi"><a class="none" href="#">배송지 관리</a></li>
        <li class="myPageLi"><a class="none" onclick="test()">회원탈퇴</a></li>
    </ul><br>

    <h5 class="myPageH">ORDER</h5><br>
    <ul class="myPageUl">
        <li class="myPageLi"><a class="none" href="/orderDetail">주문/배송조회</a></li>
    </ul><br>

    <h5 class="myPageH">ACTIVITY</h5><br>

    <ul class="myPageUl">
        <li class="myPageLi"><a class="none" onclick="test()">리뷰 내역</a></li>
        <li class="myPageLi"><a class="none" onclick="test()">1:1 문의내역</a></li>
        <li class="myPageLi"><a class="none" onclick="test()">제품 문의내역</a></li>
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


<%--<body>--%>
<%--<jsp:include page="header.jsp"/>--%>

<%--<div id="myPage">--%>
<%--    <p class="custInfo">--%>
<%--        <%= session.getAttribute("c_name") %>님의 MY PAGE--%>
<%--    </p>--%>
<%--    <p class="custInfo">--%>
<%--        <span style="float: left;">등급:</span>--%>
<%--        <span style="float: right;">--%>
<%--                <%=session.getAttribute("grd_name")%>--%>
<%--            </span><br>--%>
<%--        <span style="float: left;">누적 금액:</span>--%>
<%--        <span style="float: right;">--%>
<%--                <%=session.getAttribute("tot_amt")%>원(test)--%>
<%--            </span><br>--%>
<%--        <span style="float: left;">가입 날짜:</span>--%>
<%--        <span style="float: right;">--%>
<%--                <%= session.getAttribute("reg_dt")%>--%>
<%--            </span><br>--%>
<%--        <span style="float: left;">최근 로그인:</span>--%>
<%--        <span style="float: right;">--%>
<%--                <%= session.getAttribute("login_dt")%>--%>
<%--            </span><br>--%>
<%--    </p>--%>
<%--    <h5 class="myPageH">INFO</h5>--%>
<%--    <ul class="myPageUl">--%>
<%--        <li class="myPageLi"><a class="none" href="/mypage/info">개인정보 관리</a></li>--%>
<%--        <li class="myPageLi"><a class="none" href="/mypage/pwdEdit">비밀번호 변경</a></li>--%>
<%--        <li class="myPageLi"><a class="none" href="#">배송지 관리</a></li>--%>
<%--        <li class="myPageLi"><a class="none" onclick="test()">회원탈퇴</a></li>--%>
<%--    </ul>--%>

<%--    <h5 class="myPageH">ORDER</h5>--%>
<%--    <ul class="myPageUl">--%>
<%--        <li class="myPageLi"><a class="none" href="/orderDetail">주문/배송조회</a></li>--%>
<%--    </ul>--%>

<%--    <h5 class="myPageH">ACTIVITY</h5>--%>

<%--    <ul class="myPageUl">--%>
<%--        <li class="myPageLi"><a class="none" onclick="test()">리뷰 내역</a></li>--%>
<%--        <li class="myPageLi"><a class="none" onclick="test()">1:1 문의내역</a></li>--%>
<%--        <li class="myPageLi"><a class="none" onclick="test()">제품 문의내역</a></li>--%>
<%--    </ul>--%>
<%--</div>--%>

<%--<jsp:include page="footer.jsp" flush="false" />--%>

<%--<script>--%>
<%--    let pwdClear = "${pwdClear}"--%>
<%--    if(pwdClear==="pwdMsg2") {--%>
<%--        alert("비밀번호 변경에 성공했습니다.")--%>
<%--    }--%>

<%--    function test(){--%>
<%--        alert("테스트중입니다!")--%>
<%--    }--%>
<%--</script>--%>

<%--</body>--%>

<%--<body>--%>
<%--<jsp:include page="header.jsp" />--%>
<%--<div id="myPage" style="margin: auto; width: 350px; padding: 20px; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);">--%>
<%--    <p class="custInfo">--%>
<%--        <%= session.getAttribute("c_name") %>님의 MY PAGE--%>
<%--    </p>--%>
<%--    <p class="custInfo">--%>
<%--        <span style="float: left;">등급:</span>--%>
<%--        <span style="float: right;">--%>
<%--                <%=session.getAttribute("grd_name")%>--%>
<%--            </span><br>--%>
<%--        <span style="float: left;">누적 금액:</span>--%>
<%--        <span style="float: right;">--%>
<%--                <%=session.getAttribute("tot_amt")%>원(test)--%>
<%--            </span><br>--%>
<%--        <span style="float: left;">가입 날짜:</span>--%>
<%--        <span style="float: right;">--%>
<%--                <%= session.getAttribute("reg_dt")%>--%>
<%--            </span><br>--%>
<%--        <span style="float: left;">최근 로그인:</span>--%>
<%--        <span style="float: right;">--%>
<%--                <%= session.getAttribute("login_dt")%>--%>
<%--            </span><br>--%>
<%--    </p>--%>
<%--    <h5 class="myPageH" style="border-bottom: 1px solid #ccc; padding-bottom: 5px;">INFO</h5>--%>
<%--    <ul class="myPageUl" style="list-style-type: none; display: block; padding: 0;">--%>
<%--        <li class="myPageLi" style="margin-bottom: 10px; cursor: pointer; font-size: 13px;"><a class="none"--%>
<%--                                                                                               href="/mypage/info">개인정보 관리</a></li>--%>
<%--        <li class="myPageLi" style="margin-bottom: 10px; cursor: pointer; font-size: 13px;"><a class="none"--%>
<%--                                                                                               href="/mypage/pwdEdit">비밀번호 변경</a></li>--%>
<%--        <li class="myPageLi" style="margin-bottom: 10px; cursor: pointer; font-size: 13px;"><a class="none"--%>
<%--                                                                                               href="#">배송지 관리</a></li>--%>
<%--        <li class="myPageLi" style="margin-bottom: 10px; cursor: pointer; font-size: 13px;"><a class="none"--%>
<%--                                                                                               onclick="test()">회원탈퇴</a></li>--%>
<%--    </ul>--%>

<%--    <h5 class="myPageH" style="border-bottom: 1px solid #ccc; padding-bottom: 5px;">ORDER</h5>--%>
<%--    <ul class="myPageUl" style="list-style-type: none; display: block; padding: 0;">--%>
<%--        <li class="myPageLi" style="margin-bottom: 10px; cursor: pointer; font-size: 13px;"><a class="none"--%>
<%--                                                                                               href="/orderDetail">주문/배송조회</a></li>--%>
<%--    </ul>--%>

<%--    <h5 class="myPageH" style="border-bottom: 1px solid #ccc; padding-bottom: 5px;">ACTIVITY</h5>--%>

<%--    <ul class="myPageUl" style="list-style-type: none; display: block; padding: 0;">--%>
<%--        <li class="myPageLi" style="margin-bottom: 10px; cursor: pointer; font-size: 13px;"><a class="none"--%>
<%--                                                                                               onclick="test()">리뷰 내역</a></li>--%>
<%--        <li class="myPageLi" style="margin-bottom: 10px; cursor: pointer; font-size: 13px;"><a class="none"--%>
<%--                                                                                               onclick="test()">1:1 문의내역</a></li>--%>
<%--        <li class="myPageLi" style="margin-bottom: 10px; cursor: pointer; font-size: 13px;"><a class="none"--%>
<%--                                                                                               onclick="test()">제품 문의내역</a></li>--%>
<%--    </ul>--%>
<%--</div>--%>
<%--<jsp:include page="footer.jsp" flush="false" />--%>

<%--<script>--%>
<%--    let pwdClear = "${pwdClear}"--%>
<%--    if (pwdClear === "pwdMsg2") {--%>
<%--        alert("비밀번호 변경에 성공했습니다.")--%>
<%--    }--%>

<%--    function test() {--%>
<%--        alert("테스트중입니다!")--%>
<%--    }--%>
<%--</script>--%>

<%--</body>--%>