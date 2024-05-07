package com.homerunball.payment.dao;

import com.homerunball.payment.domain.PaymentDto;
import com.homerunball.payment.domain.PaymentFailDto;
import org.springframework.stereotype.Repository;

/**================================
 *
 */
@Repository
public interface PaymentDao {
    /* 인증 성공 후, Response Body 정보 저장 */
    int insertPaymentSuccess(PaymentDto paymentDto);

    /* 인증 실패 후, Response Body 정보 저장 */
    int insertPaymentFailure(PaymentFailDto paymentFailDto);
}
