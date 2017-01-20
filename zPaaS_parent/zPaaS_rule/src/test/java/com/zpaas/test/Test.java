package com.zpaas.test;



import com.zpaas.rule.RuleSVC;
import com.zpaas.utils.PaasContextHolder;

public class Test {
	public static void main(String[] args)throws Exception {
		//规则服务
		RuleSVC rule = (RuleSVC) PaasContextHolder.getContext().getBean("zpaasRule");
//		Transaction transaction = new Transaction();
//		transaction.setName("tx");
//		transaction.setParticipantNum(0);
//		transaction.setParticipants("participant01");
//		rule.executeRule(transaction);
//		System.out.println("ruel test 0:" + transaction.getParticipants());
//		transaction.setParticipantNum(1);
//		transaction.setParticipants("participant01");
		rule.executeRule(new Object());
//		System.out.println("ruel test 1:" + transaction.getParticipants());
	}
}
