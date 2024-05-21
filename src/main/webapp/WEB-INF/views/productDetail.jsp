<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <link href="<c:url value='/css/reset.css'/>" type="text/css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet" />
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>

    <title>홈런볼 제품 상세페이지</title>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</head>
<style>

    :root {
        --btn-width : 90%;
        --btn-min-width : 90%;
        --btn-height : 5vh;
        --btn-min-height : 5px;
        --menu-height : calc(var(--btn-height) * 8);
        --menu-min-height : calc(var(--btn-min-height) * 2);
        --font-size : 2vw;
    }
    .prdContainer {
        display: flex;
        flex-direction: column;
        align-items: center;
        width: var(--btn-width);
    }
    .prdLabel {
        width: 90%;
        height: var(--btn-height);
        min-height: var(--btn-min-height);
        display: flex;
        justify-content: space-between;
        align-items: center;
        cursor: pointer;
        border-top: 0.5px solid black
    }
    .ball{
        width: calc(var(--btn-height) * 0.4);
        height: calc(var(--btn-height) * 0.4);
        transition: 0.5s ease-in-out;
    }
    .prdMenu {
        width: var(--btn-width);
        min-width: var(--btn-min-width);
        height: 0;
        overflow: hidden;
        display: flex;
        flex-flow: column;
        justify-content: flex-start;
        align-items: flex-start;
        opacity: 0;
        transition: 0.3s ease-in-out;
        list-style: none;
        margin: 0px;
        padding: 0;
        box-sizing: border-box;
        border-bottom: 0.5px solid black;
    }
    .toggle:checked ~ .prdMenu{
        height: var(--menu-height);
        min-height: var(--menu-min-height);
        opacity: 1;
        display: block;
    }
    .toggle:checked ~ .prdLabel > .ball{
        transform: rotate(540deg);
    }
    .productMainContainer{
        display: flex;
    }
    .productItem{
        flex: 1;
    }
    .detailProductContents{
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    /*상세 이미지 가운데 정렬 코드*/
    .image-container {
        text-align: center;
    }

    .image-container img {
        display: block;
        margin: 0 auto;
        width: 80%;
    }
</style>
<head>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Open+Sans">
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>
    <title>홈런볼 제품 상세페이지</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<%--넘겨줄 정보를 담는다--%>
<form id="purchaseInfo" method="post">
    <div class="productMainContainer">
<%--    상단 왼쪽에 위치한 대표이미지--%>
        <div class="productItem">
            <p>
                <img src="/img/product/${prd.pd_type_cd}/main/${prd.mn_img_fn}"
                     alt="이미지 준비 중 입니다"
                     onerror="this.onerror=null; this.src='/img/product/${prd.pd_type_cd.toLowerCase()}/main/${prd.mn_img_fn}';">
            </p>
        </div>
        <div class="productItem">
            <p>${prd.pd_name}</p>
            <p>${prd.pd_ad_cmt}</p>
            <p>판매가격:${stkInfo.sls_prc}</p>
            <p>소비자가격:${stkInfo.rtl_prc}</p>
            <p>배송:무료배송</p>
            <p>구매 주의사항</p>
            <%--선택된 옵션으로 제품을 넘겨주기--%>
            <p>옵션:
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

            <div class="prdContainer">
                <input type="checkbox" id="toggle1" class="toggle" hidden>
                <label for="toggle1" class="prdLabel">
                    제품 상세 설명 <ion-icon name="baseball-outline" class="ball"></ion-icon>
                </label>
                <ul class="prdMenu">
                    <li>${prd.pd_det_dsc}</li>
                </ul>
            </div>
            <div class="prdContainer">
                <input type="checkbox" id="toggle2" class="toggle" hidden>
                <label for="toggle2" class="prdLabel">
                    제품 특징 <ion-icon name="baseball-outline" class="ball"></ion-icon>
                </label>
                <ul class="prdMenu">
                    <li>제품 상태:${prd.qlt_cd}</li>
                    <li>제조 국가:${prd.origin}</li>
                    <li>브랜드:${prd.brd_cd}</li>
                    <li>제품 제조일자:${prd.pd_mnf_date}</li>
                    <li>재질:${prd.mtrl}</li>
                    <li>제품 무게:${prd.wgh}</li>
                    <li>제조사:${prd.mfr}</li>
                </ul>
            </div>
            <button type="button" class="submitBtn" onclick="submitForm('directOrder')">바로구매</button>
            <button type="button" class="submitBtn" onclick="submitForm('cart')">장바구니</button>
    <%--            찜하기 3차 개발예정--%>
            <button type="button" class="submitBtn" onclick="submitForm('wish')">찜하기</button>
        </div>
    </div>
</form>
<%--연관 제품 (구현 안함 발표전에 시간이 가능하면 개발)--%>
<div class="relatedProduct"></div>
<%--제품 상세 내용--%>
<div class="detailProductContents">
    <p>${prd.pd_smr_dsc}</p>
    <p class="image-container">
        <img src="/img/product/${prd.pd_type_cd}/detail/${prd.det_img_fn}"
             alt="이미지 준비 중 입니다"
             onerror="this.onerror=null; this.src='/img/product/${prd.pd_type_cd.toLowerCase()}/detail/${prd.det_img_fn}';" >
    </p>
</div>
<%--제품 리뷰(구현 안함 3차때 추후 개발예정)--%>
<div class="review"></div>
<%--제품 문의(구현 안함 3차때 추후 개발예정)--%>
<div class="productQnA"></div>
<jsp:include page="footer.jsp" flush="false" />
</body>
<script>
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
        else if (action === 'wish'){
            alert("개발예정입니다.")
            form.action = '/product/test'; //찜하기
        }
        else if (action === 'directOrder'){
            form.action = '/cart/insert'; //바로구매
        }

        /*폼 제출*/
        form.method = 'post'; //method 속성을 POST로 설정
        form.submit();
    }
    // 각 토글 체크박스에 이벤트 리스너 추가
    document.querySelectorAll('.toggle').forEach(function(checkbox) {
        checkbox.addEventListener('change', function() {
            document.querySelectorAll('.toggle').forEach(function(otherCheckbox) {
                if (otherCheckbox !== checkbox) {
                    otherCheckbox.checked = false;
                }
            });
        });
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