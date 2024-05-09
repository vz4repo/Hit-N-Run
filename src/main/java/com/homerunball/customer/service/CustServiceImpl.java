package com.homerunball.customer.service;

import com.homerunball.customer.dao.CustDao;
import com.homerunball.customer.domain.CustDto;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class CustServiceImpl implements CustService {
    @Autowired
    private CustDao custDao;


    public String emailCheck(String c_email) {
        CustDto custDto = custDao.selectEmail(c_email);
        if (custDto == null) {
            return "ok";
        } else {
            return "no";
        }
    }

}
