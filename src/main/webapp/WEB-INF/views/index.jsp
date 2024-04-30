<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="index">
<h2>Hello! Home run()</h2>
<h2> D - <span id="dDay">남은시간!</span></h2>
<hr/>

<div><a href="/cart/list">장바구니 이동</a></div>
<div><a href="/order">주문 이동</a></div>
<div><a href="/register/add">회원등록 이동</a></div>
<div><a href="/admin/main">제품 이동</a></div>
<div><a href="/admin/stock/main">재고 이동</a></div>
<div><a href="/payment">결제 이동</a></div>
</div>

<script>
  const dDay = document.querySelector("#dDay");

  function countDay(){
    const now     = new Date();
    const dueDate = new Date("2024-05-30T11:59:59").getTime();  /* 디데이 설정 */

    const timeRemaining = dueDate - now;  /* 남은시간 */
    const day  = Math.floor(timeRemaining / (1000*60*60*24));
    const hour = Math.floor(timeRemaining / (1000*60*60)%24);
    const min  = Math.floor(timeRemaining / (1000*60)%60);
    const sec  = Math.floor(timeRemaining /  1000%60);

    dDay.innerText = `${'${day}'} [${'${hour}'}:${'${min}'}:${'${sec}'}]`;
  }
  // countDay();
  setInterval(countDay, 1000);  /* 초마다 디데이 기능 실행 */
</script>



