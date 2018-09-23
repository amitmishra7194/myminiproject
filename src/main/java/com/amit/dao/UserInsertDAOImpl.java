package com.amit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amit.bo.UserInsertBO;
@Repository
public class UserInsertDAOImpl implements UserInsertDAO {

	private static final String INSERT_USER_QUERY="INSERT INTO USER_DETAILS VALUES(?,?,?,?,?,?,?,?)";
	private static final String INSERT_USER_PWD_QUERY="INSERT INTO USERLIST VALUES(?,?)";
	@Autowired
	private JdbcTemplate jt;
	@Override
	public int insertUser(UserInsertBO bo) {
	  int count_userDetails=0;
	  int count_userlist=0;
	  count_userDetails=jt.update(INSERT_USER_QUERY, 
			                      bo.getUserId(),
			                      bo.getName(),
			                      bo.getAge(),
			                      bo.getEmail(),
			                      bo.getCity(),
			                      bo.getState(),
			                      bo.getMobile(),
			                      bo.getPassword());
	  count_userlist=jt.update(INSERT_USER_PWD_QUERY, bo.getUserId(),bo.getPassword());
		if(count_userDetails==count_userlist)
	       return count_userDetails;
		else
			return 0;
	}

}
