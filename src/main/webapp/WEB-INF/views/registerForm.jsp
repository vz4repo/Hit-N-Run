<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.net.URLDecoder"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans&display=swap" rel="stylesheet">
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
            /* padding: 30%; */
            margin: 0 auto;
            margin-top: 50px;
            margin-bottom: 150px;
        }

        #msg {
            height: 30px;
            text-align: center;
            font-size: 14px;
            margin-bottom: 20px;
            font-weight: bold;
        }

        span {
            color: gray;
        }

        body {
            font-size: 11px;
        }

        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
        }

        .modal-content {
            background-color: #fefefe;
            margin: 5% auto 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 70%;
        }

        .modal-open {
            overflow: hidden;
        }

        #tou {
            color: black;
            text-decoration: underline;
            cursor: pointer;
        }

        #pii {
            color: black;
            text-decoration: underline;
            cursor: pointer;
        }

        #close,
        #close2 {
            font-size: 22px;
            float: right;
            cursor: pointer;
        }

        #toubox,
        #tou {
            display: inline;
        }

        #piibox,
        #pii {
            display: inline;
        }

        #roadAddress{
            width: 265.5px;
        }

        #jibunAddress{
            width: 265.5px;
        }

        #detailAddress{
            width: 265.5px;
        }
    </style>

</head>
<body>
<div id="myform">
    <div id="msg" class="msg"> ${URLDecoder.decode(param.msg, "utf-8")}</div>
    <form action ="<c:url value="/register/save"/>" method="POST" onsubmit="return formCheck(this)"/>

    <h1 id="loginTitle">Sign Up</h1>
        <div class="container">
            <label>이메일</label>
            <input class="special-class" type="text" name="c_email" placeholder="homerunball@run.com" autofocus>
            <label>인증번호</label>
            <input class="special-class" type="text" name="c_email2" placeholder="인증번호 6자리">
            <label>비밀번호</label>
            <input class="special-class" type="text" name="c_pwd" placeholder="영문/숫자 조합 (6자 이상)">
            <label>비밀번호 확인</label>
            <input class="special-class" type="text" name="c_pwd2" placeholder="영문/숫자 조합 (6자 이상)">
            <label>이름</label>
            <input class="special-class" type="text" name="c_nm">
            <label>주소</label>
            <input type="text" id="zip" name="c_zip" placeholder="우편번호">
            <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
            <input type="text" id="roadAddress" name="c_road_a" placeholder="도로명주소">
            <input type="text" id="jibunAddress" name ="c_jibun_a" placeholder="지번주소">
            <span id="guide" style="color:#999;display:none"></span>
            <input type="text" id="detailAddress" name="c_det_a" placeholder="상세주소">
            <input type="text" id="extraAddress" name ="c_ext_a" placeholder="참고항목"><br><br>

            <label>휴대폰</label>
            <input class="special-class" type="text" name="c_phn" placeholder="-제외">
                <label>성별</label>
                <input type="radio" id="female" name="c_gnd" value="woman"> 여성
                <input type="radio" id="male" name="c_gnd" value="man"> 남성<br><br>

                <label>생년월일</label>
                <select class="box" id="birth-year" name="birth-year">
                    <option disabled selected>출생 연도</option>
                </select>
                <select class="box" id="birth-month" name="birth-month">
                    <option disabled selected>월 선택</option>
                </select>
                <select class="box" id="birth-day" name="birth-day">
                    <option disabled selected>일 선택</option>
                </select><br><br>
            <input type="hidden" id="birth" name="c_birth">

            <input type="checkbox" id="touBox" name="touBox">
            <p id="tou">[필수] 이용약관</p>

            <br>
            <input type="checkbox" id="piiBox" name ="piiBox">
            <p id="pii">[필수] 개인정보 수집 및 이용</p><br>

            <input type="checkbox" name="sms_agr"> <a>[선택] 쇼핑정보 SMS 수신</a><br>
            <input type="checkbox" name="email_agr"> <a>[선택] 쇼핑정보 이메일 수신</a><br><br><br>

            <button>가입하기</button><br><br>
        </div>
<%--    </form:form>--%>
    </form>
<%--</div>--%>
</div>


