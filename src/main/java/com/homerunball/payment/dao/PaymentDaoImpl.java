package com.homerunball.payment.dao;

import com.homerunball.payment.domain.PaymentDto;
import com.homerunball.payment.domain.PaymentFailDto;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl implements PaymentDao{
  @Autowired
  private SqlSession session;
  private static final String NAMESPACE = "com.homerunball.payment.dao.PaymentDao.";

  @Override
  public int insertPaymentSuccess(PaymentDto paymentDto) {
    return session.insert(NAMESPACE+"insertPaymentSuccess", paymentDto);
  }

  @Override
  public int insertPaymentFailure(PaymentFailDto paymentFailDto) {
    return session.insert(NAMESPACE+"insertPaymentFail", paymentFailDto);
  }

  @Override
  public List<PaymentDto> selectPaymentHistoryWithDateRange(Map<String,Object> localDateMap) {
    return session.selectList(NAMESPACE + "selectPaymentHistoryWithDateRange", localDateMap );
  }
}
