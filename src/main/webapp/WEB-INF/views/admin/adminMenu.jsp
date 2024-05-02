<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <li><a href="<c:url value='/admin/main'/>">HOME</a></li>
    <li><a>제품</a></li>
    <li><a href="<c:url value='/admin/product/dashboard'/>">제품 대시보드</a></li>
    <li><a href="<c:url value='/admin/product/list'/>">제품 목록</a></li>
    <li><a href="<c:url value='/admin/product/register'/>">제품 등록</a></li>
    <li>제품 관리</li>
    <ul>
        <li><a href="<c:url value='/admin/product/manage'/>">제품 정보 일괄 변경</a></li>
        <li><a href="<c:url value='/admin/product/showHiddenProductList'/>">진열 제외 제품 목록</a></li>
    </ul>
    <li><a>재고 관리</a></li>

</ul>