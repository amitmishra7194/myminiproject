package com.amit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.bo.CustomerBO;
import com.amit.bo.CustomerResultBO;
import com.amit.dao.CustomerDAO;
import com.amit.dto.CustomerDTO;
import com.amit.dto.CustomerResultDTO;


@Service
public class CustomersServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO dao;

	

	@Override
	public List<CustomerDTO> fetchCustomers() {
		List<CustomerBO> listCustomerBO = null;
		final List<CustomerDTO> listCustomerDTO = new ArrayList<>();

		listCustomerBO = dao.searchCustomers();
		listCustomerBO.forEach(bo -> {
			CustomerDTO dto = null;
			dto = new CustomerDTO();
			BeanUtils.copyProperties(bo, dto);
			listCustomerDTO.add(dto);
		});
		return listCustomerDTO;
	}

	@Override
	public String registerCustomer(CustomerDTO dto) {
		int result = 0;
		CustomerBO bo = null;
		// prepare CustomerBO obj
		bo = new CustomerBO();
		BeanUtils.copyProperties(dto, bo);
		// use dao
		result = dao.insert(bo);
		if (result == 0)
			return "Customer Registration Fail";
		else
			return "Customer Registration Success";
	}
	
	  @Override 
	  public String updateCustomerData(CustomerDTO dto) { 
		  int result= 0; 
		  CustomerBO bo = null; 
		  bo = new CustomerBO();
	  BeanUtils.copyProperties(dto, bo); 
	  result = dao.modifyCustomerByNo(bo);
	  if (result == 0) 
		  return "Customer Details Not Updated"; 
	  else 
		  return "Customer Details Updated"; }
	 
	  @Override 
	  public CustomerDTO fetchCustomerByNo(int no) { 
		  CustomerBO bo=null; 
		  CustomerDTO dto=null; 
		  bo=dao.getCustomerByCid(no); 
		  dto=new CustomerDTO(); 
		  BeanUtils.copyProperties(bo, dto); 
		  return dto; 
		  }
	 
	  @Override 
	  public String removeCustomerByNo(int no) { 
		  int result=0; 
		  //useDAO 
		  result=dao.deleteCustomerByNo(no); 
	  if(result==0) 
		  return no+" Customer Not Deleted"; 
	  else 
		  return no+" Customer Deleted"; 
	  }

	@Override
	public List<CustomerResultDTO> processSearchCustomer(CustomerDTO dto) {
		List<CustomerResultBO> listRBO = null;
		List<CustomerResultDTO> listRDTO = null;
		CustomerBO bo = new CustomerBO();
		BeanUtils.copyProperties(dto, bo);
		// use dao
		listRBO = dao.searchCustomer(bo);
		listRDTO = new ArrayList<>();
		for (CustomerResultBO rbo : listRBO) {
			CustomerResultDTO rdto = new CustomerResultDTO();
			BeanUtils.copyProperties(rbo, rdto);
			listRDTO.add(rdto);
		} // for
		return listRDTO;

	}
	 }
