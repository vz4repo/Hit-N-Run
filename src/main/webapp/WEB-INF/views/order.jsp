<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<% response.setHeader("Access-Control-Allow-Origin", "*"); %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <link href="<c:url value='/css/reset.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/order.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/payStyle.css'/>" type="text/css"  rel="stylesheet" />

    <%--   다니님 header, footer --%>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet" />
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>

    <!-- 결제위젯 SDK 추가 -->
    <script src="https://js.tosspayments.com/v1/payment-widget"></script>
    <%-- jquery --%>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <title> 주문 & 배송</title>
</head>
<body>
<%--<jsp:include page="template/header.jsp"/>--%>
<%@include file="header.jsp"%>
    <div class="order__header">
        <a href="#" class="head_main">Homerun() > 주문서</a>
        <hr class="first__under" />
        <div class="order__title">
            <div class="head_order">Order / Payment</div>
            <div class="order__title__detail">
                <a href="#">장바구니 > </a>
                <a href="#">주문서</a>
                <a href="#"> > 주문완료</a>
            </div>
        </div>
        <hr />
        <section class="order__delivery">
            <ul>
                <li>
                    <span>배송지</span>
                    <div>
                        <input type="radio" value="" id="" class="" />
                        <button>배송지변경</button>
                    </div>
                </li>
                <li>
                    <span>이름 / 연락처</span>
                </li>
            </ul>
        </section>
    </div>
    <section class="order__items">
    <hr class="first__under" />
    <div class="title__order">상품정보</div>
    <div class="tb__order">
        <form action="/order">
            <table>
                <colgroup>
                    <col width="70" />
                    <col width="*" />
                    <col width="150" />
                    <col width="150" />
                    <col width="150" />
                    <col width="150" />
                </colgroup>
                <thead>
                <tr>
                    <th scope="col">
                        <div>이미지</div>
                    </th>
                    <th scope="col">
                        <div>상품정보</div>
                    </th>
                    <th scope="col">
                        <div>판매가</div>
                    </th>
                    <th scope="col">
                        <div>수량</div>
                    </th>
                    <th scope="col">
                        <div>배송구분</div>
                    </th>
                    <th scope="col">
                        <div>주문금액</div>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="cartDto" items="${list}" varStatus="status">
                    <tr>
                        <td>
                            <a href="/product/detail?pd_id = ${cartDto.pd_id}">
                                <img src="/img/product/${cartDto.pd_type_cd.toLowerCase()}/main/${cartDto.mn_img_fn}" alt="썸네일" name="thumbnail" />
                            </a>
                        </td>
                        <td>
                            <a href="#">${cartDto.pd_name}</a>
                            <span>${cartDto.pd_clsf_code}</span>
                        </td>
                        <td><span class="priceFormat">${cartDto.sls_prc}</span></td>
                        <td><span>${cartDto.cart_cnt}</span>개</td>
                        <td><span>무료배송</span></td>
                        <td><span class="priceFormat" id="payAmt">${cartDto.sls_prc * cartDto.cart_cnt}</span></td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="1">
                        <div class="tb__left"><span>[기본배송]</span></div>
                    </td>
                </tr>
                <tr>
                    <td colspan="7">
                        <div class="tb__right">
                            <span>상품구매금액</span>
                            <span>배송비 무료</span>
                            <div>최종 결제 금액
                                <span class="" id="totalSum">${cartDto.sls_prc * cartDto.cart_cnt}</span>
                            </div>
                        </div>
                    </td>
                </tr>
                </tfoot>
            </table>
        </form>
    </div>
    </section>
<section class="order__payment">
    <%@include file="payCheckout.jsp"%>
</section>
<%@include file="footer.jsp"%>
<script>
    $(document).ready(function(){
        $('.priceFormat').each(function (){
            let value = $(this).text();
            value = value.replace(/,/g, '');
            const numbericValue = parseInt(value);
            const formatValue = numbericValue.toLocaleString('ko-KR');
            $(this).text(formatValue+'원');
        })

    })

    /*테이블의 행 수를 동적으로 계산*/
    window.onload = function() {
        const rows = document.querySelectorAll('body > section.order__items > div.tb__order > form > table > tbody > tr');
        let totalSum = 0;

        rows.forEach(function(row) {
            /* 각 행의 6번째 셀(td)에서 판매가를 가져와서 총합구하기 */
            const price = row.cells[5].innerText;
            totalSum += parseInt(price.replace(/[^\d]/g, ''));
        });
        <%--/*총합을 나타낼 위치*/--%>
        document.getElementById('totalSum').innerText = totalSum.toLocaleString('ko-KR') + '원';
    }

</script>
</body>

</html>