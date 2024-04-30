package com.homerunball.cust.controller;
import com.homerunball.cust.dao.CustDao;
import com.homerunball.cust.dto.CustDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.homerunball.cust.service.CustService;


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
    public String save(@ModelAttribute("custdto") CustDto custdto, BindingResult result) throws Exception {

        if (!result.hasErrors()) {
            System.out.println("custdto.toString() = " + custdto.toString());
            int rowCnt = custDao.insertCust(custdto);
            if (rowCnt != FAIL){
                return "registerInfo";
            }
        }
        return "registerForm";
    }

    private boolean isValid(CustDto custdto) {

        return true;
    }

    @PostMapping("/email-check")
    public @ResponseBody String emailCheck(@RequestParam("c_email") String c_email) {
        System.out.println("c_email = " + c_email);
        String checkResult = custService.emailCheck(c_email);
        return checkResult;
    }
}