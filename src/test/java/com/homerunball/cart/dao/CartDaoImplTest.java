package com.homerunball.cart.dao;

import com.homerunball.cart.domain.CartDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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

        CartDto cart = new CartDto("U000005", "GLV000021-20", "RRR", 2);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==1);

        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==2);
    }


    /* 한 고객의 장바구니 선택 삭제 */
    @Test
    public void deleteTest() throws Exception{
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

         /*장바구니 User U000005 생성*/
        CartDto cart = new CartDto("U000005", "GLV000021-20", "RRR", 1);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==1);
        /* 장바구니 User U000005를 선택해서 id를 가져온다*/
        String c_id = cartDao.selectAll().get(0).getC_id();
        /* id와 담은제품이 일치할경우 객체삭제 */
        cartDao.delete(c_id, cart.getPd_id(), cart.getPd_clsf_code());
        assertTrue(cartDao.count()==0);

        /* 장바구니 User U000005 생성*/
        assertTrue(cartDao.insert(cart)==1);
        // 장바구니에 userid와 제품id+1를 delete, count 할경우 존재하지 않는 제품id 이기때문에 count는 그대로
        assertTrue(cartDao.delete(c_id, cart.getC_id()+1, cart.getPd_clsf_code())==0);
        assertTrue(cartDao.count()==1);
    }

    /* 모든유저데이터 전체삭제 */
    @Test
    public void deleteAllTest() throws Exception{
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

        CartDto cart = new CartDto("U000005", "GLV000021-20", "RRR",1);
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
    public void cidDeleteAll() throws Exception {
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

        /* cart에 5번고객이 장바구니에 2개를추가, 6번고객이 장바구니에 1개추가 총 count는 3개 */
        CartDto cart = new CartDto("U000005", "GLV000021-21", "RRR",1);
        CartDto cart2 = new CartDto("U000005", "GLV000022-21", "RR",1);
        CartDto cart3 = new CartDto("U000006", "GLV000021-21", "RR",1);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.insert(cart2)==1);
        assertTrue(cartDao.insert(cart3)==1);
        assertTrue(cartDao.count()==3);

        /* 5번고객의 장바구니를 전체삭제 */
        assertTrue(cartDao.cidDeleteAll(cart2.getC_id())==2);
        /* 남은고객은 6번고객 1건 */
        assertTrue(cartDao.count()==1);

        List<CartDto> list = cartDao.selectAll();
        /* cart에 남아있는 list의 개수도 1개 */
        assertTrue(list.size()==1);
    }

    @Test
    public void insertTest() throws Exception {
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

        // 장바구니 User U000005 생성
        CartDto cart = new CartDto("U000005", "GLV000021-20", "RRR",1);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==1);

        // 장바구니 User U000005 생성후 전체삭제
        cart = new CartDto("U000005", "GLV000021-20", "RRR",2);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==2);

        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

        // 장바구니 User U000005 생성
        cart = new CartDto("U000005", "GLV000021-20", "RRR",1);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==1);
    }

    @Test
    public void selectUserTest() throws Exception {
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

        CartDto cart = new CartDto("U000003", "GLV000021-30", "333",2);
        assertTrue(cartDao.insert(cart)==1);

        String c_id = cartDao.selectAll().get(0).getC_id();
        cart.setC_id(c_id);
        List<CartDto> cart2 = cartDao.selectUser(c_id);
        assertTrue(cart.equals(cart2.get(0)));
    }

    @Test
    public void selectAllTest() throws Exception {
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

        List<CartDto> list = cartDao.selectAll();
        assertTrue(list.size()==0);

        CartDto cart = new CartDto("U000003", "GLV000021-30", "333",2);
        assertTrue(cartDao.insert(cart)==1);

        list = cartDao.selectAll();
        assertTrue(list.size()==1);

        assertTrue(cartDao.insert(cart)==1);
        list = cartDao.selectAll();
        assertTrue(list.size()==2);
    }

    @Test
    public void updateTest() throws Exception {
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);


        // 장바구니 User U000003 생성
        CartDto cart = new CartDto("U000003", "GLV000021-30", "333",2);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==1);

        // 고객ID 가져오기
        String c_id = cartDao.selectAll().get(0).getC_id();
        System.out.println(c_id); // U000003

        // 고객ID, 사이즈, 장바구니담은수량 변경
        cart.setPd_clsf_code("XS");
        cart.setCart_cnt(3);
        assertTrue(cartDao.update(cart)==1);
        System.out.println(cart); //CardDto{c_id='U000003', pd_id='HAD000032-12', pd_clsf_code='XS', cart_cnt=3}

        // 장바구니 User U000003 을 선택해서 cart2에 담는다
        List<CartDto> cart2 = cartDao.selectUser(c_id);
        // 동일한 객체인지 확인
        System.out.println(cart);
        System.out.println(cart2);
        assertTrue(cart.equals(cart2));
    }

    @Test
    public void cartCheckTest() throws Exception {
        cartDao.deleteAll();
        assertTrue(cartDao.count()==0);

        CartDto cart = new CartDto("U000005", "GLV000021-21", "S",1);
        CartDto cart2 = new CartDto("U000005", "GLV000021-21", "S",1);
        CartDto cart3 = new CartDto("U000006", "GLV000021-21", "S",1);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.insert(cart2)==1);
        assertTrue(cartDao.insert(cart3)==1);
        assertTrue(cartDao.count()==3);

//        assertTrue(cartDao.cartCheck(cart));
        /* cart 와 cart는 동일고객 */
        assertTrue(cart.equals(cart2));
        /* car2와 cart3는 다른고객 */
        assertFalse(cart2.equals(cart3));
    }
}