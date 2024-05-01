package com.homerunball.customer;

import com.homerunball.customer.domain.CustDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class CustTest {
    @Autowired
    DataSource ds;

    @Test
    public void insertCustTest() throws Exception{
        deleteAll();
        CustDto custdto = new CustDto("1111", "1234", "aaa", "sss", "d", "000", "sss", "aaa", "sss", "ddd", "aaa", "N", "N");
        int rowCnt = insertCust(custdto);

        assertTrue(rowCnt==1);
    }

    @Test
    public void selectCustTest() throws Exception{
        deleteAll();
        CustDto custdto = new CustDto("bbb","sss","aaa","sss","d","a","sss","aaa","sss","ddd","aaa","N","N");
        int rowCnt = insertCust(custdto);
        CustDto cust2 = selectCust("bbb");

        assertEquals(true, custdto.getC_email().equals("bbb"));
    }
@Test
    public void deleteCustTest() throws Exception{
        deleteAll();
        int rowCnt = deleteCust("asdf");

        assertTrue(rowCnt == 0);

        CustDto custdto = new CustDto("bbb","sss","aaa","sss","d","a","sss","aaa","sss","ddd","aaa","N","N");
        rowCnt = insertCust(custdto);
        assertTrue(rowCnt == 1);

        rowCnt = deleteCust(custdto.getC_email());
        assertTrue(rowCnt == 1);

        assertTrue(selectCust(custdto.getC_email())==null);
    }

    public int insertCust(CustDto custdto)throws Exception{
        Connection conn = ds.getConnection();

    String sql = "insert into cust(c_email, c_pwd, c_nm, c_birth, c_gnd, c_phn, c_zip, c_road_a, c_jibun_a, c_det_a, c_ext_a, sms_agr, email_agr) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, custdto.getC_email());
        pstmt.setString(2, custdto.getC_pwd());
        pstmt.setString(3, custdto.getC_nm());
        pstmt.setString(4, custdto.getC_birth());
        pstmt.setString(5, custdto.getC_gnd());
        pstmt.setString(6, custdto.getC_phn());
        pstmt.setString(7, custdto.getC_zip());
        pstmt.setString(8, custdto.getC_road_a());
        pstmt.setString(9, custdto.getC_jibun_a());
        pstmt.setString(10, custdto.getC_det_a());
        pstmt.setString(11, custdto.getC_ext_a());
        pstmt.setString(12, custdto.getSms_agr());
        pstmt.setString(13, custdto.getEmail_agr());

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
            CustDto custdto = new CustDto();

            custdto.setC_email(rs.getString(1));
            custdto.setC_pwd(rs.getString(2));
            custdto.setC_nm(rs.getString(3));
            custdto.setC_birth(rs.getString(4));
            custdto.setC_gnd(rs.getString(5));
            custdto.setC_phn(rs.getString(6));
            custdto.setC_zip(rs.getString(7));
            custdto.setC_road_a(rs.getString(8));
            custdto.setC_jibun_a(rs.getString(9));
            custdto.setC_det_a(rs.getString(10));
            custdto.setC_ext_a(rs.getString(11));
            custdto.setSms_agr(rs.getString(12));
            custdto.setEmail_agr(rs.getString(13));

            return custdto;
        }
        return null;
    }
    @Test
    public void updateUserTest() throws Exception {
        deleteAll();
        CustDto custdto = new CustDto("bbb", "1111", "evra", "sss", "d", "888", "sss", "aaa", "sss", "ddd", "aaa", "N", "N");
        int rowCnt = insertCust(custdto);
        assertTrue(rowCnt == 1);

        CustDto cust2 = new CustDto("bbb", "3333", "evra", "sss", "d", "888", "sss", "aaa", "sss", "ddd", "aaa", "N", "N");
        rowCnt = updateCust(cust2);
        assertTrue(rowCnt == 1);

        assertTrue(selectCust("bbb").getC_nm().equals("evra"));
    }

    public int updateCust(CustDto custdto) throws Exception{
        Connection conn = ds.getConnection();

        String sql = "update cust " +
                "set c_pwd = ?, c_nm = ?, c_birth = ?, c_gnd = ?, c_phn = ?, c_zip = ?, c_road_a = ?, c_jibun_a = ?, c_det_a = ?, c_ext_a = ?, sms_agr = ?, email_agr = ?" + "where c_email = ?";

        PreparedStatement pstat = conn.prepareStatement(sql);

        pstat.setString(1, custdto.getC_pwd());
        pstat.setString(2, custdto.getC_nm());
        pstat.setString(3, custdto.getC_birth());
        pstat.setString(4, custdto.getC_gnd());
        pstat.setString(5, custdto.getC_phn());
        pstat.setString(6, custdto.getC_zip());
        pstat.setString(7, custdto.getC_road_a());
        pstat.setString(8, custdto.getC_jibun_a());
        pstat.setString(9, custdto.getC_det_a());
        pstat.setString(10, custdto.getC_ext_a());
        pstat.setString(11, custdto.getSms_agr());
        pstat.setString(12, custdto.getEmail_agr());
        pstat.setString(13, custdto.getC_email());

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