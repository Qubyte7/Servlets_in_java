package com.example.demo2.controller.Admin;

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

@WebServlet("/Adminlogin")
public class login extends HttpServlet {
    UserImpl user;
    LoginDao loginDao;
    public void init(){
        this.user = new UserImpl();
        this.loginDao = new LoginDao();

    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(email);
        loginBean.setPassword(password);
        HttpSession session = req.getSession(true);

        try {
            boolean result = loginDao.validate(loginBean);
            if (result) {
                session.setAttribute("username", email);
                res.sendRedirect("DAdminservlet");
            } else {

                 String issue = "Email or password Incorrect , PLease Try Again !";
                 req.setAttribute("issue",issue);
                res.sendRedirect("AdminLogin.jsp");
            }
        }catch (Exception e){
            System.out.println("Exception on ADmin Servlet"+e.getMessage());
            e.printStackTrace();
        }
    }
}
