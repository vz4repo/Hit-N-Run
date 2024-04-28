package com.homerunball.admin.product.service;

import com.homerunball.admin.product.ProductDto;

import java.util.List;

public interface ProductService {
    int getAllCount() throws Exception;

    public int removeAll() throws Exception;

    int remove(String pd_id) throws Exception;

    int create(ProductDto productDto) throws Exception;

    List<ProductDto> getAllProducts() throws Exception;

    ProductDto getOneProduct(String pd_id) throws Exception;

    int modifyContent(ProductDto productDto) throws Exception;

    int updateStatus(ProductDto productDto) throws Exception;
}