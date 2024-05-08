package com.homerunball.customer.dao;

import com.homerunball.customer.domain.CustDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void selectCust() {
    }

    @Test
    public void insertCust() throws Exception{
        custDao.deleteAll();
        CustDto custdto = new CustDto("1111", "1234", "aaa", "sss", "d", "000", "sss", "aaa", "sss", "ddd", "aaa", "N", "N");
        int rowCnt = custDao.insertCust(custdto);

        assertTrue(rowCnt==1);

    }

    @Test
    public void updateCust() throws Exception{
        /*테스트 중복방지*/
        custDao.deleteAll();
        /*고객 정보 추가*/
        CustDto custdto = new CustDto("1111", "1111", "aaa", "sss", "d", "888", "sss", "aaa", "sss", "ddd", "aaa", "N", "N");
        /*추가된 고객을 DB에 저장*/
        int rowCnt = custDao.insertCust(custdto);
        /*저장 성공*/
        assertTrue(rowCnt == 1);

        /*고객 비번 변경*/
        custdto.setC_pwd("2222");
        custdto.setC_nm("bbb");

        /*변경된 정보 DB에 저장*/
        rowCnt = custDao.updateCust(custdto);
        /*변경 잘됐는지 출력 > 변경 잘됨*/
        System.out.println("custdto = " + custdto);
        /*변경은 잘됐으나 DB에 저장이 실패, 이유가?..*/
        assertTrue(rowCnt == 1);

    }
    }