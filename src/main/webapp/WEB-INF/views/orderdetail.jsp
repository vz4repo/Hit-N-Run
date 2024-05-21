<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap"
          rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <link href="<c:url value='/css/reset.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/cart.css'/>" rel="stylesheet"/>
    <%--   다니님 header, footer --%>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet"/>
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>

    <title>주문내역조회</title>
    <%-- [혁락] css 수정 시작 --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css"/>
    <style>
      /* 공통 스타일 */
      /*body {*/
      /*  font-family: Arial, sans-serif;*/
      /*  margin: 0;*/
      /*  padding: 0;*/
      /*  background-color: #f4f4f4;*/
      /*}*/

      .order-container {
        width: 80%;
        margin: 0 auto;
        padding: 20px;
      }

      .orders {
        width: 100%;
        background-color: #fff;
        border-radius: 8px;
        overflow: hidden;
        margin-top: 20px;
      }

      .orders table {
        width: 100%;
        border-collapse: collapse;
      }

      .orders th,
      .orders td {
        padding: 10px;
        text-align: center;
        height: 70px;
        box-sizing: border-box;
        vertical-align: middle;
        word-break: break-all;
        border-spacing: 0;
        margin: 0;
        outline: none;
      }

      .orders th {
        background-color: #f4f4f4;
        text-align: center;
        border-top: 2px solid #000;
        border-bottom: 2px solid #000;
      }

      .orders td {
        border-bottom: 1px solid #ddd;
      }

      .orders tr:hover {
        background-color: #f9f9f9;
      }

      .product-info {
        display: flex;
      }

      ul {
        display: block;
      }

      .product-info img {
        width: 100px;
        height: 100px;
        object-fit: cover;
        margin-right: 10px;
      }

      .info {
        list-style-type: none;
        padding: 0;
        margin: 0;
      }

      .info .brand {
        font-weight: bold;
      }

      .info .name {
        font-size: 1.1em;
      }

      .info .name a {
        text-decoration: none;
        color: black;
      }

      .info .name a:hover {
        text-decoration: underline;
        cursor: pointer;
      }

      .info .option {
        color: gray;
      }

      .order-status {
        display: flex;
        flex-direction: column;
        align-items: center;
      }

      .order-status a {
        color: #007bff;
        text-decoration: none;
        margin-bottom: 5px;
      }

      .order-status a:hover {
        text-decoration: underline;
        cursor: pointer;
      }

      .order-status button {
        background-color: #f4f4f4;
        border: 1px solid #ccc;
        padding: 5px;
        cursor: pointer;
      }

      .order-status button:hover {
        background-color: #ddd;
      }

      .order-number a {
        text-decoration: none;
        color: black;
      }

      .order-number a:hover {
        text-decoration: underline;
        cursor: pointer;
      }

      .order-amount span {
        display: block;
      }

      /* 모달 스타일 */
      .modal {
        display: none;
        position: fixed;
        z-index: 1;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0, 0, 0, 0.4);
        justify-content: center;
        align-items: center;
      }

      .modal-content {
        background-color: #fff;
        margin: auto;
        padding: 20px;
        border: 1px solid #888;
        width: 80%;
        max-width: 600px;
        border-radius: 8px;
        position: relative;
      }

      .modal-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        border-bottom: 1px solid #ddd;
        padding-bottom: 10px;
      }

      .modal-header h2 {
        margin: 0;
      }

      .close {
        color: #aaa;
        font-size: 28px;
        font-weight: bold;
        cursor: pointer;
      }

      .close:hover,
      .close:focus {
        color: black;
        text-decoration: none;
      }

      .modal-body {
        margin-top: 20px;
      }

      .order-step-header {
        font-size: 18px;
        font-weight: bold;
      }

      .order-step-subheader {
        color: gray;
        margin-left: 10px;
      }

      .order-step-table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
      }

      .order-step-table th,
      .order-step-table td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: left;
      }

      .order-step-table th {
        background-color: #f4f4f4;
        text-align: center;
      }

      /* 배송 모달 스타일 */
      .delivery-info {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
      }

      .delivery-info th,
      .delivery-info td {
        border: none;
        padding: 10px;
        text-align: left;
      }

      .delivery-info th {
        width: 25%;
        background-color: #f4f4f4;
      }

      .delivery-info td {
        width: 25%;
      }

      .delivery-table {
        width: 100%;
        border-collapse: collapse;
      }

      .delivery-table th,
      .delivery-table td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: left;
      }

      .delivery-table th {
        background-color: #f4f4f4;
        text-align: center;
      }

      /* 영수증 modal */
      /* 영수증 modal */
      /* modal 에 쓰일 회색 배경 */
      #receiptModal .order-container {
        background-color: #f4f4f4;
      }

      /* modal */
      #receiptModal .modal {
        display: flex;
        justify-content: center;
        align-items: center;
        position: fixed;
        z-index: 1;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0, 0, 0, 0.4);
        padding-top: 20px;
      }

      #receiptModal .modal-content {
        background-color: #fff;
        margin: 5% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 100%;
        max-width: 400px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
      }

      #receiptModal .modal-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding-bottom: 10px;
        border-bottom: 1px solid #ddd;
      }

      #receiptModal .modal-header h2 {
        margin: 0;
        font-size: 24px;
      }

      #receiptModal .modal-header .icons {
        display: flex;
        gap: 10px;
      }

      #receiptModal .modal-body {
        padding-top: 10px;
        font-size: 14px;
        line-height: 1.6;
      }

      #receiptModal .modal-body .info {
        display: flex;
        flex-direction: column;
      }

      #receiptModal .modal-body .info div {
        display: flex;
        justify-content: space-between;
        margin: 5px 0;
      }

      #receiptModal .modal-body hr {
        border: none;
        border-top: 1px solid #ddd;
        margin: 10px 0;
      }

      #receiptModal .modal-footer {
        padding-top: 10px;
        border-top: 1px solid #ddd;
        font-size: 12px;
        color: #8b95a1;
      }

      #receiptModal .modal-footer p {
        margin: 5px 0;
      }

      #receiptModal .close {
        color: #aaa;
        font-size: 28px;
        font-weight: bold;
        cursor: pointer;
      }

      #receiptModal .close:hover,
      #receiptModal .close:focus {
        color: black;
        text-decoration: none;
      }

      #receiptModal .icon {
        cursor: pointer;
        font-size: 20px;
        color: #555;
      }

      #receiptModal .icon:hover {
        color: #000;
      }

      #receiptModal .highlight .align-left {
        color: #ff0000;
      }

      #receiptModal .total-amount .align-left {
        color: #0000ff;
        font-weight: bold;
      }

      #receiptModal .align-left {
        color: #8b95a1;
        text-align: left;
      }

      #receiptModal .align-right {
        color: #4e5968;
        font-weight: 600;
        text-align: right;
      }
    </style>
    <%-- [혁락] css 수정 끝 --%>
