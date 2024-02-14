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
        String insertingQuery = "INSERT INTO student (name,age,school) VALUES (?,?,?);";
       try {
           PreparedStatement inserting = conn.prepareStatement(insertingQuery);
           inserting.setString(1,s1.getName());
           inserting.setInt(2,s1.getAge());
           inserting.setString(3,s1.getSchool());
           inserting.executeUpdate();
           System.out.println(" successfully created ");
       }catch (Exception e){
           System.out.println("qwweeww"+e.getMessage());
           e.printStackTrace();
       }
    }

    @Override
    public void UpdateStudent(Student s1) {
       String sql = " UPDATE student SET name = ?,age = ?, school = ? where code = ?;";
       try(Connection conn = u.getConn()){
           PreparedStatement updating  = conn.prepareStatement(sql);
           updating.setString(1, s1.getName());
           updating.setInt(2,s1.getAge());
           updating.setString(3, s1.getSchool());
           updating.setInt(4,s1.getId());
           updating.executeUpdate();
           System.out.println("Successfully Updated !");
       }catch (Exception e){
           System.out.println("Problem in Updating " + e.getMessage());
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
    public Student selectStudent(int id) {
        Connection conn = null;
        conn = u.getConn();
        String sql ="select * from student where code = ?;";
        Student student = new Student();
        try {
            PreparedStatement selectStudent = conn.prepareStatement(sql);
            selectStudent.setInt(1,id);
            ResultSet sr =  selectStudent.executeQuery();
            int code;
            String name;
            int age;
            String school;
            System.out.println("we are to fecth !");
            while (sr.next()){
                code = sr.getInt(1);
                student.setId(code);
                name = sr.getString(2);
                student.setName(name);
                age = sr.getInt(3);
                student.setAge(age);
                school = sr.getString(4);
                student.setSchool(school);
            }

            System.out.println("successfully selected !");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return student;
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
