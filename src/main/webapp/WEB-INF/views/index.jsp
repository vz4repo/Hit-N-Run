<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<body>
<h2>Hello Home run()</h2>
<h2>SYSDATE : ${empty curDate? "no conn" : curDate }</h2>
<a href="/homerunball/cart/list">cart 이동</a>
<a href="/admin/stock/list">재고목록페이지 이동</a>
</body>
</html>