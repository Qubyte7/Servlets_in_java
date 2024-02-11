package com.example.demo2.StudetDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
   final private String url= "jdbc:postgresql://localhost:8080/javaweb";
   final private String password= "Mugisha@2007";
   final private String name = "postgres";

   Connection conn;
   public Connection getConn()throws SQLException{
       try{
           Class.forName("org.postgresql.Driver");
           conn = DriverManager.getConnection(url,name,password);
           System.out.println("connection successfully !");
       }catch (SQLException e){
           System.out.println(e.getMessage());
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return conn;
   }

}