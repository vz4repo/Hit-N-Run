package com.homerunball.order.controller;

import com.homerunball.order.dao.OrderDetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class OrdDetController {
    @Autowired
    OrderDetDao orderDetDao;


//    @GetMapping("/OrderDet")
//    public String select(int od_det_seqnum, int od_id, Model m)
//
}