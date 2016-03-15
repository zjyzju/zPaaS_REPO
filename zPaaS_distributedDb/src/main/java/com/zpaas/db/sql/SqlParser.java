package com.zpaas.db.sql;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpaas.db.sql.parser.SQLLexer;
import com.zpaas.db.sql.parser.SQLParser;
import com.zpaas.db.sql.parser.SQLParser.Aggregate_functionContext;
import com.zpaas.db.sql.parser.SQLParser.Alter_table_statementContext;
import com.zpaas.db.sql.parser.SQLParser.Column_name_listContext;
import com.zpaas.db.sql.parser.SQLParser.Comp_opContext;
import com.zpaas.db.sql.parser.SQLParser.Comparison_predicateContext;
import com.zpaas.db.sql.parser.SQLParser.Create_table_statementContext;
import com.zpaas.db.sql.parser.SQLParser.Derived_tableContext;
import com.zpaas.db.sql.parser.SQLParser.Drop_table_statementContext;
import com.zpaas.db.sql.parser.SQLParser.General_set_functionContext;
import com.zpaas.db.sql.parser.SQLParser.Groupby_clauseContext;
import com.zpaas.db.sql.parser.SQLParser.Grouping_elementContext;
import com.zpaas.db.sql.parser.SQLParser.Grouping_element_listContext;
import com.zpaas.db.sql.parser.SQLParser.Having_clauseContext;
import com.zpaas.db.sql.parser.SQLParser.IdentifierContext;
import com.zpaas.db.sql.parser.SQLParser.In_predicateContext;
import com.zpaas.db.sql.parser.SQLParser.In_predicate_valueContext;
import com.zpaas.db.sql.parser.SQLParser.In_value_listContext;
import com.zpaas.db.sql.parser.SQLParser.Numeric_value_expressionContext;
import com.zpaas.db.sql.parser.SQLParser.Pattern_matcherContext;
import com.zpaas.db.sql.parser.SQLParser.Pattern_matching_predicateContext;
import com.zpaas.db.sql.parser.SQLParser.Row_value_predicandContext;
import com.zpaas.db.sql.parser.SQLParser.Set_function_typeContext;
import com.zpaas.db.sql.parser.SQLParser.Table_nameContext;
import com.zpaas.db.sql.parser.SQLParser.Table_or_query_nameContext;
import com.zpaas.db.sql.parser.SQLParser.Table_primaryContext;
import com.zpaas.db.sql.parser.SQLParser.Table_subqueryContext;

/**
 * 解析SQL语句的工具类
 * @author zjy
 * @date 2014年6月18日 下午2:14:45 
 * @version V1.0
 */
public class SqlParser {
	public static final Logger log = LoggerFactory.getLogger(SqlParser.class);

	/**
	 * 使用ANTLR生成的SQL语句解析类对传入的SQL进行解析，返回一个ParseTree对象树
	 * @param sql SQL语句
	 * @return ParseTree对象树
	 */
	private static ParseTree parse(String sql){
		
		CharStream stream = new ANTLRInputStream(sql);
		SQLLexer lexer = new SQLLexer(stream);
		TokenStream tokens = new CommonTokenStream(lexer);
		SQLParser parser = new SQLParser(tokens);
		ParseTree tree = parser.sql();
		return tree;
	}

	/**
	 * 解析传入的SQL
	 * @param sql SQL语句
	 * @return ParsedSqlContext对象
	 */
	public static ParsedSqlContext parseSql(String sql) {
		ParseTree tree = parse(sql);
		ParsedSqlContext ctx = new ParsedSqlContext();
		ctx.setTables(new ArrayList<Table>());
		ctx.setColumns(new ArrayList<Column>());
		ctx.setFuncTypes(new ArrayList<String>());
		ctx.setGroupElements(new ArrayList<String>());
		parseSqlTree(tree, ctx);
		if(log.isDebugEnabled()) {
			log.debug(JSONObject.fromObject(ctx).toString());
		}
		return ctx;
	}
	
