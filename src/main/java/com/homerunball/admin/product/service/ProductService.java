package com.homerunball.admin.product.service;

import com.homerunball.admin.product.domain.ProductDto;

import java.util.List;

public interface ProductService {
    /* 모든 제품의 수를 센다. */
    int getAllCount() throws Exception;

    /* 모든 제품을 삭제한다. */
    public int removeAll() throws Exception;

    /* 지정된 pd_id만을 삭제한다. */
    int remove(String pd_id) throws Exception;

    /* 제품 하나를 생성한다. */
    int create(ProductDto productDto) throws Exception;

    /* 모든 제품을 list에 저장한다. */
    List<ProductDto> getAllProducts() throws Exception;

    /* 진열되지 않는 모든 제품을 list에 저장한다. */
    public List<ProductDto> getAllOutProducts() throws Exception;

    /* 지정된 제품 하나만을 가져온다. */
    ProductDto getOneProduct(String pd_id) throws Exception;

    /* 제품 유형을 기준으로 가장 큰 시리얼 넘버를 찾는다. */
    int findBiggestSerialNumber(String pd_type_cd) throws Exception;

    /* 제품 유형을 기준으로 몇 개의 제품이 있는지 센다. */
    int countProductType(String pd_type_cd) throws Exception;

    /* 제품의 내용을 수정한다. */
    int modifyContent(ProductDto productDto) throws Exception;

    /*진열이 제외된 상품을 다시 진열한다.*/
    int showProduct(List<String> pd_id) throws Exception;
}