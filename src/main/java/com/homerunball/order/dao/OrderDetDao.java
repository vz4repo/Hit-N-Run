package com.homerunball.order.dao;

import com.homerunball.customer.domain.CustDto;
import com.homerunball.order.domain.OrderDetDto;

import java.util.List;

public interface OrderDetDao {


    /* 리스트 수를 센다*/
    int count() throws Exception;

    int delete(int od_det_seqnum, String od_id, int c_id) throws Exception;

    int deleteAll() throws Exception;

    OrderDetDto select(int od_det_seqnum, String od_id, int c_id) throws Exception;

    List<OrderDetDto> selectAll() throws Exception;

    int insert(OrderDetDto orddet) throws Exception;

    int update(OrderDetDto orddet) throws Exception;
}