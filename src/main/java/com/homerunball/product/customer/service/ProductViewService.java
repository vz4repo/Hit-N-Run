package com.homerunball.product.customer.service;

import com.homerunball.product.customer.domain.ProductViewDto;
import com.homerunball.product.customer.domain.StockViewDto;

import java.util.List;

public interface ProductViewService {
    int getCnt() throws Exception;
    ProductViewDto read(String pd_id) throws Exception;
    List<ProductViewDto> getList() throws Exception;
    StockViewDto readStkInfo(String pd_id) throws Exception;
    StockViewDto readStkOptInfo(String pd_id, String pd_clsf_cd) throws Exception;
}
