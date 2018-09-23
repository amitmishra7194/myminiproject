package com.amit.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.amit.bo.StudentBO;
import com.amit.bo.StudentResultBO;
@Repository
public class StudentDAOImpl implements StudentDAO {
	private static final String RETRIVE_STUDENT_QUERY = "SELECT SID,SNAME,SAGE,ADDRESS,COURSE,CITY,STATE,PINCODE FROM MVC_STUDENTS";
	private static final String INSERT_STUDENT_QUERY = "INSERT INTO MVC_STUDENTS VALUES(?,?,?,?,?,?,?,?)";
	private static final String RETRIVE_STUDS_BY_NO = "SELECT SID,SNAME,SAGE,ADDRESS,COURSE,CITY,STATE,PINCODE FROM MVC_STUDENTS WHERE SID=?";
	private static final String MODIFY_STUDS_QUERY = "UPDATE MVC_STUDENTS SET SNAME=?,SAGE=?,ADDRESS=?,COURSE=?,CITY=?,STATE=?,PINCODE=? WHERE SID=?";
	private static final String DELETE_STUD_QUERY = "DELETE FROM MVC_STUDENTS WHERE SID=?";
	
	private static final String STUDENT_SEARCH_QUERY = "SELECT SID,SNAME,SAGE,ADDRESS,COURSE,CITY,STATE,PINCODE FROM MVC_STUDENTS"
			+ " WHERE(SID is not null and SID=?)" + "OR(SNAME is not null and SNAME LIKE ?)"
			+ "OR(SAGE is not null and SAGE=?)" + "OR(ADDRESS is not null and ADDRESS LIKE ?)"
			+ "OR(COURSE is not null and COURSE LIKE ?)" + "OR(CITY is not null and CITY LIKE ?)"
			+ "OR(STATE is not null and STATE LIKE ?)" + "OR(PINCODE is not null and PINCODE=?)";

	
	
	
	@Autowired
	private JdbcTemplate jt;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentBO> searchStudents() {
		List<StudentBO> listStudentBO = null;
		listStudentBO = new ArrayList<>();
		listStudentBO = (List<StudentBO>) jt.query(RETRIVE_STUDENT_QUERY, rs -> {
			@SuppressWarnings("rawtypes")
			List<StudentBO> listStudentBO1 = new ArrayList();
			StudentBO bo = null;
			
			while(rs.next()){
				bo = new StudentBO();
				bo.setSid(rs.getInt(1));
				bo.setSname(rs.getString(2));
				bo.setSage(rs.getInt(3));
				bo.setAddress(rs.getString(4));
				bo.setCourse(rs.getString(5));
				bo.setCity(rs.getString(6));
				bo.setState(rs.getString(7));
				bo.setPincode(rs.getInt(8));
				listStudentBO1.add(bo);
			
			}
			
			return listStudentBO1;
		});
		return listStudentBO;
	}

	@Override
	public int insert(StudentBO bo) {
		int count = 0;
		count = jt.update(INSERT_STUDENT_QUERY, bo.getSid(), bo.getSname(), bo.getSage(), bo.getAddress(),
				bo.getCourse(), bo.getCity(), bo.getState(), bo.getPincode());
		return count;
	}

	@Override
	public StudentBO getStudentBySid(int no) {
		StudentBO bo=null;
		  bo=jt.queryForObject(RETRIVE_STUDS_BY_NO,(rs,index)->{
			  StudentBO studBO=null;
			  studBO=new StudentBO();
			  studBO.setSid(rs.getInt(1));
			  studBO.setSname(rs.getString(2));
			  studBO.setSage(rs.getInt(3));
			  studBO.setAddress(rs.getString(4));
			  studBO.setCourse(rs.getString(5));
			  studBO.setCity(rs.getString(6));
			  studBO.setState(rs.getString(7));
			  studBO.setPincode(rs.getInt(8));
			  return studBO;
		  },no);
			return bo;
	}

	@Override
	public int modifyStudentByNo(StudentBO bo) {
		int count=0;
        count=jt.update(MODIFY_STUDS_QUERY, bo.getSname(),bo.getSage(),bo.getAddress(),bo.getCourse(),bo.getCity(),bo.getState(),bo.getPincode(),bo.getSid());
		return count;
	}

	@Override
	public int deleteStudentByNo(int no) {
            int count=0;
            count=jt.update(DELETE_STUD_QUERY, no);
		return count;
	}

	@Override
	public List<StudentResultBO> searchStudent(StudentBO bo) {
		List<StudentResultBO> listRBO = new ArrayList<>();
		listRBO = jt.query(STUDENT_SEARCH_QUERY, rs -> {
			List<StudentResultBO> listRBO1 = new ArrayList<>();
			while (rs.next()) {
				StudentResultBO studBO = new StudentResultBO();
				studBO.setSid(rs.getInt(1));
				studBO.setSname(rs.getString(2));
				studBO.setSage(rs.getInt(3));
				studBO.setAddress(rs.getString(4));
				studBO.setCourse(rs.getString(5));
				studBO.setCity(rs.getString(6));
				studBO.setState(rs.getString(7));
				studBO.setPincode(rs.getInt(8));

				listRBO1.add(studBO);
			}
			return listRBO1;
		}, bo.getSid(), bo.getSname(), bo.getSage(), bo.getAddress(), bo.getCourse(), bo.getCity(), bo.getState(),
				bo.getPincode());
		return listRBO;
	}

 }

