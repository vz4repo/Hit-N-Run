package com.homerunball.admin.stock.dao;

import com.homerunball.admin.stock.domain.StockDto;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class StockDaoImplTest extends TestCase {

    @Autowired
    private StockDao stockDao;

    @Test
    /*모든 재고 선택*/
    public void testSelectStkAll() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockDao.deleteAll();
        assertTrue(stockDao.count()==0);

        /*1. 재고 1개 추가*/

        /*2. 데이터 선택*/

        /*3. 없는 데이터 선택*/


    }

    @Test
    /*재고 1개 선택(지정된 제품ID, 사이즈코드 선택)*/
    public void testSelectStk() throws Exception {
    }

    @Test
    /*재고 전체 수량 카운트*/
    public void testCount() throws Exception {
    }

    @Test
    /*모든 재고 삭제*/
    public void testDeleteAll() throws Exception {
    }

    @Test
    /*재고 1개 삭제(지정된 제품ID, 사이즈코드 선택)*/
    public void testDelete() throws Exception {
    }

    @Test
    /*재고 하나 추가*/
    public void testInsert() throws Exception {
    }

    @Test
    /*재고의 내용을 업데이트 한다.*/
    public void testUpdate() throws Exception {
    }

    @Test
    /*재고의 상태를 업데이트 한다.*/
    public void testUpdateStatus() throws Exception {

    }
}