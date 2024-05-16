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


    /*겟맵핑 /add 경로일시 회원가입 폼으로 이동*/
    @GetMapping("/add")
    public String register(){
        return "registerForm";
    }


    /*유효성 검사를 하기 위한 어노테이션*/
    /*새로 작성한 Validator를 사용하기 위해서 InitBinder 어노테이션 사용*/
    @InitBinder
    /*유효성 검사를 위해 WebDataBinder클래스의 객체를 사용*/
    public void custValid(WebDataBinder binder){
        /*객체를 통해 새로운 Validator인 CustValidator를 등록*/
        binder.setValidator(new CustValidator());
    }

    @PostMapping("/add")
    /*유효성 검사가 필요한 객체 앞에 @Valid 어노테이션을 작성하면 등록한 CustValidator 사용가능*/
    public String save(@Valid CustDto custDto, BindingResult result, RedirectAttributes Successful) {
        /*Validator에서 걸린게 있으면 그 오류가 result에 저장됨*/
        System.out.println("자스를 통과한 에러가 있나요?! = " + result);
        try {
            /*hasErrors 메서드를 통해서 result에 오류가 있다면 회원가입 폼으로 이동*/
            if (result.hasErrors()) {
                return "registerForm";
            }
            /*선택 약관을 체크 안했을시 N값으로 저장*/
            if (custDto.getSms_agr() == null) {
                custDto.setSms_agr("N");
            }
            if (custDto.getEmail_agr() == null) {
                custDto.setEmail_agr("N");
            }
            System.out.println("회원가입 정보 = " + custDto);
            Successful.addFlashAttribute("signUpClear", "msg");

            custDto.setC_pwd(custService.pwdEncrypt(custDto.getC_pwd()));

            /*회원가입시 적었던 정보를 Dto를 이용하여 Dao에 인서트하여 DB 저장*/
            custDao.insert(custDto);

        /*예외 발생시 로그에서 예외 정보 출력해주고 회원가입 폼으로 이동*/
        } catch (Exception e) {
            e.printStackTrace();
            return "registerForm";
        }
        /*예외 발생 없을시 로그인 화면으로 이동*/
        return "redirect:/login";
    }

    /*이메일 중복 체크*/
    @PostMapping("/email-check")
    public @ResponseBody String emailCheck(@RequestParam("c_email") String c_email) {
        String checkResult = custService.emailCheck(c_email);
        return checkResult;
    }
}