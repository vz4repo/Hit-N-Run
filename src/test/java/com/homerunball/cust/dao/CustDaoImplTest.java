package com.homerunball.cust.dao;

import com.homerunball.cust.dto.CustDto;
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
    CustDao custDao;

    @Test
    public void deleteCust() {
    }

    @Test
    public void selectCust() {
    }

    @Test
    public void insertCust() {
    }

    @Test
    public void updateCust() {
        /*테스트 중복방지*/
        custDao.deleteCust("bbbbb");
        /*고객 정보 추가*/
        CustDto cust = new CustDto("bbbbb", "1111", "aaa", "sss", "d", "888", "sss", "aaa", "sss", "ddd", "aaa", "N", "N");
        /*추가된 고객을 DB에 저장*/
        int rowCnt = custDao.insertCust(cust);
        /*저장 성공*/
        assertTrue(rowCnt == 1);

        /*고객 비번 변경*/
        cust.setC_pwd("2222");
        cust.setC_nm("bbb");

        /*변경된 정보 DB에 저장*/
        rowCnt = custDao.updateCust(cust);
        /*변경 잘됐는지 출력 > 변경 잘됨*/
        System.out.println("cust = " + cust);
        /*변경은 잘됐으나 DB에 저장이 실패, 이유가?..*/
        assertTrue(rowCnt == 1);

       /* Cust cust2 = custDao.selectCust(cust.getC_email());
        System.out.println("cust = " + cust);
        System.out.println("cust2 = " + cust2);
        assertTrue(cust.equals(cust2));*/
    }
    }