<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/img/icon_logo.png">
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

    <link href="<c:url value='/css/reset.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/search.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/productDetail.css'/>" type="text/css" rel="stylesheet"/>

    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <title>홈런볼 제품 상세페이지</title>
</head>
<body class="productDetail">
<jsp:include page="header.jsp"/>
<%--넘겨줄 정보를 담는다--%>
<form id="purchaseInfo" method="post">
    <div class="productMainContainer">
<%--    상단 왼쪽에 위치한 대표이미지--%>
        <div class="productItemMnImg" id="mnImg">
                <img src="/img/product/${prd.pd_type_cd}/main/${prd.mn_img_fn}"
                     alt="이미지 준비 중 입니다"
                     onerror="this.onerror=null; this.src='/img/product/${prd.pd_type_cd.toLowerCase()}/main/${prd.mn_img_fn}';">
        </div>
        <div class="productItemDsc">
            <div class="prdDetailTitle">
                <h2>${prd.pd_name}</h2>
                <c:set var="myValue" value="${prd.pd_ad_cmt}" />
                <c:choose>
                    <c:when test="${not empty myValue}">
                        <p class="prdDetailTitlePara">${myValue}</p>
                    </c:when>
                    <c:otherwise>
                        <p></p>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="prdDetail">
                <div class="title">
                    <ul class="titleList">
                        <li><b>옵션 </b></li>
                        <li><b>추가 상품 </b></li>
                        <li><b>판매가 </b></li>
                    </ul>
                </div>
                <div class="content">
                    <ul class="contentList">
<%--                        옵션--%>
                        <li><select id="mySelect" name="selectedOption">
                            <%--                   서버에서 list를 가져와서 가지고 있는 속성을 옵션으로 만든다--%>
                            <%--                   listStkOpt는 재고테이블을 리스트로 읽어옵니다--%>
                            <c:forEach var="option" items="${listStkOpt}">
                                <option value="${option.pd_clsf_cd}">${option.pd_clsf_cd}</option>
                            </c:forEach>
<%--                        가격--%>
                        </select></li>
                        <li><select id="mySelect2">
                            <option>선택</option>
                            <option>종이백</option>
                            <option>선물박스</option>
                        </select></li>
                        <li class="prcDis"><span id="retail-price"><span id="rtl_prc">${stkInfo.rtl_prc}</span></span><span id="sale-price"><span id="sls_prc"> ${stkInfo.sls_prc}</span></span>원</li>
<%--                        <li>무료배송</li>--%>
                    </ul>
                </div>
            </div>
            <%--            바로구매 3차 개발 예정--%>
            <div class="prdSubmitBtn">
                <ul>
                    <li class="buyBtnList">
                        <button type="button" class="submitBtn">바로구매</button>
                    </li>
                </ul>
                <ul>
                    <li class="cartBtnList">
                        <button type="button" class="submitBtn" onclick="submitForm('cart')">
                           장바구니 담기 <ion-icon name="bag-outline"></ion-icon>
                        </button>
                    </li>
                    <li class="wishBtnList">
                        <%--            찜하기 3차 개발 예정--%>
                        <button type="button" id="heartIconBtn" class="prdWishBtn">
                            <ion-icon id="heartIcon" name="heart-outline"></ion-icon>
                        </button>
                    </li>
                </ul>
                <ul>
                    <li class="sendGiftBtnList">
                        <button type="button" class="sendGift">선물하기<ion-icon name="gift-outline"></ion-icon></button>
                    </li>
                </ul>
            </div>
<%--            input으로 필요한 정보 pd_id, pd_clsf_cd를 넘겨준다.--%>
                <input id="pd_id" name="pd_id" value="${stkInfo.pd_id}" style="display: none">
                <input id="pd_clsf_cd" name="pd_clsf_cd" style="display: none">
                <input id="mn_img_fn" name="mn_img_fn" value="${prd.mn_img_fn}" style="display: none">
                <input id="pd_type_cd" name="pd_type_cd" value="${prd.pd_type_cd}" style="display: none">

<%--            프로모션 정보--%>
            <div class="prdDtlInfo">
                <p><ion-icon name="rocket-outline"></ion-icon> 5만원 이상 구매시 무료배송</p>
                <p><ion-icon name="create-outline"></ion-icon> 리뷰 작성시 적립금 지급</p>
                <p><ion-icon name="diamond-outline"></ion-icon> 등급별 최대 10% 할인</p>
            </div>
