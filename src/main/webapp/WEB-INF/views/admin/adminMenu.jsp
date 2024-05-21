<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="w3-sidebar w3-light-grey w3-bar-block w3-card w3-animate-left" style="display:none" id="mySidebar">
    <%--<button class="w3-bar-item w3-button w3-large" onclick="w3_close()">Close &times;</button>--%>
    <a href="<c:url value='/admin/main'/>" class="w3-bar-item w3-button">HOME</a>
    <a href="<c:url value='/admin/product/dashboard'/>" class="w3-bar-item w3-button">제품 대시보드</a>
    <a href="<c:url value='/admin/product/list'/>" class="w3-bar-item w3-button">제품 목록</a>
    <a href="<c:url value='/admin/product/register'/>" class="w3-bar-item w3-button">제품 등록</a>

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
        var x = document.getElementById(id);
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
            x.previousElementSibling.className += " w3-black";
        } else {
            x.className = x.className.replace(" w3-show", "");
            x.previousElementSibling.className =
                x.previousElementSibling.className.replace(" w3-black", "");
        }
    }
</script>