<div id="myModal" class="modal">
    <div class="modal-content">
        <span id="close">&times;</span>
        <h3>홈런볼 이용약관</h3><br>
        <p>제1조(목적)</p>
        <p>이 약관은 홈런볼 회사(전자상거래 사업자)가 운영하는 홈런볼 사이버 몰(이하 “몰”이라 한다)에서 제공하는 인터넷 관련 서비스(이하 “서비스”라 한다)를 이용함에 있어
            사이버 몰과 이용자의 권리.의무 및 책임사항을 규정함을 목적으로 합니다.</p>
        <p>※「PC통신, 무선 등을 이용하는 전자상거래에 대해서도 그 성질에 반하지 않는 한 이 약관을 준용합니다.」</p><br>

        <p>제2조(정의)</p>

        <p>① “몰”이란 홈런볼 회사가 재화 또는 용역(이하 “재화 등”이라 함)을 이용자에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 재화 등을 거래할 수 있도록 설정한
            가상의 영업장을 말하며,
            아울러 사이버몰을 운영하는 사업자의 의미로도 사용합니다.</p>
        <p>② “이용자”란 “몰”에 접속하여 이 약관에 따라 “몰”이 제공하는 서비스를 받는 회원 및 비회원을 말합니다.
            ③ ‘회원’이라 함은 “몰”에 회원등록을 한 자로서, 계속적으로 “몰”이 제공하는 서비스를 이용할 수 있는 자를 말합니다.
            ④ ‘비회원’이라 함은 회원에 가입하지 않고 “몰”이 제공하는 서비스를 이용하는 자를 말합니다.</p><br>

        <p>제3조 (약관 등의 명시와 설명 및 개정)</p>

        <p>① “몰”은 이 약관의 내용과 상호 및 대표자 성명, 영업소 소재지 주소(소비자의 불만을 처리할 수 있는 곳의 주소를 포함), 전화번호.모사전송번호.전자우편주소, 사업자등록번호,
            통신판매업 신고번호, 개인정보보호책임자등을 이용자가 쉽게 알 수 있도록 홈런볼 사이버몰의 초기 서비스화면(전면)에 게시합니다.</p>
        <p>② “몰은 이용자가 약관에 동의하기에 앞서 약관에 정하여져 있는 내용 중 청약철회.배송책임.환불조건 등과 같은 중요한 내용을 이용자가 이해할 수 있도록 별도의 연결화면 또는 팝업화면 등을
            제공하여 이용자의 확인을 구하여야 합니다.</p>
        <p> ③ “몰”은 「전자상거래 등에서의 소비자보호에 관한 법률」, 「약관의 규제에 관한 법률」, 「전자문서 및 전자거래기본법」, 「전자금융거래법」, 「전자서명법」, 「정보통신망 이용촉진 및
            정보보호 등에 관한 법률」,
            「방문판매 등에 관한 법률」, 「소비자기본법」 등 관련 법을 위배하지 않는 범위에서 이 약관을 개정할 수 있습니다.</p>
        <p>④ “몰”이 약관을 개정할 경우에는 적용일자 및 개정사유를 명시하여 현행약관과 함께 몰의 초기화면에 그 적용일자 7일 이전부터 적용일자 전일까지 공지합니다.
            다만, 이용자에게 불리하게 약관내용을 변경하는 경우에는 최소한 30일 이상의 사전 유예기간을 두고 공지합니다.
            이 경우 “몰“은 개정 전 내용과 개정 후 내용을 명확하게 비교하여 이용자가 알기 쉽도록 표시합니다.</p>
        <p>⑤ “몰”이 약관을 개정할 경우에는 그 개정약관은 그 적용일자 이후에 체결되는 계약에만 적용되고 그 이전에 이미 체결된 계약에 대해서는 개정 전의 약관조항이 그대로 적용됩니다.
            다만 이미 계약을 체결한 이용자가 개정약관 조항의 적용을 받기를 원하는 뜻을 제3항에 의한 개정약관의 공지기간 내에 “몰”에 송신하여 “몰”의 동의를 받은 경우에는 개정약관 조항이
            적용됩니다.</p>
        <p>⑥ 이 약관에서 정하지 아니한 사항과 이 약관의 해석에 관하여는 전자상거래 등에서의 소비자보호에 관한 법률,
            약관의 규제 등에 관한 법률, 공정거래위원회가 정하는 전자상거래 등에서의 소비자 보호지침 및 관계법령 또는 상관례에 따릅니다.</p><br>

        <p>제4조(서비스의 제공 및 변경)</p>

        <p>① “몰”은 다음과 같은 업무를 수행합니다.</p>
        <p>1. 재화 또는 용역에 대한 정보 제공 및 구매계약의 체결</p>
        <p>2. 구매계약이 체결된 재화 또는 용역의 배송</p>
        <p>3. 기타 “몰”이 정하는 업무</p>
        <p>② “몰”은 재화 또는 용역의 품절 또는 기술적 사양의 변경 등의 경우에는 장차 체결되는 계약에 의해 제공할 재화 또는 용역의 내용을 변경할 수 있습니다.
            이 경우에는 변경된 재화 또는 용역의 내용 및 제공일자를 명시하여 현재의 재화 또는 용역의 내용을 게시한 곳에 즉시 공지합니다.</p>
        <p>③ “몰”이 제공하기로 이용자와 계약을 체결한 서비스의 내용을 재화등의 품절 또는 기술적 사양의 변경 등의 사유로 변경할 경우에는 그 사유를 이용자에게 통지 가능한 주소로 즉시
            통지합니다.</p>
        <p>④ 전항의 경우 “몰”은 이로 인하여 이용자가 입은 손해를 배상합니다. 다만, “몰”이 고의 또는 과실이 없음을 입증하는 경우에는 그러하지 아니합니다.</p><br>

        <p>제5조(서비스의 중단)</p>
        <p>① “몰”은 컴퓨터 등 정보통신설비의 보수점검.교체 및 고장, 통신의 두절 등의 사유가 발생한 경우에는 서비스의 제공을 일시적으로 중단할 수 있습니다.</p>
        <p>② “몰”은 제1항의 사유로 서비스의 제공이 일시적으로 중단됨으로 인하여 이용자 또는 제3자가 입은 손해에 대하여 배상합니다. 단, “몰”이 고의 또는 과실이 없음을 입증하는 경우에는
            그러하지 아니합니다.</p>
        <p>③ 사업종목의 전환, 사업의 포기, 업체 간의 통합 등의 이유로 서비스를 제공할 수 없게 되는 경우에는 “몰”은 제8조에 정한 방법으로 이용자에게 통지하고 당초 “몰”에서 제시한 조건에따라
            소비자에게 보상합니다. 다만, “몰”이 보상기준 등을 고지하지 아니한 경우에는 이용자들의 마일리지 또는 적립금 등을 “몰”에서 통용되는 통화가치에 상응하는 현물 또는 현금으로 이용자에게
            지급합니다.</p><br>

        <p>제6조(회원가입)</p>

        <p>① 이용자는 “몰”이 정한 가입 양식에 따라 회원정보를 기입한 후 이 약관에 동의한다는 의사표시를 함으로서 회원가입을 신청합니다.</p>
        <p> ② “몰”은 제1항과 같이 회원으로 가입할 것을 신청한 이용자 중 다음 각 호에 해당하지 않는 한 회원으로 등록합니다.</p>
        <p>1. 가입신청자가 이 약관 제7조제3항에 의하여 이전에 회원자격을 상실한 적이 있는 경우, 다만 제7조제3항에 의한 회원자격 상실 후 3년이 경과한 자로서 “몰”의 회원재가입 승낙을 얻은
            경우에는 예외로 한다.</p>
        <p>2. 등록 내용에 허위, 기재누락, 오기가 있는 경우</p>
        <p>3. 기타 회원으로 등록하는 것이 “몰”의 기술상 현저히 지장이 있다고 판단되는 경우</p>
        <p>③ 회원가입계약의 성립 시기는 “몰”의 승낙이 회원에게 도달한 시점으로 합니다.</p>
        <p>④ 회원은 회원가입 시 등록한 사항에 변경이 있는 경우, 상당한 기간 이내에 “몰”에 대하여 회원정보 수정 등의 방법으로 그 변경사항을 알려야 합니다.</p><br>

        <p>제7조(회원 탈퇴 및 자격 상실 등)</p>
        <p>① 회원은 “몰”에 언제든지 탈퇴를 요청할 수 있으며 “몰”은 즉시 회원탈퇴를 처리합니다.</p>
        <p>② 회원이 다음 각 호의 사유에 해당하는 경우, “몰”은 회원자격을 제한 및 정지시킬 수 있습니다.</p>
        <p>1. 가입 신청 시에 허위 내용을 등록한 경우</p>
        <p>2. “몰”을 이용하여 구입한 재화 등의 대금, 기타 “몰”이용에 관련하여 회원이 부담하는 채무를 기일에 지급하지 않는 경우</p>
        <p>3. 다른 사람의 “몰” 이용을 방해하거나 그 정보를 도용하는 등 전자상거래 질서를 위협하는 경우</p>
        <p>4. “몰”을 이용하여 법령 또는 이 약관이 금지하거나 공서양속에 반하는 행위를 하는 경우</p>
        <p>③ “몰”이 회원 자격을 제한.정지 시킨 후, 동일한 행위가 2회 이상 반복되거나 30일 이내에 그 사유가 시정되지 아니하는 경우 “몰”은 회원자격을 상실시킬 수 있습니다.</p>
        <p>④ “몰”이 회원자격을 상실시키는 경우에는 회원등록을 말소합니다. 이 경우 회원에게 이를 통지하고, 회원등록 말소 전에 최소한 30일 이상의 기간을 정하여 소명할 기회를 부여합니다.</p>
        <br>

        <p>제8조(회원에 대한 통지)</p>
        <p>① “몰”이 회원에 대한 통지를 하는 경우, 회원이 “몰”과 미리 약정하여 지정한 전자우편 주소로 할 수 있습니다.</p>
        <p>② “몰”은 불특정다수 회원에 대한 통지의 경우 1주일이상 “몰” 게시판에 게시함으로서 개별 통지에 갈음할 수 있습니다.</p>
        <p>다만, 회원 본인의 거래와 관련하여 중대한 영향을 미치는 사항에 대하여는 개별통지를 합니다.</p><br>

        <p>제9조(구매신청)</p>
        <p>① “몰”이용자는 “몰”상에서 다음 또는 이와 유사한 방법에 의하여 구매를 신청하며, “몰”은 이용자가 구매신청을 함에 있어서 다음의 각 내용을 알기 쉽게 제공하여야 합니다.</p>
        <p>1. 재화 등의 검색 및 선택</p>
        <p>2. 받는 사람의 성명, 주소, 전화번호, 전자우편주소(또는 이동전화번호) 등의 입력</p>
        <p>3. 약관내용, 청약철회권이 제한되는 서비스, 배송료.설치비 등의 비용부담과 관련한 내용에 대한 확인</p>
        <p>4. 이 약관에 동의하고 위 3.호의 사항을 확인하거나 거부하는 표시(예, 마우스 클릭)</p>
        <p>5. 재화등의 구매신청 및 이에 관한 확인 또는 “몰”의 확인에 대한 동의</p>
        <p>6. 결제방법의 선택</p>
        <p>② “몰”이 제3자에게 구매자 개인정보를 제공·위탁할 필요가 있는 경우 실제 구매신청 시 구매자의 동의를 받아야 하며, 회원가입 시 미리 포괄적으로 동의를 받지 않습니다.</p>
        <p>이 때 “몰”은 제공되는 개인정보 항목, 제공받는 자의 개인정보 이용 목적 및 보유·이용 기간 등을 구매자에게 명시하여야 합니다.</p>
        <p>다만 「정보통신망이용촉진 및 정보보호 등에 관한 법률」 제25조 제1항에 의한 개인정보 처리위탁의 경우 등 관련 법령에 달리 정함이 있는 경우에는 그에 따릅니다.</p><br>

        <p>제10조 (계약의 성립)</p>
        <p>① “몰”은 제9조와 같은 구매신청에 대하여 다음 각 호에 해당하면 승낙하지 않을 수 있습니다. 다만, 미성년자와 계약을 체결하는 경우에는 법정대리인의 동의를 얻지 못하면 미성년자 본인
            또는 법정대리인이 계약을 취소할 수 있다는 내용을 고지하여야 합니다.</p>
        <p>1. 신청 내용에 허위, 기재누락, 오기가 있는 경우</p>
        <p>2. 미성년자가 담배, 주류 등 청소년보호법에서 금지하는 재화 및 용역을 구매하는 경우</p>
        <p>3. 기타 구매신청에 승낙하는 것이 “몰” 기술상 현저히 지장이 있다고 판단하는 경우</p>
        <p>② “몰”의 승낙이 제12조제1항의 수신확인통지형태로 이용자에게 도달한 시점에 계약이 성립한 것으로 봅니다.</p>
        <p>③ “몰”의 승낙의 의사표시에는 이용자의 구매 신청에 대한 확인 및 판매가능 여부, 구매신청의 정정 취소 등에 관한 정보 등을 포함하여야 합니다.</p><br>

        <p> 제11조(지급방법)</p>
        <p>“몰”에서 구매한 재화 또는 용역에 대한 대금지급방법은 다음 각 호의 방법중 가용한 방법으로 할 수 있습니다. 단, “몰”은 이용자의 지급방법에 대하여 재화 등의 대금에 어떠한 명목의
            수수료도 추가하여 징수할 수 없습니다.</p>
        <p>1. 폰뱅킹, 인터넷뱅킹, 메일 뱅킹 등의 각종 계좌이체</p>
        <p>2. 선불카드, 직불카드, 신용카드 등의 각종 카드 결제</p>
        <p>3. 온라인무통장입금</p>
        <p>4. 전자화폐에 의한 결제</p>
        <p>5. 수령 시 대금지급</p>
        <p>6. 기타 전자적 지급 방법에 의한 대금 지급 등</p><br>

        <p>제12조(수신확인통지.구매신청 변경 및 취소)</p>
        <p>① “몰”은 이용자의 구매신청이 있는 경우 이용자에게 수신확인통지를 합니다.</p>
        <p>② 수신확인통지를 받은 이용자는 의사표시의 불일치 등이 있는 경우에는 수신확인통지를 받은 후 즉시 구매신청 변경 및 취소를 요청할 수 있고</p>
        <p>“몰”은 배송 전에 이용자의 요청이 있는 경우에는 지체 없이 그 요청에 따라 처리하여야 합니다.</p><br>

        <p>제13조(재화 등의 공급)</p>
        <p>① “몰”은 이용자와 재화 등의 공급시기에 관하여 별도의 약정이 없는 이상, 이용자가 청약을 한 날부터 7일 이내에 재화 등을 배송할 수 있도록 주문제작, 포장 등 기타의 필요한 조치를
            취합니다.</p>
        <p>다만, “몰”이 이미 재화 등의 대금의 전부 또는 일부를 받은 경우에는 대금의 전부 또는 일부를 받은 날부터 3영업일 이내에 조치를 취합니다.</p>
        <p>이때 “몰”은 이용자가 재화 등의 공급 절차 및 진행 사항을 확인할 수 있도록 적절한 조치를 합니다.</p>
        <p>② “몰”은 이용자가 구매한 재화에 대해 배송수단, 수단별 배송비용 부담자, 수단별 배송기간 등을 명시합니다.</p>
        <p>만약 “몰”이 약정 배송기간을 초과한 경우에는 그로 인한 이용자의 손해를 배상하여야 합니다.</p>
        <p>다만 “몰”이 고의.과실이 없음을 입증한 경우에는 그러하지 아니합니다.</p><br>

        <p>제14조(환급)</p>
        <p>“몰”은 이용자가 구매신청한 재화 등이 품절 등의 사유로 인도 또는 제공을 할 수 없을 때에는 지체 없이 그 사유를 이용자에게 통지하고 사전에 재화 등의 대금을 받은 경우에는
            대금을 받은 날부터 3영업일 이내에 환급하거나 환급에 필요한 조치를 취합니다.</p><br>

        <p>제15조(개인정보보호)</p>
        <p>① “몰”은 이용자의 개인정보 수집시 서비스제공을 위하여 필요한 범위에서 최소한의 개인정보를 수집합니다.
        <p>② “몰”은 회원가입시 구매계약이행에 필요한 정보를 미리 수집하지 않습니다. 다만, 관련 법령상 의무이행을 위하여 구매계약 이전에 본인확인이 필요한 경우로서 최소한의 특정 개인정보를
            수집하는 경우에는 그러하지 아니합니다.
        <p> ③ “몰”은 이용자의 개인정보를 수집·이용하는 때에는 당해 이용자에게 그 목적을 고지하고 동의를 받습니다.</p>
        <p>④ “몰”은 수집된 개인정보를 목적외의 용도로 이용할 수 없으며, 새로운 이용목적이 발생한 경우 또는 제3자에게 제공하는 경우에는 이용·제공단계에서 당해 이용자에게 그 목적을 고지하고
            동의를 받습니다. 다만, 관련 법령에 달리 정함이 있는 경우에는 예외로 합니다.
        <p>⑤ “몰”이 제2항과 제3항에 의해 이용자의 동의를 받아야 하는 경우에는 개인정보보호 책임자의 신원(소속, 성명 및 전화번호, 기타 연락처 ), 정보의 수집목적 및 이용목적, 제3자에 대한
            정보제공 관련사항(제공받은자, 제공목적 및 제공할 정보의 내용) 등「정보통신망 이용촉진 및 정보보호 등에 관한 법률」 제22조제2항이 규정한 사항을 미리 명시하거나 고지해야 하며 이용자는
            언제든지 이 동의를 철회할 수 있습니다.
        <p>⑥ 이용자는 언제든지 “몰”이 가지고 있는 자신의 개인정보에 대해 열람 및 오류정정을 요구할 수 있으며 “몰”은 이에 대해 지체 없이 필요한 조치를 취할 의무를 집니다.
            이용자가 오류의 정정을 요구한 경우에는 “몰”은 그 오류를 정정할 때까지 당해 개인정보를 이용하지 않습니다.</p>
        <p>⑦ “몰”은 개인정보 보호를 위하여 이용자의 개인정보를 처리하는 자를 최소한으로 제한하여야 하며 신용카드, 은행계좌 등을 포함한 이용자의 개인정보의 분실, 도난, 유출, 동의 없는
            제3자 제공, 변조 등으로 인한 이용자의 손해에 대하여 모든 책임을 집니다.</p>
        <p>⑧ “몰” 또는 그로부터 개인정보를 제공받은 제3자는 개인정보의 수집목적 또는 제공받은 목적을 달성한 때에는 당해 개인정보를 지체 없이 파기합니다.</p>
        <p>⑨ “몰”은 개인정보의 수집·이용·제공에 관한 동의란을 미리 선택한 것으로 설정해두지 않습니다.</p>
        <p>또한 개인정보의 수집·이용·제공에 관한 이용자의 동의거절시 제한되는 서비스를 구체적으로 명시하고, 필수수집항목이 아닌</p>
        <p>개인정보의 수집·이용·제공에 관한 이용자의 동의 거절을 이유로 회원가입 등 서비스 제공을 제한하거나 거절하지 않습니다.</p><br>

        <p>제16조(“몰“의 의무)</p>
        <p>① “몰”은 법령과 이 약관이 금지하거나 공서양속에 반하는 행위를 하지 않으며 이 약관이 정하는 바에 따라 지속적이고, 안정적으로 재화.용역을 제공하는데 최선을 다하여야 합니다.</p>
        <p>② “몰”은 이용자가 안전하게 인터넷 서비스를 이용할 수 있도록 이용자의 개인정보(신용정보 포함)보호를 위한 보안 시스템을 갖추어야 합니다.</p>
        <p>③ “몰”이 상품이나 용역에 대하여 「표시.광고의 공정화에 관한 법률」 제3조 소정의 부당한 표시.광고행위를 함으로써 이용자가 손해를 입은 때에는 이를 배상할 책임을 집니다.</p>
        <p>④ “몰”은 이용자가 원하지 않는 영리목적의 광고성 전자우편을 발송하지 않습니다.</p><br>

        <p>제17조(회원의 ID 및 비밀번호에 대한 의무)</p>
        <p>① 제15조의 경우를 제외한 ID와 비밀번호에 관한 관리책임은 회원에게 있습니다.</p>
        <p>② 회원은 자신의 ID 및 비밀번호를 제3자에게 이용하게 해서는 안됩니다.</p>
        <p>③ 회원이 자신의 ID 및 비밀번호를 도난당하거나 제3자가 사용하고 있음을 인지한 경우에는 바로 “몰”에 통보하고 “몰”의 안내가 있는 경우에는 그에 따라야 합니다.</p><br>

        <p>제18조(이용자의 의무)</p>
        <p>이용자는 다음 행위를 하여서는 안 됩니다.</p>
        <p>1. 신청 또는 변경시 허위 내용의 등록</p>
        <p>2. 타인의 정보 도용</p>
        <p>3. “몰”에 게시된 정보의 변경</p>
        <p>4. “몰”이 정한 정보 이외의 정보(컴퓨터 프로그램 등) 등의 송신 또는 게시</p>
        <p>5. “몰” 기타 제3자의 저작권 등 지적재산권에 대한 침해</p>
        <p>6. “몰” 기타 제3자의 명예를 손상시키거나 업무를 방해하는 행위</p>
        <p>7. 외설 또는 폭력적인 메시지, 화상, 음성, 기타 공서양속에 반하는 정보를 몰에 공개 또는 게시하는 행위</p><br>

        <p>(부칙) 2024년 04월 22일부터 시행합니다. (2024.04.22 개정)</p>
    </div>
