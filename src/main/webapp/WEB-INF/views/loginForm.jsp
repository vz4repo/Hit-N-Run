
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home Run Ball</title>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <style>
        body{
            font-family: "IBM Plex Sans KR", sans-serif;
        }

        #loginform {
            max-width: 500px;
            max-height: 500px;
            text-align: center;
            border: 3px solid #f1f1f1;
            border-radius: 50px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            padding-top: 2%;
            padding-bottom: 2%;
            margin: 0 auto;
            margin-top: 200px;
        }

        .container {
            width: 400px;
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


        .subBtn {
            width: 49%;
            margin-bottom: 10px;
        }

        label {
            display: block;
            margin-bottom: 15px;
            font-weight: bold;
            color: gray;
            font-size: 13px;
        }

        #check {
            margin-bottom: 15px;
            font-size: 13px;
            display: flex;
        }

        #remember{
            margin-right: 5px;
            /*float: right;*/
        }

        #emailRemember{
            font-size: 12px;
            float: right;
        }

        .buttonContainer {
            display: flex;
            justify-content: space-between;
            max-width: 400px;
            margin: auto;
        }

        .subBtn {
            display: flex;
            align-items: center; /* 텍스트와 이미지를 세로 중앙으로 정렬 */
            justify-content: center; /* 텍스트와 이미지를 수평으로 정렬 */
            /*background-color: gainsboro;*/
            color: black;
            border: none; /* 버튼의 기본 테두리를 제거 */
            cursor: pointer;
            padding: 5px 10px; /* 버튼 내부 패딩을 추가하여 내용과 테두리 사이의 공간을 조절 */
        }

        #forgot{
            cursor: pointer;
        }

        #regi{
            cursor: pointer;
            text-decoration: none; /* 밑줄 제거 */
            color: #000; /* 링크 색상 */
            /*float: right;*/
        }

        #loginDiv {
            position: relative;
        }

        #loginImg {
            position: absolute;
            left: 5px;
            /* 이미지를 왼쪽으로 5px 이동시켜요. 이 값을 조절하여 원하는 위치에 맞출 수 있어요. */
            top: 40%;
            /* 이미지를 수직으로 가운데에 위치시켜요. */
            transform: translateY(-50%);
            height: 25px;
            width: 25px;
            pointer-events: none;
            /* 이미지 위에서의 이벤트를 비활성화해요. */
        }

        #c_email {
            padding-left: 40px;
            /* 이미지를 감안하여 왼쪽 패딩을 추가해요. */
        }

        #pwdDiv {
            position: relative;
        }

        #pwdImg {
            position: absolute;
            left: 5px;
            top: 40%;
            transform: translateY(-50%);
            height: 25px;
            width: 25px;
            pointer-events: none;
        }

        #c_pwd {
            padding-left: 40px;
        }

        #login {
            position: relative;
            width: 100%;
            height: 50px;
            padding: 10px;
            margin-bottom: 10px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            background-color: darkgreen;
            color: whitesmoke;
            border: none;
             font-size: 15px;
            text-align: center;
            -webkit-transition-duration: 0.4s;
            /* Safari */
            transition-duration: 0.4s;
            text-decoration: none;
            overflow: hidden;
            cursor: pointer;

        }

        #login:after {
            content: "";
            background:  #073713;
            display: block;
            position: absolute;
            padding-top: 300%;
            padding-left: 350%;
            margin-left: -20px !important;
            margin-top: -120%;
            opacity: 0;
            transition: all 0.8s
        }

        #login:active:after {
            padding: 0;
            margin: 0;
            opacity: 1;
            transition: 0s
        }


    </style>
</head>

<body>
<div id="loginform">
    <form action="<c:url value='/login'/>" method="post" onsubmit="return">

    <a href="/"><img src="/img/homerunball_logo.png" style="width:200px"></a><br><br><br><br><br>
    <div class="container">

    <div id="loginDiv">
        <input value="${cookie.c_email.value}" id="c_email" name="c_email" class="special-class" type="text" maxlength="30"
               placeholder="homerun@ball.com" required>
        <img id="loginImg" src="https://cdn-icons-png.flaticon.com/128/1540/1540316.png">
    </div>

<%--        <div id="pwdDiv"><img id="pwdImg" style="height: 30px" width="30px" src="https://cdn-icons-png.flaticon.com/128/14/14478.png"><input id="c_pwd" class="special-class" type="password" name="c_pwd" maxlength="15" placeholder="Password" required></div>--%>
<%--        --%>

        <div id="pwdDiv">
            <input id="c_pwd" class="special-class" type="password" name="c_pwd" maxlength="15" placeholder="Password" required>
            <img id="pwdImg" src="https://cdn-icons-png.flaticon.com/128/2827/2827914.png">
        </div>

        <input type="hidden" name="toURL" value="${param.toURL}">
        <div id="emailRemember">
            <input type="checkbox" id="remember" name="rememberEmail" ${empty cookie.c_email.value ? "":"checked"}>이메일 저장</div><br><br>
        <button type="submit" id="login">로그인</button>

        <div id="check">
            <a id="forgot" onclick="test()" >비밀번호 찾기</a> <a id="regi" href="/register/add" style="margin-left: 280px">회원가입 </a>
        </div><br>

        <div class="buttonContainer">
        <div class="subBtn" id="googleBtn" onclick="test()"> <img id="google" src="https://cdn-icons-png.flaticon.com/128/300/300221.png" width="50" height="50"></div>
            <div class="subBtn" id="kakaoBtn" onclick="test()"> <img id="kakao" src="https://cdn-icons-png.flaticon.com/128/3669/3669973.png" width="50" height="50"></div>
                <div class="subBtn" id="appleBtn" onclick="test()"> <img id="apple" src="https://cdn-icons-png.flaticon.com/128/0/747.png" width="50" height="50"></div>
        </div>

    </div>

    </form>
</div>

<script>
    let signUpClear = "${signUpClear}"
    if(signUpClear==="msg") {
        alert("회원가입이 되셨습니다.");
    }

    let loginFail = "${loginFail}"
    if(loginFail==="msg") {
        alert("아이디 또는 비밀번호를 잘못 입력하셨습니다.");
    }

    let pwdClear = "${pwdClear}"
    if(pwdClear==="pwdMsg2") {
        alert("변경된 비밀번호로 다시 로그인해주세요.")
    }

    <%--let pwdClear = "${pwdClear}";--%>
    <%--if (pwdClear === "pwdMsg2") {--%>
    <%--    let confirmation = confirm("로그아웃 후 새로운 비밀번호로 로그인 하시겠습니까?");--%>
    <%--    if (!confirmation) {--%>
    <%--        window.location.href = "/mypage/list";--%>
    <%--    }--%>
    <%--}--%>


    function test(){
            alert("테스트중입니다!")
    }
</script>

</body>

</html>
