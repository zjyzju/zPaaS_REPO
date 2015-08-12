package com.zpaas.distributedDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zpaas.cache.remote.RemoteCacheSVC;
import com.zpaas.db.common.StringHash;
import com.zpaas.db.distribute.DistributeRuleAssist;
import com.zpaas.db.distribute.DistributedDataSource;
import com.zpaas.db.sequence.Sequence;
import com.zpaas.db.tenant.MultiTenantDataSource;


@SuppressWarnings("unused")
public class Test extends Thread{
	public static void main(String[] args) throws Exception{
//		flushCache();
//		runTestCase();
		System.out.println(new Date(1425121440290l));
		System.out.println(StringHash.valueOf("15108007157")%16 + 1);
		System.out.println(2037001%16 + 1);
	}
	
	public static void flushCache() throws Exception{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] {"distributedDbContext.xml"});
		RemoteCacheSVC cache = (RemoteCacheSVC)ctx.getBean("sqlCache");
		System.out.println(cache.flushDB());
	}
	
	public static void runTestCase() throws Exception{
		long start = System.currentTimeMillis();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] {"distributedDbContext.xml"});
		/*
		 * 测试按模分布的场景-distributedDb层-单表cust
		 * insert-select-update-select-delete
		 */
//		testCase1(ctx);
		
		/*
		 * 测试按区域分布的场景-distributedDb层-单表service_number
		 * insert-select-update-select-delete
		 */
//		testCase2(ctx);
		
		/*
		 * 测试按模分布的场景-multiTenantDb层-单表cust
		 * insert-select-update-select-delete
		 */
//		testCase3(ctx);
		
		/*
		 * 测试按模分布的场景-多租户oneUser1模式-单表cust_tenant
		 * insert-select-update-select-delete
		 */
//		testCase4(ctx);
		
		/*
		 * 测试按模分布的场景-distributedDb层-单表user-组合分区键
		 * insert-select-update-select-delete
		 */
//		testCase5(ctx);
		
		/*
		 * 测试按模分布的场景-distributedDb层-DDL
		 * create
		 */
		testCase6(ctx);
		
		/*
		 * 并发测试场景
		 * testCase1+testCase2
		 */
//		testCaseThread(100, 10);
		
		
		long end = System.currentTimeMillis();
		System.out.println("time cost:" + (end-start));
	}
	
	ClassPathXmlApplicationContext ctx = null;
	int times = 0;
	public Test(ClassPathXmlApplicationContext ctx, int times) {
		this.ctx = ctx;
		this.times = times;
	}
	
	@Override
	public void run() {
		for(int i=0; i<times; i++) {
			
			try {
				testCase1(ctx);
				testCase2(ctx);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.run();
	}
	
	public static void testCaseThread(int threadNum, int times) throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] {"distributedDbContext.xml"});
		Test a = null;
		List<Test> list = new ArrayList<Test>();
		for(int i=0; i<threadNum; i++) {
			a = new Test(ctx, times);
			a.start();
			list.add(a);
		}
		
		for(Test b : list) {
			b.join();
		}
	}
	

	public static void testCase1(ClassPathXmlApplicationContext ctx) throws Exception {
		DistributedDataSource ds = (DistributedDataSource)ctx.getBean("db_cust");
		
		Sequence custIdSeq = (Sequence) ctx.getBean("cust_id_seq");
		long id = custIdSeq.nextValue();
		Connection conn = ds.getConnection();
		String sql = " insert into cust(cust_id,name,cert_type,cert_code) values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.setString(2, "zjy");
		ps.setString(3, "身份证");
		ps.setString(4, "1234567890");
		int ret = ps.executeUpdate();
		System.out.println("insert result:" + ret);
		
		sql = " select * from cust a where a.cust_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
			}
		}
		
		sql = " update cust set name=? where cust_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, "zhangjy");
		ps.setLong(2, id);
		ret = ps.executeUpdate();
		System.out.println("delete result:" + ret);
		
		sql = " select * from cust a where a.cust_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		rs = ps.executeQuery();
		while(rs != null && rs.next()) {
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
			}
		}
		
