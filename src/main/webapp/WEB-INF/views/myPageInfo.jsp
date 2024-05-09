<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            margin-right: 120px;
        }

        .hidden {
            display: none;
        }
    </style>
</head>

<body>
<div id="myform">
    <form action="<c:url value="/mypage/info"/>" method="POST">
    <h1 id="loginTitle">개인정보 관리</h1>
        <div class="container">
            <p id="check-result"></p>
            <label id="email">이메일*</label>
            <input class="special-class" type="text" id="c_email" name="c_email" value="<%= session.getAttribute("c_email")%>"disabled>

            <label id="pwdLabel">비밀번호</label>
            <input id="pwdChange" type="button" onclick="showPasswordForm()" value="비밀번호 변경">
            <input id="pwd" class="special-class" type="password" name="c_pwd" value="<%= session.getAttribute("c_pwd")%>"readonly>
<%--히든--%>
            <div id="passwordForm" class="hidden">
                <label>새로운 비밀번호</label>
                <input id="newPwd" class="special-class" type="password">
                <button type="button" onclick="updatePassword()">확인</button>
                <button type="button" onclick="hidePasswordForm()">취소</button>
            </div>
<%--히든--%>
            <label>이름*</label>
            <input class="special-class" type="text" name="c_name" value="<%= session.getAttribute("c_name")%>"disabled>
            <label>주소</label>
            <input type="text" id="zip" name="c_zip" value="<%= session.getAttribute("c_zip")%>">
            <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
            <input type="text" id="roadAddress" name="c_road_a" value="<%= session.getAttribute("c_road_a")%>">
            <input type="text" id="jibunAddress" name="c_jibun_a" value="<%= session.getAttribute("c_jibun_a")%>">
            <span id="guide" style="color:#999;display:none"></span>
            <input type="text" id="detailAddress" name="c_det_a" value="<%= session.getAttribute("c_det_a")%>">
            <input type="text" id="extraAddress" name="c_ext_a" value="<%= session.getAttribute("c_ext_a")%>"><br><br>

            <label>휴대폰</label>
            <input class="special-class" type="text" name="c_phn" value="<%= session.getAttribute("c_phn")%>">

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


            <button>수정</button><br><br>
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
                /*표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.*/
                if (extraRoadAddr !== '') {
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                /*우편번호와 주소 정보를 해당 필드에 넣는다.*/
                document.getElementById('zip').value = data.zonecode;


                document.getElementById("roadAddress").value = roadAddr;
                document.getElementById("jibunAddress").value = data.jibunAddress;

                /*참고항목 문자열이 있을 경우 해당 필드에 넣는다.*/
                if (roadAddr !== '') {
                    document.getElementById("extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                /*사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.*/
                if (data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if (data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }

    function showPasswordForm() {
        var form = document.getElementById("passwordForm");
        var previousPassword = document.getElementById("pwdLabel");
        var pwdChd = document.getElementById("pwdChange");
        var previousInput = document.querySelector('input[name="c_pwd"]');

        // 히든 폼을 보이도록 설정
        form.style.display = "inline-block";
        // 이전 비밀번호 라벨을 숨김
        previousPassword.style.display = "none";
        // 비밀번호 변경 버튼을 숨김
        pwdChd.style.display = "none";
        // 이전 비밀번호 입력 필드를 숨김
        previousInput.style.display = "none";
    }

    function hidePasswordForm() {
        var form = document.getElementById("passwordForm");
        var previousPassword = document.getElementById("pwdLabel");
        var pwdChd = document.getElementById("pwdChange");
        var previousInput = document.querySelector('input[name="c_pwd"]');

        // 히든 폼을 숨김
        form.style.display = "none";
        // 이전 비밀번호 라벨을 보임
        previousPassword.style.display = "inline-block";
        // 비밀번호 변경 버튼을 보임
        pwdChd.style.display = "inline-block";
        // 이전 비밀번호 입력 필드를 보임
        previousInput.style.display = "inline-block";
    }

    function updatePassword() {
        var newPassword = document.getElementById("newPwd").value;
        var passwordInput = document.getElementById('pwd');
        passwordInput.value = newPassword;
        hidePasswordForm(); // 폼 숨기기
    }

</script>
</body>
</html>