package com.homerunball.cust.controller;
import com.homerunball.cust.dao.CustDao;
import com.homerunball.cust.dto.CustDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.homerunball.cust.service.CustService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    CustDao custDao;

    @Autowired
    CustService custService;

    final int FAIL = 0;

    @GetMapping("/add")
    public  String register(){
        return "registerForm";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute("custdto") CustDto custdto, BindingResult result, RedirectAttributes Successful) throws Exception {

        /*에러가 없으면 DB에 값 저장*/
        if (!result.hasErrors()) {
            System.out.println("custdto.toString() = " + custdto.toString());
            int rowCnt = custDao.insertCust(custdto);
            if (rowCnt != FAIL){
//                return "registerInfo";
                Successful.addFlashAttribute("signUp", "signUpOk");
                return "redirect:/login";
            }
        }
        /*에러 있을시 회원가입 폼으로 이동*/
        return "registerForm";
    }

    /*자바로 2차 유효성 검사(대기)*/
    private boolean isValid(CustDto custdto) {

        return true;
    }

    /*이메일 중복 체크*/
    @PostMapping("/email-check")
    public @ResponseBody String emailCheck(@RequestParam("c_email") String c_email) {
        System.out.println("c_email = " + c_email);
        String checkResult = custService.emailCheck(c_email);
        return checkResult;
    }
}