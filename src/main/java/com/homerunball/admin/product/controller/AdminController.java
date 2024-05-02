package com.homerunball.admin.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    /*관리자 메인페이지로 이동한다.*/
    @RequestMapping("/main")
    public String main(Model model) {
        return "/admin/admin";
    }
}