<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

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
      display: flex;
      align-items: center;
      justify-content: start;
      padding: 20px 0;
      margin: 20px 0;
  }

  .dlv-header {
      margin-left: 8%;
      font-size: 15px;
      font-weight: 600;
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



  #dlv-container .btn-change-address {
    padding: 5px 10px;
    border: 1px solid #333;
    color: #fff;
    background-color: #333;
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
    <a href="#" class="head_main">Home-run() 주 문 서</a>
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
    <%-- 김수연 시작 --%>
    <%-- 배송지 정보 section --%>
    <section id="dlv-container">
        <div class="dlv-header">배송 정보</div>
        <%-- 기본/선택 배송지 내용 출력 --%>
        <div class="dlv-header-content">
            <%-- TODO : 기본배송지 --%>
        </div>
        <!-- 배송지 변경 버튼 -->
        <button class="btn-change-address">배송지 변경</button>
    </section>

    <!-- 배송지 목록 Modal -->
    <div id="addressModal">
        <div class="modal-content">
            <span class="close" id="closeModal">&times;</span>
            <h1>배송지 변경</h1>
            <div class="dlv-modal-container">
                <%-- ajax를 통해서 내용이 채워지는 부분 --%>
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
                    <col width="50%"/>
                    <col width="10%"/>
                    <col width="5%"/>
                    <col width="5%"/>
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
                                <img src="/img/product/${cartDto.pd_type_cd}/main/${cartDto.mn_img_fn}"
                                     alt="이미지 준비 중 입니다"
                                     onerror="this.onerror=null; this.src='/img/product/${cartDto.pd_type_cd.toLowerCase()}/main/${cartDto.mn_img_fn}';">
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
<%-- 결제 위젯 호출 --%>
<section class="order__payment">
    <%@include file="payCheckout.jsp" %>
</section>
<%-- footer --%>
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
  /*테이블의 행 수를 계산*/
  window.onload = function () {
    const rows = document.querySelectorAll('body > section.order__items > div.tb__order > form > table > tbody > tr');
    let totalSum = 0;

    rows.forEach(function (row) {
      /* 각 행의 6번째 td에서 판매가를 가져와서 총합구하기 */
      const price = row.cells[5].innerText;
      totalSum += parseInt(price.replace(/[^\d]/g, ''));
    });
    /*총합을 나타낼 위치*/
    document.getElementById('totalSum').innerText = totalSum.toLocaleString('ko-KR') + '원';
  }

  /* 배송지 요청 */
  /* 배송지 modal */
  document.addEventListener('DOMContentLoaded', () => {
    const contextPath = '<%= request.getContextPath() %>';

    const addressModal = document.querySelector('#addressModal');
    const btn = document.querySelector('.btn-change-address');
    const closeModal = document.querySelector('#closeModal');

    btn.addEventListener('click', () => {
      addressModal.style.display = 'block';
      $.ajax({
        type: "GET",
        url: `${contextPath}/delivery/deliveryList`,
        success: function (response) {
          if (response.message) {
            $(".dlv-modal-container").html(`<p>${response.message}</p>`);
          } else {
            let htmlContent = '';
            response.list.forEach(listDto => {
              /*
              기본배송지 붙일때 쓸 태그
              <span className="default">기본배송지</span>
              */
              htmlContent += `
                            <div class="address-card">
                                <div class="title">
                                    (${'${listDto.rcver}'}) ${'${listDto.adr_name}'}
                                </div>
                                <div class="details">
                                    ${'${listDto.rcver_phn}'}<br/>
                                    (${'${listDto.rcver_zip}'}) ${'${listDto.rcver_adr}'}
                                </div>
                                <div class="buttons">
                                    <button class="dlv-select" addrId="${'${listDto.c_adr_list_id}'}">선택</button>
                                </div>
                            </div>
                        `;
            });
            $(".dlv-modal-container").html(htmlContent);
          }
        },
        error: function (xhr, status, error) {
          console.error('Error fetching delivery list:', error);
          alert('배송지 목록을 불러오는 중 오류가 발생했습니다. 다시 시도해주세요.');
        }
      });
    });

    closeModal.addEventListener('click', () => {
      addressModal.style.display = 'none';
    });

    window.addEventListener('click', (event) => {
      if (event.target === addressModal) {
        addressModal.style.display = 'none';
      }
    });

    /*
# 이벤트 위임을 사용하여 동적으로 생성된 요소에 이벤트 핸들러 등록

DOMContentLoaded 이벤트 발생 시 DOM 요소를 찾기 때문에,
이벤트 핸들러를 등록하려는 요소가 존재하지 않으면 오류가 발생합니다.

따라서 동적으로 생성된 요소에 대해 이벤트 핸들러를 올바르게 등록하려면
이벤트 위임을 사용해야 합니다.

이벤트 위임을 사용하여 동적으로 생성된 .dlv-select 버튼에
이벤트 핸들러를 등록하도록 코드를 수정할 수 있습니다.

이벤트 위임을 사용하면
이벤트 핸들러를 상위 요소에 등록하고,
이벤트가 하위 요소로 위임되도록 합니다.
    * */
    document.querySelector('.dlv-modal-container').addEventListener('click', function (event) {
      if (event.target.classList.contains('dlv-select')) {
        const c_adr_list_id = event.target.getAttribute('addrId');
        $.ajax({
          type: "GET",
          url: `${contextPath}/delivery/deliverySelected`,
          data: {dlvId: c_adr_list_id},
          success: function (response) {
            if (response.message) {
              $(".dlv-header-content").html(`<p>${'${response.message}'}</p>`);
            } else {
              const selectedDto = response.selectedDto;
              const htmlContent = `
                                    <ul style="display: block">
                                        <li>
                                            <span class="label">배송지</span>
                                            <div class="dlv-content"> ${'${selectedDto.adr_name}'} </div>
                                        </li>
                                        <li>
                                            <span class="label">이름/연락처</span>
                                            <div class="dlv-content">
                                                <ul>
                                                    <li>${'${selectedDto.rcver}'}</li>
                                                    <li>${'${selectedDto.rcver_phn}'}</li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li>
                                            <span class="label">주소</span>
                                            <div class="dlv-content">
                                                <ul>
                                                    <li> ${'${selectedDto.rcver_zip}'} </li>
                                                    <li> ${'${selectedDto.rcver_adr}'} </li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li>
                                            <span class="label">배송 요청사항</span>
                                            <div class="dlv-content">
                                                <select class="select-request" name="delivery_request" id="delivery_request">
                                                    <option value="" selected="selected"> 배송 시 요청사항을 선택해주세요</option>
                                                    <option value="부재 시 경비실에 맡겨주세요"> 부재 시 경비실에 맡겨주세요</option>
                                                    <option value="부재 시 택배함에 넣어주세요"> 부재 시 택배함에 넣어주세요</option>
                                                    <option value="부재 시 집 앞에 놔주세요"> 부재 시 집 앞에 놔주세요</option>
                                                    <option value="배송 전 연락 바랍니다"> 배송 전 연락 바랍니다</option>
                                                    <option value="파손의 위험이 있는 상품입니다. 배송 시 주의해 주세요."> 파손의 위험이 있는 상품입니다. 배송 시 주의해 주세요.</option>
                                                    <option value="etc">직접 입력</option>
                                                </select></div>
                                        </li>
                                    </ul>
                                  `;
              $(".dlv-header-content").html(htmlContent);
              addressModal.style.display = 'none';
            }
          },
          error: function (xhr, status, error) {
            console.error('Error fetching selected delivery:', error);
            alert('선택한 배송지를 불러오는 중 오류가 발생했습니다. 다시 시도해주세요.');
          }
        });
      }
    });
  })
</script>
</body>
</html>