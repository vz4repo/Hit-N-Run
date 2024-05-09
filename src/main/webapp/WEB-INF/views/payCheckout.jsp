<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <div>
    <%-- 테스트값 입력 영역(dev) --%>
    <div class="wrapper">
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
