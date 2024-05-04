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
    <title>재고 등록하기 페이지</title>
</head>
<body>
<jsp:include page="../adminMenu.jsp" flush="false"/>
<div class="main">
    <h1>재고 등록 화면</h1>
</div>
</body>
</html>
