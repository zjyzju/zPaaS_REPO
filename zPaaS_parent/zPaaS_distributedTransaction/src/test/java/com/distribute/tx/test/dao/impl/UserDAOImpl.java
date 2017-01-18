package com.distribute.tx.test.dao.impl;


import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.distribute.tx.test.dao.UserDAO;
import com.distribute.tx.test.vo.User;

public class UserDAOImpl extends SqlMapClientDaoSupport implements
		UserDAO {

	@Override
	public boolean insert(User record) {
		this.getSqlMapClientTemplate().insert("user.insert", record);
		return true;
	}
	
	
}