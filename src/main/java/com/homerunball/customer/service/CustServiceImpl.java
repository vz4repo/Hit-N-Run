package com.homerunball.customer.service;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.homerunball.customer.dao.CustDao;
import com.homerunball.customer.domain.CustDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;


//@Component
@Service
public class CustServiceImpl implements CustService {
    @Autowired
    private CustDao custDao;

    @Autowired
    private JavaMailSenderImpl mailSender;

    private int authNumber;

    public String emailCheck(String c_email) throws Exception {
        CustDto custDto = custDao.selectEmail(c_email);
        if (custDto == null) {
            return "ok";
        } else {
            return "no";
        }
    }

    /*비밀번호 암호화를 위해 메이븐에 스프링 시큐리티 코어 추가
    코어가 갖고 있는 BCryptPasswordEncoder 클래스 사용*/
    public String pwdEncrypt(String c_pwd) throws Exception{
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(c_pwd);
    }


    public void makeRandomNumber() throws Exception{
        // 난수의 범위 111111 ~ 999999 (6자리 난수)
        Random r = new Random();
        int checkNum = r.nextInt(888888) + 111111;
        System.out.println("인증번호 : " + checkNum);
        authNumber = checkNum;
    }

    public String joinEmail(String c_email) throws Exception{
        makeRandomNumber();
        String setFrom = ".com"; // email-config에 설정한 자신의 이메일 주소를 입력
        String toMail = c_email;
        String title = "WELCOME HOMERUN BALL :)"; // 이메일 제목
        String content = "고객님이 요청하신 인증번호는 " + authNumber + "입니다.";
        mailSend(setFrom, toMail, title, content);
        return Integer.toString(authNumber);
    }


    public void mailSend(String setFrom, String toMail, String title, String content) throws Exception{
        MimeMessage message = mailSender.createMimeMessage();
        // true 매개값을 전달하면 multipart 형식의 메세지 전달이 가능.문자 인코딩 설정도 가능하다.
//        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            // true 전달 > html 형식으로 전송 , 작성하지 않으면 단순 텍스트로 전달.
            helper.setText(content, true);
            mailSender.send(message);
        }
//        catch (MessagingException e) {
//            e.printStackTrace();
//        }
    }
//}