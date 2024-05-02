package com.homerunball.customer.service;

import com.homerunball.customer.service.CustService;
import com.homerunball.customer.dao.CustDao;
import com.homerunball.customer.domain.CustDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustServiceImpl implements CustService{
    @Autowired
    private CustDao custDao;

    @Override
    public CustDto read(String c_email) {
        return custDao.selectCust(c_email);
    }

    public String emailCheck(String c_email){
        CustDto custDto = custDao.selectCust(c_email);
        if(custDto == null) {
            return "ok";
        } else {
            return "no";
        }
    }
}
