package com.homerunball.payment.service;

import com.homerunball.payment.dao.PaymentDao;
import com.homerunball.payment.domain.PaymentDto;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

@Service
public class PaymentServiceImpl implements PaymentService {
  @Autowired
  PaymentDao paymentDao;

  @Override
  public List<PaymentDto> selectPaymentHistoryWithDateRange(@SessionAttribute(name = "c_id")int c_id, LocalDate fromDate, LocalDate toDate) {
    Map<String, Object> localDateMap = new HashMap<>();
    localDateMap.put("c_id", c_id);
    localDateMap.put("fromDate", fromDate);
    localDateMap.put("toDate", toDate);

    return paymentDao.selectPaymentHistoryWithDateRange(localDateMap);
  }
}
