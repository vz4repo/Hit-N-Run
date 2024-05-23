package com.homerunball.customer.service;
import com.homerunball.customer.domain.CustDto;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface CustService {

    /*이메일 중복체크*/
    String emailCheck(String c_email) throws Exception;


    /*비밀번호 암호화*/
    String pwdEncrypt(String c_pwd) throws Exception;


String joinEmail(String c_email) throws Exception;

}





