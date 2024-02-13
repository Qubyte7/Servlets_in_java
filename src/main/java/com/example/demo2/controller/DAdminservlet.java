package com.example.demo2.controller;

import com.example.demo2.StudetDao.Student;
import com.example.demo2.StudetDao.StudentDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DAdminservlet")
public class DAdminservlet extends HttpServlet {
    private String message;
    StudentDaoImpl studentDao;
    public void init(){
        this.studentDao  = new StudentDaoImpl();
    }
    public  void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        List<Student> students  = studentDao.selectAllStudent();
        req.setAttribute("students", students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
        dispatcher.forward(req, res);
    }

    public void destroy() {
    }
}