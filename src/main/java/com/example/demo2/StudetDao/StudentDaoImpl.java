package com.example.demo2.StudetDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    Utils u = new Utils();
    @Override
    public boolean isStudentAlreadyRegistered(int id) throws Exception {
        String sql = "SELECT COUNT(*) > 0 AS isavailable FROM student WHERE code = ?";
        Connection conn = null;
        boolean isRegistered = false;

        try {
            conn = u.getConn();
            PreparedStatement selectId = conn.prepareStatement(sql);
            selectId.setInt(1, id);
            ResultSet idSelected = selectId.executeQuery();

            if (idSelected.next()) {
                isRegistered = idSelected.getBoolean("isavailable");
            }
        } finally {
            // Close resources
            if (conn != null) {
                conn.close();
            }
        }
        System.out.println("IS STUDENT ALREADY IN DATABASE "+isRegistered);
        return isRegistered;
    }


    @Override
    public  void RegisterStudent(Student s1){
        Connection conn = null;
        conn = u.getConn();
        String insertingQuery = "INSERT INTO student VALUES (?,?,?,?);";
       try {
           PreparedStatement inserting = conn.prepareStatement(insertingQuery);
           inserting.setInt(1,s1.getId());
           inserting.setString(2,s1.getName());
           inserting.setInt(3,s1.getAge());
           inserting.setString(4,s1.getSchool());
           inserting.executeUpdate();
           System.out.println(" successfully created ");
       }catch (Exception e){
           System.out.println("qwweeww"+e.getMessage());
           e.printStackTrace();
       }
    }


    @Override
    public void deleteStudent(int id) {
        Connection conn = null;
        conn = u.getConn();
        String sql = "DELETE FROM student where code = ?;";
    try{
        PreparedStatement deleting= conn.prepareStatement(sql);
        deleting.setInt(1,id);
        deleting.executeUpdate();
        System.out.println("Student successfully deleted");
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
    }

    @Override
    public void selectStudent(int id) {
        Connection conn = null;
        conn = u.getConn();
        String sql ="SELECT * FROM where code=?;";
        try {
            PreparedStatement selectStudent = conn.prepareStatement(sql);
            selectStudent.setInt(1,id);
            selectStudent.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> students = new ArrayList<>();
        String sql = " SELECT code,name,age,school FROM student;";
        Connection conn = null;
        conn = u.getConn();
        try{
            PreparedStatement select = conn.prepareStatement(sql);
            ResultSet sr = select.executeQuery();

            while(sr.next()){
                int  code = sr.getInt(1);
                String name = sr.getString(2);
                int age = sr.getInt(3);
                String school = sr.getString(4);
                students.add(new Student(code, name, age, school));
                System.out.println(name + " studies at " + school );

            }

            System.out.println("succesfully selected all student !");

        }catch (Exception e){
            System.out.println("WE ARE HAVING A TINY Component : "+e.getMessage());
        }
        return students;

    }
}
