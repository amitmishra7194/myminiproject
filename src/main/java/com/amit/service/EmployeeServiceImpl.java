package com.amit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.bo.EmployeeBO;
import com.amit.bo.EmployeeResultBO;
import com.amit.dao.EmployeeDAO;
import com.amit.dto.EmployeeDTO;
import com.amit.dto.EmployeeResultDTO;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO dao;

	@Override
	public List<EmployeeDTO> fetchEmployees() {
		List<EmployeeBO> listEmployeeBO = null;
		final List<EmployeeDTO> listEmployeeDTO = new ArrayList<>();

		listEmployeeBO = dao.searchEmployees();
		listEmployeeBO.forEach(bo -> {
			EmployeeDTO dto = null;
			dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			listEmployeeDTO.add(dto);
		});
		return listEmployeeDTO;
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) {
		int result = 0;
		EmployeeBO bo = null;
		// prepare EmployeeBO obj
		bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		// use dao
		result = dao.insert(bo);
		if (result == 0)
			return "Employee Registration Fail";
		else
			return "Employee Registration Success";
	}

	@Override
	public String updateEmployeeData(EmployeeDTO dto) {
		int result = 0;
		EmployeeBO bo = null;
		bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		result = dao.modifyEmployeeByNo(bo);
		if (result == 0)
			return "Employee Details Not Updated";
		else
			return "Employee Details Updated";
	}
	
	@Override
	public EmployeeDTO fetchEmployeeByNo(int no) {
	    EmployeeBO bo=null;
	    EmployeeDTO dto=null;
	    bo=dao.getEmployeeByEid(no);
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
	    return dto;
	}
	
	@Override
	public String removeEmployeeByNo(int no) {
	    int result=0;
	    //use DAO
	    result=dao.deleteEmployeeByNo(no);
		if(result==0)
	    return no+" Employee Not Deleted";
		else
			return no+" Employee Deleted";
	}

	@Override
	public List<EmployeeResultDTO> process(EmployeeDTO dto) {
		List<EmployeeResultBO> listRBO = null;
		List<EmployeeResultDTO> listRDTO = null;
		EmployeeBO bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		// use dao
		listRBO = dao.searchEmployee(bo);
		listRDTO = new ArrayList<>();
		for (EmployeeResultBO rbo : listRBO) {
			EmployeeResultDTO rdto = new EmployeeResultDTO();
			BeanUtils.copyProperties(rbo, rdto);
			listRDTO.add(rdto);
		} // for
		return listRDTO;

	}
	
	
}
