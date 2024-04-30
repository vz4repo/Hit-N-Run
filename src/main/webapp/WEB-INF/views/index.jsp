<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello Home run()</h2>
<h2>SYSDATE : ${empty curDate? "no conn" : curDate }</h2>
<a href="/cart/list">cart 이동</a>
<a href="/login/login">로그인 이동</a>
<a href="/register/add">회원가입 이동</a>

</body>
</html>

