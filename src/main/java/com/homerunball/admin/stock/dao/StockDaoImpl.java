package com.homerunball.admin.stock.dao;

import com.homerunball.admin.stock.domain.StockDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockDaoImpl implements StockDao {

    @Autowired
    private SqlSession session;
    private static String namespace = "com.homerunball.admin.stock.dao.StockMapper.";

    /*재고 전체조회하는 메서드. dto와 수신 */
    @Override
    public List<StockDto> selectStkAll() throws Exception {
        List<StockDto> list = session.selectList(namespace + "selectStkAll");
        return list;
    }

    /*재고 중 pd_id, pd_clsf_cd가 일치하는 제품 1개 조회하는 메서드. dto와 수신 */
    @Override
    public StockDto selectStk(String pd_id, String pd_clsf_cd) throws Exception {
        return session.selectOne(namespace+"selectStk");
    }


}
