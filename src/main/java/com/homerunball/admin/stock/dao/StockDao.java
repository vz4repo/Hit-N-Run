package com.homerunball.admin.stock.dao;

import com.homerunball.admin.stock.dto.StockDto;

import java.util.List;

public interface StockDao {

    List<StockDto> selectStkAll() throws Exception;
    StockDto selectStk(String pd_id, String pd_clsf_cd) throws Exception;

/*
    int count() throws Exception;
    int deleteAll() throws Exception;
    int delete(String pd_id, String pd_clsf_cd) throws Exception;
*/



}
