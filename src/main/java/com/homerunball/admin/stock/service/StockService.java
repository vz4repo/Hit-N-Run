package com.homerunball.admin.stock.service;

import com.homerunball.admin.stock.domain.StockDto;

import java.util.List;

public interface StockService {
    /*재고 목록리스트 보여주기*/
    List<StockDto> getList() throws Exception;

    /*모든 제고의 수량을 센다.(ROW개수)*/
    int getCount() throws Exception;

    /*선택한 재고 상품 상세 보여주기*/
    StockDto getOneStock(String pd_id, String pd_clsf_cd) throws Exception;

    /*재고를 1개 추가하기*/
    int create(StockDto stockDto) throws Exception;

    /*재고 삽입 시 중복을 확인하는 로직*/
    void validateDuplicateStock(StockDto stockDto) throws Exception;

    /*재고 삽입 시 필수값 누락 확인*/
    void validateNotNullStock(StockDto stockDto) throws Exception;

    /*모든 재고를 삭제하기*/
    int removeAll() throws Exception;

    /*재고 하나 삭제하기(ROW)*/
    int remove(String pd_id, String pd_clsf_cd) throws Exception;

    /*재고 내용 수정하기*/
    int modify(StockDto stockDto) throws Exception;

    /*재고 진행 상태 업데이트*/
    int updateStatus(StockDto stockDto) throws Exception;

}
