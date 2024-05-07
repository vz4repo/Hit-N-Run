//package com.homerunball.cart.service;
//
//import com.homerunball.cart.dao.CartDao;
//import com.homerunball.cart.domain.CartDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CartServiceImpl implements CartService {
//    @Autowired
//    private CartDao cartDao;
//
//    @Override
//    public int getCount() throws Exception {
//        return cartDao.count();
//    }
//
//    @Override
//    public int remove(String c_id, String pd_id, String pd_clsf_code) throws Exception {
//        return cartDao.delete(c_id, pd_id, pd_clsf_code);
//    }
//
//    @Override
//    public int removeAll() throws Exception {
//        return cartDao.deleteAll();
//    }
//
//    @Override // 장바구니에있는 상품을 중복으로 추가하는것을 방지
//    public int create(CartDto cart) throws Exception {
//
//        return cartDao.insert(cart);
//    }
//
//    @Override
//    public int update(CartDto cart) throws Exception {
//        return cartDao.update(cart);
//    }
//
////    @Override
////    public CartDto read(String c_id) throws Exception {
////        return cartDao.select(c_id);
////    }
//
//    @Override
//    public List<CartDto> readAll() throws Exception {
//        return cartDao.selectAll();
//    }
//
//}