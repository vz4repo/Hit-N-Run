<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style><%@include file="/resources/css/adminMenu.css"%></style>
    <title>제품 대시보드</title>
</head>
<body>
<jsp:include page="../adminMenu.jsp" flush="false" />
<div class="main">
    <h1>제품 대시보드</h1>
    <p>전체 등록 제품: </p>
    <p>판매 중인 제품: </p>
    <p>품절 제품: </p>
    <p>진열 제외 제품: </p>
</div>
</body>
</html>