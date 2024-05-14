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

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    int c_id = 100006;
    LocalDate fromDate = LocalDate.parse("20230101", formatter);
    LocalDate toDate = LocalDate.parse("20240514", formatter);

    List<PaymentDto> resultDtoList = paymentService.selectPaymentHistoryWithDateRange(c_id,fromDate, toDate);
    System.out.println("resultDtoList = " + resultDtoList);

  }
}