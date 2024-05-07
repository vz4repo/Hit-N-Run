package com.homerunball.order.dao;

import com.homerunball.customer.dao.CustDao;
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

        String c_id = ordDao.getcid();
        System.out.println(c_id);

        OrdDto orddet = new OrdDto(2024050, c_id, new Date(), "1234", 1, 1, 1, new Date(), "legid", new Date(), "lastid");
        assertTrue(ordDao.insert(orddet) == 1);
        assertTrue(ordDao.count()==1);

        OrdDto ord2 = new OrdDto(2024051, c_id, new Date(), "1234", 1, 1, 1, new Date(), "legid", new Date(), "lastid");

        assertTrue(ordDao.insert(ord2) == 1);
        assertTrue(ordDao.count()==2);

        System.out.println(ord2);

    }

    @Test
    public void deleteAll() throws Exception {
        ordDao.deleteAll();
        assertTrue(ordDao.count()==0);

        String c_id = ordDao.getcid();

        OrdDto ordDto = new OrdDto(2024051, c_id, new Date(), "1234", 1, 1, 1, new Date(), "legid", new Date(), "lastid");
        assertTrue(ordDao.insert(ordDto)==1);
        assertTrue(ordDao.deleteAll()==1);
        assertTrue(ordDao.count()==0);

        ordDto = new OrdDto(2024051, c_id, new Date(), "1234", 1, 1, 1, new Date(), "legid", new Date(), "lastid");
        assertTrue(ordDao.insert(ordDto)==1);
        ordDto = new OrdDto(2024052, c_id, new Date(), "1234", 1, 1, 1, new Date(), "legid", new Date(), "lastid");
        assertTrue(ordDao.insert(ordDto)==1);
        assertTrue(ordDao.deleteAll()==2);
        assertTrue(ordDao.count()==0);
    }

    @Test
    public void select() throws Exception {
        /* 데이터 초기화*/
        ordDao.deleteAll();
        assertTrue(ordDao.count()==0);
        String c_id = ordDao.getcid();

        OrdDto ord = new OrdDto(2024054, c_id, new Date(), "1234", 1, 1, 1,"23e23","grgr");
        assertTrue(ordDao.insert(ord) == 1);



        /*2번 데이터*/
        OrdDto ord2 = new OrdDto(2024058, c_id, new Date(), "g6", 2, 2, 2, "fsds", "sdfs");
        assertTrue(ordDao.insert(ord2) == 1);

        /*중복이니까 실패?*/
        assertFalse(ord.equals(ord2));

        /*2번 데이터 조회*/
        List<OrdDto> ord2rs = ordDao.selectOdId(ord2.getOd_id());
        assertNotNull(ord2rs);

        /*수정*/
//        ord2rs.setOd_stat_cd("update");
//
//        /*수정된 데이터 업데이트*/
//        assertTrue(ordDao.update(ord2rs) == 1);
//
//        /*수정된 데이터 확인*/
//        OrdDto updatedOrd = ordDao.select(ord2rs.getOd_id(), ord2.getC_id());
//        assertEquals("update", updatedOrd.getOd_stat_cd());

        /*다시 조회*/
        Integer od_id = ordDao.selectAll().get(0).getOd_id();
        System.out.println("군고구마멍멍이"+ordDao.selectAll().get(0).getOd_id());


        ord.setOd_id(od_id);
    }

    @Test
    public void selectAll() throws Exception {
        ordDao.deleteAll();
        assertTrue(ordDao.count()==0);

        String c_id = ordDao.getcid();

        List<OrdDto> list = ordDao.selectAll();
        assertTrue(list.size() == 0);

        OrdDto ordDto = new OrdDto(2024053, c_id, new Date(), "g6", 2, 2, 2, "fsds", "sdfs");
        assertTrue(ordDao.insert(ordDto)==1);

        list = ordDao.selectAll();
        assertTrue(list.size() == 1);

        OrdDto ordDto2 = new OrdDto(2024055, c_id, new Date(), "g6", 2, 2, 2, "fsds", "sdfs");
        assertTrue(ordDao.insert(ordDto2)==1);
        list = ordDao.selectAll();
        assertTrue(list.size()==2);
    }

    @Test
    public void insert() throws Exception {
        ordDao.deleteAll();
        String c_id = ordDao.getcid();

        OrdDto ordDto = new OrdDto(2024053, c_id, new Date(), "g6", 2, 2, 2,"fsds", "sdfs");
        assertTrue(ordDao.insert(ordDto)==1);

        ordDto = new OrdDto(2024052, c_id, new Date(), "g6", 2, 2, 2,"fsds", "sdfs");
        assertTrue(ordDao.insert(ordDto)==1);
        assertTrue(ordDao.count()==2);

        ordDao.deleteAll();
        ordDto = new OrdDto(2024055, c_id, new Date(), "g6", 2, 2, 2,"fsds", "sdfs");
        assertTrue(ordDao.insert(ordDto)==1);
        assertTrue(ordDao.count()==1);
    }
}