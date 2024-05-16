<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <style>
    .container {
      width: 300px;
      margin: 0 auto;
      text-align: left;
      padding: 100px;
    }

    .special-class {
      width: 100%;
      padding: 10px;
      margin-bottom: 7px;
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

    label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
      font-size: 13px;
      color: gray;
    }

    #loginTitle {
      text-align: center;
      font-size: 20px;
      margin-bottom: 40px;
      font-family: 'IBM Plex Sans', sans-serif;
    }

    #myform {
      max-width: 1130px;
      text-align: center;
      border: 3px solid #f1f1f1;
      border-radius: 50px;
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
      margin: 0 auto;
      margin-top: 150px;
      margin-bottom: 150px;
    }

    span {
      color: gray;
    }

    body {
      font-size: 11px;
      font-family: 'IBM Plex Sans', sans-serif;
    }

  </style>
</head>

<body>
<div id="myform">
    <form action="/mypage/pwdEdit" method="POST" onsubmit="return pwdEditCheck()">
    <div class="container">
      <h1 id="loginTitle">비밀번호 변경</h1><br><br>

        <label>현재 비밀번호</label>
        <input id="curPwd" class="special-class" type="password" name="curPwd">

      <label>신규 비밀번호</label>
      <input id="newPwd" class="special-class" type="password" name="c_pwd" oninput="newPwdCheck(this.form)">
      <p id="check-newPwd"></p>

      <label>신규 비밀번호 확인</label>
      <input id="newPwd2" class="special-class" type="password" oninput="newPwdCheck(this.form)"><br><br>
      <button>확인</button>
      <button type="button" onclick="window.history.back()">나가기</button><br><br>
    </div>
  </form>
</div>

<script>

    let pwdFail = "${pwdFail}"
    if(pwdFail==="pwdMsg") {
        alert("현재 비밀번호가 일치하지 않습니다.")
    }

  function pwdEditCheck(){
    var curPwd = document.getElementById("curPwd").value;
    var newPwd = document.getElementById("newPwd").value;
    var newPwd2 = document.getElementById("newPwd2").value;
    var newPwdPattern = /^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]).{8,15}$/;


    if(!newPwdPattern.test(newPwd)) {
      alert("비밀번호는 영어/숫자/특수문자 포함 8자이상을 작성하셔야합니다.")
      return false;
    }

    if (curPwd === newPwd) {
      alert("현재 비밀번호와 새로운 비밀번호가 일치합니다. 다른 비밀번호를 입력해주세요.");
      return false;
    }

    if(newPwd !== newPwd2){
      alert("신규 비밀번호와 신규 비밀번호 확인이 일치하지 않습니다.")
      return false;
    } else if(newPwd===newPwd2){
      return true;
    }
  }

  function newPwdCheck() {
    var newPwdResult = document.getElementById("check-newPwd");
    var newPwd = document.getElementById("newPwd").value
    var newPwd2 = document.getElementById("newPwd2").value

    if(!newPwd){
      newPwdResult.style.color = "red";
      newPwdResult.innerHTML = "비밀번호를 입력해주세요.";
      return false;
    }else if(!newPwd2){
      newPwdResult.style.color = "red";
      newPwdResult.innerHTML = "비밀번호 확인을 입력해주세요.";
      return false;
    } else if ((newPwd !== newPwd2) || (newPwd2 !== newPwd)) {
      newPwdResult.style.color = "red";
      newPwdResult.innerHTML = "입력하신 비밀번호와 비밀번호 확인이 일치하지 않습니다.";
      return false;
    }else
      newPwdResult.style.color = "green";
    newPwdResult.innerHTML = "비밀번호가 동일합니다.";
    return true;
  }
</script>
</body>
</html>