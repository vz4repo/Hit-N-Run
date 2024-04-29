<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>제품 목록</title>
</head>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
        text-align: left;
    }
</style>
<body>
<jsp:include page="adminMenu.jsp" flush="false" />
총 제품 개수: ${productCount}
<table>
    <tr>
        <th class="pd_id">제품ID</th>
        <th class="pd_name">제품명</th>
        <th class="mdl_name">모델명</th>
        <th class="pd_type_cd">제품유형</th>
        <th class="pd_type_det_cd">제품상세유형</th>
        <th class="brd_cd">브랜드</th>
        <th class="mn_img_fn">대표 사진 파일명</th>
        <th class="det_img_fn">상세 사진 파일명</th>
        <th class="sls_strt_dt">판매시작일시</th>
        <th class="pd_chr_cd">제품 특성</th>
        <th class="age_grp_cd">사용 연령대</th>
        <th class="qlt_cd">제품품질</th>
        <th class="pd_is_show">제품노출여부</th>
        <th class="hit_cnt">조회수</th>
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
            <th class="mn_img_fn">${productDto.mn_img_fn}</th>
            <th class="det_img_fn">${productDto.det_img_fn}</th>
            <th class="sls_strt_dt">${productDto.sls_strt_dt}</th>
            <th class="pd_chr_cd">${productDto.pd_chr_cd}</th>
            <th class="age_grp_cd">${productDto.age_grp_cd}</th>
            <th class="qlt_cd">${productDto.qlt_cd}</th>
            <th class="pd_is_show">${productDto.pd_is_show}</th>
            <th class="hit_cnt">${productDto.hit_cnt}</th>
            <th class="frst_reg_dt">${productDto.frst_reg_dt}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>