package com.homerunball.customer.dao;

import com.homerunball.customer.domain.CustDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustDaoImpl implements CustDao {

    /*DB를 연결하기 위한 세션, HTTP 세션이랑 별개*/
    @Autowired
    private SqlSession session;
    private static String namespace = "com.homerunball.customer.dao.CustDao.";

    @Override
    public int deleteCust(String c_email) {
        return session.delete(namespace + "delete", c_email);
    }

    @Override
    public CustDto selectEmail(String c_email) {return session.selectOne(namespace + "selectEmail", c_email);}


    @Override
    public CustDto selectID(int c_id) {return session.selectOne(namespace + "selectID", c_id);}


    @Override
    public int insert(CustDto custdto) {
        return session.insert(namespace + "insert", custdto);
    }

    @Override
    public int updateAll(CustDto custdto) { return session.update(namespace + "updateAll", custdto);
    }

    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace + "deleteAll");
    }
//
    @Override
    public int updateLoginDt(String c_email) {
        return session.update(namespace + "updateLoginDt", c_email);
    }


    @Override
    public CustDto grdNameJoin(int c_id) {return session.selectOne(namespace+ "grdNameJoin", c_id);}


}