package com.homerunball.cust.controller;

import com.homerunball.cust.dto.CustDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    /*@InitBinder
    public void toDate(WebDataBinder binder){
        conversionService conversionService = binder.getConversionService();
        System.out.println("conversionService="+conversionService);
        binder.setValidator(new CustValidator());
    }*/
    @GetMapping("/add")
    public  String register(){
        return "registerForm";
    }
    @PostMapping("/save")
    public String save(CustDto cust, BindingResult result, Model m) throws Exception {

/*        CustValidator custValidator = new CustValidator();
        custValidator.validate(cust, result);*/

        if(result.hasErrors()) {
            return "registerForm";
        }

       /* if(!isValid(cust)) {
            String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
            m.addAttribute("msg", msg);
            return "redirect:/register/add";
      }*/

        return "registerInfo";
    }

    private boolean isValid(CustDto cust) {
        return true;
    }
}