</div>

<div id="myModal2" class="modal">
    <div class="modal-content">
        <span id="close2">&times;</span>
        <h3>홈런볼 개인정보 수집 및 이용</h3><br>

        <p>(주)홈런볼은 고객님의 개인정보를 중요시하며, “정보통신망 이용촉진 및 정보보호” 에 관한 법률을 준수하고 있습니다.</p>
        <p>회사는 개인정보취급방침을 통하여 고객님께서 제공하는 개인정보가 어떠한 용도와 방식으로 이용되고 있으며, 개인정보호를 위해 어떠한 조치가 취해지고 있는지 알려드립니다.</p><br>

        <p>제 1조 수집하는 개인정보 항목</p>

        <p>* 회사는 회원가입, 상담, 서비스 신청 등을 위해 아래와 같은 개인정보를 수집하고 있습니다.</p>

        <p>회원가입시 : 이름, 이메일(로그인 ID), 비밀번호, 휴대전화번호(개인인증)</p>
        <p>서비스 신청시 : 주소, 전화번호, 결제정보</p>

        <p>* 서비스 이용 과정이나 사업처리 과정에서 서비스이용기록, 접속로그, 쿠키, 접속IP, 결제기록이 생성되어 수집될 수 있습니다.</p><br>


        <p>제 2조 개인정보의 수집 및 이용목적</p>

        <p>회사는 수집한 개인정보를 다음의 목적을 위해 활용합니다.</p>

        <p>* 서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산</p>

        <p>콘텐츠 제공, 구매 및 요금결제, 물품배송 청구지 등 발송, 금융거래 본인인증 및 금융서비스</p>

        <p>* 회원관리</p>
        <p>회원제 서비스 이용에 따른 본인확인, 개인식별, 불량회원의 부정이용 방지와 비인가 사용방지</p>
        <p>가입의사 확인, 연령확인, 만14세 미만 아동 개인정보 수집 시 법정대리인 동의여부 확인</p>
        <p>불만처리 등 민원처리, 고지사항 전달</p>
        <p>* 마케팅 및 광고에 활용</p>
        <p>이벤트 등 광고성 정보전달, 접속 빈도 파악 또는 회원의 서비스 이용에 대한 통계</p><br>

        <p>제 3조 개인정보의 보유 및 이용기간</p>
        <p>원칙적으로 개인정보 수집 및 이용목적이 달성된 후에는 해당정보를 지체없이 파기합니다.</p>
        <p>제 3조 개인정보의 파기절차 및 방법</p>
        <p>회사는 원칙적으로 개인정보 수집 및 이용목적이 달성된 후에는 해당정보를 지체없이 파기합니다. 파기절차 및 방법은 다음과 같습니다.</p>
        <p>* 파기절차</p>
        <p>회원님이 회원가입 등을 위해 입력하신 정보는 목적이 달성된 후 별도의 DB로 옮겨져 내부 방침 및 기타관련 법령에 의한 정보보호 사유에 따라(보유 및 이용기간 참조) 일정 기간 저장 된
            후 파기되어 집니다.</p>
        <p>* 파기방법</p>
        <p>전자적 파일형태로 저장된 개인정보는 기록을 재생할 수 없는 기술적 방법을 사용하여 삭제</p><br>

        <p>제 4조 개인정보 제공</p>
        <p>회사는 이용자의 개인정보를 원칙적으로 외부에 지공하지 않습니다. 다만, 아래의 경우 예외로 합니다.</p>
        <p>* 이용자들이 사전에 동의한 경우</p>
        <p>* 법령의 규정에 의거하거나, 수사목적으로 법령에 정해진 절차와 방법에 따라 수사기관의 요구가 있는 경우</p><br>
        <p>제 5조 수집한 개인정보의 위탁</p>
        <p>회사는 서비스 이행을 위해 아래와 같이 외부 전문업체에 위탁하여 운영하고 있습니다.</p>
        <p>* 위탁대상자: 택배사</p>
        <p>* 위탁업무 내용: 택배사 위탁내용</p>
        <p>* 위탁대상자: 입점사(파트너사)</p>
        <p>* 위탁업무 내용: 입점사(파트너사) 제품 구매 시 구매정보</p>
        <p> * 위탁대상자: PG사</p>
        <p> * 위탁업무 내용: PG사 위탁내용</p><br>


        <p> 제 6조 이용자 및 법정대리인의 권리와 그 행사방법</p>
        <p> * 이용자는 언제든지 등록되어 있는 자신의 개인정보를 조회하거나 수정할 수 있으며,가입해지를 요청할 수도 있습니다.</p>
        <p> * 이용자들의 개인정보 조회, 수정을 위해서는 “개인정보변경”(또는 “회원정보수정” 등)을 가입해지(동의철회)를 위해서는 “회원탈퇴”를 클릭하여 본인 확인절차를 거치신 후 직접 열람,
            정정 또는 탈퇴가 가능합니다.</p>
        <p> * 혹은 개인정보관리책임자에게 서면, 전화 또는 이메일로 연락을 통한 조치</p>
        <p>* 귀하가 개인정보의 오류에 대한 정정을 요청하신 경우 정정을 완료하기 전까지 당해 개인정보를 이용 또는 제공하지 않습니다. 또한 잘못된 개인정보를 제3자에게 이미 제공한 경우 정정
            처리결과를 제3자에게 지체없이 통지하여 정정이 이루어지도록 합니다.</p>
        <p>* 회사는 이용자의 요청에 의해 해지 또는 삭제된 개인정보는 “회사가 수집하는 개인정보의 보유 및 이용기간”에 명시된 바에 따라 처리하고 그 외의 용도로 열람 또는 이용할 수 없도록
            처리하고 있습니다.</p><br>

        <p>제 7조 개인정보의 안전성 확보조치에 관한 사항</p>
        <p>1. 내부관리계획의 수립 및 시행</p>
        <p>회사의 내부관리계획 수립 및 시행은 방송통신위원회 고시를 준수하여 시행합니다.</p>
        <p>2. 개인정보취급자의 최소화 및 교육</p>
        <p>개인정보를 취급하는 담당자를 최소화하며 담당자에 대한 수시 교육을 통해 개인정보를 안전하게 관리하고 있습니다.</p>
        <p>3. 개인정보에 대한 접근제한</p>
        <p>개인정보를 처리하는 데이터베이스시스템에 대한 접근권한의 부여, 변경, 말소를 통하여 개인정보에 대한 접근통제에 필요한 조치를 하고 있습니다.</p>
        <p>4. 개인정보의 암호화</p>
        <p>이용자의 중요 개인정보는 암호화 되어 저장 및 관리되고 있으며, 중요한 데이터는 저장 및 전송 시 암호화하여 사용하는 등의 별도 보안기능을 사용하고 있습니다.</p>
    </div>
