package com.ohgiraffers.understand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBTemplate.*;

public class Practice {
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;


        getEmpInfoByName(con, stmt, rset);



    }

    public static void mostSalarlyInfo(Connection con, Statement stmt,  ResultSet rset){
        try {
            stmt= con.createStatement();
            String query =
                    "SELECT "+
                            " SALARY, "+
                            " EMP_ID, "+
                            " EMP_NAME, "+
                            " PHONE "+
                            " FROM employee"+
                            " ORDER BY SALARY DESC LIMIT 1;";

            rset = stmt.executeQuery(query);
            while(rset.next()){
                System.out.println("사원ID:"+rset.getString("EMP_ID")+" 사원이름: "+rset.getString("EMP_NAME"));
                System.out.println("전화번호: "+ rset.getString("PHONE")+" 월급: "+rset.getString("SALARY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close(con);
            close(stmt);
            close(rset);
        }
    }




    public static void getEmpInfoByName(Connection con, Statement stmt,  ResultSet rset){

        Scanner sc = new Scanner(System.in);

        System.out.println("조회하실 사원의 이름을 입력해주세요: ");
        String name = sc.next();


        try {
            stmt= con.createStatement();
            String query =
                    "SELECT "+
                            " a.SALARY, "+
                            " a.EMP_ID, "+
                            " a.EMP_NAME, "+
                            " b.JOB_NAME, "+
                            " a.PHONE "+
                            " FROM employee as a "+
                            " JOIN job as b on a.JOB_CODE = b.JOB_CODE "+
                            " WHERE EMP_NAME = '"+name+"' ";

            rset = stmt.executeQuery(query);
            while(rset.next()){
                System.out.println("사원ID:"+rset.getString("EMP_ID")+" 사원이름: "+rset.getString("EMP_NAME"));
                System.out.println("전화번호: "+ rset.getString("PHONE")+" 월급: "+rset.getString("SALARY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close(con);
            close(stmt);
            close(rset);
        }
    }
}
