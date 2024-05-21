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
  #dlv-container {
    width: 700px;
    margin: 0 auto;
    border: 1px solid #ddd;
    padding: 20px;
    border-radius: 5px;
  }

  #dlv-container .dlv-header {
    font-size: 24px;
    font-weight: bold;
    margin-bottom: 20px;
  }

  #dlv-container ul {
    list-style: none;
    padding: 0;
    margin: 0;
  }

  #dlv-container li {
    display: flex;
    align-items: center;
    padding: 10px 0;
  }

  #dlv-container .label {
    width: 150px;
    font-weight: bold;
  }

  #dlv-container .dlv-content {
    flex: 1;
    display: flex;
    align-items: center;
  }

  #dlv-container .btn-change-address {
    padding: 5px 10px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    margin-left: 10px;
  }

  #dlv-container .select-request {
    width: auto;
    padding: 5px;
    border: 1px solid #ddd;
    border-radius: 5px;
  }

  #dlv-container .radio-group label {
    margin-right: 10px;
  }

  #dlv-container .dlv-content ul {
    display: block;
  }

  #dlv-container .dlv-content li {
    padding: 4px;
  }

  /* Modal styles */
  #addressModal {
    display: none;
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgb(0, 0, 0);
    background-color: rgba(0, 0, 0, 0.4);
    padding-top: 60px;
  }

  #addressModal .modal-content {
    background-color: #fefefe;
    margin: 5% auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
    max-width: 600px;
    border-radius: 10px;
  }

  #addressModal .close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
  }

  #addressModal .close:hover,
  #addressModal .close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
  }

  #addressModal .address-card {
    border: 1px solid #ddd;
    padding: 10px;
    margin: 10px 0;
    border-radius: 5px;
  }

  #addressModal .address-card .title {
    font-weight: bold;
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  #addressModal .address-card .title .default {
    color: #007bff;
    border: 1px solid #007bff;
    padding: 2px 5px;
    border-radius: 5px;
  }

  #addressModal .address-card .details {
    margin: 10px 0;
  }

  #addressModal .address-card .buttons {
    display: flex;
    justify-content: space-between;
  }

  #addressModal .address-card .buttons button {
    padding: 5px 10px;
    border: 1px solid #ddd;
    background-color: #f0f0f0;
    cursor: pointer;
  }

  #addressModal .address-card .buttons button.select {
    background-color: #000;
    color: #fff;
  }

  #addressModal .add-new-address {
    text-align: right;
    margin: 10px 0;
    color: #007bff;
    cursor: pointer;
  }
