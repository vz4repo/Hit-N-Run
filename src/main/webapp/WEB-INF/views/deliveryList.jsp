<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>


<%-- ⭐⭐⭐⭐ 생각해보기 ⭐⭐⭐⭐ --%>
<%-- cust_adr_list 외의 다른 테이블에거 가져온 컬럼을 뭔가 처리 없이 다짜고짜 같이 넣어도 되나??? --%>

<p>띄우는거 성공</p>

<%-- 여기로 회원id 받아서 DeliveryController로 전달하려고 했는데 못함 --%>
<%--<strong>c__id 입력 : </strong>
    <form action="/delivery/deliveryList" method="get">
            <input type="number" id="c_id" name="c_id">
        <button type="submit">전송</button>
    </form>--%>

    <form action="delivery/deliveryList?c_id=${c_id}">
    <%-- items : 여러개의 데이터가 담긴 객체, var : 반복 변수? <-정확히 몬지 모르겠음 --%>
    <c:forEach var="list" items="${list}">
        ${list.c_id}회원번호는 ${list.c_adr_list_id} 입니다.
    </c:forEach>
    </form>


</body>
</html>