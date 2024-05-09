<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<c:set var="loginOutLink" value="${sessionScope.c_id==null ? '/login' : '/logout'}"/>
<c:set var="loginOut" value="${sessionScope.c_id==null ? '로그인' : '로그아웃'}"/>

<link rel="icon" type="image/x-icon" href="https://www.rawlings.com/dw/image/v2/BBBJ_PRD/on/demandware.static/-/Sites-master-catalog/default/dw0de929af/products/ROMLBHOF-2.jpg?sw=800&sfrm=png&bgcolor=ebebeb">
<style>

    li {
        list-style: none;
    }
</style>


<div class="index">
    <h2>Hello! Home run()</h2>
    <h2> D - <span id="dDay">남은시간!</span></h2>
    <hr/>


    <nav id="loginbtn">
        <ul>
            <li><a id="logoutLink" href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
        </ul>
    </nav>

<div><a href="/mypage/add">마이페이지 이동</a></div>
<div><a href="/cart/list">장바구니 이동</a></div>
<div><a href="/order">주문 이동</a></div>
<div><a href="/admin/main">제품 이동</a></div>
<div><a href="/payment">결제 이동</a></div>
</div>

<script>
    window.onload = function() {
        if("${sessionScope.c_id}" !== "") {
            document.getElementById('logoutLink').addEventListener('click', function(event) {
                event.preventDefault();
                if (confirm('정말로 로그아웃을 하시겠습니까?')) {
                    window.location.href = event.target.href;
                    alert('로그아웃이 되셨습니다.');
                }
            });
        }
    };

    const dDay = document.querySelector("#dDay");

    function countDay() {
        const now = new Date();
        const dueDate = new Date("2024-05-30T11:59:59").getTime();  /* 디데이 설정 */

        const timeRemaining = dueDate - now;  /* 남은시간 */
        const day = Math.floor(timeRemaining / (1000 * 60 * 60 * 24));
        const hour = Math.floor(timeRemaining / (1000 * 60 * 60) % 24);
        const min = Math.floor(timeRemaining / (1000 * 60) % 60);
        const sec = Math.floor(timeRemaining / 1000 % 60);

        dDay.innerText = `${'${day}'} [${'${hour}'}:${'${min}'}:${'${sec}'}]`;
    }

    // countDay();
    setInterval(countDay, 1000);  /* 초마다 디데이 기능 실행 */

</script>



