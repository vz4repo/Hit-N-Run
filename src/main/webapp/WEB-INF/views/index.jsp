<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%--제품 진열--%>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Open+Sans">
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/resources/css/footer.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <c:set var="loginOutLink" value="${sessionScope.c_id==null ? '/login' : '/logout'}"/>
    <c:set var="loginOut" value="${sessionScope.c_id==null ? '로그인' : '로그아웃'}"/>

    <link rel="icon" type="image/x-icon" href="https://www.rawlings.com/dw/image/v2/BBBJ_PRD/on/demandware.static/-/Sites-master-catalog/default/dw0de929af/products/ROMLBHOF-2.jpg?sw=800&sfrm=png&bgcolor=ebebeb">
    <style>
<%--        <%@include file="/resources/css/header.css"%>--%>
<%--        <%@include file="/resources/css/nav.css"%>--%>

        /*캐러셀에 필요한 css*/
        <%@include file="/resources/css/carousel.css"%>

        /*mainCategory에 필요한 css include*/
        <%@include file="/resources/css/mainCategory.css"%>
    </style>
    <title>Home-Run</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="index">
        <h2>Hello! Home run()</h2>
        <h2> D - <span id="dDay">남은시간!</span></h2>
        <hr/>
        <nav id="loginbtn">
            <ul>
            <li><a id="logoutLink" href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
            </ul>
        </nav>
        <div><a href="/mypage/list">마이페이지 이동</a></div>
        <div><a href="/cart/list">장바구니 이동</a></div>
        <%--<div><a href="/order">주문 이동</a></div>--%>
        <div><a href="/admin/main">제품 이동</a></div>
        <div><a href="/product/detail?pd_id=APP000003-04">제품상세 이동</a></div>
        <%--<div><a href="/payment">결제 이동</a></div>--%>
        <div><a href="/product/detail">제품 상세 이동</a></div>
        <div><a href="/delivery/deliveryList">배송지 이동</a></div>
    </div>

    <%--상품 진열 시작--%>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h2><b>신제품</b></h2>
                <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="0">
                    <!-- Carousel indicators -->
                    <ol class="carousel-indicators">
                        <c:set var="num" value="${newProductNumber % 4 == 0 ? newProductNumber / 4 : newProductNumber / 4 + 1}" />
                        <c:forEach var="i" begin="0" end="${num-1}" step="1">
                            <c:choose>
                                <c:when test="${i == 0}">
                                    <li data-target="#myCarousel" data-slide-to="${i}" class="active"></li>
                                </c:when>
                                <c:otherwise>
                                    <li data-target="#myCarousel" data-slide-to="${i}"></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </ol>
                    <!-- Wrapper for carousel items -->
                    <div class="carousel-inner">
                        <c:forEach var="product" items="${newProductList}" varStatus="status">
                        <c:if test="${status.index % 4 == 0}">
                        <c:choose>
                        <c:when test="${status.index == 0}">
                        <div class="item active">
                            </c:when>
                            <c:otherwise>
                            <div class="item">
                                </c:otherwise>
                                </c:choose>
                                <div class="row">
                                    </c:if>
                                    <div class="col-sm-3">
                                        <div class="thumb-wrapper border-4 border-success">
                                            <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                            <div class="img-box">
                                                <a href="/product/detail?pd_id=${product.pd_id}">
                                                    <img src="img/product/${product.pd_type_cd.toLowerCase()}/main/${product.mn_img_fn}" class="img-responsive" alt="">
                                                </a>
                                            </div>
                                            <div class="thumb-content">
                                                <h4 class="productName"><a href="/product/detail?pd_id=${product.pd_id}">${product.pd_name}</a></h4>
                                                <div class="star-rating">
                                                    <ul class="list-inline">
                                                        <li class="list-inline-item"><i class="fa fa-star"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star-half"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
                                                    </ul>
                                                </div>
                                                <c:choose>
                                                    <c:when test="${product.max_rtl_prc > product.max_sls_prc}">
                                                        <p class="item-price"><strike>${product.max_rtl_prc}원</strike> <span>${product.max_sls_prc}원</span></p>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <p class="item-price"><span>${product.max_sls_prc}원</span></p>
                                                    </c:otherwise>
                                                </c:choose>
                                                <a href="/cart/list" class="btn btn-primary">Add to Cart</a>
                                            </div>
                                        </div>
                                    </div>
                                    <c:if test="${status.index % 4 == 3}">
                                </div> <!-- row 닫기 -->
                            </div> <!-- item 닫기 -->
                            </c:if>
                            </c:forEach>
                            <!-- newProductList의 인덱스를 4로 나눴을 때 3이 아닌 경우 닫아야 할 태그를 닫아줍니다. -->
                            <c:if test="${newProductNumber % 4 != 0}">
                        </div> <!-- row 닫기 -->
                    </div> <!-- item 닫기 -->
                    </c:if>
                </div>
                <!-- Carousel controls -->
                <a class="carousel-control left" href="#myCarousel" data-slide="prev">
                    <i class="fa fa-angle-left"></i>
                </a>
                <a class="carousel-control right" href="#myCarousel" data-slide="next">
                    <i class="fa fa-angle-right"></i>
                </a>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <h2><b>인기 제품</b></h2>
                <div id="myCarousel1" class="carousel slide" data-ride="carousel" data-interval="0">
                    <!-- Carousel indicators -->
                    <ol class="carousel-indicators">
                        <c:set var="num" value="${newProductNumber % 4 == 0 ? newProductNumber / 4 : newProductNumber / 4 + 1}" />
                        <c:forEach var="i" begin="0" end="${num-1}" step="1">
                            <c:choose>
                                <c:when test="${i == 0}">
                                    <li data-target="#myCarousel1" data-slide-to="${i}" class="active"></li>
                                </c:when>
                                <c:otherwise>
                                    <li data-target="#myCarousel1" data-slide-to="${i}"></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </ol>
                    <!-- Wrapper for carousel items -->
                    <div class="carousel-inner">
                        <c:forEach var="product" items="${newProductList}" varStatus="status">
                        <c:if test="${status.index % 4 == 0}">
                        <c:choose>
                        <c:when test="${status.index == 0}">
                        <div class="item active">
                            </c:when>
                            <c:otherwise>
                            <div class="item">
                                </c:otherwise>
                                </c:choose>
                                <div class="row">
                                    </c:if>
                                    <div class="col-sm-3">
                                        <div class="thumb-wrapper">
                                            <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                            <div class="img-box">
                                                <a href="/product/detail?pd_id=${product.pd_id}">
                                                    <img src="img/product/${product.pd_type_cd.toLowerCase()}/main/${product.mn_img_fn}" class="img-responsive" alt="">
                                                </a>
                                            </div>
                                            <div class="thumb-content">
                                                <h4 class="productName"><a href="/product/detail?pd_id=${product.pd_id}">${product.pd_name}</a></h4>
                                                <div class="star-rating">
                                                    <ul class="list-inline">
                                                        <li class="list-inline-item"><i class="fa fa-star"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star-half"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
                                                    </ul>
                                                </div>
                                                <c:choose>
                                                    <c:when test="${product.max_rtl_prc > product.max_sls_prc}">
                                                        <p class="item-price"><strike>${product.max_rtl_prc}원</strike> <span>${product.max_sls_prc}원</span></p>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <p class="item-price"><span>${product.max_sls_prc}원</span></p>
                                                    </c:otherwise>
                                                </c:choose>
                                                <a href="/cart/list" class="btn btn-primary">Add to Cart</a>
                                            </div>
                                        </div>
                                    </div>
                                    <c:if test="${status.index % 4 == 3}">
                                </div> <!-- row 닫기 -->
                            </div> <!-- item 닫기 -->
                            </c:if>
                            </c:forEach>
                            <!-- newProductList의 인덱스를 4로 나눴을 때 3이 아닌 경우 닫아야 할 태그를 닫아줍니다. -->
                            <c:if test="${newProductNumber % 4 != 0}">
                        </div> <!-- row 닫기 -->
                    </div> <!-- item 닫기 -->
                    </c:if>
                </div>
                <!-- Carousel controls -->
                <a class="carousel-control left" href="#myCarousel1" data-slide="prev">
                    <i class="fa fa-angle-left"></i>
                </a>
                <a class="carousel-control right" href="#myCarousel1" data-slide="next">
                    <i class="fa fa-angle-right"></i>
                </a>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <h2><b>스테디 셀러 제품</b></h2>
                <div id="myCarousel2" class="carousel slide" data-ride="carousel" data-interval="0">
                    <!-- Carousel indicators -->
                    <ol class="carousel-indicators">
                        <c:set var="num" value="${newProductNumber % 4 == 0 ? newProductNumber / 4 : newProductNumber / 4 + 1}" />
                        <c:forEach var="i" begin="0" end="${num-1}" step="1">
                            <c:choose>
                                <c:when test="${i == 0}">
                                    <li data-target="#myCarousel2" data-slide-to="${i}" class="active"></li>
                                </c:when>
                                <c:otherwise>
                                    <li data-target="#myCarousel2" data-slide-to="${i}"></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </ol>
                    <!-- Wrapper for carousel items -->
                    <div class="carousel-inner">
                        <c:forEach var="product" items="${newProductList}" varStatus="status">
                        <c:if test="${status.index % 4 == 0}">
                        <c:choose>
                        <c:when test="${status.index == 0}">
                        <div class="item active">
                            </c:when>
                            <c:otherwise>
                            <div class="item">
                                </c:otherwise>
                                </c:choose>
                                <div class="row">
                                    </c:if>
                                    <div class="col-sm-3">
                                        <div class="thumb-wrapper">
                                            <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                            <div class="img-box">
                                                <a href="/product/detail?pd_id=${product.pd_id}">
                                                    <img src="img/product/${product.pd_type_cd.toLowerCase()}/main/${product.mn_img_fn}" class="img-responsive" alt="">
                                                </a>
                                            </div>
                                            <div class="thumb-content">
                                                <h4 class="productName"><a href="/product/detail?pd_id=${product.pd_id}">${product.pd_name}</a></h4>
                                                <div class="star-rating">
                                                    <ul class="list-inline">
                                                        <li class="list-inline-item"><i class="fa fa-star"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star-half"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
                                                    </ul>
                                                </div>
                                                <c:choose>
                                                    <c:when test="${product.max_rtl_prc > product.max_sls_prc}">
                                                        <p class="item-price"><strike>${product.max_rtl_prc}원</strike> <span>${product.max_sls_prc}원</span></p>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <p class="item-price"><span>${product.max_sls_prc}원</span></p>
                                                    </c:otherwise>
                                                </c:choose>
                                                <a href="/cart/list" class="btn btn-primary">Add to Cart</a>
                                            </div>
                                        </div>
                                    </div>
                                    <c:if test="${status.index % 4 == 3}">
                                </div> <!-- row 닫기 -->
                            </div> <!-- item 닫기 -->
                            </c:if>
                            </c:forEach>
                            <!-- newProductList의 인덱스를 4로 나눴을 때 3이 아닌 경우 닫아야 할 태그를 닫아줍니다. -->
                            <c:if test="${newProductNumber % 4 != 0}">
                        </div> <!-- row 닫기 -->
                    </div> <!-- item 닫기 -->
                    </c:if>
                </div>
                <!-- Carousel controls -->
                <a class="carousel-control left" href="#myCarousel2" data-slide="prev">
                    <i class="fa fa-angle-left"></i>
                </a>
                <a class="carousel-control right" href="#myCarousel2" data-slide="next">
                    <i class="fa fa-angle-right"></i>
                </a>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <h2><b>추천 제품</b></h2>
                <div id="myCarousel3" class="carousel slide" data-ride="carousel" data-interval="0">
                    <!-- Carousel indicators -->
                    <ol class="carousel-indicators">
                        <c:set var="num" value="${newProductNumber % 4 == 0 ? newProductNumber / 4 : newProductNumber / 4 + 1}" />
                        <c:forEach var="i" begin="0" end="${num-1}" step="1">
                            <c:choose>
                                <c:when test="${i == 0}">
                                    <li data-target="#myCarousel3" data-slide-to="${i}" class="active"></li>
                                </c:when>
                                <c:otherwise>
                                    <li data-target="#myCarousel3" data-slide-to="${i}"></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </ol>
                    <!-- Wrapper for carousel items -->
                    <div class="carousel-inner">
                        <c:forEach var="product" items="${newProductList}" varStatus="status">
                        <c:if test="${status.index % 4 == 0}">
                        <c:choose>
                        <c:when test="${status.index == 0}">
                        <div class="item active">
                            </c:when>
                            <c:otherwise>
                            <div class="item">
                                </c:otherwise>
                                </c:choose>
                                <div class="row">
                                    </c:if>
                                    <div class="col-sm-3">
                                        <div class="thumb-wrapper">
                                            <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                            <div class="img-box">
                                                <a href="/product/detail?pd_id=${product.pd_id}">
                                                    <img src="img/product/${product.pd_type_cd.toLowerCase()}/main/${product.mn_img_fn}" class="img-responsive" alt="">
                                                </a>
                                            </div>
                                            <div class="thumb-content">
                                                <h4 class="productName"><a href="/product/detail?pd_id=${product.pd_id}">${product.pd_name}</a></h4>
                                                <div class="star-rating">
                                                    <ul class="list-inline">
                                                        <li class="list-inline-item"><i class="fa fa-star"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star-half"></i></li>
                                                        <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
                                                    </ul>
                                                </div>
                                                <c:choose>
                                                    <c:when test="${product.max_rtl_prc > product.max_sls_prc}">
                                                        <p class="item-price"><strike>${product.max_rtl_prc}원</strike> <span>${product.max_sls_prc}원</span></p>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <p class="item-price"><span>${product.max_sls_prc}원</span></p>
                                                    </c:otherwise>
                                                </c:choose>
                                                <a href="/cart/list" class="btn btn-primary">Add to Cart</a>
                                            </div>
                                        </div>
                                    </div>
                                    <c:if test="${status.index % 4 == 3}">
                                </div> <!-- row 닫기 -->
                            </div> <!-- item 닫기 -->
                            </c:if>
                            </c:forEach>
                            <!-- newProductList의 인덱스를 4로 나눴을 때 3이 아닌 경우 닫아야 할 태그를 닫아줍니다. -->
                            <c:if test="${newProductNumber % 4 != 0}">
                        </div> <!-- row 닫기 -->
                    </div> <!-- item 닫기 -->
                    </c:if>
                </div>
                <!-- Carousel controls -->
                <a class="carousel-control left" href="#myCarousel3" data-slide="prev">
                    <i class="fa fa-angle-left"></i>
                </a>
                <a class="carousel-control right" href="#myCarousel3" data-slide="next">
                    <i class="fa fa-angle-right"></i>
                </a>
            </div>
        </div>

        <%--mainCategory에 필요한 페이지 include(css도 필요)--%>
        <jsp:include page="mainCategory.jsp" flush="false" />
    </div>
    </div>
        <jsp:include page="footer.jsp" flush="false" />
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

        $(document).ready(function(){
            $(".wish-icon i").click(function () {
                $(this).toggleClass("fa-heart fa-heart-o");
            });
        });
    </script>
</body>
</html>