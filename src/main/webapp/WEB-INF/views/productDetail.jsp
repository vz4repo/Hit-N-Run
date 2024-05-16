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
<p><a href="/product/detail?pd_id=APP000001-20">의류</a></p>
<p><a href="/product/detail?pd_id=BAT000001-99">배트1</a></p>
<p><a href="/product/detail?pd_id=BAT000002-20">배트2</a></p>
<p><a href="/product/detail?pd_id=GLV000001-99">글러브1</a></p>
<p><a href="/product/detail?pd_id=GLV000002-50">글러브2</a></p>
<p><a href="/product/detail?pd_id=SHO000001-00">신발</a></p>
<div class="productMain">
    <form id="purchaseInfo" method="post">
        <p><img src="${prd.mn_img_fn}" alt="이미지를 준비중입니다."></p>
        <p>${prd.pd_name}</p>
        <p>${prd.pd_ad_cmt}</p>

        <p>옵션:
            <select id="mySelect" name="selectedOption">
<%--                서버에서 list를 가져와서 가지고 있는 속성을 옵션으로 만든다--%>
<%--                listStkOpt는 재고테이블을 리스트로 읽어옵니다--%>
                <c:forEach var="option" items="${listStkOpt}">
                    <option value="${option.pd_clsf_cd}">${option.pd_clsf_cd}</option>
                </c:forEach>
            </select>
<%--            input으로 필요한 정보 pd_id, pd_clsf_cd를 넘겨준다.--%>
            <input id="pd_id" name="pd_id" value="${stkInfo.pd_id}" style="display: none">
            <input id="pd_clsf_cd" name="pd_clsf_cd" style="display: none">
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
        <button type="button" class="submitBtn" onclick="submitForm('cart')">장바구니</button>
        <button type="button" class="submitBtn" onclick="submitForm('wish')">찜하기</button>
    </form>
</div>
<%--연관 제품 (구현 안함 발표전에 시간이 가능하면 개발)--%>
<div class="relatedProduct"></div>
<%--제품 상세 내용--%>
<div class="detailProductContents">
    <p><img src="${prd.det_img_fn}" alt="이미지 준비중입니다."></p>
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
        var selectElement = document.getElementById("mySelect");
        var selectedValue = selectElement.value;
        document.getElementById("pd_clsf_cd").value = selectedValue;

        /*action에 따라 처리*/
        if(action === 'cart'){
            /*첫 번째 버튼의 목적지로 전송*/
            form.action = '/cart/insert';
        }
        else if (action === 'wish'){
            /*두 번째 버튼의 목적지로 전송*/
            form.action = '/product/test';
        }

        /*폼 제출*/
        form.method = 'post'; //method 속성을 POST로 설정
        form.submit();
    }
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
