<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>
        .container {
            width: 300px;
            margin: 0 auto;
            text-align: left;
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
            /*padding: 30%;*/
            margin: 0 auto;
            margin-top: 50px;
            margin-bottom: 150px;
        }


        span {
            color: gray;
        }

        body {
            font-size: 11px;
            font-family: 'IBM Plex Sans', sans-serif;
        }

        #roadAddress {
            width: 265.5px;
        }

        #jibunAddress {
            width: 265.5px;
        }

        #detailAddress {
            width: 265.5px;
        }

        #birth {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1em;
            width: 100%;
            box-sizing: border-box;
        }

        #pwdLabel, #pwdChange{
            display: inline-block;
        }

        #pwdLabel{
            margin-right: 143px;
        }

        .hidden {
            display: none;
            width: 100%;
        }
    </style>
</head>

<body>
<div id="myform">
    <form action="/mypage/info" method="POST" onsubmit="return formCheck()">
        <h1 id="loginTitle">개인정보 관리</h1>
        <div class="container">
            <p id="check-result"></p>
            <label id="email">이메일*</label>
            <input class="special-class" type="text" id="c_email" name="c_email" value="<%= session.getAttribute("c_email")%>" disabled>

<%--            <label id="pwdLabel">비밀번호</label>--%>
<%--            <input id="pwdChange" type="button" onclick="pwdEdit()" value="비밀번호 변경">--%>

<%--            <input id="pwdChange" type="button" onclick="showPasswordForm()" value="비밀번호 변경">--%>
<%--            <input id="pwd" class="special-class" type="password" name="c_pwd" value="<%= session.getAttribute("c_pwd")%>" readonly>--%>



<%--히든--%>
<%--            <div id="passwordForm" class="hidden">--%>
<%--&lt;%&ndash;                <label>현재 비밀번호</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <input id="curPwd" class="special-class" type="password" >&ndash;%&gt;--%>
<%--                <label>새로운 비밀번호</label>--%>
<%--                <input id="newPwd" class="special-class" type="password" name="c_pwd" oninput="newPwdCheck(this.form)">--%>
<%--                <p id="check-newPwd"></p>--%>
<%--                <label>비밀번호 확인</label>--%>
<%--                <input id="newPwd2" class="special-class" type="password" oninput="newPwdCheck(this.form)">--%>
<%--                <button type="button" onclick="updatePassword()">확인</button>--%>
<%--                <button type="button" onclick="hidePasswordForm()">취소</button>--%>
<%--            </div>--%>
<%--히든--%>
            <label>이름*</label>
            <input class="special-class" type="text" name="c_name" value="<%= session.getAttribute("c_name")%>"disabled>
            <label>주소</label>
            <input type="text" id="zip" name="c_zip" value="<%= session.getAttribute("c_zip")%>" readonly>
            <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
            <input type="text" id="roadAddress" name="c_road_a" value="<%= session.getAttribute("c_road_a")%>" readonly>
            <input type="text" id="jibunAddress" name="c_jibun_a" value="<%= session.getAttribute("c_jibun_a")%>" readonly>
            <span id="guide" style="color:#999;display:none"></span>
            <input type="text" id="detailAddress" name="c_det_a" value="<%= session.getAttribute("c_det_a")%>"><br><br>
            <label>휴대폰</label>
            <input class="special-class" type="text" id="c_phn" name="c_phn" value="<%= session.getAttribute("c_phn")%>">
            <label>성별*</label>
            <input class="special-class" type="text" name="c_gnd" value="<%= session.getAttribute("c_gnd")%>"disabled>
            <label id="aa">생년월일*</label>
            <input class="special-class"  id="birth" name="c_birth" value="<%= session.getAttribute("c_birth")%>"disabled><br><br>
            <a>SMS 수신</a><br>
            <input type="radio" id="sms_agr" name="sms_agr" value="Y" <%= session.getAttribute("sms_agr").equals("Y") ? "checked" : "" %>>수신함
             <input type="radio" id="sms_no" name="sms_agr" value="N" <%= session.getAttribute("sms_agr").equals("N") ? "checked" : "" %>>수신안함<br><br>
            <a>이메일 수신</a><br>
            <input type="radio" id="email_agr" name="email_agr" value="Y"<%= session.getAttribute("email_agr").equals("Y") ? "checked" : "" %>>수신함
            <input type="radio" id="email_no" name="email_agr" value="N"<%= session.getAttribute("email_agr").equals("N") ? "checked" : "" %>>수신안함<br><br>
            <button id="edit">수정</button><br>
            <button type="button" onclick="window.history.back()">나가기</button><br><br>
        </div>
    </form>
