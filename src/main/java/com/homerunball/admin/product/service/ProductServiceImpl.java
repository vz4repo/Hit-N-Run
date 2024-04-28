package com.homerunball.admin.product.service;

import com.homerunball.admin.product.ProductDto;
import com.homerunball.admin.product.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public int getAllCount() throws Exception {
        return productDao.countAll();
    }

    @Override
    public int removeAll() throws Exception {
        return productDao.deleteAll();
    }

    @Override
    public int remove(String pd_id) throws Exception {
        return productDao.delete(pd_id);
    }

    @Override
    public int create(ProductDto productDto) throws Exception {
        return productDao.insert(productDto);
    }

    @Override
    public List<ProductDto> getAllProducts() throws Exception {
        return productDao.selectPrdAll();
    }

    @Override
    public ProductDto getOneProduct(String pd_id) throws Exception {
        ProductDto productDto = productDao.selectPrd(pd_id);
        productDao.increaseHitCnt(pd_id);
        return productDto;
    }

    @Override
    public int modifyContent(ProductDto productDto) throws Exception {
        return productDao.updateContent(productDto);
    }

    @Override
    public int updateStatus(ProductDto productDto) throws Exception {
        return productDao.updateStatus(productDto);
    }
}