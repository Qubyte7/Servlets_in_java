package com.example.demo2.user;

import com.example.demo2.StudetDao.Utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserChecking {
    Utils utils;
    public UserChecking(){this.utils = new Utils();}
    private static String SQL = "select email from admin where email = ? ;";
    public  boolean validate(String email){
        boolean result = false;
       try(PreparedStatement checking = utils.getConn().prepareStatement(SQL);) {
           checking.setString(1,email);
           ResultSet rs = checking.executeQuery();
           result = rs.next();
       }catch (Exception e){
           throw  new RuntimeException(e);
       }
       return result;
    }
}
