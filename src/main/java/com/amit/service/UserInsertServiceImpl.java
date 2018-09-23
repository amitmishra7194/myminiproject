package com.amit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.bo.UserInsertBO;
import com.amit.dao.UserInsertDAO;
import com.amit.dto.UserInsertDTO;
@Service
public class UserInsertServiceImpl implements UserInsertService {

	@Autowired
	private UserInsertDAO dao;

	@Override
	public String registerUser(UserInsertDTO dto) {
		int result = 0;
		UserInsertBO bo = null;
		bo = new UserInsertBO();
		BeanUtils.copyProperties(dto, bo);
		result = dao.insertUser(bo);
		if (result != 0)
			return "Registration Successful";
		else
			return "Registration fail";
	}

}
