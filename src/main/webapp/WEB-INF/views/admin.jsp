<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>홈런볼 관리자 페이지</title>
</head>
<body>
<ul>
  <li><a>제품</a></li>
  <li><a href="<c:url value='/admin/product/dashboard'/>">제품 대시보드</a></li>
  <li><a href="<c:url value='/admin/product/list'/>">제품 목록</a></li>
  <li><a href="<c:url value='/admin/product/register'/>">제품 등록</a></li>
  <li><a href="<c:url value='/admin/product/manage'/>">제품 관리</a></li>
  <li><a>재고 관리</a></li>
</ul>
<h1>관리자를 위한 메인 페이지</h1>
</body>
</html>