<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />



    <style>

        body {
            font-family: "IBM Plex Sans KR", sans-serif;
            font-size: 11px;
        }

        /*.container {*/
        /*    width: 515px;*/
        /*    margin-left: 430px;*/
        /*    text-align: left;*/
        /*}*/
        .container {
            width: 515px;
            margin: auto;
            text-align: left;
            position: relative;
            left: -130px;
        }

        .special-class {
            width: 400px;
            padding: 10px;
            margin-bottom: 7px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        #edit {
            margin-top: -1px;
            border: none;
            cursor: pointer;
            background-color: white;
            outline: none;
            font-size: 12px;
            margin-right: 295px;
            font-weight: bold;
        }

        .infoLabel {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            font-size: 13px;
            color: gray;
        }

        #loginTitle {
            font-size: 20px;
            margin-bottom: 40px;
            margin-top: 40px;
        }

        span {
            color: gray;
        }

        #roadAddress,
        #jibunAddress,
        #detailAddress {
            width: 400px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        #zip {
            width: 75px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        #zipBtn {
            float: right;
            margin-right: 115px;
        }

        #c_birth {
            padding: 9px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1em;
            width: 400px;
            box-sizing: border-box;
        }


        #ad {
            display: flex;
            justify-content: space-between;
        }

        #check {
            margin-bottom: 15px;
            font-size: 12px;
            margin-left: 390px;
            width: 500px;
            display: inline-block;
            font-weight: bold;
        }

        #delete {
            cursor: pointer;
        }

        #choice{
            font-size: 11px;
        }

        .choiceLabel {
            cursor: pointer;
        }

        .oneLine{
            display: flex;
            justify-content: space-between;
        }

        #det, #phn{
            font-size: 11px;
            margin-top: 15px;
        }

        #phn{
            margin-right: 37px;
        }

    </style>

    <link href="<c:url value='/css/reset.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="header.jsp"/>
<jsp:include page="myPageHeader.jsp"/>
<div id="myform">
    <form action="/mypage/info" method="POST" onsubmit="return formCheck()">
        <div class="container">
            <h1 id="loginTitle">Edit Profile</h1>
            <p id="check-result"></p>
            <label class="infoLabel">이메일*</label>
            <input class="special-class" type="text" id="c_email" name="c_email" value="<%= session.getAttribute("c_email")%>" disabled>
            <label class="infoLabel">이름*</label>
            <input class="special-class" type="text" name="c_name" value="<%= session.getAttribute("c_name")%>"disabled>
            <label class="infoLabel">주소</label>
            <div id="ad">
                <input type="text" id="zip" name="c_zip" value="<%= session.getAttribute("c_zip")%>" readonly>
                <input type="button" id="zipBtn" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" ></div>
            <input type="text" id="roadAddress" name="c_road_a" value="<%= session.getAttribute("c_road_a")%>" readonly>
            <input type="text" id="jibunAddress" name="c_jibun_a" maxlength="30" value="<%= session.getAttribute("c_jibun_a")%>" readonly>
            <span id="guide" style="color:#999;display:none"></span>
            <div class="oneLine"><input type="text" id="detailAddress" name="c_det_a" maxlength="30" value="<%= session.getAttribute("c_det_a")%>"><p id="det">건물명 + 상세주소</p></div><br>
            <label class="infoLabel">휴대폰</label>
            <div class="oneLine"><input class="special-class" type="text" id="c_phn" name="c_phn" maxlength="12" value="<%= session.getAttribute("c_phn")%>"><p id="phn">-제외</p></div>
            <label class="infoLabel">성별*</label>
            <input class="special-class" type="text" name="c_gnd" value="<%= session.getAttribute("c_gnd")%>"disabled>
            <label class="infoLabel" id="aa">생년월일</label>
            <input type="date" id="c_birth" name="c_birth" min="1900-01-01" max="2023-12-31" value="<%= session.getAttribute("c_birth")%>" ><br><br>
          <div id="choice">
            <a>SMS 수신</a><br>
            <input type="radio" id="sms_agr" name="sms_agr" value="Y" <%= session.getAttribute("sms_agr").equals("Y") ? "checked" : "" %>>
            <label for="sms_agr" class="choiceLabel">수신함</label>
            <input type="radio" id="sms_no" name="sms_agr" value="N" <%= session.getAttribute("sms_agr").equals("N") ? "checked" : "" %>>
            <label for="sms_no" class="choiceLabel">수신 안함</label><br><br>

            <a>이메일 수신</a><br>
            <input type="radio" id="email_agr" name="email_agr" value="Y" <%= session.getAttribute("email_agr").equals("Y") ? "checked" : "" %>>
            <label for="email_agr" class="choiceLabel">수신함</label>
            <input type="radio" id="email_no" name="email_agr" value="N" <%= session.getAttribute("email_agr").equals("N") ? "checked" : "" %>>
            <label for="email_no" class="choiceLabel">수신 안함</label>
          </div><br><br><br><br><br>


            <div id="check">
     <button id="edit">수정</button> <a id="delete" onclick="test()">회원탈퇴</a>
            </div>
      </div>
    </form>
</div>
<jsp:include page="footer.jsp" flush="false" />


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

    function formCheck() {
        var isPhn = newPhnCheck();
        if (!isPhn) {
            return false;
        }
        return confirm("변경사항을 마무리하시고 적용하시겠습니까?")
    }

    function newPhnCheck() {
        var newPhn = document.getElementById("c_phn").value;

        var newPhnPattern = /^[0-9]{11,12}$/;

        if (!newPhnPattern.test(newPhn)) {
            alert("휴대폰 번호는 숫자 11~12자로 입력이 가능합니다.")
            return false;
        }
        return true;
    }


function test(){
alert("테스트중입니다!")
}

</script>
</body>
</html>