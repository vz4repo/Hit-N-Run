<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>

<html>
<body>
<h2>Hello Home run()</h2>
<h2>SYSDATE : ${empty curDate? "no conn" : curDate }</h2>
<h2>JSTL SYSDATE: <c:out value="${curDate}" /></h2>
<h2>ServerTime :${serverTime}</h2>

</body>
</html>

