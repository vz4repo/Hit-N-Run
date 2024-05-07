package com.homerunball.order.dao;

import com.homerunball.customer.domain.CustDto;
import com.homerunball.order.domain.OrdDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrdDaoImpl implements OrdDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.homerunball.order.dao.OrdDao.";

    @Autowired
    public String getcid() throws Exception{
        return session.selectOne(namespace+"getcid");
    }
    /* 리스트 수를 센다*/
    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    } // T selectOne(String statement)

    /*데이터를 삭제한다*/
    @Override
    public int delete(Integer od_id, String c_id) throws Exception {
        Map map = new HashMap();
        map.put("od_id", od_id);
        map.put("c_id", c_id);
        return session.delete(namespace+"delete", map);
    }

    /*데이터를 모두 삭제한다*/
    @Override
    public int deleteAll() {
        return session.delete(namespace+"deleteAll");
    } // int delete(String statement)

    /*od_id 한개를 불러온다*/
    @Override
    public OrdDto select(Integer od_id, String c_id) throws Exception {

        System.out.println("asdf" + od_id);

        return session.selectOne(namespace + "select", od_id);
    } // T selectOne(String statement, Object parameter)

    /*모든 od_id를 불러온다*/
    @Override
    public List<OrdDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    } // Li


    @Override
    public List<OrdDto> selectOdId(Integer od_id) throws Exception {
        return session.selectList(namespace+"selectOdId",od_id);
    }

    /* od_id 한개를 입력해준다*/
    @Override
    public int insert(OrdDto ord) throws Exception {
        return session.insert(namespace+"insert", ord);
    }
//        OrdDto select(String od_id, String c_id) throws Exception; // T selectOne(String statement, Object parameter)

    /*주문 리스트를 업데이트한다*/
    @Override
    public int update(OrdDto ord) throws Exception {
        return session.update(namespace+"update", ord);
    } // int update(String statement, Object parameter)

}
