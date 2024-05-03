<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <style>
        <%@include file="/resources/css/adminMenu.css" %>
    </style>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: left;
        }
    </style>
    <title>재고 목록</title>
</head>
<body>
<jsp:include page="../adminMenu.jsp" flush="false"/>
<div class="main">
    <div class="search-container">
        <form action="<c:url value="/board/list"/>" class="search-form" method="get">
            <select class="search-option" name="option">
                <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
                <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
            </select>

            <input type="text" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}"
                   placeholder="검색어를 입력해주세요">
            <input type="submit" class="search-button" value="검색">
        </form>
        <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/admin/stock/register"/>'">
            <i class="fa fa-pencil"></i> 글쓰기
        </button>
        <%--        <th class="pd_type_cd">제품유형</th>--%>
        <%--        <th class="pd_type_det_cd">제품상세유형</th>--%>
        <%--        <th class="brd_cd">브랜드</th>--%>
        <%--        <th class="sls_strt_dt">판매시작일시</th>--%>
        <%--        <th class="frst_reg_dt">제품 최초 등록일</th>--%>
    </div>
    <div class="product-container">
        <table>
            <tr>
                <th class="pd_id">제품ID</th>
                <th class="pd_name">제품명</th>
                <th class="nml_stk_qty">정상재고 수량</th>
                <th class="rt_stk_qty">반품재고 수량</th>
                <th class="rgn_stk_qty">재생가능재고 수량</th>
                <th class="urgn_stk_qty">재생불가능재고 수량</th>
                <th class="sfty_stk_qty">안전재고 수량</th>
                <th class="odpmt_stk">가용재고</th>
            </tr>
            <c:forEach var="productDto" items="${productList}">
                <tr>
                    <td class="pd_id">${productDto.pd_id}</td>
                    <td class="pd_name">${productDto.pd_name}</td>

                    <c:set var="foundStock" value="false"/>
                    <c:forEach var="stockDto" items="${stockList}">
                        <c:if test="${stockDto.pd_id eq productDto.pd_id}">
                            <c:set var="foundStock" value="true"/>
                            <td class="nml_stk_qty">${stockDto.nml_stk_qty}</td>
                            <td class="rt_stk_qty">${stockDto.nml_stk_qty}</td>
                            <td class="rgn_stk_qty">${stockDto.nml_stk_qty}</td>
                            <td class="urgn_stk_qty">${stockDto.nml_stk_qty}</td>
                            <td class="sfty_stk_qty">${stockDto.nml_stk_qty}</td>
                            <td class="odpmt_stk">${stockDto.nml_stk_qty}</td>
                        </c:if>
                    </c:forEach>
                    <c:if test="${foundStock eq false}">
                        <td class="nml_stk_qty">0</td>
                        <td class="rt_stk_qty">0</td>
                        <td class="rgn_stk_qty">0</td>
                        <td class="urgn_stk_qty">0</td>
                        <td class="sfty_stk_qty">0</td>
                        <td class="odpmt_stk">0</td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="stock-container">
        <table>
            <tr>
                <th class="pd_id">제품ID</th>
                <th class="pd_name">제품명</th>
                <th class="pd_clsf_cd">제품 구분 코드</th>
                <th class="nml_stk_qty">정상재고 수량</th>
                <th class="rt_stk_qty">반품재고 수량</th>
                <th class="rgn_stk_qty">재생가능재고 수량</th>
                <th class="urgn_stk_qty">재생불가능재고 수량</th>
                <th class="sfty_stk_qty">안전재고 수량</th>
                <th class="odpmt_stk">가용재고</th>
                <th class="pur_dt">매입일</th>
                <th class="rcpt_dt">입고일</th>
                <th class="rcpt_cp">입고처</th>
                <th class="rcpt_prc">입고가격</th>
                <th class="rtl_prc">소비자가격</th>
                <th class="sls_prc">판매가격</th>
                <th class="stk_plc_cd">재고 위치 코드</th>
            </tr>
            <c:forEach var="stockDto" items="${stockList}">
                <tr>
                    <td class="pd_id">${stockDto.pd_id}</td>
                    <td class="pd_name">${stockDto.pd_name}</td>
                    <td class="pd_clsf_cd">${stockDto.pd_clsf_cd}</td>
                    <td class="nml_stk_qty">${stockDto.nml_stk_qty}</td>
                    <td class="rt_stk_qty">${stockDto.rt_stk_qty}</td>
                    <td class="rgn_stk_qty">${stockDto.rgn_stk_qty}</td>
                    <td class="urgn_stk_qty">${stockDto.urgn_stk_qty}</td>
                    <td class="sfty_stk_qty">${stockDto.sfty_stk_qty}</td>
                    <td class="odpmt_stk">${stockDto.odpmt_stk}</td>
                    <td class="pur_dt">${stockDto.pur_dt}</td>
                    <td class="rcpt_dt">${stockDto.rcpt_dt}</td>
                    <td class="rcpt_cp">${stockDto.rcpt_cp}</td>
                    <td class="rcpt_prc">${stockDto.rcpt_prc}</td>
                    <td class="rtl_prc">${stockDto.rtl_prc}</td>
                    <td class="sls_prc">${stockDto.sls_prc}</td>
                    <td class="stk_plc_cd">${stockDto.stk_plc_cd}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="paging-container">
        <p>페이징자리</p>
    </div>
</div>
</body>
</html>
