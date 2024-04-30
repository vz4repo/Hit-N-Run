package com.homerunball.cart.controller;

import com.homerunball.cart.dao.CartDao;
import com.homerunball.cart.domain.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartDao cartDao;
    /*
    1. checked일때 전체 check
    2. 이미지 출력
    2-1. 상품명 출력
    2-2. 옵션 출력
    2-3. 사이즈출력
    2-4. 판매가출력
    2-5. 수량출력 및 변경
    3. 판매가 * 수량 = 합계
    4. 삭제 버튼 만들기
    */

    @PostMapping("/update")
    public String update(String pd_clsf_code, String c_id, int cart_cnt, CartDto cartDto, Model m) {
        try {
            cartDto.setPd_clsf_code(pd_clsf_code);
            cartDto.setCart_cnt(cart_cnt);
            cartDao.update(cartDto);
            System.out.println(cartDto);

            m.addAttribute("c_id", c_id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/cart/list";
    }


    /* 고객 한명의 장바구니 전체삭제 */
    @PostMapping("/removeAll")
    public String removeAll(String c_id, Model m,HttpServletRequest request){
        try{
            cartDao.cidDeleteAll(c_id);
            m.addAttribute("c_id", c_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/cart/list";
    }

    /*고객장바구니 선택삭제*/
    @PostMapping("/remove")
    public String remove(String c_id, String pd_id, String pd_clsf_code, HttpServletRequest request){

        try {
            // 고객의 장바구니를 삭제 (고객ID, 제품번호, 사이즈) 를 매개변수로 받아온다
            int rowcnt = cartDao.delete(c_id, pd_id, pd_clsf_code);

            // 1이 아닐경우 throw
            if(rowcnt !=1)
                throw new Exception("Cart remove err");
        } catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/cart/list?c_id="+c_id;
    }


    /*고객 장바구니 load*/
    @GetMapping("/list")
    public String cartForm(String c_id, Model m, HttpSession session){
        try {
            /*로그인한 고객이 세션에있는지 확인한다*/
            String loginId = (String)session.getAttribute(c_id);

            List<CartDto> list = cartDao.selectUser(c_id);

            /*Cart가 null 일경우 장바구니에 담긴 상품이 없다고 뷰애서 출력*/
            if(list.isEmpty()) {
                m.addAttribute("cartEmpty", "CART_EMPTY");
            }
            m.addAttribute("list", list);
            m.addAttribute("c_id", c_id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "cart";
    }

    private boolean loginChecked(HttpServletRequest request){
        HttpSession session = request.getSession();
        return session.getAttribute("userId") != null;
    }
}