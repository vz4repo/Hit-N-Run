package com.homerunball.customer.dao;

import com.homerunball.customer.controller.CustValidator;
import com.homerunball.customer.controller.LoginController;
import com.homerunball.customer.domain.CustDto;
//import com.homerunball.customer.domain.CustHistDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class CustDaoImplTest {
    @Autowired
    private CustDao custDao;


    @Test
    public void deleteCust() {
    }

    @Test
    public void selectEmail() {
    }

//    @Test
//    public void insert() throws Exception{
//        custDao.deleteAll();
//        CustDto custDto = new CustDto("asdf", "1234", "aaa", "bbb", "b", "000", "223", "aaa", "jjj", "ddd", "Y", "Y");
//        int rowCnt = custDao.insert(custDto);
//        assertTrue(rowCnt==1);
//    }


    @Test
    public void updateAll() throws Exception{
        /*DB에서 아이디 100056번인 고객의 정보를 Dto에 저장*/
        CustDto custDto = custDao.selectID(100056);

        /*그 고객의 이름을 변경*/
        custDto.setC_name("흥흥흥");
        custDto.setC_phn("9999");

        /* 수정된 정보를 데이터베이스에 업데이트 */
        int rowCnt = custDao.updateAll(custDto);
        /* 업데이트가 성공적으로 수행되었는지 확인 */
        assertTrue(rowCnt == 1);
    }


//    @Test
//    public void histInsert() throws Exception{
//        CustHistDto custHistDto = custDao
//    }
}