<%--            토글메뉴--%>
            <div class="prdContainer">
                <input type="checkbox" id="toggle1" class="toggle" hidden>
                <label for="toggle1" class="prdLabel">
                    <p><b>제품 상세 설명</b></p> <ion-icon name="baseball-outline" class="ball"></ion-icon>
                </label>
                <ul class="prdMenu">
                    <li>${prd.pd_det_dsc}</li>
                </ul>
            </div>
            <div class="prdContainer">
                <input type="checkbox" id="toggle2" class="toggle" hidden>
                <label for="toggle2" class="prdLabel">
                    <p><b>제품 특징</b></p> <ion-icon name="baseball-outline" class="ball"></ion-icon>
                </label>
                <ul class="prdMenu">
                    <li><b>제품 상태: </b>${prd.qlt_cd}</li>
                    <li><b>제조 국가: </b>${prd.origin}</li>
                    <li><b>브랜드: </b>${prd.brd_cd}</li>
                    <li><b>제품 제조일자: </b><span id="formattedDate" data-date="${prd.pd_mnf_date}"></span></li>
                    <li><b>재질: </b>${prd.mtrl}</li>
                    <li><b>제품 무게: </b>${prd.wgh}</li>
                    <li><b>제조사: </b>${prd.mfr}</li>
                </ul>
            </div>
        </div>
    </div>
</form>
<%--이전에 작성한 네비게이션 바--%>
<%--<div class="prdScroll">--%>
<%--    <ul class="prdList">--%>
<%--&lt;%&ndash;        <li><a href="#relatedProductContainer" class="scroll_move" onclick="scrollToSection(event, 'relatedProductContainer')">연관제품</a></li>&ndash;%&gt;--%>
<%--        <li><a href="#detailProductContainer" class="scroll_move" onclick="scrollToSection(event, 'detailProductContainer')">제품상세</a></li>--%>
<%--        <li><a href="#reviewContainer" class="scroll_move" onclick="scrollToSection(event, 'reviewContainer')">리뷰</a></li>--%>
<%--        <li><a href="#QnAContainer" class="scroll_move" onclick="scrollToSection(event, 'QnAContainer')">제품문의</a></li>--%>
<%--    </ul>--%>
<%--</div>--%>
<!--   Sticky Nav 부분 -->
<div class="prdNavbar" id="prdNavbar">
    <ul>
        <li><a class="prdActive" href="#relatedProductContainer" id="relatedNav">연관제품</a></li>
        <li><a href="#detailProductContainer" id="detailNav">제품상세</a></li>
        <li><a href="#reviewContainer" id="reviewNav">리뷰</a></li>
        <li><a href="#QnAContainer" id="QnANav">제품문의</a></li>
    </ul>
</div>
<%--연관 제품 (3차 개발 예정)--%>
<div class="relatedProductContainer" id="relatedProductContainer">
    <div class="prdRltdTitle"><h2><b>고객들이 많이 조회한 연관 제품</b></h2></div>
    <div class="prdRltdContainer">
        <div class="prdRltd">
            <a href="http://localhost:9090/product/detail?pd_id=GLV000020-30">
                <img src="/img/product/GLV/main/GLV000020-30.jpg"
                     alt="이미지 준비 중 입니다"
                     onerror="this.onerror=null; this.src='/img/product/glv/main/GLV000020-30.jpg';">
                <div class="prdRltdName">롤링스 한정판 아버지의 날 REV1X 내야 장갑</div>
            </a>
        </div>
        <div class="prdRltd">
            <a href="http://localhost:9090/product/detail?pd_id=GLV000019-00">
                <img src="/img/product/GLV/main/GLV000019-00.jpg"
                     alt="이미지 준비 중 입니다"
                     onerror="this.onerror=null; this.src='/img/product/glv/main/GLV000019-00.jpg';">
                <div class="prdRltdName">롤링스 REV1X 11.75인치 내야 글러브</div>
            </a>
        </div>
        <div class="prdRltd">
            <a href="http://localhost:9090/product/detail?pd_id=GLV000018-67">
                <img src="/img/product/GLV/main/GLV000018-67.jpg"
                     alt="이미지 준비 중 입니다"
                     onerror="this.onerror=null; this.src='/img/product/glv/main/GLV000018-67.jpg';">
                <div class="prdRltdName">REV1X 11.5인치 인필드 프로-I 웹 글러브</div>
            </a>
        </div>
    </div>
