package com.homerunball.delivery.controller;

import com.homerunball.delivery.dao.DeliveryDao;
import com.homerunball.delivery.domain.DeliveryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/delivery") /* 원하는 url을 사용해서 해당 메서드 실행할수있게 해줌 */
public class DeliveryController {
    @Autowired /* 의존성 주입 */
    DeliveryDao deliveryDao;

    @GetMapping("/deliveryList")
    /*public String deliveryList(HttpServletRequest request) {*/
    /* 고객 배송지 목록 출력 <- CartController 의 cartForm 에서 뺏겨옴*/
    /*public String deliveryList(int c_id, Model model, HttpSession session) throws Exception {*/
/*    public String deliveryList(Model model, @RequestParam("c_id") int c_id) throws Exception {*/
    public String deliveryList(DeliveryDto dto, Model model) throws Exception {
            /* 로그인 되어있는지 체크하는 메서드로 체크. 안되어있으면 로그인페이지로 */
        /*로그인한 고객이 세션에있는지 확인한다*/
        /*int loginId = (int)session.getAttribute(c_id);*/

//        int c_id = Integer.parseInt(request.getParameter("c_id"));

        List<DeliveryDto> list = deliveryDao.selectAll(dto.getC_id());
        /*List<DeliveryDto> list = deliveryDao.selectAll(c_id);*/
        System.out.println(list);
        model.addAttribute("list", list);

        System.out.println("list = " + list);

        return "deliveryList";
    }

    /* 로그인 되어있는지 확인하는 메서드  */
    private boolean loginChecked(HttpServletRequest request){
        HttpSession session = request.getSession();
        return session.getAttribute("c_email") != null;

    }
}