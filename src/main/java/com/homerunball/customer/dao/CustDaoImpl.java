package com.homerunball.customer.dao;

import com.homerunball.customer.domain.CustDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustDaoImpl implements CustDao {
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
    public int insertCust(CustDto custdto) {
        return session.insert(namespace + "insert", custdto);
    }

    @Override
    public int updateCust(CustDto custdto) {
        return session.update(namespace + "update", custdto);
    }

    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace + "deleteAll");
    }
//
    @Override
    public int updateLoginDate(String c_email) {
        return session.update(namespace + "updateLoginDate", c_email);
    }

//    @Override
//    public HashMap<String, String> selectCustomerWithGrade(String c_email){
//        return session.selectOne(namespace + "CustGrdName", c_email);
//    }
}