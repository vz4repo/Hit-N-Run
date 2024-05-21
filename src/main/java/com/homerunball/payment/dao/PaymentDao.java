package com.homerunball.payment.dao;

import com.homerunball.payment.domain.PaymentDto;
import com.homerunball.payment.domain.PaymentFailDto;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**================================
 *
 */
@Repository
public interface PaymentDao {
    /* 인증 성공 후, Response Body 정보 저장 */
    int insertPaymentSuccess(PaymentDto paymentDto) throws Exception;

    /* 인증 실패 후, Response Body 정보 저장 */
    int insertPaymentFailure(PaymentFailDto paymentFailDto) throws Exception;

    List<PaymentDto> selectPaymentHistoryWithDateRange(Map<String,Object> localDateMap) throws Exception;
}
