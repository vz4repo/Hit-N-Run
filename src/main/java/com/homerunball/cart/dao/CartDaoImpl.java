package com.homerunball.cart.dao;

import com.homerunball.cart.domain.CartDto;
import com.homerunball.customer.domain.CustDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CartDaoImpl implements CartDao {
    @Autowired
    private SqlSession session;

    private static String namespace = "com.homerunball.cart.dao.CartDao.";


    @Override
    public List<CustDto> getcustAll() throws Exception{
        return session.selectList(namespace+"getcustAll");
    }

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    @Override
    public int delete(int c_id, String pd_id, String pd_clsf_code) throws Exception {
        Map map = new HashMap();
        map.put("c_id", c_id);
        map.put("pd_id", pd_id);
        map.put("pd_clsf_code", pd_clsf_code);
        return session.delete(namespace+"delete", map);
    }


    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace+"deleteAll");
    }

    @Override
    public int cidDeleteAll(int c_id) throws Exception {
        return session.delete(namespace+"cidDeleteAll", c_id);
    }

    @Override
    public boolean exists(CartDto cart) throws Exception {
        return session.selectOne(namespace+"exists", cart);
    }

    @Override
    public int insert(CartDto cart) throws Exception {
        return session.insert(namespace+"insert", cart);
    }


    @Override
    public int update(CartDto cart) throws Exception {
        return session.update(namespace+"update", cart);
    }

    @Override
    public List<CartDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public List<CartDto> selectUser(int c_id) throws Exception {
        return session.selectList(namespace+"selectUser",c_id);
    }

    @Override
    public List<CartDto> getStk(int c_id) throws Exception {
        return session.selectList(namespace+"getStk",c_id);
    }

}