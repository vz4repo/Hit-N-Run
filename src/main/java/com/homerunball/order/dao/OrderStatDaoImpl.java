package com.homerunball.order.dao;

import com.homerunball.order.domain.OrderStatDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderStatDaoImpl implements com.homerunball.order.dao.OrderStatDao {
    @Autowired
    private SqlSession session;

    private static String namespace = "com.homerunball.order.dao.OrderStatMapper.";

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    @Override
    public int delete(int od_stat_seqnum, int od_id) throws Exception {
        Map map = new HashMap();
        map.put("od_stat_seqnum", od_stat_seqnum);
        map.put("od_id", od_id);
        return session.delete(namespace+"delete", map);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace+"deleteAll");
    }

    @Override
    public int insert(OrderStatDto ord_stat) throws Exception {
        return session.insert(namespace+"insert", ord_stat);
    }
}
