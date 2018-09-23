package com.amit.service;

import java.util.List;

import com.amit.dto.EmployeeDTO;
import com.amit.dto.EmployeeResultDTO;

public interface EmployeeService {
  public List<EmployeeDTO> fetchEmployees();
  public String registerEmployee(EmployeeDTO dto);
  public EmployeeDTO fetchEmployeeByNo(int no);
  public String updateEmployeeData(EmployeeDTO dto);
  public String removeEmployeeByNo(int no);
  public List<EmployeeResultDTO> process(EmployeeDTO dto);
}
