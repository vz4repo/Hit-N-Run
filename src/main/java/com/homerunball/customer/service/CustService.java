package com.homerunball.customer.service;
import com.homerunball.customer.dto.CustDto;

public interface CustService {

    String emailCheck(String c_email);

    CustDto read(String c_email);

}


