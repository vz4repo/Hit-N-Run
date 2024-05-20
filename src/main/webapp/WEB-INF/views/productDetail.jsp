<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>홈런볼 제품 상세페이지</title>
</head>
<body>
<%--제품 상세 정보 표기--%>
<%--선택된 옵션으로 제품을 넘겨주기--%>

<%--넘겨줄 정보를 담는다--%>
<div class="productMainContainer">
    <form id="purchaseInfo" method="post">
<%--    상단 왼쪽에 위치한 대표이미지--%>
        <div class="productItem">
            <p>
                <img src="/img/product/${prd.pd_type_cd.toLowerCase()}/main/${prd.mn_img_fn}"
                     alt="이미지 준비 중 입니다"
                     onerror="this.onerror=null; this.src='/img/product/altImg.jpg';">
            </p>
        </div>
        <div class="productItem">
            <p>${prd.pd_name}</p>
            <p>${prd.pd_ad_cmt}</p>

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

            <p>판매가격:${stkInfo.sls_prc}</p>
            <p>소비자가격:${stkInfo.rtl_prc}</p>
            <p>제품 상세 설명(제품post연결후 토글로)</p>
            <p>${prd.pd_det_dsc}</p>
            <p>제품 특징(제품post연결후 토글로)</p>
            <p>제품 상태:${prd.qlt_cd}</p>
            <p>제조 국가:${prd.origin}</p>
            <p>브랜드:${prd.brd_cd}</p>
            <p>제품 제조일자:${prd.pd_mnf_date}</p>
            <p>재질:${prd.mtrl}</p>
            <p>제품 무게:${prd.wgh}</p>
            <p>제조사:${prd.mfr}</p>
            <p>배송:무료배송</p>
            <p>구매 주의사항</p>
            <button type="button" class="submitBtn" onclick="submitForm('directOrder')">바로구매</button>
            <button type="button" class="submitBtn" onclick="submitForm('cart')">장바구니</button>
    <%--            찜하기 3차 개발예정--%>
            <button type="button" class="submitBtn" onclick="submitForm('wish')">찜하기</button>

        </div>
    </form>
</div>
<%--연관 제품 (구현 안함 발표전에 시간이 가능하면 개발)--%>
<div class="relatedProduct"></div>
<%--제품 상세 내용--%>
<div class="detailProductContents">
    <p>
        <img src="/img/product/${prd.pd_type_cd.toLowerCase()}/main/${prd.det_img_fn}"
             alt="이미지 준비 중 입니다"
             onerror="this.onerror=null; this.src='/img/product/altImg.jpg';">
    </p>
    <p>${prd.pd_smr_dsc}</p>
</div>
<%--제품 리뷰(구현 안함 3차때 추후 개발예정)--%>
<div class="review"></div>
<%--제품 문의(구현 안함 3차때 추후 개발예정)--%>
<div class="productQnA"></div>
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
            form.action = '/product/test'; //찜하기
        }
        else if (action === 'directOrder'){
            form.action = '/cart/insert'; //바로구매
        }

        /*폼 제출*/
        form.method = 'post'; //method 속성을 POST로 설정
        form.submit();
    }

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
</html>
