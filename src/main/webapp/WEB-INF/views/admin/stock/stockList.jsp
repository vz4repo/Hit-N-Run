<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        <%@include file="/resources/css/stockAdminMenu.css" %>
        input[type="date"]::-webkit-calendar-picker-indicator {
            display: none;
            -webkit-appearance: none;
            appearance: none;
        }

        .search-container, .product-container {
            width: 100%;
            margin: 20px 0px;
            display: inline-block;
            text-align: center;
        }

        .search-container tbody tr:nth-of-type(3) select {
            margin-right: 30px;
        }

        .search-container td {
            text-align: left;
            padding-left: 20px;
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
        .search-option {
            outline: none;
            border: 1px solid #ccc;
            padding: 5px;
            font-size: 12px;
        }

        .search-option > option {
            text-align: center;
        }

        .search-input, .search-inputDate{
            color: gray;
            background-color: white;
            border: 1px solid #ccc;
            height: 100%;
            font-size: 12px;
            padding: 5px;
        }

        .search-input {
            width: 300px;
        }

        .search-inputDate {
            width: 100px;
            text-align: center;
        }

        .search-input::placeholder {
            color: gray;
        }

        .buttons {
            margin: 20px;
        }

        .sendBtn, .sendBtnSmall {
            border-radius: 4px;
            border: 1px solid #000000;
            color: white;
            cursor: pointer;
            background-color: #585858;
        }

        .sendBtn, .cancelBtn {
            padding: 10px 20px;
            font-size: 15px;
        }

        .sendBtnSmall {
            padding: 5px 10px;
            font-size: 10px;
        }

        .cancelBtn {
            border-radius: 4px;
            border: 1px solid #000000;
            background-color: white;
            cursor: pointer;
            color: #000000;
        }

        .cancelBtn:hover {
            background: #0b7dda;
            color: white;
        }

        .sendBtn:hover, .sendBtnSmall:hover {
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
<jsp:include page="../stockAdminMenu.jsp"/>
<div id="main">
    <div class="w3-dark-grey header-container">
        <div class="w3-dark-grey header-button">
            <button id="openNav" class="w3-button w3-dark-grey w3-xlarge" onclick="w3_open()">&#9776;</button>
            <button id="closeNav" class="w3-button w3-dark-grey w3-xlarge" onclick="w3_close()" style="display:none">&times;</button>
        </div>
        <div id="headline" class="header-title">재고 등록/수정</div>
    </div>
    <%-- 재고관리를 위한 제품 검색 --%>
    <div class="w3-container search-container">
        <form action="<c:url value="/admin/stock/searchList"/>" class="search-form" method="get">
            <table>
                <tr>
                    <th colspan="2">제품 검색</th>
                </tr>
                <%--검색 분류: 상품ID, 상품명, 모델명, 스포츠 유형, 제조자, 시리즈, 사용 선수명, 시즌--%>
                <tr>
                    <th>검색 분류</th>
                    <td>
                        <select class="search-option" name="keywordSelect">
                            <option value="pd_id">상품ID</option>
                            <option value="pd_name">상품명</option>
                            <option value="mdl_name">모델명</option>
                            <option value="sprt_type_cd">스포츠 유형</option>
                            <option value="mfr">제조사</option>
                            <option value="srs_id">시리즈</option>
                            <option value="player_name">사용 선수명</option>
                            <option value="season">시즌</option>
                        </select>
                        <input type="text" name="keyword" class="search-input" type="text" value="${keyword}"
                               placeholder="검색어를 입력해주세요">
                    </td>
                </tr>
                <%--상품 분류: 대(제품 유형), 중(제품 상세 유형), 소(브랜드)--%>
                <tr>
                    <th>상품 분류</th>
                    <td>
                        <label for="pd_type_cd">제품 유형</label>
                        <select class="search-option" id="pd_type_cd" name="pd_type_cd">
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
                        <select class="search-option" id="pd_type_det_cd" name="pd_type_det_cd">
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
                            <option value="SPK">스파이크_야구화</option>
                            <option value="TRF">인조잔디_야구화</option>
                        </select>

                        <label for="brd_cd">브랜드</label>
                        <select class="search-option" id="brd_cd" name="brd_cd">
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
                <%--상품 등록일: 검색시작날짜 - 검색마지막날짜--%>
                <tr>
                    <th>상품 등록일</th>
                    <%--
                        - 미선택 시 후 (1개월, 3개월, 6개월)버튼 클릭 시 오늘날짜 기준으로 조회
                        - 검색 시작일자 기준 1개월, 3개월, 6개월
                    --%>
                    <td>
                        기간선택 :
                        <label for="sdate">시작일</label>
                        <input class="search-inputDate" type="date" id="sdate">
                        ~
                        <label for="edate">종료일</label>
                        <input class="search-inputDate" type="date" id="edate">
                    </td>
                </tr>
                <%--진열 상태: 전체, 진열중, 진열 제외--%>
                <tr>
                    <th>진열 상태</th>
                    <td>
                        <input type='radio' id="displayAll" name='pd_is_show'/>
                        <label for="displayAll">전체</label>
                        <input type='radio' id="displayOn" name='pd_is_show' value='Y'/>
                        <label for="displayOn">진열하기</label>
                        <input type='radio' id="displayNo" name='pd_is_show' value='N'/>
                        <label for="displayNo">진열제외</label>
                    </td>
                </tr>
                <%--판매 상태: 전체, 판매중, 판매 안함--%>
                <tr>
                    <th>판매 상태</th>
                    <td>
                        <input type='radio' id="allSale" name='pd_stat_hist_cd'/>
                        <label for="allSale">전체</label>
                        <input type='radio' id="planSale" name='pd_stat_hist_cd' value='planSale'/>
                        <label for="planSale">판매 예정</label>
                        <input type='radio' id="onSale" name='pd_stat_hist_cd' value='onSale'/>
                        <label for="onSale">판매 중</label>
                        <input type='radio' id="notSale" name='pd_stat_hist_cd' value='notSale'/>
                        <label for="notSale">판매 안 함</label>
                    </td>
                </tr>
            </table>
            <div class="buttons">
                <button type="submit" class="sendBtn" id="searchBtn">검색</button>
                <button type="button" class="cancelBtn" id="cancelBtn">취소</button>
            </div>
        </form>
    </div>
    <%-- 재고관리를 위한 제품 목록 조회 및 재고등록/수정/일괄설정 --%>
    <jsp:include page="modal/stockRegisterModal.jsp"/>
    <jsp:include page="modal/stockModifyModal.jsp"/>
    <div class="w3-container product-container" style="overflow-x:auto;">
        <table>
            <thead>
                <tr>
                    <th colspan="2">
                        <button type="button" class="sendBtnSmall" id="stockCreateManage">재고 일괄등록</button>
                        <button type="button" class="sendBtnSmall" id="stockModifyManage">재고 일괄수정</button>
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
                        <button type="button" class="sendBtnSmall createStockBtn" data-bs-toggle="modal" data-bs-target="#createModal" onclick="registModal('${status.index}', '${productDto.pd_id}', '${productDto.pd_name}')">재고등록</button>
                        <%--<button type="button" class="sendBtnSmall modifyStockBtn" data-bs-toggle="modal" data-bs-target="#modifyModal" onclick="updateModal('${status.index}', '${productDto.pd_id}')">재고수정</button>--%>
                        <button type="button" class="sendBtnSmall modifyStockBtn" data-bs-toggle="modal" onclick="updateModal('${status.index}', '${productDto.pd_id}')">재고수정</button>
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

        /* 날짜 검색하는 기능에서 시작일, 종료일 구현하는 js */
        $.datepicker.setDefaults({
            changeYear: true,
            changeMonth: true,
            dateFormat: 'yy-mm-dd',
            prevText: '이전 달',
            nextText: '다음 달',
            closeText: '닫기',
            currentText: '오늘',
            monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
            dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
            showMonthAfterYear: true,
            yearSuffix: '년',
            showButtonPanel: true,
        });

        initializeDatepicker();

    });

    function initializeDatepicker() {
        $('#sdate').datepicker({
            onSelect: function (selectedDate) {
                $('#edate').datapicker("option", "minDate", selectedDate);
            }
        });

        $('#edate').datepicker({
            onSelect: function (selectedDate) {
                $('#sdate').datepicker('option', 'maxDate', selectedDate);
            }
        });
        $('.dateForm').datepicker();

        var today = new Date();
        $('#sdate, #edate, .dateForm').datepicker('setDate', today);
    }

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