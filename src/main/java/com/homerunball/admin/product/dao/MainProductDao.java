package com.homerunball.admin.product.dao;

import com.homerunball.admin.product.domain.MainProductDto;

import java.util.List;

public interface MainProductDao {
    /*판매중인 신제품을 선택한다.*/
    List<MainProductDto> selectAllNewSalesProduct() throws Exception;

    /*판매중인 인기제품을 선택한다.*/
    List<MainProductDto> selectAllHotSalesProduct() throws Exception;

    /*판매중인 스테디 셀러 제품을 선택한다.*/
    List<MainProductDto> selectAllSteadySalesProduct() throws Exception;

    /*판매중인 추천 제품을 선택한다.*/
    List<MainProductDto> selectAllRecommendSalesProduct() throws Exception;
}