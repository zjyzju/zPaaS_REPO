package com.distribute.tx.test;

import net.sf.json.JSONObject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribute.tx.test.vo.Cust;
import com.zpaas.db.sequence.Sequence;
import com.zpaas.dtx.assured.AssuredTransactionManager;

public class AssureTransactionTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "assuredTransactionContext.xml" });
		AssuredTransactionManager sampleTransaction = (AssuredTransactionManager)ctx.getBean("sampleTransaction");
		final Sequence custSeq = (Sequence)ctx.getBean("cust_id_seq");
		Cust cust = new Cust();
		cust.setCustId(custSeq.nextValue());
		cust.setName("assured tx:" + cust.getCustId());
		cust.setCertCode("111111");
		cust.setCertType("1");
		sampleTransaction.execute(JSONObject.fromObject(cust));
	}
}