</div>
<%--제품 상세 내용--%>
<div class="detailProductContainer" id="detailProductContainer">
    <p class="title">상세 정보</p>
    <p class="image-container">
        <img src="/img/product/${prd.pd_type_cd}/detail/${prd.det_img_fn}"
             alt="이미지 준비 중 입니다"
             onerror="this.onerror=null; this.src='/img/product/${prd.pd_type_cd.toLowerCase()}/detail/${prd.det_img_fn}';" >
    </p>
    <p class="smr_dsc">${prd.pd_smr_dsc}</p>
</div>
<div class="reviewContainer" id="reviewContainer">
    <h2>리뷰</h2>
    <table class="reviewTable">
        <tr><th>일련번호</th><th>내용</th><th>작성자</th><th>작성일자</th><th>평점</th></tr>
        <tr><td>10</td><td>포장도 신경써주시고 배송도 빠르게 잘 왔습니다.</td><td>김지훈</td><td>2024.05.28</td><td>★★★★★</td></tr>
        <tr><td>9</td><td>다른 제품이 왔습니다.</td><td>김지훈</td><td>2024.05.27</td><td>★★</td></tr>
        <tr><td>8</td><td>항상 잘 이용하고 있습니다.</td><td>김지훈</td><td>2024.05.26</td><td>★★★★</td></tr>
        <tr><td>7</td><td>배송이 좀 걸리네요.</td><td>김지훈</td><td>2024.05.26</td><td>★★★</td></tr>
        <tr><td>6</td><td>항상 잘 구매하고 있습니다.</td><td>김지훈</td><td>2024.05.25</td><td>★★★★</td></tr>
        <tr><td>5</td><td>저렴한 가격에 잘 샀습니다.</td><td>김지훈</td><td>2024.05.25</td><td>★★★★</td></tr>
        <tr><td>4</td><td>배송이 3주나 걸렸네요.</td><td>김지훈</td><td>2024.05.24</td><td>★★</td></tr>
        <tr><td>3</td><td>제품이 파손되서 도착했습니다.</td><td>김지훈</td><td>2024.05.23</td><td>★</td></tr>
        <tr><td>2</td><td>그럭 저럭 괜찮습니다.</td><td>김지훈</td><td>2024.05.22</td><td>★★★</td></tr>
        <tr><td>1</td><td>빠른 배송 감사합니다.</td><td>김지훈</td><td>2024.05.21</td><td>★★★★★</td></tr>

    </table>
    <p> <a href="">&lt</a>
        <a href="">1</a>
        <a href="">2</a>
        <a href="">3</a>
        <a href="">4</a>
        <a href="">5</a>
        <a href="">6</a>
        <a href="">7</a>
        <a href="">8</a>
        <a href="">9</a>
        <a href="">10</a>
        <a href="">&gt</a></p>
    <button class="writeReviewBtn" onclick="writeReviewBtn()">리뷰작성</button>
</div>

