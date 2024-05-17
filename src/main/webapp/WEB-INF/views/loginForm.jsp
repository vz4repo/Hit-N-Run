
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home Run Ball</title>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans&display=swap" rel="stylesheet">
    <style>

        body{
            font-family: 'IBM Plex Sans', sans-serif;
        }

        #loginform {
            max-width: 1130px;
            text-align: center;
            border: 3px solid #f1f1f1;
            border-radius: 50px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            padding-top: 7%;
            padding-bottom: 10%; /* 세로 방향의 패딩만 설정 */
            margin: 0 auto;
            margin-top: 200px;
            margin-bottom: 150px;
        }

        .container {
            width: 300px;
            margin: 0 auto;
            text-align: left;
        }


        .special-class {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            background-color: darkgreen;
            color: whitesmoke;
        }

        .subBtn {
            width: 49%;
            margin-bottom: 10px;
        }

        label {
            display: block;
            margin-bottom: 15px;
            font-weight: bold;
            color: gray;
        }

        #check {
            margin-bottom: 15px;
            font-size: 12px;
            display: flex;
        }

        #remember{
            margin-right: 5px;
        }

        #loginTitle {
            font-size: 20px;
            margin-bottom: 40px;
            font-family: 'IBM Plex Sans', sans-serif;
        }

        label{
            font-size: 13px;
        }


        #kakaoBtn {
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #ffd400;
            color: saddlebrown;
            font-weight: bold;
        }


        #googleBtn {
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: gainsboro;
            color: black;
            /*color: saddlebrown;*/
            /*font-weight: bold;*/
        }

        #naverBtn {
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: green;
            /*color: black;*/
            /*color: saddlebrown;*/
            /*font-weight: bold;*/
        }

        #kakao {
            margin-right: 10px; /* 이미지와 텍스트 사이의 간격 조정 */
        }

        #google {
            margin-right: 10px; /* 이미지와 텍스트 사이의 간격 조정 */
        }

        #naver {
            margin-right: 10px; /* 이미지와 텍스트 사이의 간격 조정 */
        }
    </style>
</head>

<body>

<div id="loginform">
    <form action="<c:url value='/login'/>" method="post" onsubmit="return">
        <h1 id="loginTitle">Home Run Ball</h1>
    <div class="container">
        <label>Email</label>
        <input value="${cookie.c_email.value}" name="c_email" class="special-class" type="text" placeholder="Email" required>
        <label>Password</label>
        <input class="special-class" type="password" name="c_pwd" placeholder="Password" required>

        <input type="hidden" name="toURL" value="${param.toURL}">

        <div id="check">
            <input type="checkbox" id="remember" name="rememberEmail" ${empty cookie.c_email.value ? "":"checked"}> Remember Email
        </div>
        <button type="submit">Continue</button>
        <button type="button" class="subBtn" onclick="test()">Forgot Email</button>
        <button type="button" class="subBtn" onclick="test()">Forgot pwd</button>
        <a href="/register/add"> <button type="button" id="signUpButton">Sign Up</button> </a>

        <button id="googleBtn" type="button" onclick="test()">
            <img id="google" src="https://cdn-icons-png.flaticon.com/128/300/300221.png" width="30" height="30">
            구글 로그인
        </button>

        <button id="naverBtn" type="button" onclick="test()">
            <img id="naver" src="https://cdn-icons-png.flaticon.com/128/11423/11423248.png" width="30" height="30">
            네이버 로그인
        </button>

        <button id="kakaoBtn" type="button" onclick="test()">
            <img id="kakao" src="https://cdn-icons-png.flaticon.com/512/2111/2111466.png" width="30" height="30">
            카카오톡 로그인
        </button>

    </div>
    </form>
</div>


<footer>
    </footer>


<script>
    let signUpClear = "${signUpClear}"
    if(signUpClear==="msg") {
        alert("회원가입이 되셨습니다.");
    }

    let loginFail = "${loginFail}"
    if(loginFail==="msg") {
        alert("아이디 또는 비밀번호를 잘못 입력하셨습니다.");
    }


    function test(){
            alert("아직 테스트중입니다!")
    }
</script>

</body>

</html>
