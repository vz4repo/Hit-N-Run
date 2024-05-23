<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet" />

    <link href="<c:url value='/css/reset.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/productDetail.css'/>" type="text/css" rel="stylesheet"/>

    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <title>홈런볼 제품 상세페이지</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<%--넘겨줄 정보를 담는다--%>
<form id="purchaseInfo" method="post">
    <div class="productMainContainer">
<%--    상단 왼쪽에 위치한 대표이미지--%>
        <div class="productItem" id="mnImg">
                <img src="/img/product/${prd.pd_type_cd}/main/${prd.mn_img_fn}"
                     alt="이미지 준비 중 입니다"
                     onerror="this.onerror=null; this.src='/img/product/${prd.pd_type_cd.toLowerCase()}/main/${prd.mn_img_fn}';">
        </div>
        <div class="productItem">
            <h2>${prd.pd_name}</h2>
            <h6>${prd.pd_ad_cmt}</h6>
            <p><b>판매가격:</b> ${stkInfo.sls_prc}원</p>
            <p><b>소비자가격:</b> ${stkInfo.rtl_prc}원</p>
            <p><b>배송:</b> 무료배송</p>
            <p><b>구매 주의사항</b></p>
            <%--선택된 옵션으로 제품을 넘겨주기--%>
            <p><b>옵션:</b>
                <select id="mySelect" name="selectedOption">
<%--                   서버에서 list를 가져와서 가지고 있는 속성을 옵션으로 만든다--%>
<%--                   listStkOpt는 재고테이블을 리스트로 읽어옵니다--%>
                   <c:forEach var="option" items="${listStkOpt}">
                       <option value="${option.pd_clsf_cd}">${option.pd_clsf_cd}</option>
                   </c:forEach>
                </select>
<%--            input으로 필요한 정보 pd_id, pd_clsf_cd를 넘겨준다.--%>
                <input id="pd_id" name="pd_id" value="${stkInfo.pd_id}" style="display: none">
                <input id="pd_clsf_cd" name="pd_clsf_cd" style="display: none">
                <input id="mn_img_fn" name="mn_img_fn" value="${prd.mn_img_fn}" style="display: none">
                <input id="pd_type_cd" name="pd_type_cd" value="${prd.pd_type_cd}" style="display: none">
            </p>
<%--            바로구매 3차 개발 예정--%>
            <div class="prdSubmitBtn">
                <button type="button" class="submitBtn" onclick="errorBtn()">바로구매</button>
                <button type="button" class="submitBtn" onclick="submitForm('cart')">장바구니</button>
<%--            찜하기 3차 개발 예정--%>
                <button type="button" class="submitBtn" onclick="errorBtn()">찜하기</button>
            </div>
<%--            토글메뉴--%>
            <div class="prdContainer">
                <input type="checkbox" id="toggle1" class="toggle" hidden>
                <label for="toggle1" class="prdLabel">
                    <h5>제품 상세 설명</h5> <ion-icon name="baseball-outline" class="ball"></ion-icon>
                </label>
                <ul class="prdMenu">
                    <li>${prd.pd_det_dsc}</li>
                </ul>
            </div>
            <div class="prdContainer">
                <input type="checkbox" id="toggle2" class="toggle" hidden>
                <label for="toggle2" class="prdLabel">
                    <h5>제품 특징</h5> <ion-icon name="baseball-outline" class="ball"></ion-icon>
                </label>
                <ul class="prdMenu">
                    <li><b>제품 상태: </b>${prd.qlt_cd}</li>
                    <li><b>제조 국가: </b>${prd.origin}</li>
                    <li><b>브랜드: </b>${prd.brd_cd}</li>
                    <li><b>제품 제조일자: </b>${prd.pd_mnf_date}</li>
                    <li><b>재질: </b>${prd.mtrl}</li>
                    <li><b>제품 무게: </b>${prd.wgh}</li>
                    <li><b>제조사: </b>${prd.mfr}</li>
                </ul>
            </div>
        </div>
    </div>
</form>
<div class="prdScroll">
    <ul class="prdList">
<%--        <li><a href="#relatedProductContainer" class="scroll_move" onclick="scrollToSection(event, 'relatedProductContainer')">연관제품</a></li>--%>
        <li><a href="#detailProductContainer" class="scroll_move" onclick="scrollToSection(event, 'detailProductContainer')">제품상세</a></li>
        <li><a href="#reviewContainer" class="scroll_move" onclick="scrollToSection(event, 'reviewContainer')">리뷰</a></li>
        <li><a href="#QnAContainer" class="scroll_move" onclick="scrollToSection(event, 'QnAContainer')">제품문의</a></li>
    </ul>
