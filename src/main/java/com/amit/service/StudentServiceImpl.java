package com.amit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.bo.StudentBO;
import com.amit.bo.StudentResultBO;
import com.amit.dao.StudentDAO;
import com.amit.dto.StudentDTO;
import com.amit.dto.StudentResultDTO;
@Service
public class StudentServiceImpl implements StudentService {
       
	@Autowired
	private StudentDAO dao;


	@Override
	public List<StudentDTO> fetchStudents() {
		final List<StudentDTO> listStudentDTO = new ArrayList<>();

		List<StudentBO> listStudentBO = null;
		listStudentBO = dao.searchStudents();
		listStudentBO.forEach(bo -> {
			StudentDTO dto = null;
			dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			listStudentDTO.add(dto);
		});
		return listStudentDTO;
	}

	@Override
	public String registerStudent(StudentDTO dto) {
		int result = 0;
		StudentBO bo = null;
		bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		result = dao.insert(bo);
		if (result == 0)
			return "Student Registration Fail";
		else
			return "Student Registration Success";
	}

	@Override
	public StudentDTO fetchStudentByNo(int no) {
		StudentBO bo = null;
		StudentDTO dto = null;
		bo = dao.getStudentBySid(no);
		dto = new StudentDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public String updateStudentData(StudentDTO dto) {
		int result = 0;
		StudentBO bo = null;
		bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		result = dao.modifyStudentByNo(bo);
		if (result == 0)
			return "Student Details Not Updated";
		else
			return "Student Details Updated";

	}

	@Override
	public String removeStudentByNo(int no) {
		int result = 0;
		result = dao.deleteStudentByNo(no);
		if (result == 0)
			return no + " Student Not Deleted";
		else
			return no + " Student  Deleted";
	}

	@Override
	public List<StudentResultDTO> processSearchStudent(StudentDTO dto) {
		List<StudentResultBO> listRBO = null;
		List<StudentResultDTO> listRDTO = null;
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		// use dao
		listRBO = dao.searchStudent(bo);
		listRDTO = new ArrayList<>();
		for (StudentResultBO rbo : listRBO) {
			StudentResultDTO rdto = new StudentResultDTO();
			BeanUtils.copyProperties(rbo, rdto);
			listRDTO.add(rdto);
		} // for
		return listRDTO;
	}

}