//		sql = "delete from cust  where cust_id = ?";
//		ps = conn.prepareStatement(sql);
//		ps.setLong(1, id);
//		ret = ps.executeUpdate();
//		System.out.println("delete result:" + ret);
		
	/*	sql = "select * from cust a where a.cust_id > ? and a.cust_id < ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, 15006);
		ps.setInt(2, 15022);
		rs = ps.executeQuery();
		while(rs.next()) {
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
			}
		}
		
		sql = "select b.name, CouNt(*), min(b.cust_id) from cust b group by b.name";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				
				System.out.print(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i) + "| ");
			}
			System.out.print("\n");
		}
		
		sql = "select * from cust b where b.cust_id not in(?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, "1");
		ps.setString(2, "0");
		rs = ps.executeQuery();
		int j=0;
		while(rs.next()) {
			if(j==10) {
				break;
			}
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
			}
			j++;
		}
		
		sql = "select * from cust b where b.name in(select a.name from cust a where a.cust_id > ? and a.cust_id < ?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, 15006);
		ps.setInt(2, 15022);
		rs = ps.executeQuery();
		int k = 0;
		while(rs.next()) {
			if(k==10) {
				break;
			}
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
				
			}
			k++;
		}
		
		sql = " select * from cust a where a.cust_id = 15006 or a.cust_id=15021";
		Statement ss = conn.createStatement();
		rs = ss.executeQuery(sql);
		while(rs.next()) {
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
			}
		}
		*/
		conn.close();
	}
	
	public static void testCase2(ClassPathXmlApplicationContext ctx) throws Exception {
		DistributedDataSource ds = (DistributedDataSource)ctx.getBean("db_cust");
		
		Sequence seq = (Sequence) ctx.getBean("service_number_seq");
		long id1 = seq.nextValue();
		String id = "sn_" + id1;
		Long city_id = 571l;
		Connection conn = ds.getConnection();
		String sql = " insert into service_number(sn,city_id,remark) values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setLong(2, city_id);
		ps.setString(3, "北京号源");
		int ret = ps.executeUpdate();
		System.out.println("insert result:" + ret);
		
		sql = " select * from service_number a where a.sn = ? and a.city_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setLong(2, city_id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
			}
		}
		
		sql = " update service_number set remark=? where sn = ? and city_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, "北京号源-update");
		ps.setString(2, id);
		ps.setLong(3, city_id);
		ret = ps.executeUpdate();
		System.out.println("delete result:" + ret);
		
		sql = " select * from service_number a where a.sn = ? and a.city_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setLong(2, city_id);
		rs = ps.executeQuery();
		while(rs != null && rs.next()) {
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
			}
		}
		
