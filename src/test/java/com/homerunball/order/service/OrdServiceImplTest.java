package com.homerunball.order.service;

import com.homerunball.order.dao.OrdDao;
import com.homerunball.order.domain.OrdDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrdServiceImplTest {
//    @Autowired
//    private OrdService ordService;
//    @Autowired
//    OrdDao ordDao;
//
//    @Test
//    public void getcount() throws Exception{
//        ordDao.deleteAll();
//        assertTrue(ordService.getcount()==0);
//
//        OrdDto ord = new OrdDto("123", new Date(), "1234", 1, 1, 1, new Date(), "legid", new Date(), "lastid");
//        assertTrue(ordService.writer(ord) == 1);
//        assertTrue(ordService.getcount()==1);
//
//        OrdDto ord2 = new OrdDto("111", new Date(), "1234", 1, 1, 1, new Date(), "legid", new Date(), "lastid");
//
//        assertTrue(ordService.writer(ord2) == 1);
//        assertTrue(ordService.getcount()==2);
//    }
//
//
//    @Test
//    public void writer() throws Exception {
//
//        for(int i = 0; 1 < 100; i++){
//            String od_id = "aaa2" + i;
//            String c_id = "123" + i;
//            Date od_dt = new Date();
//            String od_stat_cd = "1234";
//            Integer od_pd_qty = 1 + i;
//            Integer od_tot_qty = 200 - i;
//            Integer od_pay_amt = 1 * i;
//            Timestamp frst_reg_dt = new Timestamp(new Date().getTime());
//            String frst_reg_id = "asdf";
//            Timestamp last_mod_dt = new Timestamp(new Date().getTime());
//            String last_mod_id = "asdf";
//
//            OrdDto ord = new OrdDto(c_id, od_dt, od_stat_cd, od_pd_qty, od_tot_qty, od_pay_amt, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id);
//            assertTrue(ordService.writer(ord) == 1);
//        }
//
//    }
//
//
//    @Test
//    public void read() throws Exception {
//
//        ordDao.deleteAll();
//        assertTrue(ordService.getcount()==0);
//        // 데이터 초기화
//
//        OrdDto ord = new OrdDto("aaa1", "123", new Date(), "1234", 1, 1, 1,"23e23","grgr");
//        assertTrue(ordService.writer(ord) == 1);
//
//        /*2번 데이터*/
//        OrdDto ord2 = new OrdDto("bbb2", "456", new Date(), "g6", 2, 2, 2, "fsds", "sdfs");
//        assertTrue(ordService.writer(ord2) == 1);
//
//        /*중복이니까 실패*/
//        assertFalse(ord.equals(ord2)); /*삽입은 실패해야 함*/
//
//        /*2번 데이터 조회*/
//        OrdDto ord2rs = ordService.read(ord2.getOd_id(), ord2.getC_id());
//        assertNotNull(ord2rs);
//
//        /*수정*/
//        ord2rs.setOd_stat_cd("modify");
//
//        /*수정된 데이터 업데이트*/
//        assertTrue(ordService.modify(ord2rs) == 1);
//
//        /*수정된 데이터 확인*/
//        OrdDto modifydOrd = ordService.read(ord2rs.getOd_id(), ord2rs.getC_id());
//        assertEquals("modify", modifydOrd.getOd_stat_cd());
//    }
//
//    @Test
//    public void remove() throws Exception {
//        ordDao.deleteAll();
//
//        OrdDto ordDto = new OrdDto("qwer123", "123", new Date(), "1234", 1, 1, 1, "23e23", "grgr");
//        assertTrue(ordService.writer(ordDto) == 1);
//        String od_id = ordDao.selectAll().get(0).getOd_id();
//        System.out.println("od_id = " + od_id);
//
//        ordDao.deleteAll();
//        OrdDto ordDto1 = new OrdDto("qwer1234", "123", new Date(), "1234", 1, 1, 1, "23e23", "grgr");
//
//    }


}