//package com.homerunball.order.service;
//
//
//import com.homerunball.order.dao.OrdDao;
//import com.homerunball.order.domain.OrdDto;
//import com.homerunball.order.service.OrdService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.sql.Timestamp;
//import java.util.Date;
//
//import static org.junit.Assert.*;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//public class OrdServiceImplTest {
//    @Autowired
//    private OrdService ordService;
//    @Autowired
//    OrdDao ordDao;
//
//
//    /*장바구니 리스트 수를 센다*/
//    @Test
//    public void getcount() throws Exception{
//        ordDao.deleteAll();
//        assertTrue(ordService.getcount()==0);
//
//        String c_id = ordDao.getcid();
//
//        OrdDto ord = new OrdDto(2024050, c_id, new Date(), "1234", 1, 1, 1, new Date(), "legid", new Date(), "lastid");
//        assertTrue(ordService.writer(ord) == 1);
//        assertTrue(ordService.getcount()==1);
//
//        OrdDto ord2 = new OrdDto(2024051, c_id, new Date(), "1234", 1, 1, 1, new Date(), "legid", new Date(), "lastid");
//
//        assertTrue(ordService.writer(ord2) == 1);
//        assertTrue(ordService.getcount()==2);
//    }
//
//
//    /*리스트 작성*/
//    @Test
//    public void writer() throws Exception {
//
//        /* 모두 삭제*/
//        ordDao.deleteAll();
//        assertTrue(ordService.getcount()==0);
//
//        String c_id = ordDao.getcid();
//
//        /*for문으로 100개?? 한번에 넣어보기*/
//        /*이상하게 500개가 들어간다*/
//        for(int i = 0; 1 < 100; i++){
//            OrdDto ord = new OrdDto(2024050 + i, c_id + i, new Date(), "1234", 1 + i, 200 - i, 1 * i, new Timestamp(new Date().getTime()), "asdf", new Timestamp(new Date().getTime()), "asdf");
//            ordService.writer(ord);
//            /*assertTrue(ordService.writer(ord) == 100);*/
//        }
//
//
//    }
//
//
//    /*데이터를 가져온다*/
//    @Test
//    public void read() throws Exception {
//
//        ordDao.deleteAll();
//        assertTrue(ordService.getcount()==0);
//        // 데이터 초기화
//        String c_id = ordDao.getcid();
//
//        /*1번 데이터 입력*/
//        OrdDto ord = new OrdDto(202405, c_id, new Date(), "1234", 1, 1, 1,"23e23","grgr");
//        assertTrue(ordService.writer(ord) == 1);
//
//        /*2번 데이터 입력*/
////        OrdDto ord2 = new OrdDto(2024051, c_id, new Date(), "g6", 2, 2, 2, "fsds", "sdfs");
////        assertTrue(ordService.writer(ord2) == 1);
////
////        /*중복이니까 실패*/
////        assertFalse(ord.equals(ord2)); /*삽입은 실패해야 함*/
////
////        /*2번 데이터 조회*/
////        OrdDto ord2rs = ordService.read(ord2.getOd_id(), ord2.getC_id());
////        assertNotNull(ord2rs);
////
////        /*수정*/
////        ord2rs.setOd_stat_cd("modify");
////
////        /*수정된 데이터 업데이트*/
////        assertTrue(ordService.modify(ord2rs) == 1);
////
////        /*수정된 데이터 확인*/
////        OrdDto modifydOrd = ordService.read(ord2rs.getOd_id(), ord2rs.getC_id());
////        assertEquals("modify", modifydOrd.getOd_stat_cd());
//    }
//
//    /*데이터를 삭제한다*/
//    @Test
//    public void remove() throws Exception {
//        ordDao.deleteAll();
//
//        String c_id = ordDao.getcid();
//
//        OrdDto ordDto = new OrdDto(2024053, c_id, new Date(), "1234", 1, 1, 1, "23e23", "grgr");
//        assertTrue(ordService.writer(ordDto) == 1);
////        String od_id = ordDao.selectAll().get(0).getOd_id();
////        System.out.println("od_id = " + od_id);
//
//        ordDao.deleteAll();
//        OrdDto ordDto1 = new OrdDto(2024056, c_id, new Date(), "1234", 1, 1, 1, "23e23", "grgr");
//
//    }
//
//
//}