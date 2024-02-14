package com.example.demo2.controller.student;

import com.example.demo2.StudetDao.Student;
import com.example.demo2.StudetDao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

@WebServlet("/updateStudent")
public class Update extends HttpServlet {
    StudentDaoImpl studentDao;
    public void init(){this.studentDao = new StudentDaoImpl();}
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        int code =Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String school= request.getParameter("school");
        Student student1 = new Student(code,name,age,school);
        try{
            studentDao.UpdateStudent(student1);
            response.sendRedirect("Dservlet");
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
