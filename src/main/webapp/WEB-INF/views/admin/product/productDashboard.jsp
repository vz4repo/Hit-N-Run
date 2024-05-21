<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>제품 대시보드</title>
    <style>
        <%@include file="/resources/css/stockAdminMenu.css" %>
        td {
            text-align: center;
        }
        .dashboard-container {
            margin: 20px 0;
        }
    </style>
</head>
<body>
<jsp:include page="../stockAdminMenu.jsp"/>
<div id="main">
    <div class="w3-dark-grey header-container">
        <div class="w3-dark-grey header-button">
            <button id="openNav" class="w3-button w3-dark-grey w3-xlarge" onclick="w3_open()">&#9776;</button>
            <button id="closeNav" class="w3-button w3-dark-grey w3-xlarge" onclick="w3_close()" style="display:none">&times;</button>
        </div>
        <div id="headline" class="header-title">제품 대시보드</div>
    </div>
    <div class="w3-container dashboard-container">
        <table>
            <tr>
                <th>전체 등록 제품</th>
                <th>판매 중인 제품</th>
                <th>품절 제품</th>
                <th>진열 제외 제품</th>
            </tr>
            <tr>
                <td>통계통계</td>
                <td>통계통계</td>
                <td>통계통계</td>
                <td>통계통계</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>