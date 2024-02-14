package com.example.demo2.StudetDao;

import java.util.List;

public interface StudentDao {
    boolean isStudentAlreadyRegistered(int id) throws Exception;
    void RegisterStudent(Student s1);
    void UpdateStudent(Student s1);
    void deleteStudent(int id);
    Student selectStudent(int id);
    List<Student> selectAllStudent();
}
