package com.example.demo2.controller.student;

import com.example.demo2.StudetDao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Delete")
public class Delete extends HttpServlet {
    StudentDaoImpl studentDao;
    public void init(){
        this.studentDao = new StudentDaoImpl();
    }
 public void service(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
    int code = Integer.parseInt(request.getParameter("id"));
    studentDao.deleteStudent(code);
    response.sendRedirect("Dservlet");
 }
}
