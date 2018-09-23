package com.amit.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amit.bo.CustomerBO;
import com.amit.bo.CustomerResultBO;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	private static final String RETRIVE_CUSTS_QUERY = "SELECT CID,CNAME,CAGE,ADDRESS,CITY,STATE,PINCODE FROM MVC_CUSTOMERS";
	private static final String INSERT_CUSTS_QUERY = "INSERT INTO MVC_CUSTOMERS VALUES(?,?,?,?,?,?,?)";
	private static final String RETRIVE_CUSTS_BY_NO = "SELECT CID,CNAME,CAGE,ADDRESS,CITY,STATE,PINCODE FROM MVC_CUSTOMERS WHERE CID=?";
	private static final String MODIFY_CUSTS_QUERY = "UPDATE MVC_CUSTOMERS SET CNAME=?,CAGE=?,ADDRESS=?,CITY=?,STATE=?,PINCODE=? WHERE CID=?";
	private static final String DELETE_CUST_QUERY = "DELETE FROM MVC_CUSTOMERS WHERE CID=?";
    
	private static final String CUSTOMER_SEARCH_QUERY = "SELECT CID,CNAME,CAGE,ADDRESS,CITY,STATE,PINCODE FROM MVC_CUSTOMERS"
			+ " WHERE(CID is not null and CID=?)" 
			+ "OR(CNAME is not null and CNAME LIKE ?)"
			+ "OR(CAGE is not null and CAGE=?)" 
			+ "OR(ADDRESS is not null and ADDRESS LIKE ?)"
			+ "OR(CITY is not null and CITY LIKE ?)"
			+ "OR(STATE is not null and STATE LIKE ?)" 
			+ "OR(PINCODE is not null and PINCODE=?)";

	
	
	@Autowired
	private JdbcTemplate jt;


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CustomerBO>searchCustomers() {
		List<CustomerBO> listCustomerBO = null;
		listCustomerBO = new ArrayList<CustomerBO>();
		// excute quary
		listCustomerBO = (List<CustomerBO>) jt.query(RETRIVE_CUSTS_QUERY, rs -> {
			List<CustomerBO> listCustomerBO1 = null;
			listCustomerBO1 = new ArrayList();
			CustomerBO bo = null;
			while (rs.next()) {
				bo = new CustomerBO();
				bo.setCid(rs.getInt(1));
				bo.setCname(rs.getString(2));
				bo.setCage(rs.getInt(3));
				bo.setAddress(rs.getString(4));
				bo.setCity(rs.getString(5));
				bo.setState(rs.getString(6));
				bo.setPincode(rs.getInt(7));
				// add bo to listEmployeeBO1
				listCustomerBO1.add(bo);
			}
			return listCustomerBO1;
		});
		return listCustomerBO;
	}// method

	@Override
	public int insert(CustomerBO bo) {
		int count = 0;
		count = jt.update(INSERT_CUSTS_QUERY, bo.getCid(), bo.getCname(), bo.getCage(), bo.getAddress(),
				 bo.getCity(), bo.getState(), bo.getPincode());
		return count;
	}
	
	@Override
	public int modifyCustomerByNo(CustomerBO bo) {
          int count=0;
          count=jt.update(MODIFY_CUSTS_QUERY, bo.getCname(),bo.getCage(),bo.getAddress(),bo.getCity(),bo.getState(),bo.getPincode(),bo.getCid());
		return count;
	}

	@Override
	public CustomerBO getCustomerByCid(int no) {
		CustomerBO bo=null;
	  bo=jt.queryForObject(RETRIVE_CUSTS_BY_NO,(rs,index)->{
		  CustomerBO custBO=null;
		  custBO=new CustomerBO();
		  custBO.setCid(rs.getInt(1));
		  custBO.setCname(rs.getString(2));
		  custBO.setCage(rs.getInt(3));
		  custBO.setAddress(rs.getString(4));
		  custBO.setCity(rs.getString(5));
		  custBO.setState(rs.getString(6));
		  custBO.setPincode(rs.getInt(7));
		  return custBO;
	  },no);
		return bo;
	}
	
	@Override
	public int deleteCustomerByNo(int no) {
		int count=0;
		count=jt.update(DELETE_CUST_QUERY, no);
		return count;
	}

	@Override
	public List<CustomerResultBO> searchCustomer(CustomerBO bo) {
		List<CustomerResultBO> listRBO = new ArrayList<>();
		listRBO = jt.query(CUSTOMER_SEARCH_QUERY, rs -> {
			List<CustomerResultBO> listRBO1 = new ArrayList<>();
			while (rs.next()) {
				CustomerResultBO custBO = new CustomerResultBO();
				custBO.setCid(rs.getInt(1));
				custBO.setCname(rs.getString(2));
				custBO.setCage(rs.getInt(3));
				custBO.setAddress(rs.getString(4));
				custBO.setCity(rs.getString(5));
				custBO.setState(rs.getString(6));
				custBO.setPincode(rs.getInt(7));

				listRBO1.add(custBO);
			}
			return listRBO1;
		}, bo.getCid(), bo.getCname(), bo.getCage(), bo.getAddress(), bo.getCity(), bo.getState(),
				bo.getPincode());
		return listRBO;
	}
}
