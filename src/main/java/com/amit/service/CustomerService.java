package com.amit.service;

import java.util.List;

import com.amit.dto.CustomerDTO;
import com.amit.dto.CustomerResultDTO;

public interface CustomerService {
  public List<CustomerDTO> fetchCustomers();
  public String registerCustomer(CustomerDTO dto);
  public CustomerDTO fetchCustomerByNo(int no);
  public String updateCustomerData(CustomerDTO dto);
  public String removeCustomerByNo(int no);
  public List<CustomerResultDTO> processSearchCustomer(CustomerDTO dto);
}
