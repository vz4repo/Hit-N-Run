package com.homerunball.ord.dao;

import com.homerunball.ord.domain.OrdDto;
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

        OrdDto ord = new OrdDto("aaa1", "123", new Date(), "1234", 1, 1, 1, new Date(), "legid", new Date(), "lastid");
        assertTrue(ordDao.insert(ord) == 1);
        assertTrue(ordDao.count()==1);

        OrdDto ord2 = new OrdDto("aaa1", "111", new Date(), "1234", 1, 1, 1, new Date(), "legid", new Date(), "lastid");

        assertTrue(ordDao.insert(ord2) == 1);
        assertTrue(ordDao.count()==2);

    }

    @Test
    public void deleteAll() throws Exception {
        ordDao.deleteAll();
        assertTrue(ordDao.count()==0);

        OrdDto ordDto = new OrdDto("fff1", "111", new Date(), "1234", 1, 1, 1, new Date(), "legid", new Date(), "lastid");
        assertTrue(ordDao.insert(ordDto)==1);
        assertTrue(ordDao.deleteAll()==1);
        assertTrue(ordDao.count()==0);

        ordDto = new OrdDto("fff2", "111", new Date(), "1234", 1, 1, 1, new Date(), "legid", new Date(), "lastid");
        assertTrue(ordDao.insert(ordDto)==1);
        ordDto = new OrdDto("fff4", "111", new Date(), "1234", 1, 1, 1, new Date(), "legid", new Date(), "lastid");
        assertTrue(ordDao.insert(ordDto)==1);
        assertTrue(ordDao.deleteAll()==2);
        assertTrue(ordDao.count()==0);
    }

    @Test
    public void select() throws Exception {
        /* 데이터 초기화*/
        ordDao.deleteAll();
        assertTrue(ordDao.count()==0);


        OrdDto ord = new OrdDto("aaa1", "123", new Date(), "1234", 1, 1, 1,"23e23","grgr");
        assertTrue(ordDao.insert(ord) == 1);



        /*2번 데이터*/
        OrdDto ord2 = new OrdDto("bbb2", "456", new Date(), "g6", 2, 2, 2, "fsds", "sdfs");
        assertTrue(ordDao.insert(ord2) == 1);

        /*중복이니까 실패?*/
        assertFalse(ord.equals(ord2));

        /*2번 데이터 조회*/
        OrdDto ord2rs = ordDao.select(ord2.getOd_id(), ord2.getC_id());
        assertNotNull(ord2rs);

        /*수정*/
        ord2rs.setOd_stat_cd("update");

        /*수정된 데이터 업데이트*/
        assertTrue(ordDao.update(ord2rs) == 1);

        /*수정된 데이터 확인*/
        OrdDto updatedOrd = ordDao.select(ord2rs.getOd_id(), ord2.getC_id());
        assertEquals("update", updatedOrd.getOd_stat_cd());

        /*다시 조회*/
        String od_id = ordDao.selectAll().get(0).getOd_id();
        System.out.println("군고구마멍멍이"+ordDao.selectAll().get(0).getOd_id());


        ord.setOd_id(od_id);

        /*od_id랑 od_id2 비교*/
        OrdDto ord3 = ordDao.select(od_id, ord2.getC_id());
        System.out.println("ord = " + ord);
        System.out.println("ord2 = " + ord2);
        assertTrue(ord != ord2);
    }

    @Test
    public void selectAll() throws Exception {
        ordDao.deleteAll();
        assertTrue(ordDao.count()==0);

        List<OrdDto> list = ordDao.selectAll();
        assertTrue(list.size() == 0);

        OrdDto ordDto = new OrdDto("ccc1", "456", new Date(), "g6", 2, 2, 2, "fsds", "sdfs");
        assertTrue(ordDao.insert(ordDto)==1);

        list = ordDao.selectAll();
        assertTrue(list.size() == 1);

        OrdDto ordDto2 = new OrdDto("ddd2", "456", new Date(), "g6", 2, 2, 2, "fsds", "sdfs");
        assertTrue(ordDao.insert(ordDto2)==1);
        list = ordDao.selectAll();
        assertTrue(list.size()==2);
    }

    @Test
    public void insert() throws Exception {
        ordDao.deleteAll();
        OrdDto ordDto = new OrdDto("ddd1", "456", new Date(), "g6", 2, 2, 2,"fsds", "sdfs");
        assertTrue(ordDao.insert(ordDto)==1);

        ordDto = new OrdDto("ddd3", "456", new Date(), "g6", 2, 2, 2,"fsds", "sdfs");
        assertTrue(ordDao.insert(ordDto)==1);
        assertTrue(ordDao.count()==2);

        ordDao.deleteAll();
        ordDto = new OrdDto("ddd4", "456", new Date(), "g6", 2, 2, 2,"fsds", "sdfs");
        assertTrue(ordDao.insert(ordDto)==1);
        assertTrue(ordDao.count()==1);
    }
}