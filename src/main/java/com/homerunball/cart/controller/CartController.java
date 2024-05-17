package com.homerunball.cart.controller;

import com.homerunball.admin.product.domain.ProductDto;
import com.homerunball.cart.dao.CartDao;
import com.homerunball.cart.domain.CartDto;
import com.homerunball.product.customer.domain.StockViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartDao cartDao;
    /*
    1. checked일때 전체 check -ok
    2. 이미지 출력
    2-1. 상품명 출력
    2-2. 옵션 출력
    2-3. 사이즈출력 -ok
    2-4. 판매가출력
    2-5. 수량출력 및 변경 -ok
    3. 판매가 * 수량 = 합계
    4. 삭제 버튼 만들기 -ok
    */

    /* pd_clsf_code 사이즈 , cart_cnt 제품개수 옵션변경할경우 update */
    @PostMapping("/update")
    public String update(CartDto cartDto, int c_id, String pd_clsf_code, Integer cart_cnt, Model m) {
        try {
            /* 제품 Count 변경한다 */
            cartDto.setCart_cnt(cart_cnt);
            /* update 실행 */
            System.out.println("cartDto: "+cartDto);
            cartDao.update(cartDto);
            m.addAttribute("c_id", c_id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/cart/list";
    }

    @PostMapping("/selectRemove")
    public String selectRemove(CartDto cartDto, int c_id, Model m){
        try {
//            cartDao.delete(cartDto.getC_id())
        } catch (Exception e){

        }
        return "redirect:/cart/list";
    }


    /* 고객 한명의 장바구니 전체삭제 */
    @PostMapping("/removeAll")
    public String removeAll(int c_id, Model m,HttpServletRequest request){
        try{
            /* c_id 고객번호를 매개변수로 받아와서 장바구니 전체 삭제한다 */
            cartDao.cidDeleteAll(c_id);
            m.addAttribute("c_id", c_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/cart/list";
    }

    /*고객장바구니 선택삭제*/
    @PostMapping("/remove")
    public String remove(int c_id, String pd_id, String pd_clsf_code, HttpServletRequest request){
        try {
            /*고객의 장바구니를 삭제 (고객ID, 제품번호, 사이즈) 를 매개변수로 받아온다*/
            int rowcnt = cartDao.delete(c_id, pd_id, pd_clsf_code);

            /* 1이 아닐경우 throw */
            if(rowcnt !=1)
                throw new Exception("Cart remove err");
        } catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/cart/list?c_id="+c_id;
    }


    @PostMapping("/insert")
    public String insert(CartDto cartDto, String mn_img_fn, String pd_id, String pd_clsf_cd, Model m, HttpSession session) {
        int c_id = 0;
        try {
            /* 로그인한 고객의 email이 세션에있는지 확인한다 */
            c_id = (int) session.getAttribute("c_id");

            cartDto.setC_id(c_id);
            cartDto.setPd_id(pd_id);
            cartDto.setPd_clsf_code(pd_clsf_cd);
            cartDto.setMn_img_fn(mn_img_fn);

            boolean exists = cartDao.exists(cartDto);

            if (exists) {
                CartDto dao = cartDao.selectCart(c_id, pd_id, pd_clsf_cd);
                int currentCart = dao.getCart_cnt();
                cartDto.setCart_cnt(currentCart+1);
                cartDao.update(cartDto);
            } else {
                cartDao.insert(cartDto);
            }

            m.addAttribute("cartDto", cartDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/cart/list?c_id=" + c_id;
    }

    /*고객 장바구니 load*/
    @GetMapping("/list")
    public String cartForm(Model m, HttpSession session){

        try {
            /* 로그인한 고객의 c_id가 세션에있는지 확인한다 */
            int c_id = (int)session.getAttribute("c_id");

            /* cart에있는 c_id를가진 고객의 장바구니를 list에 담는다 */
            List<CartDto> list = cartDao.getStk(c_id);

//            List<ProductDto> prdImg = cartDao.getProductImg()
            System.out.println("stklist=========="+list);


            /* Cart가 null 일경우 장바구니에 담긴 상품이 없다고 뷰애서 출력 */
            if(list.isEmpty()) {
                throw new Exception();
            }
            m.addAttribute("list", list);
            m.addAttribute("c_id", c_id);
        } catch (Exception e){
            e.printStackTrace();
            m.addAttribute("msg", "CART_EMPTY");
        }
        return "cart";
    }
}