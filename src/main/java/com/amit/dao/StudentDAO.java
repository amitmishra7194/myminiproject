package com.amit.dao;

import java.util.List;

import com.amit.bo.StudentBO;
import com.amit.bo.StudentResultBO;


public interface StudentDAO {
     public List<StudentBO> searchStudents();
     public int insert(StudentBO bo);
     public StudentBO getStudentBySid(int no);
     public int modifyStudentByNo(StudentBO bo);
     public int deleteStudentByNo(int no);
     public List<StudentResultBO>searchStudent(StudentBO bo);
}