//		sql = "delete from service_number  where sn = ? and city_id = ?";
//		ps = conn.prepareStatement(sql);
//		ps.setString(1, id);
//		ps.setLong(2, city_id);
//		ret = ps.executeUpdate();
//		System.out.println("delete result:" + ret);
		
		conn.close();
	}
	
	public static void testCase3(ClassPathXmlApplicationContext ctx) throws Exception {
		MultiTenantDataSource ds = (MultiTenantDataSource)ctx.getBean("multi_tenant_db");
		
		Sequence custIdSeq = (Sequence) ctx.getBean("cust_id_seq");
		long id = custIdSeq.nextValue();
		DistributeRuleAssist.setTenant("1");
		Connection conn = ds.getConnection();
		String sql = " insert into cust(cust_id,name,cert_type,cert_code) values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.setString(2, "zjy");
		ps.setString(3, "身份证");
		ps.setString(4, "1234567890");
		int ret = ps.executeUpdate();
		System.out.println("insert result:" + ret);
		
		sql = " select * from cust a where a.cust_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
			}
		}
		
		sql = " update cust set name=? where cust_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, "zhangjy");
		ps.setLong(2, id);
		ret = ps.executeUpdate();
		System.out.println("delete result:" + ret);
		
		sql = " select * from cust a where a.cust_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		rs = ps.executeQuery();
		while(rs != null && rs.next()) {
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
			}
		}
		
		sql = "delete from cust  where cust_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ret = ps.executeUpdate();
		System.out.println("delete result:" + ret);
		
		conn.close();
		DistributeRuleAssist.clearTenant();
	}
	
	public static void testCase4(ClassPathXmlApplicationContext ctx) throws Exception {
		DistributedDataSource ds = (DistributedDataSource)ctx.getBean("db_cust");
		
		Sequence custIdSeq = (Sequence) ctx.getBean("cust_id_seq");
		long id = custIdSeq.nextValue();
		long tenantId = 1;
		Connection conn = ds.getConnection();
		String sql = " insert into cust_tenant(cust_id,name,cert_type,cert_code,tenant_id) values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.setString(2, "zjy");
		ps.setString(3, "身份证");
		ps.setString(4, "1234567890");
		ps.setLong(5, tenantId);
		int ret = ps.executeUpdate();
		System.out.println("insert result:" + ret);
		
		sql = " select * from cust_tenant a where a.cust_id = ? and a.tenant_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.setLong(2, tenantId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
			}
		}
		
		sql = " update cust_tenant set name=? where cust_id = ? and tenant_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, "zhangjy");
		ps.setLong(2, id);
		ps.setLong(3, tenantId);
		ret = ps.executeUpdate();
		System.out.println("delete result:" + ret);
		
		sql = " select * from cust_tenant a where a.cust_id = ? and a.tenant_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.setLong(2, tenantId);
		rs = ps.executeQuery();
		while(rs != null && rs.next()) {
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
			}
		}
		
		sql = "delete from cust_tenant  where cust_id = ? and tenant_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.setLong(2, tenantId);
		ret = ps.executeUpdate();
		System.out.println("delete result:" + ret);
		
		conn.close();
	}
	
	public static void testCase5(ClassPathXmlApplicationContext ctx) throws Exception {
		DistributedDataSource ds = (DistributedDataSource)ctx.getBean("db_cust");
		
		Sequence seq = (Sequence) ctx.getBean("user_seq");
		long id = seq.nextValue();
		String cityId = "1001";
		String provId = "10";
		Connection conn = ds.getConnection();
		String sql = " insert into user(user_id,username,prov_id,city_id) values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.setString(2, "zjy");
		ps.setString(3, provId);
		ps.setString(4, cityId);
		int ret = ps.executeUpdate();
		System.out.println("insert result:" + ret);
		
		sql = " select * from user a where a.user_id = ? and a.city_id = ? and a.prov_id=?";
		ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.setString(2, cityId);
		ps.setString(3, provId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
			}
		}
		
		sql = " update user set username=? where user_id = ? and city_id = ? and prov_id=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, "zhangjy");
		ps.setLong(2, id);
		ps.setString(3, cityId);
		ps.setString(4, provId);
		ret = ps.executeUpdate();
		System.out.println("delete result:" + ret);
		
		sql = " select * from user a where a.user_id = ? and a.city_id = ? and a.prov_id=?";
		ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.setString(2, cityId);
		ps.setString(3, provId);
		rs = ps.executeQuery();
		while(rs != null && rs.next()) {
			int size = rs.getMetaData().getColumnCount();
			for(int i=1; i<=size; i++) {
				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
			}
		}
		
		sql = "delete from user  where user_id = ? and city_id = ? and prov_id=?";
		ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.setString(2, cityId);
		ps.setString(3, provId);
		ret = ps.executeUpdate();
		System.out.println("delete result:" + ret);
		
		conn.close();
	}
	
	public static void testCase6(ClassPathXmlApplicationContext ctx) throws Exception {
		DistributedDataSource ds = (DistributedDataSource)ctx.getBean("db_cust");
//		DistributeRuleAssist.setTableIndex(3);
		Connection conn = ds.getConnection();
//		String sql = " CREATE TABLE `cust1` (`cust_id` int(11) NOT NULL,`name` varchar(45) DEFAULT NULL,`cert_type` varchar(45) DEFAULT NULL,`cert_code` varchar(45) DEFAULT NULL,PRIMARY KEY (`cust_id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
//		String sql = "ALTER TABLE `cust` ADD COLUMN `remark` VARCHAR(45) NULL AFTER `cert_code`";
//		String sql = "DROP TABLE `cust`";
//		String sql = "update cust set name='zjy'";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		int rs = ps.executeUpdate();
//		while(rs != null && rs.next()) {
//			int size = rs.getMetaData().getColumnCount();
//			for(int i=1; i<=size; i++) {
//				System.out.println(rs.getMetaData().getColumnName(i) + ":" + rs.getObject(i));
//			}
//
//		}
		List<Thread> tList = new ArrayList<Thread>();
		for(int i=0; i<10; i++) {
			Thread t = new TestThread(conn, i);
			tList.add(t);
			t.start();
		}
		
		for(Thread t : tList) {
			t.join();
		}
		
		conn.close();
	}
	
	
}

class TestThread extends Thread {
	private Connection conn = null;
	private Integer i;
	public TestThread(Connection conn, Integer i) {
		this.conn = conn;
		this.i = i;
	}
	
	@Override
	public void run() {
		try {
			String sql = "select * from  cust where cust_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 87880+i*4);
			ResultSet rs = ps.executeQuery();
			while(rs != null && rs.next()) {
				for(int k=1; k<=2; k++) {
					System.out.println(i + ":" + rs.getMetaData().getColumnName(k) + ":" + rs.getObject(k));
					Thread.sleep(10000);
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
