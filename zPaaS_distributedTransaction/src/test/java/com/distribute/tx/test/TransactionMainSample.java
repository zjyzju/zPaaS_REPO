package com.distribute.tx.test;

import java.util.ArrayList;

import net.sf.json.JSONObject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionTemplate;

import com.distribute.tx.test.dao.CustDAO;
import com.distribute.tx.test.vo.Cust;
import com.zpaas.db.sequence.Sequence;
import com.zpaas.dtx.common.TransactionCallback;
import com.zpaas.dtx.common.TransactionContext;
import com.zpaas.dtx.common.TransactionStatus;
import com.zpaas.dtx.eventual.TransactionManager;

public class TransactionMainSample {
	
	public static void main(String args[]) {
		int threadNum = 1;
		int count = 50;
		if(args.length >=2) {
			threadNum = Integer.valueOf(args[0]);
			count = Integer.valueOf(args[1]);
		}
		final int thaa = count;
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "txContext.xml" });
		final TransactionManager manager = (TransactionManager)ctx.getBean("transactionManager1");
		final TransactionTemplate tt = (TransactionTemplate)ctx.getBean("transactionTemplate");
		final Sequence custSeq = (Sequence)ctx.getBean("cust_id_seq");
		final CustDAO custDao  = (CustDAO)ctx.getBean("custDao");
		long start = System.currentTimeMillis();
		ArrayList<Thread> list = new ArrayList<Thread>();
		
		try {
			for(int j=0; j<threadNum; j++) {
				Thread th = new Thread() {
					@Override
					public void run() {
						for(int i=0;i<thaa; i++){
							System.out.println(i);
							final Cust cust = new Cust();
							cust.setCustId(custSeq.nextValue());
							cust.setName("name:" + cust.getCustId());
							cust.setCertCode("111111");
							cust.setCertType("1");
							TransactionContext txMsg = new TransactionContext();
							txMsg.setContent(JSONObject.fromObject(cust).toString());
							txMsg.setName("business-topic");
							final int count = i;
							try {
								System.out.println(manager.startTransaction(txMsg, new TransactionCallback() {
									
									@Override
									public Object doInTransaction(TransactionStatus status) {
										if(count%4 == 1) {
											throw new RuntimeException();
										}
										Object ret = tt.execute(new org.springframework.transaction.support.TransactionCallback<Object>() {
											
											@Override
											public Object doInTransaction(
													org.springframework.transaction.TransactionStatus paramTransactionStatus) {
												return custDao.insert(cust);											
											}
										});
										if(count%4 == 2) {
											throw new RuntimeException();
										}
										if (ret != null && ((Boolean)ret)) {
											System.out.println("succeed");
											return true;
										}else {
											System.out.println("failed");
											status.setRollbackOnly();
											return false;
										}
									}
								}));
							} catch (RuntimeException e) {
								e.printStackTrace();
							}
//							try {
//								Thread.sleep(2);
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
						}
					}
				};
				list.add(th);
				th.start();
			}
			for(Thread th : list) {
				try {
					th.join();
				} catch (Exception e) {
					
				}
			}
			System.out.println("cost:" + (System.currentTimeMillis()-start));
			while(true) {
				Thread.sleep(10000);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			
		}
	}
	
}
