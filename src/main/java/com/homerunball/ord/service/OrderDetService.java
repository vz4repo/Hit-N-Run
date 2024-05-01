package com.homerunball.ord.service;

import com.homerunball.ord.dao.OrderDetDao;
import com.homerunball.ord.domain.OrdDto;
import com.homerunball.ord.domain.OrderDetDto;

import java.util.List;

public interface OrderDetService {
    int getcount() throws Exception;

    int delete(int od_det_seqnum, String od_id) throws Exception;

    OrderDetDto select(int od_det_seqnum, String od_id) throws Exception;

    int insert(OrderDetDto ord_det) throws Exception;

    List<OrderDetDto> getList() throws Exception;

    int update(OrderDetDto ord_det) throws Exception;
}
