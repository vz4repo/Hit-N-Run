
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home Run Ball</title>
    <%--폰트 정해지면 바꾸기--%>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans&display=swap" rel="stylesheet">
    <style>
        body{
            font-family: 'IBM Plex Sans', sans-serif;
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
            /*margin-bottom: 50px;*/
        }

        .container {
            width: 400px;
            /*height: 400px;*/
            margin: 0 auto;
            text-align: left;
        }


        .special-class {
            width: 87%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            height: 50px;
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
            font-size: 13px;
        }

        #check {
            margin-bottom: 15px;
            font-size: 13px;
            display: flex;
            /*margin-left: 30px;*/
        }

        #remember{
            margin-right: 5px;
            /*font-size: 12px;*/
        }

        #emailRemember{
            font-size: 12px;
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
            background-color: gainsboro;
            color: black;
            border: none; /* 버튼의 기본 테두리를 제거 */
            cursor: pointer;
            padding: 5px 10px; /* 버튼 내부 패딩을 추가하여 내용과 테두리 사이의 공간을 조절 */
        }

        #googleBtn {
            background-color: gainsboro;
            color: #2c0b0e;
        }

        #kakaoBtn {
            background-color: #ffd400;
            color: #2c0b0e;
        }

        #appleBtn {
            background-color: whitesmoke;
            color: #2c0b0e;
        }


        #forgot{
            cursor: pointer;
        }

        #regi{
            cursor: pointer;
            text-decoration: none; /* 밑줄 제거 */
            color: #000; /* 링크 색상 */
        }

        #loginImg, #c_email{
            display: inline;
        }

        #loginDiv {
            display: flex;
            justify-content: space-between;
        }

        #pwdImg, #c_pwd{
            display: inline;
        }

        #pwdDiv{
            display: flex;
            justify-content: space-between;
        }
    </style>
</head>

<body>
<div id="loginform">
    <form action="<c:url value='/login'/>" method="post" onsubmit="return">

    <a href="/"><img src="/img/homerunball_logo.png" style="width:200px"></a><br><br><br><br>
    <div class="container">

    <div id="loginDiv"><img id="loginImg" style="height: 30px" width="30px"
                            src="https://cdn-icons-png.flaticon.com/128/1540/1540316.png"><input value="${cookie.c_email.value}"
                                                                                                 id="c_email" name="c_email" class="special-class" type="text" maxlength="30" placeholder="Email" required></div>

        <div id="pwdDiv"><img id="pwdImg" style="height: 30px" width="30px" src="https://cdn-icons-png.flaticon.com/128/14/14478.png"><input id="c_pwd" class="special-class" type="password" name="c_pwd" maxlength="15" placeholder="Password" required></div>

        <input type="hidden" name="toURL" value="${param.toURL}">

<%--        <div id="check">--%>
        <div id="emailRemember">
            <input type="checkbox" id="remember" name="rememberEmail" ${empty cookie.c_email.value ? "":"checked"}>이메일 저장</div><br><br>
<%--        </div><br>--%>
        <button type="submit">로그인</button>
<%--        <a href="/register/add"> <button type="button" id="signUpButton">회원가입</button> </a>--%>

        <div class="buttonContainer">
        <button type="button" class="subBtn" id="googleBtn" onclick="test()"> <img id="google" src="https://cdn-icons-png.flaticon.com/128/300/300221.png" width="30" height="30"></button>
        <button type="button" class="subBtn" id="kakaoBtn" onclick="test()"> <img id="kakao" src="https://cdn-icons-png.flaticon.com/512/2111/2111466.png" width="30" height="30"></button>
            <button type="button" class="subBtn" id="appleBtn" onclick="test()"> <img id="apple" src="https://cdn-icons-png.flaticon.com/128/0/747.png" width="30" height="30"></button></div>
        <div id="check">
            <a id="forgot" onclick="test()" >아이디/비밀번호 찾기</a> <a id="regi" href="/register/add" style="margin-left: 220px">회원가입 </a>
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

    function test(){
            alert("테스트중입니다!")
    }
</script>

</body>

</html>
