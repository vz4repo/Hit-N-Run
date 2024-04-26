<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="index">
<h2>Hello Home run()</h2>
<h2>SYSDATE : ${empty curDate? "no conn" : curDate }</h2>
<h2>JSTL SYSDATE: <c:out value="${curDate}" /></h2>
<h2>ServerTime :${serverTime}</h2>

<a href="/homerunball/cart/list">cart 이동</a>
</div>
