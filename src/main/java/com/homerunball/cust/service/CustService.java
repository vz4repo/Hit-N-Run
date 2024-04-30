package com.homerunball.cust.service;
import com.homerunball.cust.dto.CustDto;
import java.util.List;

public interface CustService {

    String emailCheck(String c_email);

    CustDto read(String c_email);

}


