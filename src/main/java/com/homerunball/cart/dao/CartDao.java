package com.homerunball.cart.dao;

import com.homerunball.cart.domain.CartDto;
import com.homerunball.customer.domain.CustDto;

import java.util.List;

public interface CartDao {
    List<CustDto> getcustAll() throws Exception;


    int count() throws Exception;

    int delete(int c_id, String pd_id, String pd_clsf_code) throws Exception;

    int deleteAll() throws Exception;

    int cidDeleteAll(int c_id) throws Exception;

    int insert(CartDto cart) throws Exception;

    int update(CartDto cart) throws Exception;

    List<CartDto> selectAll() throws Exception;

    List<CartDto> selectUser(int c_id) throws Exception;

    List<CartDto> getStk(int c_id) throws Exception;

}