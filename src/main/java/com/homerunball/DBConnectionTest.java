package com.homerunball;

import java.sql.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DBConnectionTest {
  @GetMapping("/")
  public String connTest(Model model) throws Exception {
    final String DB_URL = "jdbc:mysql://localhost:3306/homerunball?useUnicode=true&characterEncoding=utf8";
    final String DB_USER = "root";
    final String DB_PASSWORD = "12341234";

    Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    /* 데이터베이스의 연결을 얻는다. */
    Statement stmt = conn.createStatement();
    /* Statement를 생성한다. */

    String query = "SELECT now()";
    /* 시스템의 현재 날짜시간을 출력하는 쿼리(query) */
    ResultSet rs = stmt.executeQuery(query);
    /* query를 실행한 결과를 rs에 담는다. */

    String curDate = "default sysdate";

    /*  실행결과가 담긴 rs에서 한 줄씩 읽어서 출력 */
    while (rs.next()) {
      curDate = rs.getString(1);
      /* 읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 curDate에 저장 */
      System.out.printf("##### DB 접속 성공 ##### %n[ SELECT now() -> %s ]", curDate);
    }
    model.addAttribute("curDate", curDate);

    return "index";
  }

//  @GetMapping("conn")
//  public  static void main(String args[]) throws Exception {
//    final String DB_URL = "jdbc:mysql://localhost:3306/homerunball?useUnicode=true&characterEncoding=utf8";
//    final String DB_USER = "root";
//    final String DB_PASSWORD = "12341234";
//
//    Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//    /* 데이터베이스의 연결을 얻는다. */
//    Statement stmt  = conn.createStatement();
//    /* Statement를 생성한다. */
//
//    String query = "SELECT now()";
//    /* 시스템의 현재 날짜시간을 출력하는 쿼리(query) */
//    ResultSet rs = stmt.executeQuery(query);
//    /* query를 실행한 결과를 rs에 담는다. */
//
//    String curDate = "default sysdate";
//
//    /*  실행결과가 담긴 rs에서 한 줄씩 읽어서 출력 */
//    while (rs.next()) {
//      curDate = rs.getString(1);
//      /* 읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 curDate에 저장 */
//      System.out.printf("[ SELECT now() -> %s ]", curDate);
//    }
//  }
}