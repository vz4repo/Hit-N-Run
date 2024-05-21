package com.homerunball.order.dao;

import com.homerunball.order.domain.OrderDetDto;
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
//
//    @Test
//    public void count() throws Exception{
//        orderdetDao.deleteAll();
//        assertTrue(orderdetDao.count()==0);
//
//
//        //상세페이지 생성
//        OrderDetDto ord_det = new OrderDetDto(20240117-000001, 2024050, "GLV000001-80","XS", new Date(),"XANDER BOGAERTS",940000,2,"asdf",new Date(),"a",new Date(),"a");
//        assertTrue(orderdetDao.insert(ord_det)==1);
//        assertTrue(orderdetDao.count()==1);
//
//        //다른 객체 생성
//        OrderDetDto ord_det2 = new OrderDetDto(20240117-000002, 2024051, "GLV000001-80","XS", new Date(),"XANDER BOGAERTS",940000,2,"asdf",new Date(),"a",new Date(),"a");
//        assertTrue(orderdetDao.insert(ord_det2)==1);
//        //ord_det랑 ord_det2랑 비교
//        assertFalse(ord_det.equals(ord_det2));
//
////        assertTrue(orderdetDao.insert(ord_det2)==1);  //같은 키 실패
//    }
//
//    @Test
//    public void delete() throws Exception{
//        orderdetDao.deleteAll();
//        assertTrue(orderdetDao.count()==0);
//
//        OrderDetDto ord_det = new OrderDetDto(20240117-000002, 2024051, "GLV000001-80","XS", new Date(),"XANDER BOGAERTS",940000,2,"asdf",new Date(),"a",new Date(),"a");
//        assertTrue(orderdetDao.insert(ord_det)==1);
//        assertTrue(orderdetDao.count()==1);
//
//        //상세페이지 od_det_seqnum를 선택해서 id를 가져온다
//        Integer od_det_seqnum = orderdetDao.selectAll().get(0).getOd_det_seqnum();
//        //id와 상세리스트가 일치할경우 삭제
//        orderdetDao.delete(od_det_seqnum, ord_det.getOd_id(), ord_det.getPd_id(), ord_det.getPd_clsf_cd() );
//        assertTrue(orderdetDao.count()==0);
//
//        //상세리스트 생성
//        assertTrue(orderdetDao.insert(ord_det)==1);
//        // 상세에 od_det_seqnum와 od_id+1를 delete, count 할경우 존재하지 않는 제품id 이기때문에 count는 그대로
//        assertTrue( orderdetDao.delete(od_det_seqnum, ord_det.getOd_id()+1, ord_det.getPd_id(), ord_det.getPd_clsf_cd())==0);
//        assertTrue(orderdetDao.count()==1);
//
//
//    }
//
//    @Test
//    public void select() throws Exception {
//        orderdetDao.deleteAll();
//        assertTrue(orderdetDao.count()==0);
//
//        //상세리스트 1개추가
//        OrderDetDto ord_det = new OrderDetDto(20240117-000001, 2024051, "GLV000001-80","XS", new Date(),"XANDER BOGAERTS",940000,2,"asdf",new Date(),"a",new Date(),"a");
//        assertTrue(orderdetDao.insert(ord_det)==1);
//        assertTrue(orderdetDao.count()==1);
//
//        //상세리스트 1개 더 추가
//        OrderDetDto ord_det2 = new OrderDetDto(20240117-000002, 2024052, "GLV000001-81","S", new Date(),"XANDER BOGAERTS",940000,2,"asdf",new Date(),"a",new Date(),"a");
//        assertTrue(orderdetDao.insert(ord_det2)==1);
//
//        //상세리스트 1개 더 추가
//        OrderDetDto ord_det3 = new OrderDetDto(20240117-000003, 2024053, "GLV000001-82","l", new Date(),"XANDER BOGAERTS",940000,2,"asdf",new Date(),"a",new Date(),"a");
//        assertTrue(orderdetDao.insert(ord_det3)==1);
//
//        //ord_det,ord_det2,ord_det3개를 비교 / 셋다 달라서 false
//        assertFalse(ord_det.equals(ord_det2));
//        assertFalse(ord_det.equals(ord_det3));
//        assertFalse(ord_det2.equals(ord_det3));
//
//    }
//
    @Test
    public void insert() throws Exception {
        orderdetDao.deleteAll();
        assertTrue(orderdetDao.count()==0);

        //리스트 1개 추가
        OrderDetDto ord_det = new OrderDetDto(100003, "pd_aa","aaa", new Date(), "pd_name", 1000, 2, "aaa","","",  new Date(), "testuser", new Date(), "testuser");
        assertTrue(orderdetDao.insert(ord_det)==1);
        assertTrue(orderdetDao.count()==1);

        //리스트 1개 더 추가
        OrderDetDto ord_det2 = new OrderDetDto(100003, "pd_aa","aaa", new Date(), "pd_name", 1000, 2, "aaa","", "", new Date(), "testuser", new Date(), "testuser");
        assertTrue(orderdetDao.insert(ord_det)==1);
        assertTrue(orderdetDao.insert(ord_det2)==1);

        //2다 모두 삭제
        orderdetDao.deleteAll();
        assertTrue(orderdetDao.count()==0);

        for (int i = 1; i <= 10; i++) {
            int od_det_seqnum = 20240117 * 1000000 + i; // '20240117'와 '000001'을 결합하여 숫자로 표현합니다.
            int od_id = 2024050 + i; // 2024050에 1부터 10까지의 숫자를 더하여 생성

            OrderDetDto ord_det3 = new OrderDetDto(100003, "pd_aa","aaa", new Date(), "pd_name", 1000, 2, "aaa","",  "",new Date(), "testuser", new Date(), "testuser");
            assertEquals(1, orderdetDao.insert(ord_det3)); // 리스트에 OrderDetDto 객체 추가
        }
        assertTrue(orderdetDao.count()==10);

        assertEquals(10, orderdetDao.count());

    }
//
//    @Test
//    public void update() throws Exception {
//
//        orderdetDao.deleteAll();
//        assertTrue(orderdetDao.count()==0);
//
//        OrderDetDto ord_det = new OrderDetDto(20240117-000001, 2024051, "GLV000001-80","XS", new Date(),"XANDER BOGAERTS",940000,2,"asdf",new Date(),"a",new Date(),"a");
//        assertTrue(orderdetDao.insert(ord_det)==1);
//        assertTrue(orderdetDao.count()==1);
//
//        OrderDetDto ord_det2 = new OrderDetDto(20240117-000002, 2024052, "GLV000001-80","XS", new Date(),"XANDER BOGAERTS",940000,2,"asdf",new Date(),"a",new Date(),"a");
//        assertTrue(orderdetDao.insert(ord_det2)==1);
//
//        ord_det.setDlvry_stat_cd("fdsa");
//        assertTrue(orderdetDao.update(ord_det)==1);
//
//        ord_det2.setDlvry_stat_cd("qwer");
//        assertTrue(orderdetDao.update(ord_det2)==1);
//
//        System.out.println(ord_det2);
//
//    }
}