<%--제품 문의(구현 안함 3차때 추후 개발예정)--%>
<div class="QnAContainer" id="QnAContainer">
    <h2>제품문의</h2>
    <table class="QnATable" name="QnATable">
        <tr><th>일련번호</th><th>내용</th><th>작성자</th><th>작성일자</th><th>답변여부</th></tr>
        <tr><td>10</td><td>DP 제품 할인은 안 하나요?</td><td>김지훈</td><td>2024.05.27</td><td>답변대기중</td></tr>
        <tr><td>9</td><td>배송 문의드립니다. 급해서 그런데 혹시 오늘 회사에 방문하면 제품을 바로 받을수 있을까요?</td><td>김지훈</td><td>2024.05.27</td><td>답변대기중</td></tr>
        <tr><td>8</td><td>배송 문의드립니다. 오늘 시키면 언제 제품을 받을수 있을까요?</td><td>김지훈</td><td>2024.05.26</td><td>답변대기중</td></tr>
        <tr><td>7</td><td>AS보증 기간이 어떻게 되나요?</td><td>김지훈</td><td>2024.05.26</td><td>답변대기중</td></tr>
        <tr><td>6</td><td>무게가 어떻게 되나요?</td><td>김지훈</td><td>2024.05.26</td><td>답변대기중</td></tr>
        <tr><td>5</td><td>단체 주문도 가능할까요?</td><td>김지훈</td><td>2024.05.25</td><td>답변완료✔</td></tr>
        <tr><td>4</td><td>색상 문의 드립니다.</td><td>김지훈</td><td>2024.05.24</td><td>답변완료✔</td></tr>
        <tr><td>3</td><td>사이즈 문의 드립니다.</td><td>김지훈</td><td>2024.05.23</td><td>답변완료✔</td></tr>
        <tr><td>2</td><td>제품의 추가 입고는 언제되나요?</td><td>김지훈</td><td>2024.05.22</td><td>답변대기중</td></tr>
        <tr><td>1</td><td>제품 문의 드립니다.</td><td>김지훈</td><td>2024.05.21</td><td>답변완료✔</td></tr>
    </table>
    <p> <a href="">&lt</a>
        <a href="">1</a>
        <a href="">2</a>
        <a href="">3</a>
        <a href="">4</a>
        <a href="">5</a>
        <a href="">6</a>
        <a href="">7</a>
        <a href="">8</a>
        <a href="">9</a>
        <a href="">10</a>
        <a href="">&gt</a></p>
    <button class="writeQnABtn" onclick="writeQnABtn()">제품문의작성</button>