</head>
<body>
<%-- 잠깐 테스트 때문에 include 주석처리 --%>
<%--<jsp:include page="header.jsp"/>--%>

<main>
    <!-- 주문 목록 섹션 -->
    <div class="order-container">
        <div class="orders">
            <table>
                <thead>
                <tr>
                    <th>상품정보</th>
                    <!-- 상품 정보 헤더 -->
                    <th>주문일자</th>
                    <!-- 주문일자 헤더 -->
                    <th>주문번호</th>
                    <!-- 주문번호 헤더 -->
                    <th>주문금액(수량)</th>
                    <!-- 주문금액(수량) 헤더 -->
                    <th>주문 상태</th>
                    <!-- 주문 상태 헤더 -->
                </tr>
                </thead>
                <tbody>
                <%----%>
                <c:forEach var="orderdetDto" items="${list}" varStatus="status">
                    <tr class="order-item-hist">
                        <td class="product-info">
                            <div>
                                <a href="/product/detail?pd_id=${Imglist[status.index].pd_id}">
                                    <!-- 상품 이미지 -->
                                    <img src="/img/product/${Imglist[status.index].pd_type_cd.toLowerCase()}/main/${Imglist[status.index].mn_img_fn}"
                                         alt="썸네일" name="thumbnail"/>
                                </a>
                            </div>
                            <ul class="info">
                                <li class="brand">
                                    브랜드 이름
                                </li>
                                <!-- 브랜드 이름 -->
                                <li class="name">
                                    <a href="#">${orderdetDto.pd_name}</a>
                                    <!-- 상품 이름 -->
                                </li>
                                <li class="option">옵션/사이즈: ${orderdetDto.pd_clsf_cd}</li>
                                <!-- 상품 옵션 -->
                            </ul>
                        </td>
                        <td>
                            <div class="order-date">${orderdetDto.frst_reg_dt}</div>
                        </td>
                        <!-- 주문일자 -->

                        <td>
                            <div class="order-number">
                                <a href="#">${orderdetDto.od_id}</a>
                                <!-- 주문번호 -->
                            </div>
                        </td>


                        <td>
                            <div class="order-amount" data-order-id="20231208212440001">
                                <span class="sls_prc">${orderdetDto.sls_prc} 원</span><span>${orderdetDto.od_qty} 개</span>
                                <!-- 주문금액 및 수량 -->
                            </div>
                        </td>

                        <td class="order-status">
                            <a href="#" class="open-order-step-modal">${orderdetDto.od_stat_cd}</a>
                            <!-- 구매상태 링크 -->
                            <button class="open-delivery-modal">배송조회</button>
                            <!-- 배송조회 버튼 -->
                        </td>
                    </tr>
                </c:forEach>
                <%----%>
                <tr>
                    <td class="product-info">
                        <div>
                            <a href="#"><img src="product1.jpg" alt="Product 1"/></a>
                            <!-- 상품 이미지 -->
                        </div>
                        <ul class="info">
                            <li class="brand">실바니안 패밀리</li>
                            <!-- 브랜드 이름 -->
                            <li class="name">
                                <a href="#"
                                >5385-불이 들어오는 빨간지붕 이층집 기프트세트</a
                                >
                                <!-- 상품 이름 -->
                            </li>
                            <li class="option">옵션: FREE</li>
                            <!-- 상품 옵션 -->
                        </ul>
                    </td>
                    <td>
                        <div class="order-date">2023.12.08</div>
                    </td>
                    <!-- 주문일자 -->
                    <td>
                        <div class="order-number">
                            <a href="#">20231208212440001</a>
                            <!-- 주문번호 -->
                        </div>
                    </td>
                    <td>
                        <div class="order-amount" data-order-id="20231208212440001">
                            <span>48,312원</span><span>1개</span>
                            <!-- 주문금액 및 수량 -->
                        </div>
                    </td>
                    <td class="order-status">
                        <a href="#" class="open-order-step-modal">구매 확정</a>
                        <!-- 구매확정 링크 -->
                        <button class="open-delivery-modal">배송조회</button>
                        <!-- 배송조회 버튼 -->
                    </td>
                </tr>
                <!-- 추가 주문 행을 여기에 추가 -->
                </tbody>
            </table>
        </div>
    </div>

    <!-- 주문 단계 모달 -->
    <div id="orderStepModal" class="modal">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="order-step-header">
                    Step<span class="order-step-subheader">주문단계</span>
                    <!-- 주문단계 헤더 -->
                </h2>
                <span class="close">&times;</span>
                <!-- 모달 닫기 버튼 -->
            </div>
            <div class="modal-body">
                <table class="order-step-table">
                    <thead>
                    <tr>
                        <th>일자</th>
                        <!-- 일자 헤더 -->
                        <th>처리내역</th>
                        <!-- 처리내역 헤더 -->
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>2023-12-08 22:13</td>
                        <td>주문 일시</td>
                    </tr>
                    <tr>
                        <td>2023-12-08 22:13</td>
                        <td>입금 확인</td>
                    </tr>
                    <tr>
                        <td>2023-12-08 22:13</td>
                        <td>출고 요청</td>
                    </tr>
                    <tr>
                        <td>2023-12-11 08:52</td>
                        <td>출고 처리 중</td>
                    </tr>
                    <tr>
                        <td>2023-12-11 10:16</td>
                        <td>출고 완료</td>
                    </tr>
                    <!-- 추가 주문 단계 행을 여기에 추가 -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- 배송 조회 모달 -->
    <div id="deliveryModal" class="modal">
        <div class="modal-content">
            <div class="modal-header">
                <h2>배송조회</h2>
                <!-- 배송조회 헤더 -->
                <span class="close">&times;</span>
                <!-- 모달 닫기 버튼 -->
            </div>
            <div class="modal-body">
                <table class="delivery-info">
                    <tbody>
                    <tr>
                        <th>현재 상태</th>
                        <!-- 현재 상태 헤더 -->
                        <td>구매확정</td>
                    </tr>
                    <tr>
                        <th>송장 번호</th>
                        <!-- 송장 번호 헤더 -->
                        <td>682218726753 (CJ대한통운)</td>
                    </tr>
                    </tbody>
                </table>
                <table class="delivery-table">
                    <thead>
                    <tr>
                        <th>배송시간</th>
                        <!-- 배송시간 헤더 -->
                        <th>현재위치</th>
                        <!-- 현재위치 헤더 -->
                        <th>배송내용</th>
                        <!-- 배송내용 헤더 -->
                        <th>지점 연락처</th>
                        <!-- 지점 연락처 헤더 -->
                        <th>기사 연락처</th>
                        <!-- 기사 연락처 헤더 -->
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>2023-12-13 13:54:02</td>
                        <td>강남개포주공</td>
                        <td>배송완료</td>
                        <td>010-9266-4597</td>
                        <td>010-8734-1963</td>
                    </tr>
                    <tr>
                        <td>2023-12-13 12:06:55</td>
                        <td>강남개포주공</td>
                        <td>배송출발 (배달예정시간 :14~16시)</td>
                        <td>010-9266-4597</td>
                        <td>010-8734-1963</td>
                    </tr>
                    <tr>
                        <td>2023-12-13 10:19:33</td>
                        <td>강남A</td>
                        <td>간선하차</td>
                        <td>031-751-1255</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>2023-12-13 10:17:52</td>
                        <td>강남A</td>
                        <td>간선하차</td>
                        <td>031-751-1255</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>2023-12-13 07:02:38</td>
                        <td>대전HUB</td>
                        <td>간선상차</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>2023-12-13 06:56:06</td>
                        <td>대전HUB</td>
                        <td>간선상차</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>2023-12-12 00:47:49</td>
                        <td>부천1</td>
                        <td>간선상차</td>
                        <td>032-528-1256</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>2023-12-11 20:47:25</td>
                        <td>중산물류</td>
                        <td>집화처리</td>
                        <td>010-6565-8952</td>
                        <td></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- 영수증 모달 -->
    <div id="receiptModal" class="modal">
        <div class="modal-content">
            <div class="modal-header">
                <h2>신용 · 체크카드 매출전표</h2>
                <div class="icons">
                    <i class="fas fa-copy icon" onclick="copyLink()"></i>
                    <i class="fas fa-print icon" onclick="printReceipt()"></i>
                    <span class="close" onclick="closeModal()">&times;</span>
                </div>
            </div>
            <div class="modal-body">
                <div class="info">
                    <div>
                        <span class="align-left">주문번호:</span>
                        <span class="align-right">123451234512345</span>
                    </div>
                    <div>
                        <span class="align-left">구매자:</span>
                        <span class="align-right">홈런볼</span>
                    </div>
                    <div>
                        <span class="align-left">구매상품:</span>
                        <span class="align-right"
                        >미즈노 반팔 하계티 네이비 32MAA15614NV</span
                        >
                    </div>
                    <hr/>
                    <div>
                        <span class="align-left">카드종류:</span>
                        <span class="align-right">신한</span>
                    </div>
                    <div>
                        <span class="align-left">카드번호:</span>
                        <span class="align-right">51073776****472*</span>
                    </div>
                    <div>
                        <span class="align-left">할부:</span>
                        <span class="align-right">일시불</span>
                    </div>
                    <div>
                        <span class="align-left">승인번호:</span>
                        <span class="align-right">36952716</span>
                    </div>
                    <hr/>
                    <div>
                        <span class="align-left">승인:</span>
                        <span class="align-right">249,240원</span>
                    </div>
                    <div>
                        <span class="align-left">2023-11-02 16:43:37</span>
                    </div>
                    <div class="highlight">
                        <span class="align-left">취소:</span>
                        <span class="align-right">-</span>
                    </div>
                    <div>
                        <span class="align-left"></span>
                    </div>
                    <hr/>
                    <div>
                        <span class="align-left">공급가액:</span>
                        <span class="align-right">224,316원</span>
                    </div>
                    <div>
                        <span class="align-left">면세가액:</span>
                        <span class="align-right">0원</span>
                    </div>
                    <div>
                        <span class="align-left">부가세:</span>
                        <span class="align-right">24,924원</span>
                    </div>
                    <div>
                        <span class="align-left">과세제외액:</span>
                        <span class="align-right">0원</span>
                    </div>
                    <div class="total-amount">
                        <span class="align-left">합계:</span>
                        <span class="align-right">249,240원</span>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <strong>이용상점</strong>
                <p>
                    주식회사 홈런볼 | 대표자명: 김지훈 | 사업자등록번호: 999-81-00612 | 전화: 1544-1544 | 주소: 서울특별시 강남구 미왕빌딩 A
                </p>
                <strong>결제서비스업체</strong>
                <p>
                    토스페이먼츠(주) | 대표자명: 강병훈 | 사업자등록번호: 411-86-01799 | 전화: 1544-7772 | 주소: 서울특별시 강남구 테헤란로 131, 14층 (역삼동,
                    한국지식재산센터)
                </p>
                <p>
                    * 부가가치세법 제46조 3항에 따라 신용카드 매출전표로
                    매출세금계산서를 발행할 수 있습니다.
                </p>
            </div>
        </div>
    </div>

    <script>
      document.addEventListener('DOMContentLoaded', () => {
        const orderStepModal = document.getElementById('orderStepModal');
        const deliveryModal = document.getElementById('deliveryModal');
        const closeModalButtons = document.querySelectorAll('.close');
        const openOrderStepModalButtons = document.querySelectorAll('.open-order-step-modal');
        const openDeliveryModalButtons = document.querySelectorAll('.open-delivery-modal');

        /* 영수증 모달 */
        const receiptModal = document.getElementById('receiptModal');
        const orderAmounts = document.querySelectorAll('.order-amount');

        // 주문 단계 모달 열기
        openOrderStepModalButtons.forEach((button) => {
          button.addEventListener('click', () => {
            orderStepModal.style.display = 'flex';
          });
        });

        // 배송 조회 모달 열기
        openDeliveryModalButtons.forEach((button) => {
          button.addEventListener('click', () => {
            deliveryModal.style.display = 'flex';
          });
        });

        // 영수증 모달 열기
        orderAmounts.forEach((orderAmount) => {
          orderAmount.addEventListener('click', async () => {
            const orderId = orderAmount.getAttribute('data-order-id');
            const receiptContent = document.getElementById('receiptContent');
            try {
              /* TODO: json 값 불러오기 */
              <%--const response = await fetch(`/receipt?order=${orderId}`);--%>
              <%--const receiptHtml = await response.text();--%>
              <%--receiptContent.innerHTML = receiptHtml;--%>
              receiptModal.style.display = 'flex';
            } catch (error) {
              receiptContent.innerHTML = '영수증을 불러오는 데 실패했습니다.';
              receiptModal.style.display = 'flex';
            }
          });
        });

        // 모달 닫기
        closeModalButtons.forEach((button) => {
          button.addEventListener('click', () => {
            button.closest('.modal').style.display = 'none';
          });
        });

        // TODO: 모달 바깥 영역 클릭 시 닫기 :: 필요 여부 확인
        window.addEventListener('click', (event) => {
          if (event.target === orderStepModal || event.target === deliveryModal || event.target === receiptModal) {
            event.target.style.display = 'none';
          }
        });

      });

      /* 영수증 링크 복사 */
      const copyLink = () => {
        const url = window.location.href;
        navigator.clipboard.writeText(url)
        .then(() => alert("링크가 복사되었습니다!"))
        .catch(err => alert("링크 복사에 실패했습니다."));
      };

      /* 영수증 프린트 */
      const printReceipt = () => {
        const printContents = document.querySelector('#receiptModal .modal-content').innerHTML;
        const originalContents = document.body.innerHTML;

        document.body.innerHTML = printContents;
        window.print();
        document.body.innerHTML = originalContents;
        location.reload();
      };

      /* 원 표시*/
      // Function to format the date
      const formatDate = (isoDateString) => {
        const date = new Date(isoDateString);

        // Format the date as yyyy.mm.dd
        const formattedDate = date.toLocaleDateString('ko-KR', {
          year: 'numeric',
          month: '2-digit',
          day: '2-digit'
        }).replace(/\. /g, '.');

        // Format the time as HH:MM
        const formattedTime = date.toLocaleTimeString('ko-KR', {
          hour: '2-digit',
          minute: '2-digit',
          hour12: false
        });

        return `${'${formattedDate}'} ${'${formattedTime}'}`;
      };

      // Function to format the price
      const formatPrice = (price) => `${'${price.toLocaleString("ko-KR")}'} 원`;

      // Apply formatting to each transaction
      document.querySelectorAll('.order-item-hist').forEach(transaction => {
        const dateElement = transaction.querySelector('.order-date');
        const priceElement = transaction.querySelector('.sls_prc');

        const isoDateString = new Date(dateElement.textContent).toISOString();
        const price = parseInt(priceElement.textContent, 10);

        dateElement.textContent = formatDate(isoDateString);
        priceElement.textContent = formatPrice(price);
      });
    </script>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>