</div>


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function (data) {

                var roadAddr = data.roadAddress;
                var extraRoadAddr = '';

                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                    extraRoadAddr += data.bname;
                }

                if (data.buildingName !== '' && data.apartment === 'Y') {
                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }

                document.getElementById('zip').value = data.zonecode;
                document.getElementById("roadAddress").value = roadAddr;
                document.getElementById("jibunAddress").value = data.jibunAddress;
            }
        }).open();
    }

    // function pwdEdit() {
    //     window.location.href = "/mypage/pwdEdit";
    // }

    function showPasswordForm() {
        var form = document.getElementById("passwordForm");
        var previousPassword = document.getElementById("pwdLabel");
        var pwdChd = document.getElementById("pwdChange");
        var pwdInput = document.getElementById("pwd")
        var editButton = document.getElementById("edit")


        /*히든 폼을 보이도록 설정*/
        form.style.display = "inline-block";
        /*이전 비밀번호 라벨을 숨김*/
        previousPassword.style.display = "none";
        /*비밀번호 변경 버튼을 숨김*/
        pwdChd.style.display = "none";
        /*이전 비밀번호 입력 필드를 숨김*/
        pwdInput.style.display = "none";
        editButton.disabled = true;
    }

    function hidePasswordForm() {
        var form = document.getElementById("passwordForm");
        var previousPassword = document.getElementById("pwdLabel");
        var pwdChd = document.getElementById("pwdChange");
        var pwdInput = document.getElementById("pwd")
        var editButton = document.getElementById("edit")

        /*히든 폼을 숨김*/
        form.style.display = "none";
        /*이전 비밀번호 라벨을 보임*/
        previousPassword.style.display = "inline-block";
        /*비밀번호 변경 버튼을 보임*/
        pwdChd.style.display = "inline-block";
        /*이전 비밀번호 입력 필드를 보임*/
        pwdInput.style.display = "inline-block";
        editButton.disabled = false;
    }

     /*회원가입 유효성 자스도 이런식으로 바꿔보기*/
    function updatePassword() {
        var newPwd = document.getElementById("newPwd").value;
        var newPwd2 = document.getElementById("newPwd2").value;
        // var pwd = document.getElementById('pwd');
        var newPwdPattern = /^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]).{8,15}$/;

        if(!newPwdPattern.test(newPwd)) {
            alert("비밀번호는 영어/숫자/특수문자 포함 8자이상을 작성하셔야합니다.")
            return false;
        }

        if(newPwd !== newPwd2){
            return false;
        } else if(newPwd===newPwd2){
            // pwd.value = newPwd;
                hidePasswordForm();
                return true;
        }
    }

    function formCheck(){
        var isPhn = newPhnCheck();
        if(!isPhn){
            return false;
        }
        return confirm("변경사항을 마무리하시고 적용하시겠습니까?")
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

    function newPhnCheck(){
        var newPhn = document.getElementById("c_phn").value;

        var newPhnPattern = /^[0-9]{1,12}$/;

        if(!newPhnPattern.test(newPhn)){
            alert("휴대폰 전화번호는 숫자 12자 이하로 작성해주세요")
            return false;
    }
        return true;
    }


</script>
</body>
</html>