package com.example.demo2.controller.Admin;

import com.example.demo2.HashPassword;
import com.example.demo2.user.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterAdmin")
public class RegisterAdmin extends HttpServlet {
    UserImpl userimpl;
   LoginDao loginDao;
   UserChecking check;
   HashPassword hashPassword;
    public void init(){
        this.loginDao = new LoginDao();
        this.userimpl = new UserImpl();
        this.check = new UserChecking();
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String hashedPassword = HashPassword.dohashing(password);

        User user = new User(name,email,hashedPassword);
        LoginBean alreadyThere = new LoginBean();
        alreadyThere.setUsername(email);
        alreadyThere.setPassword(hashedPassword);
        HttpSession session = req.getSession(true);
try {
    if (check.validate(alreadyThere.getUsername())) {
        String retry = " The user Already exists try by logging In ! ";
        req.setAttribute("retry",retry);
        RequestDispatcher dispatcher = req.getRequestDispatcher("AdminLogin.jsp");
        dispatcher.forward(req,res);
    } else {
        userimpl.RegisterAdmin(user);
        session.setAttribute("username",email);
        res.sendRedirect("AdminLogin.jsp");
    }
}catch (Exception e){
    System.out.println(e.getMessage());
}
    }
}
