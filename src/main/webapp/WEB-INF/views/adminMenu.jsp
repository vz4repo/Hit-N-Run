<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <li><a>제품</a></li>
    <li><a href="<c:url value='/admin/product/dashboard'/>">제품 대시보드</a></li>
    <li><a href="<c:url value='/admin/product/list'/>">제품 목록</a></li>
    <li><a href="<c:url value='/admin/product/register'/>">제품 등록</a></li>
    <li><a href="<c:url value='/admin/product/manage'/>">제품 관리</a></li>
    <li><a>재고 관리</a></li>
</ul>