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
    <title>ProductBasicInformation</title>
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
    <h1>기본 정보 일괄변경</h1>
    <form id="registerForm" action="<c:url value='/admin/product/manage'/>" method="post">
        <div class="product_content">
            <table style="width:100%">
                <tr>
                    <th colspan="2">
                        총 <strong>${selectedProductCount}</strong>개 제품의 기본 정보를 일괄 변경합니다.
                    </th>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="checkbox" id="selectAll"><label for="selectAll">전체 선택</label>
                    </th>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="productName" value="pd_name"><label for="productName">제품명</label></th>
                    <td>
                        <input type="text" name="pd_name" class="pdNameCnt" maxlength="100" placeholder="하타케야마 포수미트 M2 양의지 강민호 스펙 글러브 블루/블랙/레드 H29" >
                        <span id="pdNameCnt">[0 / 100]</span>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="modelName" value="mdl_name"><label for="modelName">모델명</label></th>
                    <td>
                        <input type="text" name="mdl_name" class="modelNameCnt" maxlength="100" placeholder="하타케야마 포수미트" >
                        <span id="modelNameCnt">[0 / 100]</span>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="sportsType" value="sprt_type_cd"><label for="sportsType">스포츠 유형</label></th>
                    <td>
                        <select name="sprt_type_cd">
                            <option value="BASE">경식</option>
                            <option value="SOFT">연식</option>
                            <option value="CASL">캐주얼</option>
                            <option value="TRA">훈련용</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="originalProductNum" value="og_pd_num"><label for="originalProductNum">자체 제품 코드</label></th>
                    <td>
                        <input type="text" name="og_pd_num" class="originProductNum" maxlength="100" >
                        <span id="originProductNum">[0 / 100]</span>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="productQuality" value="qlt_cd"><label for="productQuality">제품 상태</label></th>
                    <td>
                        <select name="qlt_cd" >
                            <option value="NEW">신제품</option>
                            <option value="USE">중고제품</option>
                            <option value="REF">리퍼제품</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="productAdComment" value="pd_ad_cmt"><label for="productAdComment">제품 홍보문구</label></th>
                    <td>
                        <input type="text" name="pd_ad_cmt" class="productAdCommentCnt" size="50" maxlength="100" id="adComment" style="width: inherit" />
                        <span id="productAdCommentCnt">[0 / 100]</span>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="origin" value="origin"><label for="origin">제조국</label></th>
                    <td>
                        <input type="text" name="origin" >
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="manufacturer" value="mfr"><label for="manufacturer">제조사</label></th>
                    <td>
                        <input type="text" name="mfr" >
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="series" value="srs_id"><label for="series">시리즈</label></th>
                    <td>
                        <input type="text" name="srs_id" class="seriesIdCnt" maxlength="100" >
                        <span id="seriesIdCnt">[0 / 100]</span>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="ageGroup" value="age_grp_cd"><label for="ageGroup">사용 연령대</label></th>
                    <td>
                        <input type='radio' id="adult" name='age_grp_cd' value='ADL' />
                        <label for="adult">성인</label>
                        <input type='radio' id="youth" name='age_grp_cd' value="YOU"/>
                        <label for="youth">유소년</label>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="playerName" value="player_name"><label for="playerName">사용 선수명</label></th>
                    <td>
                        <input type="text" name="player_name" maxlength="50" />
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="material" value="mtrl"><label for="material">제품 소재</label></th>
                    <td>
                        <input type="text" name="mtrl" class="materialCnt" maxlength="100" >
                        <span id="materialCnt">[0 / 100]</span>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="season" value="season"><label for="season">시즌</label></th>
                    <td>
                        <input type="text" name="season" maxlength="10" >
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="weight" value="weight"><label for="weight">무게(g)</label></th>
                    <td>
                        <input type="text" name="wgh" class="weightCnt" maxlength="100" >
                        <span id="weightCnt">[0 / 100]</span>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="color" value="clr_cd"><label for="color">색깔 코드</label></th>
                    <td>
                        <select id="clr_cd" name="clr_cd">
                            <option value="00">흰색</option>
                            <option value="01">흰색_회색</option>
                            <option value="02">흰색_검은색</option>
                            <option value="03">흰색_분홍색</option>
                            <option value="04">흰색_빨간색</option>
                            <option value="05">흰색_주황색</option>
                            <option value="06">흰색_노란색</option>
                            <option value="07">흰색_초록색</option>
                            <option value="08">흰색_파란색</option>
                            <option value="09">흰색_보라색</option>
                            <option value="10">회색</option>
                            <option value="11">회색_검은색</option>
                            <option value="12">회색_분홍색</option>
                            <option value="13">회색_빨간색</option>
                            <option value="14">회색_주황색</option>
                            <option value="15">회색_노란색</option>
                            <option value="16">회색_초록색</option>
                            <option value="17">회색_파란색</option>
                            <option value="18">회색_보라색</option>
                            <option value="20">검은색</option>
                            <option value="21">검은색_분홍색</option>
                            <option value="22">검은색_빨간색</option>
                            <option value="23">검은색_주황색</option>
                            <option value="24">검은색_노란색</option>
                            <option value="25">검은색_초록색</option>
                            <option value="26">검은색_파란색</option>
                            <option value="27">검은색_보라색</option>
                            <option value="30">분홍색</option>
                            <option value="31">분홍색_빨간색</option>
                            <option value="32">분홍색_주황색</option>
                            <option value="33">분홍색_노란색</option>
                            <option value="34">분홍색_초록색</option>
                            <option value="35">분홍색_파란색</option>
                            <option value="36">분홍색_보라색</option>
                            <option value="40">빨간색</option>
                            <option value="41">빨간색_주황색</option>
                            <option value="42">빨간색_노란색</option>
                            <option value="43">빨간색_초록색</option>
                            <option value="44">빨간색_파란색</option>
                            <option value="45">빨간색_보라색</option>
                            <option value="50">주황색</option>
                            <option value="51">주황색_노란색</option>
                            <option value="52">주황색_초록색</option>
                            <option value="53">주황색_파란색</option>
                            <option value="54">주황색_보라색</option>
                            <option value="60">노란색</option>
                            <option value="61">노란색_초록색</option>
                            <option value="62">노란색_파란색</option>
                            <option value="63">노란색_보라색</option>
                            <option value="70">초록색</option>
                            <option value="71">초록색_파란색</option>
                            <option value="72">초록색_보라색</option>
                            <option value="80">파란색</option>
                            <option value="81">파란색_보라색</option>
                            <option value="89">남색</option>
                            <option value="90">보라색</option>
                            <option value="91">금색</option>
                            <option value="92">금색_검은색</option>
                            <option value="98">탄색</option>
                            <option value="99">갈색</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="productSummary" value="pd_smr_dsc"><label for="productSummary">제품 요약 설명</label></th>
                    <td>
                        <input type="text" name="pd_smr_dsc" size="50" maxlength="200" id="textSummary" style="width: inherit" />
                        <span id="summaryLengthCheck">[0 / 200]</span>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="pd_det_dsc" value="pd_smr_dsc"><label for="pd_det_dsc">제품 상세 설명</label></th>
                    <td>
                        <textarea name="pd_det_dsc" id = "textDescription" style="resize: none" maxlength="5000" ></textarea>
                        <span id="descriptionLengthCheck">[0 / 5000]</span>
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
        /*제품명 글자 수 세기*/
        $(".pdNameCnt").keyup(function() {
            let content = $(this).val();
            $("#pdNameCnt").text("[" + content.length + " / 100]"); /* 실시간 글자수 카운팅 */
            if (content.length > 100) {
                alert("최대 100자까지 입력 가능합니다.");
                $(this).val(content.substring(0, 100));
                $('#pdNameCnt').text("[100 / 100]");
            }
        });

        /*모델명 글자 수 세기*/
        $(".modelNameCnt").keyup(function() {
            let content = $(this).val();
            $("#modelNameCnt").text("[" + content.length + " / 100]"); /* 실시간 글자수 카운팅 */
            if (content.length > 100) {
                alert("최대 100자까지 입력 가능합니다.");
                $(this).val(content.substring(0, 100));
                $('#modelNameCnt').text("[100 / 100]");
            }
        });

        /*자체 제품 코드 글자 수 세기*/
        $(".originProductNum").keyup(function() {
            let content = $(this).val();
            $("#originProductNum").text("[" + content.length + " / 100]"); /* 실시간 글자수 카운팅 */
            if (content.length > 100) {
                alert("최대 100자까지 입력 가능합니다.");
                $(this).val(content.substring(0, 100));
                $('#originProductNum').text("[100 / 100]");
            }
        });

        /*제품 홍보문구 글자 수 세기*/
        $(".productAdCommentCnt").keyup(function() {
            let content = $(this).val();
            $("#productAdCommentCnt").text("[" + content.length + " / 100]"); /* 실시간 글자수 카운팅 */
            if (content.length > 100) {
                alert("최대 100자까지 입력 가능합니다.");
                $(this).val(content.substring(0, 100));
                $('#productAdCommentCnt').text("[100 / 100]");
            }
        });

        /*시리즈 글자 수 세기*/
        $(".seriesIdCnt").keyup(function() {
            let content = $(this).val();
            $("#seriesIdCnt").text("[" + content.length + " / 100]"); /* 실시간 글자수 카운팅 */
            if (content.length > 100) {
                alert("최대 100자까지 입력 가능합니다.");
                $(this).val(content.substring(0, 100));
                $('#seriesIdCnt').text("[100 / 100]");
            }
        });

        /*제품 소재 글자 수 세기*/
        $(".materialCnt").keyup(function() {
            let content = $(this).val();
            $("#materialCnt").text("[" + content.length + " / 100]"); /* 실시간 글자수 카운팅 */
            if (content.length > 100) {
                alert("최대 100자까지 입력 가능합니다.");
                $(this).val(content.substring(0, 100));
                $('#materialCnt').text("[100 / 100]");
            }
        });

        /*무게 글자 수 세기*/
        $(".weightCnt").keyup(function() {
            let content = $(this).val();
            $("#weightCnt").text("[" + content.length + " / 100]"); /* 실시간 글자수 카운팅 */
            if (content.length > 100) {
                alert("최대 100자까지 입력 가능합니다.");
                $(this).val(content.substring(0, 100));
                $('#weightCnt').text("[100 / 100]");
            }
        });

        /*홍보 문구의 길이가 100자가 넘지 않도록 제한하는 함수*/
        $("#adComment").keyup(function() {
            let content = $(this).val();
            $("#adLengthCheck").text("[" + content.length + " / 100]"); /* 실시간 글자수 카운팅 */
            if (content.length > 100) {
                alert("최대 100자까지 입력 가능합니다.");
                $(this).val(content.substring(0, 100));
                $('#adLengthCheck').text("[100 / 100]");
            }
        });

        /*제품 요약의 텍스트 길이가 200자가 넘지 않도록 하는 함수*/
        $("#textSummary").keyup(function() {
            let content = $(this).val();
            $("#summaryLengthCheck").text("[" + content.length + " / 200]"); /* 실시간 글자수 카운팅 */
            if (content.length > 200) {
                alert("최대 200자까지 입력 가능합니다.");
                $(this).val(content.substring(0, 200));
                $('#summaryLengthCheck').text("[200 / 200]");
            }
        });

        /*상품 상세 설명의 텍스트 길이가 5000자가 되지 않도록 제한하는 함수*/
        $("#textDescription").keyup(function() {
            let content = $(this).val();
            $("#descriptionLengthCheck").text("[" + content.length + " / 5000]"); /* 실시간 글자수 카운팅 */
            if (content.length > 5000) {
                alert("최대 5000자까지 입력 가능합니다.");
                $(this).val(content.substring(0, 5000));
                $('#descriptionLengthCheck').text("[0 / 5000]");
            }
        });

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

        $("#registerBtn").on("click",function(event){
            let checked = $("input[name=selectedContent]:checked").length;
            if (checked == 0) {
                alert("하나 이상의 항목을 선택해주세요.");
                event.preventDefault();
            }

            /*아무것도 선택하지 않았으면 값을 입력해달라고 경고창 띄우기*/
        });

        let selectedContent = {};
        $('input:checkbox[name="selectedContent"]').each(function() {
            if (this.checked) {
                selectedContent[$(this).attr('id')] = $('input[name="' + $(this).attr('id') + '"]:checked').val();
            }
        });
    });

    // 취소 버튼 클릭하면 뒤로 가기
    document.getElementById("cancelBtn").addEventListener("click", function() {
        window.history.back();
    });
</script>
</script>
</body>
</html>