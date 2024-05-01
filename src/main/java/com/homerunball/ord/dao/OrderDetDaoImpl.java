package com.homerunball.ord.dao;

import com.homerunball.ord.domain.OrderDetDto;
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
    private static String namespace = "com.homerunball.ord.dao.OrderDetMapper.";

    /* 리스트 수를 센다*/
    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    /*데이터를 삭제한다*/
    @Override
    public int delete(int od_det_seqnum, String od_id) throws Exception {
        Map map = new HashMap();
        map.put("od_det_seqnum", od_det_seqnum);
        map.put("od_id", od_id);
        return session.delete(namespace+"delete", map);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace+"deleteAll");
    }

    @Override
    public OrderDetDto select(int od_det_seqnum, String od_id) throws Exception {

        /*System.out.println("asdf" + od_det_seqnum);*/

        return session.selectOne(namespace + "select", od_det_seqnum);
    }

    @Override
    public List<OrderDetDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public int insert(OrderDetDto dto) throws Exception {
        return session.insert(namespace+"insert", dto);
    }
    @Override
    public int update(OrderDetDto dto) throws Exception {
        return session.update(namespace+"update", dto);
    }
}
