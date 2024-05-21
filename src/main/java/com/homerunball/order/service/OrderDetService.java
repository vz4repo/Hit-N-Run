package com.homerunball.order.service;

import com.homerunball.order.domain.OrderDetDto;

import java.math.BigInteger;
import java.util.List;

public interface OrderDetService {
    int getcount() throws Exception;

    int delete(int od_det_seqnum, BigInteger od_id, int c_id) throws Exception;

    List<OrderDetDto> select(int c_id) throws Exception;

    int insert(OrderDetDto ord_det) throws Exception;

    List<OrderDetDto> getList() throws Exception;

    int update(OrderDetDto ord_det) throws Exception;
}
