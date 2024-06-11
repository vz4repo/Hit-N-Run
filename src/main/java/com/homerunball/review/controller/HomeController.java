package com.homerunball.review.controller;

import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//@Controller
public class HomeController {

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list(Locale locale, Model model) {

    model.addAttribute("url", "list.co");
    /* TODO: sysout 대신 Logger */
    /*System.out.println("list");*/
    return "list";
  }

  @RequestMapping(value = "/detail", method = RequestMethod.GET)
  public String detail(Locale locale, Model model) {

    model.addAttribute("url", "detail.co");
    /* TODO: sysout 대신 Logger */
    /*System.out.println("detail");*/
    return "detail";
  }
}