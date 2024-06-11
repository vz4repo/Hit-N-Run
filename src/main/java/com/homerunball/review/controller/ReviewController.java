package com.homerunball.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {

  @GetMapping("showRevw")
  public String showRevw(String pd_id ) {
    /* 제품 상세 페이지로 */
    return "pdDetail";
  }
}
