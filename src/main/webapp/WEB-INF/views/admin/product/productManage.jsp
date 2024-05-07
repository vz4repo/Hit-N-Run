<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style><%@include file="/resources/css/adminMenu.css"%></style>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: left;
        }
    </style>
    <title>제품 관리 페이지</title>
    <% String msg = (String) request.getAttribute("msg"); %>
    <% if (msg != null && !msg.isEmpty()) { %>
    <script>
        alert("<%= msg %>");
    </script>
    <% } %>
</head>
<body>
<jsp:include page="../adminMenu.jsp" flush="false" />
<div class="main">
    <h1>제품 관리 페이지</h1>
        <table>
            <tr>
                <td colspan="12">[총 ${productCount}개]</td>
            </tr>
            <tr>
                <td colspan="12">
                    <select id="productNumber" name="productNumber">
                        <option value="selectedProduct">선택한 제품의</option>
                        <option value="allProduct">검색 결과 전체 제품의</option>
                    </select>
                    <select id="changeContent" name="changeContent">
                        <option value="option">- 구분 -</option>
                        <option value="pd_name">제품명</option>
                        <option value="mdl_name">모델명</option>
                        <option value="pd_ad_cmt">제품 홍보 문구</option>
                        <option value="pd_smr_dsc">제품 요약 설명</option>
                        <option value="pd_det_dsc">제품 상세 설명</option>
                        <option value="min_od_qty">최소 주문 수량</option>
                        <option value="max_od_qty">최대 주문 수량</option>
                        <option value="pd_is_show">진열 여부</option>
                        <option value="sls_strt_dt">판매시작일</option>
                        <option value="pd_chr_cd">제품 특성</option>
                        <option value="pd_stat_hist_cd">제품상태이력</option>
                    </select>
                    을
                    <button type="button" onclick="openPopup()">일괄 변경</button>

                </td>
            </tr>
            <tr>
                <th>선택</th>
                <th class="pd_id">제품ID</th>
                <th class="pd_name">제품명</th>
                <th class="mdl_name">모델명</th>
                <th class="pd_type_cd">제품유형</th>
                <th class="pd_type_det_cd">제품상세유형</th>
                <th class="brd_cd">브랜드</th>
                <th class="pd_chr_cd">제품 특성</th>
                <th class="qlt_cd">제품품질</th>
                <th class="pd_is_show">제품노출여부</th>
                <th class="pd_stat_hist_cd">제품 상태 이력</th>
                <th class="frst_reg_dt">제품 최초 등록일</th>
            </tr>
            <c:forEach var="productDto" items="${productList}">
                <tr>
                    <td><input type="checkbox" name="selectedProduct"></td>
                    <td class="pd_id">${productDto.pd_id}</td>
                    <td class="pd_name">${productDto.pd_name}</td>
                    <td class="mdl_name">${productDto.mdl_name}</td>
                    <td class="pd_type_cd">${productDto.pd_type_cd}</td>
                    <td class="pd_type_det_cd">${productDto.pd_type_det_cd}</td>
                    <td class="brd_cd">${productDto.brd_cd}</td>
                    <td class="pd_chr_cd">${productDto.pd_chr_cd}</td>
                    <td class="qlt_cd">${productDto.qlt_cd}</td>
                    <td class="pd_is_show">${productDto.pd_is_show}</td>
                    <td class="pd_stat_hist_cd">${productDto.pd_stat_hist_cd}</td>
                    <td class="frst_reg_dt">${productDto.frst_reg_dt}</td>
                </tr>
            </c:forEach>
        </table>
        <input type="hidden" id="popupInput" name="popupInput">

    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script>
        function openPopup() {
            let changeContent = document.getElementById("changeContent").value;
            switch (changeContent) {
                case "option":
                    /*구분을 선택한 경우 변경항목을 선택해달라는 경고창 띄우기*/
                    alert("변경항목을 선택해주세요.");
                    break;
                case "pd_name":
                    /*pdName에 해당하는 팝업 창 열기*/
                    openTextInputPopup("제품명을 입력하세요:");
                    break;
                case "mdl_name":
                    /*mdlName에 해당하는 팝업 창 열기*/
                    openTextInputPopup("제품명을 입력하세요:");
                    break;
                case "pd_ad_cmt":
                    /*pdAdCmt에 해당하는 팝업 창 열기*/
                    openTextInputPopup("제품 홍보 문구를 입력하세요:");
                    break;
                case "pd_smr_dsc":
                    /*productSummary에 해당하는 팝업 창 열기*/
                    openTextInputPopup("제품 요약 설명을 입력하세요:");
                    break;
                case "pd_det_dsc":
                    /*productDetail에 해당하는 팝업 창 열기*/
                    openTextInputPopup("제품 상세 설명을 입력하세요:");
                    break;
                case "min_od_qty":
                    /*minQuantity에 해당하는 팝업 창 열기*/
                    openNumberInputPopup("최소 주문 수량을 입력하세요:");
                    break;
                case "max_od_qty":
                    /*maxQuantity에 해당하는 팝업 창 열기*/
                    openNumberInputPopup("최대 주문 수량을 입력하세요:");
                    break;
                case "pd_is_show":
                    /*pdIsShow에 해당하는 팝업 창 열기*/
                    openBooleanInputPopup("진열 여부를 입력하세요 (Y/N):");
                    break;
                case "sls_strt_dt":
                    /*salesStartDay에 해당하는 팝업 창 열기*/
                    openDateInputPopup("판매 시작일을 입력하세요 (YYYYMMDD 형식):");
                    break;
                case "pd_chr_cd":
                    /*productCharacter에 해당하는 팝업 창 열기*/
                    openTextInputPopup("제품 특성을 입력하세요:");
                    break;
                case "pd_stat_hist_cd":
                    /*productStatus에 해당하는 팝업 창 열기*/
                    openTextInputPopup("제품 상태를 입력하세요:");
                    break;
                default:
                    alert("다시 선택해주세요");
                break;
            }
        }

        function openTextInputPopup(promptMessage) {
            let userInput = prompt(promptMessage);
            /*userInput의 내용이 없다면*/
            if (userInput.trim() === "" || userInput === null) {
                /*변경할 내용을 입력해주세요*/
                alert("변경할 내용을 입력해주세요.")
            } else {
                // hidden input에 사용자 입력값 설정
                document.getElementById("popupInput").value = userInput;
                // form 제출
                makeForm();
            }
        }

        function openNumberInputPopup(promptMessage) {
            let userInput = prompt(promptMessage);
            if (userInput !== null) {
                // hidden input에 사용자 입력값 설정
                var number = parseInt(userInput);
                if (!isNaN(number)) {
                    document.getElementById("popupInput").value = number;
                    // form 제출
                    makeForm();
                } else {
                    alert("올바른 숫자를 입력하세요.");
                }
            }
        }

        function openBooleanInputPopup(promptMessage) {
            let userInput = prompt(promptMessage);
            if (userInput !== null) {
                // hidden input에 사용자 입력값 설정
                userInput = userInput.toUpperCase();
                if (userInput === 'Y' || userInput === 'N') {
                    document.getElementById("popupInput").value = userInput;
                    // form 제출
                    makeForm();
                } else {
                    alert("Y 또는 N 중 하나를 입력하세요.");
                }
            }
        }

        function openDateInputPopup(promptMessage) {
            let userInput = prompt(promptMessage);
            if (userInput !== null) {
                // hidden input에 사용자 입력값 설정
                var dateRegex = /^\d{8}$/;
                if (dateRegex.test(userInput)) {
                    document.getElementById("popupInput").value = userInput;
                    // form 제출
                    makeForm();
                } else {
                    alert("올바른 날짜 형식(YYYYMMDD)으로 입력하세요.");
                }
            }
        }

        function makeForm() {
            /*폼을 동적으로 생성한다.*/
            let form = $('<form id="popupForm" action="<c:url value='/admin/product/manage'/>" method="post"></form>');

            /*체크된 제품의 리스트를 저장하기 위해 변수를 선언한다.*/
            let selectedProductList = [];

            /*체크된 제품의 제품ID를 가져와서 폼에 추가한다.*/
            $("input:checkbox[name=selectedProduct]:checked").each(function () {
                selectedProductList.push($(this).closest('tr').find('.pd_id').text());
            });

            /*제품ID를 문자열로 결합하여 폼 데이터에 추가한다.*/
            form.append('<input type="hidden" name="pd_id" value="' + selectedProductList.join(',') + '">');

            /*productNumber의 값을 찾아서 저장한다.*/
            productNumber = document.getElementById("productNumber").value;
            form.append('<input type="hidden" name="productNumber" value="' + productNumber + '">');

            /*changeContent의 값을 찾아서 저장한다.*/
            changeContent = document.getElementById("changeContent").value;
            form.append('<input type="hidden" name="changeContent" value="' + changeContent + '">');

            /*팝업창에 입력한 popupInput 값을 찾아서 저장한다.*/
            popupInput = document.getElementById("popupInput").value;
            form.append('<input type="hidden" name="popupInput" value="' + popupInput + '">');

            /*폼을 body에 추가한다.*/
            $(document.body).append(form);

            /*폼을 전송한다.*/
            form.submit();

            /*폼을 제거한다.*/
            form.remove();
        }
    </script>
</div>
</body>
</html>