<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <style>
        <%@include file="/resources/css/adminMenu.css" %>
        <%@include file="/resources/css/adminDefaultTable.css" %>
        <%@include file="/resources/css/searchConditionForm.css" %>
        .product-container {
            width: 100%;
            margin: 20px 0px;
            display: inline-block;
            text-align: center;
        }

        .product-container tbody td:nth-of-type(1),
        .product-container tbody td:nth-of-type(6),
        .product-container tbody td:nth-of-type(7),
        .product-container tbody td:nth-of-type(8),
        .product-container tbody td:nth-of-type(9),
        .product-container tbody td:nth-of-type(10),
        .product-container tbody td:nth-of-type(11),
        .product-container tbody td:nth-of-type(12),
        .product-container tbody td:nth-of-type(13){
            text-align: center;
        }

         .sendBtnSmall:hover {
            background: #0b7dda;
        }

        .createStockBtn[disabled], .modifyStockBtn[disabled] {
            cursor: not-allowed;
            background: #9e9ea4;
            color: #7e7e87;
        }

    </style>
    <title>재고 목록</title>
</head>
<body>
<jsp:include page="../adminMenu.jsp" flush="false"/>
<div id="main">
    <div class="w3-dark-grey header-container">
        <div class="w3-dark-grey header-button">
            <button id="openNav" class="w3-button w3-dark-grey w3-xlarge" onclick="w3_open()">&#9776;</button>
            <button id="closeNav" class="w3-button w3-dark-grey w3-xlarge" onclick="w3_close()" style="display:none">&times;</button>
        </div>
        <div id="headline" class="header-title">재고 등록/수정</div>
    </div>
    <%-- 재고관리를 위한 제품 검색 --%>
    <jsp:include page="../searchConditionForm.jsp" flush="false" />

    <%-- 재고관리를 위한 제품 목록 조회 및 재고등록/수정/일괄설정 --%>
    <jsp:include page="modal/stockRegisterModal.jsp" flush="false"/>
    <jsp:include page="modal/stockModifyModal.jsp" flush="false"/>
    <div class="w3-container product-container" style="overflow-x:auto;">
        <table>
            <thead>
                <tr>
                    <th colspan="2">
                        <button type="button" class="sendBtnSmall" id="stockCreateManage">일괄등록</button>
                        <button type="button" class="sendBtnSmall" id="stockModifyManage">일괄수정</button>
                    </th>
                    <th colspan="12">제품목록/재고등록</th>
                </tr>
                <tr>
                    <th class="select_checkbox">전체<input type="checkbox" id="selectAll"></th>
                    <th class="pd_id">제품ID</th>
                    <th class="pd_name">제품명</th>
                    <th class="frst_reg_dt">상품 등록일</th>
                    <th class="pd_clsf_cd">제품사이즈</th>
                    <th class="nml_stk_qty">정상재고 수량</th>
                    <th class="rt_stk_qty">반품재고 수량</th>
                    <th class="rgn_stk_qty">재생가능재고 수량</th>
                    <th class="urgn_stk_qty">재생불가능재고 수량</th>
                    <th class="sfty_stk_qty">안전재고 수량</th>
                    <th class="odpmt_stk">가용재고</th>
                    <th class="useStock">재고관리사용</th>
                    <th class="createStock">개별재고등록</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="productDto" items="${productList}" varStatus="status">
                <tr>
                    <td class="select_checkbox">
                        <input type="checkbox" name="selectedProduct" id="select_checkbox${status.index}"
                               value="${productDto.pd_id}">
                    </td>
                    <td id="pd_id_${status.index}" class="pd_id">${productDto.pd_id}</td>
                    <td id="pd_name_${status.index}" class="pd_name">${productDto.pd_name}</td>
                    <td class="frst_reg_dt">
                        <fmt:formatDate value="${productDto.frst_reg_dt}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td id="pd_clsf_cd_${status.index}" class="pd_clsf_cd">
                        <select class="search-option clsfCd" name="pd_clsf_cd" onchange="getStockSize(${status.index},this.value)">
                            <option value="ALL" selected="selected">모든사이즈</option>
                            <c:forEach var="sizeDto" items="${sizeList}">
                                <c:if test="${productDto.pd_id eq sizeDto.pd_id}">
                                    <option value="${sizeDto.pd_clsf_cd}">${sizeDto.pd_clsf_cd}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
                    <td id="nmlQty_${status.index}" class="nml_stk_qty"></td>
                    <td id="rtQty_${status.index}" class="rt_stk_qty"></td>
                    <td id="rgnQty_${status.index}" class="rgn_stk_qty"></td>
                    <td id="urgnQty_${status.index}" class="urgn_stk_qty"></td>
                    <td id="sftyQty_${status.index}" class="sfty_stk_qty"></td>
                    <td id="odpmtQty_${status.index}" class="odpmt_stk"></td>
                    <td class="useStock">
                        <select class="search-option stockUse" onchange="getStockUse(${status.index},this.value)">
                            <option value="used">사용함</option>
                            <option value="unUsed">사용안함</option>
                        </select>
                    </td>
                    <td class="createStock">
                        <button type="button" class="sendBtnSmall createStockBtn" data-bs-toggle="modal" data-bs-target="#createModal" onclick="registModal('${status.index}', '${productDto.pd_id}', '${productDto.pd_name}')">등록</button>
                        <%--<button type="button" class="sendBtnSmall modifyStockBtn" data-bs-toggle="modal" data-bs-target="#modifyModal" onclick="updateModal('${status.index}', '${productDto.pd_id}')">재고수정</button>--%>
                        <button type="button" class="sendBtnSmall modifyStockBtn" data-bs-toggle="modal" onclick="updateModal('${status.index}', '${productDto.pd_id}')">수정</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {
        $('.clsfCd').each(function (index) {
            getStockSize(index, 'ALL');
        });

        $('.stockUse').each(function (index) {
            getStockUse(index, 'used');
        });

        /*제품 전체선택 버튼 클릭시 제품 전체 선택 기능*/
        $('#selectAll').click(function () {
            $('input:checkbox').prop('checked', this.checked);
        });
    });

    function registModal(index, pdId, pdName) {
        let pdClsfCd = $('#pd_clsf_cd_' + index + ' select').val();
        if (pdClsfCd == null) {
            alert("사이즈를 골라주세요");
            return;
        }

        $('#createModal').modal('show');
        openRegisterModal(pdId, pdName, pdClsfCd);
    }

    function updateModal(index, pdId) {
        if ($('#modifyModal').is(':visible')) {
            return;
        }

        let pdClsfCd = $('#pd_clsf_cd_' + index + ' select').val();
        if (pdClsfCd == null || pdClsfCd == 'ALL') {
            alert("사이즈를 골라주세요");
            return;
        }

        $('#modifyModal').modal('show');
        openModifyModal(pdId, pdClsfCd);
    }

    /* 재고사용 여부 변화에 따라 이벤트 처리 > used일 경우 재고등록 버튼 활성화 > unUsed일 경우 재고등록 버튼 비활성화 */
    function getStockUse(index, item) {
        if (item === 'used') {
            $('.createStockBtn').eq(index).prop('disabled', false);
            $('.modifyStockBtn').eq(index).prop('disabled', false);

        } else {
            $('.createStockBtn').eq(index).prop('disabled', true);
            $('.modifyStockBtn').eq(index).prop('disabled', true);
        }
    }

    /* 상품의 사이즈 select option변경 시 Change 이벤트 발생 */
    function getStockSize(index, item) {
        console.log(index, item);
        /* 선택한 제품의 index와 제품사이즈를 가져온다.
            > 제품id와 size를 컨트롤러에 보낸다.
            > 컨트롤러에서 stock테이블을 찾아 값을 재고 수량관련 데이터를 찾아온다.
            > 해당 index에 해당하는 row에 데이터를 채워준다.
            > 재고가 이미 등록되어 있으면 등록 버튼 비활성화 */
        /* 제품의 id와 사이즈 정보 저장 */
        if (item.length < 1 || item =="ALL") {
            item = null;
        }

        let pdId = $('#pd_id_' + index).text();
        let clsfCd = item;

        /* 제품id와 사이즈 정보를 data에 담아 ajax를 통해 컨트롤러로 보내준다. */
        let data = {
            pd_id: pdId,
            pd_clsf_cd: clsfCd
        };

        $.ajax({
            type: 'POST',
            url: '/admin/stock/count',
            headers: {"Content-Type": "application/json"},
            dataType: 'JSON',
            data: JSON.stringify(data),
            success: function (response) {
                let result = response.stockDto;
                let isStockAvailable = response.isStockAvailable;

                console.log("success >>>>> ", result);
                $('#nmlQty_' + index).text(result.nml_stk_qty);
                $('#rtQty_' + index).text(result.rt_stk_qty);
                $('#rgnQty_' + index).text(result.rgn_stk_qty);
                $('#urgnQty_' + index).text(result.urgn_stk_qty);
                $('#sftyQty_' + index).text(result.sfty_stk_qty);
                $('#odpmtQty_' + index).text(result.odpmt_stk);

                /* 원장님 코드 중 글쓰기 기능 변경되는 것 차용 해오기
                    attr로 시도 해보기 / 클릭 안되면 이벤트 끊기
                 */
                if ($('.stockUse').eq(index).val() === "used") {
                    if (isStockAvailable) {
                        $('.createStockBtn').eq(index).prop('disabled', true);
                        $('.modifyStockBtn').eq(index).prop('disabled', false);
                    } else {
                        $('.createStockBtn').eq(index).prop('disabled', false);
                        $('.modifyStockBtn').eq(index).prop('disabled', true);
                    }
                }
            },
            error: function (request, status, error) {
                /*alert("error");*/
                console.log("code: " + request.status)
                console.log("message: " + request.responseText)
                console.log("error: " + error);
            }
        });
    }

    /*
    1. 재고 일괄설정 버튼클릭
      1.1. checked가 0이면 제품을 선택해 달라는 알림 띄우기
      1.2. checked된 제품 중 1개라도 재고관리 미사용이면 재고 등록을 먼저 하라는 알림 띄우기
    2. 선택된 데이터의 pd_id, pd_name, pd_clsf_cd 를 stockModify.jsp로 넘겨서 테이블 수정하기
    3. 재고 테이블에 데이터 수정하기
    */
</script>
</html>