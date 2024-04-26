package com.homerunball.cust.dao;

import com.homerunball.cust.dto.CustDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CustDaoImpl implements CustDao {
    @Autowired
    DataSource ds;
    final int FAIL = 0;

    @Override
    public int deleteCust(String c_email) {
        int rowCnt = FAIL;

        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "delete from cust where c_email= ? ";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c_email);
     /*   int rowCnt = pstmt.executeUpdate();
        return rowCnt;*/
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return FAIL;
        } finally {
            /* close()를 호출하다가 예외가 발생할 수 있으므로, try-catch로 감싸야함.*/
            close(pstmt, conn);
        }
    }

    @Override
    public CustDto selectCust(String c_email) {
        CustDto cust = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select c_email, c_pwd, c_nm, c_birth, c_gnd, c_phn, c_zip, c_road_a, c_jibun_a, c_det_a, c_ext_a, sms_agr, email_agr from cust where c_email = ?";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c_email);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                cust = new CustDto();
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

            }
        } catch (SQLException e) {
            return null;
        } finally {
            close(rs, pstmt, conn);
        }

        return cust;
    }

    @Override
    public int insertCust(CustDto cust) {
        int rowCnt = FAIL;

        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "insert into cust(c_email, c_pwd, c_nm, c_birth, c_gnd, c_phn, c_zip, c_road_a, c_jibun_a, c_det_a, c_ext_a, sms_agr, email_agr) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
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


            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return FAIL;
        } finally {
            close(pstmt, conn);
        }
    }

    @Override
    public int updateCust(CustDto cust) {
        int rowCnt = FAIL;

        String sql = "update cust " +
                "set c_pwd = ?, c_nm = ?, c_birth = ?, c_gnd = ?, c_phn = ?, c_zip = ?, c_road_a = ?, c_jibun_a = ?, c_det_a = ?, c_ext_a = ?, sms_agr = ?, email_agr = ?" + "where c_email = ?";
        try (
                Connection conn = ds.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
            pstmt.setString(1, cust.getC_pwd());
            pstmt.setString(2, cust.getC_nm());
            pstmt.setString(3, cust.getC_birth());
            pstmt.setString(4, cust.getC_gnd());
            pstmt.setString(5, cust.getC_phn());
            pstmt.setString(6, cust.getC_zip());
            pstmt.setString(7, cust.getC_road_a());
            pstmt.setString(8, cust.getC_jibun_a());
            pstmt.setString(9, cust.getC_det_a());
            pstmt.setString(10, cust.getC_ext_a());
            pstmt.setString(11, cust.getSms_agr());
            pstmt.setString(12, cust.getEmail_agr());
            pstmt.setString(13, cust.getC_email());

            rowCnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return FAIL;
        }

        return rowCnt;
    }

    private void deleteAll() throws Exception {
        Connection conn = ds.getConnection();

        String sql = "delete from cust";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
    }

    private void close(AutoCloseable... acs) {
        for(AutoCloseable ac :acs)
            try { if(ac!=null) ac.close(); } catch(Exception e) { e.printStackTrace(); }
    }
}
