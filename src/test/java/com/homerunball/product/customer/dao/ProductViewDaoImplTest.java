package com.homerunball.product.customer.dao;

import com.homerunball.product.customer.domain.ProductViewDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProductViewDaoImplTest {
@Autowired
ProductViewDao productViewDao;
    @Test
    public void countPrd() throws Exception {
        System.out.println("productViewDao.countPrd() = " + productViewDao.countPrd());
    }

    @Test
    public void selectPrd() throws Exception {
        System.out.println("productViewDao.selectPrd(\"GLV000001-99\") = " + productViewDao.selectPrd("GLV000001-99"));
    }

    @Test
    public void selectAllPrd() throws Exception {
        List<ProductViewDto> list = productViewDao.selectAllPrd();
        System.out.println("list.size() = " + list.size());
        System.out.println("list = " + list);
    }

    @Test
    public  void selectStk() throws Exception {
        System.out.println("productViewDao.selectStk(\"GLV000001-99\") = " + productViewDao.selectStk("GLV000001-99"));
    }

    @Test
    public void selectStkOpt() throws Exception {
        System.out.println("productViewDao.selectStkOpt(\"GLV000001-99\", \"RH\") = " + productViewDao.selectStkOpt("GLV000001-99", "RH"));
    }
}