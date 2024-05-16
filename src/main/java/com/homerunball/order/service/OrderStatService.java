package com.homerunball.order.service;

import com.homerunball.order.domain.OrderStatDto;

public interface OrderStatService {
    int getcount() throws Exception;

    int delete(int od_stat_seqnum, int od_id) throws Exception;

    int insert(OrderStatDto ord_stat) throws Exception;
}
