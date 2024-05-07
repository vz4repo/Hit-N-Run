package com.homerunball.order.service;

import com.homerunball.order.domain.OrderDetDto;

import java.util.List;

public interface OrderDetService {
    int getcount() throws Exception;

    int delete(int od_det_seqnum, int od_id, String pd_id, String pd_clsf_cd) throws Exception;

    List<OrderDetDto> select(int od_det_seqnum, int od_id) throws Exception;

    int insert(OrderDetDto ord_det) throws Exception;

    List<OrderDetDto> getList() throws Exception;

    int update(OrderDetDto ord_det) throws Exception;
}
