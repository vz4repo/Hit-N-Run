package com.homerunball.order.dao;

import com.homerunball.order.domain.OrdAndStkDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderAndStkDaoImpl implements OrderAndStkDao {
    @Autowired
    private SqlSession session;

    private static String namespace = "com.homerunball.order.dao.OrderAndStkDao.";
    @Override
    public List<OrdAndStkDto> getcartItem(int c_id) {
        return session.selectList(namespace+"getcartItem", c_id);
    }
}
