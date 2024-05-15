package com.homerunball.payment.service;

import com.homerunball.payment.dao.PaymentDao;
import com.homerunball.payment.domain.PaymentDto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
  public List<PaymentDto> selectPaymentHistoryWithDateRange(@SessionAttribute(name = "c_id")int c_id, String fromDate, String toDate) {
    /* 날짜포맷으로 String -> LocalDate Casting */
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /* TODO: Exception 처리 대상
     *   java.time.format.DateTimeParseException - 잘못된 날짜형식. 2024.12.32
     *  */
    LocalDate parsedfromDate = LocalDate.parse(fromDate, formatter);
    LocalDate parsedtoDate = LocalDate.parse(toDate, formatter);

    Map<String, Object> localDateMap = new HashMap<>();
    localDateMap.put("c_id", c_id);
    localDateMap.put("fromDate", parsedfromDate);
    localDateMap.put("toDate", parsedtoDate);

    return paymentDao.selectPaymentHistoryWithDateRange(localDateMap);
  }
}
