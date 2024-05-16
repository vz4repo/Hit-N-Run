
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home Run Ball</title>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans&display=swap" rel="stylesheet">
    <style>

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

        /*.container */
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

        /*#error-message {*/
        /*    position: absolute;*/
        /*    color: gray;*/
        /*    top: 26%;*/
        /*    left: 50%;*/
        /*    transform: translate(-50%, -50%);*/
        /*}*/
        label{
            font-size: 13px;
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
        <button type="button" class="subBtn">Forgot Email</button>
        <button type="button" class="subBtn">Forgot pwd</button>
        <a href="/register/add"> <button type="button" id="signUpButton">Sign Up</button> </a>
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

</script>

</body>

</html>
