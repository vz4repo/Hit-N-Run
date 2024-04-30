package com.homerunball.cart.service;

import com.homerunball.cart.domain.CartDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CartServiceImplTest {
    @Autowired
    private CartService cartService;

    @Test
    public void insertTestData() throws Exception {
        cartService.removeAll();
        for(int i=0; i<1; i++){
            CartDto cart = new CartDto("U000005", "GLV000021-20", "S", 5,1234, "asdf",1231, 2345);
            cartService.create(cart);
        }
    }
    @Test
    public void getCount() throws Exception{
        cartService.removeAll();
        assertTrue(cartService.getCount()==0);

        CartDto cart = new CartDto("U000005", "GLV000021-20", "S", 2,1234, "asdf",1231, 2345);
        assertTrue(cartService.create(cart)==1);
        assertTrue(cartService.getCount()==1);

        CartDto cart2 = new CartDto("U000005", "GLV000021-21", "XL", 2,1234, "asdf",1231, 2345);
        CartDto cart3 = new CartDto("U000005", "GLV000021-21", "XL", 2,1234, "asdf",1231, 2345);
        CartDto cart4 = new CartDto("U000005", "GLV000021-21", "XL", 2,1234, "asdf",1231, 2345);
        assertTrue(cartService.create(cart2)==1);
        assertTrue(cartService.create(cart3)==1);
        assertTrue(cartService.create(cart4)==1);
        assertTrue(cartService.getCount()==4);
    }

//    @Test
//    public void remove() throws Exception {
//        cartService.removeAll();
//        assertTrue(cartService.getCount()==0);
//
//        CartDto cart = new CartDto("U000005", "GLV000021-20", "S", 2);
//        assertTrue(cartService.create(cart)==1);
//        assertTrue(cartService.getCount()==1);
//
//        String c_id = cartService.readAll().get(0).getC_id();
//        assertTrue(cartService.remove(c_id, cart.getPd_id())==1);
//        assertTrue(cartService.getCount()==0);
//    }

    @Test
    public void removeAll() throws Exception {
    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void read() throws Exception {
    }

    @Test
    public void readAll() throws Exception {
    }
}