</div>


<script>
    function birthUpdate() {
        var birthYearSelect = document.getElementById('birth-year');
        var birthMonthSelect = document.getElementById('birth-month');
        var birthDaySelect = document.getElementById('birth-day');

        var birthYear = birthYearSelect.value;
        var birthMonth = birthMonthSelect.value;
        var birthDay = birthDaySelect.value;

        var birth = birthYear + '-' + birthMonth + '-' + birthDay;

        /*hidden input 요소에 값 설정*/
        document.getElementById('birth').value = birth;
    }

    function xxxx(selectElement, start, end) {
        for (var i = start; i <= end; i++) {
            var option = document.createElement('option');
            option.value = i;
            option.textContent = i;
            selectElement.appendChild(option);
        }
    }

    xxxx(document.getElementById('birth-year'), 1950, 2024);
    xxxx(document.getElementById('birth-month'), 1, 12);
    xxxx(document.getElementById('birth-day'), 1, 31);

    document.getElementById('birth-year').addEventListener('change', birthUpdate);
    document.getElementById('birth-month').addEventListener('change', birthUpdate);
    document.getElementById('birth-day').addEventListener('change', birthUpdate);
    /*페이지 로드 후 초기 값 설정*/
    birthUpdate();


    /*2. 이용약관 모달*/
    document.getElementById("tou").addEventListener("click", function () {
        document.getElementById("myModal").style.display = "block";
        /*모달이 나타날 때 스크롤바 숨김*/
        document.body.classList.add("modal-open");
    });

    /*모달 창 닫기*/
    document.getElementById("close").addEventListener("click", function () {
        document.getElementById("myModal").style.display = "none";
        /*모달이 사라질 때 스크롤바 다시 보이게 함*/
        document.body.classList.remove("modal-open");
    });


    document.getElementById("pii").addEventListener("click", function () {
        document.getElementById("myModal2").style.display = "block";
        /*모달이 나타날 때 스크롤바 숨김*/
        document.body.classList.add("modal-open");
    });

    /*모달 창 닫기*/
    document.getElementById("close2").addEventListener("click", function () {
        document.getElementById("myModal2").style.display = "none";
        /*모달이 사라질 때 스크롤바 다시 보이게 함*/
        document.body.classList.remove("modal-open");
    });

    /*3. 회원가입 유효성 검사*/

    function formCheck(frm) {
        var msg = '';

        if (frm.c_email.value.length < 3) {
            setMessage('이메일의 길이는 3자 이상이어야 합니다.', frm.c_email);
            return false;
        }
        return true;
    }
    function setMessage(msg, element){
        document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle"> ${'${msg}'}</i>`;

        if(element) {
            element.select();
        }
    }

</script>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    /*본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.*/
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function (data) {
                /*팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.*/

                /*도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.*/
                var roadAddr = data.roadAddress;
                var extraRoadAddr = '';

                /*법정동명이 있을 경우 추가한다. (법정리는 제외)
                법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.*/
                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                    extraRoadAddr += data.bname;
                }
                /*건물명이 있고, 공동주택일 경우 추가한다.*/
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
</script>

</body>

</html>