package com.homerunball;

import java.sql.*;

public class DBConnectionTest {
    public static void main(String[] args) throws Exception {
        String DB_URL = "jdbc:mysql://localhost:3306/homerunball?useUnicode=true&characterEncoding=utf8";

        String DB_USER = "root";
        String DB_PASSWORD = "1234";

        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        Statement stmt  = conn.createStatement();

        String query = "SELECT now()";
        ResultSet rs = stmt.executeQuery(query);

        // 실행결과가 담긴 rs에서 한 줄씩 읽어서 출력
        while (rs.next()) {
            String curDate = rs.getString(1);
            System.out.println(curDate);
        }
    }
}

