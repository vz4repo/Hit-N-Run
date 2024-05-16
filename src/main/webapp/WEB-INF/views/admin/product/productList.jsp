<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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

        strong {
            font-weight: bold;
            color: #1b64da;
        }
    </style>
    <title>제품 목록</title>
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
        <table>
            <tr>
                <td colspan="12">[총 <strong>${productCount}</strong>개]</td>
            </tr>
            <tr>
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
    </div>
</body>
</html>