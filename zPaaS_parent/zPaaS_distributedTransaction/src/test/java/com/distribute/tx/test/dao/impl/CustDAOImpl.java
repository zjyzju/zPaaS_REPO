package com.distribute.tx.test.dao.impl;


import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.distribute.tx.test.dao.CustDAO;
import com.distribute.tx.test.vo.Cust;

public class CustDAOImpl extends SqlMapClientDaoSupport implements
		CustDAO {

	@Override
	public boolean insert(Cust record) {
		this.getSqlMapClientTemplate().insert("cust.insert", record);
		return true;
	}
	
	
	public Cust queryById(Long custId) {
		return (Cust) this.getSqlMapClientTemplate().queryForObject("cust.queryById", custId);
	}
	
	
}