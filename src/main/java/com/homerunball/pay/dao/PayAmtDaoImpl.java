package com.homerunball.pay.dao;

import com.homerunball.pay.dto.PayAmtDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PayAmtDaoImpl implements PayAmtDao{
    @Autowired
    private SqlSession session;
    private static String namespace = "PayAmtDto.";

    public PayAmtDto insertPayAmt(PayAmtDto dto) {
        return session.selectOne(namespace+"insertPayAmt", dto);
    }
}
