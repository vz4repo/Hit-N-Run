<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link href="<c:url value='/css/reset.css'/>" type="text/css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <link href="<c:url value='/css/order.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/payStyle.css'/>"   rel="stylesheet" />
    <!-- 결제위젯 SDK 추가 -->
    <script src="https://js.tosspayments.com/v1/payment-widget"></script>
    <%-- jquery --%>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <title> 주문 & 배송</title>
</head>
<body>
    <div class="order__header">
        <a href="#" class="order__path">Homerun() > 주문서</a>
        <hr />
        <div class="order__title">
            <h1>
                Order / Payment
            </h1>
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
    <hr class="second__under" />
    <div class="tb__order">
        <form action="/order">
            <table style="width: 90%">
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
                        <div>소비자가</div>
                    </th>
                    <th scope="col">
                        <div>수량</div>
                    </th>
                    <th scope="col">
                        <div>배송구분</div>
                    </th>
                    <th scope="col">
                        <div>판매가</div>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="cartDto" items="${list}" varStatus="status">
                    <tr>
                        <td>
                            <a href="#"><img src="#" alt="썸네일" /></a>
                        </td>
                        <td>
                            <a href="#">${stkList[status.index].pd_name}</a>
                            <span>${cartDto.pd_clsf_code}</span>
                        </td>
                        <td><span class="priceFormat">${stkList[status.index].sls_prc}</span></td>
                        <td><span>${stkList[status.index].cart_cnt}</span>개</td>
                        <td><span>무료배송</span></td>
                        <td><span class="priceFormat">${stkList[status.index].cart_cnt*stkList[status.index].sls_prc}</span></td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="2">
                        <div class="tb__left"><span>[기본배송]</span></div>
                    </td>
                </tr>
                <tr>
                    <td colspan="7">
                        <div class="tb__right">
                            <span>상품구매금액</span>
                            <span>배송비 무료</span>
                            <span class="priceFormat totalSum">합계:</span>
                            <span>원</span>
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
<script type="text/javascript" src="<c:url value='/javascript/checkout.js'/>"></script>
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

  /*총합을 저장할 변수*/
  let totalSum = 0;

  /*테이블의 행 수를 동적으로 계산*/
  const rows = document.querySelectorAll('body > section.order__items > div.tb__order > form > table > tbody > tr');
  const rowCount = rows.length;

  /*각 행의 부분합으로 총합구하기*/
  for (let i = 1; i <= rowCount; i++) {
    const selector = `body > section.order__items > div.tb__order > form > table > tbody > tr:nth-child(${'${i}'}) > td:nth-child(6) > span`;
    const spanElement = document.querySelector(selector);

    if (spanElement) {
      const value = parseInt(spanElement.textContent.replace(/[^\d]/g, ''), 10);
      totalSum += value;
    }
  }

  /*총합을 나타낼 위치*/
  document.querySelector('.totalSum').textContent = totalSum;
</script>
</body>

</html>