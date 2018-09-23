package com.amit.dao;

import java.util.List;

import com.amit.bo.EmployeeBO;
import com.amit.bo.EmployeeResultBO;

public interface EmployeeDAO {
     public List<EmployeeBO> searchEmployees();
     public int insert(EmployeeBO bo);
     public EmployeeBO getEmployeeByEid(int no);
     public int modifyEmployeeByNo(EmployeeBO bo);
     public int deleteEmployeeByNo(int no);
     public List<EmployeeResultBO>searchEmployee(EmployeeBO bo);
     
}
