<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8" />
    <link rel="icon" href="https://static.toss.im/icons/png/4x/icon-toss-logo.png" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/payStyle.css'/>" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>결제 test</title>
    <!-- 결제위젯 SDK 추가 -->
    <script src="https://js.tosspayments.com/v1/payment-widget"></script>
  </head>

  <body>
    <%-- dev 테스트값 입력 영역 --%>
    <div class=" wrapper">
      <div class="box_section">
        <div style="display:flex ;justify-content: space-between">
          <div class="test">
            <label for="testAmount">금액
              <input id="testAmount" class="test" type="text" name="testAmount" value="" placeholder="테스트 금액">
            </label>
          </div>
          <div class="test">
            <label for="testCoupon">쿠폰
              <input id="testCoupon" class="test" type="text" name="testCoupon" value="" placeholder="테스트 쿠폰">
            </label>
          </div>
          <div class="test">
            <label for="orderName">주문명
              <input id="orderName" class="test" type="text" name="orderName" value="" placeholder="테스트 주문명">
            </label>
          </div>
        </div>
        <div style="display: flex; justify-content: space-between">
          <div class="test">
            <label for="customerEmail">이메일
              <input id="customerEmail" class="test" type="text" name="customerEmail" value="" placeholder="테스트 이메일">
            </label>
          </div>
          <div class="test">
            <label for="customerName">고객명
              <input id="customerName" class="test" type="text" name="customerName" value="" placeholder="테스트 고객명">
            </label>
          </div>
          <div class="test">
            <label for="customerMobilePhone">연락처
              <input id="customerMobilePhone" class="test" type="text" name="customerMobilePhone" value="" placeholder="테스트 연락처">
            </label>
          </div>
        </div>
      </div>
    </div>
    <!-- 주문서 영역 -->
    <div class="wrapper">
      <div class="box_section" style="padding: 40px 30px 50px 30px; margin-top: 30px; margin-bottom: 50px">
        <!-- 결제 UI -->
        <div id="payment-method"></div>
        <!-- 이용약관 UI -->
        <div id="agreement"></div>
        <!-- 쿠폰 체크박스 -->
        <div class="checkable typography--p" style="padding-left: 25px">
          <label for="coupon-box" class="checkable__label typography--regular">
            <input id="coupon-box" class="checkable__input" type="checkbox" aria-checked="true" disabled />
            <span class="checkable__label-text">0원 쿠폰 적용</span>
          </label>
        </div>
        <!-- 결제하기 버튼 -->
        <button class="button" id="payment-button" style="margin-top: 30px" disabled>결제하기</button>
      </div>
    </div>
    <script>
      const button = document.querySelector("#payment-button");
      const coupon = document.querySelector("#coupon-box");
      /* TODO: 임시로 customerKey 생성 */
      const generateRandomString = () => window.btoa(Math.random()).slice(0, 20);
      /* 추가 */
      const testAmountElement = document.querySelector("#testAmount");
      const testCouponElement = document.querySelector("#testCoupon");

      let amount = 1;

      /*
      * @docs https://docs.tosspayments.com/reference/widget-sdk#sdk-설치-및-초기화
      * ------  결제위젯 초기화 ------
      * TODO: widgetClientKey는 개발자센터의 결제위젯 연동 키 > 클라이언트 키로 바꾸세요.
      * TODO: 구매자의 고유 아이디를 불러와서 customerKey로 설정하세요. 이메일・전화번호와 같이 유추가 가능한 값은 안전하지 않습니다.
      * widgetClientKey: 혁락 테스트 클라이언트 키
      * customerKey: 내 상점에서 고객을 구분하기 위한 키
      * paymentWidget: 회원/비회원마다 다른 호출
      */
      const widgetClientKey = "${widgetClientKey}";
      const customerKey = generateRandomString();
      const paymentWidget = PaymentWidget(widgetClientKey, customerKey); /* 회원 결제 */
      /* const paymentWidget = PaymentWidget(widgetClientKey, PaymentWidget.ANONYMOUS); //비회원 결제 */

      /* ------  결제 UI 렌더링 ------ */
      /* @docs https://docs.tosspayments.com/reference/widget-sdk#renderpaymentmethods선택자-결제-금액-옵션 */
      paymentMethodWidget = paymentWidget.renderPaymentMethods(
        "#payment-method",
        { value: amount },
        /* 렌더링하고 싶은 결제 UI의 variantKey */
        /* @docs https://docs.tosspayments.com/guides/payment-widget/admin#멀티-결제-ui */
        { variantKey: "DEFAULT" }
      );
      /* ------  이용약관 UI 렌더링 ------ */
      /* @docs https://docs.tosspayments.com/reference/widget-sdk#renderagreement선택자-옵션 */
      paymentWidget.renderAgreement("#agreement", { variantKey: "AGREEMENT" });

      /*  ------  결제 UI 렌더링 완료 이벤트 ------ */
      paymentMethodWidget.on("ready", function () {
        button.disabled = false;
        coupon.disabled = false;
      });

      /* ------  결제 금액 업데이트 ------ */
      /* @docs https://docs.tosspayments.com/reference/widget-sdk#updateamount결제-금액 */
      coupon.addEventListener("change", function () {
        if (coupon.checked) {
          paymentMethodWidget.updateAmount(amount - testCouponElement.value);
        } else {
          paymentMethodWidget.updateAmount(amount);
        }
      });
      /* 추가 DEV */
      testAmountElement.addEventListener("change", function() {
        amount = testAmountElement.value;
        paymentMethodWidget.updateAmount(amount);
      });
      testCouponElement.addEventListener("change", function(){
        document.querySelector(".checkable__label-text").innerHTML = testCouponElement.value + "원 쿠폰 적용";
      });

      /* ------ '결제하기' 버튼 누르면 결제창 띄우기 ------ */
      /* @docs https://docs.tosspayments.com/reference/widget-sdk#requestpayment결제-정보 */
      button.addEventListener("click", function () {
        /* 결제를 요청하기 전에 orderId, amount를 DB에 저장헤서 정합성 체크  */
        paymentWidget.requestPayment({
          orderId: generateRandomString(),
          orderName: orderName.value,
          successUrl: window.location.origin + "/success",
          failUrl: window.location.origin + "/fail",
          customerEmail: customerEmail.value,
          customerName: customerName.value,
          customerMobilePhone: customerMobilePhone.value
        });
      });
    </script>
  </body>
</html>
