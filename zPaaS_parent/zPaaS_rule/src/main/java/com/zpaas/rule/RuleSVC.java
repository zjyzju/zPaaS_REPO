package com.zpaas.rule;

/**
 * 规则服务接口类
 * @author ZhangJunyong
 *
 */
public interface RuleSVC {
	public void executeRule(Object...objects);
	public void executeRuleById(String ruleId, Object...objects);
}
