package com.homerunball.admin.stock.service;

import com.homerunball.admin.stock.dao.StockDao;
import com.homerunball.admin.stock.domain.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;

    /*재고 목록리스트 보여주기*/
    public List<StockDto> getList() throws Exception {
        return stockDao.selectStkAll();
    }

    /*선택한 재고 상품 상세 보여주기*/
    public StockDto readStock(String pd_id, String pd_clsf_cd) throws Exception {
        StockDto stockDto = stockDao.selectStk(pd_id, pd_clsf_cd);
        return stockDto;
    }
}
