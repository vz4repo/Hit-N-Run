<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="w3-sidebar w3-light-grey w3-bar-block w3-card w3-animate-left" style="display:none" id="mySidebar">
    <a href="<c:url value='/admin/main'/>" class="w3-bar-item w3-button no-event"><img src="/img/homerunball_logo.png" style="width:100%"></a>
    <a href="<c:url value='/admin/product/dashboard'/>" class="w3-bar-item w3-button">대시보드</a>
    <a href="<c:url value='/admin/product/list'/>" class="w3-bar-item w3-button">제품목록</a>
    <a href="<c:url value='/admin/product/register'/>" class="w3-bar-item w3-button">제품등록</a>
    <button class="w3-button w3-block w3-left-align" onclick="myAccFunc('demoAcc1')">제품 관리 <i class="fa fa-caret-down"></i></button>
    <div id="demoAcc1" class="w3-hide w3-white">
        <a href="<c:url value='/admin/product/manage'/>" class="w3-bar-item w3-button">제품 정보 일괄 변경</a>
        <a href="<c:url value='/admin/product/showHiddenProductList'/>" class="w3-bar-item w3-button">진열 제외 제품 목록</a>
    </div>

    <button class="w3-button w3-block w3-left-align" onclick="myAccFunc('demoAcc2')">재고 관리 <i class="fa fa-caret-down"></i></button>
    <div id="demoAcc2" class="w3-hide w3-white">
        <a href="#" class="w3-bar-item w3-button">재고 목록</a>
        <a href="<c:url value='/admin/stock/list'/>" class="w3-bar-item w3-button">재고등록수정</a>
    </div>

    <button class="w3-button w3-block w3-left-align" onclick="myAccFunc('demoAcc3')">주문관리 <i class="fa fa-caret-down"></i></button>
    <div id="demoAcc3" class="w3-hide w3-white">
        <a href="<c:url value='/admin/main/#'/>" class="w3-bar-item w3-button">주문 대시보드</a>
        <a href="<c:url value='/admin/main/#'/>" class="w3-bar-item w3-button">전체주문조회</a>
        <a href="<c:url value='/admin/main/#'/>" class="w3-bar-item w3-button">입금전 관리</a>
        <a href="<c:url value='/admin/main/#'/>" class="w3-bar-item w3-button">배송 관리</a>
        <a href="<c:url value='/admin/main/#'/>" class="w3-bar-item w3-button">취소/교환/반품/환불</a>
    </div>

    <button class="w3-button w3-block w3-left-align" onclick="myAccFunc('demoAcc4')">고객관리 <i class="fa fa-caret-down"></i></button>
    <div id="demoAcc4" class="w3-hide w3-white">
        <a href="<c:url value='/admin/main/#'/>" class="w3-bar-item w3-button">회원 정보 조회</a>
        <a href="<c:url value='/admin/main/#'/>" class="w3-bar-item w3-button">회원 등급별 관리</a>
        <a href="<c:url value='/admin/main/#'/>" class="w3-bar-item w3-button">회원 탈퇴 관리</a>
        <a href="<c:url value='/admin/main/#'/>" class="w3-bar-item w3-button">휴먼 회원 관리</a>
    </div>

</div>

<script>
    function w3_open() {
        document.getElementById("main").style.marginLeft = "15%";
        document.getElementById("mySidebar").style.width = "15%";
        document.getElementById("mySidebar").style.display = "block";
        document.getElementById("openNav").style.display = 'none';
        document.getElementById("closeNav").style.display = 'inline-block';
    }
    function w3_close() {
        document.getElementById("main").style.marginLeft = "0%";
        document.getElementById("mySidebar").style.display = "none";
        document.getElementById("openNav").style.display = "inline-block";
        document.getElementById("closeNav").style.display = 'none';
    }

    function myAccFunc(id) {
        let x = document.getElementById(id);
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
            x.previousElementSibling.style.backgroundColor = "#dcdcdc";
        } else {
            x.className = x.className.replace(" w3-show", "");
            x.previousElementSibling.style.backgroundColor = "";
        }
    }

    document.addEventListener('DOMContentLoaded', function() {
        // 로컬 스토리지에서 활성화된 항목을 가져오기
        let activeItem = localStorage.getItem('activeMenuItem');

        // 페이지가 로드될 때 현재 URL 확인하여 해당하는 메뉴 아이템에 대해 이벤트 발생
        /*let currentUrl = window.location.href;*/
        let currentUrl = window.location.pathname;
        let menuItems = document.querySelectorAll('.w3-sidebar .w3-bar-item');
        menuItems.forEach(function(item) {
            if (item.getAttribute('href') === currentUrl) {
                if (!item.classList.contains('no-event')) {
                    item.classList.add('active');
                    item.parentElement.classList.add('w3-show');
                }
            }
        });
        // 메뉴 항목 클릭 이벤트 리스너 추가
        menuItems.forEach(function(item) {
            item.addEventListener('click', function () {
                // 모든 항목에서 'active' 클래스 제거
                menuItems.forEach(function (menuItem) {
                    menuItem.classList.remove('active');
                    menuItem.parentElement.classList.remove('w3-show');
                });

                if (!item.classList.contains('no-event')) {
                    // 클릭한 항목에 'active' 클래스 추가
                    item.classList.add('active');

                    // 클릭한 항목이 아코디언 항목이면 w3-show 정보 추가
                    if (item.nextElementSibling) {
                        item.parentElement.classList.add('w3-show');
                    }

                    // 로컬 스토리지에 클릭한 항목 저장
                    localStorage.setItem('activeMenuItem', item.getAttribute('href'));
                } else {
                    // 'no-event' 클래스가 있는 요소를 클릭하면 로컬 스토리지에서 항목 제거
                    localStorage.removeItem('activeMenuItem');
                }
            });

        });
    });

    window.onload = function() {
        w3_open();
    }
</script>