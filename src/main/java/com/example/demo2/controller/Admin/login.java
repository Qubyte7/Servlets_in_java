package com.example.demo2.controller.Admin;

import com.example.demo2.HashPassword;
import com.example.demo2.user.LoginBean;
import com.example.demo2.user.LoginDao;
import com.example.demo2.user.UserImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/A_login")
public class login extends HttpServlet {
    UserImpl user;
    LoginDao loginDao;
    HashPassword hashPassword;
    public void init(){
        this.user = new UserImpl();
        this.loginDao = new LoginDao();

    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String HashedPassword = HashPassword.dohashing(password);

        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(email);
        loginBean.setPassword(HashedPassword);
        HttpSession session = req.getSession(true);

        try {
            boolean result = loginDao.validate(loginBean);
            if (result) {
                session.setAttribute("username", email);
                RequestDispatcher dispatcher = req.getRequestDispatcher("DAdminservlet");
                dispatcher.forward(req,res);
            } else {
                 String issue = "Email or password Incorrect , PLease Try Again !";
                 req.setAttribute("issue",issue);
                RequestDispatcher dispatcher = req.getRequestDispatcher("AdminLogin.jsp");
                dispatcher.forward(req,res);
            }
        }catch (Exception e){
            System.out.println("Exception on ADmin Servlet"+e.getMessage());
            e.printStackTrace();
        }
    }
}
