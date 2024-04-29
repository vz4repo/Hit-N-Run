package com.homerunball.cart.dao;

import com.homerunball.cart.domain.CartDto;
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

    private static String namespace = "com.homerunball.cart.dao.CartMapper.";

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    @Override
    public int delete(String c_id, String pd_id) throws Exception {
        Map map = new HashMap();
        map.put("c_id", c_id);
        map.put("pd_id", pd_id);
        return session.delete(namespace+"delete", map);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace+"deleteAll");
    }

    @Override
    public int insert(CartDto cart) throws Exception {
        return session.insert(namespace+"insert", cart);
    }


    @Override
    public int update(String c_id) throws Exception {
        return session.update(namespace+"update", c_id);
    }

    public CartDto select(String c_id) throws Exception {
        return session.selectOne(namespace+"select",c_id);
    }

    @Override
    public List<CartDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }

    public List<CartDto> selectUser(String c_id) throws Exception {
        return session.selectList(namespace+"selectUser",c_id);
    }


}
