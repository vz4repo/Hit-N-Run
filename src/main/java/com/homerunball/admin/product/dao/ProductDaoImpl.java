package com.homerunball.admin.product.dao;

import com.homerunball.admin.product.ProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SqlSession session;
    private static String NAMESPACE = "com.homerunball.admin.product.dao.ProductMapper.";

    /*

     */
    @Override
    public int count() throws Exception {
        return session.selectOne(NAMESPACE + "count");
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(NAMESPACE + "deleteAll");
    }

    @Override
    public int delete(String pd_id) throws Exception {
        return session.delete(NAMESPACE + "delete", pd_id);
    }

    @Override
    public int insert(ProductDto productDto) throws Exception {
        return session.insert(NAMESPACE + "insert", productDto);
    }

    @Override
    public List<ProductDto> selectPrdAll() throws Exception {
        return session.selectList(NAMESPACE + "selectPrdAll");
    }

    @Override
    public ProductDto selectPrd(String pd_id) throws Exception {
        return session.selectOne(NAMESPACE + "selectPrd", pd_id);
    }

    @Override
    public List<ProductDto> selectPrdPrcAll() throws Exception {
        return session.selectList(NAMESPACE + "selectPrdPrcAll");
    }

    @Override
    public ProductDto selectPrdPrc(String pd_id) throws Exception {
        return session.selectOne(NAMESPACE + "selectPrdPrc", pd_id);
    }

    @Override
    public int updateContent(ProductDto productDto) throws Exception {
        return session.update(NAMESPACE + "updateContent", productDto);
    }

    @Override
    public int updateStatus(ProductDto productDto) throws Exception {
        return session.update(NAMESPACE + "updateStatus", productDto);
    }

    @Override
    public int increaseHitCnt(String pd_id) throws Exception {
        return session.update(NAMESPACE + "increaseHitCnt", pd_id);
    }
}