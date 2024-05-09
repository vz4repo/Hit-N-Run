package com.homerunball.product.customer.dao;

import com.homerunball.product.customer.domain.ProductViewDto;
import com.homerunball.product.customer.domain.StockViewDto;

import java.util.List;

public interface ProductViewDao {
    int countPrd() throws Exception;

    ProductViewDto selectPrd(String pd_id) throws Exception;

    List<ProductViewDto> selectAllPrd() throws Exception;

    StockViewDto selectStk(String pd_id) throws Exception;

    StockViewDto selectStkOpt(String pd_id, String pd_clsf_cd) throws Exception;
}
