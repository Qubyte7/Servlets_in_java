package com.example.demo2.Admin;

import com.example.demo2.StudetDao.Utils;
import com.example.demo2.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminImpl {
    Connection conn = null;
    Utils u = new Utils();
    public void RegisterUser(Admin user){

        String sql = "INSERT INTO admin (name, email, password) VALUES (?,?,?);";
        conn = u.getConn();
        try{
        PreparedStatement inserting = conn.prepareStatement(sql);
        inserting.setString(1,user.name);
        inserting.setString(2,user.email);
        inserting.setString(3,user.password);
        inserting.executeUpdate();
        System.out.println("User successfully created");
    }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public  void deleteUser()throws SQLException{

        String sql  = " DELETE FROM admin where id = ?;";
        conn = u.getConn();
        PreparedStatement inserting = conn.prepareStatement(sql);
        inserting.executeUpdate();
        System.out.println("successfully Delete User");
    }
    public  void viewUsers()throws SQLException{
        String sql = "SELECT name ,email from guest;";
        conn = u.getConn();
        PreparedStatement inserting = conn.prepareStatement(sql);
        inserting.executeUpdate();
    }
}
