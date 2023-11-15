package main.java.com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application02 {

    public static void main(String[] args){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost/employee";
        String user = "guro";
        String password = "guro";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, password);
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
