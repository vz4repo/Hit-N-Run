package com.homerunball.product.customer.dao;

import com.homerunball.product.customer.domain.ProductViewDto;
import com.homerunball.product.customer.domain.StockViewDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductViewDaoImpl implements ProductViewDao {
    @Autowired
    SqlSession session;
    private static String namespace = "com.homerunball.product.customer.dao.ProductViewMapper.";

    @Override
    public int countPrd() throws Exception{
        return session.selectOne(namespace+"countPrd");
    }
    @Override
    public ProductViewDto selectPrd(String pd_id) throws Exception{
        return session.selectOne(namespace+"selectPrd",pd_id);
    }
    @Override
    public List<ProductViewDto> selectAllPrd() throws Exception{
        return session.selectList(namespace+"selectAllPrd");
    }
    @Override
    public StockViewDto selectStk(String pd_id) throws Exception{
        return session.selectOne(namespace+"selectStk", pd_id);
    }
    @Override
    public StockViewDto selectStkOpt(String pd_id, String pd_clsf_cd) throws Exception{
        Map map = new HashMap();
        map.put("pd_id", pd_id);
        map.put("pd_clsf_cd", pd_clsf_cd);
        return session.selectOne(namespace+"selectStkOpt", map);
    }
}
