
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home Run Ball</title>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans&display=swap" rel="stylesheet">
    <style>

        #loginSection {
            text-align: center;
            margin-top: 50px;
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

        .container .subBtn {
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

        form {
            max-width: 1130px;
            margin: 0 auto;
            border: 3px solid #f1f1f1;
            border-radius: 10px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            padding: 5%;
        }
        #error-message {
            position: absolute;
            color: gray;
            top: 26%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
        label{
            font-size: 13px;
        }

    </style>


    <script>
        let msg = "${sf}"
        if(msg==="SF_OK") {
            alert("회원가입이 되셨습니다.");
        }
    </script>


</head>

<body>

<header>

    </header>

    <form id="loginSection" action="<c:url value='/login'/>" method="post" onsubmit="return;">

    <%String msg =(String)request.getAttribute("msg");
        if(msg!=null) {%>
    <div id="error-message">
    <label><%= msg %></label>
    <% } %>
    </div>

        <h1 id="loginTitle">Home Run Ball</h1>
    <div class="container">
        <label>Email or ID</label>
        <input value="${cookie.userID.value}" name="id" id="usernameInput" class="special-class" type="text" placeholder="Email or ID" required>
        <label>Password</label>
        <input name="pwd" id="passwordInput" class="special-class" type="password" placeholder="Password" required>

        <input type="hidden" name="toURL" value="${param.toURL}">

        <div id="check">
            <input type="checkbox" id="remember" name="rememberID" ${empty cookie.userID.value ? "":"checked"}> Remember Email or ID
        </div>
        <button type="submit">Continue</button>
        <button type="button" class="subBtn">Forgot ID</button>
        <button type="button" class="subBtn">Forgot pwd</button>
        <a href="/register/add"> <button type="button" id="signUpButton">Sign Up</button> </a>


    </div>
    </form>

<footer>
    </footer>

</body>

</html>
