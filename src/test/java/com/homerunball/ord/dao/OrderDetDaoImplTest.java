package com.homerunball.ord.dao;

import com.homerunball.ord.domain.OrderDetDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrderDetDaoImplTest {
    @Autowired
    private OrderDetDao orderdetDao;

    @Test
    public void count() throws Exception{
        orderdetDao.deleteAll();
        assertTrue(orderdetDao.count()==0);

//        OrderDetDto ord_det = new OrderDetDto(20240117-000001, 1, "GLV000001-80","XS",new Date(),"XANDER BOGAERTS",940000,2,"asdf",new Date(),"a",new Date(),"a");
//        assertTrue(orderdetDao.insert(ord_det)==1);
//        assertTrue(orderdetDao.count()==1);
    }

    @Test
    public void delete(){

    }

    @Test
    public void select() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }
}