</div>
<%--연관 제품 (3차 개발 예정)--%>
<div class="relatedProductContainer" id="relatedProductContainer"></div>
<%--제품 상세 내용--%>
<div class="detailProductContainer" id="detailProductContainer">
    <p>${prd.pd_smr_dsc}</p>
    <p class="image-container">
        <img src="/img/product/${prd.pd_type_cd}/detail/${prd.det_img_fn}"
             alt="이미지 준비 중 입니다"
             onerror="this.onerror=null; this.src='/img/product/${prd.pd_type_cd.toLowerCase()}/detail/${prd.det_img_fn}';" >
    </p>
</div>
<div class="prdScroll">
    <ul class="prdList">
        <%--        <li><a href="#relatedProductContainer" class="scroll_move" onclick="scrollToSection(event, 'relatedProductContainer')">연관제품</a></li>--%>
        <li><a href="#detailProductContainer" class="scroll_move" onclick="scrollToSection(event, 'detailProductContainer')">제품상세</a></li>
        <li><a href="#reviewContainer" class="scroll_move" onclick="scrollToSection(event, 'reviewContainer')">리뷰</a></li>
        <li><a href="#QnAContainer" class="scroll_move" onclick="scrollToSection(event, 'QnAContainer')">제품문의</a></li>
    </ul>
</div>
<%--제품 리뷰(구현 안함 3차때 추후 개발예정)--%>
<div class="reviewContainer" id="reviewContainer">
    <table class="reviewTable">
        <tr><th>일련번호</th><th>내용</th><th>작성자</th><th>작성일자</th><th>평점</th></tr>
        <tr><td>5</td><td>3차 개발 예정입니다.</td><td>김지훈</td><td>2024.05.25</td><td>★★★★</td></tr>
        <tr><td>4</td><td>3차 개발 예정입니다.</td><td>김지훈</td><td>2024.05.24</td><td>★★</td></tr>
        <tr><td>3</td><td>3차 개발 예정입니다.</td><td>김지훈</td><td>2024.05.23</td><td>★</td></tr>
        <tr><td>2</td><td>3차 개발 예정입니다.</td><td>김지훈</td><td>2024.05.22</td><td>★★★</td></tr>
        <tr><td>1</td><td>리뷰입니다.</td><td>김지훈</td><td>2024.05.21</td><td>★★★★★</td></tr>
    </table><button class="writeReviewBtn" onclick="writeReviewBtn()">리뷰작성</button>
</div>
<div class="prdScroll">
    <ul class="prdList">
        <%--        <li><a href="#relatedProductContainer" class="scroll_move" onclick="scrollToSection(event, 'relatedProductContainer')">연관제품</a></li>--%>
        <li><a href="#detailProductContainer" class="scroll_move" onclick="scrollToSection(event, 'detailProductContainer')">제품상세</a></li>
        <li><a href="#reviewContainer" class="scroll_move" onclick="scrollToSection(event, 'reviewContainer')">리뷰</a></li>
        <li><a href="#QnAContainer" class="scroll_move" onclick="scrollToSection(event, 'QnAContainer')">제품문의</a></li>
    </ul>
</div>
<%--제품 문의(구현 안함 3차때 추후 개발예정)--%>
<div class="QnAContainer" id="QnAContainer">
    <table class="QnATable">
        <tr><th>일련번호</th><th>내용</th><th>작성자</th><th>작성일자</th><th>답변여부</th></tr>
        <tr><td>5</td><td>3차 개발 예정입니다.</td><td>김지훈</td><td>2024.05.25</td><td>답변완료✔</td></tr>
        <tr><td>4</td><td>3차 개발 예정입니다.</td><td>김지훈</td><td>2024.05.24</td><td>답변완료✔</td></tr>
        <tr><td>3</td><td>3차 개발 예정입니다.</td><td>김지훈</td><td>2024.05.23</td><td>답변완료✔</td></tr>
        <tr><td>2</td><td>3차 개발 예정입니다.</td><td>김지훈</td><td>2024.05.22</td><td>답변대기중</td></tr>
        <tr><td>1</td><td>제품문의입니다.</td><td>김지훈</td><td>2024.05.21</td><td>답변완료✔</td></tr>
    </table><button class="writeQnABtn" onclick="writeQnABtn()">상품문의작성</button>
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
    function scrollToSection(event, sectionId) {
        event.preventDefault();
        const headerOffset = document.querySelector('header').offsetHeight;
        const element = document.getElementById(sectionId);
        const elementPosition = element.getBoundingClientRect().top;
        const offsetPosition = elementPosition + window.pageYOffset - headerOffset;

        window.scrollTo({
            top: offsetPosition,
            behavior: 'smooth'
        });
    }
    /* 가로 스크롤 생성 */
    window.addEventListener('resize', function() {
        const bodyWidth = document.body.clientWidth;
        if (bodyWidth < 1120) {
            document.body.style.overflowX = 'auto'; // 바디의 폭이 1120보다 작을 때 가로 스크롤 생성
        } else {
            document.body.style.overflowX = 'hidden'; // 그 외에는 가로 스크롤 숨기기
        }
    });
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
</script>
</body>
</html>