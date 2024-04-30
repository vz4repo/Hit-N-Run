package com.homerunball.cart.dao;

import com.homerunball.cart.domain.CartDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CartDaoImplTest {
    @Autowired
    private CartDao cartDao;

    @Test
    public void countTest() throws Exception{
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

        CartDto cart = new CartDto("U000005", "GLV000021-20", "RRR", 2, 1234, "asdf",1231, 2345);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==1);

        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==2);

    }


    @Test
    public void deleteTest() throws Exception{
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

        // 장바구니 User U000005 생성
        CartDto cart = new CartDto("U000005", "GLV000021-20", "RRR", 1,1234, "asdf",1231, 2345);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==1);
//
//        // 장바구니 User U000005를 선택해서 id를 가져온다
//        String c_id = cartDao.selectAll().get(0).getC_id();
//        // id와 담은제품이 일치할경우 객체삭제
//        cartDao.delete(c_id, cart.getPd_id());
//        assertTrue(cartDao.count()==0);
//
//        // 장바구니 User U000005 생성
//        assertTrue(cartDao.insert(cart)==1);
//        // 장바구니에 userid와 제품id+1를 delete, count 할경우 존재하지 않는 제품id 이기때문에 count는 그대로
//        assertTrue(cartDao.delete(c_id, cart.getC_id()+1)==0);
//        assertTrue(cartDao.count()==1);
    }

    @Test
    public void deleteAllTest() throws Exception{
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

        CartDto cart = new CartDto("U000005", "GLV000021-20", "RRR",1, 1234, "asdf",1231, 2345);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.deleteAll()==1);
        assertTrue(cartDao.count()==0);


        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==2);
        assertTrue(cartDao.deleteAll()==2);
        assertTrue(cartDao.count()==0);
    }

    @Test
    public void insertTest() throws Exception {
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

        // 장바구니 User U000005 생성
        CartDto cart = new CartDto("U000005", "GLV000021-20", "RRR",1,1234, "asdf",1231, 2345);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==1);

        // 장바구니 User U000005 생성후 전체삭제
        cart = new CartDto("U000005", "GLV000021-20", "RRR",2,1234, "asdf",1231, 2345);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==2);

        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

        // 장바구니 User U000005 생성
        cart = new CartDto("U000005", "GLV000021-20", "RRR",1,1234, "asdf",1231, 2345);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==1);
    }

    @Test
    public void updateTest() throws Exception {
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);


        // 장바구니 User U000003 생성
        CartDto cart = new CartDto("U000003", "GLV000021-30", "333",2,1234, "asdf",1231, 2345);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==1);

        // 고객ID 가져오기
        String c_id = cartDao.selectAll().get(0).getC_id();
        System.out.println(c_id); // U000003

        // 고객ID, 사이즈, 장바구니담은수량 변경
        cart.setPd_id("HAD000032-12");
        cart.setPd_clsf_code("XS");
        cart.setCart_cnt(3);
        assertTrue(cartDao.update(c_id)==1);
        System.out.println(cart); //CardDto{c_id='U000003', pd_id='HAD000032-12', pd_clsf_code='XS', cart_cnt=3}

        // 장바구니 User U000003 을 선택해서 cart2에 담는다
        CartDto cart2 = cartDao.select(c_id);
        // 동일한 객체인지 확인
        assertTrue(cart.equals(cart2));
    }

    @Test
    public void selectTest() throws Exception {
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

        CartDto cart = new CartDto("U000003", "GLV000021-30", "333",2,1234, "asdf",1231, 2345);
        assertTrue(cartDao.insert(cart)==1);

        String c_id = cartDao.selectAll().get(0).getC_id();
        cart.setC_id(c_id);
        CartDto cart2 = cartDao.select(c_id);
        assertTrue(cart.equals(cart2));
    }

    @Test
    public void selectAllTest() throws Exception {
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

        List<CartDto> list = cartDao.selectAll();
        assertTrue(list.size()==0);

        CartDto cart = new CartDto("U000003", "GLV000021-30", "333",2,1234, "asdf",1231, 2345);
        assertTrue(cartDao.insert(cart)==1);

        list = cartDao.selectAll();
        assertTrue(list.size()==1);

        assertTrue(cartDao.insert(cart)==1);
        list = cartDao.selectAll();
        assertTrue(list.size()==2);
    }
}