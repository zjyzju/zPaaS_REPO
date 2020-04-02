package com.zpaas.distributedDb;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zpaas.db.sequence.Sequence;



public class Test extends Thread{
	public static void main(String[] args) throws Exception{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] {"sequenceContext.xml"});
		Sequence custIdSeq = (Sequence) ctx.getBean("cust_id_seq");
		long id = custIdSeq.nextValue();
		System.out.println("get sequence:" + id);
		ctx.close();
	}
}