	/**
	 * 解析SQL对象树
	 * @param sqlTree 传入参数，ANTLR解析后的ParseTree对象
	 * @param ctx 传出参数，SQL语句的解析结果
	 * @return 通过ParsedSqlContext对象返回结果
	 */
	private static void parseSqlTree(ParseTree sqlTree, ParsedSqlContext ctx) {
		if (sqlTree != null && sqlTree.getChildCount() <= 0) {
			return;
		}

		List<Table> tables = ctx.getTables();// 存放表信息的解析结果
		List<Column> columns = ctx.getColumns();// 存储条件列信息的解析结果
		List<String> funcTypes = ctx.getFuncTypes();// 存放集合运算函数
		List<String> groupElements = ctx.getGroupElements();// 存放group by的列
		int size = sqlTree.getChildCount();
		ParseTree child = null;
		//从根节点开始，循环递归处理每个节点
		for (int i = 0; i < size; i++) {
			child = sqlTree.getChild(i);					
			if (child instanceof Table_primaryContext) {// 解析select主语句中的表信息
				Table table = new Table();
				boolean isTable = false;
				//循环Table_primaryContext的每个子节点
				for (int j = 0; j < child.getChildCount(); j++) {
					
					if (child.getChild(j) instanceof Table_or_query_nameContext) {//该节点表示是表名
						table.setTableName(child.getChild(j).getText());
						isTable = true;
					} else if (child.getChild(j) instanceof IdentifierContext) {//该节点表示是别名
						table.setAlias(child.getChild(j).getText());
					} else if (child.getChild(j) instanceof Derived_tableContext) {//表示是个虚拟表，递归处理（select * from xxx） b
						parseSqlTree(child.getChild(j), ctx);
					}
				}
				if (isTable) {//加入到放表信息的列表
					tables.add(table);
				}
			} else if (child instanceof Table_nameContext) {// 解析select子查询中的表信息
				Table table = new Table();
				table.setTableName(child.getText());
				tables.add(table);
			} else if (child instanceof Comparison_predicateContext || child instanceof Pattern_matching_predicateContext) {// 解析select语句包括select子查询中的条件列
				Column column = new Column();
				columns.add(column);
				boolean right = false;
				//循环Comparison_predicateContext的每个子节点
				for (int j = 0; j < child.getChildCount(); j++) {
					if (child.getChild(j) instanceof Row_value_predicandContext) {//有可能是左值也有可能是左值
						if (!right) {//左值时作为列名
							column.setColumnName(child.getChild(j).getText());
							right = true;
						} else {//右值时作为条件比较值
							column.setValue(child.getChild(j).getText());
						}
					} else if (child.getChild(j) instanceof Comp_opContext || child.getChild(j) instanceof Pattern_matcherContext) {//条件比较操作符
						column.setOperator(child.getChild(j).getText());
						parseSqlTree(child.getChild(j), ctx);
					}

				}
			} else if (child instanceof Column_name_listContext) {// 解析insert语句中的table后面的列
				Column column = null;
				//循环处理每个Column_name_listContext子节点
				for (int j = 0; j < child.getChildCount(); j++) {
					if (child.getChild(j) instanceof IdentifierContext) {//insert语句中的table后面的列
						column = new Column();
						columns.add(column);
						column.setColumnName(child.getChild(j).getText());
					}
				}
			} else if (child instanceof In_value_listContext) {// 解析insert语句中的values后面的值列表
				List<String> values = new ArrayList<String>();
				//将所有的值按顺序放到List中
				for (int j = 0; j < child.getChildCount(); j++) {
					if (child.getChild(j) instanceof Row_value_predicandContext) {
						values.add(child.getChild(j).getText());
					}
				}
				//将值列表按顺序匹配到列对象中
				if (values != null && values.size() == columns.size()) {
					int k = 0;
					for (String value : values) {
						columns.get(k).setOperator("=");
						columns.get(k).setValue(value);
						k++;
					}
				}
			} else if (child instanceof In_predicateContext) {// 处理where条件中的in条件
				Column column = new Column();
				columns.add(column);
				//循环处理In_predicateContext所有的子节点
				for (int j = 0; j < child.getChildCount(); j++) {
					if (child.getChild(j) instanceof Numeric_value_expressionContext) {//列名
						column.setColumnName(child.getChild(j).getText());
					} else if (child.getChild(j) instanceof TerminalNodeImpl) {// 处理in和not in
						if (column.getOperator() == null) {
							column.setOperator(child.getChild(j).getText());
						} else {
							column.setOperator(column.getOperator() + " " + child.getChild(j).getText());
						}
					} else if (child.getChild(j) instanceof In_predicate_valueContext) {//处理（）中的值清单
						for (int k = 0; k < child.getChild(j).getChildCount(); k++) {
							if (child.getChild(j).getChild(k) instanceof In_value_listContext) {//值清单的字符串,如1,2,3
								column.setValue(child.getChild(j).getChild(k).getText());
								break;
							} else if (child.getChild(j).getChild(k) instanceof Table_subqueryContext) {
								//如果是select查询子句则递归处理
								parseSqlTree(child.getChild(j).getChild(k), ctx);
							}
						}
					}
				}
			} else if (child instanceof Aggregate_functionContext) {// 解析count、max、min、sum、avg等集合函数
				if (child.getChild(0) instanceof TerminalNodeImpl) {//count(*)的情况
					funcTypes.add(child.getChild(0).getText());
				} else {//递归处理其他递归函数的情况
					parseSqlTree(child, ctx);
				}
			} else if (child instanceof General_set_functionContext) {// 解析count、max、min、sum、avg等集合函数
				if (child.getChild(0) instanceof Set_function_typeContext) {
					funcTypes.add(child.getChild(0).getText());//将集合函数加入列表中
				}
			} else if (child instanceof Groupby_clauseContext) {// 处理group by子句
				ctx.setGroupBySql(true);
				for (int j = 0; j < child.getChildCount(); j++) {
					//处理group by子句中的列清单
					if (child.getChild(j) instanceof Grouping_element_listContext) {
						for (int k = 0; k < child.getChild(j).getChildCount(); k++) {
							if (child.getChild(j).getChild(k) instanceof Grouping_elementContext) {
								groupElements.add(child.getChild(j).getChild(k).getText());
							}
						}
						break;
					}
				}
			} else if (child instanceof Having_clauseContext) {// 处理having子句
				ctx.setHavingSql(true);
			} else if (child instanceof Create_table_statementContext) {// 处理create语句
				for (int j = 0; j < child.getChildCount(); j++) {
					if (child.getChild(j) instanceof Table_nameContext) {//该节点表示是表名
						Table table = new Table();
						table.setTableName(child.getChild(j).getText());
						tables.add(table);
					}
				}
			} else if (child instanceof Alter_table_statementContext) {// 处理alter语句
				for (int j = 0; j < child.getChildCount(); j++) {
					if (child.getChild(j) instanceof Table_nameContext) {//该节点表示是表名
						Table table = new Table();
						table.setTableName(child.getChild(j).getText());
						tables.add(table);
					}
				}
			} else if (child instanceof Drop_table_statementContext) {// 处理alter语句
				for (int j = 0; j < child.getChildCount(); j++) {
					if (child.getChild(j) instanceof Table_nameContext) {//该节点表示是表名
						Table table = new Table();
						table.setTableName(child.getChild(j).getText());
						tables.add(table);
					}
				}
			} else {
//				if (child instanceof Pattern_matching_predicateContext) {
//					for (int j = 0; j < child.getChildCount(); j++) {
//						System.out.println(child.getChild(j).getClass());
//						System.out.println(child.getChild(j).getText());
//					}
//				}
				parseSqlTree(child, ctx);
			}
		}
	}
	
