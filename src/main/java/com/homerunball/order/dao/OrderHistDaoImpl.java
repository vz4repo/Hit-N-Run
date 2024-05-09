//package com.homerunball.ord.dao;
//
//import com.homerunball.ord.domain.OrderHistDto;
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Repository
//public class OrderHistDaoImpl implements OrderHistDao {
//    @Autowired
//    private SqlSession session;
//    private static String namespace = "com.homerunball.ord.dao.OrderHistDao.";
//
//    @Override
//    public  int count() throws Exception{
//        return session.selectOne(namespace+"conut");
//    }
//
//    @Override
//    public int delete(String od_hist_seqnum, String od_id, String c_id){
//        Map map = new HashMap();
//        map.put("od_hist_seqnum", od_hist_seqnum);
//        map.put("od_id", od_id);
//        map.put("c_id", c_id);
//        return session.delete(namespace+"delete", map);
//    }
//
//    @Override
//    public int insert(OrderHistDto ord_hist) throws Exception{
//        return session.insert(namespace+"insert", ord_hist);
//    }
//
//}
