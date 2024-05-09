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
  * widgetClientKey: 테스트 클라이언트 키
  * customerKey: 내 상점에서 고객을 구분하기 위한 키
  * paymentWidget: 회원/비회원마다 다른 호출
  */
  const widgetClientKey = "test_gck_docs_Ovk5rk1EwkEbP0W43n07xlzm";
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


  /*결제 성공시(200) order테이블 insert*/
  if(window.location.pathname === "/success") {
    // 결제가 성공하면 주문을 처리하는 코드 실행
    $.ajax({
      url: "<c:url value='/order'/>?c_id=${c_id}",
      type: "POST",
      success: function(response) {
        // 성공적으로 처리되었을때
        console.log("주문이 성공적으로 처리되었습니다.");
      }
    });
  }
