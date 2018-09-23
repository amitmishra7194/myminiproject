package com.amit.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amit.bo.EmployeeBO;
import com.amit.bo.EmployeeResultBO;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String RETRIVE_EMPS_QUERY = "SELECT EID,ENAME,AGE,ADDRESS,DEPARTMENT,CITY,STATE,PINCODE FROM MVC_EMPLOYEES";
	private static final String INSERT_EMP_QUERY = "INSERT INTO MVC_EMPLOYEES VALUES(?,?,?,?,?,?,?,?)";
	private static final String RETRIVE_EMPS_BY_NO = "SELECT EID,ENAME,AGE,ADDRESS,DEPARTMENT,CITY,STATE,PINCODE FROM MVC_EMPLOYEES WHERE EID=?";
	private static final String MODIFY_EMPS_QUERY = "UPDATE MVC_EMPLOYEES SET ENAME=?,AGE=?,ADDRESS=?,DEPARTMENT=?,CITY=?,STATE=?,PINCODE=? WHERE EID=?";
	private static final String DELETE_EMP_QUERY = "DELETE FROM MVC_EMPLOYEES WHERE EID=?";

	private static final String EMP_SEARCH_QUERY = "SELECT EID,ENAME,AGE,ADDRESS,DEPARTMENT,CITY,STATE,PINCODE FROM MVC_EMPLOYEES"
			+ " WHERE(EID is not null and EID=?)" + "OR(ENAME is not null and ENAME LIKE ?)"
			+ "OR(AGE is not null and AGE=?)" + "OR(ADDRESS is not null and ADDRESS LIKE ?)"
			+ "OR(DEPARTMENT is not null and DEPARTMENT LIKE ?)" + "OR(CITY is not null and CITY LIKE ?)"
			+ "OR(STATE is not null and STATE LIKE ?)" + "OR(PINCODE is not null and PINCODE=?)";

	@Autowired
	private JdbcTemplate jt;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<EmployeeBO> searchEmployees() {
		List<EmployeeBO> listEmployeeBO = null;
		listEmployeeBO = new ArrayList<EmployeeBO>();
		// excute quary
		listEmployeeBO = (List<EmployeeBO>) jt.query(RETRIVE_EMPS_QUERY, rs -> {
			List<EmployeeBO> listEmployeeBO1 = null;
			listEmployeeBO1 = new ArrayList();
			EmployeeBO bo = null;
			while (rs.next()) {
				bo = new EmployeeBO();
				bo.setEid(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setAge(rs.getInt(3));
				bo.setAddress(rs.getString(4));
				bo.setDepartment(rs.getString(5));
				bo.setCity(rs.getString(6));
				bo.setState(rs.getString(7));
				bo.setPincode(rs.getInt(8));
				// add bo to listEmployeeBO1
				listEmployeeBO1.add(bo);
			}
			return listEmployeeBO1;
		});
		return listEmployeeBO;
	}// method

	@Override
	public int insert(EmployeeBO bo) {
		int count = 0;
		count = jt.update(INSERT_EMP_QUERY, bo.getEid(), bo.getEname(), bo.getAge(), bo.getAddress(),
				bo.getDepartment(), bo.getCity(), bo.getState(), bo.getPincode());
		return count;
	}

	@Override
	public int modifyEmployeeByNo(EmployeeBO bo) {
		int count = 0;
		count = jt.update(MODIFY_EMPS_QUERY, bo.getEname(), bo.getAge(), bo.getAddress(), bo.getDepartment(),
				bo.getCity(), bo.getState(), bo.getPincode(), bo.getEid());
		return count;
	}

	@Override
	public EmployeeBO getEmployeeByEid(int no) {
		EmployeeBO bo = null;
		bo = jt.queryForObject(RETRIVE_EMPS_BY_NO, (rs, index) -> {
			EmployeeBO empBO = null;
			empBO = new EmployeeBO();
			empBO.setEid(rs.getInt(1));
			empBO.setEname(rs.getString(2));
			empBO.setAge(rs.getInt(3));
			empBO.setAddress(rs.getString(4));
			empBO.setDepartment(rs.getString(5));
			empBO.setCity(rs.getString(6));
			empBO.setState(rs.getString(7));
			empBO.setPincode(rs.getInt(8));
			return empBO;
		}, no);
		return bo;
	}

	@Override
	public int deleteEmployeeByNo(int no) {
		int count = 0;
		count = jt.update(DELETE_EMP_QUERY, no);
		return count;
	}

	@Override
	public List<EmployeeResultBO> searchEmployee(EmployeeBO bo) {
		List<EmployeeResultBO> listRBO = new ArrayList<>();
		listRBO = jt.query(EMP_SEARCH_QUERY, rs -> {
			List<EmployeeResultBO> listRBO1 = new ArrayList<>();
			while (rs.next()) {
				EmployeeResultBO empBO = new EmployeeResultBO();
				empBO.setEid(rs.getInt(1));
				empBO.setEname(rs.getString(2));
				empBO.setAge(rs.getInt(3));
				empBO.setAddress(rs.getString(4));
				empBO.setDepartment(rs.getString(5));
				empBO.setCity(rs.getString(6));
				empBO.setState(rs.getString(7));
				empBO.setPincode(rs.getInt(8));

				listRBO1.add(empBO);
			}
			return listRBO1;
		}, bo.getEid(), bo.getEname(), bo.getAge(), bo.getAddress(), bo.getDepartment(), bo.getCity(), bo.getState(),
				bo.getPincode());
		return listRBO;
	}

}
