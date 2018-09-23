package com.amit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.bo.UserBO;
import com.amit.dao.UserDAO;
import com.amit.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {
  
	@Autowired
	private UserDAO dao;
	
	@Override
	public String verifyUser(UserDTO dto) {
		int result=0;
		UserBO bo=null;
		//convert DTO into BO
		bo=new UserBO();
		BeanUtils.copyProperties(dto, bo);
	//use DAO
		result=dao.validate(bo);
		if(result==0)
		return "Invalid User";
		else 
			return "Valid User";
	}

}
