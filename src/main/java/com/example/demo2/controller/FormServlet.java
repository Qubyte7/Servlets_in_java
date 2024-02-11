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

@WebServlet(name = "FormServlet", value = "/form")
public class FormServlet extends HttpServlet {
    StudentDaoImpl studentDao;
    public void init(){this.studentDao = new StudentDaoImpl();}

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String school = req.getParameter("school");
            Student student1 = new Student(id,name,age,school);
            System.out.println("Are we doing something 11 ! 🙊");
            studentDao.RegisterStudent(student1);
        System.out.println("Are we doing something 12 ! 🙊");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/Dservlet");
            dispatcher.forward(req, res);


    }
}

