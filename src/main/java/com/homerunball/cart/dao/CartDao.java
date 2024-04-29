package com.homerunball.cart.dao;

import com.homerunball.cart.domain.CartDto;

import java.util.List;

public interface CartDao {
    int count() throws Exception;

    int delete(String c_id, String pd_id) throws Exception;

    int deleteAll() throws Exception;

    int insert(CartDto cart) throws Exception;

    int update(String c_id) throws Exception;

    CartDto select(String c_id) throws Exception;

    List<CartDto> selectAll() throws Exception;

    List<CartDto> selectUser(String c_id) throws Exception;
}
