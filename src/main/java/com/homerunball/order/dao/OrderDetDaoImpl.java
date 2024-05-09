package com.homerunball.order.dao;

import com.homerunball.order.domain.OrderDetDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDetDaoImpl implements OrderDetDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.homerunball.order.dao.OrderDetDao.";

    /* 리스트 수를 센다*/
    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    /*데이터를 삭제한다*/
    @Override
    public int delete(int od_det_seqnum, String od_id, int c_id) throws Exception {
        Map map = new HashMap();
        map.put("od_det_seqnum", od_det_seqnum);
        map.put("od_id", od_id);
        map.put("c_id", c_id);
        return session.delete(namespace+"delete", map);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace+"deleteAll");
    }

    @Override
    public OrderDetDto select(int od_det_seqnum, String od_id, int c_id) throws Exception {
        Map map = new HashMap();
        map.put("od_det_seqnum", od_det_seqnum);
        map.put("od_id", od_id);
        map.put("c_id", c_id);
        /*System.out.println("asdf" + od_det_seqnum);*/

        return session.selectOne(namespace + "select", od_det_seqnum);
    }

    @Override
    public List<OrderDetDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public int insert(OrderDetDto ord_det) throws Exception {
        return session.insert(namespace+"insert", ord_det);
    }
    @Override
    public int update(OrderDetDto ord_det) throws Exception {
        return session.update(namespace+"update", ord_det);
    }

}