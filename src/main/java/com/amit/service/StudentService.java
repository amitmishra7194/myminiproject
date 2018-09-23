package com.amit.service;

import java.util.List;

import com.amit.dto.StudentDTO;
import com.amit.dto.StudentResultDTO;

public interface StudentService {
  public List<StudentDTO> fetchStudents();
  public String registerStudent(StudentDTO dto);
  public StudentDTO fetchStudentByNo(int no);
  public String updateStudentData(StudentDTO dto);
  public String removeStudentByNo(int no);
  public List<StudentResultDTO> processSearchStudent(StudentDTO dto);
}
