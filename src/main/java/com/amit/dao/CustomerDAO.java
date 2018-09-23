package com.amit.dao;

import java.util.List;

import com.amit.bo.CustomerBO;
import com.amit.bo.CustomerResultBO;



public interface CustomerDAO {
     public List<CustomerBO> searchCustomers();
     public int insert(CustomerBO bo);
     public CustomerBO getCustomerByCid(int no);
     public int modifyCustomerByNo(CustomerBO bo);
     public int deleteCustomerByNo(int no);
     public List<CustomerResultBO>searchCustomer(CustomerBO bo);
}
