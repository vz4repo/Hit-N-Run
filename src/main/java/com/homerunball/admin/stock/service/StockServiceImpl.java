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
    @Override
    public List<StockDto> getList() throws Exception {
        return stockDao.selectStkAll();
    }

    /*선택한 재고 상품 상세 보여주기*/
    @Override
    public StockDto getOneStock(String pd_id, String pd_clsf_cd) throws Exception {
        StockDto stockDto = stockDao.selectStk(pd_id, pd_clsf_cd);
        return stockDto;
    }


    /*모든 제고의 수량을 센다.(ROW개수)*/
    @Override
    public int getCount() throws Exception{
        return stockDao.count();
    }

    /*재고를 1개 추가하기*/
    @Override
    public int create(StockDto stockDto) throws Exception{
        return stockDao.insert(stockDto);
    }

    /*모든 재고를 삭제하기*/
    @Override
    public int removeAll() throws Exception{
        return stockDao.deleteAll();
    }

    /*재고 하나 삭제하기(ROW)*/
    @Override
    public int remove(String pd_id, String pd_clsf_cd) throws Exception{
        return stockDao.delete(pd_id, pd_clsf_cd);
    }

    /*재고 내용 수정하기*/
    @Override
    public int modify(StockDto stockDto) throws Exception{
        return stockDao.update(stockDto);
    }

    /*재고 진행 상태 업데이트*/
    @Override
    public int updateStatus(StockDto stockDto) throws Exception{
        return stockDao.updateStatus(stockDto);
    }
}