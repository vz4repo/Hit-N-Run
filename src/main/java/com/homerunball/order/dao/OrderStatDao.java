package com.homerunball.order.dao;

import com.homerunball.order.domain.OrderStatDto;

public interface OrderStatDao {
    int count() throws Exception;

    int delete(int od_stat_seqnum, int od_id) throws Exception;

    int insert(OrderStatDto ord_stat) throws Exception;

    int deleteAll() throws Exception;

}
