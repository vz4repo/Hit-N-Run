package com.homerunball.cart.controller;

import com.homerunball.cart.dao.CartDao;
import com.homerunball.cart.domain.CartDto;
import com.homerunball.customer.domain.CustDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    2-3. 사이즈출력 -ok
    2-4. 판매가출력
    2-5. 수량출력 및 변경 -ok
    3. 판매가 * 수량 = 합계
    4. 삭제 버튼 만들기 -ok
    */

    
    // 덜구현됨, 버튼만들고 연결시켜야함
    @PostMapping("/insert")
    public String insert(CartDto cartDto, String pd_id, String pd_clsf_code, Integer cart_cnt, Model m, HttpSession session){
        try{
            /* 로그인한 고객의 email이 세션에있는지 확인한다 */
            String c_id = (String)session.getAttribute("c_id"); // ccc@ccc.com
//            String c_id = cartDao.customerGetCid(cid);
            cartDto.setC_id(c_id);
            cartDto.setPd_id("update");
            cartDto.setPd_clsf_code("SSS");
            cartDto.setCart_cnt(2);

//            CartDto cartCheck = cartDao.cartCheck(cart);
//            System.out.println(cartCheck);

            int rowcnt = cartDao.insert(cartDto);

            m.addAttribute("c_id",c_id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/cart/list";
    }

    /* pd_clsf_code 사이즈 , cart_cnt 제품개수 옵션변경할경우 update */
    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<String> update(@RequestBody CartDto cartDto) {
        try {
//            /* 사이즈 변경한다 */
//            cartDto.setPd_clsf_code(pd_clsf_code);
//            /* 제품 Count 변경한다 */
//            cartDto.setCart_cnt(cart_cnt);
            /* update 실행 */
            cartDao.update(cartDto);

//            m.addAttribute("c_id", c_id);
            return ResponseEntity.ok("Success");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
        }
    }


    /* 고객 한명의 장바구니 전체삭제 */
    @PostMapping("/removeAll")
    public String removeAll(String c_id, Model m,HttpServletRequest request){
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
    public String remove(String c_id, String pd_id, String pd_clsf_code, HttpServletRequest request){
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


    /*고객 장바구니 load*/
    @GetMapping("/list")
    public String cartForm(Model m, HttpSession session, HttpServletRequest request){
        if(!loginCheck(request))
            return "redirect:/login?toURL="+request.getRequestURI();

        try {
            /* 로그인한 고객의 email이 세션에있는지 확인한다 */
            String c_id = (String)session.getAttribute("c_id"); // ccc@ccc.com
            /* 로그인한 고객의 c_email을 이용해서 cust의 c_id를 가져온다 */
//            String c_id = cartDao.customerGetCid(cid);
            /* cart에있는 c_id를가진 고객의 장바구니를 list에 담는다 */
            List<CartDto> list = cartDao.selectUser(c_id);

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

    private boolean loginCheck(HttpServletRequest request){
        HttpSession session = request.getSession();
        return session.getAttribute("c_id") != null;
    }
}