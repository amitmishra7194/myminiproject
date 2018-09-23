package com.amit.bo;

public class EmployeeBO {
    
	 private int eid;                                      
	 private String ename;                                 
	 private int age;                                     
	 private String address;                                      
	 private String department;                                      
	 private String city;                                           
	 private String state;                                             
	 private int pincode;
	 public EmployeeBO(int eid, String ename, int age, String address, String department, String city, String state,
				int pincode) {
		
			this.eid = eid;
			this.ename = ename;
			this.age = age;
			this.address = address;
			this.department = department;
			this.city = city;
			this.state = state;
			this.pincode = pincode;
		}
	 
	 public EmployeeBO() {
	 
	 }
	 
	 public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
