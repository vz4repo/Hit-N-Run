<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>제품 목록</title>
</head>
<body>
<jsp:include page="adminMenu.jsp" flush="false" />
총 제품 개수: ${productCount}
<table>
    <tr>
        <th class="pd_id">제품ID</th>
        <th class="pd_name">제품명</th>
        <th class="mdl_name">모델명</th>
        <th class="qlt_cd">제품품질</th>
        <th class="pd_is_show">제품노출여부</th>
        <th class="pd_type_cd">제품유형</th>
        <th class="pd_type_det_cd">제품상세유형</th>
        <th class="brd_cd">브랜드</th>
        <th class="hit_cnt">조회수</th>
    </tr>
    <c:forEach var="productDto" items="${productList}">
        <tr>
            <td class="pd_id">${productDto.pd_id}</td>
            <td class="pd_name">${productDto.pd_name}</td>
            <td class="mdl_name">${productDto.mdl_name}</td>
            <td class="qlt_cd">${productDto.qlt_cd}</td>
            <td class="pd_is_show">${productDto.pd_is_show}</td>
            <td class="pd_type_cd">${productDto.pd_type_cd}</td>
            <td class="pd_type_det_cd">${productDto.pd_type_det_cd}</td>
            <td class="brd_cd">${productDto.brd_cd}</td>
            <td class="hit_cnt">${productDto.hit_cnt}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>