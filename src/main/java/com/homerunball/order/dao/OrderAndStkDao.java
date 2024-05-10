package com.homerunball.order.dao;

import com.homerunball.order.domain.OrdAndStkDto;

import java.util.List;

public interface OrderAndStkDao {
    List<OrdAndStkDto> getcartItem(int c_id);
}
