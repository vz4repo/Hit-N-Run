package com.homerunball.admin.product.dao;

import com.homerunball.admin.product.domain.ProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SqlSession session;
    private static String NAMESPACE = "com.homerunball.admin.product.dao.ProductMapper.";

    /* 모든 제품의 수를 센다. */
    @Override
    public int countAll() throws Exception {
        return session.selectOne(NAMESPACE + "count");
    }

    /* 모든 제품을 삭제한다. */
    @Override
    public int deleteAll() throws Exception {
        return session.delete(NAMESPACE + "deleteAll");
    }

    /* 지정된 pd_id만을 삭제한다. */
    @Override
    public int delete(String pd_id) throws Exception {
        return session.delete(NAMESPACE + "delete", pd_id);
    }

    /* 제품 하나를 삽입한다. */
    @Override
    public int insert(ProductDto productDto) throws Exception {
        return session.insert(NAMESPACE + "insert", productDto);
    }

    /* 모든 제품을 선택한다. */
    @Override
    public List<ProductDto> selectPrdAll() throws Exception {
        return session.selectList(NAMESPACE + "selectPrdAll");
    }

    /*진열되지 않은 모든 제품을 선택한다.*/
    @Override
    public List<ProductDto> selectAllOutProduct() throws Exception {
        return session.selectList(NAMESPACE + "selectAllOutProduct");
    }

    /* 지정된 제품 하나만을 선택한다. */
    @Override
    public ProductDto selectPrd(String pd_id) throws Exception {
        return session.selectOne(NAMESPACE + "selectPrd", pd_id);
    }

    /* prd(제품) 테이블과 stk(재고) 테이블에서 pd_id(제품ID)가 동일한 모든 제품 선택하기 */
    @Override
    public List<ProductDto> selectPrdPrcAll() throws Exception {
        return session.selectList(NAMESPACE + "selectPrdPrcAll");
    }

    /* prd(제품) 테이블과 stk(재고) 테이블에서 pd_id(제품ID)가 동일한 제품 한 개 선택하기 */
    @Override
    public ProductDto selectPrdPrc(String pd_id) throws Exception {
        return session.selectOne(NAMESPACE + "selectPrdPrc", pd_id);
    }

    /* 제품 유형을 기준으로 가장 큰 시리얼 넘버를 찾는다. */
    @Override
    public int searchBiggestSerialNumber(String pd_type_cd) throws Exception {
        return session.selectOne(NAMESPACE + "searchBiggestSerialNumber", pd_type_cd);
    }

    /* 제품 유형을 기준으로 몇 개의 제품이 있는지 센다. */
    @Override
    public int countType(String pd_type_cd) throws Exception {
        return session.selectOne(NAMESPACE + "countType", pd_type_cd);
    }

    /* 제품에 등록된 내용을 업데이트한다. */
    @Override
    public int updateContent(ProductDto productDto) throws Exception {
        return session.update(NAMESPACE + "updateContent", productDto);
    }

    /* 제품의 상태를 업데이트한다. */
//    @Override
//    public int updateStatus(ProductDto productDto) throws Exception {
//        return session.update(NAMESPACE + "updateStatus", productDto);
//    }

    /* 상품이 선택될 때마다 조회수를 늘린다. */
    @Override
    public int increaseHitCnt(String pd_id) throws Exception {
        return session.update(NAMESPACE + "increaseHitCnt", pd_id);
    }

    /*진열이 제외된 상품을 다시 진열한다.*/
    @Override
    public int updateToShow(List<String> pd_id) throws Exception {
        return session.update(NAMESPACE + "updateToShow", pd_id);
    }
}