</div>
<jsp:include page="footer.jsp" flush="false" />
</body>
<script>
    function errorBtn(){
        alert("3차 개발 예정입니다")
    }
    function writeReviewBtn(){
        alert("3차 개발 예정입니다")
    }
    function writeQnABtn(){
        alert("3차 개발 예정입니다")
    }
    /*버튼별 이동 페이지 설정*/
    function submitForm(action){
        var form = document.getElementById('purchaseInfo');

        /* 선택한 옵션을 pd_clsf_cd의 value로 설정*/
        var selectElement = document.getElementById("mySelect"); //mySelect의 참조 설정
        var selectedValue = selectElement.value; // mySelect의 값을 변수에 저장
        document.getElementById("pd_clsf_cd").value = selectedValue; //pd_clsf_cd라는 input태그에 담아서 넘긴다.

        /*form action의 경로 설정*/
        if(action === 'cart'){
            form.action = '/cart/insert'; //장바구니
        }
        // else if (action === 'wish'){
        //     alert("개발예정입니다.");
        //     form.action = '/product/test'; //찜하기
        // }
        // else if (action === 'directOrder'){
        //     alert("개발예정입니다.");
        //     form.action = '/product/test'; //바로구매
        // }

        /*폼 제출*/
        form.method = 'post'; //method 속성을 POST로 설정
        form.submit();
    }
    /* 각 토글 체크박스에 이벤트 리스너 추가 */
    document.querySelectorAll('.toggle').forEach(function(checkbox) {
        checkbox.addEventListener('change', function() {
            document.querySelectorAll('.toggle').forEach(function(otherCheckbox) {
                if (otherCheckbox !== checkbox) {
                    otherCheckbox.checked = false;
                }
            });
        });
    });

    /*스크롤 바 위치 조정(기존에는 헤더와 겹쳤다)*/
    // function scrollToSection(event, sectionId) {
    //     event.preventDefault();
    //     const headerOffset = document.querySelector('header').offsetHeight;
    //     const element = document.getElementById(sectionId);
    //     const elementPosition = element.getBoundingClientRect().top;
    //     const offsetPosition = elementPosition + window.pageYOffset - headerOffset;
    //
    //     window.scrollTo({
    //         top: offsetPosition,
    //         behavior: 'smooth'
    //     });
    // }

    // 스크롤 내려갈 시 고정될 nav
    function handleNavbarScroll() {
        var navbar = document.getElementById("prdNavbar");
        if (!navbar) return; // 해당 요소가 없는 경우 함수 종료

        var sticky = navbar.offsetTop;
        var navbarHeight = navbar.offsetHeight;

        function getHeaderHeight() {
            var header = document.querySelector("header");
            return header ? header.offsetHeight : 0;
        }

        function getSectionOffsets() {
            return {
                relatedProduct: document.getElementById("relatedProductContainer").offsetTop,
                detailProductContainer: document.getElementById("detailProductContainer").offsetTop,
                reviewContainer: document.getElementById("reviewContainer").offsetTop,
                QnAContainer: document.getElementById("QnAContainer").offsetTop
            };
        }

        var navLinks = {
            relatedProduct: document.getElementById("relatedNav"),
            detailProductContainer: document.getElementById("detailNav"),
            reviewContainer: document.getElementById("reviewNav"),
            QnAContainer: document.getElementById("QnANav")
        };

        var headerHeight = getHeaderHeight();
        var sections = getSectionOffsets();

        if (window.pageYOffset >= sticky) {
            // 헤더의 top 값을 확인하여 클래스 추가
            if (document.getElementById("cart__header").style.top == "-200px") {
                navbar.classList.add("sticky2");
                navbar.classList.remove("sticky");
            } else {
                navbar.classList.add("sticky");
                navbar.classList.remove("sticky2");
            }

            var currentSection = null;
            for (var section in sections) {
                if (window.pageYOffset >= sections[section] - headerHeight - navbarHeight) {
                    currentSection = section;
                }
            }

            for (var section in navLinks) {
                if (section === currentSection) {
                    navLinks[section].classList.add("prdActive");
                } else {
                    navLinks[section].classList.remove("prdActive");
                }
            }
        } else {
            navbar.classList.remove("sticky", "sticky2");

            navLinks.relatedProduct.classList.add("prdActive");
            for (var section in navLinks) {
                if (section !== "relatedProduct") {
                    navLinks[section].classList.remove("prdActive");
                }
            }
        }
    }

    var prevScrollpos = window.pageYOffset;
    function handleHeaderScroll() {
        var currentScrollPos = window.pageYOffset;
        if (prevScrollpos > currentScrollPos) {
            document.getElementById("cart__header").style.top = "0";
        } else {
            document.getElementById("cart__header").style.top = "-200px";
        }
        prevScrollpos = currentScrollPos;
    }

    document.addEventListener("DOMContentLoaded", function() {
        // 첫 번째 기능: QnATable 처리
        var tables = document.getElementsByName('QnATable');
        tables.forEach(function(table) {
            var cells = table.getElementsByTagName('td');
            for (var i = 0; i < cells.length; i++) {
                if (cells[i].innerText === '답변완료✔') {
                    cells[i].classList.add('QnATableAnswered');
                }
            }
        });

        // 두 번째 기능: updatePrices 호출 및 초기 스크롤 상태 반영
        updatePrices();
        window.onscroll(); // 페이지 로드 시 초기 스크롤 상태를 반영
    });

    // 스크롤 이벤트 핸들러 통합
    window.onscroll = function () {
        handleHeaderScroll();
        if (typeof handleNavbarScroll === 'function') {
            handleNavbarScroll();
        }
    };

    // 네비게이션 링크 클릭 시 스크롤 이동
    for (var section in navLinks) {
        navLinks[section].onclick = function(event) {
            event.preventDefault();
            var targetId = this.getAttribute("href").substring(1);
            var targetElement = document.getElementById(targetId);
            var headerHeight = getHeaderHeight();
            window.scrollTo({
                top: targetElement.offsetTop - headerHeight - navbarHeight,
                behavior: "smooth"
            });
        };
    }

    // /* 가로 스크롤 생성 */
    // window.addEventListener('resize', function() {
    //     const bodyWidth = document.body.clientWidth;
    //     if (bodyWidth < 1120) {
    //         document.body.style.overflowX = 'auto'; // 바디의 폭이 1120보다 작을 때 가로 스크롤 생성
    //     } else {
    //         document.body.style.overflowX = 'hidden'; // 그 외에는 가로 스크롤 숨기기
    //     }
    // });
    /* 장바구니에 담을때, 제품상세 또는 장바구니 페이지로 이동할지 선택*/
    // 1. 장바구니 버튼을 누를시 장바구니에 제품상세의 정보를 넘겨야한다.
    // 2. 페이지 이동을 할지 묻는 버튼
    // 3. 이동 버튼을 누르면, 장바구니 페이지로 이동. 아니라면, 기존페이지에 있는다.
    // 방법이 두가지 있다. 넘기기전에 이동할지 이동안할지 묻고, 이동하면 컨트롤러에서 그대로 보내주면 되고, 아니면 리다리렉트로 다시 돌아오기
    // 하나는 ajax로 서버에 정보를 보내주고, 메세지 또는 경고창으로 이동유무를 묻고 이어준다.

    // /*선택한 옵션을 다음페이지에 넘겨주기 ajax로 구현하다가 안되서 보류*/
    // $(document).ready(function(){
    //     $(".submitBtn").click(function (){
    //         var pd_id = $("#pd_id").text();
    //         var pd_clsf_cd = $("#pd_clsf_cd").text();
    //
    //         var data ={
    //             pd_id: pd_id,
    //             pd_clsf_cd
    //         };
    //
    //         $.ajax({
    //             type: "POST",
    //             url: "/product/detail",
    //             headers: {"content_type": "application/jspn"},
    //             data: JSON.stringify(data),
    //             success: function (){
    //                 alert("변경성공");
    //             },
    //             error: function (xhr, status, error){
    //                 alert(error);
    //             }
    //         })
    //     })
    // })
    /* wish버튼 애니매이션 */
    document.getElementById('heartIconBtn').addEventListener('click', function() {
        const icon = document.getElementById('heartIcon');
        const currentName = icon.getAttribute('name');
        icon.setAttribute('name', currentName === 'heart-outline' ? 'heart' : 'heart-outline');
        if(currentName !== 'heart'){
            icon.classList.add('fillColor');
            // Remove the animation class after it ends to allow re-triggering
            setTimeout(() => {
                icon.classList.remove('fillColor');
                icon.style.color = 'red';
            }, 1000);
        } else {
            icon.style.color = '#333';
        }
    });
    // // 가격 정의
    // function formatPrice(price) {
    //     return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    // }
    // // 답변완료 텍스트를 초록색으로 바꿔줌
    // document.addEventListener("DOMContentLoaded", function() {
    //     var tables = document.getElementsByName('QnATable');
    //
    //     tables.forEach(function(table) {
    //         var cells = table.getElementsByTagName('td');
    //         for (var i = 0; i < cells.length; i++) {
    //             if (cells[i].innerText === '답변완료✔') {
    //                 cells[i].classList.add('QnATableAnswered');
    //             }
    //         }
    //     });
    // });
    // 가격을 포맷하는 함수 (예시)
    function formatPrice(price) {
        return parseInt(price).toLocaleString('ko-KR');
    }

    // 가격 값을 포맷하여 업데이트하는 함수
    function updatePrices() {
        const salePriceElement = document.getElementById('sls_prc');
        const retailPriceElement = document.getElementById('rtl_prc');
        const retailPriceContainer = document.getElementById('retail-price');

        // 원래 텍스트를 가져옴
        const salePrice = salePriceElement.innerText;
        const retailPrice = retailPriceElement.innerText;

        // 가격을 비교
        if (parseInt(salePrice) >= parseInt(retailPrice)) {
            // sls_prc가 더 크거나 같은 경우 rtl_prc를 숨김
            retailPriceContainer.style.display = 'none';
            // 판매가의 글자 색상을 검정색으로 변경
            salePriceElement.style.color = '#333';
        } else {
            // 포맷된 가격을 설정
            retailPriceElement.innerText = formatPrice(retailPrice);
        }
        // salePrice는 항상 포맷하여 표시
        salePriceElement.innerText = formatPrice(salePrice);
    }

    // DOMContentLoaded 이벤트를 사용하여 DOM이 완전히 로드된 후 실행
    // document.addEventListener('DOMContentLoaded', (event) => {
    //     updatePrices();
    // });
    function formatDateString(dateString) {
        // 날짜 문자열을 변환
        var year = dateString.substring(0, 4);
        var month = dateString.substring(4, 6);
        var day = dateString.substring(6, 8);

        // 원하는 형식으로 변환
        return year + "년 " + month + "월 " + day + "일";
    }

    document.addEventListener("DOMContentLoaded", function() {
        // HTML 데이터 속성에서 서버에서 가져온 날짜 문자열 읽기
        var dateString = document.getElementById("formattedDate").getAttribute("data-date");
        console.log(dateString); // 디버깅용으로 콘솔에 출력
        // 날짜 형식을 변경하여 HTML 요소에 출력
        document.getElementById("formattedDate").innerText = formatDateString(dateString);
    });
</script>
</body>
</html>