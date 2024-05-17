<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        <%@include file="/resources/css/adminMenu.css"%>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: left;
        }

        strong {
            font-weight: bold;
            color: #1b64da;
        }

        textarea {
            width: 100%;
            height: 200px;
        }
    </style>
    <title>ProductExposure</title>
    <% String msg = (String) request.getAttribute("msg"); %>
    <% if (msg != null && !msg.isEmpty()) { %>
    <script>
        alert("<%= msg %>");
    </script>
    <% } %>
</head>
<body>
<jsp:include page="../../adminMenu.jsp" flush="false" />
<div class="main">
    <h1>표시설정 일괄변경</h1>
    <form id="registerForm" action="<c:url value='/admin/product/manage'/>" method="post">
        <div class="product_content">
            <table style="width:100%">
                <tr>
                    <th colspan="2">
                        총 <strong>${selectedProductCount}</strong>개 제품의 표시설정을 일괄 변경합니다.
                    </th>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="checkbox" id="selectAll"><label for="selectAll">전체 선택</label>
                    </th>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="productShow" value="pd_is_show"><label for="productShow">진열 상태</label></th>
                    <td>
                        <input type='radio' id="onShow" name='pd_is_show' value='Y' />
                        <label for="onShow">진열하기</label>
                        <input type='radio' id="noShow" name='pd_is_show' value='N' />
                        <label for="noShow">진열제외</label>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="productStatus" value="pd_stat_hist_cd"><label for="productStatus">판매 상태</label></th>
                    <td>
                        <input type='radio' id="planSale" name='pd_stat_hist_cd' value='planSale' />
                        <label for="planSale">판매 예정</label>
                        <input type='radio' id="onSale" name='pd_stat_hist_cd' value='onSale' />
                        <label for="onSale">판매 중</label>
                        <input type='radio' id="notSale" name='pd_stat_hist_cd' value='notSale' />
                        <label for="notSale">판매 안 함</label>
                    </td>
                </tr>
                <tr>
                    <th>
                        <input type="checkbox" name="selectedContent" id="category" value="pd_type_cd,pd_type_det_cd,brd_cd"><label for="category">제품분류 선택</label>
                    </th>
                    <td>
                        <label for="pd_type_cd">제품 유형</label>
                        <select id="pd_type_cd" name="pd_type_cd">
                            <option value="GLV">글러브</option>
                            <option value="PRO">보호장비</option>
                            <option value="OGL">장갑</option>
                            <option value="ACC">액세서리</option>
                            <option value="BAT">배트</option>
                            <option value="APP">의류</option>
                            <option value="BAL">야구공</option>
                            <option value="SHO">야구화</option>
                        </select>

                        <label for="pd_type_det_cd">제품 상세 유형</label>
                        <select id="pd_type_det_cd" name="pd_type_det_cd">
                            <option value="CAT">포수</option>
                            <option value="INF">내야수</option>
                            <option value="FIR">1루수</option>
                            <option value="PIT">투수</option>
                            <option value="OTF">외야수</option>
                            <option value="BTR">타자</option>
                            <option value="UMP">심판</option>
                            <option value="DEF">수비</option>
                            <option value="SLD">슬라이딩</option>
                            <option value="NEC">목걸이</option>
                            <option value="HAT">모자</option>
                            <option value="FST">사계절상의</option>
                            <option value="FSB">사계절하의</option>
                            <option value="WTT">겨울용상의</option>
                            <option value="WTB">겨울용하의</option>
                            <option value="SMT">여름용상의</option>
                            <option value="SMB">여름용하의</option>
                            <option value="UNF">유니폼</option>
                            <option value="OTR">아우터</option>
                            <option value="SPK">스파이크 야구화</option>
                            <option value="TRF">인조잔디 야구화</option>
                        </select>

                        <label for="brd_cd">브랜드</label>
                        <select id="brd_cd" name="brd_cd" >
                            <option value="GLD">골드</option>
                            <option value="KBT">구보타슬러거</option>
                            <option value="NB">뉴발란스</option>
                            <option value="DVD">다비드</option>
                            <option value="DST">데상트</option>
                            <option value="RAW">롤링스</option>
                            <option value="MOR">모리모토</option>
                            <option value="MIZ">미즈노</option>
                            <option value="BKP">백퍼센트</option>
                            <option value="VL">볼레</option>
                            <option value="SSK">사사키</option>
                            <option value="SKL">스카이라인</option>
                            <option value="STM">스톰</option>
                            <option value="WLP">월드페가수스</option>
                            <option value="IPS">아이피셀렉트</option>
                            <option value="ACS">아식스</option>
                            <option value="ATM">아톰즈</option>
                            <option value="UA">언더아머</option>
                            <option value="WIL">윌슨</option>
                            <option value="EVO">이보쉴드</option>
                            <option value="IKJ">인코자바</option>
                            <option value="ZET">제트</option>
                            <option value="GF">지폼</option>
                            <option value="PRS">프로스펙스</option>
                            <option value="TTM">투더문</option>
                            <option value="HD">하데나</option>
                            <option value="HTK">하타케야마</option>
                            <option value="44G">44글러브</option>
                            <option value="ETC">기타</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="productCharacter" value="pd_chr_cd"><label for="productCharacter">제품 특성</label></th>
                    <td>
                        <input type="checkbox" id="npd" name="pd_chr_cd" value="N">
                        <label for="npd">신상품</label><br>
                        <input type="checkbox" id="hpd" name="pd_chr_cd" value="H">
                        <label for="hpd">인기 제품</label><br>
                        <input type="checkbox" id="spd" name="pd_chr_cd" value="S">
                        <label for="spd">스테디 셀러</label><br>
                        <input type="checkbox" id="rpd" name="pd_chr_cd" value="R">
                        <label for="rpd">추천 제품</label><br>
                        <input type="hidden" name="pd_chr_cd" value="">
                    </td>
                </tr>
            </table>
            <input type="hidden" name="productList" value="${productList}">
            <input type="hidden" name="selectedContent" value="${selectedContent}">
        </div>
        <div class="buttons">
            <button type="submit" class="registerBtn" id="registerBtn">선택항목 일괄변경</button>
            <button type="button" class="cancelBtn" id="cancelBtn">취소</button>
        </div>
    </form>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
    $(document).ready(function() {
        /*전체 선택을 클릭하는 경우 발생하는 함수*/
        $("#selectAll").click(function() {
            /*전체 선택이 체크되어 있다면 나머지 체크박스도 체크되게 한다.*/
            if($("#selectAll").is(":checked")) $("input[name=selectedContent]").prop("checked", true);
            /*그렇지 않다면 나머지 체크박스가 체크되지 않게 한다.*/
            else $("input[name=selectedContent]").prop("checked", false);
        });

        /*체크 박스 하나만을 선택했을 때 발생하는 함수*/
        $("input[name=selectedContent]").click(function() {
            /*total에 체크박스의 전체 개수를 저장한다.*/
            let total = $("input[name=selectedContent][type=checkbox]").length;
            /*checked에 체크가 된 체크박수의 개수를 저장한다.*/
            let checked = $("input[name=selectedContent]:checked").length;

            /*전체 체크박스의 수와 체크된 체크박스의 개수가 다르면 전체 선택이 체크되지 않게 한다.*/
            if(total != checked) $("#selectAll").prop("checked", false);
            /*전체 체크박스의 수와 체크된 체크박스의 개수가 동일하다면 전체 선택이 체크되게 한다.*/
            else $("#selectAll").prop("checked", true);
        });

        /*아무것도 선택하지 않았으면 값을 입력해달라고 경고창 띄우기*/
        $("#registerBtn").on("click",function(event){
            let checked = $("input[name=selectedContent]:checked").length;
            if (checked == 0) {
                alert("하나 이상의 항목을 선택해주세요.");
                event.preventDefault();
            }
        });

        /*선택된 항목들의 데이터를 저장할 selectedContent를 선언한다.*/
        let selectedContent = {};
        /*name 속성이 selectedContent인 체크박스를 반복한다.*/
        $('input:checkbox[name="selectedContent"]').each(function() {
            /*만약 체크박스가 체크되어 있다면*/
            if (this.checked) {
                /*체크된 체크박스의 id속성을 키로 사용하여 selectedContent 객체에 값을 추가한다.*/
                /*이 때 해당 id를 가진 라디오 버튼 중 체크된 값(value)을 가져와서 저장한다.*/
                selectedContent[$(this).attr('id')] = $('input[name="' + $(this).attr('id') + '"]:checked').val();
            }
        });
    });

    // 취소 버튼 클릭하면 뒤로 가기
    document.getElementById("cancelBtn").addEventListener("click", function() {
        window.history.back();
    });
</script>
</body>
</html>