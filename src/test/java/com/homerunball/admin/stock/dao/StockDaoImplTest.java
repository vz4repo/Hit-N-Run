package com.homerunball.admin.stock.dao;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class StockDaoImplTest extends TestCase {

    @Autowired
    private StockDao stockDao;
/*
우선 구현해보고 테스트...
    *//*
    재고 전체조회하는 메서드 테스트
    1. 10개 추가
    2. 데이터 선택
    3. 없는 데이터 선택
    *//*
    @Test
    @Transactional
    public void testSelectStkAll() {

    }

    public void testSelectStk() {
    }
    */
}