package com.homerunball.order.dao;

import com.homerunball.order.domain.OrdDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrdDaoImplTest {
    @Autowired
    private OrdDao ordDao;

    @Test
    public void count() throws Exception{
        ordDao.deleteAll();
        assertTrue(ordDao.count()==0);


        OrdDto ord = new OrdDto(100012, new Date(), "00주문완료", 1, 1, 30000, 30000);
        assertTrue(ordDao.insert(ord) == 1);
        assertTrue(ordDao.count()==1);

        OrdDto ord2 = new OrdDto(100012, new Date(), "21구매확정", 1, 1, 50000, 50000);

        assertTrue(ordDao.insert(ord2) == 1);
        assertTrue(ordDao.count()==2);

    }

    @Test
    public void deleteAll() throws Exception {
        ordDao.deleteAll();
        assertTrue(ordDao.count()==0);

        OrdDto ordDto = new OrdDto(100012, new Date(), "00주문완료", 1, 1, 30000, 30000);
        assertTrue(ordDao.insert(ordDto)==1);
        assertTrue(ordDao.deleteAll()==1);
        assertTrue(ordDao.count()==0);

        ordDto = new OrdDto(100012, new Date(), "00주문완료", 1, 1, 30000, 30000);
        assertTrue(ordDao.insert(ordDto)==1);
        ordDto = new OrdDto(100012, new Date(), "00주문완료", 1, 1, 30000, 30000);
        assertTrue(ordDao.insert(ordDto)==1);
        assertTrue(ordDao.deleteAll()==2);
        assertTrue(ordDao.count()==0);
    }

    @Test
    public void select() throws Exception {
        /* 데이터 초기화*/
        ordDao.deleteAll();
        assertTrue(ordDao.count()==0);


        OrdDto ord = new OrdDto(100012, new Date(), "00주문완료", 1, 1, 30000, 30000);
        assertTrue(ordDao.insert(ord) == 1);


        /*2번 데이터*/
        OrdDto ord2 = new OrdDto(100012, new Date(), "00주문완료", 1, 1, 30000, 30000);
        assertTrue(ordDao.insert(ord2) == 1);

        /* 한 고객(100012)이 주문을 각자 2번하고, od_id (주문번호는) 다르게 생성된다 */
        assertFalse(ord.equals(ord2)); /* 다른 주문번호이기때문에 두 객체는 다르다. */

        /*2번 데이터 조회*/
        int oid = ordDao.selectAll().get(0).getOd_id();
        int cid = ordDao.selectAll().get(0).getC_id();
        ord2 = ordDao.select(oid, cid);

        /*수정*/
        ord2.setOd_stat_cd("after");

        /*수정된 데이터 업데이트*/
        assertTrue(ordDao.update(ord2) == 1);

        /*수정된 데이터 확인*/
        OrdDto updatedOrd = ordDao.select(ord2.getOd_id(), ord2.getC_id());
        assertEquals("after", updatedOrd.getOd_stat_cd());

        /*다시 조회*/
        int od_id = ordDao.selectAll().get(0).getOd_id();

        ord.setOd_id(od_id);

        /*od_id랑 od_id2 비교*/
        assertTrue(ord != ord2);
    }

    @Test
    public void selectAll() throws Exception {
        ordDao.deleteAll();
        assertTrue(ordDao.count()==0);

        List<OrdDto> list = ordDao.selectAll();
        assertTrue(list.size() == 0);

        OrdDto ordDto = new OrdDto(100012, new Date(), "00주문완료", 1, 1, 30000, 30000);
        assertTrue(ordDao.insert(ordDto)==1);

        list = ordDao.selectAll();
        assertTrue(list.size() == 1);

        OrdDto ordDto2 = new OrdDto(100012, new Date(), "00주문완료", 1, 1, 30000, 30000);
        assertTrue(ordDao.insert(ordDto2)==1);
        list = ordDao.selectAll();
        assertTrue(list.size()==2);
    }

    @Test
    public void insert() throws Exception {
        ordDao.deleteAll();
        OrdDto ordDto = new OrdDto(100012, new Date(), "00주문완료", 1, 1, 30000, 30000);
        assertTrue(ordDao.insert(ordDto)==1);

        ordDto = new OrdDto(100012, new Date(), "00주문완료", 1, 1, 30000, 30000);
        assertTrue(ordDao.insert(ordDto)==1);
        assertTrue(ordDao.count()==2);

        ordDao.deleteAll();
        ordDto = new OrdDto(100012, new Date(), "00주문완료", 1, 1, 30000, 30000);
        assertTrue(ordDao.insert(ordDto)==1);
        assertTrue(ordDao.count()==1);
    }
}