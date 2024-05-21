<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
    <title>My Page</title>
    <style>
        body {
            font-family: 'IBM Plex Sans', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
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

        p {
            font-size: 13px;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin-bottom: 10px;
            cursor: pointer;
            font-size: 13px;
        }

        #myPage h5 {
            border-bottom: 1px solid #ccc;
            padding-bottom: 5px;
        }
    </style>
</head>

<body>
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

<script>
    let pwdClear = "${pwdClear}"
    if(pwdClear==="pwdMsg2") {
        alert("비밀번호 변경에 성공했습니다.")
    }

    function test(){
        alert("아직 테스트중입니다!")
    }
</script>

</body>