</style>
<%-- 김수연 끝 --%>
<body>
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
    <%--   <hr/>
       <section class="order__delivery">
           &lt;%&ndash; 김수연 시작 &ndash;%&gt;
           &lt;%&ndash; 고객이 선택한 배송지 뜨는 페이지 _ order.jsp &ndash;%&gt;
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
                       &lt;%&ndash; c_id : 고객 번호&ndash;%&gt;
                       <td>고객 C_ID</td>
                       <td>${sessionScope.c_id}</td>
                   </tr>
                   <tr>
                       &lt;%&ndash; rcver : 고객명 / &ndash;%&gt;
                       <td>이름(장소명)</td>
                       <td>${selectedDto.rcver}(${selectedDto.adr_name})</td>
                   </tr>
                   <tr>
                       &lt;%&ndash; rcver_phn : 고객 연락처 &ndash;%&gt;
                       <td>연락처</td>
                       <td>${selectedDto.rcver_phn}</td>
                   </tr>
                   <tr>
                       &lt;%&ndash; rcver_adr : 고객 주소&ndash;%&gt;
                       <td>주소</td>
                       <td>${selectedDto.rcver_adr}</td>
                   </tr>
                   <tr>
                       <td colspan="2">
                           &lt;%&ndash; 여기서 배송지 변경 버튼 누르면, deliveryList.jsp 페이지로 이동해야한다. &ndash;%&gt;
                           &lt;%&ndash;<button id="changeAdrList" onclick="redirectToDeliveryList()">배송지 변경</button>&ndash;%&gt;
                           &lt;%&ndash;                                <button id="selectAllBtn">배송지 전체 조회</button>&ndash;%&gt;
                       </td>
                   </tr>
               </table>
           </div>
           <hr/>

           &lt;%&ndash;            <%@include file="deliveryList.jsp"%>&ndash;%&gt;
           &lt;%&ndash;            <% String rcver = request.getParameter("rcver"); %>&ndash;%&gt;
           &lt;%&ndash;            <div>&ndash;%&gt;
           &lt;%&ndash;                &ndash;%&gt;
           &lt;%&ndash;            </div>&ndash;%&gt;

           &lt;%&ndash;                <div id="deliveryForm">&ndash;%&gt;
           &lt;%&ndash;                    &lt;%&ndash; 여기에 배송지 목록이 동적으로 채워질 것입니다. &ndash;%&gt;&ndash;%&gt;
           &lt;%&ndash;                </div>&ndash;%&gt;


           &lt;%&ndash;                <c:import url="<%= request.getContextPath() %>/delivery/" />&ndash;%&gt;
           &lt;%&ndash;                <h1><c:out value="웅냥냥"/></h1>&ndash;%&gt;
           &lt;%&ndash;                <script>&ndash;%&gt;
           &lt;%&ndash;                    var contextPath = "${pageContext.request.contextPath}";&ndash;%&gt;
           &lt;%&ndash;                    console.log("Context Path: " + contextPath);&ndash;%&gt;

           &lt;%&ndash;                    // 예를 들어, id가 "contextPathDisplay"인 요소에 contextPath를 추가하는 경우&ndash;%&gt;
           &lt;%&ndash;                    document.getElementById("contextPathDisplay").innerText = "Context Path: " + contextPath;&ndash;%&gt;

           &lt;%&ndash;                </script>&ndash;%&gt;
           &lt;%&ndash;                <h1><c:out value="${request.getContextPath()}"/></h1>&ndash;%&gt;
           &lt;%&ndash;                <h1><c:out value="${pageContext.request.contextPath}"/></h1>&ndash;%&gt;

           &lt;%&ndash;                <c:import url="${pageContext.request.contextPath}/delivery/" />&ndash;%&gt;

       </section>
   --%>
    <section id="dlv-container">
        <!-- 배송 정보 헤더 -->
        <div class="dlv-header">배송 정보</div>
        <%-- TODO: display:block 강제 적용 중. 수정 필요--%>
        <ul style="display: block">
            <!-- 배송지 선택 -->
            <li>
                <span class="label">배송지</span>
                <div class="dlv-content">
                    <ul>
                        <li class="radio-group">
                            <!-- 배송지 라디오 버튼 -->
                            <label><input type="radio" name="delivery_address" checked/>
                                ${selectedDto.adr_name}
                            </label>
                            <label><input type="radio" name="delivery_address"/>
                                배송지2
                            </label>
                        </li>
                        <!-- 배송지 변경 버튼 -->
                        <li>
                            <button class="btn-change-address">배송지 변경</button>
                        </li>
                    </ul>
                </div>
            </li>
            <!-- 이름/연락처 정보 -->
            <li>
                <span class="label">이름/연락처</span>
                <div class="dlv-content">
                    <ul>
                        <!-- 이름 -->
                        <li>${selectedDto.rcver}</li>
                        <!-- 전화번호 -->
                        <li>${selectedDto.rcver_phn}</li>
                    </ul>
                </div>
            </li>
            <!-- 주소 정보 -->
            <li>
                <span class="label">주소</span>
                <div class="dlv-content">
                    <ul>
                        <%--                        <!-- 우편번호 -->
                                                <li></li>
                                                <!-- 주소 1 -->
                                                <li></li>
                                                <!-- 주소 2 -->
                                                <li></li>--%>
                        <%-- 수연님이 받은 주소 포맷 --%>
                        ${selectedDto.rcver_adr}
                    </ul>
                </div>
            </li>
            <!-- 배송 요청사항 선택 -->
            <li>
                <span class="label">배송 요청사항</span>
                <div class="dlv-content">
                    <!-- 배송 요청사항 드롭다운 -->
                    <select class="select-request" name="delivery_request" id="delivery_request"
                            onchange="showEtc(this.value);">
                        <option value="" selected="selected">
                            배송 시 요청사항을 선택해주세요
                        </option>
                        <option value="부재 시 경비실에 맡겨주세요">
                            부재 시 경비실에 맡겨주세요
                        </option>
                        <option value="부재 시 택배함에 넣어주세요">
                            부재 시 택배함에 넣어주세요
                        </option>
                        <option value="부재 시 집 앞에 놔주세요">
                            부재 시 집 앞에 놔주세요
                        </option>
                        <option value="배송 전 연락 바랍니다">
                            배송 전 연락 바랍니다
                        </option>
                        <option value="파손의 위험이 있는 상품입니다. 배송 시 주의해 주세요.">
                            파손의 위험이 있는 상품입니다. 배송 시 주의해 주세요.
                        </option>
                        <option value="etc">직접 입력</option>
                    </select>
                </div>
            </li>
        </ul>
    </section>

    <!-- DLV List Modal -->
    <div id="addressModal">
        <div class="modal-content">
            <span class="close" id="closeModal">&times;</span>
            <h2>배송지 변경</h2>
            <div class="address-card">
                <div class="title">
                    권혁락 (우리집) <span class="default">기본배송지</span>
                </div>
                <div class="details">
                    010-4166-0518 | 010-4166-0518<br/>
                    (06331) 서울 강남구 개포로 516 (개포주공아파트) 432동 301호
                </div>
                <div class="buttons">
                    <button>수정</button>
                    <button class="select">선택</button>
                </div>
            </div>
            <div class="address-card">
                <div class="title">권혁락 (권혁락님 배송지)</div>
                <div class="details">
                    010-4166-0518 | 010-4166-0518<br/>
                    (06337) 서울특별시 강남구 일원동 615 우성7차아파트 104동 401호
                </div>
                <div class="buttons">
                    <button class="btn-modify">수정</button>
                    <button>삭제</button>
                    <button class="btn-select">선택</button>
                </div>
            </div>
            <div class="add-new-address">신규 배송지 등록 +</div>
        </div>
    </div>
    <%-- 김수연 끝 --%>
