package com.distribute.tx.test.dao;

import com.distribute.tx.test.vo.Cust;

public interface CustDAO {

	public boolean insert(Cust record);
	public Cust queryById(Long custId);
	
}