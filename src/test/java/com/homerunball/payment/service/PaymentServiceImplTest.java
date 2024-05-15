package com.homerunball.payment.service;

import com.homerunball.payment.domain.PaymentDto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PaymentServiceImplTest {
  @Autowired
  private PaymentService paymentService;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Test
  public void 결제내역_날짜범위로_조회() {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    /* service에서 쓸 param 3개 */
    int c_id = 100006;
    String strFromDate = "2019-05-15";
    String strToDate = "2024-05-15";

    /* service 수행 */
    List<PaymentDto> resultDtoList = paymentService.selectPaymentHistoryWithDateRange(c_id,strFromDate, strToDate);
    /* resultDtoList.stream().forEach(System.out::println); */
    /* 출력값 (주문명, 주문일, 주문금액) 확인 */
    resultDtoList.stream()
        .map(resultDto -> String.format("주문명: %s, 주문일: %s, 주문금액: %s, 주문번호: %d", resultDto.getPay_final_amt(), resultDto.getPay_dt(), resultDto.getPay_od_name(), resultDto.getOd_id()))
        .forEach(System.out::println);
  }
}