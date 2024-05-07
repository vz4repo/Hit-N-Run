//package com.homerunball.order.dao;
//
//import com.homerunball.order.domain.OrderDetDto;
//import com.homerunball.order.domain.OrderStatDto;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.Date;
//
//import static org.junit.Assert.*;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//public class OrderStatDaoImplTest {
//    @Autowired
//    private OrderStatDao orderStatDao;
//    @Autowired
//    private OrdDao ordDao;
//    @Test
//    public void count()throws Exception {
//        orderStatDao.deleteAll();
//        assertTrue(orderStatDao.count()==0);
//
//        String c_id = ordDao.getcid();
//
//        //상태페이지 생성
//        OrderStatDto ord_stat = new OrderStatDto(1,20240503,c_id,"주문완료",new Date(),new Date(),"a",new Date(),"a");
//        assertTrue(orderStatDao.insert(ord_stat) == 1);
//        assertTrue(orderStatDao.count()==1);
//
//        OrderStatDto ord_stat2 = new OrderStatDto(2,20240504,c_id,"주문완료",new Date(),new Date(),"a",new Date(),"a");
//        assertTrue(orderStatDao.insert(ord_stat2) == 1);
//        assertTrue(orderStatDao.count()==2);
//    }
//
//    @Test
//    public void delete() throws Exception{
//        orderStatDao.deleteAll();
//        assertTrue(orderStatDao.count()==0);
//
//        String c_id = ordDao.getcid();
//
//        OrderStatDto ord_stat = new OrderStatDto(1,20240503,c_id,"주문완료",new Date(),new Date(),"a",new Date(),"a");
//        assertTrue(orderStatDao.insert(ord_stat) == 1);
//        assertTrue(orderStatDao.count()==1);
//
//        OrderStatDto ord_stat2 = new OrderStatDto(2,20240504,c_id,"주문완료",new Date(),new Date(),"a",new Date(),"a");
//        assertTrue(orderStatDao.insert(ord_stat2) == 1);
//        assertTrue(orderStatDao.count()==2);
//
//        OrderStatDto ord_stat3 = new OrderStatDto(3,20240505,c_id,"주문완료",new Date(),new Date(),"a",new Date(),"a");
//        assertTrue(orderStatDao.insert(ord_stat3) == 1);
//        assertTrue(orderStatDao.count()==3);
//
//        // 주문 상태 선택삭제
//        assertTrue(orderStatDao.delete(3, 20240505) == 1);
//
//        OrderStatDto ord_stat4 = new OrderStatDto(4,20240506,c_id,"주문완료",new Date(),new Date(),"a",new Date(),"a");
//        assertTrue(orderStatDao.insert(ord_stat4) == 1);
//        assertTrue(orderStatDao.count()==3);
//
//        OrderStatDto ord_stat5 = new OrderStatDto(5,20240507,c_id,"주문완료",new Date(),new Date(),"a",new Date(),"a");
//        assertTrue(orderStatDao.insert(ord_stat5) == 1);
//        assertTrue(orderStatDao.count()==4);
//
//
//    }
//
//    @Test
//    public void insert() throws Exception{
//
//        orderStatDao.deleteAll();
//        assertTrue(orderStatDao.count()==0);
//
//        String c_id = ordDao.getcid();
//
//        OrderStatDto ord_stat = new OrderStatDto(1,20240506,c_id,"주문완료",new Date(),new Date(),"a",new Date(),"a");
//        assertTrue(orderStatDao.insert(ord_stat) == 1);
//
//        //리스트 1개 더 추가
//        OrderStatDto ord_stat2 = new OrderStatDto(2,20240507,c_id,"주문완료",new Date(),new Date(),"a",new Date(),"a");
//        assertTrue(orderStatDao.insert(ord_stat2)==1);
//
//        //2다 모두 삭제
//        orderStatDao.deleteAll();
//        assertTrue(orderStatDao.count()==0);
//
//        for (int i = 1; i <= 10; i++) {
//            int od_stat_seqnum = 3 + i; //
//            int od_id = 20240508 + i; // 20240503에 1부터 10까지의 숫자를 더하여 생성
//
//            OrderStatDto ord_stat3 = new OrderStatDto(od_stat_seqnum, od_id, c_id, "주문완료", new Date(), new Date(), "a", new Date(), "a");
//            assertEquals(1, orderStatDao.insert(ord_stat3)); // 리스트에 OrderStatDto 객체 추가
//        }
//        assertTrue(orderStatDao.count()==10);
//
//        assertEquals(10, orderStatDao.count());
//    }
//}