<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<% response.setHeader("Access-Control-Allow-Origin", "*"); %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap"
          rel="stylesheet"/>
    <link href="<c:url value='/css/reset.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/order.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/payStyle.css'/>" type="text/css" rel="stylesheet"/>

    <%--   다니님 header, footer --%>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet"/>
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>

    <!-- 결제위젯 SDK 추가 -->
    <script src="https://js.tosspayments.com/v1/payment-widget"></script>
    <%-- jquery --%>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <title> 주문 & 배송</title>
</head>
<%-- 김수연 시작 --%>
<style>
    #deliveryForm {
        display: flex;
        justify-content: center;
        flex-wrap: wrap; /* 요소가 너무 많을 때 다음 줄로 넘어갈 수 있도록 설정 */
    }

    #delivery_left {
        text-align: center;
        width: 20%;
        height: 100%;
    }

    #delivery_right {
        width: 80%;
        height: 100%;
    }
</style>

<%-- 김수연 끝 --%>
<body>
<%--<jsp:include page="template/header.jsp"/>--%>
<jsp:include page="header.jsp"/>
<div class="order__header">
    <a href="#" class="head_main">Homerun() > 주문서</a>
    <hr class="first__under"/>
    <div class="order__title">
        <div class="head_order">Order / Payment</div>
        <div class="order__title__detail">
            <a href="#">장바구니 > </a>
            <a href="#">주문서</a>
            <a href="#"> > 주문완료</a>
        </div>
    </div>
    <hr/>
    <section class="order__delivery">
        <%-- 김수연 시작 --%>
        <%-- 고객이 선택한 배송지 뜨는 페이지 _ order.jsp --%>
        <div>
            <div id="delivery_left" class="head_order">
                Delivery
            </div>
            <div id="delivery_right">
            </div>
        </div>

        <hr class="first__under"/>
        <div id="selectedDLV" class="center-table">
            <table>
                <tr>
                    <%-- c_id : 고객 번호--%>
                    <td>고객 C_ID</td>
                    <td>${sessionScope.c_id}</td>
                </tr>
                <tr>
                    <%-- rcver : 고객명 / --%>
                    <td>이름(장소명)</td>
                    <td>${selectedDto.rcver}(${selectedDto.adr_name})</td>
                </tr>
                <tr>
                    <%-- rcver_phn : 고객 연락처 --%>
                    <td>연락처</td>
                    <td>${selectedDto.rcver_phn}</td>
                </tr>
                <tr>
                    <%-- rcver_adr : 고객 주소--%>
                    <td>주소</td>
                    <td>${selectedDto.rcver_adr}</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <%-- 여기서 배송지 변경 버튼 누르면, deliveryList.jsp 페이지로 이동해야한다. --%>
                        <%--<button id="changeAdrList" onclick="redirectToDeliveryList()">배송지 변경</button>--%>
                        <%--                                <button id="selectAllBtn">배송지 전체 조회</button>--%>
                    </td>
                </tr>
            </table>
        </div>
        <hr/>


        <%-- 김수연 끝 --%>


        <%--            <%@include file="deliveryList.jsp"%>--%>
        <%--            <% String rcver = request.getParameter("rcver"); %>--%>
        <%--            <div>--%>
        <%--                --%>
        <%--            </div>--%>

        <%--                <div id="deliveryForm">--%>
        <%--                    &lt;%&ndash; 여기에 배송지 목록이 동적으로 채워질 것입니다. &ndash;%&gt;--%>
        <%--                </div>--%>


        <%--                <c:import url="<%= request.getContextPath() %>/delivery/" />--%>
        <%--                <h1><c:out value="웅냥냥"/></h1>--%>
        <%--                <script>--%>
        <%--                    var contextPath = "${pageContext.request.contextPath}";--%>
        <%--                    console.log("Context Path: " + contextPath);--%>

        <%--                    // 예를 들어, id가 "contextPathDisplay"인 요소에 contextPath를 추가하는 경우--%>
        <%--                    document.getElementById("contextPathDisplay").innerText = "Context Path: " + contextPath;--%>

        <%--                </script>--%>
        <%--                <h1><c:out value="${request.getContextPath()}"/></h1>--%>
        <%--                <h1><c:out value="${pageContext.request.contextPath}"/></h1>--%>

        <%--                <c:import url="${pageContext.request.contextPath}/delivery/" />--%>


    </section>
</div>
<section class="order__items">
    <hr class="first__under"/>
    <div class="title__order">상품정보</div>
    <div class="tb__order">
        <form action="/order">
            <table>
                <colgroup>
                    <col width="20%"/>
                    <col width="44%"/>
                    <col width="8%"/>
                    <col width="8%"/>
                    <col width="10%"/>
                    <col width="10%"/>
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
                        <div>주문금액</div>
                    </th>
                    <th scope="col">
                        <div>배송구분</div>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="cartDto" items="${list}" varStatus="status">
                    <tr>
                        <td>
                            <a href="/product/detail?pd_id=${cartDto.pd_id}">
                                <img src="/img/product/${cartDto.pd_type_cd.toLowerCase()}/main/${cartDto.mn_img_fn}"
                                     alt="썸네일" name="thumbnail"/>
                            </a>
                        </td>
                        <td>
                            <a href="/product/item?pd_id=${cartDto.pd_id}">${cartDto.pd_name}</a>
                            <span>${cartDto.pd_clsf_code}</span>
                        </td>
                        <td><span class="priceFormat">${cartDto.sls_prc}</span></td>
                        <td><span>${cartDto.cart_cnt}</span>개</td>
<%--                        <td><span class="priceFormat" id="payAmt">${cartDto.sls_prc * cartDto.cart_cnt}</span></td>--%>
                        <td><span class="price payAmt">${cartDto.sls_prc * cartDto.cart_cnt}</span></td>
                        <td><span>무료배송</span></td>
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
    </div>
</section>
<section class="order__payment">
    <%@include file="payCheckout.jsp" %>
</section>
<%@include file="footer.jsp" %>
<script>
    $(document).ready(function () {
        // 가격 포맷팅
        $('.price').each(function () {
            let value = $(this).text();
            value = value.replace(/,/g, '');
            const numericValue = Number(value);
            const formatValue = numericValue.toLocaleString('ko-KR');
            $(this).text(formatValue + '원');
        });

        // 테이블의 행 수를 동적으로 계산
        let totalSum = 0;
        $('body > section.order__items > div.tb__order > form > table > tbody > tr').each(function () {
            const payAmt = $(this).find('.payAmt').text();
            const price = Number(payAmt.replace(/[^\d]/g, ''));
            totalSum += price;
        });

        // 총합을 표시할 위치에 설정
        $('#totalSum').text(totalSum.toLocaleString('ko-KR') + '원');
    });

</script>
</body>

</html>