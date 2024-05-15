<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="sidenav">
    <a href="<c:url value='/admin/main'/>">HOME</a>
    <a href="<c:url value='/admin/product/dashboard'/>">제품 대시보드</a>
    <a href="<c:url value='/admin/product/list'/>">제품 목록</a>
    <a href="<c:url value='/admin/product/register'/>">제품 등록</a>
    <button class="dropdown-btn">제품 관리
        <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-container">
        <a href="<c:url value='/admin/product/manage'/>">제품 정보 일괄 변경</a>
        <a href="<c:url value='/admin/product/showHiddenProductList'/>">진열 제외 제품 목록</a>
    </div>
    <a href="<c:url value='/admin/stock/list'/>">재고 관리</a>
</div>

<script>
    var dropdown = document.getElementsByClassName("dropdown-btn");
    var i;

    for (i = 0; i < dropdown.length; i++) {
        dropdown[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var dropdownContent = this.nextElementSibling;
            if (dropdownContent.style.display === "block") {
                dropdownContent.style.display = "none";
            } else {
                dropdownContent.style.display = "block";
            }
        });
    }
</script>