package com.homerunball.admin.product.service;

import com.homerunball.admin.product.dao.MainProductDao;
import com.homerunball.admin.product.domain.MainProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainProductServiceImpl implements MainProductService {
    @Autowired
    MainProductDao mainProductDao;

    /*판매중인 신제품을 선택한다.*/
    @Override
    public List<MainProductDto> getAllNewSalesProduct() throws Exception {
        return mainProductDao.selectAllNewSalesProduct();
    }
}