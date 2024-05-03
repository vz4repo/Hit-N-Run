package com.homerunball.admin.stock.dao;

import com.homerunball.admin.stock.domain.StockDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StockDaoImpl implements StockDao {

    @Autowired
    private SqlSession session;
    private static String namespace = "com.homerunball.admin.stock.dao.stockMapper.";

    /*모든 재고 선택*/
    @Override
    public List<StockDto> selectStkAll() throws Exception {
        List<StockDto> list = session.selectList(namespace + "selectStkAll");
        return list;
    }

    /*재고 1개 선택(지정된 제품ID, 사이즈코드 선택)*/
    @Override
    public StockDto selectStk(String pd_id, String pd_clsf_cd) throws Exception {
        Map map = new HashMap();
        map.put("pd_id", pd_id);
        map.put("pd_clsf_cd", pd_clsf_cd);
        return session.selectOne(namespace+"selectStk", map);
    }

    /*재고 전체 수량 카운트*/
    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    /*모든 재고 삭제*/
    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace+"deleteAll");
    }

    /*재고 1개 삭제(지정된 제품ID, 사이즈코드 선택)*/
    @Override
    public int delete(String pd_id, String pd_clsf_cd) throws Exception {
        Map map = new HashMap();
        map.put("pd_id", pd_id);
        map.put("pd_clsf_cd", pd_clsf_cd);
        return session.delete(namespace+"delete", map);
    }

    /*재고 하나 추가*/
    @Override
    public int insertStk(StockDto stockDto) throws Exception {
        return session.insert(namespace+"insertStk", stockDto);
    }

    /*재고의 내용을 업데이트 한다.*/
    @Override
    public int update(StockDto stockDto) throws Exception {
        return session.update(namespace+"update", stockDto);
    }

    /*재고의 상태를 업데이트 한다.*/
    @Override
    public int updateStatus(StockDto stockDto) throws Exception{
        return session.update(namespace+"updateStatus", stockDto);
    }
}
