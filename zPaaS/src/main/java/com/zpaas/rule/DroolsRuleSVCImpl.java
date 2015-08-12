package com.zpaas.rule;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.StatefulSession;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.file.FileManagerSVC;

/**
 * 基于Drools的规则服务实现类
 * @author ZhangJunyong
 *
 */
public class DroolsRuleSVCImpl  implements ConfigurationWatcher, RuleSVC{
	public static final Logger log = Logger.getLogger(DroolsRuleSVCImpl.class);
	
	public static final String RULE_ID = "ruleId";
	
	private String confPath = "/com/zpaas/rule/ruleSVC";
	private ConfigurationCenter cc = null;
	private FileManagerSVC ruleRepo = null;
	private String defaultRuleId = null;
	private RuleBase defaultRule = null;
	private HashMap<String, RuleBase> ruleCache = new HashMap<String, RuleBase>();
	
	public void executeRule(Object... objects) {
		if(defaultRule == null) {
			return;
		}
		StatefulSession session = defaultRule.newStatefulSession();
		for(Object obj : objects) {
			session.insert(obj);
			
		}
		session.fireAllRules();
		session.dispose();
	}
	
	public void executeRuleById(String ruleId, Object... objects) {
		RuleBase rule = ruleCache.get(ruleId);
		if(rule == null) {
			rule = loadDroolsRule(ruleId);
			if(rule == null) {
				return;
			}
			ruleCache.put(ruleId, rule);
		}
		StatefulSession session = rule.newStatefulSession();
		for(Object obj : objects) {
			session.insert(obj);
			
		}
		session.fireAllRules();
		session.dispose();
	}
	
	private RuleBase loadDroolsRule(String ruleId) {
		if(ruleId == null ) {
			return null;
		}
		byte[] ruleByte = ruleRepo.readFile(ruleId);
		if(ruleByte == null) {
			return null;
		}
		RuleBase base = RuleBaseFactory.newRuleBase();
		Reader reader = new InputStreamReader(new ByteArrayInputStream(ruleByte));
		PackageBuilder builder = new PackageBuilder();
		try {
			builder.addPackageFromDrl(reader);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			log.error("load rule from drl file failed:" + e);
			return null;
		} 
		base.addPackages(builder.getPackages());
		return base;
	}

	public void init() {
		try {
			process(cc.getConfAndWatch(confPath, this));
			
		} catch (PaasException e) {
			log.error(e.getMessage(),e);
		}
	}
	
	public void process(String conf) {
		if(log.isInfoEnabled()) {
			log.info("new rule configuration is received: " + conf);
		}
		JSONObject json = JSONObject.fromObject(conf);
		boolean changed = false;
		if(json.getString(RULE_ID) != null && !json.getString(RULE_ID).equals(defaultRuleId)) {
			changed = true;
			defaultRuleId = json.getString(RULE_ID);
		}
		if(changed) {
			if(defaultRuleId != null) {
				defaultRule = loadDroolsRule(defaultRuleId);
			}else {
				defaultRule = null;
			}
		}
	}
	
	
	
	public String getConfPath() {
		return confPath;
	}

	public void setConfPath(String confPath) {
		this.confPath = confPath;
	}

	public ConfigurationCenter getCc() {
		return cc;
	}

	public void setCc(ConfigurationCenter cc) {
		this.cc = cc;
	}

	public FileManagerSVC getRuleRepo() {
		return ruleRepo;
	}

	public void setRuleRepo(FileManagerSVC ruleRepo) {
		this.ruleRepo = ruleRepo;
	}

	public static void main(String[] args)throws Exception {
//		RuleBase base = RuleBaseFactory.newRuleBase();
//		String rule = "import com.ai.paas.client.message.Message \n" +
//					  "rule \"testRule\" \n" +
//							"no-loop true \n" + 
//							"when \n" +
//								"eval(true); \n" +
//								"$msg : Message(); \n" +
//								"$topic : String(); \n" +
//							"then \n" +
//								"System.out.println(\"fit\"); \n" +
//								"$msg.setTopic($topic); \n" +
//					  "end";
//		Reader reader = new StringReader(rule);
//		PackageBuilder builder = new PackageBuilder();
//		builder.addPackageFromDrl(reader);
//		base.addPackages(builder.getPackages());
//		StatefulSession session = base.newStatefulSession();
//		Message msg = new Message();
//		String topic = "Drools topic";
//		session.insert(msg);
//		session.insert(topic);
//		session.fireAllRules();
//		System.out.println(msg.getTopic());
//		PayInfo payInfo = new PayInfo();
//		payInfo.setBankNo("402");
//		payInfo.setServiceType("3");
//		
//		RuleService ruleService = (RuleService)PaasContextHolder.getContext().getBean("aipayRule");
//		ruleService.executeRule(payInfo);
//		System.out.println(payInfo.getResult());
	}
}
