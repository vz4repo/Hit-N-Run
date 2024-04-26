package com.homerunball;

import com.homerunball.cust.dto.CustDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DBConnectionTest2Test {
    @Autowired
    DataSource ds;

    @Test
    public void insertCustTest() throws Exception{
        deleteAll();
        CustDto cust = new CustDto("1111", "1234", "aaa", "sss", "d", "000", "sss", "aaa", "sss", "ddd", "aaa", "N", "N");
        int rowCnt = insertCust(cust);

        assertTrue(rowCnt==1);
    }

    @Test
    public void selectCustTest() throws Exception{
        deleteAll();
        CustDto cust = new CustDto("bbb","sss","aaa","sss","d","a","sss","aaa","sss","ddd","aaa","N","N");
        int rowCnt = insertCust(cust);
        CustDto cust2 = selectCust("bbb");

        assertEquals(true, cust.getC_email().equals("bbb"));
    }
@Test
    public void deleteCustTest() throws Exception{
        deleteAll();
        int rowCnt = deleteCust("asdf");

        assertTrue(rowCnt == 0);

        CustDto cust = new CustDto("bbb","sss","aaa","sss","d","a","sss","aaa","sss","ddd","aaa","N","N");
        rowCnt = insertCust(cust);
        assertTrue(rowCnt == 1);

        rowCnt = deleteCust(cust.getC_email());
        assertTrue(rowCnt == 1);

        assertTrue(selectCust(cust.getC_email())==null);
    }

    public int insertCust(CustDto cust)throws Exception{
        Connection conn = ds.getConnection();

    String sql = "insert into cust(c_email, c_pwd, c_nm, c_birth, c_gnd, c_phn, c_zip, c_road_a, c_jibun_a, c_det_a, c_ext_a, sms_agr, email_agr) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, cust.getC_email());
        pstmt.setString(2, cust.getC_pwd());
        pstmt.setString(3, cust.getC_nm());
        pstmt.setString(4, cust.getC_birth());
        pstmt.setString(5, cust.getC_gnd());
        pstmt.setString(6, cust.getC_phn());
        pstmt.setString(7, cust.getC_zip());
        pstmt.setString(8, cust.getC_road_a());
        pstmt.setString(9, cust.getC_jibun_a());
        pstmt.setString(10, cust.getC_det_a());
        pstmt.setString(11, cust.getC_ext_a());
        pstmt.setString(12, cust.getSms_agr());
        pstmt.setString(13, cust.getEmail_agr());

        int rowCnt = pstmt.executeUpdate();

        return rowCnt;
    }

    public CustDto selectCust(String c_email) throws Exception {
        Connection conn = ds.getConnection();

        String sql = "select c_email, c_pwd, c_nm, c_birth, c_gnd, c_phn, c_zip, c_road_a, c_jibun_a, c_det_a, c_ext_a, sms_agr, email_agr from cust where c_email = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, c_email);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            CustDto cust = new CustDto();

            cust.setC_email(rs.getString(1));
            cust.setC_pwd(rs.getString(2));
            cust.setC_nm(rs.getString(3));
            cust.setC_birth(rs.getString(4));
            cust.setC_gnd(rs.getString(5));
            cust.setC_phn(rs.getString(6));
            cust.setC_zip(rs.getString(7));
            cust.setC_road_a(rs.getString(8));
            cust.setC_jibun_a(rs.getString(9));
            cust.setC_det_a(rs.getString(10));
            cust.setC_ext_a(rs.getString(11));
            cust.setSms_agr(rs.getString(12));
            cust.setEmail_agr(rs.getString(13));

            return cust;
        }
        return null;
    }
    @Test
    public void updateUserTest() throws Exception {
        deleteAll();
        CustDto cust = new CustDto("bbb", "1111", "evra", "sss", "d", "888", "sss", "aaa", "sss", "ddd", "aaa", "N", "N");
        int rowCnt = insertCust(cust);
        assertTrue(rowCnt == 1);

        CustDto cust2 = new CustDto("bbb", "3333", "evra", "sss", "d", "888", "sss", "aaa", "sss", "ddd", "aaa", "N", "N");
        rowCnt = updateCust(cust2);
        assertTrue(rowCnt == 1);

        assertTrue(selectCust("bbb").getC_nm().equals("evra"));
    }

    public int updateCust(CustDto cust) throws Exception{
        Connection conn = ds.getConnection();

        String sql = "update cust " +
                "set c_pwd = ?, c_nm = ?, c_birth = ?, c_gnd = ?, c_phn = ?, c_zip = ?, c_road_a = ?, c_jibun_a = ?, c_det_a = ?, c_ext_a = ?, sms_agr = ?, email_agr = ?" + "where c_email = ?";

        PreparedStatement pstat = conn.prepareStatement(sql);

        pstat.setString(1, cust.getC_pwd());
        pstat.setString(2, cust.getC_nm());
        pstat.setString(3, cust.getC_birth());
        pstat.setString(4, cust.getC_gnd());
        pstat.setString(5, cust.getC_phn());
        pstat.setString(6, cust.getC_zip());
        pstat.setString(7, cust.getC_road_a());
        pstat.setString(8, cust.getC_jibun_a());
        pstat.setString(9, cust.getC_det_a());
        pstat.setString(10, cust.getC_ext_a());
        pstat.setString(11, cust.getSms_agr());
        pstat.setString(12, cust.getEmail_agr());
        pstat.setString(13, cust.getC_email());

        return pstat.executeUpdate();
    }

    public int deleteCust(String c_email) throws Exception{
        Connection conn = ds.getConnection();

        String sql = "delete from cust where c_email = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, c_email);
        return pstmt.executeUpdate();
    }
    private void deleteAll() throws Exception {
        Connection conn = ds.getConnection();

        String sql = "delete from cust";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
    }
    @Test
public void springJdbcConnectionTest() throws Exception{

    Connection conn = ds.getConnection(); // 데이터베이스의 연결을 얻는다.

    System.out.println("conn = " + conn);
        assertTrue(conn!=null);
}
}