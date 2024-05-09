package com.homerunball.payment.dao;

import com.homerunball.payment.domain.PaymentDto;
import com.homerunball.payment.domain.PaymentFailDto;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
  public void 저장하면_결과는_1() {
    /* Dto에 값 직접 대입 생성 */
    PaymentDto paymentDto = new PaymentDto("tgen_20250509375A8517OXo2",2 ,100000111 ,240502101 ,"1aB90E5F4F763DDCD54A704CC28D1CFB",32021 ,32021 ,"05",ldt,"토스페이","DONE","00000000",ldt,"200","32테스트","31","31","개인신용",0 ,"91005000****750*");
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
}
