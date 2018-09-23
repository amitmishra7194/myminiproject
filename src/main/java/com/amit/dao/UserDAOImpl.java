package com.amit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amit.bo.UserBO;

@Repository
public class UserDAOImpl implements UserDAO {
	private static final String USER_VALIDATE_QUARY = "SELECT count(*) FROM USERLIST WHERE UNAME=? and PWD=?";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int validate(UserBO bo) {
		int count = 0;
		count = jt.queryForObject(USER_VALIDATE_QUARY, Integer.class, bo.getUser(), bo.getPwd());
		return count;
	}

}
