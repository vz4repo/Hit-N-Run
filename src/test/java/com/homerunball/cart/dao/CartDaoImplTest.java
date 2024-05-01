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

        CartDto cart = new CartDto("U000005", "GLV000021-20", "RRR", 2);
        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==1);

        assertTrue(cartDao.insert(cart)==1);
        assertTrue(cartDao.count()==2);
    }
    /*
    * ----------------------------------------------------------
    * CUST
    * TDD
    * insert가 됬으면 insert됬으면 데이터가 잘 들어갔는지 꺼내서 확인
    * 필수값을 넣어도, 빠진값이있어도 에러가나는지 확인 (실패 false 한것도 assert 해서 확인)
    * assertTrue로 확인해야한다
    *
    * Dao, Service, Controller : 예외 던지기 throws Exception 빠짐
    * 유효성검사는 js와 server 둘다 체크해준다
    *
    * Controller에서 에러메세지 던지고 뷰단에서 받는걸로 바꿔야함
    *
    * ----------------------------------------------------------
    * Product
    * TDD
    * Delete: 한~두개넣고 지워보고, 왕창넣고 지워보고, 똑같은데이터를 또넣고 지웠을때 결과가 어떻게 나오는지,
    * 내가 원하는게 지워졌는지, 엉뚱한게 지워졌는지 체크
    *
    * Mapper
    * MYSQL 테이블이름은 길게작성, 별명은짧게작성
    * DB를 읽어온다음 변경하기때문에 updateContent 쿼리문 -> if문 안쓰고 set으로 update쳐도 됨
    * searchBiggestSerialNumber 쿼리문 -> max함수사용
    *
    * Controller
    * 예외처리코드넣기
    * productList의 count 안쓰고 size로 사용하기
    * register함수의 requestParam 사용금지
    * DTO getCtg 에서 get + get + get 해서 사용하면된다?
    * img 경로 하드코딩됨: 경로를 따로지정해서 읽어다쓰기
    * img는 외부로 빼고, 기본아이콘은 내부에위치
    *
    * ----------------------------------------------------------
    * Cart
    * Mapper where절 and문 줄바꿔서 ok
    * Service DB에 Dao 함수들을 모아서 Service에 넣는다
    * : 코드를한번 감싸는것뿐 중복이아니다. 변경에 유리하다
    * : 컨트롤러의 코드가 복잡할경우 서비스로 옮기면된다
    *
    * TDD
    * insert후 select진행해서 결과확인
    * 똑같은걸 2개넣었을떄 count는 1개
    * insert 는 여러개 넣어봐야한다 delete는 하나만지워보고 하나지워지는지확인
    * update후 select 해서 확인한다
    * 여러번해서 select 했을경우 다른게올ㄹ수있으니까 같은지 비교해서 확인한다
    *
    * Controller
    * Dao를 쓰지말고 service를 사용한다
    * 에러코드 추가
    * isEmpyty는 view가 처리하게 한다 (catch문에 넣기)
    *
    * ----------------------------------------------------------
    * 결제
    * 주문 작성되있다고 가정하고 Hard코딩하기
    */


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
        assertTrue(cart.equals(cart2.get(0)));
    }

    @Test
    public void selectTest() throws Exception {
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
}