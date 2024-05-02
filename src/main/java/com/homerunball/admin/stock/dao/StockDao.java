package com.homerunball.admin.stock.dao;

import com.homerunball.admin.stock.domain.StockDto;

import java.util.List;

public interface StockDao {
    /*모든 재고 선택*/
    List<StockDto> selectStkAll() throws Exception;

    /*재고 1개 선택(지정된 제품ID, 사이즈코드 선택)*/
    StockDto selectStk(String pd_id, String pd_clsf_cd) throws Exception;

    /*재고 전체 수량 카운트*/
    int count() throws Exception;

    /*모든 재고 삭제*/
    int deleteAll() throws Exception;

    /*재고 1개 삭제(지정된 제품ID, 사이즈코드 선택)*/
    int delete(String pd_id, String pd_clsf_cd) throws Exception;

    /*재고 하나 추가*/
    int insertStk(StockDto stockDto) throws Exception;

    /*재고의 내용을 업데이트 한다.*/
    int update(StockDto stockDto) throws Exception;

    /*재고의 상태를 업데이트 한다.*/
    int updateStatus(StockDto stockDto) throws Exception;

}
