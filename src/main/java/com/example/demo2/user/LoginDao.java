package com.example.demo2.user;

import com.example.demo2.HashPassword;
import com.example.demo2.StudetDao.Utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    private Utils utils;

    public LoginDao(){
        this.utils =  new Utils();
    }
    private static String GET_USER_BY_UP = "Select email, password from admin where email = ?  and password = ?";

    public boolean validate(LoginBean loginBean){
        boolean result = false;
        try(PreparedStatement statement = utils.getConn().prepareStatement(GET_USER_BY_UP)){
            statement.setString(1, loginBean.getUsername());
            statement.setString(2, loginBean.getPassword());
            ResultSet rs = statement.executeQuery();
            result = rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
