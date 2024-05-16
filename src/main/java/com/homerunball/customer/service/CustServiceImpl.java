package com.homerunball.customer.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.homerunball.customer.dao.CustDao;
import com.homerunball.customer.domain.CustDto;
import org.springframework.beans.factory.annotation.Autowired;


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
    /*비밀번호 암호화를 위해 메이븐에 스프링 시큐리티 코어 추가
    코어가 갖고 있는 BCryptPasswordEncoder 클래스 사용*/
    public String pwdEncrypt(String c_pwd) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(c_pwd);
    }

}