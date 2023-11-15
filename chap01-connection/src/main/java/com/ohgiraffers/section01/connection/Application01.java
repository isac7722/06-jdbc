package main.java.com.ohgiraffers.section01.connection;

import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application01 {
    public static void main(String[] args) {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "guro", "guro");
            System.out.println(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
