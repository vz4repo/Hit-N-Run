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
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <c:set var="loginOutLink" value="${sessionScope.c_id==null ? '/login' : '/logout'}"/>
    <c:set var="loginOut" value="${sessionScope.c_id==null ? '로그인' : '로그아웃'}"/>

    <link rel="icon" type="image/x-icon" href="https://www.rawlings.com/dw/image/v2/BBBJ_PRD/on/demandware.static/-/Sites-master-catalog/default/dw0de929af/products/ROMLBHOF-2.jpg?sw=800&sfrm=png&bgcolor=ebebeb">
    <style>

        * {
            margin: 0;
        }

        #content {
            display: flex;
            justify-content: space-between;
            text-align: center;
        }

        .interview {
            position: relative;
            margin-right: 30px;
        }

        .mySlides {
            display: none;
        }

        .cursor {
            cursor: pointer;
        }

        .cc {
            text-align: center;
            background-color: #222;
            padding: 5px;
            color: silver;
        }

        .cc p {
            margin: 0;
        }

        .column {
            float: left;
            width: 16.66%;
        }

        .demo {
            opacity: 0.6;
        }

        .active,
        .demo:hover {
            opacity: 1;
        }

        .video {
            position: relative;
        }


        .prev2,
        .next2 {
            cursor: pointer;
            position: absolute;
            top: 90%;
            width: auto;
            padding: 3px;
            margin-top: 8px;
            color: silver;
            font-weight: bold;
            font-size: 16px;
            transition: 0.6s ease;
            border-radius: 0 3px 3px 0;
            user-select: none;
        }
        .prev2 {
            left: 0;
            border-radius: 3px 0 0 3px;
        }

        .next2 {
            right: 0;
            border-radius: 3px 0 0 3px;
        }
        .dot {
            position: relative;
            top: 5px;
            left: 0;
            cursor: pointer;
            height: 15px;
            width: 15px;
            background-color: #bbb;
            border-radius: 50%;
            display: inline-block;

        }
        .active,
        .dot:hover {
            background-color: #717171;
        }


        #king {
            display: flex;
            width: 1130px;
            margin: 0;
        }

        .interview,
        .video {
            width: 50%;
            box-sizing: border-box;
        }

        .three>p {
            font-size: 12px;
            margin-top: 10px;
        }

        .title {
            color: dimgrey;
            display: flex;
            font-size: 14px;
            margin-bottom: -5px;
        }

        .mySlides2 img {
            margin-bottom: 10px;
        }

        .mySlides2>.text {
            margin-bottom: 10px;
        }

        .text {
            position: relative;
            margin-top: 7px;
            font-size: 14px;
            color: dimgray;
        }

        li {
            list-style: none;
        }

        body {
            font-family: "Open Sans", sans-serif;
        }

        h2 {
            color: #000;
            font-size: 26px;
            font-weight: 300;
            text-align: center;
            text-transform: uppercase;
            position: relative;
            margin: 30px 0 60px;
        }

        .productName {
            height: 40px;
        }

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
        <div id="content">
            <section id="main_section">
                <div id="king">
                    <div class="interview">
                        <h1 class="title">Interview</h1><br>

                        <div class="mySlides">
                            <a href="https://www.mlb.com/news/max-scherzer-nerve-injury" target="_blank">
                                <img src="https://img.mlbstatic.com/mlb-images/image/upload/t_16x9,w_640/v1715469645/mlb/aythmzxp4a85cmoofdcu"
                                     style="width:100%" height="325">
                            </a>
                        </div>

                        <div class="mySlides">
                            <a href="https://www.mlb.com/news/justin-verlander-throws-seven-scoreless-innings-to-beat-tigers" target="_blank">
                                <img src="https://img.mlbstatic.com/mlb-images/image/upload/t_16x9,w_640/mlb/edvtcyf3r7vj5tw0cfgm"
                                     style="width:100%" height="325">
                            </a>
                        </div>

                        <div class="mySlides">
                            <a href="https://www.mlb.com/news/aaron-judge-homers-3-doubles-yankees-beat-pablo-lopez" target="_blank">
                                <img src="https://img.mlbstatic.com/mlb-images/image/upload/t_16x9,w_640/mlb/uqd0yhdexfb64ktw2gez"
                                     style="width:100%" height="325">
                            </a>
                        </div>

                        <div class="mySlides">
                            <a href="https://www.mlb.com/news/jacob-degrom-injury-hopeful-august-return" target="_blank">
                                <img src="https://img.mlbstatic.com/mlb-images/image/upload/t_16x9,w_640/mlb/ugooaw5iuhp2vtiwatsy"
                                     style="width:100%" height="325">
                            </a>
                        </div>

                        <div class="mySlides">
                            <a href="https://www.mlb.com/news/yankees-ace-gerrit-cole-throws-off-mound-for-first-time" target="_blank">
                                <img src="https://img.mlbstatic.com/mlb-images/image/upload/t_16x9,w_640/mlb/k48suv94gttm3lex2zo1"
                                     style="width:100%" height="325">
                            </a>
                        </div>

                        <div class="mySlides">
                            <a href="https://www.mlb.com/news/mike-trout-updates-knee-surgery-recovery" target="_blank">
                                <img src="https://img.mlbstatic.com/mlb-images/image/upload/t_16x9,w_640/mlb/utosn1lnf6oerckjukln"
                                     style="width:100%" height="325">
                            </a>
                        </div>

                        <div class="cc">
                            <p id="caption"></p>
                        </div>

                        <div class="mini">
                            <div class="column">
                                <img class="demo cursor"
                                     src="https://img.mlbstatic.com/mlb-images/image/upload/t_16x9,w_640/v1715469645/mlb/aythmzxp4a85cmoofdcu"
                                     width="100" height="60" onclick="currentSlide(1)" alt="Max Scherzer">
                            </div>
                            <div class="column">
                                <img class="demo cursor"
                                     src="https://img.mlbstatic.com/mlb-images/image/upload/t_16x9,w_640/mlb/edvtcyf3r7vj5tw0cfgm"
                                     style="width:100%" height="60" onclick="currentSlide(2)" alt="Justin Verlander">
                            </div>


                            <div class="column">
                                <img class="demo cursor"
                                     src="https://img.mlbstatic.com/mlb-images/image/upload/t_16x9,w_640/mlb/uqd0yhdexfb64ktw2gez"
                                     style="width: 100%" height="60" onclick="currentSlide(3)" alt="Aaron Judge">
                            </div>
                            <div class="column">
                                <img class="demo cursor"
                                     src="https://img.mlbstatic.com/mlb-images/image/upload/t_16x9,w_640/mlb/ugooaw5iuhp2vtiwatsy"
                                     style="width:100%" height="60" onclick="currentSlide(4)" alt="Jacob deGrom">
                            </div>
                            <div class="column">
                                <img class="demo cursor"
                                     src="https://img.mlbstatic.com/mlb-images/image/upload/t_16x9,w_640/mlb/k48suv94gttm3lex2zo1"
                                     style="width:100%" height="60" onclick="currentSlide(5)" alt="Gerrit Cole">
                            </div>
                            <div class="column">
                                <img class="demo cursor"
                                     src="https://img.mlbstatic.com/mlb-images/image/upload/t_16x9,w_640/mlb/utosn1lnf6oerckjukln"
                                     style="width:100%" height="60" onclick="currentSlide(6)" alt="Mike Trout">
                            </div>
                        </div>
                    </div>



                    <div class="video">
                        <h1 class="title">Video</h1><br>

                        <div class="mySlides2">
                            <iframe width="100%" height="350"
                                    src="https://www.youtube.com/embed/EbOpepcbSio?si=v2Fp3Cp0efiPX7eL" title="YouTube video player"
                                    frameborder="0"
                                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                                    referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                            <div class="text">2024 Wilson Glove Day - Atlanta</div>
                        </div>

                        <div class="mySlides2">
                            <iframe width="100%" height="350"
                                    src="https://www.youtube.com/embed/17skxnSQGYQ?si=IQkqj-MhtcLG6jAA" title="YouTube video player"
                                    frameborder="0"
                                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                                    referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                            <div class="text">2024 Wilson Glove Day - Boston</div>
                        </div>

                        <div class="mySlides2">
                            <iframe width="100%" height="350"
                                    src="https://www.youtube.com/embed/y2Yu7pwrrI0?si=9Tp_72UhlIZdxJaw" title="YouTube video player"
                                    frameborder="0"
                                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                                    referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                            <div class="text">2024 Wilson Glove Day - Baltimore</div>
                        </div>


                        <div class="mySlides2">
                            <iframe width="100%" height="350"
                                    src="https://www.youtube.com/embed/fFxGI9yIso0?si=rH8ayHVSuMvp32zZ" title="YouTube video player"
                                    frameborder="0"
                                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                                    referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                            <div class="text">2024 Wilson Glove Day - Tampa Bay</div>
                        </div>

                        <div class="mySlides2">
                            <iframe width="100%" height="350"
                                    src="https://www.youtube.com/embed/KBMG5okesuA?si=Pg-Rp1Z0kS8JEL88" title="YouTube video player"
                                    frameborder="0"
                                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                                    referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                            <div class="text">2024 Wilson Glove Day - Pittsburgh</div>
                        </div>

                        <a class="prev2" onclick="plusSlides2(-1)">❮</a>
                        <a class="next2" onclick="plusSlides2(1)">❯</a>

                        <div style="text-align:center">
                            <span class="dot" onclick="currentSlide2(1)"></span>
                            <span class="dot" onclick="currentSlide2(2)"></span>
                            <span class="dot" onclick="currentSlide2(3)"></span>
                            <span class="dot" onclick="currentSlide2(4)"></span>
                            <span class="dot" onclick="currentSlide2(5)"></span>
                        </div>
                    </div>
                </div><br><br>



            </section>
        </div>
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

    <jsp:include page="footer.jsp" flush="false"/>
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

        let slideIndex = 1;
        showSlides(slideIndex);

        function plusSlides(n) {
            showSlides(slideIndex += n);
        }
        function currentSlide(n) {
            showSlides(slideIndex = n);
        }
        function showSlides(n) {
            let i;
            let slides = document.getElementsByClassName("mySlides");
            let dots = document.getElementsByClassName("demo");
            let captionText = document.getElementById("caption");
            if (n > slides.length) { slideIndex = 1 }
            if (n < 1) { slideIndex = slides.length } for (i = 0; i < slides.length; i++) { slides[i].style.display = "none"; } for (i = 0;
                                                                                                                                     i < dots.length; i++) { dots[i].className = dots[i].className.replace(" active", ""); } slides[slideIndex -
            1].style.display = "block"; dots[slideIndex - 1].className += " active"; captionText.innerHTML = dots[slideIndex -
            1].alt;
        } let slideIndex2 = 1; showSlides2(slideIndex2);
        function plusSlides2(n) {
            showSlides2(slideIndex2 += n);
        }
        function currentSlide2(n) { showSlides2(slideIndex2 = n); }
        function showSlides2(n) {
            let i; let slides2 = document.getElementsByClassName("mySlides2");
            let dots = document.getElementsByClassName("dot");
            if (n > slides2.length) {
                slideIndex2 = 1
            }
            if (n < 1) {
                slideIndex2 = slides2.length
            }
            for (i = 0; i < slides2.length; i++) {
                slides2[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
            slides2[slideIndex2 - 1].style.display = "block"; dots[slideIndex2 - 1].className += " active";
        } function stop() { event.preventDefault(); }



    </script>
</body>
</html>