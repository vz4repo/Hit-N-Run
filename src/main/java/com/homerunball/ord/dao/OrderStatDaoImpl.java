//package com.homerunball.ord.dao;
//
//import com.homerunball.ord.domain.OrderStatDto;
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Repository
//public class OrderStatDaoImpl implements OrderStatDao {
//    @Autowired
//    private SqlSession session;
//
//    private static String namespace = "com.homerunball.ord.dao.OrderStatMapper.";
//
//    @Override
//    public int count() throws Exception {
//        return session.selectOne(namespace+"count");
//    }
//
//
//    @Override
//    public int delete(String od_stat_seqnum, String od_id, String c_id) throws Exception {
//        Map map = new HashMap();
//        map.put("od_det_seqnum", od_stat_seqnum);
//        map.put("od_id", od_id);
//        map.put("c_id", c_id);
//        return session.delete(namespace+"delete", map);
//    }
//
//    @Override
//    public int insert(OrderStatDto ord_stat) throws Exception {
//        return session.insert(namespace+"insert", ord_stat);
//    }
//}
