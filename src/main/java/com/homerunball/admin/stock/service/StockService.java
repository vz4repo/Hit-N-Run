package com.homerunball.admin.stock.service;

import com.homerunball.admin.stock.dto.StockDto;

import java.util.List;

public interface StockService {
    List<StockDto> getList() throws Exception;  /*재고 목록리스트 보여주기*/
    StockDto readStock(String pd_id, String pd_clsf_cd) throws Exception;   /*선택한 재고 상품 상세 보여주기*/


/*
    int create(StockDto stockDto) throws Exception;
    int getCount() throws Exception;
    int removeAll() throws Exception;
    int remove(String pd_id, String pd_clsf_cd) throws Exception;
*/


}