</div>
<section class="order__items">
    <hr class="first__under"/>
    <div class="title__order">상품정보</div>
    <div class="tb__order">
        <form action="/order">
            <table>
                <colgroup>
                    <col width="20%"/>
                    <col width="30%"/>
                    <col width="15%"/>
                    <col width="15%"/>
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
    <%@include file="payCheckout.jsp" %>
</section>
<%@include file="footer.jsp" %>
<script>
  $(document).ready(function () {
    $('.priceFormat').each(function () {
      let value = $(this).text();
      value = value.replace(/,/g, '');
      const numbericValue = parseInt(value);
      const formatValue = numbericValue.toLocaleString('ko-KR');
      $(this).text(formatValue + '원');
    })

  })

  /*테이블의 행 수를 동적으로 계산*/
  window.onload = function () {
    const rows = document.querySelectorAll('body > section.order__items > div.tb__order > form > table > tbody > tr');
    let totalSum = 0;

    rows.forEach(function (row) {
      /* 각 행의 6번째 셀(td)에서 판매가를 가져와서 총합구하기 */
      const price = row.cells[5].innerText;
      totalSum += parseInt(price.replace(/[^\d]/g, ''));
    });
    <%--/*총합을 나타낼 위치*/--%>
    document.getElementById('totalSum').innerText = totalSum.toLocaleString('ko-KR') + '원';
  }

  /* 배송지 modal */
  document.addEventListener('DOMContentLoaded', () => {
    const modal = document.querySelector('#addressModal');
    const btn = document.querySelector('.btn-change-address');
    const closeModal = document.querySelector('#closeModal');

    btn.addEventListener('click', () => {
      modal.style.display = 'block';
    });

    closeModal.addEventListener('click', () => {
      modal.style.display = 'none';
    });

    window.addEventListener('click', (event) => {
      if (event.target === modal) {
        modal.style.display = 'none';
      }
    });
  });
</script>
</body>
</html>