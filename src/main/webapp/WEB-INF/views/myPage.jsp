<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">



<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
        }

        #sidebar {
            margin-top: 200px;
        }

        #sidebar li a {
            text-decoration: none;
            color: black;
        }

        #sidebar li a:hover {
            background-color: #ddd;
        }

        h1 {
            font-size: 20px;
        }

        h2 {
            color: #333;
            font-size: 15px;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin-bottom: 10px;
        }
    </style>
</head>

<body>
<div id="sidebar">
    <h1>
        <%= session.getAttribute("c_name") %>님의 회원등급은 <%=session.getAttribute("grd_name")%>입니다.
    </h1>
    <h5>
        총 누적 금액: <%=session.getAttribute("tot_amt")%>원<br>
        홈런볼 가입날짜: <%= session.getAttribute("reg_dt")%><br>
        홈런볼 최근 로그인:  <%= session.getAttribute("login_dt")%>
    </h5><br>
    <h2>My Info</h2>
    <ul>
        <li><a href="/mypage/pwdEdit">비밀번호 변경</a></li>
        <li><a href="/mypage/info">개인정보 관리</a></li>
        <li><a href="#">배송지 관리</a></li>
        <li><a href="#">회원탈퇴</a></li>
    </ul>

    <h2>My Shopping</h2>
    <ul>
        <li><a href="/mypage/pay">주문/배송조회</a></li>
    </ul>

    <h2>My Activity</h2>

    <ul>
        <li><a href="#">리뷰 내역</a></li>
        <li><a href="#">1:1 문의내역</a></li>
        <li><a href="#">제품 문의내역</a></li>
    </ul>
</div>

<script>
    let pwdClear = "${pwdClear}"
    if(pwdClear==="pwdMsg2") {
        alert("비밀번호 변경에 성공했습니다.")
    }
</script>

</body>
