/*
package com.homerunball.admin.stock.service;

import com.homerunball.admin.stock.dao.StockDao;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class StockServiceImplTest extends TestCase {

    @Autowired
    private StockDao stockDao;

    @Test
    public void testGetList() {
    }

    @Test
    public void testGetOneStock() {
    }

    @Test
    public void testGetCount() {
    }

    @Test
    public void testCreate() {
    }

    */
/*중복 데이터 확인 테스트*//*

*/
/*
    @Test
    public void testIsDuplicateStock() throws Exception {
//        0. 테이블 전체 초기화
        stockDao.deleteAll();
        assertTrue(stockDao.count()==0);

//        1. 재고 1개 추가
//             1개 insert 확인 / size = 1 확인
        StockDto stockDto = new StockDto("APP000001-10", "M", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockDao.insertStk(stockDto)==1);
        assertTrue(stockDao.count()==1);

//        2. 재고 1개 추가. 총 2개 / 1개 insert 확인 / size = 2 확인
//        2.1. 첫 삽입 데이터와 동일데이터 삽입: false 인지 확인
        stockDto = new StockDto("APP000001-10", "M", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertFalse(stockDao.insertStk(stockDto)==1);
        assertTrue(stockDao.count()==1);

//        2.2. 첫 삽입 데이터와 다른데이터 삽입: true 인지 확인
        stockDto = new StockDto("APP000001-10", "L", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockDao.insertStk(stockDto)==1);
        assertTrue(stockDao.count()==2);

    }
*//*


    @Test
    public void testRemoveAll() {
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void testModify() {
    }

    @Test
    public void testUpdateStatus() {
    }
}*/
