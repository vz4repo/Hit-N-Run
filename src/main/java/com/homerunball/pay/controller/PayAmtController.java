package com.homerunball.pay.controller;

import com.homerunball.pay.dao.PayAmtDaoImpl;
import com.homerunball.pay.dto.PayAmtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*

결제가 들어간다는 것은?
- 전제 : 주문이 완료됐다.
1. 주문 메인 테이블 조회
    > 고객의 상태가 탈퇴인지 아닌지?
        > 주문번호 없어? ! 에러처리
        > 주문번호 있어? ! 통과(값 반환)
    > 회원이야? ? (회원id + 주문번호) 조회 : 주문번호 조회
2. 주문번호를 가지고 주문상세테이블 조회
   > 주문번호 없어? ! 에러처리
   > 주문번호 있어? ! 통과(값 반환)
3. 고객이 존재하는지 조회? 고객 테이블에 없어? ! 에러처리
4. 1번에 대한 결제 상세 금액 조회

*/

@Controller
public class PayAmtController {
    @Autowired
    PayAmtDaoImpl payAmtDao;

    @RequestMapping(value = "/selectDataPayAmt", method = RequestMethod.POST)
    public String InsertDataPayAmt(Model model) {
        /*PayAmtDto payAmtDto = new PayAmtDto();*/


        return "작업중...";
    }
/*
    @RequestMapping(value = "/PayAmtForm", method = RequestMethod.POST)
    public String viewPayAmtForm() {
        System.out.println("PayAmtForm.jsp를 호출하는 컨트롤러가 동작 했습니다.");
        return "PayAmtForm";
    }
*/

    @RequestMapping("/PayAmtList")
    public String viewPayAmtList() {
        System.out.println("PayAmtList.jsp를 호출하는 컨트롤러가 동작 했습니다.");
        return "PayAmtList";
    }
}
