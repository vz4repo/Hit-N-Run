package com.homerunball.customer.dao;

import com.homerunball.customer.dto.CustDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustDaoImpl implements CustDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.homerunball.cust.dao.custMapper.";

    @Override
    public int deleteCust(String c_email) {
        return session.delete(namespace + "delete", c_email);
    }

    @Override
    public CustDto selectCust(String c_email) {
        return session.selectOne(namespace + "select", c_email);
    }

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
}