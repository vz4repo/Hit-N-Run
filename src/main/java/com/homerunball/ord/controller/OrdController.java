package com.homerunball.ord.controller;

import com.homerunball.ord.dao.OrdDao;
import com.homerunball.ord.domain.OrdDto;
import com.homerunball.ord.service.OrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/")
public class OrdController {
    @Autowired
    OrdService ordService;
    @Autowired
    OrdDao ordDao;


    @GetMapping("/order")
    public String read(String od_id, Model m){
        try {
            List<OrdDto> list = ordDao.selectOdId(od_id);
            System.out.println(list);
            /*System.out.println("[controller]ordDto = " + ordDto);*/
            m.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "order";
    }
}

