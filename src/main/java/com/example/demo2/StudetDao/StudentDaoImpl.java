package com.example.demo2.StudetDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    Utils u = new Utils();
    @Override
    public  void RegisterStudent(Student s1){
        Connection conn = null;
        try {
            conn = u.getConn();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
           System.out.println(e.getMessage());
           e.printStackTrace();
       }
    }


    @Override
    public void UpdateStudent(Student s1) {
        Connection conn = null;
        try {
            conn = u.getConn();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    String sql = " UPDATE student SET name=? ,age=?,school= ? where code = ?;";
    try{
        PreparedStatement updating =conn.prepareStatement(sql);
        updating.setString(1,s1.getName());
        updating.setInt(2,s1.getAge());
        updating.setString(3,s1.getSchool());
        updating.setInt(4,s1.getId());
        updating.executeUpdate();
        System.out.println("successfully Updated !");
    }catch (Exception e){}
    }

    @Override
    public void deleteStudent(int id) {
        Connection conn = null;
        try {
            conn = u.getConn();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        try {
            conn = u.getConn();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        try {
            conn = u.getConn();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try{
            PreparedStatement select = conn.prepareStatement(sql);
            ResultSet sr = select.executeQuery();

            while(sr.next()){
                int  code = sr.getInt(1);
                String name = sr.getString(2);
                int age = sr.getInt(3);
                String school = sr.getString(4);
                students.add(new Student(code, name, age, school));
            }

            System.out.println("succesfully selected all student !");

        }catch (Exception e){
            System.out.println("WE ARE HAVING A TINY Component : "+e.getMessage());
        }
        return students;

    }
}
