<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Open+Sans">
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>
    <title>오류페이지입니다.</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>잘못된 접근입니다.</h1>
<%--<p>${errorMessage}</p>--%>
<jsp:include page="footer.jsp" flush="false" />
</body>
</html>
