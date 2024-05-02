package com.homerunball.admin.product.dao;

import com.homerunball.admin.product.domain.ProductDto;

import java.util.List;

public interface ProductDao {
    /* 모든 제품의 수를 센다. */
    int countAll() throws Exception;

    /* 모든 제품을 삭제한다. */
    int deleteAll() throws Exception;

    /*진열되지 않은 모든 제품을 선택한다.*/
    List<ProductDto> selectAllOutProduct() throws Exception;

    /* 지정한 제품 하나를 삭제한다. */
    int delete(String pd_id) throws Exception;

    /* 지정한 제품을 여러 개를 삭제한다. */
    int deleteSelected(List<String> pd_id) throws Exception;

    /* 제품 하나를 삽입한다. */
    int insert(ProductDto productDto) throws Exception;

    /* 지정된 제품 하나만을 선택한다. */
    ProductDto selectPrd(String pd_id) throws Exception;

    /* 모든 제품을 선택한다. */
    List<ProductDto> selectPrdAll() throws Exception;

    /* prd(제품) 테이블과 stk(재고) 테이블에서 pd_id(제품ID)가 동일한 모든 제품 선택하기 */
    List<ProductDto> selectPrdPrcAll() throws Exception;

    /* prd(제품) 테이블과 stk(재고) 테이블에서 pd_id(제품ID)가 동일한 제품 한 개 선택하기 */
    ProductDto selectPrdPrc(String pd_id) throws Exception;

    /* 제품 유형을 기준으로 가장 큰 시리얼 넘버를 찾는다. */
    int searchBiggestSerialNumber(String pd_type_cd) throws Exception;

    /* 제품 유형을 기준으로 몇 개의 제품이 있는지 센다. */
    int countType(String pd_type_cd) throws Exception;

    /* 제품의 내용을 업데이트한다. */
    int updateContent(ProductDto productDto) throws Exception;

    /* 제품의 상태를 업데이트한다. */
//    int updateStatus(ProductDto productDto) throws Exception;

    /* 상품이 선택될 때마다 조회수를 늘린다. */
    int increaseHitCnt(String pd_id) throws Exception;

    /*진열이 제외된 상품을 다시 진열한다.*/
    int updateToShow(List<String> pd_id) throws Exception;
}