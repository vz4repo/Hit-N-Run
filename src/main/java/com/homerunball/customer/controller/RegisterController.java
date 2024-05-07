package com.homerunball.customer.controller;
import com.homerunball.customer.dao.CustDao;
import com.homerunball.customer.domain.CustDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.homerunball.customer.service.CustService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/register")
public class RegisterController {

    /*고객다오 의존성 주입*/
    @Autowired
    CustDao custDao;

    /*고객서비스 의존성 주입*/
    @Autowired
    CustService custService;

    /*실패값을 상수 0으로 지정*/
    final int FAIL = 0;


    @InitBinder
    public void custValid(WebDataBinder binder){
        /*CustValidator를 WebDateBinder의 로컬 validator로 등록*/
        binder.setValidator(new CustValidator());
    }

    /*리퀘스트맵핑에서 겟맵핑 /add로 이동하면 회원가입 폼으로 이동*/
    @GetMapping("/add")
    public String register(){
        return "registerForm";
    }

    /*겟맵핑에서 포스트로 보낼때*/
    @PostMapping("/add")
    public String save(@Valid CustDto custDto, BindingResult result, RedirectAttributes Successful){
        System.out.println("자스를 통과한 에러가 있나요?! = " + result);
        if (!result.hasErrors()) {
            System.out.println("회원가입 정보 = " + custDto);
            int rowCnt = custDao.insertCust(custDto);
            if (rowCnt != FAIL){
                Successful.addFlashAttribute("signUp", "signUpOk");
                return "redirect:/login";
            }
        }
        /*에러 있을시 회원가입 폼으로 이동*/
        return "registerForm";
    }

//    /*이메일 중복 체크*/
    @PostMapping("/email-check")
    public @ResponseBody String emailCheck(@RequestParam("c_email") String c_email) {
        System.out.println("c_email = " + c_email);
        String checkResult = custService.emailCheck(c_email);
        return checkResult;
    }

}