	public static void main(String[] args) {
//		 String sql = "update aip_partner_account t set t.status = ? where t.partner_account_id = ? and t.acct_id = ?";
//		String sql = "update aip_partner_account t set t.status = question_mark_1 where t.partner_account_id = question_mark_2 and t.acct_id = question_mark_3";
//		String sql = "select * from table1 a, table2, table3, (select * from table4 b, table5 c where b.col1=c.col1 and b.col3=1 and c.col4='a') d where a.col5=4 and a.col6='b'".toUpperCase();
//		String sql = "insert into table1(col1,col2,col3) values(a,'b','c')";		
//		String sql = "insert into table1(col1,col2,col3) select * from table2 where col4=4";
//		String sql = "delete from t_able0 t where t.id = 0";
//		String sql = "select * from cust a where a.cust_id not in (1, 2,3)";
//		String sql = "select b.name, CouNt(*), min(b.cust_id) from cust b group by b.name having (count(*)>1 and count(*)<=3) or count(*)>6";
//		String sql = "select tx_id, tx_topic, tx_status, tx_content, start_time,finish_time, content_class, subscriber_amount, subscribers, succeed_amount, succeed_subscribers,       failed_subscribers,send_times,status_time      from transaction_message_0008 where tx_status=70 and status_time <      date_sub(sysdate(),interval 60 second) ";
//		String sql = " CREATE TABLE `cust` (`cust_id` int(11) NOT NULL,`name` varchar(45) DEFAULT NULL,`cert_type` varchar(45) DEFAULT NULL,`cert_code` varchar(45) DEFAULT NULL,PRIMARY KEY (`cust_id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
//		String sql = "CREATE TABLE `cust` (`cust_id` int(11) DEFAULT 1,PRIMARY KEY (`cust_id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
//		String sql = "ALTER TABLE `cust` ADD COLUMN `remark` VARCHAR(45) NULL AFTER `cert_code`";
//		String sql = "DROP TABLE `cust`";
//		String sql = "insert into iuy_acct_prod_voting (acct_voting_id, acct_id, object_type, object_id, voting_type,       voting_date, comments)     values (1, 2, 3, 4,       5, 6, 7)  ";
//		String sql = "show tables";
//		String sql = "select count(*) from (select 1 from iuy_order_main                                   limit 0,10) b";
		String sql = "select * from (select t_1.*,rownum as row_num from (select log_id, log_info, db_code from t_demo_log  where (  db_code like question_mark_1 and log_info is not null )  ) t_1 where rownum<=2 + 3) t_2 where t_2.row_num>2";
		parseSql(sql);
	}
}
