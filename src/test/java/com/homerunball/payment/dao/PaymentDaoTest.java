package com.homerunball.payment.dao;

import com.homerunball.payment.domain.PaymentDto;
import com.homerunball.payment.domain.PaymentFailDto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PaymentDaoTest {
  @Autowired
  private PaymentDao paymentDao;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  /* datetime 객체에 들어갈 테스트 값 */
  ZonedDateTime zdt = ZonedDateTime.parse("2024-04-26T10:53:10+09:00");
  LocalDateTime ldt = zdt.toLocalDateTime();

  /* 1개 값 저장 후 결과==1 확인 */
  @Test
  public void 저장하면_결과는_1() throws Exception {
    /* Dto에 값 직접 대입 생성 */
    PaymentDto paymentDto = new PaymentDto("tgen_20250509375A8517OXo2",2 ,100000111 ,240502101 ,"1aB90E5F4F763DDCD54A704CC28D1CFB",32021 ,32021 ,"05",ldt,"토스페이","DONE","00000000",ldt,"200","32테스트","31","31","개인신용",0 ,"91005000****750*", "주문명");
    logger.debug(String.valueOf(paymentDto));
    /* 인증 성공의 경우 */
    int result = paymentDao.insertPaymentSuccess(paymentDto);

    /* 예상: 1, 결과: result*/
    assertEquals(1, result);

    /* Dto에 값 직접 대입 생성 */
    PaymentFailDto paymentFailDto = new PaymentFailDto("tgen_20250509175A2571OXo2", 2024050902, "1aB90E5F4F763DDCD54A704CC28D1CFB", "err-code", "err-msg-ko", ldt);
    logger.debug(String.valueOf(paymentFailDto));
    /* 인증 실패의 경우 */
    result = paymentDao.insertPaymentFailure(paymentFailDto);
    /* 예상: 1, 결과: result*/
    assertEquals(1, result);
  }

  @Test
  public void 결제내역_불러오기(){
/*
    화면설계서 #44 ~ 48

    ISO 8601 형식('2024-05-05T00:00:00') 사용하면 성능에 조금 이득
    EXPLAIN ANALYZE SELECT * FROM pay WHERE pay_dt > '2024-05-05T00:00:00';

    param : 2개
     1. ( from 1|3|6|5*12-month to now )
     2. ( from calendar to calendar )
    결제 정보  출력 목록("결제일자", "상품명", "결제금액") toss 결제 기준 orderName 100자
*/
    /* 현제시각(param2) */
    LocalDate currentDate = LocalDate.now();
    System.out.println("origin currentDate = " + currentDate);

    /* 1, 3, 6, 5*12 개월 */
    /*
    int param1 = 1;
    LocalDate targetDate = currentDate.minusMonths(param1);
    */

    LocalDate targetDate = currentDate.minusMonths(1);
    System.out.println("params >> [FROM] "+targetDate+", [TO] "+ currentDate );

    targetDate = currentDate.minusMonths(3);
        System.out.println("params >> [FROM] "+targetDate+", [TO] "+ currentDate );

    targetDate = currentDate.minusMonths(6);
        System.out.println("params >> [FROM] "+targetDate+", [TO] "+ currentDate );

    targetDate = currentDate.minusMonths(5*12);
        System.out.println("params >> [FROM] "+targetDate+", [TO] "+ currentDate );
/*  // service 에서 테스트하기로..
    currentDate = LocalDate.parse("20240511", formatter자리);
    targetDate = LocalDate.parse("20230512", formatter자리);
        System.out.println("params >> [FROM] "+targetDate+", [TO] "+ currentDate );
*/
  }

}
