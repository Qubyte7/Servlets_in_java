package com.example.demo2.controller.user;

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

@WebServlet("/login")
public class login extends HttpServlet {
    UserImpl user;
    LoginDao loginDao;
    HashPassword hashPassword;
    public void init(){
        this.user = new UserImpl();
        this.loginDao = new LoginDao();
        this.hashPassword = new HashPassword();

    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String HashedPassword = hashPassword.dohashing(password);
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(email);
        loginBean.setPassword(HashedPassword);
        try {
            boolean result = loginDao.validate(loginBean);
            HttpSession session = req.getSession();
            if (result) {
                System.out.println("Looged succusfully");
                session.setAttribute("username",email);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/DuserServlet");
                dispatcher.forward(req, res);
            } else {
                String issue = "Email or password Incorrect , PLease Try Again !";
                req.setAttribute("issue",issue);
                RequestDispatcher dispatcher = req.getRequestDispatcher("Userlogin.jsp");
                dispatcher.forward(req,res);
            }
        }catch (Exception e){
            System.out.println("Exception on guest Servlet"+e.getMessage());
            e.printStackTrace();
        }

    }
}
