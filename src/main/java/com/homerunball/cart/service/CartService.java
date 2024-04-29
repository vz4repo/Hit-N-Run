package com.homerunball.cart.service;

import com.homerunball.cart.domain.CartDto;

import java.util.List;

public interface CartService {
    int getCount() throws Exception;

    int remove(String c_id, String pd_id) throws Exception;

    int removeAll() throws Exception;

    int create(CartDto cart) throws Exception;

    int update(String c_id) throws Exception;

    CartDto read(String c_id) throws Exception;

    List<CartDto> readAll() throws Exception;
}
