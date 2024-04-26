<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tile Layout</title>
    <link href="<c:url value='/css/layout.css'/>" rel="stylesheet">
</head>
<body>
<div>
        <div class="header"><tiles:insertAttribute name="header" /></div>
        <div class="left"><tiles:insertAttribute name="left" /></div>
        <div class="right"><tiles:insertAttribute name="right" /></div>
<%--        <div id="main"><tiles:insertAttribute name="main" /></div>--%>
        <!-- content -->
        <div>    <%@include file="index.jsp"%></div>
<%--        <tiles:insertAttribute name="content"/>--%>
        <div class="footer"><tiles:insertAttribute name="footer" /></div>
</div>
</body>
</html>