// Generated from SQLParser.g4 by ANTLR 4.2.2
package com.zpaas.db.sql.parser;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ISODOW=98, OVERWRITE=115, PRECISION=118, ILIKE=23, Character_String_Literal=221, 
		NOT=35, EXCEPT=17, FOREIGN=90, BYTEA=185, CHARACTER=64, MONTH=112, BlockComment=217, 
		VARBIT=154, CREATE=10, STDDEV_POP=131, USING=52, NOT_EQUAL=198, TIMEZONE_MINUTE=140, 
		VERTICAL_BAR=212, TIMESTAMPTZ=180, REGEXP=123, GEQ=202, SHOW=135, STDDEV_SAMP=132, 
		DIVIDE=208, BLOB=184, GROUPING=91, ASC=6, SUBPARTITION=133, KEY=100, ELSE=16, 
		NUMBER=215, BOOL=152, TRAILING=47, SEMI_COLON=195, INT=161, RLIKE=124, 
		LEADING=30, TABLESPACE=136, MILLISECONDS=109, REAL=166, GROUP=21, INTERSECT=26, 
		REAL_NUMBER=216, TRIM=141, LEFT_PAREN=203, LOCATION=104, END=15, CONSTRAINT=70, 
		RENAME=126, TIMEZONE_HOUR=139, CAST_EXPRESSION=191, ALTER=59, ISOYEAR=99, 
		NCHAR=173, TABLE=45, VARCHAR=172, MICROSECONDS=107, FLOAT=167, ASYMMETRIC=5, 
		SUM=134, Space=222, AS=1, TIME=177, RIGHT_PAREN=204, THEN=46, MAXVALUE=106, 
		AVG=57, LEFT=31, ZONE=150, COLUMN=67, PLUS=205, EXISTS=82, NVARCHAR=174, 
		Not_Similar_To=188, LIKE=32, ADD=58, INTEGER=162, OUTER=38, BY=62, TO=142, 
		RIGHT=41, SET=129, HAVING=22, MIN=110, MINUS=206, TEXT=181, HOUR=93, CONCATENATION_OPERATOR=197, 
		UNION=49, COLON=194, DATABASE=73, DECIMAL=170, DROP=78, BIGINT=163, WHEN=54, 
		BIT=153, FORMAT=88, NATURAL=34, BETWEEN=61, FIRST=87, Regular_Identifier=219, 
		CAST=9, EXTERNAL=84, WEEK=148, DOUBLE_QUOTE=214, VARYING=147, CASE=8, 
		INT8=158, CHAR=171, DAY=72, COUNT=68, INT2=156, INT1=155, INT4=157, EXPLAIN=83, 
		QUOTE=213, MODULAR=209, FULL=19, QUARTER=121, THAN=137, INSERT=96, INTERSECTION=97, 
		LESS=102, BOTH=7, TINYINT=159, DOUBLE=168, Similar_To_Case_Insensitive=189, 
		SYMMETRIC=44, LAST=101, COMMENT=71, SELECT=42, INTO=27, UNIQUE=50, COALESCE=66, 
		SECOND=128, EPOCH=80, ROLLUP=125, NULL=36, EVERY=81, ON=37, PRIMARY=120, 
		DELETE=14, NUMERIC=169, INET4=186, LIST=103, TABLES=143, UNDERLINE=211, 
		Not_Similar_To_Case_Insensitive=190, CUBE=69, NATIONAL=113, OR=39, VAR_POP=146, 
		FILTER=86, FROM=20, COLLECT=65, FALSE=18, DISTINCT=13, TIMESTAMP=179, 
		DEC=74, WHERE=55, NULLIF=114, VAR_SAMP=145, TIMETZ=178, INNER=25, YEAR=149, 
		ORDER=40, TIMEZONE=138, LIMIT=33, DECADE=75, GTH=201, White_Space=223, 
		UPDATE=51, MAX=105, LineComment=218, FLOAT4=164, FLOAT8=165, AND=3, CROSS=11, 
		Similar_To=187, INTERVAL=176, IF=94, INDEX=95, BOOLEAN=151, IN=24, UNKNOWN=144, 
		MULTIPLY=207, COMMA=196, REFERENCES=127, IS=28, PARTITION=116, PARTITIONS=117, 
		SOME=43, EQUAL=193, ALL=2, DOT=210, EXTRACT=85, CENTURY=63, DOW=76, WITH=56, 
		DOY=77, FUSION=89, VARBINARY=183, DEFAULT=79, VALUES=53, HASH=92, MILLENNIUM=108, 
		RANGE=122, PURGE=119, AFTER=60, TRUE=48, JOIN=29, SIMILAR=130, LTH=199, 
		ANY=4, BAD=224, ASSIGN=192, DESC=12, BINARY=182, Quoted_Identifier=220, 
		MINUTE=111, DATE=175, LEQ=200, SMALLINT=160;
	public static final String[] tokenNames = {
		"<INVALID>", "AS", "ALL", "AND", "ANY", "ASYMMETRIC", "ASC", "BOTH", "CASE", 
		"CAST", "CREATE", "CROSS", "DESC", "DISTINCT", "DELETE", "END", "ELSE", 
		"EXCEPT", "FALSE", "FULL", "FROM", "GROUP", "HAVING", "ILIKE", "IN", "INNER", 
		"INTERSECT", "INTO", "IS", "JOIN", "LEADING", "LEFT", "LIKE", "LIMIT", 
		"NATURAL", "NOT", "NULL", "ON", "OUTER", "OR", "ORDER", "RIGHT", "SELECT", 
		"SOME", "SYMMETRIC", "TABLE", "THEN", "TRAILING", "TRUE", "UNION", "UNIQUE", 
		"UPDATE", "USING", "VALUES", "WHEN", "WHERE", "WITH", "AVG", "ADD", "ALTER", 
		"AFTER", "BETWEEN", "BY", "CENTURY", "CHARACTER", "COLLECT", "COALESCE", 
		"COLUMN", "COUNT", "CUBE", "CONSTRAINT", "COMMENT", "DAY", "DATABASE", 
		"DEC", "DECADE", "DOW", "DOY", "DROP", "DEFAULT", "EPOCH", "EVERY", "EXISTS", 
		"EXPLAIN", "EXTERNAL", "EXTRACT", "FILTER", "FIRST", "FORMAT", "FUSION", 
		"FOREIGN", "GROUPING", "HASH", "HOUR", "IF", "INDEX", "INSERT", "INTERSECTION", 
		"ISODOW", "ISOYEAR", "KEY", "LAST", "LESS", "LIST", "LOCATION", "MAX", 
		"MAXVALUE", "MICROSECONDS", "MILLENNIUM", "MILLISECONDS", "MIN", "MINUTE", 
		"MONTH", "NATIONAL", "NULLIF", "OVERWRITE", "PARTITION", "PARTITIONS", 
		"PRECISION", "PURGE", "PRIMARY", "QUARTER", "RANGE", "REGEXP", "RLIKE", 
		"ROLLUP", "RENAME", "REFERENCES", "SECOND", "SET", "SIMILAR", "STDDEV_POP", 
		"STDDEV_SAMP", "SUBPARTITION", "SUM", "SHOW", "TABLESPACE", "THAN", "TIMEZONE", 
		"TIMEZONE_HOUR", "TIMEZONE_MINUTE", "TRIM", "TO", "TABLES", "UNKNOWN", 
		"VAR_SAMP", "VAR_POP", "VARYING", "WEEK", "YEAR", "ZONE", "BOOLEAN", "BOOL", 
		"BIT", "VARBIT", "INT1", "INT2", "INT4", "INT8", "TINYINT", "SMALLINT", 
		"INT", "INTEGER", "BIGINT", "FLOAT4", "FLOAT8", "REAL", "FLOAT", "DOUBLE", 
		"NUMERIC", "DECIMAL", "CHAR", "VARCHAR", "NCHAR", "NVARCHAR", "DATE", 
		"INTERVAL", "TIME", "TIMETZ", "TIMESTAMP", "TIMESTAMPTZ", "TEXT", "BINARY", 
		"VARBINARY", "BLOB", "BYTEA", "INET4", "'~'", "'!~'", "'~*'", "'!~*'", 
		"CAST_EXPRESSION", "':='", "'='", "':'", "';'", "','", "CONCATENATION_OPERATOR", 
		"NOT_EQUAL", "'<'", "'<='", "'>'", "'>='", "'('", "')'", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'.'", "'_'", "'|'", "'''", "'\"'", "NUMBER", "REAL_NUMBER", 
		"BlockComment", "LineComment", "Regular_Identifier", "Quoted_Identifier", 
		"Character_String_Literal", "' '", "White_Space", "BAD"
	};
	public static final int
		RULE_sql = 0, RULE_explain_clause = 1, RULE_statement = 2, RULE_data_statement = 3, 
		RULE_data_change_statement = 4, RULE_schema_statement = 5, RULE_index_statement = 6, 
		RULE_database_definition = 7, RULE_if_not_exists = 8, RULE_drop_database_statement = 9, 
		RULE_if_exists = 10, RULE_desc_table_statement = 11, RULE_show_tables_statement = 12, 
		RULE_create_table_statement = 13, RULE_table_elements = 14, RULE_field_element = 15, 
		RULE_field_type = 16, RULE_field_decorator = 17, RULE_constraint_element = 18, 
		RULE_comment_type = 19, RULE_foreign_key_type = 20, RULE_primary_key_type = 21, 
		RULE_unique_type = 22, RULE_constraint_type = 23, RULE_null_notnull_type = 24, 
		RULE_after_type = 25, RULE_default_type = 26, RULE_param_clause = 27, 
		RULE_param = 28, RULE_method_specifier = 29, RULE_table_space_specifier = 30, 
		RULE_table_space_name = 31, RULE_table_partitioning_clauses = 32, RULE_range_partitions = 33, 
		RULE_range_value_clause_list = 34, RULE_range_value_clause = 35, RULE_hash_partitions = 36, 
		RULE_individual_hash_partitions = 37, RULE_individual_hash_partition = 38, 
		RULE_hash_partitions_by_quantity = 39, RULE_list_partitions = 40, RULE_list_value_clause_list = 41, 
		RULE_list_value_partition = 42, RULE_column_partitions = 43, RULE_partition_name = 44, 
		RULE_drop_table_statement = 45, RULE_identifier = 46, RULE_nonreserved_keywords = 47, 
		RULE_unsigned_literal = 48, RULE_general_literal = 49, RULE_datetime_literal = 50, 
		RULE_time_literal = 51, RULE_timestamp_literal = 52, RULE_date_literal = 53, 
		RULE_interval_literal = 54, RULE_boolean_literal = 55, RULE_data_type = 56, 
		RULE_predefined_type = 57, RULE_network_type = 58, RULE_character_string_type = 59, 
		RULE_type_length = 60, RULE_national_character_string_type = 61, RULE_binary_large_object_string_type = 62, 
		RULE_numeric_type = 63, RULE_exact_numeric_type = 64, RULE_approximate_numeric_type = 65, 
		RULE_precision_param = 66, RULE_boolean_type = 67, RULE_datetime_type = 68, 
		RULE_bit_type = 69, RULE_binary_type = 70, RULE_value_expression_primary = 71, 
		RULE_parenthesized_value_expression = 72, RULE_nonparenthesized_value_expression_primary = 73, 
		RULE_unsigned_value_specification = 74, RULE_unsigned_numeric_literal = 75, 
		RULE_signed_numerical_literal = 76, RULE_set_function_specification = 77, 
		RULE_aggregate_function = 78, RULE_general_set_function = 79, RULE_set_function_type = 80, 
		RULE_filter_clause = 81, RULE_grouping_operation = 82, RULE_case_expression = 83, 
		RULE_case_abbreviation = 84, RULE_case_specification = 85, RULE_simple_case = 86, 
		RULE_searched_case = 87, RULE_simple_when_clause = 88, RULE_searched_when_clause = 89, 
		RULE_else_clause = 90, RULE_result = 91, RULE_cast_specification = 92, 
		RULE_cast_operand = 93, RULE_cast_target = 94, RULE_value_expression = 95, 
		RULE_common_value_expression = 96, RULE_numeric_value_expression = 97, 
		RULE_term = 98, RULE_factor = 99, RULE_array = 100, RULE_numeric_primary = 101, 
		RULE_sign = 102, RULE_numeric_value_function = 103, RULE_extract_expression = 104, 
		RULE_extract_field = 105, RULE_time_zone_field = 106, RULE_extract_source = 107, 
		RULE_string_value_expression = 108, RULE_character_value_expression = 109, 
		RULE_character_factor = 110, RULE_character_primary = 111, RULE_string_value_function = 112, 
		RULE_trim_function = 113, RULE_trim_operands = 114, RULE_trim_specification = 115, 
		RULE_boolean_value_expression = 116, RULE_or_predicate = 117, RULE_and_predicate = 118, 
		RULE_boolean_factor = 119, RULE_boolean_test = 120, RULE_is_clause = 121, 
		RULE_truth_value = 122, RULE_boolean_primary = 123, RULE_boolean_predicand = 124, 
		RULE_parenthesized_boolean_value_expression = 125, RULE_row_value_expression = 126, 
		RULE_row_value_special_case = 127, RULE_explicit_row_value_constructor = 128, 
		RULE_row_value_predicand = 129, RULE_row_value_constructor_predicand = 130, 
		RULE_table_expression = 131, RULE_from_clause = 132, RULE_table_reference_list = 133, 
		RULE_table_reference = 134, RULE_joined_table = 135, RULE_joined_table_primary = 136, 
		RULE_cross_join = 137, RULE_qualified_join = 138, RULE_natural_join = 139, 
		RULE_union_join = 140, RULE_join_type = 141, RULE_outer_join_type = 142, 
		RULE_outer_join_type_part2 = 143, RULE_join_specification = 144, RULE_join_condition = 145, 
		RULE_named_columns_join = 146, RULE_table_primary = 147, RULE_column_name_list = 148, 
		RULE_derived_table = 149, RULE_where_clause = 150, RULE_search_condition = 151, 
		RULE_groupby_clause = 152, RULE_grouping_element_list = 153, RULE_grouping_element = 154, 
		RULE_ordinary_grouping_set = 155, RULE_ordinary_grouping_set_list = 156, 
		RULE_rollup_list = 157, RULE_cube_list = 158, RULE_empty_grouping_set = 159, 
		RULE_having_clause = 160, RULE_row_value_predicand_list = 161, RULE_query_expression = 162, 
		RULE_query_expression_body = 163, RULE_non_join_query_expression = 164, 
		RULE_query_term = 165, RULE_non_join_query_term = 166, RULE_query_primary = 167, 
		RULE_non_join_query_primary = 168, RULE_simple_table = 169, RULE_explicit_table = 170, 
		RULE_table_or_query_name = 171, RULE_table_name = 172, RULE_column_name = 173, 
		RULE_query_specification = 174, RULE_select_list = 175, RULE_select_sublist = 176, 
		RULE_derived_column = 177, RULE_qualified_asterisk = 178, RULE_set_qualifier = 179, 
		RULE_column_reference = 180, RULE_as_clause = 181, RULE_column_reference_list = 182, 
		RULE_scalar_subquery = 183, RULE_row_subquery = 184, RULE_table_subquery = 185, 
		RULE_subquery = 186, RULE_predicate = 187, RULE_comparison_predicate = 188, 
		RULE_equal_predicate = 189, RULE_comp_op = 190, RULE_equal_comp_op = 191, 
		RULE_between_predicate = 192, RULE_between_predicate_part_2 = 193, RULE_in_predicate = 194, 
		RULE_in_predicate_value = 195, RULE_in_value_list = 196, RULE_pattern_matching_predicate = 197, 
		RULE_pattern_matcher = 198, RULE_negativable_matcher = 199, RULE_regex_matcher = 200, 
		RULE_null_predicate = 201, RULE_quantified_comparison_predicate = 202, 
		RULE_quantifier = 203, RULE_all = 204, RULE_some = 205, RULE_exists_predicate = 206, 
		RULE_unique_predicate = 207, RULE_primary_datetime_field = 208, RULE_non_second_primary_datetime_field = 209, 
		RULE_extended_datetime_field = 210, RULE_routine_invocation = 211, RULE_function_names_for_reserved_words = 212, 
		RULE_function_name = 213, RULE_sql_argument_list = 214, RULE_orderby_clause = 215, 
		RULE_sort_specifier_list = 216, RULE_sort_specifier = 217, RULE_order_specification = 218, 
		RULE_limit_clause = 219, RULE_null_ordering = 220, RULE_insert_statement = 221, 
		RULE_update_statement = 222, RULE_column_set_list = 223, RULE_delete_statement = 224, 
		RULE_alter_tablespace_statement = 225, RULE_alter_table_statement = 226;
	public static final String[] ruleNames = {
		"sql", "explain_clause", "statement", "data_statement", "data_change_statement", 
		"schema_statement", "index_statement", "database_definition", "if_not_exists", 
		"drop_database_statement", "if_exists", "desc_table_statement", "show_tables_statement", 
		"create_table_statement", "table_elements", "field_element", "field_type", 
		"field_decorator", "constraint_element", "comment_type", "foreign_key_type", 
		"primary_key_type", "unique_type", "constraint_type", "null_notnull_type", 
		"after_type", "default_type", "param_clause", "param", "method_specifier", 
		"table_space_specifier", "table_space_name", "table_partitioning_clauses", 
		"range_partitions", "range_value_clause_list", "range_value_clause", "hash_partitions", 
		"individual_hash_partitions", "individual_hash_partition", "hash_partitions_by_quantity", 
		"list_partitions", "list_value_clause_list", "list_value_partition", "column_partitions", 
		"partition_name", "drop_table_statement", "identifier", "nonreserved_keywords", 
		"unsigned_literal", "general_literal", "datetime_literal", "time_literal", 
		"timestamp_literal", "date_literal", "interval_literal", "boolean_literal", 
		"data_type", "predefined_type", "network_type", "character_string_type", 
		"type_length", "national_character_string_type", "binary_large_object_string_type", 
		"numeric_type", "exact_numeric_type", "approximate_numeric_type", "precision_param", 
		"boolean_type", "datetime_type", "bit_type", "binary_type", "value_expression_primary", 
		"parenthesized_value_expression", "nonparenthesized_value_expression_primary", 
		"unsigned_value_specification", "unsigned_numeric_literal", "signed_numerical_literal", 
		"set_function_specification", "aggregate_function", "general_set_function", 
		"set_function_type", "filter_clause", "grouping_operation", "case_expression", 
		"case_abbreviation", "case_specification", "simple_case", "searched_case", 
		"simple_when_clause", "searched_when_clause", "else_clause", "result", 
		"cast_specification", "cast_operand", "cast_target", "value_expression", 
		"common_value_expression", "numeric_value_expression", "term", "factor", 
		"array", "numeric_primary", "sign", "numeric_value_function", "extract_expression", 
		"extract_field", "time_zone_field", "extract_source", "string_value_expression", 
		"character_value_expression", "character_factor", "character_primary", 
		"string_value_function", "trim_function", "trim_operands", "trim_specification", 
		"boolean_value_expression", "or_predicate", "and_predicate", "boolean_factor", 
		"boolean_test", "is_clause", "truth_value", "boolean_primary", "boolean_predicand", 
		"parenthesized_boolean_value_expression", "row_value_expression", "row_value_special_case", 
		"explicit_row_value_constructor", "row_value_predicand", "row_value_constructor_predicand", 
		"table_expression", "from_clause", "table_reference_list", "table_reference", 
		"joined_table", "joined_table_primary", "cross_join", "qualified_join", 
		"natural_join", "union_join", "join_type", "outer_join_type", "outer_join_type_part2", 
		"join_specification", "join_condition", "named_columns_join", "table_primary", 
		"column_name_list", "derived_table", "where_clause", "search_condition", 
		"groupby_clause", "grouping_element_list", "grouping_element", "ordinary_grouping_set", 
		"ordinary_grouping_set_list", "rollup_list", "cube_list", "empty_grouping_set", 
		"having_clause", "row_value_predicand_list", "query_expression", "query_expression_body", 
		"non_join_query_expression", "query_term", "non_join_query_term", "query_primary", 
		"non_join_query_primary", "simple_table", "explicit_table", "table_or_query_name", 
		"table_name", "column_name", "query_specification", "select_list", "select_sublist", 
		"derived_column", "qualified_asterisk", "set_qualifier", "column_reference", 
		"as_clause", "column_reference_list", "scalar_subquery", "row_subquery", 
		"table_subquery", "subquery", "predicate", "comparison_predicate", "equal_predicate", 
		"comp_op", "equal_comp_op", "between_predicate", "between_predicate_part_2", 
		"in_predicate", "in_predicate_value", "in_value_list", "pattern_matching_predicate", 
		"pattern_matcher", "negativable_matcher", "regex_matcher", "null_predicate", 
		"quantified_comparison_predicate", "quantifier", "all", "some", "exists_predicate", 
		"unique_predicate", "primary_datetime_field", "non_second_primary_datetime_field", 
		"extended_datetime_field", "routine_invocation", "function_names_for_reserved_words", 
		"function_name", "sql_argument_list", "orderby_clause", "sort_specifier_list", 
		"sort_specifier", "order_specification", "limit_clause", "null_ordering", 
		"insert_statement", "update_statement", "column_set_list", "delete_statement", 
		"alter_tablespace_statement", "alter_table_statement"
	};

	@Override
	public String getGrammarFileName() { return "SQLParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public SQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SqlContext extends ParserRuleContext {
		public TerminalNode SEMI_COLON() { return getToken(SQLParser.SEMI_COLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SQLParser.EOF, 0); }
		public Explain_clauseContext explain_clause() {
			return getRuleContext(Explain_clauseContext.class,0);
		}
		public SqlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSql(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSql(this);
		}
	}

	public final SqlContext sql() throws RecognitionException {
		SqlContext _localctx = new SqlContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sql);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(454); explain_clause();
				}
				break;
			}
			setState(457); statement();
			setState(459);
			_la = _input.LA(1);
			if (_la==SEMI_COLON) {
				{
				setState(458); match(SEMI_COLON);
				}
			}

			setState(461); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Explain_clauseContext extends ParserRuleContext {
		public TerminalNode EXPLAIN() { return getToken(SQLParser.EXPLAIN, 0); }
		public Explain_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explain_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExplain_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExplain_clause(this);
		}
	}

	public final Explain_clauseContext explain_clause() throws RecognitionException {
		Explain_clauseContext _localctx = new Explain_clauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_explain_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463); match(EXPLAIN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Data_statementContext data_statement() {
			return getRuleContext(Data_statementContext.class,0);
		}
		public Index_statementContext index_statement() {
			return getRuleContext(Index_statementContext.class,0);
		}
		public Schema_statementContext schema_statement() {
			return getRuleContext(Schema_statementContext.class,0);
		}
		public Data_change_statementContext data_change_statement() {
			return getRuleContext(Data_change_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(469);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(465); data_statement();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(466); data_change_statement();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(467); schema_statement();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(468); index_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Data_statementContext extends ParserRuleContext {
		public Query_expressionContext query_expression() {
			return getRuleContext(Query_expressionContext.class,0);
		}
		public Data_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterData_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitData_statement(this);
		}
	}

	public final Data_statementContext data_statement() throws RecognitionException {
		Data_statementContext _localctx = new Data_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_data_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471); query_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Data_change_statementContext extends ParserRuleContext {
		public Update_statementContext update_statement() {
			return getRuleContext(Update_statementContext.class,0);
		}
		public Insert_statementContext insert_statement() {
			return getRuleContext(Insert_statementContext.class,0);
		}
		public Delete_statementContext delete_statement() {
			return getRuleContext(Delete_statementContext.class,0);
		}
		public Data_change_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_change_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterData_change_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitData_change_statement(this);
		}
	}

	public final Data_change_statementContext data_change_statement() throws RecognitionException {
		Data_change_statementContext _localctx = new Data_change_statementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_data_change_statement);
		try {
			setState(476);
			switch (_input.LA(1)) {
			case INSERT:
				enterOuterAlt(_localctx, 1);
				{
				setState(473); insert_statement();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(474); update_statement();
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 3);
				{
				setState(475); delete_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Schema_statementContext extends ParserRuleContext {
		public Desc_table_statementContext desc_table_statement() {
			return getRuleContext(Desc_table_statementContext.class,0);
		}
		public Create_table_statementContext create_table_statement() {
			return getRuleContext(Create_table_statementContext.class,0);
		}
		public Database_definitionContext database_definition() {
			return getRuleContext(Database_definitionContext.class,0);
		}
		public Show_tables_statementContext show_tables_statement() {
			return getRuleContext(Show_tables_statementContext.class,0);
		}
		public Alter_tablespace_statementContext alter_tablespace_statement() {
			return getRuleContext(Alter_tablespace_statementContext.class,0);
		}
		public Drop_table_statementContext drop_table_statement() {
			return getRuleContext(Drop_table_statementContext.class,0);
		}
		public Alter_table_statementContext alter_table_statement() {
			return getRuleContext(Alter_table_statementContext.class,0);
		}
		public Drop_database_statementContext drop_database_statement() {
			return getRuleContext(Drop_database_statementContext.class,0);
		}
		public Schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSchema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSchema_statement(this);
		}
	}

	public final Schema_statementContext schema_statement() throws RecognitionException {
		Schema_statementContext _localctx = new Schema_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_schema_statement);
		try {
			setState(486);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(478); database_definition();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(479); drop_database_statement();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(480); create_table_statement();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(481); drop_table_statement();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(482); alter_tablespace_statement();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(483); alter_table_statement();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(484); desc_table_statement();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(485); show_tables_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_statementContext extends ParserRuleContext {
		public Token u;
		public IdentifierContext n;
		public Table_nameContext t;
		public Method_specifierContext m;
		public Sort_specifier_listContext s;
		public Param_clauseContext p;
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public Sort_specifier_listContext sort_specifier_list() {
			return getRuleContext(Sort_specifier_listContext.class,0);
		}
		public Param_clauseContext param_clause() {
			return getRuleContext(Param_clauseContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Method_specifierContext method_specifier() {
			return getRuleContext(Method_specifierContext.class,0);
		}
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INDEX() { return getToken(SQLParser.INDEX, 0); }
		public Index_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIndex_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIndex_statement(this);
		}
	}

	public final Index_statementContext index_statement() throws RecognitionException {
		Index_statementContext _localctx = new Index_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_index_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488); match(CREATE);
			setState(490);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(489); ((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(492); match(INDEX);
			setState(493); ((Index_statementContext)_localctx).n = identifier();
			setState(494); match(ON);
			setState(495); ((Index_statementContext)_localctx).t = table_name();
			setState(497);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(496); ((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(499); match(LEFT_PAREN);
			setState(500); ((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(501); match(RIGHT_PAREN);
			setState(503);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(502); ((Index_statementContext)_localctx).p = param_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Database_definitionContext extends ParserRuleContext {
		public IdentifierContext dbname;
		public If_not_existsContext if_not_exists() {
			return getRuleContext(If_not_existsContext.class,0);
		}
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Database_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDatabase_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDatabase_definition(this);
		}
	}

	public final Database_definitionContext database_definition() throws RecognitionException {
		Database_definitionContext _localctx = new Database_definitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_database_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505); match(CREATE);
			setState(506); match(DATABASE);
			setState(508);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(507); if_not_exists();
				}
			}

			setState(510); ((Database_definitionContext)_localctx).dbname = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_not_existsContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SQLParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public If_not_existsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_not_exists; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIf_not_exists(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIf_not_exists(this);
		}
	}

	public final If_not_existsContext if_not_exists() throws RecognitionException {
		If_not_existsContext _localctx = new If_not_existsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_if_not_exists);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512); match(IF);
			setState(513); match(NOT);
			setState(514); match(EXISTS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_database_statementContext extends ParserRuleContext {
		public IdentifierContext dbname;
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Drop_database_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_database_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDrop_database_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDrop_database_statement(this);
		}
	}

	public final Drop_database_statementContext drop_database_statement() throws RecognitionException {
		Drop_database_statementContext _localctx = new Drop_database_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_drop_database_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516); match(DROP);
			setState(517); match(DATABASE);
			setState(519);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(518); if_exists();
				}
			}

			setState(521); ((Drop_database_statementContext)_localctx).dbname = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_existsContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SQLParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public If_existsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_exists; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIf_exists(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIf_exists(this);
		}
	}

	public final If_existsContext if_exists() throws RecognitionException {
		If_existsContext _localctx = new If_existsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_if_exists);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523); match(IF);
			setState(524); match(EXISTS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Desc_table_statementContext extends ParserRuleContext {
		public TerminalNode DESC() { return getToken(SQLParser.DESC, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Desc_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desc_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDesc_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDesc_table_statement(this);
		}
	}

	public final Desc_table_statementContext desc_table_statement() throws RecognitionException {
		Desc_table_statementContext _localctx = new Desc_table_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_desc_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526); match(DESC);
			setState(527); table_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Show_tables_statementContext extends ParserRuleContext {
		public TerminalNode TABLES() { return getToken(SQLParser.TABLES, 0); }
		public TerminalNode SHOW() { return getToken(SQLParser.SHOW, 0); }
		public Show_tables_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_tables_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterShow_tables_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitShow_tables_statement(this);
		}
	}

	public final Show_tables_statementContext show_tables_statement() throws RecognitionException {
		Show_tables_statementContext _localctx = new Show_tables_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_show_tables_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529); match(SHOW);
			setState(530); match(TABLES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_table_statementContext extends ParserRuleContext {
		public IdentifierContext file_type;
		public Token path;
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public Param_clauseContext param_clause() {
			return getRuleContext(Param_clauseContext.class,0);
		}
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public Table_partitioning_clausesContext table_partitioning_clauses() {
			return getRuleContext(Table_partitioning_clausesContext.class,0);
		}
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Table_elementsContext table_elements() {
			return getRuleContext(Table_elementsContext.class,0);
		}
		public TerminalNode EXTERNAL() { return getToken(SQLParser.EXTERNAL, 0); }
		public If_not_existsContext if_not_exists() {
			return getRuleContext(If_not_existsContext.class,0);
		}
		public Query_expressionContext query_expression() {
			return getRuleContext(Query_expressionContext.class,0);
		}
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Create_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCreate_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCreate_table_statement(this);
		}
	}

	public final Create_table_statementContext create_table_statement() throws RecognitionException {
		Create_table_statementContext _localctx = new Create_table_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_create_table_statement);
		int _la;
		try {
			setState(591);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(532); match(CREATE);
				setState(533); match(EXTERNAL);
				setState(534); match(TABLE);
				setState(536);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(535); if_not_exists();
					}
				}

				setState(538); table_name();
				setState(539); table_elements();
				setState(540); match(USING);
				setState(541); ((Create_table_statementContext)_localctx).file_type = identifier();
				setState(543);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(542); param_clause();
					}
				}

				setState(546);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(545); table_partitioning_clauses();
					}
				}

				{
				setState(548); match(LOCATION);
				setState(549); ((Create_table_statementContext)_localctx).path = match(Character_String_Literal);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(551); match(CREATE);
				setState(552); match(TABLE);
				setState(554);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(553); if_not_exists();
					}
				}

				setState(556); table_name();
				setState(557); table_elements();
				setState(560);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(558); match(USING);
					setState(559); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(563);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(562); param_clause();
					}
				}

				setState(566);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(565); table_partitioning_clauses();
					}
				}

				setState(570);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(568); match(AS);
					setState(569); query_expression();
					}
				}

				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(572); match(CREATE);
				setState(573); match(TABLE);
				setState(575);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(574); if_not_exists();
					}
				}

				setState(577); table_name();
				setState(580);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(578); match(USING);
					setState(579); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(583);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(582); param_clause();
					}
				}

				setState(586);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(585); table_partitioning_clauses();
					}
				}

				setState(588); match(AS);
				setState(589); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_elementsContext extends ParserRuleContext {
		public Field_elementContext field_element(int i) {
			return getRuleContext(Field_elementContext.class,i);
		}
		public List<Constraint_elementContext> constraint_element() {
			return getRuleContexts(Constraint_elementContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Field_elementContext> field_element() {
			return getRuleContexts(Field_elementContext.class);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Constraint_elementContext constraint_element(int i) {
			return getRuleContext(Constraint_elementContext.class,i);
		}
		public Table_elementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_elements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_elements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_elements(this);
		}
	}

	public final Table_elementsContext table_elements() throws RecognitionException {
		Table_elementsContext _localctx = new Table_elementsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_table_elements);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(593); match(LEFT_PAREN);
			setState(594); field_element();
			setState(599);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(595); match(COMMA);
					setState(596); field_element();
					}
					} 
				}
				setState(601);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(602); match(COMMA);
				setState(603); constraint_element();
				}
				}
				setState(608);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(609); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_elementContext extends ParserRuleContext {
		public IdentifierContext name;
		public Field_typeContext field_type() {
			return getRuleContext(Field_typeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Field_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterField_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitField_element(this);
		}
	}

	public final Field_elementContext field_element() throws RecognitionException {
		Field_elementContext _localctx = new Field_elementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611); ((Field_elementContext)_localctx).name = identifier();
			setState(612); field_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_typeContext extends ParserRuleContext {
		public List<Field_decoratorContext> field_decorator() {
			return getRuleContexts(Field_decoratorContext.class);
		}
		public Field_decoratorContext field_decorator(int i) {
			return getRuleContext(Field_decoratorContext.class,i);
		}
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public Field_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterField_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitField_type(this);
		}
	}

	public final Field_typeContext field_type() throws RecognitionException {
		Field_typeContext _localctx = new Field_typeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_field_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614); data_type();
			setState(618);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (NOT - 35)) | (1L << (NULL - 35)) | (1L << (AFTER - 35)) | (1L << (COMMENT - 35)) | (1L << (DEFAULT - 35)))) != 0)) {
				{
				{
				setState(615); field_decorator();
				}
				}
				setState(620);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_decoratorContext extends ParserRuleContext {
		public Default_typeContext default_type() {
			return getRuleContext(Default_typeContext.class,0);
		}
		public Comment_typeContext comment_type() {
			return getRuleContext(Comment_typeContext.class,0);
		}
		public After_typeContext after_type() {
			return getRuleContext(After_typeContext.class,0);
		}
		public Null_notnull_typeContext null_notnull_type() {
			return getRuleContext(Null_notnull_typeContext.class,0);
		}
		public Field_decoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_decorator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterField_decorator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitField_decorator(this);
		}
	}

	public final Field_decoratorContext field_decorator() throws RecognitionException {
		Field_decoratorContext _localctx = new Field_decoratorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_field_decorator);
		try {
			setState(625);
			switch (_input.LA(1)) {
			case NOT:
			case NULL:
				enterOuterAlt(_localctx, 1);
				{
				setState(621); null_notnull_type();
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(622); default_type();
				}
				break;
			case AFTER:
				enterOuterAlt(_localctx, 3);
				{
				setState(623); after_type();
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(624); comment_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constraint_elementContext extends ParserRuleContext {
		public Primary_key_typeContext primary_key_type() {
			return getRuleContext(Primary_key_typeContext.class,0);
		}
		public Unique_typeContext unique_type() {
			return getRuleContext(Unique_typeContext.class,0);
		}
		public Foreign_key_typeContext foreign_key_type() {
			return getRuleContext(Foreign_key_typeContext.class,0);
		}
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Constraint_typeContext constraint_type() {
			return getRuleContext(Constraint_typeContext.class,0);
		}
		public Constraint_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterConstraint_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitConstraint_element(this);
		}
	}

	public final Constraint_elementContext constraint_element() throws RecognitionException {
		Constraint_elementContext _localctx = new Constraint_elementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_constraint_element);
		try {
			setState(635);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(627); primary_key_type();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(628); foreign_key_type();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(629); unique_type();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(630); constraint_type();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(631); match(CONSTRAINT);
				setState(632); identifier();
				setState(633); foreign_key_type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comment_typeContext extends ParserRuleContext {
		public TerminalNode QUOTE(int i) {
			return getToken(SQLParser.QUOTE, i);
		}
		public List<TerminalNode> QUOTE() { return getTokens(SQLParser.QUOTE); }
		public TerminalNode COMMENT() { return getToken(SQLParser.COMMENT, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Comment_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterComment_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitComment_type(this);
		}
	}

	public final Comment_typeContext comment_type() throws RecognitionException {
		Comment_typeContext _localctx = new Comment_typeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_comment_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(637); match(COMMENT);
			setState(638); match(QUOTE);
			setState(639); match(Character_String_Literal);
			setState(640); match(QUOTE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Foreign_key_typeContext extends ParserRuleContext {
		public Column_name_listContext column_name_list(int i) {
			return getRuleContext(Column_name_listContext.class,i);
		}
		public List<Column_name_listContext> column_name_list() {
			return getRuleContexts(Column_name_listContext.class);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public TerminalNode KEY() { return getToken(SQLParser.KEY, 0); }
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public TerminalNode FOREIGN() { return getToken(SQLParser.FOREIGN, 0); }
		public TerminalNode REFERENCES() { return getToken(SQLParser.REFERENCES, 0); }
		public Foreign_key_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreign_key_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterForeign_key_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitForeign_key_type(this);
		}
	}

	public final Foreign_key_typeContext foreign_key_type() throws RecognitionException {
		Foreign_key_typeContext _localctx = new Foreign_key_typeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_foreign_key_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(642); match(FOREIGN);
			setState(643); match(KEY);
			setState(644); match(LEFT_PAREN);
			setState(645); column_name_list();
			setState(646); match(RIGHT_PAREN);
			setState(647); match(REFERENCES);
			setState(648); table_name();
			setState(649); match(LEFT_PAREN);
			setState(650); column_name_list();
			setState(651); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primary_key_typeContext extends ParserRuleContext {
		public Column_name_listContext column_name_list() {
			return getRuleContext(Column_name_listContext.class,0);
		}
		public TerminalNode KEY() { return getToken(SQLParser.KEY, 0); }
		public TerminalNode PRIMARY() { return getToken(SQLParser.PRIMARY, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Primary_key_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_key_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPrimary_key_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPrimary_key_type(this);
		}
	}

	public final Primary_key_typeContext primary_key_type() throws RecognitionException {
		Primary_key_typeContext _localctx = new Primary_key_typeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_primary_key_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653); match(PRIMARY);
			setState(654); match(KEY);
			setState(655); match(LEFT_PAREN);
			setState(656); column_name_list();
			setState(657); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unique_typeContext extends ParserRuleContext {
		public Column_name_listContext column_name_list() {
			return getRuleContext(Column_name_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public Unique_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unique_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUnique_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUnique_type(this);
		}
	}

	public final Unique_typeContext unique_type() throws RecognitionException {
		Unique_typeContext _localctx = new Unique_typeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_unique_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(659); match(UNIQUE);
			setState(660); match(LEFT_PAREN);
			setState(661); column_name_list();
			setState(662); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constraint_typeContext extends ParserRuleContext {
		public Primary_key_typeContext primary_key_type() {
			return getRuleContext(Primary_key_typeContext.class,0);
		}
		public Unique_typeContext unique_type() {
			return getRuleContext(Unique_typeContext.class,0);
		}
		public Foreign_key_typeContext foreign_key_type() {
			return getRuleContext(Foreign_key_typeContext.class,0);
		}
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Constraint_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterConstraint_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitConstraint_type(this);
		}
	}

	public final Constraint_typeContext constraint_type() throws RecognitionException {
		Constraint_typeContext _localctx = new Constraint_typeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constraint_type);
		try {
			setState(676);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(664); match(CONSTRAINT);
				setState(665); identifier();
				setState(666); primary_key_type();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(668); match(CONSTRAINT);
				setState(669); identifier();
				setState(670); foreign_key_type();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(672); match(CONSTRAINT);
				setState(673); identifier();
				setState(674); unique_type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Null_notnull_typeContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public Null_notnull_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_notnull_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNull_notnull_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNull_notnull_type(this);
		}
	}

	public final Null_notnull_typeContext null_notnull_type() throws RecognitionException {
		Null_notnull_typeContext _localctx = new Null_notnull_typeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_null_notnull_type);
		try {
			setState(681);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(678); match(NOT);
				setState(679); match(NULL);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(680); match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class After_typeContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode AFTER() { return getToken(SQLParser.AFTER, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public After_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_after_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAfter_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAfter_type(this);
		}
	}

	public final After_typeContext after_type() throws RecognitionException {
		After_typeContext _localctx = new After_typeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_after_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(683); match(AFTER);
			setState(684); ((After_typeContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Default_typeContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public Row_value_expressionContext row_value_expression() {
			return getRuleContext(Row_value_expressionContext.class,0);
		}
		public Default_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDefault_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDefault_type(this);
		}
	}

	public final Default_typeContext default_type() throws RecognitionException {
		Default_typeContext _localctx = new Default_typeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_default_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(686); match(DEFAULT);
			setState(687); row_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_clauseContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Param_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterParam_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitParam_clause(this);
		}
	}

	public final Param_clauseContext param_clause() throws RecognitionException {
		Param_clauseContext _localctx = new Param_clauseContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(689); match(WITH);
			setState(690); match(LEFT_PAREN);
			setState(691); param();
			setState(696);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(692); match(COMMA);
				setState(693); param();
				}
				}
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(699); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public Token key;
		public Numeric_value_expressionContext value;
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(701); ((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(702); match(EQUAL);
			setState(703); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_specifierContext extends ParserRuleContext {
		public IdentifierContext m;
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Method_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterMethod_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitMethod_specifier(this);
		}
	}

	public final Method_specifierContext method_specifier() throws RecognitionException {
		Method_specifierContext _localctx = new Method_specifierContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705); match(USING);
			setState(706); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_space_specifierContext extends ParserRuleContext {
		public Table_space_nameContext table_space_name() {
			return getRuleContext(Table_space_nameContext.class,0);
		}
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public Table_space_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_space_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_space_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_space_specifier(this);
		}
	}

	public final Table_space_specifierContext table_space_specifier() throws RecognitionException {
		Table_space_specifierContext _localctx = new Table_space_specifierContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708); match(TABLESPACE);
			setState(709); table_space_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_space_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Table_space_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_space_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_space_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_space_name(this);
		}
	}

	public final Table_space_nameContext table_space_name() throws RecognitionException {
		Table_space_nameContext _localctx = new Table_space_nameContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(711); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_partitioning_clausesContext extends ParserRuleContext {
		public Column_partitionsContext column_partitions() {
			return getRuleContext(Column_partitionsContext.class,0);
		}
		public Hash_partitionsContext hash_partitions() {
			return getRuleContext(Hash_partitionsContext.class,0);
		}
		public List_partitionsContext list_partitions() {
			return getRuleContext(List_partitionsContext.class,0);
		}
		public Range_partitionsContext range_partitions() {
			return getRuleContext(Range_partitionsContext.class,0);
		}
		public Table_partitioning_clausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_partitioning_clauses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_partitioning_clauses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_partitioning_clauses(this);
		}
	}

	public final Table_partitioning_clausesContext table_partitioning_clauses() throws RecognitionException {
		Table_partitioning_clausesContext _localctx = new Table_partitioning_clausesContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_table_partitioning_clauses);
		try {
			setState(717);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(713); range_partitions();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(714); hash_partitions();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(715); list_partitions();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(716); column_partitions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Range_partitionsContext extends ParserRuleContext {
		public TerminalNode RANGE() { return getToken(SQLParser.RANGE, 0); }
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public Range_value_clause_listContext range_value_clause_list() {
			return getRuleContext(Range_value_clause_listContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public Range_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_partitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRange_partitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRange_partitions(this);
		}
	}

	public final Range_partitionsContext range_partitions() throws RecognitionException {
		Range_partitionsContext _localctx = new Range_partitionsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719); match(PARTITION);
			setState(720); match(BY);
			setState(721); match(RANGE);
			setState(722); match(LEFT_PAREN);
			setState(723); column_reference_list();
			setState(724); match(RIGHT_PAREN);
			setState(725); match(LEFT_PAREN);
			setState(726); range_value_clause_list();
			setState(727); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Range_value_clause_listContext extends ParserRuleContext {
		public Range_value_clauseContext range_value_clause(int i) {
			return getRuleContext(Range_value_clauseContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Range_value_clauseContext> range_value_clause() {
			return getRuleContexts(Range_value_clauseContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Range_value_clause_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_value_clause_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRange_value_clause_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRange_value_clause_list(this);
		}
	}

	public final Range_value_clause_listContext range_value_clause_list() throws RecognitionException {
		Range_value_clause_listContext _localctx = new Range_value_clause_listContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(729); range_value_clause();
			setState(734);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(730); match(COMMA);
				setState(731); range_value_clause();
				}
				}
				setState(736);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Range_value_clauseContext extends ParserRuleContext {
		public TerminalNode THAN() { return getToken(SQLParser.THAN, 0); }
		public TerminalNode LESS() { return getToken(SQLParser.LESS, 0); }
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public Partition_nameContext partition_name() {
			return getRuleContext(Partition_nameContext.class,0);
		}
		public TerminalNode MAXVALUE() { return getToken(SQLParser.MAXVALUE, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode VALUES() { return getToken(SQLParser.VALUES, 0); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public Range_value_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_value_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRange_value_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRange_value_clause(this);
		}
	}

	public final Range_value_clauseContext range_value_clause() throws RecognitionException {
		Range_value_clauseContext _localctx = new Range_value_clauseContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(737); match(PARTITION);
			setState(738); partition_name();
			setState(739); match(VALUES);
			setState(740); match(LESS);
			setState(741); match(THAN);
			setState(753);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(742); match(LEFT_PAREN);
				setState(743); value_expression();
				setState(744); match(RIGHT_PAREN);
				}
				break;

			case 2:
				{
				setState(747);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(746); match(LEFT_PAREN);
					}
				}

				setState(749); match(MAXVALUE);
				setState(751);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(750); match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Hash_partitionsContext extends ParserRuleContext {
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public Hash_partitions_by_quantityContext hash_partitions_by_quantity() {
			return getRuleContext(Hash_partitions_by_quantityContext.class,0);
		}
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public Individual_hash_partitionsContext individual_hash_partitions() {
			return getRuleContext(Individual_hash_partitionsContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode HASH() { return getToken(SQLParser.HASH, 0); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public Hash_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hash_partitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterHash_partitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitHash_partitions(this);
		}
	}

	public final Hash_partitionsContext hash_partitions() throws RecognitionException {
		Hash_partitionsContext _localctx = new Hash_partitionsContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(755); match(PARTITION);
			setState(756); match(BY);
			setState(757); match(HASH);
			setState(758); match(LEFT_PAREN);
			setState(759); column_reference_list();
			setState(760); match(RIGHT_PAREN);
			setState(766);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(761); match(LEFT_PAREN);
				setState(762); individual_hash_partitions();
				setState(763); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(765); hash_partitions_by_quantity();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Individual_hash_partitionsContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Individual_hash_partitionContext> individual_hash_partition() {
			return getRuleContexts(Individual_hash_partitionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Individual_hash_partitionContext individual_hash_partition(int i) {
			return getRuleContext(Individual_hash_partitionContext.class,i);
		}
		public Individual_hash_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_individual_hash_partitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIndividual_hash_partitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIndividual_hash_partitions(this);
		}
	}

	public final Individual_hash_partitionsContext individual_hash_partitions() throws RecognitionException {
		Individual_hash_partitionsContext _localctx = new Individual_hash_partitionsContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768); individual_hash_partition();
			setState(773);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(769); match(COMMA);
				setState(770); individual_hash_partition();
				}
				}
				setState(775);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Individual_hash_partitionContext extends ParserRuleContext {
		public Partition_nameContext partition_name() {
			return getRuleContext(Partition_nameContext.class,0);
		}
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public Individual_hash_partitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_individual_hash_partition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIndividual_hash_partition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIndividual_hash_partition(this);
		}
	}

	public final Individual_hash_partitionContext individual_hash_partition() throws RecognitionException {
		Individual_hash_partitionContext _localctx = new Individual_hash_partitionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776); match(PARTITION);
			setState(777); partition_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Hash_partitions_by_quantityContext extends ParserRuleContext {
		public Numeric_value_expressionContext quantity;
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public TerminalNode PARTITIONS() { return getToken(SQLParser.PARTITIONS, 0); }
		public Hash_partitions_by_quantityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hash_partitions_by_quantity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterHash_partitions_by_quantity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitHash_partitions_by_quantity(this);
		}
	}

	public final Hash_partitions_by_quantityContext hash_partitions_by_quantity() throws RecognitionException {
		Hash_partitions_by_quantityContext _localctx = new Hash_partitions_by_quantityContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(779); match(PARTITIONS);
			setState(780); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_partitionsContext extends ParserRuleContext {
		public List_value_clause_listContext list_value_clause_list() {
			return getRuleContext(List_value_clause_listContext.class,0);
		}
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode LIST() { return getToken(SQLParser.LIST, 0); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public List_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_partitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterList_partitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitList_partitions(this);
		}
	}

	public final List_partitionsContext list_partitions() throws RecognitionException {
		List_partitionsContext _localctx = new List_partitionsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(782); match(PARTITION);
			setState(783); match(BY);
			setState(784); match(LIST);
			setState(785); match(LEFT_PAREN);
			setState(786); column_reference_list();
			setState(787); match(RIGHT_PAREN);
			setState(788); match(LEFT_PAREN);
			setState(789); list_value_clause_list();
			setState(790); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_value_clause_listContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<List_value_partitionContext> list_value_partition() {
			return getRuleContexts(List_value_partitionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List_value_partitionContext list_value_partition(int i) {
			return getRuleContext(List_value_partitionContext.class,i);
		}
		public List_value_clause_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_value_clause_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterList_value_clause_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitList_value_clause_list(this);
		}
	}

	public final List_value_clause_listContext list_value_clause_list() throws RecognitionException {
		List_value_clause_listContext _localctx = new List_value_clause_listContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(792); list_value_partition();
			setState(797);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(793); match(COMMA);
				setState(794); list_value_partition();
				}
				}
				setState(799);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_value_partitionContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public In_value_listContext in_value_list() {
			return getRuleContext(In_value_listContext.class,0);
		}
		public Partition_nameContext partition_name() {
			return getRuleContext(Partition_nameContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode VALUES() { return getToken(SQLParser.VALUES, 0); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public List_value_partitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_value_partition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterList_value_partition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitList_value_partition(this);
		}
	}

	public final List_value_partitionContext list_value_partition() throws RecognitionException {
		List_value_partitionContext _localctx = new List_value_partitionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(800); match(PARTITION);
			setState(801); partition_name();
			setState(802); match(VALUES);
			setState(804);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(803); match(IN);
				}
			}

			setState(806); match(LEFT_PAREN);
			setState(807); in_value_list();
			setState(808); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_partitionsContext extends ParserRuleContext {
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public Table_elementsContext table_elements() {
			return getRuleContext(Table_elementsContext.class,0);
		}
		public Column_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_partitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterColumn_partitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitColumn_partitions(this);
		}
	}

	public final Column_partitionsContext column_partitions() throws RecognitionException {
		Column_partitionsContext _localctx = new Column_partitionsContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(810); match(PARTITION);
			setState(811); match(BY);
			setState(812); match(COLUMN);
			setState(813); table_elements();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Partition_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Partition_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPartition_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPartition_name(this);
		}
	}

	public final Partition_nameContext partition_name() throws RecognitionException {
		Partition_nameContext _localctx = new Partition_nameContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(815); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_table_statementContext extends ParserRuleContext {
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public TerminalNode PURGE() { return getToken(SQLParser.PURGE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public Drop_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDrop_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDrop_table_statement(this);
		}
	}

	public final Drop_table_statementContext drop_table_statement() throws RecognitionException {
		Drop_table_statementContext _localctx = new Drop_table_statementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_drop_table_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(817); match(DROP);
			setState(818); match(TABLE);
			setState(820);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(819); if_exists();
				}
			}

			setState(822); table_name();
			setState(824);
			_la = _input.LA(1);
			if (_la==PURGE) {
				{
				setState(823); match(PURGE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Quoted_Identifier() { return getToken(SQLParser.Quoted_Identifier, 0); }
		public Nonreserved_keywordsContext nonreserved_keywords() {
			return getRuleContext(Nonreserved_keywordsContext.class,0);
		}
		public TerminalNode Regular_Identifier() { return getToken(SQLParser.Regular_Identifier, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_identifier);
		try {
			setState(829);
			switch (_input.LA(1)) {
			case Regular_Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(826); match(Regular_Identifier);
				}
				break;
			case VALUES:
			case AVG:
			case ADD:
			case ALTER:
			case BETWEEN:
			case BY:
			case CENTURY:
			case CHARACTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COUNT:
			case CUBE:
			case DAY:
			case DEC:
			case DECADE:
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXPLAIN:
			case EXTERNAL:
			case EXTRACT:
			case FILTER:
			case FIRST:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
			case INDEX:
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
			case LAST:
			case LESS:
			case LIST:
			case LOCATION:
			case MAX:
			case MAXVALUE:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case MIN:
			case MINUTE:
			case MONTH:
			case NATIONAL:
			case NULLIF:
			case OVERWRITE:
			case PARTITION:
			case PARTITIONS:
			case PRECISION:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RLIKE:
			case ROLLUP:
			case RENAME:
			case SECOND:
			case SET:
			case SIMILAR:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case THAN:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case UNKNOWN:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
			case WEEK:
			case YEAR:
			case ZONE:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case DECIMAL:
			case CHAR:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
				enterOuterAlt(_localctx, 2);
				{
				setState(827); nonreserved_keywords();
				}
				break;
			case Quoted_Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(828); match(Quoted_Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Nonreserved_keywordsContext extends ParserRuleContext {
		public TerminalNode TIMESTAMP() { return getToken(SQLParser.TIMESTAMP, 0); }
		public TerminalNode COALESCE() { return getToken(SQLParser.COALESCE, 0); }
		public TerminalNode STDDEV_POP() { return getToken(SQLParser.STDDEV_POP, 0); }
		public TerminalNode VAR_SAMP() { return getToken(SQLParser.VAR_SAMP, 0); }
		public TerminalNode BIT() { return getToken(SQLParser.BIT, 0); }
		public TerminalNode SUM() { return getToken(SQLParser.SUM, 0); }
		public TerminalNode INT() { return getToken(SQLParser.INT, 0); }
		public TerminalNode QUARTER() { return getToken(SQLParser.QUARTER, 0); }
		public TerminalNode EVERY() { return getToken(SQLParser.EVERY, 0); }
		public TerminalNode NVARCHAR() { return getToken(SQLParser.NVARCHAR, 0); }
		public TerminalNode INT1() { return getToken(SQLParser.INT1, 0); }
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public TerminalNode MAX() { return getToken(SQLParser.MAX, 0); }
		public TerminalNode ROLLUP() { return getToken(SQLParser.ROLLUP, 0); }
		public TerminalNode SECOND() { return getToken(SQLParser.SECOND, 0); }
		public TerminalNode ADD() { return getToken(SQLParser.ADD, 0); }
		public TerminalNode COUNT() { return getToken(SQLParser.COUNT, 0); }
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public TerminalNode YEAR() { return getToken(SQLParser.YEAR, 0); }
		public TerminalNode SIMILAR() { return getToken(SQLParser.SIMILAR, 0); }
		public TerminalNode RLIKE() { return getToken(SQLParser.RLIKE, 0); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode PURGE() { return getToken(SQLParser.PURGE, 0); }
		public TerminalNode BYTEA() { return getToken(SQLParser.BYTEA, 0); }
		public TerminalNode INTERVAL() { return getToken(SQLParser.INTERVAL, 0); }
		public TerminalNode CHAR() { return getToken(SQLParser.CHAR, 0); }
		public TerminalNode VARBINARY() { return getToken(SQLParser.VARBINARY, 0); }
		public TerminalNode VARCHAR() { return getToken(SQLParser.VARCHAR, 0); }
		public TerminalNode AVG() { return getToken(SQLParser.AVG, 0); }
		public TerminalNode INET4() { return getToken(SQLParser.INET4, 0); }
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode FLOAT8() { return getToken(SQLParser.FLOAT8, 0); }
		public TerminalNode VAR_POP() { return getToken(SQLParser.VAR_POP, 0); }
		public TerminalNode MINUTE() { return getToken(SQLParser.MINUTE, 0); }
		public TerminalNode ISOYEAR() { return getToken(SQLParser.ISOYEAR, 0); }
		public TerminalNode LAST() { return getToken(SQLParser.LAST, 0); }
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public TerminalNode OVERWRITE() { return getToken(SQLParser.OVERWRITE, 0); }
		public TerminalNode NCHAR() { return getToken(SQLParser.NCHAR, 0); }
		public TerminalNode TIMEZONE_HOUR() { return getToken(SQLParser.TIMEZONE_HOUR, 0); }
		public TerminalNode TIMETZ() { return getToken(SQLParser.TIMETZ, 0); }
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode TEXT() { return getToken(SQLParser.TEXT, 0); }
		public TerminalNode MONTH() { return getToken(SQLParser.MONTH, 0); }
		public TerminalNode BLOB() { return getToken(SQLParser.BLOB, 0); }
		public TerminalNode EXPLAIN() { return getToken(SQLParser.EXPLAIN, 0); }
		public TerminalNode DEC() { return getToken(SQLParser.DEC, 0); }
		public TerminalNode INTERSECTION() { return getToken(SQLParser.INTERSECTION, 0); }
		public TerminalNode LESS() { return getToken(SQLParser.LESS, 0); }
		public TerminalNode MILLENNIUM() { return getToken(SQLParser.MILLENNIUM, 0); }
		public TerminalNode TINYINT() { return getToken(SQLParser.TINYINT, 0); }
		public TerminalNode GROUPING() { return getToken(SQLParser.GROUPING, 0); }
		public TerminalNode TIMESTAMPTZ() { return getToken(SQLParser.TIMESTAMPTZ, 0); }
		public TerminalNode NATIONAL() { return getToken(SQLParser.NATIONAL, 0); }
		public TerminalNode BETWEEN() { return getToken(SQLParser.BETWEEN, 0); }
		public TerminalNode DATE() { return getToken(SQLParser.DATE, 0); }
		public TerminalNode FUSION() { return getToken(SQLParser.FUSION, 0); }
		public TerminalNode INT2() { return getToken(SQLParser.INT2, 0); }
		public TerminalNode VARBIT() { return getToken(SQLParser.VARBIT, 0); }
		public TerminalNode WEEK() { return getToken(SQLParser.WEEK, 0); }
		public TerminalNode ZONE() { return getToken(SQLParser.ZONE, 0); }
		public TerminalNode FIRST() { return getToken(SQLParser.FIRST, 0); }
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public TerminalNode NULLIF() { return getToken(SQLParser.NULLIF, 0); }
		public TerminalNode TIME() { return getToken(SQLParser.TIME, 0); }
		public TerminalNode TRIM() { return getToken(SQLParser.TRIM, 0); }
		public TerminalNode INSERT() { return getToken(SQLParser.INSERT, 0); }
		public TerminalNode DOUBLE() { return getToken(SQLParser.DOUBLE, 0); }
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public TerminalNode CENTURY() { return getToken(SQLParser.CENTURY, 0); }
		public TerminalNode LIST() { return getToken(SQLParser.LIST, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode VALUES() { return getToken(SQLParser.VALUES, 0); }
		public TerminalNode SMALLINT() { return getToken(SQLParser.SMALLINT, 0); }
		public TerminalNode ISODOW() { return getToken(SQLParser.ISODOW, 0); }
		public TerminalNode FORMAT() { return getToken(SQLParser.FORMAT, 0); }
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public TerminalNode DOY() { return getToken(SQLParser.DOY, 0); }
		public TerminalNode MIN() { return getToken(SQLParser.MIN, 0); }
		public TerminalNode FILTER() { return getToken(SQLParser.FILTER, 0); }
		public TerminalNode PRECISION() { return getToken(SQLParser.PRECISION, 0); }
		public TerminalNode SUBPARTITION() { return getToken(SQLParser.SUBPARTITION, 0); }
		public TerminalNode DOW() { return getToken(SQLParser.DOW, 0); }
		public TerminalNode EXTERNAL() { return getToken(SQLParser.EXTERNAL, 0); }
		public TerminalNode MICROSECONDS() { return getToken(SQLParser.MICROSECONDS, 0); }
		public TerminalNode HASH() { return getToken(SQLParser.HASH, 0); }
		public TerminalNode DECIMAL() { return getToken(SQLParser.DECIMAL, 0); }
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode THAN() { return getToken(SQLParser.THAN, 0); }
		public TerminalNode EPOCH() { return getToken(SQLParser.EPOCH, 0); }
		public TerminalNode REGEXP() { return getToken(SQLParser.REGEXP, 0); }
		public TerminalNode TIMEZONE() { return getToken(SQLParser.TIMEZONE, 0); }
		public TerminalNode FLOAT4() { return getToken(SQLParser.FLOAT4, 0); }
		public TerminalNode CUBE() { return getToken(SQLParser.CUBE, 0); }
		public TerminalNode UNKNOWN() { return getToken(SQLParser.UNKNOWN, 0); }
		public TerminalNode TIMEZONE_MINUTE() { return getToken(SQLParser.TIMEZONE_MINUTE, 0); }
		public TerminalNode BOOLEAN() { return getToken(SQLParser.BOOLEAN, 0); }
		public TerminalNode CHARACTER() { return getToken(SQLParser.CHARACTER, 0); }
		public TerminalNode REAL() { return getToken(SQLParser.REAL, 0); }
		public TerminalNode DAY() { return getToken(SQLParser.DAY, 0); }
		public TerminalNode COLLECT() { return getToken(SQLParser.COLLECT, 0); }
		public TerminalNode BIGINT() { return getToken(SQLParser.BIGINT, 0); }
		public TerminalNode STDDEV_SAMP() { return getToken(SQLParser.STDDEV_SAMP, 0); }
		public TerminalNode RANGE() { return getToken(SQLParser.RANGE, 0); }
		public TerminalNode FLOAT() { return getToken(SQLParser.FLOAT, 0); }
		public TerminalNode EXTRACT() { return getToken(SQLParser.EXTRACT, 0); }
		public TerminalNode INT4() { return getToken(SQLParser.INT4, 0); }
		public TerminalNode MAXVALUE() { return getToken(SQLParser.MAXVALUE, 0); }
		public TerminalNode MILLISECONDS() { return getToken(SQLParser.MILLISECONDS, 0); }
		public TerminalNode NUMERIC() { return getToken(SQLParser.NUMERIC, 0); }
		public TerminalNode BOOL() { return getToken(SQLParser.BOOL, 0); }
		public TerminalNode INT8() { return getToken(SQLParser.INT8, 0); }
		public TerminalNode DECADE() { return getToken(SQLParser.DECADE, 0); }
		public TerminalNode INTEGER() { return getToken(SQLParser.INTEGER, 0); }
		public TerminalNode INDEX() { return getToken(SQLParser.INDEX, 0); }
		public TerminalNode PARTITIONS() { return getToken(SQLParser.PARTITIONS, 0); }
		public Nonreserved_keywordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonreserved_keywords; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNonreserved_keywords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNonreserved_keywords(this);
		}
	}

	public final Nonreserved_keywordsContext nonreserved_keywords() throws RecognitionException {
		Nonreserved_keywordsContext _localctx = new Nonreserved_keywordsContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(831);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VALUES) | (1L << AVG) | (1L << ADD) | (1L << ALTER) | (1L << BETWEEN) | (1L << BY) | (1L << CENTURY))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CHARACTER - 64)) | (1L << (COLLECT - 64)) | (1L << (COALESCE - 64)) | (1L << (COLUMN - 64)) | (1L << (COUNT - 64)) | (1L << (CUBE - 64)) | (1L << (DAY - 64)) | (1L << (DEC - 64)) | (1L << (DECADE - 64)) | (1L << (DOW - 64)) | (1L << (DOY - 64)) | (1L << (DROP - 64)) | (1L << (EPOCH - 64)) | (1L << (EVERY - 64)) | (1L << (EXISTS - 64)) | (1L << (EXPLAIN - 64)) | (1L << (EXTERNAL - 64)) | (1L << (EXTRACT - 64)) | (1L << (FILTER - 64)) | (1L << (FIRST - 64)) | (1L << (FORMAT - 64)) | (1L << (FUSION - 64)) | (1L << (GROUPING - 64)) | (1L << (HASH - 64)) | (1L << (INDEX - 64)) | (1L << (INSERT - 64)) | (1L << (INTERSECTION - 64)) | (1L << (ISODOW - 64)) | (1L << (ISOYEAR - 64)) | (1L << (LAST - 64)) | (1L << (LESS - 64)) | (1L << (LIST - 64)) | (1L << (LOCATION - 64)) | (1L << (MAX - 64)) | (1L << (MAXVALUE - 64)) | (1L << (MICROSECONDS - 64)) | (1L << (MILLENNIUM - 64)) | (1L << (MILLISECONDS - 64)) | (1L << (MIN - 64)) | (1L << (MINUTE - 64)) | (1L << (MONTH - 64)) | (1L << (NATIONAL - 64)) | (1L << (NULLIF - 64)) | (1L << (OVERWRITE - 64)) | (1L << (PARTITION - 64)) | (1L << (PARTITIONS - 64)) | (1L << (PRECISION - 64)) | (1L << (PURGE - 64)) | (1L << (QUARTER - 64)) | (1L << (RANGE - 64)) | (1L << (REGEXP - 64)) | (1L << (RLIKE - 64)) | (1L << (ROLLUP - 64)) | (1L << (RENAME - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (SECOND - 128)) | (1L << (SET - 128)) | (1L << (SIMILAR - 128)) | (1L << (STDDEV_POP - 128)) | (1L << (STDDEV_SAMP - 128)) | (1L << (SUBPARTITION - 128)) | (1L << (SUM - 128)) | (1L << (TABLESPACE - 128)) | (1L << (THAN - 128)) | (1L << (TIMEZONE - 128)) | (1L << (TIMEZONE_HOUR - 128)) | (1L << (TIMEZONE_MINUTE - 128)) | (1L << (TRIM - 128)) | (1L << (TO - 128)) | (1L << (UNKNOWN - 128)) | (1L << (VAR_SAMP - 128)) | (1L << (VAR_POP - 128)) | (1L << (VARYING - 128)) | (1L << (WEEK - 128)) | (1L << (YEAR - 128)) | (1L << (ZONE - 128)) | (1L << (BOOLEAN - 128)) | (1L << (BOOL - 128)) | (1L << (BIT - 128)) | (1L << (VARBIT - 128)) | (1L << (INT1 - 128)) | (1L << (INT2 - 128)) | (1L << (INT4 - 128)) | (1L << (INT8 - 128)) | (1L << (TINYINT - 128)) | (1L << (SMALLINT - 128)) | (1L << (INT - 128)) | (1L << (INTEGER - 128)) | (1L << (BIGINT - 128)) | (1L << (FLOAT4 - 128)) | (1L << (FLOAT8 - 128)) | (1L << (REAL - 128)) | (1L << (FLOAT - 128)) | (1L << (DOUBLE - 128)) | (1L << (NUMERIC - 128)) | (1L << (DECIMAL - 128)) | (1L << (CHAR - 128)) | (1L << (VARCHAR - 128)) | (1L << (NCHAR - 128)) | (1L << (NVARCHAR - 128)) | (1L << (DATE - 128)) | (1L << (INTERVAL - 128)) | (1L << (TIME - 128)) | (1L << (TIMETZ - 128)) | (1L << (TIMESTAMP - 128)) | (1L << (TIMESTAMPTZ - 128)) | (1L << (TEXT - 128)) | (1L << (VARBINARY - 128)) | (1L << (BLOB - 128)) | (1L << (BYTEA - 128)) | (1L << (INET4 - 128)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_literalContext extends ParserRuleContext {
		public General_literalContext general_literal() {
			return getRuleContext(General_literalContext.class,0);
		}
		public Unsigned_numeric_literalContext unsigned_numeric_literal() {
			return getRuleContext(Unsigned_numeric_literalContext.class,0);
		}
		public Unsigned_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUnsigned_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUnsigned_literal(this);
		}
	}

	public final Unsigned_literalContext unsigned_literal() throws RecognitionException {
		Unsigned_literalContext _localctx = new Unsigned_literalContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_unsigned_literal);
		try {
			setState(835);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(833); unsigned_numeric_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMESTAMP:
			case Character_String_Literal:
				enterOuterAlt(_localctx, 2);
				{
				setState(834); general_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class General_literalContext extends ParserRuleContext {
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Datetime_literalContext datetime_literal() {
			return getRuleContext(Datetime_literalContext.class,0);
		}
		public General_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_general_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGeneral_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGeneral_literal(this);
		}
	}

	public final General_literalContext general_literal() throws RecognitionException {
		General_literalContext _localctx = new General_literalContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_general_literal);
		try {
			setState(840);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(837); match(Character_String_Literal);
				}
				break;
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(838); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(839); boolean_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datetime_literalContext extends ParserRuleContext {
		public Interval_literalContext interval_literal() {
			return getRuleContext(Interval_literalContext.class,0);
		}
		public Timestamp_literalContext timestamp_literal() {
			return getRuleContext(Timestamp_literalContext.class,0);
		}
		public Date_literalContext date_literal() {
			return getRuleContext(Date_literalContext.class,0);
		}
		public Time_literalContext time_literal() {
			return getRuleContext(Time_literalContext.class,0);
		}
		public Datetime_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetime_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDatetime_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDatetime_literal(this);
		}
	}

	public final Datetime_literalContext datetime_literal() throws RecognitionException {
		Datetime_literalContext _localctx = new Datetime_literalContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_datetime_literal);
		try {
			setState(846);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(842); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(843); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(844); date_literal();
				}
				break;
			case INTERVAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(845); interval_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Time_literalContext extends ParserRuleContext {
		public Token time_string;
		public TerminalNode TIME() { return getToken(SQLParser.TIME, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Time_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTime_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTime_literal(this);
		}
	}

	public final Time_literalContext time_literal() throws RecognitionException {
		Time_literalContext _localctx = new Time_literalContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(848); match(TIME);
			setState(849); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Timestamp_literalContext extends ParserRuleContext {
		public Token timestamp_string;
		public TerminalNode TIMESTAMP() { return getToken(SQLParser.TIMESTAMP, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Timestamp_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timestamp_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTimestamp_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTimestamp_literal(this);
		}
	}

	public final Timestamp_literalContext timestamp_literal() throws RecognitionException {
		Timestamp_literalContext _localctx = new Timestamp_literalContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(851); match(TIMESTAMP);
			setState(852); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Date_literalContext extends ParserRuleContext {
		public Token date_string;
		public TerminalNode DATE() { return getToken(SQLParser.DATE, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Date_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDate_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDate_literal(this);
		}
	}

	public final Date_literalContext date_literal() throws RecognitionException {
		Date_literalContext _localctx = new Date_literalContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(854); match(DATE);
			setState(855); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Interval_literalContext extends ParserRuleContext {
		public Token interval_string;
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public TerminalNode INTERVAL() { return getToken(SQLParser.INTERVAL, 0); }
		public Interval_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interval_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterInterval_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitInterval_literal(this);
		}
	}

	public final Interval_literalContext interval_literal() throws RecognitionException {
		Interval_literalContext _localctx = new Interval_literalContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_interval_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(857); match(INTERVAL);
			setState(858); ((Interval_literalContext)_localctx).interval_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_literalContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SQLParser.TRUE, 0); }
		public TerminalNode UNKNOWN() { return getToken(SQLParser.UNKNOWN, 0); }
		public TerminalNode FALSE() { return getToken(SQLParser.FALSE, 0); }
		public Boolean_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBoolean_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBoolean_literal(this);
		}
	}

	public final Boolean_literalContext boolean_literal() throws RecognitionException {
		Boolean_literalContext _localctx = new Boolean_literalContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(860);
			_la = _input.LA(1);
			if ( !(_la==FALSE || _la==TRUE || _la==UNKNOWN) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Data_typeContext extends ParserRuleContext {
		public Predefined_typeContext predefined_type() {
			return getRuleContext(Predefined_typeContext.class,0);
		}
		public Data_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterData_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitData_type(this);
		}
	}

	public final Data_typeContext data_type() throws RecognitionException {
		Data_typeContext _localctx = new Data_typeContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_data_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(862); predefined_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Predefined_typeContext extends ParserRuleContext {
		public Bit_typeContext bit_type() {
			return getRuleContext(Bit_typeContext.class,0);
		}
		public Network_typeContext network_type() {
			return getRuleContext(Network_typeContext.class,0);
		}
		public Character_string_typeContext character_string_type() {
			return getRuleContext(Character_string_typeContext.class,0);
		}
		public Binary_large_object_string_typeContext binary_large_object_string_type() {
			return getRuleContext(Binary_large_object_string_typeContext.class,0);
		}
		public Boolean_typeContext boolean_type() {
			return getRuleContext(Boolean_typeContext.class,0);
		}
		public National_character_string_typeContext national_character_string_type() {
			return getRuleContext(National_character_string_typeContext.class,0);
		}
		public Numeric_typeContext numeric_type() {
			return getRuleContext(Numeric_typeContext.class,0);
		}
		public Binary_typeContext binary_type() {
			return getRuleContext(Binary_typeContext.class,0);
		}
		public Datetime_typeContext datetime_type() {
			return getRuleContext(Datetime_typeContext.class,0);
		}
		public Predefined_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predefined_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPredefined_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPredefined_type(this);
		}
	}

	public final Predefined_typeContext predefined_type() throws RecognitionException {
		Predefined_typeContext _localctx = new Predefined_typeContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_predefined_type);
		try {
			setState(873);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(864); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(865); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(866); binary_large_object_string_type();
				}
				break;
			case DEC:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case DECIMAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(867); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(868); boolean_type();
				}
				break;
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(869); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(870); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(871); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(872); network_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Network_typeContext extends ParserRuleContext {
		public TerminalNode INET4() { return getToken(SQLParser.INET4, 0); }
		public Network_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_network_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNetwork_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNetwork_type(this);
		}
	}

	public final Network_typeContext network_type() throws RecognitionException {
		Network_typeContext _localctx = new Network_typeContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(875); match(INET4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Character_string_typeContext extends ParserRuleContext {
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public TerminalNode CHARACTER() { return getToken(SQLParser.CHARACTER, 0); }
		public TerminalNode TEXT() { return getToken(SQLParser.TEXT, 0); }
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode VARCHAR() { return getToken(SQLParser.VARCHAR, 0); }
		public TerminalNode CHAR() { return getToken(SQLParser.CHAR, 0); }
		public Character_string_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_string_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCharacter_string_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCharacter_string_type(this);
		}
	}

	public final Character_string_typeContext character_string_type() throws RecognitionException {
		Character_string_typeContext _localctx = new Character_string_typeContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_character_string_type);
		int _la;
		try {
			setState(900);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(877); match(CHARACTER);
				setState(879);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(878); type_length();
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(881); match(CHAR);
				setState(883);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(882); type_length();
					}
				}

				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(885); match(CHARACTER);
				setState(886); match(VARYING);
				setState(888);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(887); type_length();
					}
				}

				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(890); match(CHAR);
				setState(891); match(VARYING);
				setState(893);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(892); type_length();
					}
				}

				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(895); match(VARCHAR);
				setState(897);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(896); type_length();
					}
				}

				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(899); match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_lengthContext extends ParserRuleContext {
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Type_lengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_length; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterType_length(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitType_length(this);
		}
	}

	public final Type_lengthContext type_length() throws RecognitionException {
		Type_lengthContext _localctx = new Type_lengthContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(902); match(LEFT_PAREN);
			setState(903); match(NUMBER);
			setState(904); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class National_character_string_typeContext extends ParserRuleContext {
		public TerminalNode NATIONAL() { return getToken(SQLParser.NATIONAL, 0); }
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public TerminalNode CHARACTER() { return getToken(SQLParser.CHARACTER, 0); }
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode NVARCHAR() { return getToken(SQLParser.NVARCHAR, 0); }
		public TerminalNode NCHAR() { return getToken(SQLParser.NCHAR, 0); }
		public TerminalNode CHAR() { return getToken(SQLParser.CHAR, 0); }
		public National_character_string_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_national_character_string_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNational_character_string_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNational_character_string_type(this);
		}
	}

	public final National_character_string_typeContext national_character_string_type() throws RecognitionException {
		National_character_string_typeContext _localctx = new National_character_string_typeContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_national_character_string_type);
		int _la;
		try {
			setState(941);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(906); match(NATIONAL);
				setState(907); match(CHARACTER);
				setState(909);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(908); type_length();
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(911); match(NATIONAL);
				setState(912); match(CHAR);
				setState(914);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(913); type_length();
					}
				}

				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(916); match(NCHAR);
				setState(918);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(917); type_length();
					}
				}

				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(920); match(NATIONAL);
				setState(921); match(CHARACTER);
				setState(922); match(VARYING);
				setState(924);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(923); type_length();
					}
				}

				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(926); match(NATIONAL);
				setState(927); match(CHAR);
				setState(928); match(VARYING);
				setState(930);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(929); type_length();
					}
				}

				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(932); match(NCHAR);
				setState(933); match(VARYING);
				setState(935);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(934); type_length();
					}
				}

				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(937); match(NVARCHAR);
				setState(939);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(938); type_length();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_large_object_string_typeContext extends ParserRuleContext {
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode BLOB() { return getToken(SQLParser.BLOB, 0); }
		public TerminalNode BYTEA() { return getToken(SQLParser.BYTEA, 0); }
		public Binary_large_object_string_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_large_object_string_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBinary_large_object_string_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBinary_large_object_string_type(this);
		}
	}

	public final Binary_large_object_string_typeContext binary_large_object_string_type() throws RecognitionException {
		Binary_large_object_string_typeContext _localctx = new Binary_large_object_string_typeContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_binary_large_object_string_type);
		int _la;
		try {
			setState(951);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(943); match(BLOB);
				setState(945);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(944); type_length();
					}
				}

				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(947); match(BYTEA);
				setState(949);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(948); type_length();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Numeric_typeContext extends ParserRuleContext {
		public Exact_numeric_typeContext exact_numeric_type() {
			return getRuleContext(Exact_numeric_typeContext.class,0);
		}
		public Approximate_numeric_typeContext approximate_numeric_type() {
			return getRuleContext(Approximate_numeric_typeContext.class,0);
		}
		public Numeric_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNumeric_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNumeric_type(this);
		}
	}

	public final Numeric_typeContext numeric_type() throws RecognitionException {
		Numeric_typeContext _localctx = new Numeric_typeContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_numeric_type);
		try {
			setState(955);
			switch (_input.LA(1)) {
			case DEC:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case NUMERIC:
			case DECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(953); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(954); approximate_numeric_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exact_numeric_typeContext extends ParserRuleContext {
		public TerminalNode TINYINT() { return getToken(SQLParser.TINYINT, 0); }
		public TerminalNode INT() { return getToken(SQLParser.INT, 0); }
		public TerminalNode DEC() { return getToken(SQLParser.DEC, 0); }
		public TerminalNode INT1() { return getToken(SQLParser.INT1, 0); }
		public TerminalNode INT4() { return getToken(SQLParser.INT4, 0); }
		public TerminalNode NUMERIC() { return getToken(SQLParser.NUMERIC, 0); }
		public Precision_paramContext precision_param() {
			return getRuleContext(Precision_paramContext.class,0);
		}
		public TerminalNode INT8() { return getToken(SQLParser.INT8, 0); }
		public TerminalNode INT2() { return getToken(SQLParser.INT2, 0); }
		public TerminalNode INTEGER() { return getToken(SQLParser.INTEGER, 0); }
		public TerminalNode BIGINT() { return getToken(SQLParser.BIGINT, 0); }
		public TerminalNode DECIMAL() { return getToken(SQLParser.DECIMAL, 0); }
		public TerminalNode SMALLINT() { return getToken(SQLParser.SMALLINT, 0); }
		public Exact_numeric_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exact_numeric_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExact_numeric_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExact_numeric_type(this);
		}
	}

	public final Exact_numeric_typeContext exact_numeric_type() throws RecognitionException {
		Exact_numeric_typeContext _localctx = new Exact_numeric_typeContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_exact_numeric_type);
		int _la;
		try {
			setState(984);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(957); match(NUMERIC);
				setState(959);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(958); precision_param();
					}
				}

				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(961); match(DECIMAL);
				setState(963);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(962); precision_param();
					}
				}

				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(965); match(DEC);
				setState(967);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(966); precision_param();
					}
				}

				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(969); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(970); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(971); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(972); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(973); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(974); match(INT);
				setState(976);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(975); precision_param();
					}
				}

				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(978); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(979); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(980); match(BIGINT);
				setState(982);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(981); precision_param();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Approximate_numeric_typeContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(SQLParser.FLOAT, 0); }
		public Precision_paramContext precision_param() {
			return getRuleContext(Precision_paramContext.class,0);
		}
		public TerminalNode FLOAT4() { return getToken(SQLParser.FLOAT4, 0); }
		public TerminalNode DOUBLE() { return getToken(SQLParser.DOUBLE, 0); }
		public TerminalNode REAL() { return getToken(SQLParser.REAL, 0); }
		public TerminalNode PRECISION() { return getToken(SQLParser.PRECISION, 0); }
		public TerminalNode FLOAT8() { return getToken(SQLParser.FLOAT8, 0); }
		public Approximate_numeric_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_approximate_numeric_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterApproximate_numeric_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitApproximate_numeric_type(this);
		}
	}

	public final Approximate_numeric_typeContext approximate_numeric_type() throws RecognitionException {
		Approximate_numeric_typeContext _localctx = new Approximate_numeric_typeContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_approximate_numeric_type);
		int _la;
		try {
			setState(996);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(986); match(FLOAT);
				setState(988);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(987); precision_param();
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(990); match(FLOAT4);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(991); match(REAL);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(992); match(FLOAT8);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(993); match(DOUBLE);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(994); match(DOUBLE);
				setState(995); match(PRECISION);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precision_paramContext extends ParserRuleContext {
		public Token precision;
		public Token scale;
		public TerminalNode COMMA() { return getToken(SQLParser.COMMA, 0); }
		public TerminalNode NUMBER(int i) {
			return getToken(SQLParser.NUMBER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(SQLParser.NUMBER); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Precision_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precision_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPrecision_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPrecision_param(this);
		}
	}

	public final Precision_paramContext precision_param() throws RecognitionException {
		Precision_paramContext _localctx = new Precision_paramContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_precision_param);
		try {
			setState(1006);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(998); match(LEFT_PAREN);
				setState(999); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(1000); match(RIGHT_PAREN);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1001); match(LEFT_PAREN);
				setState(1002); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(1003); match(COMMA);
				setState(1004); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(1005); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_typeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(SQLParser.BOOL, 0); }
		public TerminalNode BOOLEAN() { return getToken(SQLParser.BOOLEAN, 0); }
		public Boolean_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBoolean_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBoolean_type(this);
		}
	}

	public final Boolean_typeContext boolean_type() throws RecognitionException {
		Boolean_typeContext _localctx = new Boolean_typeContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1008);
			_la = _input.LA(1);
			if ( !(_la==BOOLEAN || _la==BOOL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datetime_typeContext extends ParserRuleContext {
		public TerminalNode TIMESTAMP() { return getToken(SQLParser.TIMESTAMP, 0); }
		public TerminalNode DATE() { return getToken(SQLParser.DATE, 0); }
		public List<TerminalNode> TIME() { return getTokens(SQLParser.TIME); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode TIME(int i) {
			return getToken(SQLParser.TIME, i);
		}
		public TerminalNode TIMETZ() { return getToken(SQLParser.TIMETZ, 0); }
		public TerminalNode ZONE() { return getToken(SQLParser.ZONE, 0); }
		public TerminalNode INTERVAL() { return getToken(SQLParser.INTERVAL, 0); }
		public TerminalNode TIMESTAMPTZ() { return getToken(SQLParser.TIMESTAMPTZ, 0); }
		public Datetime_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetime_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDatetime_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDatetime_type(this);
		}
	}

	public final Datetime_typeContext datetime_type() throws RecognitionException {
		Datetime_typeContext _localctx = new Datetime_typeContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_datetime_type);
		try {
			setState(1024);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1010); match(DATE);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1011); match(INTERVAL);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1012); match(TIME);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1013); match(TIME);
				setState(1014); match(WITH);
				setState(1015); match(TIME);
				setState(1016); match(ZONE);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1017); match(TIMETZ);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1018); match(TIMESTAMP);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1019); match(TIMESTAMP);
				setState(1020); match(WITH);
				setState(1021); match(TIME);
				setState(1022); match(ZONE);
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1023); match(TIMESTAMPTZ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bit_typeContext extends ParserRuleContext {
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public TerminalNode BIT() { return getToken(SQLParser.BIT, 0); }
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode VARBIT() { return getToken(SQLParser.VARBIT, 0); }
		public Bit_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBit_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBit_type(this);
		}
	}

	public final Bit_typeContext bit_type() throws RecognitionException {
		Bit_typeContext _localctx = new Bit_typeContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_bit_type);
		int _la;
		try {
			setState(1039);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1026); match(BIT);
				setState(1028);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1027); type_length();
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1030); match(VARBIT);
				setState(1032);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1031); type_length();
					}
				}

				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1034); match(BIT);
				setState(1035); match(VARYING);
				setState(1037);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1036); type_length();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_typeContext extends ParserRuleContext {
		public TerminalNode VARBINARY() { return getToken(SQLParser.VARBINARY, 0); }
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode BINARY() { return getToken(SQLParser.BINARY, 0); }
		public Binary_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBinary_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBinary_type(this);
		}
	}

	public final Binary_typeContext binary_type() throws RecognitionException {
		Binary_typeContext _localctx = new Binary_typeContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_binary_type);
		int _la;
		try {
			setState(1054);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1041); match(BINARY);
				setState(1043);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1042); type_length();
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1045); match(BINARY);
				setState(1046); match(VARYING);
				setState(1048);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1047); type_length();
					}
				}

				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1050); match(VARBINARY);
				setState(1052);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1051); type_length();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_expression_primaryContext extends ParserRuleContext {
		public Nonparenthesized_value_expression_primaryContext nonparenthesized_value_expression_primary() {
			return getRuleContext(Nonparenthesized_value_expression_primaryContext.class,0);
		}
		public Parenthesized_value_expressionContext parenthesized_value_expression() {
			return getRuleContext(Parenthesized_value_expressionContext.class,0);
		}
		public Value_expression_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_expression_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterValue_expression_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitValue_expression_primary(this);
		}
	}

	public final Value_expression_primaryContext value_expression_primary() throws RecognitionException {
		Value_expression_primaryContext _localctx = new Value_expression_primaryContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_value_expression_primary);
		try {
			setState(1058);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1056); parenthesized_value_expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1057); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parenthesized_value_expressionContext extends ParserRuleContext {
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Parenthesized_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesized_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterParenthesized_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitParenthesized_value_expression(this);
		}
	}

	public final Parenthesized_value_expressionContext parenthesized_value_expression() throws RecognitionException {
		Parenthesized_value_expressionContext _localctx = new Parenthesized_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1060); match(LEFT_PAREN);
			setState(1061); value_expression();
			setState(1062); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Nonparenthesized_value_expression_primaryContext extends ParserRuleContext {
		public Case_expressionContext case_expression() {
			return getRuleContext(Case_expressionContext.class,0);
		}
		public Unsigned_value_specificationContext unsigned_value_specification() {
			return getRuleContext(Unsigned_value_specificationContext.class,0);
		}
		public Scalar_subqueryContext scalar_subquery() {
			return getRuleContext(Scalar_subqueryContext.class,0);
		}
		public Cast_specificationContext cast_specification() {
			return getRuleContext(Cast_specificationContext.class,0);
		}
		public Set_function_specificationContext set_function_specification() {
			return getRuleContext(Set_function_specificationContext.class,0);
		}
		public Column_referenceContext column_reference() {
			return getRuleContext(Column_referenceContext.class,0);
		}
		public Routine_invocationContext routine_invocation() {
			return getRuleContext(Routine_invocationContext.class,0);
		}
		public Nonparenthesized_value_expression_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonparenthesized_value_expression_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNonparenthesized_value_expression_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNonparenthesized_value_expression_primary(this);
		}
	}

	public final Nonparenthesized_value_expression_primaryContext nonparenthesized_value_expression_primary() throws RecognitionException {
		Nonparenthesized_value_expression_primaryContext _localctx = new Nonparenthesized_value_expression_primaryContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(1071);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1064); unsigned_value_specification();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1065); column_reference();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1066); set_function_specification();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1067); scalar_subquery();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1068); case_expression();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1069); cast_specification();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1070); routine_invocation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_value_specificationContext extends ParserRuleContext {
		public Unsigned_literalContext unsigned_literal() {
			return getRuleContext(Unsigned_literalContext.class,0);
		}
		public Unsigned_value_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_value_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUnsigned_value_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUnsigned_value_specification(this);
		}
	}

	public final Unsigned_value_specificationContext unsigned_value_specification() throws RecognitionException {
		Unsigned_value_specificationContext _localctx = new Unsigned_value_specificationContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1073); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_numeric_literalContext extends ParserRuleContext {
		public TerminalNode REAL_NUMBER() { return getToken(SQLParser.REAL_NUMBER, 0); }
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
		public Unsigned_numeric_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_numeric_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUnsigned_numeric_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUnsigned_numeric_literal(this);
		}
	}

	public final Unsigned_numeric_literalContext unsigned_numeric_literal() throws RecognitionException {
		Unsigned_numeric_literalContext _localctx = new Unsigned_numeric_literalContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1075);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==REAL_NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_numerical_literalContext extends ParserRuleContext {
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public Unsigned_numeric_literalContext unsigned_numeric_literal() {
			return getRuleContext(Unsigned_numeric_literalContext.class,0);
		}
		public Signed_numerical_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_numerical_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSigned_numerical_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSigned_numerical_literal(this);
		}
	}

	public final Signed_numerical_literalContext signed_numerical_literal() throws RecognitionException {
		Signed_numerical_literalContext _localctx = new Signed_numerical_literalContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1078);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(1077); sign();
				}
			}

			setState(1080); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_function_specificationContext extends ParserRuleContext {
		public Aggregate_functionContext aggregate_function() {
			return getRuleContext(Aggregate_functionContext.class,0);
		}
		public Set_function_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_function_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSet_function_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSet_function_specification(this);
		}
	}

	public final Set_function_specificationContext set_function_specification() throws RecognitionException {
		Set_function_specificationContext _localctx = new Set_function_specificationContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1082); aggregate_function();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aggregate_functionContext extends ParserRuleContext {
		public TerminalNode COUNT() { return getToken(SQLParser.COUNT, 0); }
		public TerminalNode MULTIPLY() { return getToken(SQLParser.MULTIPLY, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public General_set_functionContext general_set_function() {
			return getRuleContext(General_set_functionContext.class,0);
		}
		public Filter_clauseContext filter_clause() {
			return getRuleContext(Filter_clauseContext.class,0);
		}
		public Aggregate_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAggregate_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAggregate_function(this);
		}
	}

	public final Aggregate_functionContext aggregate_function() throws RecognitionException {
		Aggregate_functionContext _localctx = new Aggregate_functionContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_aggregate_function);
		try {
			setState(1092);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1084); match(COUNT);
				setState(1085); match(LEFT_PAREN);
				setState(1086); match(MULTIPLY);
				setState(1087); match(RIGHT_PAREN);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1088); general_set_function();
				setState(1090);
				switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
				case 1:
					{
					setState(1089); filter_clause();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class General_set_functionContext extends ParserRuleContext {
		public Set_qualifierContext set_qualifier() {
			return getRuleContext(Set_qualifierContext.class,0);
		}
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Set_function_typeContext set_function_type() {
			return getRuleContext(Set_function_typeContext.class,0);
		}
		public General_set_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_general_set_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGeneral_set_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGeneral_set_function(this);
		}
	}

	public final General_set_functionContext general_set_function() throws RecognitionException {
		General_set_functionContext _localctx = new General_set_functionContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1094); set_function_type();
			setState(1095); match(LEFT_PAREN);
			setState(1097);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(1096); set_qualifier();
				}
			}

			setState(1099); value_expression();
			setState(1100); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_function_typeContext extends ParserRuleContext {
		public TerminalNode STDDEV_SAMP() { return getToken(SQLParser.STDDEV_SAMP, 0); }
		public TerminalNode STDDEV_POP() { return getToken(SQLParser.STDDEV_POP, 0); }
		public TerminalNode VAR_SAMP() { return getToken(SQLParser.VAR_SAMP, 0); }
		public TerminalNode SUM() { return getToken(SQLParser.SUM, 0); }
		public TerminalNode EVERY() { return getToken(SQLParser.EVERY, 0); }
		public TerminalNode ANY() { return getToken(SQLParser.ANY, 0); }
		public TerminalNode AVG() { return getToken(SQLParser.AVG, 0); }
		public TerminalNode INTERSECTION() { return getToken(SQLParser.INTERSECTION, 0); }
		public TerminalNode MIN() { return getToken(SQLParser.MIN, 0); }
		public TerminalNode MAX() { return getToken(SQLParser.MAX, 0); }
		public TerminalNode VAR_POP() { return getToken(SQLParser.VAR_POP, 0); }
		public TerminalNode SOME() { return getToken(SQLParser.SOME, 0); }
		public TerminalNode COUNT() { return getToken(SQLParser.COUNT, 0); }
		public TerminalNode FUSION() { return getToken(SQLParser.FUSION, 0); }
		public TerminalNode COLLECT() { return getToken(SQLParser.COLLECT, 0); }
		public Set_function_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_function_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSet_function_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSet_function_type(this);
		}
	}

	public final Set_function_typeContext set_function_type() throws RecognitionException {
		Set_function_typeContext _localctx = new Set_function_typeContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1102);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << SOME) | (1L << AVG))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (COLLECT - 65)) | (1L << (COUNT - 65)) | (1L << (EVERY - 65)) | (1L << (FUSION - 65)) | (1L << (INTERSECTION - 65)) | (1L << (MAX - 65)) | (1L << (MIN - 65)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (STDDEV_POP - 131)) | (1L << (STDDEV_SAMP - 131)) | (1L << (SUM - 131)) | (1L << (VAR_SAMP - 131)) | (1L << (VAR_POP - 131)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Filter_clauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode FILTER() { return getToken(SQLParser.FILTER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Filter_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFilter_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFilter_clause(this);
		}
	}

	public final Filter_clauseContext filter_clause() throws RecognitionException {
		Filter_clauseContext _localctx = new Filter_clauseContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1104); match(FILTER);
			setState(1105); match(LEFT_PAREN);
			setState(1106); match(WHERE);
			setState(1107); search_condition();
			setState(1108); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Grouping_operationContext extends ParserRuleContext {
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode GROUPING() { return getToken(SQLParser.GROUPING, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Grouping_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouping_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGrouping_operation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGrouping_operation(this);
		}
	}

	public final Grouping_operationContext grouping_operation() throws RecognitionException {
		Grouping_operationContext _localctx = new Grouping_operationContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1110); match(GROUPING);
			setState(1111); match(LEFT_PAREN);
			setState(1112); column_reference_list();
			setState(1113); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_expressionContext extends ParserRuleContext {
		public Case_specificationContext case_specification() {
			return getRuleContext(Case_specificationContext.class,0);
		}
		public Case_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCase_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCase_expression(this);
		}
	}

	public final Case_expressionContext case_expression() throws RecognitionException {
		Case_expressionContext _localctx = new Case_expressionContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1115); case_specification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_abbreviationContext extends ParserRuleContext {
		public TerminalNode COALESCE() { return getToken(SQLParser.COALESCE, 0); }
		public Boolean_value_expressionContext boolean_value_expression(int i) {
			return getRuleContext(Boolean_value_expressionContext.class,i);
		}
		public TerminalNode NULLIF() { return getToken(SQLParser.NULLIF, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Boolean_value_expressionContext> boolean_value_expression() {
			return getRuleContexts(Boolean_value_expressionContext.class);
		}
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Case_abbreviationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_abbreviation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCase_abbreviation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCase_abbreviation(this);
		}
	}

	public final Case_abbreviationContext case_abbreviation() throws RecognitionException {
		Case_abbreviationContext _localctx = new Case_abbreviationContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_case_abbreviation);
		int _la;
		try {
			setState(1135);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(1117); match(NULLIF);
				setState(1118); match(LEFT_PAREN);
				setState(1119); numeric_value_expression();
				setState(1120); match(COMMA);
				setState(1121); boolean_value_expression();
				setState(1122); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1124); match(COALESCE);
				setState(1125); match(LEFT_PAREN);
				setState(1126); numeric_value_expression();
				setState(1129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1127); match(COMMA);
					setState(1128); boolean_value_expression();
					}
					}
					setState(1131); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(1133); match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_specificationContext extends ParserRuleContext {
		public Searched_caseContext searched_case() {
			return getRuleContext(Searched_caseContext.class,0);
		}
		public Simple_caseContext simple_case() {
			return getRuleContext(Simple_caseContext.class,0);
		}
		public Case_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCase_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCase_specification(this);
		}
	}

	public final Case_specificationContext case_specification() throws RecognitionException {
		Case_specificationContext _localctx = new Case_specificationContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_case_specification);
		try {
			setState(1139);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1137); simple_case();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1138); searched_case();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_caseContext extends ParserRuleContext {
		public List<Simple_when_clauseContext> simple_when_clause() {
			return getRuleContexts(Simple_when_clauseContext.class);
		}
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public TerminalNode CASE() { return getToken(SQLParser.CASE, 0); }
		public Simple_when_clauseContext simple_when_clause(int i) {
			return getRuleContext(Simple_when_clauseContext.class,i);
		}
		public Else_clauseContext else_clause() {
			return getRuleContext(Else_clauseContext.class,0);
		}
		public TerminalNode END() { return getToken(SQLParser.END, 0); }
		public Simple_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_case; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSimple_case(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSimple_case(this);
		}
	}

	public final Simple_caseContext simple_case() throws RecognitionException {
		Simple_caseContext _localctx = new Simple_caseContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1141); match(CASE);
			setState(1142); boolean_value_expression();
			setState(1144); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1143); simple_when_clause();
				}
				}
				setState(1146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(1149);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(1148); else_clause();
				}
			}

			setState(1151); match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Searched_caseContext extends ParserRuleContext {
		public List<Searched_when_clauseContext> searched_when_clause() {
			return getRuleContexts(Searched_when_clauseContext.class);
		}
		public TerminalNode CASE() { return getToken(SQLParser.CASE, 0); }
		public Searched_when_clauseContext searched_when_clause(int i) {
			return getRuleContext(Searched_when_clauseContext.class,i);
		}
		public Else_clauseContext else_clause() {
			return getRuleContext(Else_clauseContext.class,0);
		}
		public TerminalNode END() { return getToken(SQLParser.END, 0); }
		public Searched_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searched_case; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSearched_case(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSearched_case(this);
		}
	}

	public final Searched_caseContext searched_case() throws RecognitionException {
		Searched_caseContext _localctx = new Searched_caseContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1153); match(CASE);
			setState(1155); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1154); searched_when_clause();
				}
				}
				setState(1157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(1160);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(1159); else_clause();
				}
			}

			setState(1162); match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_when_clauseContext extends ParserRuleContext {
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public TerminalNode THEN() { return getToken(SQLParser.THEN, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public TerminalNode WHEN() { return getToken(SQLParser.WHEN, 0); }
		public Simple_when_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_when_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSimple_when_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSimple_when_clause(this);
		}
	}

	public final Simple_when_clauseContext simple_when_clause() throws RecognitionException {
		Simple_when_clauseContext _localctx = new Simple_when_clauseContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1164); match(WHEN);
			setState(1165); search_condition();
			setState(1166); match(THEN);
			setState(1167); result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Searched_when_clauseContext extends ParserRuleContext {
		public Search_conditionContext c;
		public ResultContext r;
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public TerminalNode THEN() { return getToken(SQLParser.THEN, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public TerminalNode WHEN() { return getToken(SQLParser.WHEN, 0); }
		public Searched_when_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searched_when_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSearched_when_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSearched_when_clause(this);
		}
	}

	public final Searched_when_clauseContext searched_when_clause() throws RecognitionException {
		Searched_when_clauseContext _localctx = new Searched_when_clauseContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1169); match(WHEN);
			setState(1170); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(1171); match(THEN);
			setState(1172); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_clauseContext extends ParserRuleContext {
		public ResultContext r;
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(SQLParser.ELSE, 0); }
		public Else_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterElse_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitElse_clause(this);
		}
	}

	public final Else_clauseContext else_clause() throws RecognitionException {
		Else_clauseContext _localctx = new Else_clauseContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1174); match(ELSE);
			setState(1175); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResultContext extends ParserRuleContext {
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitResult(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_result);
		try {
			setState(1179);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1177); value_expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1178); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cast_specificationContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Cast_targetContext cast_target() {
			return getRuleContext(Cast_targetContext.class,0);
		}
		public Cast_operandContext cast_operand() {
			return getRuleContext(Cast_operandContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode CAST() { return getToken(SQLParser.CAST, 0); }
		public Cast_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCast_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCast_specification(this);
		}
	}

	public final Cast_specificationContext cast_specification() throws RecognitionException {
		Cast_specificationContext _localctx = new Cast_specificationContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1181); match(CAST);
			setState(1182); match(LEFT_PAREN);
			setState(1183); cast_operand();
			setState(1184); match(AS);
			setState(1185); cast_target();
			setState(1186); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cast_operandContext extends ParserRuleContext {
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public Cast_operandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCast_operand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCast_operand(this);
		}
	}

	public final Cast_operandContext cast_operand() throws RecognitionException {
		Cast_operandContext _localctx = new Cast_operandContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1188); value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cast_targetContext extends ParserRuleContext {
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public Cast_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCast_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCast_target(this);
		}
	}

	public final Cast_targetContext cast_target() throws RecognitionException {
		Cast_targetContext _localctx = new Cast_targetContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1190); data_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_expressionContext extends ParserRuleContext {
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public Common_value_expressionContext common_value_expression() {
			return getRuleContext(Common_value_expressionContext.class,0);
		}
		public Row_value_expressionContext row_value_expression() {
			return getRuleContext(Row_value_expressionContext.class,0);
		}
		public Value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterValue_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitValue_expression(this);
		}
	}

	public final Value_expressionContext value_expression() throws RecognitionException {
		Value_expressionContext _localctx = new Value_expressionContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_value_expression);
		try {
			setState(1195);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1192); common_value_expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1193); row_value_expression();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1194); boolean_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Common_value_expressionContext extends ParserRuleContext {
		public String_value_expressionContext string_value_expression() {
			return getRuleContext(String_value_expressionContext.class,0);
		}
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public Common_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_common_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCommon_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCommon_value_expression(this);
		}
	}

	public final Common_value_expressionContext common_value_expression() throws RecognitionException {
		Common_value_expressionContext _localctx = new Common_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_common_value_expression);
		try {
			setState(1200);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1197); numeric_value_expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1198); string_value_expression();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1199); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Numeric_value_expressionContext extends ParserRuleContext {
		public TermContext left;
		public TermContext right;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TerminalNode MINUS(int i) {
			return getToken(SQLParser.MINUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(SQLParser.MINUS); }
		public List<TerminalNode> PLUS() { return getTokens(SQLParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(SQLParser.PLUS, i);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Numeric_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNumeric_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNumeric_value_expression(this);
		}
	}

	public final Numeric_value_expressionContext numeric_value_expression() throws RecognitionException {
		Numeric_value_expressionContext _localctx = new Numeric_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_numeric_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1202); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(1207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(1203);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1204); ((Numeric_value_expressionContext)_localctx).right = term();
				}
				}
				setState(1209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public FactorContext left;
		public FactorContext right;
		public List<TerminalNode> MODULAR() { return getTokens(SQLParser.MODULAR); }
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TerminalNode MULTIPLY(int i) {
			return getToken(SQLParser.MULTIPLY, i);
		}
		public TerminalNode DIVIDE(int i) {
			return getToken(SQLParser.DIVIDE, i);
		}
		public List<TerminalNode> MULTIPLY() { return getTokens(SQLParser.MULTIPLY); }
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(SQLParser.DIVIDE); }
		public TerminalNode MODULAR(int i) {
			return getToken(SQLParser.MODULAR, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1210); ((TermContext)_localctx).left = factor();
			setState(1215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 207)) & ~0x3f) == 0 && ((1L << (_la - 207)) & ((1L << (MULTIPLY - 207)) | (1L << (DIVIDE - 207)) | (1L << (MODULAR - 207)))) != 0)) {
				{
				{
				setState(1211);
				_la = _input.LA(1);
				if ( !(((((_la - 207)) & ~0x3f) == 0 && ((1L << (_la - 207)) & ((1L << (MULTIPLY - 207)) | (1L << (DIVIDE - 207)) | (1L << (MODULAR - 207)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1212); ((TermContext)_localctx).right = factor();
				}
				}
				setState(1217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public Numeric_primaryContext numeric_primary() {
			return getRuleContext(Numeric_primaryContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1219);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(1218); sign();
				}
			}

			setState(1221); numeric_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Numeric_value_expressionContext> numeric_value_expression() {
			return getRuleContexts(Numeric_value_expressionContext.class);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Numeric_value_expressionContext numeric_value_expression(int i) {
			return getRuleContext(Numeric_value_expressionContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1223); match(LEFT_PAREN);
			setState(1224); numeric_value_expression();
			setState(1229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1225); match(COMMA);
				setState(1226); numeric_value_expression();
				}
				}
				setState(1231);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1232); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Numeric_primaryContext extends ParserRuleContext {
		public Cast_targetContext cast_target(int i) {
			return getRuleContext(Cast_targetContext.class,i);
		}
		public List<Cast_targetContext> cast_target() {
			return getRuleContexts(Cast_targetContext.class);
		}
		public Numeric_value_functionContext numeric_value_function() {
			return getRuleContext(Numeric_value_functionContext.class,0);
		}
		public List<TerminalNode> CAST_EXPRESSION() { return getTokens(SQLParser.CAST_EXPRESSION); }
		public TerminalNode CAST_EXPRESSION(int i) {
			return getToken(SQLParser.CAST_EXPRESSION, i);
		}
		public Value_expression_primaryContext value_expression_primary() {
			return getRuleContext(Value_expression_primaryContext.class,0);
		}
		public Numeric_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNumeric_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNumeric_primary(this);
		}
	}

	public final Numeric_primaryContext numeric_primary() throws RecognitionException {
		Numeric_primaryContext _localctx = new Numeric_primaryContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_numeric_primary);
		int _la;
		try {
			setState(1243);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1234); value_expression_primary();
				setState(1239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(1235); match(CAST_EXPRESSION);
					setState(1236); cast_target();
					}
					}
					setState(1241);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1242); numeric_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(SQLParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SQLParser.PLUS, 0); }
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSign(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1245);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Numeric_value_functionContext extends ParserRuleContext {
		public Extract_expressionContext extract_expression() {
			return getRuleContext(Extract_expressionContext.class,0);
		}
		public Numeric_value_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_value_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNumeric_value_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNumeric_value_function(this);
		}
	}

	public final Numeric_value_functionContext numeric_value_function() throws RecognitionException {
		Numeric_value_functionContext _localctx = new Numeric_value_functionContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1247); extract_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Extract_expressionContext extends ParserRuleContext {
		public Extract_fieldContext extract_field_string;
		public Extract_fieldContext extract_field() {
			return getRuleContext(Extract_fieldContext.class,0);
		}
		public TerminalNode EXTRACT() { return getToken(SQLParser.EXTRACT, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Extract_sourceContext extract_source() {
			return getRuleContext(Extract_sourceContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public Extract_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extract_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExtract_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExtract_expression(this);
		}
	}

	public final Extract_expressionContext extract_expression() throws RecognitionException {
		Extract_expressionContext _localctx = new Extract_expressionContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1249); match(EXTRACT);
			setState(1250); match(LEFT_PAREN);
			setState(1251); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(1252); match(FROM);
			setState(1253); extract_source();
			setState(1254); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Extract_fieldContext extends ParserRuleContext {
		public Extended_datetime_fieldContext extended_datetime_field() {
			return getRuleContext(Extended_datetime_fieldContext.class,0);
		}
		public Primary_datetime_fieldContext primary_datetime_field() {
			return getRuleContext(Primary_datetime_fieldContext.class,0);
		}
		public Time_zone_fieldContext time_zone_field() {
			return getRuleContext(Time_zone_fieldContext.class,0);
		}
		public Extract_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extract_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExtract_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExtract_field(this);
		}
	}

	public final Extract_fieldContext extract_field() throws RecognitionException {
		Extract_fieldContext _localctx = new Extract_fieldContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_extract_field);
		try {
			setState(1259);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1256); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1257); time_zone_field();
				}
				break;
			case CENTURY:
			case DECADE:
			case DOW:
			case DOY:
			case EPOCH:
			case ISODOW:
			case ISOYEAR:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case QUARTER:
			case WEEK:
				enterOuterAlt(_localctx, 3);
				{
				setState(1258); extended_datetime_field();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Time_zone_fieldContext extends ParserRuleContext {
		public TerminalNode TIMEZONE_MINUTE() { return getToken(SQLParser.TIMEZONE_MINUTE, 0); }
		public TerminalNode TIMEZONE() { return getToken(SQLParser.TIMEZONE, 0); }
		public TerminalNode TIMEZONE_HOUR() { return getToken(SQLParser.TIMEZONE_HOUR, 0); }
		public Time_zone_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_zone_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTime_zone_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTime_zone_field(this);
		}
	}

	public final Time_zone_fieldContext time_zone_field() throws RecognitionException {
		Time_zone_fieldContext _localctx = new Time_zone_fieldContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1261);
			_la = _input.LA(1);
			if ( !(((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (TIMEZONE - 138)) | (1L << (TIMEZONE_HOUR - 138)) | (1L << (TIMEZONE_MINUTE - 138)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Extract_sourceContext extends ParserRuleContext {
		public Column_referenceContext column_reference() {
			return getRuleContext(Column_referenceContext.class,0);
		}
		public Datetime_literalContext datetime_literal() {
			return getRuleContext(Datetime_literalContext.class,0);
		}
		public Extract_sourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extract_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExtract_source(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExtract_source(this);
		}
	}

	public final Extract_sourceContext extract_source() throws RecognitionException {
		Extract_sourceContext _localctx = new Extract_sourceContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_extract_source);
		try {
			setState(1265);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1263); column_reference();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1264); datetime_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_value_expressionContext extends ParserRuleContext {
		public Character_value_expressionContext character_value_expression() {
			return getRuleContext(Character_value_expressionContext.class,0);
		}
		public String_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterString_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitString_value_expression(this);
		}
	}

	public final String_value_expressionContext string_value_expression() throws RecognitionException {
		String_value_expressionContext _localctx = new String_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1267); character_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Character_value_expressionContext extends ParserRuleContext {
		public List<TerminalNode> CONCATENATION_OPERATOR() { return getTokens(SQLParser.CONCATENATION_OPERATOR); }
		public List<Character_factorContext> character_factor() {
			return getRuleContexts(Character_factorContext.class);
		}
		public TerminalNode CONCATENATION_OPERATOR(int i) {
			return getToken(SQLParser.CONCATENATION_OPERATOR, i);
		}
		public Character_factorContext character_factor(int i) {
			return getRuleContext(Character_factorContext.class,i);
		}
		public Character_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCharacter_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCharacter_value_expression(this);
		}
	}

	public final Character_value_expressionContext character_value_expression() throws RecognitionException {
		Character_value_expressionContext _localctx = new Character_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1269); character_factor();
			setState(1274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(1270); match(CONCATENATION_OPERATOR);
				setState(1271); character_factor();
				}
				}
				setState(1276);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Character_factorContext extends ParserRuleContext {
		public Character_primaryContext character_primary() {
			return getRuleContext(Character_primaryContext.class,0);
		}
		public Character_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCharacter_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCharacter_factor(this);
		}
	}

	public final Character_factorContext character_factor() throws RecognitionException {
		Character_factorContext _localctx = new Character_factorContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1277); character_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Character_primaryContext extends ParserRuleContext {
		public String_value_functionContext string_value_function() {
			return getRuleContext(String_value_functionContext.class,0);
		}
		public Value_expression_primaryContext value_expression_primary() {
			return getRuleContext(Value_expression_primaryContext.class,0);
		}
		public Character_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCharacter_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCharacter_primary(this);
		}
	}

	public final Character_primaryContext character_primary() throws RecognitionException {
		Character_primaryContext _localctx = new Character_primaryContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_character_primary);
		try {
			setState(1281);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1279); value_expression_primary();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1280); string_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_value_functionContext extends ParserRuleContext {
		public Trim_functionContext trim_function() {
			return getRuleContext(Trim_functionContext.class,0);
		}
		public String_value_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_value_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterString_value_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitString_value_function(this);
		}
	}

	public final String_value_functionContext string_value_function() throws RecognitionException {
		String_value_functionContext _localctx = new String_value_functionContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1283); trim_function();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trim_functionContext extends ParserRuleContext {
		public TerminalNode TRIM() { return getToken(SQLParser.TRIM, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Trim_operandsContext trim_operands() {
			return getRuleContext(Trim_operandsContext.class,0);
		}
		public Trim_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trim_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTrim_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTrim_function(this);
		}
	}

	public final Trim_functionContext trim_function() throws RecognitionException {
		Trim_functionContext _localctx = new Trim_functionContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1285); match(TRIM);
			setState(1286); match(LEFT_PAREN);
			setState(1287); trim_operands();
			setState(1288); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trim_operandsContext extends ParserRuleContext {
		public Character_value_expressionContext trim_character;
		public Character_value_expressionContext trim_source;
		public TerminalNode COMMA() { return getToken(SQLParser.COMMA, 0); }
		public Character_value_expressionContext character_value_expression(int i) {
			return getRuleContext(Character_value_expressionContext.class,i);
		}
		public Trim_specificationContext trim_specification() {
			return getRuleContext(Trim_specificationContext.class,0);
		}
		public List<Character_value_expressionContext> character_value_expression() {
			return getRuleContexts(Character_value_expressionContext.class);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public Trim_operandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trim_operands; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTrim_operands(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTrim_operands(this);
		}
	}

	public final Trim_operandsContext trim_operands() throws RecognitionException {
		Trim_operandsContext _localctx = new Trim_operandsContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_trim_operands);
		int _la;
		try {
			setState(1304);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1297);
				switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
				case 1:
					{
					setState(1291);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOTH) | (1L << LEADING) | (1L << TRAILING))) != 0)) {
						{
						setState(1290); trim_specification();
						}
					}

					setState(1294);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << LEFT) | (1L << RIGHT) | (1L << SOME) | (1L << TRUE) | (1L << VALUES) | (1L << AVG) | (1L << ADD) | (1L << ALTER) | (1L << BETWEEN) | (1L << BY) | (1L << CENTURY))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CHARACTER - 64)) | (1L << (COLLECT - 64)) | (1L << (COALESCE - 64)) | (1L << (COLUMN - 64)) | (1L << (COUNT - 64)) | (1L << (CUBE - 64)) | (1L << (DAY - 64)) | (1L << (DEC - 64)) | (1L << (DECADE - 64)) | (1L << (DOW - 64)) | (1L << (DOY - 64)) | (1L << (DROP - 64)) | (1L << (EPOCH - 64)) | (1L << (EVERY - 64)) | (1L << (EXISTS - 64)) | (1L << (EXPLAIN - 64)) | (1L << (EXTERNAL - 64)) | (1L << (EXTRACT - 64)) | (1L << (FILTER - 64)) | (1L << (FIRST - 64)) | (1L << (FORMAT - 64)) | (1L << (FUSION - 64)) | (1L << (GROUPING - 64)) | (1L << (HASH - 64)) | (1L << (INDEX - 64)) | (1L << (INSERT - 64)) | (1L << (INTERSECTION - 64)) | (1L << (ISODOW - 64)) | (1L << (ISOYEAR - 64)) | (1L << (LAST - 64)) | (1L << (LESS - 64)) | (1L << (LIST - 64)) | (1L << (LOCATION - 64)) | (1L << (MAX - 64)) | (1L << (MAXVALUE - 64)) | (1L << (MICROSECONDS - 64)) | (1L << (MILLENNIUM - 64)) | (1L << (MILLISECONDS - 64)) | (1L << (MIN - 64)) | (1L << (MINUTE - 64)) | (1L << (MONTH - 64)) | (1L << (NATIONAL - 64)) | (1L << (NULLIF - 64)) | (1L << (OVERWRITE - 64)) | (1L << (PARTITION - 64)) | (1L << (PARTITIONS - 64)) | (1L << (PRECISION - 64)) | (1L << (PURGE - 64)) | (1L << (QUARTER - 64)) | (1L << (RANGE - 64)) | (1L << (REGEXP - 64)) | (1L << (RLIKE - 64)) | (1L << (ROLLUP - 64)) | (1L << (RENAME - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (SECOND - 128)) | (1L << (SET - 128)) | (1L << (SIMILAR - 128)) | (1L << (STDDEV_POP - 128)) | (1L << (STDDEV_SAMP - 128)) | (1L << (SUBPARTITION - 128)) | (1L << (SUM - 128)) | (1L << (TABLESPACE - 128)) | (1L << (THAN - 128)) | (1L << (TIMEZONE - 128)) | (1L << (TIMEZONE_HOUR - 128)) | (1L << (TIMEZONE_MINUTE - 128)) | (1L << (TRIM - 128)) | (1L << (TO - 128)) | (1L << (UNKNOWN - 128)) | (1L << (VAR_SAMP - 128)) | (1L << (VAR_POP - 128)) | (1L << (VARYING - 128)) | (1L << (WEEK - 128)) | (1L << (YEAR - 128)) | (1L << (ZONE - 128)) | (1L << (BOOLEAN - 128)) | (1L << (BOOL - 128)) | (1L << (BIT - 128)) | (1L << (VARBIT - 128)) | (1L << (INT1 - 128)) | (1L << (INT2 - 128)) | (1L << (INT4 - 128)) | (1L << (INT8 - 128)) | (1L << (TINYINT - 128)) | (1L << (SMALLINT - 128)) | (1L << (INT - 128)) | (1L << (INTEGER - 128)) | (1L << (BIGINT - 128)) | (1L << (FLOAT4 - 128)) | (1L << (FLOAT8 - 128)) | (1L << (REAL - 128)) | (1L << (FLOAT - 128)) | (1L << (DOUBLE - 128)) | (1L << (NUMERIC - 128)) | (1L << (DECIMAL - 128)) | (1L << (CHAR - 128)) | (1L << (VARCHAR - 128)) | (1L << (NCHAR - 128)) | (1L << (NVARCHAR - 128)) | (1L << (DATE - 128)) | (1L << (INTERVAL - 128)) | (1L << (TIME - 128)) | (1L << (TIMETZ - 128)) | (1L << (TIMESTAMP - 128)) | (1L << (TIMESTAMPTZ - 128)) | (1L << (TEXT - 128)) | (1L << (VARBINARY - 128)) | (1L << (BLOB - 128)) | (1L << (BYTEA - 128)) | (1L << (INET4 - 128)))) != 0) || ((((_la - 203)) & ~0x3f) == 0 && ((1L << (_la - 203)) & ((1L << (LEFT_PAREN - 203)) | (1L << (NUMBER - 203)) | (1L << (REAL_NUMBER - 203)) | (1L << (Regular_Identifier - 203)) | (1L << (Quoted_Identifier - 203)) | (1L << (Character_String_Literal - 203)))) != 0)) {
						{
						setState(1293); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(1296); match(FROM);
					}
					break;
				}
				setState(1299); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1300); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(1301); match(COMMA);
				setState(1302); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trim_specificationContext extends ParserRuleContext {
		public TerminalNode BOTH() { return getToken(SQLParser.BOTH, 0); }
		public TerminalNode TRAILING() { return getToken(SQLParser.TRAILING, 0); }
		public TerminalNode LEADING() { return getToken(SQLParser.LEADING, 0); }
		public Trim_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trim_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTrim_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTrim_specification(this);
		}
	}

	public final Trim_specificationContext trim_specification() throws RecognitionException {
		Trim_specificationContext _localctx = new Trim_specificationContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1306);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOTH) | (1L << LEADING) | (1L << TRAILING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_value_expressionContext extends ParserRuleContext {
		public Or_predicateContext or_predicate() {
			return getRuleContext(Or_predicateContext.class,0);
		}
		public Boolean_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBoolean_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBoolean_value_expression(this);
		}
	}

	public final Boolean_value_expressionContext boolean_value_expression() throws RecognitionException {
		Boolean_value_expressionContext _localctx = new Boolean_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1308); or_predicate();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Or_predicateContext extends ParserRuleContext {
		public List<Or_predicateContext> or_predicate() {
			return getRuleContexts(Or_predicateContext.class);
		}
		public Or_predicateContext or_predicate(int i) {
			return getRuleContext(Or_predicateContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(SQLParser.OR); }
		public And_predicateContext and_predicate() {
			return getRuleContext(And_predicateContext.class,0);
		}
		public TerminalNode OR(int i) {
			return getToken(SQLParser.OR, i);
		}
		public Or_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOr_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOr_predicate(this);
		}
	}

	public final Or_predicateContext or_predicate() throws RecognitionException {
		Or_predicateContext _localctx = new Or_predicateContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1310); and_predicate();
			setState(1315);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1311); match(OR);
					setState(1312); or_predicate();
					}
					} 
				}
				setState(1317);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class And_predicateContext extends ParserRuleContext {
		public Boolean_factorContext boolean_factor() {
			return getRuleContext(Boolean_factorContext.class,0);
		}
		public List<TerminalNode> AND() { return getTokens(SQLParser.AND); }
		public List<And_predicateContext> and_predicate() {
			return getRuleContexts(And_predicateContext.class);
		}
		public TerminalNode AND(int i) {
			return getToken(SQLParser.AND, i);
		}
		public And_predicateContext and_predicate(int i) {
			return getRuleContext(And_predicateContext.class,i);
		}
		public And_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAnd_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAnd_predicate(this);
		}
	}

	public final And_predicateContext and_predicate() throws RecognitionException {
		And_predicateContext _localctx = new And_predicateContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1318); boolean_factor();
			setState(1323);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1319); match(AND);
					setState(1320); and_predicate();
					}
					} 
				}
				setState(1325);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_factorContext extends ParserRuleContext {
		public Boolean_testContext boolean_test() {
			return getRuleContext(Boolean_testContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Boolean_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBoolean_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBoolean_factor(this);
		}
	}

	public final Boolean_factorContext boolean_factor() throws RecognitionException {
		Boolean_factorContext _localctx = new Boolean_factorContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_boolean_factor);
		try {
			setState(1329);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1326); boolean_test();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1327); match(NOT);
				setState(1328); boolean_test();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_testContext extends ParserRuleContext {
		public Is_clauseContext is_clause() {
			return getRuleContext(Is_clauseContext.class,0);
		}
		public Boolean_primaryContext boolean_primary() {
			return getRuleContext(Boolean_primaryContext.class,0);
		}
		public Boolean_testContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBoolean_test(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBoolean_test(this);
		}
	}

	public final Boolean_testContext boolean_test() throws RecognitionException {
		Boolean_testContext _localctx = new Boolean_testContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1331); boolean_primary();
			setState(1333);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(1332); is_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Is_clauseContext extends ParserRuleContext {
		public Truth_valueContext t;
		public Truth_valueContext truth_value() {
			return getRuleContext(Truth_valueContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode IS() { return getToken(SQLParser.IS, 0); }
		public Is_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIs_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIs_clause(this);
		}
	}

	public final Is_clauseContext is_clause() throws RecognitionException {
		Is_clauseContext _localctx = new Is_clauseContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1335); match(IS);
			setState(1337);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1336); match(NOT);
				}
			}

			setState(1339); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Truth_valueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SQLParser.TRUE, 0); }
		public TerminalNode UNKNOWN() { return getToken(SQLParser.UNKNOWN, 0); }
		public TerminalNode FALSE() { return getToken(SQLParser.FALSE, 0); }
		public Truth_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_truth_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTruth_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTruth_value(this);
		}
	}

	public final Truth_valueContext truth_value() throws RecognitionException {
		Truth_valueContext _localctx = new Truth_valueContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1341);
			_la = _input.LA(1);
			if ( !(_la==FALSE || _la==TRUE || _la==UNKNOWN) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_primaryContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public Boolean_predicandContext boolean_predicand() {
			return getRuleContext(Boolean_predicandContext.class,0);
		}
		public Boolean_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBoolean_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBoolean_primary(this);
		}
	}

	public final Boolean_primaryContext boolean_primary() throws RecognitionException {
		Boolean_primaryContext _localctx = new Boolean_primaryContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_boolean_primary);
		try {
			setState(1345);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1343); predicate();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1344); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_predicandContext extends ParserRuleContext {
		public Parenthesized_boolean_value_expressionContext parenthesized_boolean_value_expression() {
			return getRuleContext(Parenthesized_boolean_value_expressionContext.class,0);
		}
		public Nonparenthesized_value_expression_primaryContext nonparenthesized_value_expression_primary() {
			return getRuleContext(Nonparenthesized_value_expression_primaryContext.class,0);
		}
		public Boolean_predicandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_predicand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBoolean_predicand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBoolean_predicand(this);
		}
	}

	public final Boolean_predicandContext boolean_predicand() throws RecognitionException {
		Boolean_predicandContext _localctx = new Boolean_predicandContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_boolean_predicand);
		try {
			setState(1349);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1347); parenthesized_boolean_value_expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1348); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parenthesized_boolean_value_expressionContext extends ParserRuleContext {
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Parenthesized_boolean_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesized_boolean_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterParenthesized_boolean_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitParenthesized_boolean_value_expression(this);
		}
	}

	public final Parenthesized_boolean_value_expressionContext parenthesized_boolean_value_expression() throws RecognitionException {
		Parenthesized_boolean_value_expressionContext _localctx = new Parenthesized_boolean_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1351); match(LEFT_PAREN);
			setState(1352); boolean_value_expression();
			setState(1353); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Row_value_expressionContext extends ParserRuleContext {
		public Row_value_special_caseContext row_value_special_case() {
			return getRuleContext(Row_value_special_caseContext.class,0);
		}
		public Explicit_row_value_constructorContext explicit_row_value_constructor() {
			return getRuleContext(Explicit_row_value_constructorContext.class,0);
		}
		public Row_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRow_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRow_value_expression(this);
		}
	}

	public final Row_value_expressionContext row_value_expression() throws RecognitionException {
		Row_value_expressionContext _localctx = new Row_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_row_value_expression);
		try {
			setState(1357);
			switch (_input.LA(1)) {
			case ANY:
			case CASE:
			case CAST:
			case FALSE:
			case LEFT:
			case RIGHT:
			case SOME:
			case TRUE:
			case VALUES:
			case AVG:
			case ADD:
			case ALTER:
			case BETWEEN:
			case BY:
			case CENTURY:
			case CHARACTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COUNT:
			case CUBE:
			case DAY:
			case DEC:
			case DECADE:
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXPLAIN:
			case EXTERNAL:
			case EXTRACT:
			case FILTER:
			case FIRST:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
			case INDEX:
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
			case LAST:
			case LESS:
			case LIST:
			case LOCATION:
			case MAX:
			case MAXVALUE:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case MIN:
			case MINUTE:
			case MONTH:
			case NATIONAL:
			case NULLIF:
			case OVERWRITE:
			case PARTITION:
			case PARTITIONS:
			case PRECISION:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RLIKE:
			case ROLLUP:
			case RENAME:
			case SECOND:
			case SET:
			case SIMILAR:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case THAN:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case UNKNOWN:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
			case WEEK:
			case YEAR:
			case ZONE:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case DECIMAL:
			case CHAR:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case LEFT_PAREN:
			case NUMBER:
			case REAL_NUMBER:
			case Regular_Identifier:
			case Quoted_Identifier:
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(1355); row_value_special_case();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1356); explicit_row_value_constructor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Row_value_special_caseContext extends ParserRuleContext {
		public Nonparenthesized_value_expression_primaryContext nonparenthesized_value_expression_primary() {
			return getRuleContext(Nonparenthesized_value_expression_primaryContext.class,0);
		}
		public Row_value_special_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_special_case; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRow_value_special_case(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRow_value_special_case(this);
		}
	}

	public final Row_value_special_caseContext row_value_special_case() throws RecognitionException {
		Row_value_special_caseContext _localctx = new Row_value_special_caseContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1359); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Explicit_row_value_constructorContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public Explicit_row_value_constructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicit_row_value_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExplicit_row_value_constructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExplicit_row_value_constructor(this);
		}
	}

	public final Explicit_row_value_constructorContext explicit_row_value_constructor() throws RecognitionException {
		Explicit_row_value_constructorContext _localctx = new Explicit_row_value_constructorContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1361); match(NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Row_value_predicandContext extends ParserRuleContext {
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public Row_value_special_caseContext row_value_special_case() {
			return getRuleContext(Row_value_special_caseContext.class,0);
		}
		public Row_value_constructor_predicandContext row_value_constructor_predicand() {
			return getRuleContext(Row_value_constructor_predicandContext.class,0);
		}
		public Row_value_predicandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_predicand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRow_value_predicand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRow_value_predicand(this);
		}
	}

	public final Row_value_predicandContext row_value_predicand() throws RecognitionException {
		Row_value_predicandContext _localctx = new Row_value_predicandContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_row_value_predicand);
		try {
			setState(1366);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1363); row_value_special_case();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1364); row_value_constructor_predicand();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1365); subquery();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Row_value_constructor_predicandContext extends ParserRuleContext {
		public Boolean_predicandContext boolean_predicand() {
			return getRuleContext(Boolean_predicandContext.class,0);
		}
		public Common_value_expressionContext common_value_expression() {
			return getRuleContext(Common_value_expressionContext.class,0);
		}
		public Row_value_constructor_predicandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_constructor_predicand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRow_value_constructor_predicand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRow_value_constructor_predicand(this);
		}
	}

	public final Row_value_constructor_predicandContext row_value_constructor_predicand() throws RecognitionException {
		Row_value_constructor_predicandContext _localctx = new Row_value_constructor_predicandContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_row_value_constructor_predicand);
		try {
			setState(1370);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1368); common_value_expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1369); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_expressionContext extends ParserRuleContext {
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public From_clauseContext from_clause() {
			return getRuleContext(From_clauseContext.class,0);
		}
		public Groupby_clauseContext groupby_clause() {
			return getRuleContext(Groupby_clauseContext.class,0);
		}
		public Limit_clauseContext limit_clause() {
			return getRuleContext(Limit_clauseContext.class,0);
		}
		public Having_clauseContext having_clause() {
			return getRuleContext(Having_clauseContext.class,0);
		}
		public Orderby_clauseContext orderby_clause() {
			return getRuleContext(Orderby_clauseContext.class,0);
		}
		public Table_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_expression(this);
		}
	}

	public final Table_expressionContext table_expression() throws RecognitionException {
		Table_expressionContext _localctx = new Table_expressionContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1372); from_clause();
			setState(1374);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1373); where_clause();
				}
			}

			setState(1377);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(1376); groupby_clause();
				}
			}

			setState(1380);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(1379); having_clause();
				}
			}

			setState(1383);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(1382); orderby_clause();
				}
			}

			setState(1386);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(1385); limit_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class From_clauseContext extends ParserRuleContext {
		public Table_reference_listContext table_reference_list() {
			return getRuleContext(Table_reference_listContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public From_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFrom_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFrom_clause(this);
		}
	}

	public final From_clauseContext from_clause() throws RecognitionException {
		From_clauseContext _localctx = new From_clauseContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1388); match(FROM);
			setState(1389); table_reference_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_reference_listContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Table_referenceContext table_reference(int i) {
			return getRuleContext(Table_referenceContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<Table_referenceContext> table_reference() {
			return getRuleContexts(Table_referenceContext.class);
		}
		public Table_reference_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_reference_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_reference_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_reference_list(this);
		}
	}

	public final Table_reference_listContext table_reference_list() throws RecognitionException {
		Table_reference_listContext _localctx = new Table_reference_listContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1391); table_reference();
			setState(1396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1392); match(COMMA);
				setState(1393); table_reference();
				}
				}
				setState(1398);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_referenceContext extends ParserRuleContext {
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Table_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_reference(this);
		}
	}

	public final Table_referenceContext table_reference() throws RecognitionException {
		Table_referenceContext _localctx = new Table_referenceContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_table_reference);
		try {
			setState(1401);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1399); joined_table();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1400); table_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Joined_tableContext extends ParserRuleContext {
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public List<Joined_table_primaryContext> joined_table_primary() {
			return getRuleContexts(Joined_table_primaryContext.class);
		}
		public Joined_table_primaryContext joined_table_primary(int i) {
			return getRuleContext(Joined_table_primaryContext.class,i);
		}
		public Joined_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joined_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterJoined_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitJoined_table(this);
		}
	}

	public final Joined_tableContext joined_table() throws RecognitionException {
		Joined_tableContext _localctx = new Joined_tableContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1403); table_primary();
			setState(1405); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1404); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1407); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			} while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Joined_table_primaryContext extends ParserRuleContext {
		public Table_primaryContext right;
		public Join_typeContext t;
		public Join_specificationContext s;
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public TerminalNode UNION() { return getToken(SQLParser.UNION, 0); }
		public Join_typeContext join_type() {
			return getRuleContext(Join_typeContext.class,0);
		}
		public TerminalNode NATURAL() { return getToken(SQLParser.NATURAL, 0); }
		public TerminalNode CROSS() { return getToken(SQLParser.CROSS, 0); }
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Join_specificationContext join_specification() {
			return getRuleContext(Join_specificationContext.class,0);
		}
		public Joined_table_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joined_table_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterJoined_table_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitJoined_table_primary(this);
		}
	}

	public final Joined_table_primaryContext joined_table_primary() throws RecognitionException {
		Joined_table_primaryContext _localctx = new Joined_table_primaryContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_joined_table_primary);
		int _la;
		try {
			setState(1428);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(1409); match(CROSS);
				setState(1410); match(JOIN);
				setState(1411); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1413);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FULL) | (1L << INNER) | (1L << LEFT) | (1L << RIGHT))) != 0)) {
					{
					setState(1412); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(1415); match(JOIN);
				setState(1416); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(1417); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1419); match(NATURAL);
				setState(1421);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FULL) | (1L << INNER) | (1L << LEFT) | (1L << RIGHT))) != 0)) {
					{
					setState(1420); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(1423); match(JOIN);
				setState(1424); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(1425); match(UNION);
				setState(1426); match(JOIN);
				setState(1427); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cross_joinContext extends ParserRuleContext {
		public Table_primaryContext r;
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public TerminalNode CROSS() { return getToken(SQLParser.CROSS, 0); }
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Cross_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cross_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCross_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCross_join(this);
		}
	}

	public final Cross_joinContext cross_join() throws RecognitionException {
		Cross_joinContext _localctx = new Cross_joinContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1430); match(CROSS);
			setState(1431); match(JOIN);
			setState(1432); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Qualified_joinContext extends ParserRuleContext {
		public Join_typeContext t;
		public Table_primaryContext r;
		public Join_specificationContext s;
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public Join_typeContext join_type() {
			return getRuleContext(Join_typeContext.class,0);
		}
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Join_specificationContext join_specification() {
			return getRuleContext(Join_specificationContext.class,0);
		}
		public Qualified_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualified_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQualified_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQualified_join(this);
		}
	}

	public final Qualified_joinContext qualified_join() throws RecognitionException {
		Qualified_joinContext _localctx = new Qualified_joinContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1435);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FULL) | (1L << INNER) | (1L << LEFT) | (1L << RIGHT))) != 0)) {
				{
				setState(1434); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(1437); match(JOIN);
			setState(1438); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(1439); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Natural_joinContext extends ParserRuleContext {
		public Join_typeContext t;
		public Table_primaryContext r;
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public Join_typeContext join_type() {
			return getRuleContext(Join_typeContext.class,0);
		}
		public TerminalNode NATURAL() { return getToken(SQLParser.NATURAL, 0); }
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Natural_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_natural_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNatural_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNatural_join(this);
		}
	}

	public final Natural_joinContext natural_join() throws RecognitionException {
		Natural_joinContext _localctx = new Natural_joinContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1441); match(NATURAL);
			setState(1443);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FULL) | (1L << INNER) | (1L << LEFT) | (1L << RIGHT))) != 0)) {
				{
				setState(1442); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(1445); match(JOIN);
			setState(1446); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Union_joinContext extends ParserRuleContext {
		public Table_primaryContext r;
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public TerminalNode UNION() { return getToken(SQLParser.UNION, 0); }
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Union_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUnion_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUnion_join(this);
		}
	}

	public final Union_joinContext union_join() throws RecognitionException {
		Union_joinContext _localctx = new Union_joinContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1448); match(UNION);
			setState(1449); match(JOIN);
			setState(1450); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_typeContext extends ParserRuleContext {
		public Outer_join_typeContext t;
		public Outer_join_typeContext outer_join_type() {
			return getRuleContext(Outer_join_typeContext.class,0);
		}
		public TerminalNode INNER() { return getToken(SQLParser.INNER, 0); }
		public Join_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterJoin_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitJoin_type(this);
		}
	}

	public final Join_typeContext join_type() throws RecognitionException {
		Join_typeContext _localctx = new Join_typeContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_join_type);
		try {
			setState(1454);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1452); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1453); ((Join_typeContext)_localctx).t = outer_join_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outer_join_typeContext extends ParserRuleContext {
		public TerminalNode OUTER() { return getToken(SQLParser.OUTER, 0); }
		public Outer_join_type_part2Context outer_join_type_part2() {
			return getRuleContext(Outer_join_type_part2Context.class,0);
		}
		public Outer_join_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outer_join_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOuter_join_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOuter_join_type(this);
		}
	}

	public final Outer_join_typeContext outer_join_type() throws RecognitionException {
		Outer_join_typeContext _localctx = new Outer_join_typeContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1456); outer_join_type_part2();
			setState(1458);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(1457); match(OUTER);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outer_join_type_part2Context extends ParserRuleContext {
		public TerminalNode FULL() { return getToken(SQLParser.FULL, 0); }
		public TerminalNode LEFT() { return getToken(SQLParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(SQLParser.RIGHT, 0); }
		public Outer_join_type_part2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outer_join_type_part2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOuter_join_type_part2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOuter_join_type_part2(this);
		}
	}

	public final Outer_join_type_part2Context outer_join_type_part2() throws RecognitionException {
		Outer_join_type_part2Context _localctx = new Outer_join_type_part2Context(_ctx, getState());
		enterRule(_localctx, 286, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1460);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FULL) | (1L << LEFT) | (1L << RIGHT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_specificationContext extends ParserRuleContext {
		public Named_columns_joinContext named_columns_join() {
			return getRuleContext(Named_columns_joinContext.class,0);
		}
		public Join_conditionContext join_condition() {
			return getRuleContext(Join_conditionContext.class,0);
		}
		public Join_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterJoin_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitJoin_specification(this);
		}
	}

	public final Join_specificationContext join_specification() throws RecognitionException {
		Join_specificationContext _localctx = new Join_specificationContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_join_specification);
		try {
			setState(1464);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(1462); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1463); named_columns_join();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_conditionContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public Join_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterJoin_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitJoin_condition(this);
		}
	}

	public final Join_conditionContext join_condition() throws RecognitionException {
		Join_conditionContext _localctx = new Join_conditionContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1466); match(ON);
			setState(1467); search_condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Named_columns_joinContext extends ParserRuleContext {
		public Column_reference_listContext f;
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Named_columns_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_named_columns_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNamed_columns_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNamed_columns_join(this);
		}
	}

	public final Named_columns_joinContext named_columns_join() throws RecognitionException {
		Named_columns_joinContext _localctx = new Named_columns_joinContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1469); match(USING);
			setState(1470); match(LEFT_PAREN);
			setState(1471); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(1472); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_primaryContext extends ParserRuleContext {
		public IdentifierContext alias;
		public IdentifierContext name;
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Derived_tableContext derived_table() {
			return getRuleContext(Derived_tableContext.class,0);
		}
		public Column_name_listContext column_name_list() {
			return getRuleContext(Column_name_listContext.class,0);
		}
		public Table_or_query_nameContext table_or_query_name() {
			return getRuleContext(Table_or_query_nameContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Table_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_primary(this);
		}
	}

	public final Table_primaryContext table_primary() throws RecognitionException {
		Table_primaryContext _localctx = new Table_primaryContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_table_primary);
		int _la;
		try {
			setState(1498);
			switch (_input.LA(1)) {
			case VALUES:
			case AVG:
			case ADD:
			case ALTER:
			case BETWEEN:
			case BY:
			case CENTURY:
			case CHARACTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COUNT:
			case CUBE:
			case DAY:
			case DEC:
			case DECADE:
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXPLAIN:
			case EXTERNAL:
			case EXTRACT:
			case FILTER:
			case FIRST:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
			case INDEX:
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
			case LAST:
			case LESS:
			case LIST:
			case LOCATION:
			case MAX:
			case MAXVALUE:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case MIN:
			case MINUTE:
			case MONTH:
			case NATIONAL:
			case NULLIF:
			case OVERWRITE:
			case PARTITION:
			case PARTITIONS:
			case PRECISION:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RLIKE:
			case ROLLUP:
			case RENAME:
			case SECOND:
			case SET:
			case SIMILAR:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case THAN:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case UNKNOWN:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
			case WEEK:
			case YEAR:
			case ZONE:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case DECIMAL:
			case CHAR:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case Regular_Identifier:
			case Quoted_Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1474); table_or_query_name();
				setState(1479);
				switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
				case 1:
					{
					setState(1476);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(1475); match(AS);
						}
					}

					setState(1478); ((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(1485);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1481); match(LEFT_PAREN);
					setState(1482); column_name_list();
					setState(1483); match(RIGHT_PAREN);
					}
				}

				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1487); derived_table();
				setState(1489);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1488); match(AS);
					}
				}

				setState(1491); ((Table_primaryContext)_localctx).name = identifier();
				setState(1496);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1492); match(LEFT_PAREN);
					setState(1493); column_name_list();
					setState(1494); match(RIGHT_PAREN);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_name_listContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Column_name_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterColumn_name_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitColumn_name_list(this);
		}
	}

	public final Column_name_listContext column_name_list() throws RecognitionException {
		Column_name_listContext _localctx = new Column_name_listContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1500); identifier();
			setState(1505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1501); match(COMMA);
				setState(1502); identifier();
				}
				}
				setState(1507);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Derived_tableContext extends ParserRuleContext {
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public Derived_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derived_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDerived_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDerived_table(this);
		}
	}

	public final Derived_tableContext derived_table() throws RecognitionException {
		Derived_tableContext _localctx = new Derived_tableContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1508); table_subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Where_clauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public Where_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterWhere_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitWhere_clause(this);
		}
	}

	public final Where_clauseContext where_clause() throws RecognitionException {
		Where_clauseContext _localctx = new Where_clauseContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1510); match(WHERE);
			setState(1511); search_condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Search_conditionContext extends ParserRuleContext {
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public Search_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_search_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSearch_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSearch_condition(this);
		}
	}

	public final Search_conditionContext search_condition() throws RecognitionException {
		Search_conditionContext _localctx = new Search_conditionContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1513); value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Groupby_clauseContext extends ParserRuleContext {
		public Grouping_element_listContext g;
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public Grouping_element_listContext grouping_element_list() {
			return getRuleContext(Grouping_element_listContext.class,0);
		}
		public TerminalNode GROUP() { return getToken(SQLParser.GROUP, 0); }
		public Groupby_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupby_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGroupby_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGroupby_clause(this);
		}
	}

	public final Groupby_clauseContext groupby_clause() throws RecognitionException {
		Groupby_clauseContext _localctx = new Groupby_clauseContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1515); match(GROUP);
			setState(1516); match(BY);
			setState(1517); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Grouping_element_listContext extends ParserRuleContext {
		public Grouping_elementContext grouping_element(int i) {
			return getRuleContext(Grouping_elementContext.class,i);
		}
		public List<Grouping_elementContext> grouping_element() {
			return getRuleContexts(Grouping_elementContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Grouping_element_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouping_element_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGrouping_element_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGrouping_element_list(this);
		}
	}

	public final Grouping_element_listContext grouping_element_list() throws RecognitionException {
		Grouping_element_listContext _localctx = new Grouping_element_listContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1519); grouping_element();
			setState(1524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1520); match(COMMA);
				setState(1521); grouping_element();
				}
				}
				setState(1526);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Grouping_elementContext extends ParserRuleContext {
		public Cube_listContext cube_list() {
			return getRuleContext(Cube_listContext.class,0);
		}
		public Empty_grouping_setContext empty_grouping_set() {
			return getRuleContext(Empty_grouping_setContext.class,0);
		}
		public Ordinary_grouping_setContext ordinary_grouping_set() {
			return getRuleContext(Ordinary_grouping_setContext.class,0);
		}
		public Rollup_listContext rollup_list() {
			return getRuleContext(Rollup_listContext.class,0);
		}
		public Grouping_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouping_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGrouping_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGrouping_element(this);
		}
	}

	public final Grouping_elementContext grouping_element() throws RecognitionException {
		Grouping_elementContext _localctx = new Grouping_elementContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_grouping_element);
		try {
			setState(1531);
			switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1527); rollup_list();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1528); cube_list();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1529); empty_grouping_set();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1530); ordinary_grouping_set();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ordinary_grouping_setContext extends ParserRuleContext {
		public Row_value_predicandContext row_value_predicand() {
			return getRuleContext(Row_value_predicandContext.class,0);
		}
		public Row_value_predicand_listContext row_value_predicand_list() {
			return getRuleContext(Row_value_predicand_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Ordinary_grouping_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordinary_grouping_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOrdinary_grouping_set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOrdinary_grouping_set(this);
		}
	}

	public final Ordinary_grouping_setContext ordinary_grouping_set() throws RecognitionException {
		Ordinary_grouping_setContext _localctx = new Ordinary_grouping_setContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_ordinary_grouping_set);
		try {
			setState(1538);
			switch ( getInterpreter().adaptivePredict(_input,148,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1533); row_value_predicand();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1534); match(LEFT_PAREN);
				setState(1535); row_value_predicand_list();
				setState(1536); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ordinary_grouping_set_listContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Ordinary_grouping_setContext> ordinary_grouping_set() {
			return getRuleContexts(Ordinary_grouping_setContext.class);
		}
		public Ordinary_grouping_setContext ordinary_grouping_set(int i) {
			return getRuleContext(Ordinary_grouping_setContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Ordinary_grouping_set_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordinary_grouping_set_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOrdinary_grouping_set_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOrdinary_grouping_set_list(this);
		}
	}

	public final Ordinary_grouping_set_listContext ordinary_grouping_set_list() throws RecognitionException {
		Ordinary_grouping_set_listContext _localctx = new Ordinary_grouping_set_listContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1540); ordinary_grouping_set();
			setState(1545);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1541); match(COMMA);
				setState(1542); ordinary_grouping_set();
				}
				}
				setState(1547);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rollup_listContext extends ParserRuleContext {
		public Ordinary_grouping_set_listContext c;
		public Ordinary_grouping_set_listContext ordinary_grouping_set_list() {
			return getRuleContext(Ordinary_grouping_set_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode ROLLUP() { return getToken(SQLParser.ROLLUP, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Rollup_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rollup_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRollup_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRollup_list(this);
		}
	}

	public final Rollup_listContext rollup_list() throws RecognitionException {
		Rollup_listContext _localctx = new Rollup_listContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1548); match(ROLLUP);
			setState(1549); match(LEFT_PAREN);
			setState(1550); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(1551); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cube_listContext extends ParserRuleContext {
		public Ordinary_grouping_set_listContext c;
		public Ordinary_grouping_set_listContext ordinary_grouping_set_list() {
			return getRuleContext(Ordinary_grouping_set_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode CUBE() { return getToken(SQLParser.CUBE, 0); }
		public Cube_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cube_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCube_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCube_list(this);
		}
	}

	public final Cube_listContext cube_list() throws RecognitionException {
		Cube_listContext _localctx = new Cube_listContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1553); match(CUBE);
			setState(1554); match(LEFT_PAREN);
			setState(1555); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(1556); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Empty_grouping_setContext extends ParserRuleContext {
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Empty_grouping_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_empty_grouping_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterEmpty_grouping_set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitEmpty_grouping_set(this);
		}
	}

	public final Empty_grouping_setContext empty_grouping_set() throws RecognitionException {
		Empty_grouping_setContext _localctx = new Empty_grouping_setContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1558); match(LEFT_PAREN);
			setState(1559); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Having_clauseContext extends ParserRuleContext {
		public TerminalNode HAVING() { return getToken(SQLParser.HAVING, 0); }
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public Having_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_having_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterHaving_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitHaving_clause(this);
		}
	}

	public final Having_clauseContext having_clause() throws RecognitionException {
		Having_clauseContext _localctx = new Having_clauseContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1561); match(HAVING);
			setState(1562); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Row_value_predicand_listContext extends ParserRuleContext {
		public Row_value_predicandContext row_value_predicand(int i) {
			return getRuleContext(Row_value_predicandContext.class,i);
		}
		public List<Row_value_predicandContext> row_value_predicand() {
			return getRuleContexts(Row_value_predicandContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Row_value_predicand_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_predicand_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRow_value_predicand_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRow_value_predicand_list(this);
		}
	}

	public final Row_value_predicand_listContext row_value_predicand_list() throws RecognitionException {
		Row_value_predicand_listContext _localctx = new Row_value_predicand_listContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1564); row_value_predicand();
			setState(1569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1565); match(COMMA);
				setState(1566); row_value_predicand();
				}
				}
				setState(1571);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Query_expressionContext extends ParserRuleContext {
		public Query_expression_bodyContext query_expression_body() {
			return getRuleContext(Query_expression_bodyContext.class,0);
		}
		public Query_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuery_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuery_expression(this);
		}
	}

	public final Query_expressionContext query_expression() throws RecognitionException {
		Query_expressionContext _localctx = new Query_expressionContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1572); query_expression_body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Query_expression_bodyContext extends ParserRuleContext {
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Non_join_query_expressionContext non_join_query_expression() {
			return getRuleContext(Non_join_query_expressionContext.class,0);
		}
		public Query_expression_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_expression_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuery_expression_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuery_expression_body(this);
		}
	}

	public final Query_expression_bodyContext query_expression_body() throws RecognitionException {
		Query_expression_bodyContext _localctx = new Query_expression_bodyContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_query_expression_body);
		try {
			setState(1576);
			switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1574); non_join_query_expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1575); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Non_join_query_expressionContext extends ParserRuleContext {
		public List<TerminalNode> EXCEPT() { return getTokens(SQLParser.EXCEPT); }
		public List<TerminalNode> UNION() { return getTokens(SQLParser.UNION); }
		public List<TerminalNode> ALL() { return getTokens(SQLParser.ALL); }
		public TerminalNode EXCEPT(int i) {
			return getToken(SQLParser.EXCEPT, i);
		}
		public Query_termContext query_term(int i) {
			return getRuleContext(Query_termContext.class,i);
		}
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Non_join_query_termContext non_join_query_term() {
			return getRuleContext(Non_join_query_termContext.class,0);
		}
		public List<TerminalNode> DISTINCT() { return getTokens(SQLParser.DISTINCT); }
		public TerminalNode ALL(int i) {
			return getToken(SQLParser.ALL, i);
		}
		public TerminalNode DISTINCT(int i) {
			return getToken(SQLParser.DISTINCT, i);
		}
		public List<Query_termContext> query_term() {
			return getRuleContexts(Query_termContext.class);
		}
		public TerminalNode UNION(int i) {
			return getToken(SQLParser.UNION, i);
		}
		public Non_join_query_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_join_query_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNon_join_query_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNon_join_query_expression(this);
		}
	}

	public final Non_join_query_expressionContext non_join_query_expression() throws RecognitionException {
		Non_join_query_expressionContext _localctx = new Non_join_query_expressionContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1586);
			switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
			case 1:
				{
				setState(1578); non_join_query_term();
				}
				break;

			case 2:
				{
				setState(1579); joined_table();
				setState(1580);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1582);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1581);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1584); query_term();
				}
				break;
			}
			setState(1595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(1588);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1590);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1589);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1592); query_term();
				}
				}
				setState(1597);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Query_termContext extends ParserRuleContext {
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Non_join_query_termContext non_join_query_term() {
			return getRuleContext(Non_join_query_termContext.class,0);
		}
		public Query_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuery_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuery_term(this);
		}
	}

	public final Query_termContext query_term() throws RecognitionException {
		Query_termContext _localctx = new Query_termContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_query_term);
		try {
			setState(1600);
			switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1598); non_join_query_term();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1599); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Non_join_query_termContext extends ParserRuleContext {
		public List<TerminalNode> ALL() { return getTokens(SQLParser.ALL); }
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public List<TerminalNode> DISTINCT() { return getTokens(SQLParser.DISTINCT); }
		public TerminalNode ALL(int i) {
			return getToken(SQLParser.ALL, i);
		}
		public List<Query_primaryContext> query_primary() {
			return getRuleContexts(Query_primaryContext.class);
		}
		public List<TerminalNode> INTERSECT() { return getTokens(SQLParser.INTERSECT); }
		public TerminalNode DISTINCT(int i) {
			return getToken(SQLParser.DISTINCT, i);
		}
		public Query_primaryContext query_primary(int i) {
			return getRuleContext(Query_primaryContext.class,i);
		}
		public Non_join_query_primaryContext non_join_query_primary() {
			return getRuleContext(Non_join_query_primaryContext.class,0);
		}
		public TerminalNode INTERSECT(int i) {
			return getToken(SQLParser.INTERSECT, i);
		}
		public Non_join_query_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_join_query_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNon_join_query_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNon_join_query_term(this);
		}
	}

	public final Non_join_query_termContext non_join_query_term() throws RecognitionException {
		Non_join_query_termContext _localctx = new Non_join_query_termContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1610);
			switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
			case 1:
				{
				setState(1602); non_join_query_primary();
				}
				break;

			case 2:
				{
				setState(1603); joined_table();
				setState(1604); match(INTERSECT);
				setState(1606);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1605);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1608); query_primary();
				}
				break;
			}
			setState(1619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(1612); match(INTERSECT);
				setState(1614);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1613);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1616); query_primary();
				}
				}
				setState(1621);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Query_primaryContext extends ParserRuleContext {
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Non_join_query_primaryContext non_join_query_primary() {
			return getRuleContext(Non_join_query_primaryContext.class,0);
		}
		public Query_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuery_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuery_primary(this);
		}
	}

	public final Query_primaryContext query_primary() throws RecognitionException {
		Query_primaryContext _localctx = new Query_primaryContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_query_primary);
		try {
			setState(1624);
			switch ( getInterpreter().adaptivePredict(_input,161,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1622); non_join_query_primary();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1623); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Non_join_query_primaryContext extends ParserRuleContext {
		public Simple_tableContext simple_table() {
			return getRuleContext(Simple_tableContext.class,0);
		}
		public Non_join_query_expressionContext non_join_query_expression() {
			return getRuleContext(Non_join_query_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Non_join_query_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_join_query_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNon_join_query_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNon_join_query_primary(this);
		}
	}

	public final Non_join_query_primaryContext non_join_query_primary() throws RecognitionException {
		Non_join_query_primaryContext _localctx = new Non_join_query_primaryContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_non_join_query_primary);
		try {
			setState(1631);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1626); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1627); match(LEFT_PAREN);
				setState(1628); non_join_query_expression();
				setState(1629); match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_tableContext extends ParserRuleContext {
		public Explicit_tableContext explicit_table() {
			return getRuleContext(Explicit_tableContext.class,0);
		}
		public Query_specificationContext query_specification() {
			return getRuleContext(Query_specificationContext.class,0);
		}
		public Simple_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSimple_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSimple_table(this);
		}
	}

	public final Simple_tableContext simple_table() throws RecognitionException {
		Simple_tableContext _localctx = new Simple_tableContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_simple_table);
		try {
			setState(1635);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1633); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1634); explicit_table();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Explicit_tableContext extends ParserRuleContext {
		public Table_or_query_nameContext table_or_query_name() {
			return getRuleContext(Table_or_query_nameContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public Explicit_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicit_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExplicit_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExplicit_table(this);
		}
	}

	public final Explicit_tableContext explicit_table() throws RecognitionException {
		Explicit_tableContext _localctx = new Explicit_tableContext(_ctx, getState());
		enterRule(_localctx, 340, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1637); match(TABLE);
			setState(1638); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_or_query_nameContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Table_or_query_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_query_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_or_query_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_or_query_name(this);
		}
	}

	public final Table_or_query_nameContext table_or_query_name() throws RecognitionException {
		Table_or_query_nameContext _localctx = new Table_or_query_nameContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_table_or_query_name);
		try {
			setState(1642);
			switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1640); table_name();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1641); identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_nameContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(SQLParser.DOT); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode DOT(int i) {
			return getToken(SQLParser.DOT, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_name(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_table_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1644); identifier();
			setState(1651);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(1645); match(DOT);
				setState(1646); identifier();
				setState(1649);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(1647); match(DOT);
					setState(1648); identifier();
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterColumn_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitColumn_name(this);
		}
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1653); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Query_specificationContext extends ParserRuleContext {
		public Table_expressionContext table_expression() {
			return getRuleContext(Table_expressionContext.class,0);
		}
		public Set_qualifierContext set_qualifier() {
			return getRuleContext(Set_qualifierContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(SQLParser.SELECT, 0); }
		public Select_listContext select_list() {
			return getRuleContext(Select_listContext.class,0);
		}
		public Query_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuery_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuery_specification(this);
		}
	}

	public final Query_specificationContext query_specification() throws RecognitionException {
		Query_specificationContext _localctx = new Query_specificationContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1655); match(SELECT);
			setState(1657);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(1656); set_qualifier();
				}
			}

			setState(1659); select_list();
			setState(1661);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(1660); table_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_listContext extends ParserRuleContext {
		public Select_sublistContext select_sublist(int i) {
			return getRuleContext(Select_sublistContext.class,i);
		}
		public List<Select_sublistContext> select_sublist() {
			return getRuleContexts(Select_sublistContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Select_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSelect_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSelect_list(this);
		}
	}

	public final Select_listContext select_list() throws RecognitionException {
		Select_listContext _localctx = new Select_listContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1663); select_sublist();
			setState(1668);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1664); match(COMMA);
				setState(1665); select_sublist();
				}
				}
				setState(1670);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_sublistContext extends ParserRuleContext {
		public Derived_columnContext derived_column() {
			return getRuleContext(Derived_columnContext.class,0);
		}
		public Qualified_asteriskContext qualified_asterisk() {
			return getRuleContext(Qualified_asteriskContext.class,0);
		}
		public Select_sublistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_sublist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSelect_sublist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSelect_sublist(this);
		}
	}

	public final Select_sublistContext select_sublist() throws RecognitionException {
		Select_sublistContext _localctx = new Select_sublistContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_select_sublist);
		try {
			setState(1673);
			switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1671); derived_column();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1672); qualified_asterisk();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Derived_columnContext extends ParserRuleContext {
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public As_clauseContext as_clause() {
			return getRuleContext(As_clauseContext.class,0);
		}
		public Derived_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derived_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDerived_column(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDerived_column(this);
		}
	}

	public final Derived_columnContext derived_column() throws RecognitionException {
		Derived_columnContext _localctx = new Derived_columnContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_derived_column);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1675); value_expression();
			setState(1677);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << VALUES) | (1L << AVG) | (1L << ADD) | (1L << ALTER) | (1L << BETWEEN) | (1L << BY) | (1L << CENTURY))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CHARACTER - 64)) | (1L << (COLLECT - 64)) | (1L << (COALESCE - 64)) | (1L << (COLUMN - 64)) | (1L << (COUNT - 64)) | (1L << (CUBE - 64)) | (1L << (DAY - 64)) | (1L << (DEC - 64)) | (1L << (DECADE - 64)) | (1L << (DOW - 64)) | (1L << (DOY - 64)) | (1L << (DROP - 64)) | (1L << (EPOCH - 64)) | (1L << (EVERY - 64)) | (1L << (EXISTS - 64)) | (1L << (EXPLAIN - 64)) | (1L << (EXTERNAL - 64)) | (1L << (EXTRACT - 64)) | (1L << (FILTER - 64)) | (1L << (FIRST - 64)) | (1L << (FORMAT - 64)) | (1L << (FUSION - 64)) | (1L << (GROUPING - 64)) | (1L << (HASH - 64)) | (1L << (INDEX - 64)) | (1L << (INSERT - 64)) | (1L << (INTERSECTION - 64)) | (1L << (ISODOW - 64)) | (1L << (ISOYEAR - 64)) | (1L << (LAST - 64)) | (1L << (LESS - 64)) | (1L << (LIST - 64)) | (1L << (LOCATION - 64)) | (1L << (MAX - 64)) | (1L << (MAXVALUE - 64)) | (1L << (MICROSECONDS - 64)) | (1L << (MILLENNIUM - 64)) | (1L << (MILLISECONDS - 64)) | (1L << (MIN - 64)) | (1L << (MINUTE - 64)) | (1L << (MONTH - 64)) | (1L << (NATIONAL - 64)) | (1L << (NULLIF - 64)) | (1L << (OVERWRITE - 64)) | (1L << (PARTITION - 64)) | (1L << (PARTITIONS - 64)) | (1L << (PRECISION - 64)) | (1L << (PURGE - 64)) | (1L << (QUARTER - 64)) | (1L << (RANGE - 64)) | (1L << (REGEXP - 64)) | (1L << (RLIKE - 64)) | (1L << (ROLLUP - 64)) | (1L << (RENAME - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (SECOND - 128)) | (1L << (SET - 128)) | (1L << (SIMILAR - 128)) | (1L << (STDDEV_POP - 128)) | (1L << (STDDEV_SAMP - 128)) | (1L << (SUBPARTITION - 128)) | (1L << (SUM - 128)) | (1L << (TABLESPACE - 128)) | (1L << (THAN - 128)) | (1L << (TIMEZONE - 128)) | (1L << (TIMEZONE_HOUR - 128)) | (1L << (TIMEZONE_MINUTE - 128)) | (1L << (TRIM - 128)) | (1L << (TO - 128)) | (1L << (UNKNOWN - 128)) | (1L << (VAR_SAMP - 128)) | (1L << (VAR_POP - 128)) | (1L << (VARYING - 128)) | (1L << (WEEK - 128)) | (1L << (YEAR - 128)) | (1L << (ZONE - 128)) | (1L << (BOOLEAN - 128)) | (1L << (BOOL - 128)) | (1L << (BIT - 128)) | (1L << (VARBIT - 128)) | (1L << (INT1 - 128)) | (1L << (INT2 - 128)) | (1L << (INT4 - 128)) | (1L << (INT8 - 128)) | (1L << (TINYINT - 128)) | (1L << (SMALLINT - 128)) | (1L << (INT - 128)) | (1L << (INTEGER - 128)) | (1L << (BIGINT - 128)) | (1L << (FLOAT4 - 128)) | (1L << (FLOAT8 - 128)) | (1L << (REAL - 128)) | (1L << (FLOAT - 128)) | (1L << (DOUBLE - 128)) | (1L << (NUMERIC - 128)) | (1L << (DECIMAL - 128)) | (1L << (CHAR - 128)) | (1L << (VARCHAR - 128)) | (1L << (NCHAR - 128)) | (1L << (NVARCHAR - 128)) | (1L << (DATE - 128)) | (1L << (INTERVAL - 128)) | (1L << (TIME - 128)) | (1L << (TIMETZ - 128)) | (1L << (TIMESTAMP - 128)) | (1L << (TIMESTAMPTZ - 128)) | (1L << (TEXT - 128)) | (1L << (VARBINARY - 128)) | (1L << (BLOB - 128)) | (1L << (BYTEA - 128)) | (1L << (INET4 - 128)))) != 0) || _la==Regular_Identifier || _la==Quoted_Identifier) {
				{
				setState(1676); as_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Qualified_asteriskContext extends ParserRuleContext {
		public IdentifierContext tb_name;
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public TerminalNode MULTIPLY() { return getToken(SQLParser.MULTIPLY, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Qualified_asteriskContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualified_asterisk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQualified_asterisk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQualified_asterisk(this);
		}
	}

	public final Qualified_asteriskContext qualified_asterisk() throws RecognitionException {
		Qualified_asteriskContext _localctx = new Qualified_asteriskContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1682);
			_la = _input.LA(1);
			if (((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & ((1L << (VALUES - 53)) | (1L << (AVG - 53)) | (1L << (ADD - 53)) | (1L << (ALTER - 53)) | (1L << (BETWEEN - 53)) | (1L << (BY - 53)) | (1L << (CENTURY - 53)) | (1L << (CHARACTER - 53)) | (1L << (COLLECT - 53)) | (1L << (COALESCE - 53)) | (1L << (COLUMN - 53)) | (1L << (COUNT - 53)) | (1L << (CUBE - 53)) | (1L << (DAY - 53)) | (1L << (DEC - 53)) | (1L << (DECADE - 53)) | (1L << (DOW - 53)) | (1L << (DOY - 53)) | (1L << (DROP - 53)) | (1L << (EPOCH - 53)) | (1L << (EVERY - 53)) | (1L << (EXISTS - 53)) | (1L << (EXPLAIN - 53)) | (1L << (EXTERNAL - 53)) | (1L << (EXTRACT - 53)) | (1L << (FILTER - 53)) | (1L << (FIRST - 53)) | (1L << (FORMAT - 53)) | (1L << (FUSION - 53)) | (1L << (GROUPING - 53)) | (1L << (HASH - 53)) | (1L << (INDEX - 53)) | (1L << (INSERT - 53)) | (1L << (INTERSECTION - 53)) | (1L << (ISODOW - 53)) | (1L << (ISOYEAR - 53)) | (1L << (LAST - 53)) | (1L << (LESS - 53)) | (1L << (LIST - 53)) | (1L << (LOCATION - 53)) | (1L << (MAX - 53)) | (1L << (MAXVALUE - 53)) | (1L << (MICROSECONDS - 53)) | (1L << (MILLENNIUM - 53)) | (1L << (MILLISECONDS - 53)) | (1L << (MIN - 53)) | (1L << (MINUTE - 53)) | (1L << (MONTH - 53)) | (1L << (NATIONAL - 53)) | (1L << (NULLIF - 53)) | (1L << (OVERWRITE - 53)) | (1L << (PARTITION - 53)))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (PARTITIONS - 117)) | (1L << (PRECISION - 117)) | (1L << (PURGE - 117)) | (1L << (QUARTER - 117)) | (1L << (RANGE - 117)) | (1L << (REGEXP - 117)) | (1L << (RLIKE - 117)) | (1L << (ROLLUP - 117)) | (1L << (RENAME - 117)) | (1L << (SECOND - 117)) | (1L << (SET - 117)) | (1L << (SIMILAR - 117)) | (1L << (STDDEV_POP - 117)) | (1L << (STDDEV_SAMP - 117)) | (1L << (SUBPARTITION - 117)) | (1L << (SUM - 117)) | (1L << (TABLESPACE - 117)) | (1L << (THAN - 117)) | (1L << (TIMEZONE - 117)) | (1L << (TIMEZONE_HOUR - 117)) | (1L << (TIMEZONE_MINUTE - 117)) | (1L << (TRIM - 117)) | (1L << (TO - 117)) | (1L << (UNKNOWN - 117)) | (1L << (VAR_SAMP - 117)) | (1L << (VAR_POP - 117)) | (1L << (VARYING - 117)) | (1L << (WEEK - 117)) | (1L << (YEAR - 117)) | (1L << (ZONE - 117)) | (1L << (BOOLEAN - 117)) | (1L << (BOOL - 117)) | (1L << (BIT - 117)) | (1L << (VARBIT - 117)) | (1L << (INT1 - 117)) | (1L << (INT2 - 117)) | (1L << (INT4 - 117)) | (1L << (INT8 - 117)) | (1L << (TINYINT - 117)) | (1L << (SMALLINT - 117)) | (1L << (INT - 117)) | (1L << (INTEGER - 117)) | (1L << (BIGINT - 117)) | (1L << (FLOAT4 - 117)) | (1L << (FLOAT8 - 117)) | (1L << (REAL - 117)) | (1L << (FLOAT - 117)) | (1L << (DOUBLE - 117)) | (1L << (NUMERIC - 117)) | (1L << (DECIMAL - 117)) | (1L << (CHAR - 117)) | (1L << (VARCHAR - 117)) | (1L << (NCHAR - 117)) | (1L << (NVARCHAR - 117)) | (1L << (DATE - 117)) | (1L << (INTERVAL - 117)) | (1L << (TIME - 117)) | (1L << (TIMETZ - 117)) | (1L << (TIMESTAMP - 117)) | (1L << (TIMESTAMPTZ - 117)))) != 0) || ((((_la - 181)) & ~0x3f) == 0 && ((1L << (_la - 181)) & ((1L << (TEXT - 181)) | (1L << (VARBINARY - 181)) | (1L << (BLOB - 181)) | (1L << (BYTEA - 181)) | (1L << (INET4 - 181)) | (1L << (Regular_Identifier - 181)) | (1L << (Quoted_Identifier - 181)))) != 0)) {
				{
				setState(1679); ((Qualified_asteriskContext)_localctx).tb_name = identifier();
				setState(1680); match(DOT);
				}
			}

			setState(1684); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_qualifierContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public TerminalNode DISTINCT() { return getToken(SQLParser.DISTINCT, 0); }
		public Set_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_qualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSet_qualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSet_qualifier(this);
		}
	}

	public final Set_qualifierContext set_qualifier() throws RecognitionException {
		Set_qualifierContext _localctx = new Set_qualifierContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1686);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==DISTINCT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_referenceContext extends ParserRuleContext {
		public IdentifierContext db_name;
		public IdentifierContext tb_name;
		public IdentifierContext name;
		public List<TerminalNode> DOT() { return getTokens(SQLParser.DOT); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode DOT(int i) {
			return getToken(SQLParser.DOT, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Column_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterColumn_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitColumn_reference(this);
		}
	}

	public final Column_referenceContext column_reference() throws RecognitionException {
		Column_referenceContext _localctx = new Column_referenceContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1696);
			switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
			case 1:
				{
				setState(1691);
				switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
				case 1:
					{
					setState(1688); ((Column_referenceContext)_localctx).db_name = identifier();
					setState(1689); match(DOT);
					}
					break;
				}
				{
				setState(1693); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(1694); match(DOT);
				}
				}
				break;
			}
			setState(1698); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class As_clauseContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public As_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAs_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAs_clause(this);
		}
	}

	public final As_clauseContext as_clause() throws RecognitionException {
		As_clauseContext _localctx = new As_clauseContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1701);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(1700); match(AS);
				}
			}

			setState(1703); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_reference_listContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Column_referenceContext column_reference(int i) {
			return getRuleContext(Column_referenceContext.class,i);
		}
		public List<Column_referenceContext> column_reference() {
			return getRuleContexts(Column_referenceContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Column_reference_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_reference_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterColumn_reference_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitColumn_reference_list(this);
		}
	}

	public final Column_reference_listContext column_reference_list() throws RecognitionException {
		Column_reference_listContext _localctx = new Column_reference_listContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1705); column_reference();
			setState(1710);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1706); match(COMMA);
				setState(1707); column_reference();
				}
				}
				setState(1712);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Scalar_subqueryContext extends ParserRuleContext {
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public Scalar_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalar_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterScalar_subquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitScalar_subquery(this);
		}
	}

	public final Scalar_subqueryContext scalar_subquery() throws RecognitionException {
		Scalar_subqueryContext _localctx = new Scalar_subqueryContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1713); subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Row_subqueryContext extends ParserRuleContext {
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public Row_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRow_subquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRow_subquery(this);
		}
	}

	public final Row_subqueryContext row_subquery() throws RecognitionException {
		Row_subqueryContext _localctx = new Row_subqueryContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1715); subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_subqueryContext extends ParserRuleContext {
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public Table_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_subquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_subquery(this);
		}
	}

	public final Table_subqueryContext table_subquery() throws RecognitionException {
		Table_subqueryContext _localctx = new Table_subqueryContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1717); subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubqueryContext extends ParserRuleContext {
		public Query_expressionContext query_expression() {
			return getRuleContext(Query_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public SubqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSubquery(this);
		}
	}

	public final SubqueryContext subquery() throws RecognitionException {
		SubqueryContext _localctx = new SubqueryContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1719); match(LEFT_PAREN);
			setState(1720); query_expression();
			setState(1721); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public Pattern_matching_predicateContext pattern_matching_predicate() {
			return getRuleContext(Pattern_matching_predicateContext.class,0);
		}
		public Exists_predicateContext exists_predicate() {
			return getRuleContext(Exists_predicateContext.class,0);
		}
		public In_predicateContext in_predicate() {
			return getRuleContext(In_predicateContext.class,0);
		}
		public Null_predicateContext null_predicate() {
			return getRuleContext(Null_predicateContext.class,0);
		}
		public Between_predicateContext between_predicate() {
			return getRuleContext(Between_predicateContext.class,0);
		}
		public Comparison_predicateContext comparison_predicate() {
			return getRuleContext(Comparison_predicateContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_predicate);
		try {
			setState(1729);
			switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1723); comparison_predicate();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1724); between_predicate();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1725); in_predicate();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1726); pattern_matching_predicate();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1727); null_predicate();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1728); exists_predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comparison_predicateContext extends ParserRuleContext {
		public Row_value_predicandContext left;
		public Comp_opContext c;
		public Row_value_predicandContext right;
		public Row_value_predicandContext row_value_predicand(int i) {
			return getRuleContext(Row_value_predicandContext.class,i);
		}
		public Comp_opContext comp_op() {
			return getRuleContext(Comp_opContext.class,0);
		}
		public List<Row_value_predicandContext> row_value_predicand() {
			return getRuleContexts(Row_value_predicandContext.class);
		}
		public Comparison_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterComparison_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitComparison_predicate(this);
		}
	}

	public final Comparison_predicateContext comparison_predicate() throws RecognitionException {
		Comparison_predicateContext _localctx = new Comparison_predicateContext(_ctx, getState());
		enterRule(_localctx, 376, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1731); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(1732); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(1733); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Equal_predicateContext extends ParserRuleContext {
		public Row_value_predicandContext left;
		public Equal_comp_opContext c;
		public Row_value_predicandContext right;
		public Equal_comp_opContext equal_comp_op() {
			return getRuleContext(Equal_comp_opContext.class,0);
		}
		public Row_value_predicandContext row_value_predicand(int i) {
			return getRuleContext(Row_value_predicandContext.class,i);
		}
		public List<Row_value_predicandContext> row_value_predicand() {
			return getRuleContexts(Row_value_predicandContext.class);
		}
		public Equal_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equal_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterEqual_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitEqual_predicate(this);
		}
	}

	public final Equal_predicateContext equal_predicate() throws RecognitionException {
		Equal_predicateContext _localctx = new Equal_predicateContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_equal_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1735); ((Equal_predicateContext)_localctx).left = row_value_predicand();
			setState(1736); ((Equal_predicateContext)_localctx).c = equal_comp_op();
			setState(1737); ((Equal_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comp_opContext extends ParserRuleContext {
		public TerminalNode GEQ() { return getToken(SQLParser.GEQ, 0); }
		public TerminalNode GTH() { return getToken(SQLParser.GTH, 0); }
		public TerminalNode LEQ() { return getToken(SQLParser.LEQ, 0); }
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(SQLParser.NOT_EQUAL, 0); }
		public TerminalNode LTH() { return getToken(SQLParser.LTH, 0); }
		public Comp_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterComp_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitComp_op(this);
		}
	}

	public final Comp_opContext comp_op() throws RecognitionException {
		Comp_opContext _localctx = new Comp_opContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1739);
			_la = _input.LA(1);
			if ( !(((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (EQUAL - 193)) | (1L << (NOT_EQUAL - 193)) | (1L << (LTH - 193)) | (1L << (LEQ - 193)) | (1L << (GTH - 193)) | (1L << (GEQ - 193)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Equal_comp_opContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public Equal_comp_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equal_comp_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterEqual_comp_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitEqual_comp_op(this);
		}
	}

	public final Equal_comp_opContext equal_comp_op() throws RecognitionException {
		Equal_comp_opContext _localctx = new Equal_comp_opContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_equal_comp_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1741); match(EQUAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Between_predicateContext extends ParserRuleContext {
		public Row_value_predicandContext predicand;
		public Between_predicate_part_2Context between_predicate_part_2() {
			return getRuleContext(Between_predicate_part_2Context.class,0);
		}
		public Row_value_predicandContext row_value_predicand() {
			return getRuleContext(Row_value_predicandContext.class,0);
		}
		public Between_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_between_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBetween_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBetween_predicate(this);
		}
	}

	public final Between_predicateContext between_predicate() throws RecognitionException {
		Between_predicateContext _localctx = new Between_predicateContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1743); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(1744); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Between_predicate_part_2Context extends ParserRuleContext {
		public Row_value_predicandContext begin;
		public Row_value_predicandContext end;
		public TerminalNode ASYMMETRIC() { return getToken(SQLParser.ASYMMETRIC, 0); }
		public TerminalNode BETWEEN() { return getToken(SQLParser.BETWEEN, 0); }
		public TerminalNode SYMMETRIC() { return getToken(SQLParser.SYMMETRIC, 0); }
		public Row_value_predicandContext row_value_predicand(int i) {
			return getRuleContext(Row_value_predicandContext.class,i);
		}
		public List<Row_value_predicandContext> row_value_predicand() {
			return getRuleContexts(Row_value_predicandContext.class);
		}
		public TerminalNode AND() { return getToken(SQLParser.AND, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Between_predicate_part_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_between_predicate_part_2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBetween_predicate_part_2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBetween_predicate_part_2(this);
		}
	}

	public final Between_predicate_part_2Context between_predicate_part_2() throws RecognitionException {
		Between_predicate_part_2Context _localctx = new Between_predicate_part_2Context(_ctx, getState());
		enterRule(_localctx, 386, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1747);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1746); match(NOT);
				}
			}

			setState(1749); match(BETWEEN);
			setState(1751);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(1750);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1753); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(1754); match(AND);
			setState(1755); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class In_predicateContext extends ParserRuleContext {
		public Numeric_value_expressionContext predicand;
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public In_predicate_valueContext in_predicate_value() {
			return getRuleContext(In_predicate_valueContext.class,0);
		}
		public In_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIn_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIn_predicate(this);
		}
	}

	public final In_predicateContext in_predicate() throws RecognitionException {
		In_predicateContext _localctx = new In_predicateContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1757); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(1759);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1758); match(NOT);
				}
			}

			setState(1761); match(IN);
			setState(1762); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class In_predicate_valueContext extends ParserRuleContext {
		public In_value_listContext in_value_list() {
			return getRuleContext(In_value_listContext.class,0);
		}
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public In_predicate_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_predicate_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIn_predicate_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIn_predicate_value(this);
		}
	}

	public final In_predicate_valueContext in_predicate_value() throws RecognitionException {
		In_predicate_valueContext _localctx = new In_predicate_valueContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_in_predicate_value);
		try {
			setState(1769);
			switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1764); table_subquery();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1765); match(LEFT_PAREN);
				setState(1766); in_value_list();
				setState(1767); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class In_value_listContext extends ParserRuleContext {
		public Row_value_predicandContext row_value_predicand(int i) {
			return getRuleContext(Row_value_predicandContext.class,i);
		}
		public List<Row_value_predicandContext> row_value_predicand() {
			return getRuleContexts(Row_value_predicandContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public In_value_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_value_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIn_value_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIn_value_list(this);
		}
	}

	public final In_value_listContext in_value_list() throws RecognitionException {
		In_value_listContext _localctx = new In_value_listContext(_ctx, getState());
		enterRule(_localctx, 392, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1771); row_value_predicand();
			setState(1776);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1772); match(COMMA);
				setState(1773); row_value_predicand();
				}
				}
				setState(1778);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pattern_matching_predicateContext extends ParserRuleContext {
		public Row_value_predicandContext f;
		public Token s;
		public Row_value_predicandContext row_value_predicand(int i) {
			return getRuleContext(Row_value_predicandContext.class,i);
		}
		public List<Row_value_predicandContext> row_value_predicand() {
			return getRuleContexts(Row_value_predicandContext.class);
		}
		public Pattern_matcherContext pattern_matcher() {
			return getRuleContext(Pattern_matcherContext.class,0);
		}
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Pattern_matching_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_matching_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPattern_matching_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPattern_matching_predicate(this);
		}
	}

	public final Pattern_matching_predicateContext pattern_matching_predicate() throws RecognitionException {
		Pattern_matching_predicateContext _localctx = new Pattern_matching_predicateContext(_ctx, getState());
		enterRule(_localctx, 394, RULE_pattern_matching_predicate);
		try {
			setState(1787);
			switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1779); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
				setState(1780); pattern_matcher();
				setState(1781); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1783); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
				setState(1784); pattern_matcher();
				setState(1785); row_value_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pattern_matcherContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Negativable_matcherContext negativable_matcher() {
			return getRuleContext(Negativable_matcherContext.class,0);
		}
		public Regex_matcherContext regex_matcher() {
			return getRuleContext(Regex_matcherContext.class,0);
		}
		public Pattern_matcherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_matcher; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPattern_matcher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPattern_matcher(this);
		}
	}

	public final Pattern_matcherContext pattern_matcher() throws RecognitionException {
		Pattern_matcherContext _localctx = new Pattern_matcherContext(_ctx, getState());
		enterRule(_localctx, 396, RULE_pattern_matcher);
		int _la;
		try {
			setState(1794);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1790);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1789); match(NOT);
					}
				}

				setState(1792); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(1793); regex_matcher();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Negativable_matcherContext extends ParserRuleContext {
		public TerminalNode SIMILAR() { return getToken(SQLParser.SIMILAR, 0); }
		public TerminalNode REGEXP() { return getToken(SQLParser.REGEXP, 0); }
		public TerminalNode ILIKE() { return getToken(SQLParser.ILIKE, 0); }
		public TerminalNode RLIKE() { return getToken(SQLParser.RLIKE, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode LIKE() { return getToken(SQLParser.LIKE, 0); }
		public Negativable_matcherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negativable_matcher; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNegativable_matcher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNegativable_matcher(this);
		}
	}

	public final Negativable_matcherContext negativable_matcher() throws RecognitionException {
		Negativable_matcherContext _localctx = new Negativable_matcherContext(_ctx, getState());
		enterRule(_localctx, 398, RULE_negativable_matcher);
		try {
			setState(1802);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1796); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1797); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(1798); match(SIMILAR);
				setState(1799); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(1800); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(1801); match(RLIKE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Regex_matcherContext extends ParserRuleContext {
		public TerminalNode Not_Similar_To() { return getToken(SQLParser.Not_Similar_To, 0); }
		public TerminalNode Similar_To() { return getToken(SQLParser.Similar_To, 0); }
		public TerminalNode Not_Similar_To_Case_Insensitive() { return getToken(SQLParser.Not_Similar_To_Case_Insensitive, 0); }
		public TerminalNode Similar_To_Case_Insensitive() { return getToken(SQLParser.Similar_To_Case_Insensitive, 0); }
		public Regex_matcherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regex_matcher; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRegex_matcher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRegex_matcher(this);
		}
	}

	public final Regex_matcherContext regex_matcher() throws RecognitionException {
		Regex_matcherContext _localctx = new Regex_matcherContext(_ctx, getState());
		enterRule(_localctx, 400, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1804);
			_la = _input.LA(1);
			if ( !(((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (Similar_To - 187)) | (1L << (Not_Similar_To - 187)) | (1L << (Similar_To_Case_Insensitive - 187)) | (1L << (Not_Similar_To_Case_Insensitive - 187)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Null_predicateContext extends ParserRuleContext {
		public Row_value_predicandContext predicand;
		public Token n;
		public Row_value_predicandContext row_value_predicand() {
			return getRuleContext(Row_value_predicandContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode IS() { return getToken(SQLParser.IS, 0); }
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public Null_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNull_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNull_predicate(this);
		}
	}

	public final Null_predicateContext null_predicate() throws RecognitionException {
		Null_predicateContext _localctx = new Null_predicateContext(_ctx, getState());
		enterRule(_localctx, 402, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1806); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(1807); match(IS);
			setState(1809);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1808); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(1811); match(NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Quantified_comparison_predicateContext extends ParserRuleContext {
		public Numeric_value_expressionContext l;
		public Comp_opContext c;
		public QuantifierContext q;
		public Table_subqueryContext s;
		public Comp_opContext comp_op() {
			return getRuleContext(Comp_opContext.class,0);
		}
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public Quantified_comparison_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantified_comparison_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuantified_comparison_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuantified_comparison_predicate(this);
		}
	}

	public final Quantified_comparison_predicateContext quantified_comparison_predicate() throws RecognitionException {
		Quantified_comparison_predicateContext _localctx = new Quantified_comparison_predicateContext(_ctx, getState());
		enterRule(_localctx, 404, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1813); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(1814); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(1815); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(1816); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifierContext extends ParserRuleContext {
		public AllContext all() {
			return getRuleContext(AllContext.class,0);
		}
		public SomeContext some() {
			return getRuleContext(SomeContext.class,0);
		}
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuantifier(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 406, RULE_quantifier);
		try {
			setState(1820);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1818); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(1819); some();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AllContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public AllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_all; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAll(this);
		}
	}

	public final AllContext all() throws RecognitionException {
		AllContext _localctx = new AllContext(_ctx, getState());
		enterRule(_localctx, 408, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1822); match(ALL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SomeContext extends ParserRuleContext {
		public TerminalNode SOME() { return getToken(SQLParser.SOME, 0); }
		public TerminalNode ANY() { return getToken(SQLParser.ANY, 0); }
		public SomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_some; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSome(this);
		}
	}

	public final SomeContext some() throws RecognitionException {
		SomeContext _localctx = new SomeContext(_ctx, getState());
		enterRule(_localctx, 410, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1824);
			_la = _input.LA(1);
			if ( !(_la==ANY || _la==SOME) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exists_predicateContext extends ParserRuleContext {
		public Table_subqueryContext s;
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public Exists_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exists_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExists_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExists_predicate(this);
		}
	}

	public final Exists_predicateContext exists_predicate() throws RecognitionException {
		Exists_predicateContext _localctx = new Exists_predicateContext(_ctx, getState());
		enterRule(_localctx, 412, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1827);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1826); match(NOT);
				}
			}

			setState(1829); match(EXISTS);
			setState(1830); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unique_predicateContext extends ParserRuleContext {
		public Table_subqueryContext s;
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public Unique_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unique_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUnique_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUnique_predicate(this);
		}
	}

	public final Unique_predicateContext unique_predicate() throws RecognitionException {
		Unique_predicateContext _localctx = new Unique_predicateContext(_ctx, getState());
		enterRule(_localctx, 414, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1832); match(UNIQUE);
			setState(1833); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primary_datetime_fieldContext extends ParserRuleContext {
		public TerminalNode SECOND() { return getToken(SQLParser.SECOND, 0); }
		public Non_second_primary_datetime_fieldContext non_second_primary_datetime_field() {
			return getRuleContext(Non_second_primary_datetime_fieldContext.class,0);
		}
		public Primary_datetime_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_datetime_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPrimary_datetime_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPrimary_datetime_field(this);
		}
	}

	public final Primary_datetime_fieldContext primary_datetime_field() throws RecognitionException {
		Primary_datetime_fieldContext _localctx = new Primary_datetime_fieldContext(_ctx, getState());
		enterRule(_localctx, 416, RULE_primary_datetime_field);
		try {
			setState(1837);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1835); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(1836); match(SECOND);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Non_second_primary_datetime_fieldContext extends ParserRuleContext {
		public TerminalNode YEAR() { return getToken(SQLParser.YEAR, 0); }
		public TerminalNode MONTH() { return getToken(SQLParser.MONTH, 0); }
		public TerminalNode HOUR() { return getToken(SQLParser.HOUR, 0); }
		public TerminalNode DAY() { return getToken(SQLParser.DAY, 0); }
		public TerminalNode MINUTE() { return getToken(SQLParser.MINUTE, 0); }
		public Non_second_primary_datetime_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_second_primary_datetime_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNon_second_primary_datetime_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNon_second_primary_datetime_field(this);
		}
	}

	public final Non_second_primary_datetime_fieldContext non_second_primary_datetime_field() throws RecognitionException {
		Non_second_primary_datetime_fieldContext _localctx = new Non_second_primary_datetime_fieldContext(_ctx, getState());
		enterRule(_localctx, 418, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1839);
			_la = _input.LA(1);
			if ( !(((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (DAY - 72)) | (1L << (HOUR - 72)) | (1L << (MINUTE - 72)) | (1L << (MONTH - 72)))) != 0) || _la==YEAR) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Extended_datetime_fieldContext extends ParserRuleContext {
		public TerminalNode ISODOW() { return getToken(SQLParser.ISODOW, 0); }
		public TerminalNode EPOCH() { return getToken(SQLParser.EPOCH, 0); }
		public TerminalNode QUARTER() { return getToken(SQLParser.QUARTER, 0); }
		public TerminalNode DOY() { return getToken(SQLParser.DOY, 0); }
		public TerminalNode MILLENNIUM() { return getToken(SQLParser.MILLENNIUM, 0); }
		public TerminalNode DECADE() { return getToken(SQLParser.DECADE, 0); }
		public TerminalNode MICROSECONDS() { return getToken(SQLParser.MICROSECONDS, 0); }
		public TerminalNode WEEK() { return getToken(SQLParser.WEEK, 0); }
		public TerminalNode CENTURY() { return getToken(SQLParser.CENTURY, 0); }
		public TerminalNode MILLISECONDS() { return getToken(SQLParser.MILLISECONDS, 0); }
		public TerminalNode ISOYEAR() { return getToken(SQLParser.ISOYEAR, 0); }
		public TerminalNode DOW() { return getToken(SQLParser.DOW, 0); }
		public Extended_datetime_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extended_datetime_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExtended_datetime_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExtended_datetime_field(this);
		}
	}

	public final Extended_datetime_fieldContext extended_datetime_field() throws RecognitionException {
		Extended_datetime_fieldContext _localctx = new Extended_datetime_fieldContext(_ctx, getState());
		enterRule(_localctx, 420, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1841);
			_la = _input.LA(1);
			if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (CENTURY - 63)) | (1L << (DECADE - 63)) | (1L << (DOW - 63)) | (1L << (DOY - 63)) | (1L << (EPOCH - 63)) | (1L << (ISODOW - 63)) | (1L << (ISOYEAR - 63)) | (1L << (MICROSECONDS - 63)) | (1L << (MILLENNIUM - 63)) | (1L << (MILLISECONDS - 63)) | (1L << (QUARTER - 63)))) != 0) || _la==WEEK) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Routine_invocationContext extends ParserRuleContext {
		public Sql_argument_listContext sql_argument_list() {
			return getRuleContext(Sql_argument_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public Routine_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routine_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRoutine_invocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRoutine_invocation(this);
		}
	}

	public final Routine_invocationContext routine_invocation() throws RecognitionException {
		Routine_invocationContext _localctx = new Routine_invocationContext(_ctx, getState());
		enterRule(_localctx, 422, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1843); function_name();
			setState(1844); match(LEFT_PAREN);
			setState(1846);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << LEFT) | (1L << NOT) | (1L << NULL) | (1L << RIGHT) | (1L << SOME) | (1L << TRUE) | (1L << VALUES) | (1L << AVG) | (1L << ADD) | (1L << ALTER) | (1L << BETWEEN) | (1L << BY) | (1L << CENTURY))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CHARACTER - 64)) | (1L << (COLLECT - 64)) | (1L << (COALESCE - 64)) | (1L << (COLUMN - 64)) | (1L << (COUNT - 64)) | (1L << (CUBE - 64)) | (1L << (DAY - 64)) | (1L << (DEC - 64)) | (1L << (DECADE - 64)) | (1L << (DOW - 64)) | (1L << (DOY - 64)) | (1L << (DROP - 64)) | (1L << (EPOCH - 64)) | (1L << (EVERY - 64)) | (1L << (EXISTS - 64)) | (1L << (EXPLAIN - 64)) | (1L << (EXTERNAL - 64)) | (1L << (EXTRACT - 64)) | (1L << (FILTER - 64)) | (1L << (FIRST - 64)) | (1L << (FORMAT - 64)) | (1L << (FUSION - 64)) | (1L << (GROUPING - 64)) | (1L << (HASH - 64)) | (1L << (INDEX - 64)) | (1L << (INSERT - 64)) | (1L << (INTERSECTION - 64)) | (1L << (ISODOW - 64)) | (1L << (ISOYEAR - 64)) | (1L << (LAST - 64)) | (1L << (LESS - 64)) | (1L << (LIST - 64)) | (1L << (LOCATION - 64)) | (1L << (MAX - 64)) | (1L << (MAXVALUE - 64)) | (1L << (MICROSECONDS - 64)) | (1L << (MILLENNIUM - 64)) | (1L << (MILLISECONDS - 64)) | (1L << (MIN - 64)) | (1L << (MINUTE - 64)) | (1L << (MONTH - 64)) | (1L << (NATIONAL - 64)) | (1L << (NULLIF - 64)) | (1L << (OVERWRITE - 64)) | (1L << (PARTITION - 64)) | (1L << (PARTITIONS - 64)) | (1L << (PRECISION - 64)) | (1L << (PURGE - 64)) | (1L << (QUARTER - 64)) | (1L << (RANGE - 64)) | (1L << (REGEXP - 64)) | (1L << (RLIKE - 64)) | (1L << (ROLLUP - 64)) | (1L << (RENAME - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (SECOND - 128)) | (1L << (SET - 128)) | (1L << (SIMILAR - 128)) | (1L << (STDDEV_POP - 128)) | (1L << (STDDEV_SAMP - 128)) | (1L << (SUBPARTITION - 128)) | (1L << (SUM - 128)) | (1L << (TABLESPACE - 128)) | (1L << (THAN - 128)) | (1L << (TIMEZONE - 128)) | (1L << (TIMEZONE_HOUR - 128)) | (1L << (TIMEZONE_MINUTE - 128)) | (1L << (TRIM - 128)) | (1L << (TO - 128)) | (1L << (UNKNOWN - 128)) | (1L << (VAR_SAMP - 128)) | (1L << (VAR_POP - 128)) | (1L << (VARYING - 128)) | (1L << (WEEK - 128)) | (1L << (YEAR - 128)) | (1L << (ZONE - 128)) | (1L << (BOOLEAN - 128)) | (1L << (BOOL - 128)) | (1L << (BIT - 128)) | (1L << (VARBIT - 128)) | (1L << (INT1 - 128)) | (1L << (INT2 - 128)) | (1L << (INT4 - 128)) | (1L << (INT8 - 128)) | (1L << (TINYINT - 128)) | (1L << (SMALLINT - 128)) | (1L << (INT - 128)) | (1L << (INTEGER - 128)) | (1L << (BIGINT - 128)) | (1L << (FLOAT4 - 128)) | (1L << (FLOAT8 - 128)) | (1L << (REAL - 128)) | (1L << (FLOAT - 128)) | (1L << (DOUBLE - 128)) | (1L << (NUMERIC - 128)) | (1L << (DECIMAL - 128)) | (1L << (CHAR - 128)) | (1L << (VARCHAR - 128)) | (1L << (NCHAR - 128)) | (1L << (NVARCHAR - 128)) | (1L << (DATE - 128)) | (1L << (INTERVAL - 128)) | (1L << (TIME - 128)) | (1L << (TIMETZ - 128)) | (1L << (TIMESTAMP - 128)) | (1L << (TIMESTAMPTZ - 128)) | (1L << (TEXT - 128)) | (1L << (VARBINARY - 128)) | (1L << (BLOB - 128)) | (1L << (BYTEA - 128)) | (1L << (INET4 - 128)))) != 0) || ((((_la - 203)) & ~0x3f) == 0 && ((1L << (_la - 203)) & ((1L << (LEFT_PAREN - 203)) | (1L << (PLUS - 203)) | (1L << (MINUS - 203)) | (1L << (NUMBER - 203)) | (1L << (REAL_NUMBER - 203)) | (1L << (Regular_Identifier - 203)) | (1L << (Quoted_Identifier - 203)) | (1L << (Character_String_Literal - 203)))) != 0)) {
				{
				setState(1845); sql_argument_list();
				}
			}

			setState(1848); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_names_for_reserved_wordsContext extends ParserRuleContext {
		public TerminalNode LEFT() { return getToken(SQLParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(SQLParser.RIGHT, 0); }
		public Function_names_for_reserved_wordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_names_for_reserved_words; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_names_for_reserved_words(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_names_for_reserved_words(this);
		}
	}

	public final Function_names_for_reserved_wordsContext function_names_for_reserved_words() throws RecognitionException {
		Function_names_for_reserved_wordsContext _localctx = new Function_names_for_reserved_wordsContext(_ctx, getState());
		enterRule(_localctx, 424, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1850);
			_la = _input.LA(1);
			if ( !(_la==LEFT || _la==RIGHT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_nameContext extends ParserRuleContext {
		public Function_names_for_reserved_wordsContext function_names_for_reserved_words() {
			return getRuleContext(Function_names_for_reserved_wordsContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_name(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 426, RULE_function_name);
		try {
			setState(1854);
			switch (_input.LA(1)) {
			case VALUES:
			case AVG:
			case ADD:
			case ALTER:
			case BETWEEN:
			case BY:
			case CENTURY:
			case CHARACTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COUNT:
			case CUBE:
			case DAY:
			case DEC:
			case DECADE:
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXPLAIN:
			case EXTERNAL:
			case EXTRACT:
			case FILTER:
			case FIRST:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
			case INDEX:
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
			case LAST:
			case LESS:
			case LIST:
			case LOCATION:
			case MAX:
			case MAXVALUE:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case MIN:
			case MINUTE:
			case MONTH:
			case NATIONAL:
			case NULLIF:
			case OVERWRITE:
			case PARTITION:
			case PARTITIONS:
			case PRECISION:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RLIKE:
			case ROLLUP:
			case RENAME:
			case SECOND:
			case SET:
			case SIMILAR:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case THAN:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case UNKNOWN:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
			case WEEK:
			case YEAR:
			case ZONE:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case DECIMAL:
			case CHAR:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case Regular_Identifier:
			case Quoted_Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1852); identifier();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1853); function_names_for_reserved_words();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_argument_listContext extends ParserRuleContext {
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Sql_argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_argument_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSql_argument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSql_argument_list(this);
		}
	}

	public final Sql_argument_listContext sql_argument_list() throws RecognitionException {
		Sql_argument_listContext _localctx = new Sql_argument_listContext(_ctx, getState());
		enterRule(_localctx, 428, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1856); value_expression();
			setState(1861);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1857); match(COMMA);
				setState(1858); value_expression();
				}
				}
				setState(1863);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Orderby_clauseContext extends ParserRuleContext {
		public Sort_specifier_listContext sort_specifier_list() {
			return getRuleContext(Sort_specifier_listContext.class,0);
		}
		public TerminalNode ORDER() { return getToken(SQLParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public Orderby_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderby_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOrderby_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOrderby_clause(this);
		}
	}

	public final Orderby_clauseContext orderby_clause() throws RecognitionException {
		Orderby_clauseContext _localctx = new Orderby_clauseContext(_ctx, getState());
		enterRule(_localctx, 430, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1864); match(ORDER);
			setState(1865); match(BY);
			setState(1866); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sort_specifier_listContext extends ParserRuleContext {
		public List<Sort_specifierContext> sort_specifier() {
			return getRuleContexts(Sort_specifierContext.class);
		}
		public Sort_specifierContext sort_specifier(int i) {
			return getRuleContext(Sort_specifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Sort_specifier_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort_specifier_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSort_specifier_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSort_specifier_list(this);
		}
	}

	public final Sort_specifier_listContext sort_specifier_list() throws RecognitionException {
		Sort_specifier_listContext _localctx = new Sort_specifier_listContext(_ctx, getState());
		enterRule(_localctx, 432, RULE_sort_specifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1868); sort_specifier();
			setState(1873);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1869); match(COMMA);
				setState(1870); sort_specifier();
				}
				}
				setState(1875);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sort_specifierContext extends ParserRuleContext {
		public Row_value_predicandContext key;
		public Order_specificationContext order;
		public Null_orderingContext null_order;
		public Order_specificationContext order_specification() {
			return getRuleContext(Order_specificationContext.class,0);
		}
		public Row_value_predicandContext row_value_predicand() {
			return getRuleContext(Row_value_predicandContext.class,0);
		}
		public Null_orderingContext null_ordering() {
			return getRuleContext(Null_orderingContext.class,0);
		}
		public Sort_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSort_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSort_specifier(this);
		}
	}

	public final Sort_specifierContext sort_specifier() throws RecognitionException {
		Sort_specifierContext _localctx = new Sort_specifierContext(_ctx, getState());
		enterRule(_localctx, 434, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1876); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(1878);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(1877); ((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(1881);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(1880); ((Sort_specifierContext)_localctx).null_order = null_ordering();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Order_specificationContext extends ParserRuleContext {
		public TerminalNode DESC() { return getToken(SQLParser.DESC, 0); }
		public TerminalNode ASC() { return getToken(SQLParser.ASC, 0); }
		public Order_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOrder_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOrder_specification(this);
		}
	}

	public final Order_specificationContext order_specification() throws RecognitionException {
		Order_specificationContext _localctx = new Order_specificationContext(_ctx, getState());
		enterRule(_localctx, 436, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1883);
			_la = _input.LA(1);
			if ( !(_la==ASC || _la==DESC) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Limit_clauseContext extends ParserRuleContext {
		public Numeric_value_expressionContext e;
		public TerminalNode LIMIT() { return getToken(SQLParser.LIMIT, 0); }
		public TerminalNode COMMA() { return getToken(SQLParser.COMMA, 0); }
		public List<Numeric_value_expressionContext> numeric_value_expression() {
			return getRuleContexts(Numeric_value_expressionContext.class);
		}
		public Numeric_value_expressionContext numeric_value_expression(int i) {
			return getRuleContext(Numeric_value_expressionContext.class,i);
		}
		public Limit_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterLimit_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitLimit_clause(this);
		}
	}

	public final Limit_clauseContext limit_clause() throws RecognitionException {
		Limit_clauseContext _localctx = new Limit_clauseContext(_ctx, getState());
		enterRule(_localctx, 438, RULE_limit_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1885); match(LIMIT);
			setState(1886); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			setState(1889);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1887); match(COMMA);
				setState(1888); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Null_orderingContext extends ParserRuleContext {
		public TerminalNode FIRST() { return getToken(SQLParser.FIRST, 0); }
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public TerminalNode LAST() { return getToken(SQLParser.LAST, 0); }
		public Null_orderingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_ordering; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNull_ordering(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNull_ordering(this);
		}
	}

	public final Null_orderingContext null_ordering() throws RecognitionException {
		Null_orderingContext _localctx = new Null_orderingContext(_ctx, getState());
		enterRule(_localctx, 440, RULE_null_ordering);
		try {
			setState(1895);
			switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1891); match(NULL);
				setState(1892); match(FIRST);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1893); match(NULL);
				setState(1894); match(LAST);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Insert_statementContext extends ParserRuleContext {
		public Token path;
		public IdentifierContext file_type;
		public Param_clauseContext param_clause() {
			return getRuleContext(Param_clauseContext.class,0);
		}
		public TerminalNode INTO() { return getToken(SQLParser.INTO, 0); }
		public TerminalNode INSERT() { return getToken(SQLParser.INSERT, 0); }
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public In_value_listContext in_value_list() {
			return getRuleContext(In_value_listContext.class,0);
		}
		public TerminalNode OVERWRITE() { return getToken(SQLParser.OVERWRITE, 0); }
		public Column_name_listContext column_name_list() {
			return getRuleContext(Column_name_listContext.class,0);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public Query_expressionContext query_expression() {
			return getRuleContext(Query_expressionContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public TerminalNode VALUES() { return getToken(SQLParser.VALUES, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Insert_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterInsert_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitInsert_statement(this);
		}
	}

	public final Insert_statementContext insert_statement() throws RecognitionException {
		Insert_statementContext _localctx = new Insert_statementContext(_ctx, getState());
		enterRule(_localctx, 442, RULE_insert_statement);
		int _la;
		try {
			setState(1943);
			switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1897); match(INSERT);
				setState(1899);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(1898); match(OVERWRITE);
					}
				}

				setState(1901); match(INTO);
				setState(1902); table_name();
				setState(1907);
				switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
				case 1:
					{
					setState(1903); match(LEFT_PAREN);
					setState(1904); column_name_list();
					setState(1905); match(RIGHT_PAREN);
					}
					break;
				}
				setState(1909); query_expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1911); match(INSERT);
				setState(1913);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(1912); match(OVERWRITE);
					}
				}

				setState(1915); match(INTO);
				setState(1916); match(LOCATION);
				setState(1917); ((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(1923);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1918); match(USING);
					setState(1919); ((Insert_statementContext)_localctx).file_type = identifier();
					setState(1921);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(1920); param_clause();
						}
					}

					}
				}

				setState(1925); query_expression();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1926); match(INSERT);
				setState(1928);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(1927); match(OVERWRITE);
					}
				}

				setState(1930); match(INTO);
				setState(1931); table_name();
				setState(1936);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1932); match(LEFT_PAREN);
					setState(1933); column_name_list();
					setState(1934); match(RIGHT_PAREN);
					}
				}

				setState(1938); match(VALUES);
				setState(1939); match(LEFT_PAREN);
				setState(1940); in_value_list();
				setState(1941); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_statementContext extends ParserRuleContext {
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode UPDATE() { return getToken(SQLParser.UPDATE, 0); }
		public Column_set_listContext column_set_list() {
			return getRuleContext(Column_set_listContext.class,0);
		}
		public Table_referenceContext table_reference() {
			return getRuleContext(Table_referenceContext.class,0);
		}
		public Update_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUpdate_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUpdate_statement(this);
		}
	}

	public final Update_statementContext update_statement() throws RecognitionException {
		Update_statementContext _localctx = new Update_statementContext(_ctx, getState());
		enterRule(_localctx, 444, RULE_update_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1945); match(UPDATE);
			setState(1946); table_reference();
			setState(1947); match(SET);
			setState(1948); column_set_list();
			setState(1950);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1949); where_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_set_listContext extends ParserRuleContext {
		public Equal_predicateContext equal_predicate(int i) {
			return getRuleContext(Equal_predicateContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Equal_predicateContext> equal_predicate() {
			return getRuleContexts(Equal_predicateContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Column_set_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_set_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterColumn_set_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitColumn_set_list(this);
		}
	}

	public final Column_set_listContext column_set_list() throws RecognitionException {
		Column_set_listContext _localctx = new Column_set_listContext(_ctx, getState());
		enterRule(_localctx, 446, RULE_column_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1952); equal_predicate();
			setState(1957);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1953); match(COMMA);
				setState(1954); equal_predicate();
				}
				}
				setState(1959);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_statementContext extends ParserRuleContext {
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public From_clauseContext from_clause() {
			return getRuleContext(From_clauseContext.class,0);
		}
		public TerminalNode DELETE() { return getToken(SQLParser.DELETE, 0); }
		public Delete_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDelete_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDelete_statement(this);
		}
	}

	public final Delete_statementContext delete_statement() throws RecognitionException {
		Delete_statementContext _localctx = new Delete_statementContext(_ctx, getState());
		enterRule(_localctx, 448, RULE_delete_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1960); match(DELETE);
			setState(1961); from_clause();
			setState(1963);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1962); where_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_tablespace_statementContext extends ParserRuleContext {
		public IdentifierContext space_name;
		public Token uri;
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Alter_tablespace_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_tablespace_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAlter_tablespace_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAlter_tablespace_statement(this);
		}
	}

	public final Alter_tablespace_statementContext alter_tablespace_statement() throws RecognitionException {
		Alter_tablespace_statementContext _localctx = new Alter_tablespace_statementContext(_ctx, getState());
		enterRule(_localctx, 450, RULE_alter_tablespace_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1965); match(ALTER);
			setState(1966); match(TABLESPACE);
			setState(1967); ((Alter_tablespace_statementContext)_localctx).space_name = identifier();
			setState(1968); match(LOCATION);
			setState(1969); ((Alter_tablespace_statementContext)_localctx).uri = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_table_statementContext extends ParserRuleContext {
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public List<TerminalNode> ALTER() { return getTokens(SQLParser.ALTER); }
		public Constraint_elementContext constraint_element() {
			return getRuleContext(Constraint_elementContext.class,0);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public Field_elementContext field_element() {
			return getRuleContext(Field_elementContext.class,0);
		}
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode ADD() { return getToken(SQLParser.ADD, 0); }
		public TerminalNode ALTER(int i) {
			return getToken(SQLParser.ALTER, i);
		}
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public Table_nameContext table_name(int i) {
			return getRuleContext(Table_nameContext.class,i);
		}
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public List<Table_nameContext> table_name() {
			return getRuleContexts(Table_nameContext.class);
		}
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public Alter_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAlter_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAlter_table_statement(this);
		}
	}

	public final Alter_table_statementContext alter_table_statement() throws RecognitionException {
		Alter_table_statementContext _localctx = new Alter_table_statementContext(_ctx, getState());
		enterRule(_localctx, 452, RULE_alter_table_statement);
		try {
			setState(2020);
			switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1971); match(ALTER);
				setState(1972); match(TABLE);
				setState(1973); table_name();
				setState(1974); match(RENAME);
				setState(1975); match(TO);
				setState(1976); table_name();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1978); match(ALTER);
				setState(1979); match(TABLE);
				setState(1980); table_name();
				setState(1981); match(RENAME);
				setState(1982); match(COLUMN);
				setState(1983); column_name();
				setState(1984); match(TO);
				setState(1985); column_name();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1987); match(ALTER);
				setState(1988); match(TABLE);
				setState(1989); table_name();
				setState(1990); match(ADD);
				setState(1991); match(COLUMN);
				setState(1992); field_element();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1994); match(ALTER);
				setState(1995); match(TABLE);
				setState(1996); table_name();
				setState(1997); match(ALTER);
				setState(1998); match(COLUMN);
				setState(1999); field_element();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2001); match(ALTER);
				setState(2002); match(TABLE);
				setState(2003); table_name();
				setState(2004); match(DROP);
				setState(2005); match(COLUMN);
				setState(2006); column_name();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2008); match(ALTER);
				setState(2009); match(TABLE);
				setState(2010); table_name();
				setState(2011); match(ADD);
				setState(2012); constraint_element();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2014); match(ALTER);
				setState(2015); match(TABLE);
				setState(2016); table_name();
				setState(2017); match(DROP);
				setState(2018); constraint_element();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u00e2\u07e9\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"+
		"\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"+
		"\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f\4\u00a0"+
		"\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4\t\u00a4"+
		"\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7\4\u00a8\t\u00a8\4\u00a9"+
		"\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac\t\u00ac\4\u00ad\t\u00ad"+
		"\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0\t\u00b0\4\u00b1\t\u00b1\4\u00b2"+
		"\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4\4\u00b5\t\u00b5\4\u00b6\t\u00b6"+
		"\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9\t\u00b9\4\u00ba\t\u00ba\4\u00bb"+
		"\t\u00bb\4\u00bc\t\u00bc\4\u00bd\t\u00bd\4\u00be\t\u00be\4\u00bf\t\u00bf"+
		"\4\u00c0\t\u00c0\4\u00c1\t\u00c1\4\u00c2\t\u00c2\4\u00c3\t\u00c3\4\u00c4"+
		"\t\u00c4\4\u00c5\t\u00c5\4\u00c6\t\u00c6\4\u00c7\t\u00c7\4\u00c8\t\u00c8"+
		"\4\u00c9\t\u00c9\4\u00ca\t\u00ca\4\u00cb\t\u00cb\4\u00cc\t\u00cc\4\u00cd"+
		"\t\u00cd\4\u00ce\t\u00ce\4\u00cf\t\u00cf\4\u00d0\t\u00d0\4\u00d1\t\u00d1"+
		"\4\u00d2\t\u00d2\4\u00d3\t\u00d3\4\u00d4\t\u00d4\4\u00d5\t\u00d5\4\u00d6"+
		"\t\u00d6\4\u00d7\t\u00d7\4\u00d8\t\u00d8\4\u00d9\t\u00d9\4\u00da\t\u00da"+
		"\4\u00db\t\u00db\4\u00dc\t\u00dc\4\u00dd\t\u00dd\4\u00de\t\u00de\4\u00df"+
		"\t\u00df\4\u00e0\t\u00e0\4\u00e1\t\u00e1\4\u00e2\t\u00e2\4\u00e3\t\u00e3"+
		"\4\u00e4\t\u00e4\3\2\5\2\u01ca\n\2\3\2\3\2\5\2\u01ce\n\2\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\5\4\u01d8\n\4\3\5\3\5\3\6\3\6\3\6\5\6\u01df\n\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u01e9\n\7\3\b\3\b\5\b\u01ed\n\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u01f4\n\b\3\b\3\b\3\b\3\b\5\b\u01fa\n\b\3\t\3\t\3\t"+
		"\5\t\u01ff\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\5\13\u020a\n\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\5\17\u021b\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u0222\n\17\3\17\5\17\u0225"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u022d\n\17\3\17\3\17\3\17\3\17"+
		"\5\17\u0233\n\17\3\17\5\17\u0236\n\17\3\17\5\17\u0239\n\17\3\17\3\17\5"+
		"\17\u023d\n\17\3\17\3\17\3\17\5\17\u0242\n\17\3\17\3\17\3\17\5\17\u0247"+
		"\n\17\3\17\5\17\u024a\n\17\3\17\5\17\u024d\n\17\3\17\3\17\3\17\5\17\u0252"+
		"\n\17\3\20\3\20\3\20\3\20\7\20\u0258\n\20\f\20\16\20\u025b\13\20\3\20"+
		"\3\20\7\20\u025f\n\20\f\20\16\20\u0262\13\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\22\3\22\7\22\u026b\n\22\f\22\16\22\u026e\13\22\3\23\3\23\3\23\3\23"+
		"\5\23\u0274\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u027e\n"+
		"\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u02a7"+
		"\n\31\3\32\3\32\3\32\5\32\u02ac\n\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\7\35\u02b9\n\35\f\35\16\35\u02bc\13\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3\"\3\"\5\""+
		"\u02d0\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\7$\u02df\n$\f$\16$\u02e2"+
		"\13$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u02ee\n%\3%\3%\5%\u02f2\n%\5%\u02f4"+
		"\n%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0301\n&\3\'\3\'\3\'\7\'\u0306"+
		"\n\'\f\'\16\'\u0309\13\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\3+\3+\3+\7+\u031e\n+\f+\16+\u0321\13+\3,\3,\3,\3,\5,\u0327\n,\3,\3"+
		",\3,\3,\3-\3-\3-\3-\3-\3.\3.\3/\3/\3/\5/\u0337\n/\3/\3/\5/\u033b\n/\3"+
		"\60\3\60\3\60\5\60\u0340\n\60\3\61\3\61\3\62\3\62\5\62\u0346\n\62\3\63"+
		"\3\63\3\63\5\63\u034b\n\63\3\64\3\64\3\64\3\64\5\64\u0351\n\64\3\65\3"+
		"\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\3:\3:\3;\3;\3;\3"+
		";\3;\3;\3;\3;\3;\5;\u036c\n;\3<\3<\3=\3=\5=\u0372\n=\3=\3=\5=\u0376\n"+
		"=\3=\3=\3=\5=\u037b\n=\3=\3=\3=\5=\u0380\n=\3=\3=\5=\u0384\n=\3=\5=\u0387"+
		"\n=\3>\3>\3>\3>\3?\3?\3?\5?\u0390\n?\3?\3?\3?\5?\u0395\n?\3?\3?\5?\u0399"+
		"\n?\3?\3?\3?\3?\5?\u039f\n?\3?\3?\3?\3?\5?\u03a5\n?\3?\3?\3?\5?\u03aa"+
		"\n?\3?\3?\5?\u03ae\n?\5?\u03b0\n?\3@\3@\5@\u03b4\n@\3@\3@\5@\u03b8\n@"+
		"\5@\u03ba\n@\3A\3A\5A\u03be\nA\3B\3B\5B\u03c2\nB\3B\3B\5B\u03c6\nB\3B"+
		"\3B\5B\u03ca\nB\3B\3B\3B\3B\3B\3B\3B\5B\u03d3\nB\3B\3B\3B\3B\5B\u03d9"+
		"\nB\5B\u03db\nB\3C\3C\5C\u03df\nC\3C\3C\3C\3C\3C\3C\5C\u03e7\nC\3D\3D"+
		"\3D\3D\3D\3D\3D\3D\5D\u03f1\nD\3E\3E\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F"+
		"\3F\3F\3F\5F\u0403\nF\3G\3G\5G\u0407\nG\3G\3G\5G\u040b\nG\3G\3G\3G\5G"+
		"\u0410\nG\5G\u0412\nG\3H\3H\5H\u0416\nH\3H\3H\3H\5H\u041b\nH\3H\3H\5H"+
		"\u041f\nH\5H\u0421\nH\3I\3I\5I\u0425\nI\3J\3J\3J\3J\3K\3K\3K\3K\3K\3K"+
		"\3K\5K\u0432\nK\3L\3L\3M\3M\3N\5N\u0439\nN\3N\3N\3O\3O\3P\3P\3P\3P\3P"+
		"\3P\5P\u0445\nP\5P\u0447\nP\3Q\3Q\3Q\5Q\u044c\nQ\3Q\3Q\3Q\3R\3R\3S\3S"+
		"\3S\3S\3S\3S\3T\3T\3T\3T\3T\3U\3U\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V"+
		"\6V\u046c\nV\rV\16V\u046d\3V\3V\5V\u0472\nV\3W\3W\5W\u0476\nW\3X\3X\3"+
		"X\6X\u047b\nX\rX\16X\u047c\3X\5X\u0480\nX\3X\3X\3Y\3Y\6Y\u0486\nY\rY\16"+
		"Y\u0487\3Y\5Y\u048b\nY\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3[\3[\3[\3[\3[\3\\\3\\\3\\"+
		"\3]\3]\5]\u049e\n]\3^\3^\3^\3^\3^\3^\3^\3_\3_\3`\3`\3a\3a\3a\5a\u04ae"+
		"\na\3b\3b\3b\5b\u04b3\nb\3c\3c\3c\7c\u04b8\nc\fc\16c\u04bb\13c\3d\3d\3"+
		"d\7d\u04c0\nd\fd\16d\u04c3\13d\3e\5e\u04c6\ne\3e\3e\3f\3f\3f\3f\7f\u04ce"+
		"\nf\ff\16f\u04d1\13f\3f\3f\3g\3g\3g\7g\u04d8\ng\fg\16g\u04db\13g\3g\5"+
		"g\u04de\ng\3h\3h\3i\3i\3j\3j\3j\3j\3j\3j\3j\3k\3k\3k\5k\u04ee\nk\3l\3"+
		"l\3m\3m\5m\u04f4\nm\3n\3n\3o\3o\3o\7o\u04fb\no\fo\16o\u04fe\13o\3p\3p"+
		"\3q\3q\5q\u0504\nq\3r\3r\3s\3s\3s\3s\3s\3t\5t\u050e\nt\3t\5t\u0511\nt"+
		"\3t\5t\u0514\nt\3t\3t\3t\3t\3t\5t\u051b\nt\3u\3u\3v\3v\3w\3w\3w\7w\u0524"+
		"\nw\fw\16w\u0527\13w\3x\3x\3x\7x\u052c\nx\fx\16x\u052f\13x\3y\3y\3y\5"+
		"y\u0534\ny\3z\3z\5z\u0538\nz\3{\3{\5{\u053c\n{\3{\3{\3|\3|\3}\3}\5}\u0544"+
		"\n}\3~\3~\5~\u0548\n~\3\177\3\177\3\177\3\177\3\u0080\3\u0080\5\u0080"+
		"\u0550\n\u0080\3\u0081\3\u0081\3\u0082\3\u0082\3\u0083\3\u0083\3\u0083"+
		"\5\u0083\u0559\n\u0083\3\u0084\3\u0084\5\u0084\u055d\n\u0084\3\u0085\3"+
		"\u0085\5\u0085\u0561\n\u0085\3\u0085\5\u0085\u0564\n\u0085\3\u0085\5\u0085"+
		"\u0567\n\u0085\3\u0085\5\u0085\u056a\n\u0085\3\u0085\5\u0085\u056d\n\u0085"+
		"\3\u0086\3\u0086\3\u0086\3\u0087\3\u0087\3\u0087\7\u0087\u0575\n\u0087"+
		"\f\u0087\16\u0087\u0578\13\u0087\3\u0088\3\u0088\5\u0088\u057c\n\u0088"+
		"\3\u0089\3\u0089\6\u0089\u0580\n\u0089\r\u0089\16\u0089\u0581\3\u008a"+
		"\3\u008a\3\u008a\3\u008a\5\u008a\u0588\n\u008a\3\u008a\3\u008a\3\u008a"+
		"\3\u008a\3\u008a\3\u008a\5\u008a\u0590\n\u008a\3\u008a\3\u008a\3\u008a"+
		"\3\u008a\3\u008a\5\u008a\u0597\n\u008a\3\u008b\3\u008b\3\u008b\3\u008b"+
		"\3\u008c\5\u008c\u059e\n\u008c\3\u008c\3\u008c\3\u008c\3\u008c\3\u008d"+
		"\3\u008d\5\u008d\u05a6\n\u008d\3\u008d\3\u008d\3\u008d\3\u008e\3\u008e"+
		"\3\u008e\3\u008e\3\u008f\3\u008f\5\u008f\u05b1\n\u008f\3\u0090\3\u0090"+
		"\5\u0090\u05b5\n\u0090\3\u0091\3\u0091\3\u0092\3\u0092\5\u0092\u05bb\n"+
		"\u0092\3\u0093\3\u0093\3\u0093\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094"+
		"\3\u0095\3\u0095\5\u0095\u05c7\n\u0095\3\u0095\5\u0095\u05ca\n\u0095\3"+
		"\u0095\3\u0095\3\u0095\3\u0095\5\u0095\u05d0\n\u0095\3\u0095\3\u0095\5"+
		"\u0095\u05d4\n\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\5\u0095\u05db"+
		"\n\u0095\5\u0095\u05dd\n\u0095\3\u0096\3\u0096\3\u0096\7\u0096\u05e2\n"+
		"\u0096\f\u0096\16\u0096\u05e5\13\u0096\3\u0097\3\u0097\3\u0098\3\u0098"+
		"\3\u0098\3\u0099\3\u0099\3\u009a\3\u009a\3\u009a\3\u009a\3\u009b\3\u009b"+
		"\3\u009b\7\u009b\u05f5\n\u009b\f\u009b\16\u009b\u05f8\13\u009b\3\u009c"+
		"\3\u009c\3\u009c\3\u009c\5\u009c\u05fe\n\u009c\3\u009d\3\u009d\3\u009d"+
		"\3\u009d\3\u009d\5\u009d\u0605\n\u009d\3\u009e\3\u009e\3\u009e\7\u009e"+
		"\u060a\n\u009e\f\u009e\16\u009e\u060d\13\u009e\3\u009f\3\u009f\3\u009f"+
		"\3\u009f\3\u009f\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a1\3\u00a1"+
		"\3\u00a1\3\u00a2\3\u00a2\3\u00a2\3\u00a3\3\u00a3\3\u00a3\7\u00a3\u0622"+
		"\n\u00a3\f\u00a3\16\u00a3\u0625\13\u00a3\3\u00a4\3\u00a4\3\u00a5\3\u00a5"+
		"\5\u00a5\u062b\n\u00a5\3\u00a6\3\u00a6\3\u00a6\3\u00a6\5\u00a6\u0631\n"+
		"\u00a6\3\u00a6\3\u00a6\5\u00a6\u0635\n\u00a6\3\u00a6\3\u00a6\5\u00a6\u0639"+
		"\n\u00a6\3\u00a6\7\u00a6\u063c\n\u00a6\f\u00a6\16\u00a6\u063f\13\u00a6"+
		"\3\u00a7\3\u00a7\5\u00a7\u0643\n\u00a7\3\u00a8\3\u00a8\3\u00a8\3\u00a8"+
		"\5\u00a8\u0649\n\u00a8\3\u00a8\3\u00a8\5\u00a8\u064d\n\u00a8\3\u00a8\3"+
		"\u00a8\5\u00a8\u0651\n\u00a8\3\u00a8\7\u00a8\u0654\n\u00a8\f\u00a8\16"+
		"\u00a8\u0657\13\u00a8\3\u00a9\3\u00a9\5\u00a9\u065b\n\u00a9\3\u00aa\3"+
		"\u00aa\3\u00aa\3\u00aa\3\u00aa\5\u00aa\u0662\n\u00aa\3\u00ab\3\u00ab\5"+
		"\u00ab\u0666\n\u00ab\3\u00ac\3\u00ac\3\u00ac\3\u00ad\3\u00ad\5\u00ad\u066d"+
		"\n\u00ad\3\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00ae\5\u00ae\u0674\n\u00ae"+
		"\5\u00ae\u0676\n\u00ae\3\u00af\3\u00af\3\u00b0\3\u00b0\5\u00b0\u067c\n"+
		"\u00b0\3\u00b0\3\u00b0\5\u00b0\u0680\n\u00b0\3\u00b1\3\u00b1\3\u00b1\7"+
		"\u00b1\u0685\n\u00b1\f\u00b1\16\u00b1\u0688\13\u00b1\3\u00b2\3\u00b2\5"+
		"\u00b2\u068c\n\u00b2\3\u00b3\3\u00b3\5\u00b3\u0690\n\u00b3\3\u00b4\3\u00b4"+
		"\3\u00b4\5\u00b4\u0695\n\u00b4\3\u00b4\3\u00b4\3\u00b5\3\u00b5\3\u00b6"+
		"\3\u00b6\3\u00b6\5\u00b6\u069e\n\u00b6\3\u00b6\3\u00b6\3\u00b6\5\u00b6"+
		"\u06a3\n\u00b6\3\u00b6\3\u00b6\3\u00b7\5\u00b7\u06a8\n\u00b7\3\u00b7\3"+
		"\u00b7\3\u00b8\3\u00b8\3\u00b8\7\u00b8\u06af\n\u00b8\f\u00b8\16\u00b8"+
		"\u06b2\13\u00b8\3\u00b9\3\u00b9\3\u00ba\3\u00ba\3\u00bb\3\u00bb\3\u00bc"+
		"\3\u00bc\3\u00bc\3\u00bc\3\u00bd\3\u00bd\3\u00bd\3\u00bd\3\u00bd\3\u00bd"+
		"\5\u00bd\u06c4\n\u00bd\3\u00be\3\u00be\3\u00be\3\u00be\3\u00bf\3\u00bf"+
		"\3\u00bf\3\u00bf\3\u00c0\3\u00c0\3\u00c1\3\u00c1\3\u00c2\3\u00c2\3\u00c2"+
		"\3\u00c3\5\u00c3\u06d6\n\u00c3\3\u00c3\3\u00c3\5\u00c3\u06da\n\u00c3\3"+
		"\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c4\3\u00c4\5\u00c4\u06e2\n\u00c4\3"+
		"\u00c4\3\u00c4\3\u00c4\3\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c5\5\u00c5"+
		"\u06ec\n\u00c5\3\u00c6\3\u00c6\3\u00c6\7\u00c6\u06f1\n\u00c6\f\u00c6\16"+
		"\u00c6\u06f4\13\u00c6\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7"+
		"\3\u00c7\3\u00c7\5\u00c7\u06fe\n\u00c7\3\u00c8\5\u00c8\u0701\n\u00c8\3"+
		"\u00c8\3\u00c8\5\u00c8\u0705\n\u00c8\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3"+
		"\u00c9\3\u00c9\5\u00c9\u070d\n\u00c9\3\u00ca\3\u00ca\3\u00cb\3\u00cb\3"+
		"\u00cb\5\u00cb\u0714\n\u00cb\3\u00cb\3\u00cb\3\u00cc\3\u00cc\3\u00cc\3"+
		"\u00cc\3\u00cc\3\u00cd\3\u00cd\5\u00cd\u071f\n\u00cd\3\u00ce\3\u00ce\3"+
		"\u00cf\3\u00cf\3\u00d0\5\u00d0\u0726\n\u00d0\3\u00d0\3\u00d0\3\u00d0\3"+
		"\u00d1\3\u00d1\3\u00d1\3\u00d2\3\u00d2\5\u00d2\u0730\n\u00d2\3\u00d3\3"+
		"\u00d3\3\u00d4\3\u00d4\3\u00d5\3\u00d5\3\u00d5\5\u00d5\u0739\n\u00d5\3"+
		"\u00d5\3\u00d5\3\u00d6\3\u00d6\3\u00d7\3\u00d7\5\u00d7\u0741\n\u00d7\3"+
		"\u00d8\3\u00d8\3\u00d8\7\u00d8\u0746\n\u00d8\f\u00d8\16\u00d8\u0749\13"+
		"\u00d8\3\u00d9\3\u00d9\3\u00d9\3\u00d9\3\u00da\3\u00da\3\u00da\7\u00da"+
		"\u0752\n\u00da\f\u00da\16\u00da\u0755\13\u00da\3\u00db\3\u00db\5\u00db"+
		"\u0759\n\u00db\3\u00db\5\u00db\u075c\n\u00db\3\u00dc\3\u00dc\3\u00dd\3"+
		"\u00dd\3\u00dd\3\u00dd\5\u00dd\u0764\n\u00dd\3\u00de\3\u00de\3\u00de\3"+
		"\u00de\5\u00de\u076a\n\u00de\3\u00df\3\u00df\5\u00df\u076e\n\u00df\3\u00df"+
		"\3\u00df\3\u00df\3\u00df\3\u00df\3\u00df\5\u00df\u0776\n\u00df\3\u00df"+
		"\3\u00df\3\u00df\3\u00df\5\u00df\u077c\n\u00df\3\u00df\3\u00df\3\u00df"+
		"\3\u00df\3\u00df\3\u00df\5\u00df\u0784\n\u00df\5\u00df\u0786\n\u00df\3"+
		"\u00df\3\u00df\3\u00df\5\u00df\u078b\n\u00df\3\u00df\3\u00df\3\u00df\3"+
		"\u00df\3\u00df\3\u00df\5\u00df\u0793\n\u00df\3\u00df\3\u00df\3\u00df\3"+
		"\u00df\3\u00df\5\u00df\u079a\n\u00df\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3"+
		"\u00e0\5\u00e0\u07a1\n\u00e0\3\u00e1\3\u00e1\3\u00e1\7\u00e1\u07a6\n\u00e1"+
		"\f\u00e1\16\u00e1\u07a9\13\u00e1\3\u00e2\3\u00e2\3\u00e2\5\u00e2\u07ae"+
		"\n\u00e2\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e4\3\u00e4"+
		"\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4"+
		"\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4"+
		"\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4"+
		"\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4"+
		"\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4"+
		"\3\u00e4\3\u00e4\5\u00e4\u07e7\n\u00e4\3\u00e4\2\2\u00e5\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd"+
		"fhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092"+
		"\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa"+
		"\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2"+
		"\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da"+
		"\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2"+
		"\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a"+
		"\u010c\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122"+
		"\u0124\u0126\u0128\u012a\u012c\u012e\u0130\u0132\u0134\u0136\u0138\u013a"+
		"\u013c\u013e\u0140\u0142\u0144\u0146\u0148\u014a\u014c\u014e\u0150\u0152"+
		"\u0154\u0156\u0158\u015a\u015c\u015e\u0160\u0162\u0164\u0166\u0168\u016a"+
		"\u016c\u016e\u0170\u0172\u0174\u0176\u0178\u017a\u017c\u017e\u0180\u0182"+
		"\u0184\u0186\u0188\u018a\u018c\u018e\u0190\u0192\u0194\u0196\u0198\u019a"+
		"\u019c\u019e\u01a0\u01a2\u01a4\u01a6\u01a8\u01aa\u01ac\u01ae\u01b0\u01b2"+
		"\u01b4\u01b6\u01b8\u01ba\u01bc\u01be\u01c0\u01c2\u01c4\u01c6\2\26\20\2"+
		"\67\67;=?GJJLPR[]^aegy{\u0080\u0082\u0088\u008a\u0090\u0092\u00b7\u00b9"+
		"\u00bc\5\2\24\24\62\62\u0092\u0092\3\2\u0099\u009a\3\2\u00d9\u00da\17"+
		"\2\6\6--;;CCFFSS[[cckkpp\u0085\u0086\u0088\u0088\u0093\u0094\3\2\u00cf"+
		"\u00d0\3\2\u00d1\u00d3\3\2\u008c\u008e\5\2\t\t  \61\61\5\2\25\25!!++\4"+
		"\2\23\23\63\63\4\2\4\4\17\17\4\2\u00c3\u00c3\u00c8\u00cc\4\2\7\7..\3\2"+
		"\u00bd\u00c0\4\2\6\6--\6\2JJ__qr\u0097\u0097\t\2AAMORRdemo{{\u0096\u0096"+
		"\4\2!!++\4\2\b\b\16\16\u082e\2\u01c9\3\2\2\2\4\u01d1\3\2\2\2\6\u01d7\3"+
		"\2\2\2\b\u01d9\3\2\2\2\n\u01de\3\2\2\2\f\u01e8\3\2\2\2\16\u01ea\3\2\2"+
		"\2\20\u01fb\3\2\2\2\22\u0202\3\2\2\2\24\u0206\3\2\2\2\26\u020d\3\2\2\2"+
		"\30\u0210\3\2\2\2\32\u0213\3\2\2\2\34\u0251\3\2\2\2\36\u0253\3\2\2\2 "+
		"\u0265\3\2\2\2\"\u0268\3\2\2\2$\u0273\3\2\2\2&\u027d\3\2\2\2(\u027f\3"+
		"\2\2\2*\u0284\3\2\2\2,\u028f\3\2\2\2.\u0295\3\2\2\2\60\u02a6\3\2\2\2\62"+
		"\u02ab\3\2\2\2\64\u02ad\3\2\2\2\66\u02b0\3\2\2\28\u02b3\3\2\2\2:\u02bf"+
		"\3\2\2\2<\u02c3\3\2\2\2>\u02c6\3\2\2\2@\u02c9\3\2\2\2B\u02cf\3\2\2\2D"+
		"\u02d1\3\2\2\2F\u02db\3\2\2\2H\u02e3\3\2\2\2J\u02f5\3\2\2\2L\u0302\3\2"+
		"\2\2N\u030a\3\2\2\2P\u030d\3\2\2\2R\u0310\3\2\2\2T\u031a\3\2\2\2V\u0322"+
		"\3\2\2\2X\u032c\3\2\2\2Z\u0331\3\2\2\2\\\u0333\3\2\2\2^\u033f\3\2\2\2"+
		"`\u0341\3\2\2\2b\u0345\3\2\2\2d\u034a\3\2\2\2f\u0350\3\2\2\2h\u0352\3"+
		"\2\2\2j\u0355\3\2\2\2l\u0358\3\2\2\2n\u035b\3\2\2\2p\u035e\3\2\2\2r\u0360"+
		"\3\2\2\2t\u036b\3\2\2\2v\u036d\3\2\2\2x\u0386\3\2\2\2z\u0388\3\2\2\2|"+
		"\u03af\3\2\2\2~\u03b9\3\2\2\2\u0080\u03bd\3\2\2\2\u0082\u03da\3\2\2\2"+
		"\u0084\u03e6\3\2\2\2\u0086\u03f0\3\2\2\2\u0088\u03f2\3\2\2\2\u008a\u0402"+
		"\3\2\2\2\u008c\u0411\3\2\2\2\u008e\u0420\3\2\2\2\u0090\u0424\3\2\2\2\u0092"+
		"\u0426\3\2\2\2\u0094\u0431\3\2\2\2\u0096\u0433\3\2\2\2\u0098\u0435\3\2"+
		"\2\2\u009a\u0438\3\2\2\2\u009c\u043c\3\2\2\2\u009e\u0446\3\2\2\2\u00a0"+
		"\u0448\3\2\2\2\u00a2\u0450\3\2\2\2\u00a4\u0452\3\2\2\2\u00a6\u0458\3\2"+
		"\2\2\u00a8\u045d\3\2\2\2\u00aa\u0471\3\2\2\2\u00ac\u0475\3\2\2\2\u00ae"+
		"\u0477\3\2\2\2\u00b0\u0483\3\2\2\2\u00b2\u048e\3\2\2\2\u00b4\u0493\3\2"+
		"\2\2\u00b6\u0498\3\2\2\2\u00b8\u049d\3\2\2\2\u00ba\u049f\3\2\2\2\u00bc"+
		"\u04a6\3\2\2\2\u00be\u04a8\3\2\2\2\u00c0\u04ad\3\2\2\2\u00c2\u04b2\3\2"+
		"\2\2\u00c4\u04b4\3\2\2\2\u00c6\u04bc\3\2\2\2\u00c8\u04c5\3\2\2\2\u00ca"+
		"\u04c9\3\2\2\2\u00cc\u04dd\3\2\2\2\u00ce\u04df\3\2\2\2\u00d0\u04e1\3\2"+
		"\2\2\u00d2\u04e3\3\2\2\2\u00d4\u04ed\3\2\2\2\u00d6\u04ef\3\2\2\2\u00d8"+
		"\u04f3\3\2\2\2\u00da\u04f5\3\2\2\2\u00dc\u04f7\3\2\2\2\u00de\u04ff\3\2"+
		"\2\2\u00e0\u0503\3\2\2\2\u00e2\u0505\3\2\2\2\u00e4\u0507\3\2\2\2\u00e6"+
		"\u051a\3\2\2\2\u00e8\u051c\3\2\2\2\u00ea\u051e\3\2\2\2\u00ec\u0520\3\2"+
		"\2\2\u00ee\u0528\3\2\2\2\u00f0\u0533\3\2\2\2\u00f2\u0535\3\2\2\2\u00f4"+
		"\u0539\3\2\2\2\u00f6\u053f\3\2\2\2\u00f8\u0543\3\2\2\2\u00fa\u0547\3\2"+
		"\2\2\u00fc\u0549\3\2\2\2\u00fe\u054f\3\2\2\2\u0100\u0551\3\2\2\2\u0102"+
		"\u0553\3\2\2\2\u0104\u0558\3\2\2\2\u0106\u055c\3\2\2\2\u0108\u055e\3\2"+
		"\2\2\u010a\u056e\3\2\2\2\u010c\u0571\3\2\2\2\u010e\u057b\3\2\2\2\u0110"+
		"\u057d\3\2\2\2\u0112\u0596\3\2\2\2\u0114\u0598\3\2\2\2\u0116\u059d\3\2"+
		"\2\2\u0118\u05a3\3\2\2\2\u011a\u05aa\3\2\2\2\u011c\u05b0\3\2\2\2\u011e"+
		"\u05b2\3\2\2\2\u0120\u05b6\3\2\2\2\u0122\u05ba\3\2\2\2\u0124\u05bc\3\2"+
		"\2\2\u0126\u05bf\3\2\2\2\u0128\u05dc\3\2\2\2\u012a\u05de\3\2\2\2\u012c"+
		"\u05e6\3\2\2\2\u012e\u05e8\3\2\2\2\u0130\u05eb\3\2\2\2\u0132\u05ed\3\2"+
		"\2\2\u0134\u05f1\3\2\2\2\u0136\u05fd\3\2\2\2\u0138\u0604\3\2\2\2\u013a"+
		"\u0606\3\2\2\2\u013c\u060e\3\2\2\2\u013e\u0613\3\2\2\2\u0140\u0618\3\2"+
		"\2\2\u0142\u061b\3\2\2\2\u0144\u061e\3\2\2\2\u0146\u0626\3\2\2\2\u0148"+
		"\u062a\3\2\2\2\u014a\u0634\3\2\2\2\u014c\u0642\3\2\2\2\u014e\u064c\3\2"+
		"\2\2\u0150\u065a\3\2\2\2\u0152\u0661\3\2\2\2\u0154\u0665\3\2\2\2\u0156"+
		"\u0667\3\2\2\2\u0158\u066c\3\2\2\2\u015a\u066e\3\2\2\2\u015c\u0677\3\2"+
		"\2\2\u015e\u0679\3\2\2\2\u0160\u0681\3\2\2\2\u0162\u068b\3\2\2\2\u0164"+
		"\u068d\3\2\2\2\u0166\u0694\3\2\2\2\u0168\u0698\3\2\2\2\u016a\u06a2\3\2"+
		"\2\2\u016c\u06a7\3\2\2\2\u016e\u06ab\3\2\2\2\u0170\u06b3\3\2\2\2\u0172"+
		"\u06b5\3\2\2\2\u0174\u06b7\3\2\2\2\u0176\u06b9\3\2\2\2\u0178\u06c3\3\2"+
		"\2\2\u017a\u06c5\3\2\2\2\u017c\u06c9\3\2\2\2\u017e\u06cd\3\2\2\2\u0180"+
		"\u06cf\3\2\2\2\u0182\u06d1\3\2\2\2\u0184\u06d5\3\2\2\2\u0186\u06df\3\2"+
		"\2\2\u0188\u06eb\3\2\2\2\u018a\u06ed\3\2\2\2\u018c\u06fd\3\2\2\2\u018e"+
		"\u0704\3\2\2\2\u0190\u070c\3\2\2\2\u0192\u070e\3\2\2\2\u0194\u0710\3\2"+
		"\2\2\u0196\u0717\3\2\2\2\u0198\u071e\3\2\2\2\u019a\u0720\3\2\2\2\u019c"+
		"\u0722\3\2\2\2\u019e\u0725\3\2\2\2\u01a0\u072a\3\2\2\2\u01a2\u072f\3\2"+
		"\2\2\u01a4\u0731\3\2\2\2\u01a6\u0733\3\2\2\2\u01a8\u0735\3\2\2\2\u01aa"+
		"\u073c\3\2\2\2\u01ac\u0740\3\2\2\2\u01ae\u0742\3\2\2\2\u01b0\u074a\3\2"+
		"\2\2\u01b2\u074e\3\2\2\2\u01b4\u0756\3\2\2\2\u01b6\u075d\3\2\2\2\u01b8"+
		"\u075f\3\2\2\2\u01ba\u0769\3\2\2\2\u01bc\u0799\3\2\2\2\u01be\u079b\3\2"+
		"\2\2\u01c0\u07a2\3\2\2\2\u01c2\u07aa\3\2\2\2\u01c4\u07af\3\2\2\2\u01c6"+
		"\u07e6\3\2\2\2\u01c8\u01ca\5\4\3\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2"+
		"\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cd\5\6\4\2\u01cc\u01ce\7\u00c5\2\2\u01cd"+
		"\u01cc\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\7\2"+
		"\2\3\u01d0\3\3\2\2\2\u01d1\u01d2\7U\2\2\u01d2\5\3\2\2\2\u01d3\u01d8\5"+
		"\b\5\2\u01d4\u01d8\5\n\6\2\u01d5\u01d8\5\f\7\2\u01d6\u01d8\5\16\b\2\u01d7"+
		"\u01d3\3\2\2\2\u01d7\u01d4\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d6\3\2"+
		"\2\2\u01d8\7\3\2\2\2\u01d9\u01da\5\u0146\u00a4\2\u01da\t\3\2\2\2\u01db"+
		"\u01df\5\u01bc\u00df\2\u01dc\u01df\5\u01be\u00e0\2\u01dd\u01df\5\u01c2"+
		"\u00e2\2\u01de\u01db\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01dd\3\2\2\2\u01df"+
		"\13\3\2\2\2\u01e0\u01e9\5\20\t\2\u01e1\u01e9\5\24\13\2\u01e2\u01e9\5\34"+
		"\17\2\u01e3\u01e9\5\\/\2\u01e4\u01e9\5\u01c4\u00e3\2\u01e5\u01e9\5\u01c6"+
		"\u00e4\2\u01e6\u01e9\5\30\r\2\u01e7\u01e9\5\32\16\2\u01e8\u01e0\3\2\2"+
		"\2\u01e8\u01e1\3\2\2\2\u01e8\u01e2\3\2\2\2\u01e8\u01e3\3\2\2\2\u01e8\u01e4"+
		"\3\2\2\2\u01e8\u01e5\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e7\3\2\2\2\u01e9"+
		"\r\3\2\2\2\u01ea\u01ec\7\f\2\2\u01eb\u01ed\7\64\2\2\u01ec\u01eb\3\2\2"+
		"\2\u01ec\u01ed\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ef\7a\2\2\u01ef\u01f0"+
		"\5^\60\2\u01f0\u01f1\7\'\2\2\u01f1\u01f3\5\u015a\u00ae\2\u01f2\u01f4\5"+
		"<\37\2\u01f3\u01f2\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5"+
		"\u01f6\7\u00cd\2\2\u01f6\u01f7\5\u01b2\u00da\2\u01f7\u01f9\7\u00ce\2\2"+
		"\u01f8\u01fa\58\35\2\u01f9\u01f8\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\17"+
		"\3\2\2\2\u01fb\u01fc\7\f\2\2\u01fc\u01fe\7K\2\2\u01fd\u01ff\5\22\n\2\u01fe"+
		"\u01fd\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0201\5^"+
		"\60\2\u0201\21\3\2\2\2\u0202\u0203\7`\2\2\u0203\u0204\7%\2\2\u0204\u0205"+
		"\7T\2\2\u0205\23\3\2\2\2\u0206\u0207\7P\2\2\u0207\u0209\7K\2\2\u0208\u020a"+
		"\5\26\f\2\u0209\u0208\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020b\3\2\2\2"+
		"\u020b\u020c\5^\60\2\u020c\25\3\2\2\2\u020d\u020e\7`\2\2\u020e\u020f\7"+
		"T\2\2\u020f\27\3\2\2\2\u0210\u0211\7\16\2\2\u0211\u0212\5\u015a\u00ae"+
		"\2\u0212\31\3\2\2\2\u0213\u0214\7\u0089\2\2\u0214\u0215\7\u0091\2\2\u0215"+
		"\33\3\2\2\2\u0216\u0217\7\f\2\2\u0217\u0218\7V\2\2\u0218\u021a\7/\2\2"+
		"\u0219\u021b\5\22\n\2\u021a\u0219\3\2\2\2\u021a\u021b\3\2\2\2\u021b\u021c"+
		"\3\2\2\2\u021c\u021d\5\u015a\u00ae\2\u021d\u021e\5\36\20\2\u021e\u021f"+
		"\7\66\2\2\u021f\u0221\5^\60\2\u0220\u0222\58\35\2\u0221\u0220\3\2\2\2"+
		"\u0221\u0222\3\2\2\2\u0222\u0224\3\2\2\2\u0223\u0225\5B\"\2\u0224\u0223"+
		"\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\7j\2\2\u0227"+
		"\u0228\7\u00df\2\2\u0228\u0252\3\2\2\2\u0229\u022a\7\f\2\2\u022a\u022c"+
		"\7/\2\2\u022b\u022d\5\22\n\2\u022c\u022b\3\2\2\2\u022c\u022d\3\2\2\2\u022d"+
		"\u022e\3\2\2\2\u022e\u022f\5\u015a\u00ae\2\u022f\u0232\5\36\20\2\u0230"+
		"\u0231\7\66\2\2\u0231\u0233\5^\60\2\u0232\u0230\3\2\2\2\u0232\u0233\3"+
		"\2\2\2\u0233\u0235\3\2\2\2\u0234\u0236\58\35\2\u0235\u0234\3\2\2\2\u0235"+
		"\u0236\3\2\2\2\u0236\u0238\3\2\2\2\u0237\u0239\5B\"\2\u0238\u0237\3\2"+
		"\2\2\u0238\u0239\3\2\2\2\u0239\u023c\3\2\2\2\u023a\u023b\7\3\2\2\u023b"+
		"\u023d\5\u0146\u00a4\2\u023c\u023a\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u0252"+
		"\3\2\2\2\u023e\u023f\7\f\2\2\u023f\u0241\7/\2\2\u0240\u0242\5\22\n\2\u0241"+
		"\u0240\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0246\5\u015a"+
		"\u00ae\2\u0244\u0245\7\66\2\2\u0245\u0247\5^\60\2\u0246\u0244\3\2\2\2"+
		"\u0246\u0247\3\2\2\2\u0247\u0249\3\2\2\2\u0248\u024a\58\35\2\u0249\u0248"+
		"\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024c\3\2\2\2\u024b\u024d\5B\"\2\u024c"+
		"\u024b\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u024f\7\3"+
		"\2\2\u024f\u0250\5\u0146\u00a4\2\u0250\u0252\3\2\2\2\u0251\u0216\3\2\2"+
		"\2\u0251\u0229\3\2\2\2\u0251\u023e\3\2\2\2\u0252\35\3\2\2\2\u0253\u0254"+
		"\7\u00cd\2\2\u0254\u0259\5 \21\2\u0255\u0256\7\u00c6\2\2\u0256\u0258\5"+
		" \21\2\u0257\u0255\3\2\2\2\u0258\u025b\3\2\2\2\u0259\u0257\3\2\2\2\u0259"+
		"\u025a\3\2\2\2\u025a\u0260\3\2\2\2\u025b\u0259\3\2\2\2\u025c\u025d\7\u00c6"+
		"\2\2\u025d\u025f\5&\24\2\u025e\u025c\3\2\2\2\u025f\u0262\3\2\2\2\u0260"+
		"\u025e\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0263\3\2\2\2\u0262\u0260\3\2"+
		"\2\2\u0263\u0264\7\u00ce\2\2\u0264\37\3\2\2\2\u0265\u0266\5^\60\2\u0266"+
		"\u0267\5\"\22\2\u0267!\3\2\2\2\u0268\u026c\5r:\2\u0269\u026b\5$\23\2\u026a"+
		"\u0269\3\2\2\2\u026b\u026e\3\2\2\2\u026c\u026a\3\2\2\2\u026c\u026d\3\2"+
		"\2\2\u026d#\3\2\2\2\u026e\u026c\3\2\2\2\u026f\u0274\5\62\32\2\u0270\u0274"+
		"\5\66\34\2\u0271\u0274\5\64\33\2\u0272\u0274\5(\25\2\u0273\u026f\3\2\2"+
		"\2\u0273\u0270\3\2\2\2\u0273\u0271\3\2\2\2\u0273\u0272\3\2\2\2\u0274%"+
		"\3\2\2\2\u0275\u027e\5,\27\2\u0276\u027e\5*\26\2\u0277\u027e\5.\30\2\u0278"+
		"\u027e\5\60\31\2\u0279\u027a\7H\2\2\u027a\u027b\5^\60\2\u027b\u027c\5"+
		"*\26\2\u027c\u027e\3\2\2\2\u027d\u0275\3\2\2\2\u027d\u0276\3\2\2\2\u027d"+
		"\u0277\3\2\2\2\u027d\u0278\3\2\2\2\u027d\u0279\3\2\2\2\u027e\'\3\2\2\2"+
		"\u027f\u0280\7I\2\2\u0280\u0281\7\u00d7\2\2\u0281\u0282\7\u00df\2\2\u0282"+
		"\u0283\7\u00d7\2\2\u0283)\3\2\2\2\u0284\u0285\7\\\2\2\u0285\u0286\7f\2"+
		"\2\u0286\u0287\7\u00cd\2\2\u0287\u0288\5\u012a\u0096\2\u0288\u0289\7\u00ce"+
		"\2\2\u0289\u028a\7\u0081\2\2\u028a\u028b\5\u015a\u00ae\2\u028b\u028c\7"+
		"\u00cd\2\2\u028c\u028d\5\u012a\u0096\2\u028d\u028e\7\u00ce\2\2\u028e+"+
		"\3\2\2\2\u028f\u0290\7z\2\2\u0290\u0291\7f\2\2\u0291\u0292\7\u00cd\2\2"+
		"\u0292\u0293\5\u012a\u0096\2\u0293\u0294\7\u00ce\2\2\u0294-\3\2\2\2\u0295"+
		"\u0296\7\64\2\2\u0296\u0297\7\u00cd\2\2\u0297\u0298\5\u012a\u0096\2\u0298"+
		"\u0299\7\u00ce\2\2\u0299/\3\2\2\2\u029a\u029b\7H\2\2\u029b\u029c\5^\60"+
		"\2\u029c\u029d\5,\27\2\u029d\u02a7\3\2\2\2\u029e\u029f\7H\2\2\u029f\u02a0"+
		"\5^\60\2\u02a0\u02a1\5*\26\2\u02a1\u02a7\3\2\2\2\u02a2\u02a3\7H\2\2\u02a3"+
		"\u02a4\5^\60\2\u02a4\u02a5\5.\30\2\u02a5\u02a7\3\2\2\2\u02a6\u029a\3\2"+
		"\2\2\u02a6\u029e\3\2\2\2\u02a6\u02a2\3\2\2\2\u02a7\61\3\2\2\2\u02a8\u02a9"+
		"\7%\2\2\u02a9\u02ac\7&\2\2\u02aa\u02ac\7&\2\2\u02ab\u02a8\3\2\2\2\u02ab"+
		"\u02aa\3\2\2\2\u02ac\63\3\2\2\2\u02ad\u02ae\7>\2\2\u02ae\u02af\5^\60\2"+
		"\u02af\65\3\2\2\2\u02b0\u02b1\7Q\2\2\u02b1\u02b2\5\u00fe\u0080\2\u02b2"+
		"\67\3\2\2\2\u02b3\u02b4\7:\2\2\u02b4\u02b5\7\u00cd\2\2\u02b5\u02ba\5:"+
		"\36\2\u02b6\u02b7\7\u00c6\2\2\u02b7\u02b9\5:\36\2\u02b8\u02b6\3\2\2\2"+
		"\u02b9\u02bc\3\2\2\2\u02ba\u02b8\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bb\u02bd"+
		"\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bd\u02be\7\u00ce\2\2\u02be9\3\2\2\2\u02bf"+
		"\u02c0\7\u00df\2\2\u02c0\u02c1\7\u00c3\2\2\u02c1\u02c2\5\u00c4c\2\u02c2"+
		";\3\2\2\2\u02c3\u02c4\7\66\2\2\u02c4\u02c5\5^\60\2\u02c5=\3\2\2\2\u02c6"+
		"\u02c7\7\u008a\2\2\u02c7\u02c8\5@!\2\u02c8?\3\2\2\2\u02c9\u02ca\5^\60"+
		"\2\u02caA\3\2\2\2\u02cb\u02d0\5D#\2\u02cc\u02d0\5J&\2\u02cd\u02d0\5R*"+
		"\2\u02ce\u02d0\5X-\2\u02cf\u02cb\3\2\2\2\u02cf\u02cc\3\2\2\2\u02cf\u02cd"+
		"\3\2\2\2\u02cf\u02ce\3\2\2\2\u02d0C\3\2\2\2\u02d1\u02d2\7v\2\2\u02d2\u02d3"+
		"\7@\2\2\u02d3\u02d4\7|\2\2\u02d4\u02d5\7\u00cd\2\2\u02d5\u02d6\5\u016e"+
		"\u00b8\2\u02d6\u02d7\7\u00ce\2\2\u02d7\u02d8\7\u00cd\2\2\u02d8\u02d9\5"+
		"F$\2\u02d9\u02da\7\u00ce\2\2\u02daE\3\2\2\2\u02db\u02e0\5H%\2\u02dc\u02dd"+
		"\7\u00c6\2\2\u02dd\u02df\5H%\2\u02de\u02dc\3\2\2\2\u02df\u02e2\3\2\2\2"+
		"\u02e0\u02de\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1G\3\2\2\2\u02e2\u02e0\3"+
		"\2\2\2\u02e3\u02e4\7v\2\2\u02e4\u02e5\5Z.\2\u02e5\u02e6\7\67\2\2\u02e6"+
		"\u02e7\7h\2\2\u02e7\u02f3\7\u008b\2\2\u02e8\u02e9\7\u00cd\2\2\u02e9\u02ea"+
		"\5\u00c0a\2\u02ea\u02eb\7\u00ce\2\2\u02eb\u02f4\3\2\2\2\u02ec\u02ee\7"+
		"\u00cd\2\2\u02ed\u02ec\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee\u02ef\3\2\2\2"+
		"\u02ef\u02f1\7l\2\2\u02f0\u02f2\7\u00ce\2\2\u02f1\u02f0\3\2\2\2\u02f1"+
		"\u02f2\3\2\2\2\u02f2\u02f4\3\2\2\2\u02f3\u02e8\3\2\2\2\u02f3\u02ed\3\2"+
		"\2\2\u02f4I\3\2\2\2\u02f5\u02f6\7v\2\2\u02f6\u02f7\7@\2\2\u02f7\u02f8"+
		"\7^\2\2\u02f8\u02f9\7\u00cd\2\2\u02f9\u02fa\5\u016e\u00b8\2\u02fa\u0300"+
		"\7\u00ce\2\2\u02fb\u02fc\7\u00cd\2\2\u02fc\u02fd\5L\'\2\u02fd\u02fe\7"+
		"\u00ce\2\2\u02fe\u0301\3\2\2\2\u02ff\u0301\5P)\2\u0300\u02fb\3\2\2\2\u0300"+
		"\u02ff\3\2\2\2\u0301K\3\2\2\2\u0302\u0307\5N(\2\u0303\u0304\7\u00c6\2"+
		"\2\u0304\u0306\5N(\2\u0305\u0303\3\2\2\2\u0306\u0309\3\2\2\2\u0307\u0305"+
		"\3\2\2\2\u0307\u0308\3\2\2\2\u0308M\3\2\2\2\u0309\u0307\3\2\2\2\u030a"+
		"\u030b\7v\2\2\u030b\u030c\5Z.\2\u030cO\3\2\2\2\u030d\u030e\7w\2\2\u030e"+
		"\u030f\5\u00c4c\2\u030fQ\3\2\2\2\u0310\u0311\7v\2\2\u0311\u0312\7@\2\2"+
		"\u0312\u0313\7i\2\2\u0313\u0314\7\u00cd\2\2\u0314\u0315\5\u016e\u00b8"+
		"\2\u0315\u0316\7\u00ce\2\2\u0316\u0317\7\u00cd\2\2\u0317\u0318\5T+\2\u0318"+
		"\u0319\7\u00ce\2\2\u0319S\3\2\2\2\u031a\u031f\5V,\2\u031b\u031c\7\u00c6"+
		"\2\2\u031c\u031e\5V,\2\u031d\u031b\3\2\2\2\u031e\u0321\3\2\2\2\u031f\u031d"+
		"\3\2\2\2\u031f\u0320\3\2\2\2\u0320U\3\2\2\2\u0321\u031f\3\2\2\2\u0322"+
		"\u0323\7v\2\2\u0323\u0324\5Z.\2\u0324\u0326\7\67\2\2\u0325\u0327\7\32"+
		"\2\2\u0326\u0325\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u0328\3\2\2\2\u0328"+
		"\u0329\7\u00cd\2\2\u0329\u032a\5\u018a\u00c6\2\u032a\u032b\7\u00ce\2\2"+
		"\u032bW\3\2\2\2\u032c\u032d\7v\2\2\u032d\u032e\7@\2\2\u032e\u032f\7E\2"+
		"\2\u032f\u0330\5\36\20\2\u0330Y\3\2\2\2\u0331\u0332\5^\60\2\u0332[\3\2"+
		"\2\2\u0333\u0334\7P\2\2\u0334\u0336\7/\2\2\u0335\u0337\5\26\f\2\u0336"+
		"\u0335\3\2\2\2\u0336\u0337\3\2\2\2\u0337\u0338\3\2\2\2\u0338\u033a\5\u015a"+
		"\u00ae\2\u0339\u033b\7y\2\2\u033a\u0339\3\2\2\2\u033a\u033b\3\2\2\2\u033b"+
		"]\3\2\2\2\u033c\u0340\7\u00dd\2\2\u033d\u0340\5`\61\2\u033e\u0340\7\u00de"+
		"\2\2\u033f\u033c\3\2\2\2\u033f\u033d\3\2\2\2\u033f\u033e\3\2\2\2\u0340"+
		"_\3\2\2\2\u0341\u0342\t\2\2\2\u0342a\3\2\2\2\u0343\u0346\5\u0098M\2\u0344"+
		"\u0346\5d\63\2\u0345\u0343\3\2\2\2\u0345\u0344\3\2\2\2\u0346c\3\2\2\2"+
		"\u0347\u034b\7\u00df\2\2\u0348\u034b\5f\64\2\u0349\u034b\5p9\2\u034a\u0347"+
		"\3\2\2\2\u034a\u0348\3\2\2\2\u034a\u0349\3\2\2\2\u034be\3\2\2\2\u034c"+
		"\u0351\5j\66\2\u034d\u0351\5h\65\2\u034e\u0351\5l\67\2\u034f\u0351\5n"+
		"8\2\u0350\u034c\3\2\2\2\u0350\u034d\3\2\2\2\u0350\u034e\3\2\2\2\u0350"+
		"\u034f\3\2\2\2\u0351g\3\2\2\2\u0352\u0353\7\u00b3\2\2\u0353\u0354\7\u00df"+
		"\2\2\u0354i\3\2\2\2\u0355\u0356\7\u00b5\2\2\u0356\u0357\7\u00df\2\2\u0357"+
		"k\3\2\2\2\u0358\u0359\7\u00b1\2\2\u0359\u035a\7\u00df\2\2\u035am\3\2\2"+
		"\2\u035b\u035c\7\u00b2\2\2\u035c\u035d\7\u00df\2\2\u035do\3\2\2\2\u035e"+
		"\u035f\t\3\2\2\u035fq\3\2\2\2\u0360\u0361\5t;\2\u0361s\3\2\2\2\u0362\u036c"+
		"\5x=\2\u0363\u036c\5|?\2\u0364\u036c\5~@\2\u0365\u036c\5\u0080A\2\u0366"+
		"\u036c\5\u0088E\2\u0367\u036c\5\u008aF\2\u0368\u036c\5\u008cG\2\u0369"+
		"\u036c\5\u008eH\2\u036a\u036c\5v<\2\u036b\u0362\3\2\2\2\u036b\u0363\3"+
		"\2\2\2\u036b\u0364\3\2\2\2\u036b\u0365\3\2\2\2\u036b\u0366\3\2\2\2\u036b"+
		"\u0367\3\2\2\2\u036b\u0368\3\2\2\2\u036b\u0369\3\2\2\2\u036b\u036a\3\2"+
		"\2\2\u036cu\3\2\2\2\u036d\u036e\7\u00bc\2\2\u036ew\3\2\2\2\u036f\u0371"+
		"\7B\2\2\u0370\u0372\5z>\2\u0371\u0370\3\2\2\2\u0371\u0372\3\2\2\2\u0372"+
		"\u0387\3\2\2\2\u0373\u0375\7\u00ad\2\2\u0374\u0376\5z>\2\u0375\u0374\3"+
		"\2\2\2\u0375\u0376\3\2\2\2\u0376\u0387\3\2\2\2\u0377\u0378\7B\2\2\u0378"+
		"\u037a\7\u0095\2\2\u0379\u037b\5z>\2\u037a\u0379\3\2\2\2\u037a\u037b\3"+
		"\2\2\2\u037b\u0387\3\2\2\2\u037c\u037d\7\u00ad\2\2\u037d\u037f\7\u0095"+
		"\2\2\u037e\u0380\5z>\2\u037f\u037e\3\2\2\2\u037f\u0380\3\2\2\2\u0380\u0387"+
		"\3\2\2\2\u0381\u0383\7\u00ae\2\2\u0382\u0384\5z>\2\u0383\u0382\3\2\2\2"+
		"\u0383\u0384\3\2\2\2\u0384\u0387\3\2\2\2\u0385\u0387\7\u00b7\2\2\u0386"+
		"\u036f\3\2\2\2\u0386\u0373\3\2\2\2\u0386\u0377\3\2\2\2\u0386\u037c\3\2"+
		"\2\2\u0386\u0381\3\2\2\2\u0386\u0385\3\2\2\2\u0387y\3\2\2\2\u0388\u0389"+
		"\7\u00cd\2\2\u0389\u038a\7\u00d9\2\2\u038a\u038b\7\u00ce\2\2\u038b{\3"+
		"\2\2\2\u038c\u038d\7s\2\2\u038d\u038f\7B\2\2\u038e\u0390\5z>\2\u038f\u038e"+
		"\3\2\2\2\u038f\u0390\3\2\2\2\u0390\u03b0\3\2\2\2\u0391\u0392\7s\2\2\u0392"+
		"\u0394\7\u00ad\2\2\u0393\u0395\5z>\2\u0394\u0393\3\2\2\2\u0394\u0395\3"+
		"\2\2\2\u0395\u03b0\3\2\2\2\u0396\u0398\7\u00af\2\2\u0397\u0399\5z>\2\u0398"+
		"\u0397\3\2\2\2\u0398\u0399\3\2\2\2\u0399\u03b0\3\2\2\2\u039a\u039b\7s"+
		"\2\2\u039b\u039c\7B\2\2\u039c\u039e\7\u0095\2\2\u039d\u039f\5z>\2\u039e"+
		"\u039d\3\2\2\2\u039e\u039f\3\2\2\2\u039f\u03b0\3\2\2\2\u03a0\u03a1\7s"+
		"\2\2\u03a1\u03a2\7\u00ad\2\2\u03a2\u03a4\7\u0095\2\2\u03a3\u03a5\5z>\2"+
		"\u03a4\u03a3\3\2\2\2\u03a4\u03a5\3\2\2\2\u03a5\u03b0\3\2\2\2\u03a6\u03a7"+
		"\7\u00af\2\2\u03a7\u03a9\7\u0095\2\2\u03a8\u03aa\5z>\2\u03a9\u03a8\3\2"+
		"\2\2\u03a9\u03aa\3\2\2\2\u03aa\u03b0\3\2\2\2\u03ab\u03ad\7\u00b0\2\2\u03ac"+
		"\u03ae\5z>\2\u03ad\u03ac\3\2\2\2\u03ad\u03ae\3\2\2\2\u03ae\u03b0\3\2\2"+
		"\2\u03af\u038c\3\2\2\2\u03af\u0391\3\2\2\2\u03af\u0396\3\2\2\2\u03af\u039a"+
		"\3\2\2\2\u03af\u03a0\3\2\2\2\u03af\u03a6\3\2\2\2\u03af\u03ab\3\2\2\2\u03b0"+
		"}\3\2\2\2\u03b1\u03b3\7\u00ba\2\2\u03b2\u03b4\5z>\2\u03b3\u03b2\3\2\2"+
		"\2\u03b3\u03b4\3\2\2\2\u03b4\u03ba\3\2\2\2\u03b5\u03b7\7\u00bb\2\2\u03b6"+
		"\u03b8\5z>\2\u03b7\u03b6\3\2\2\2\u03b7\u03b8\3\2\2\2\u03b8\u03ba\3\2\2"+
		"\2\u03b9\u03b1\3\2\2\2\u03b9\u03b5\3\2\2\2\u03ba\177\3\2\2\2\u03bb\u03be"+
		"\5\u0082B\2\u03bc\u03be\5\u0084C\2\u03bd\u03bb\3\2\2\2\u03bd\u03bc\3\2"+
		"\2\2\u03be\u0081\3\2\2\2\u03bf\u03c1\7\u00ab\2\2\u03c0\u03c2\5\u0086D"+
		"\2\u03c1\u03c0\3\2\2\2\u03c1\u03c2\3\2\2\2\u03c2\u03db\3\2\2\2\u03c3\u03c5"+
		"\7\u00ac\2\2\u03c4\u03c6\5\u0086D\2\u03c5\u03c4\3\2\2\2\u03c5\u03c6\3"+
		"\2\2\2\u03c6\u03db\3\2\2\2\u03c7\u03c9\7L\2\2\u03c8\u03ca\5\u0086D\2\u03c9"+
		"\u03c8\3\2\2\2\u03c9\u03ca\3\2\2\2\u03ca\u03db\3\2\2\2\u03cb\u03db\7\u009d"+
		"\2\2\u03cc\u03db\7\u00a1\2\2\u03cd\u03db\7\u009e\2\2\u03ce\u03db\7\u00a2"+
		"\2\2\u03cf\u03db\7\u009f\2\2\u03d0\u03d2\7\u00a3\2\2\u03d1\u03d3\5\u0086"+
		"D\2\u03d2\u03d1\3\2\2\2\u03d2\u03d3\3\2\2\2\u03d3\u03db\3\2\2\2\u03d4"+
		"\u03db\7\u00a4\2\2\u03d5\u03db\7\u00a0\2\2\u03d6\u03d8\7\u00a5\2\2\u03d7"+
		"\u03d9\5\u0086D\2\u03d8\u03d7\3\2\2\2\u03d8\u03d9\3\2\2\2\u03d9\u03db"+
		"\3\2\2\2\u03da\u03bf\3\2\2\2\u03da\u03c3\3\2\2\2\u03da\u03c7\3\2\2\2\u03da"+
		"\u03cb\3\2\2\2\u03da\u03cc\3\2\2\2\u03da\u03cd\3\2\2\2\u03da\u03ce\3\2"+
		"\2\2\u03da\u03cf\3\2\2\2\u03da\u03d0\3\2\2\2\u03da\u03d4\3\2\2\2\u03da"+
		"\u03d5\3\2\2\2\u03da\u03d6\3\2\2\2\u03db\u0083\3\2\2\2\u03dc\u03de\7\u00a9"+
		"\2\2\u03dd\u03df\5\u0086D\2\u03de\u03dd\3\2\2\2\u03de\u03df\3\2\2\2\u03df"+
		"\u03e7\3\2\2\2\u03e0\u03e7\7\u00a6\2\2\u03e1\u03e7\7\u00a8\2\2\u03e2\u03e7"+
		"\7\u00a7\2\2\u03e3\u03e7\7\u00aa\2\2\u03e4\u03e5\7\u00aa\2\2\u03e5\u03e7"+
		"\7x\2\2\u03e6\u03dc\3\2\2\2\u03e6\u03e0\3\2\2\2\u03e6\u03e1\3\2\2\2\u03e6"+
		"\u03e2\3\2\2\2\u03e6\u03e3\3\2\2\2\u03e6\u03e4\3\2\2\2\u03e7\u0085\3\2"+
		"\2\2\u03e8\u03e9\7\u00cd\2\2\u03e9\u03ea\7\u00d9\2\2\u03ea\u03f1\7\u00ce"+
		"\2\2\u03eb\u03ec\7\u00cd\2\2\u03ec\u03ed\7\u00d9\2\2\u03ed\u03ee\7\u00c6"+
		"\2\2\u03ee\u03ef\7\u00d9\2\2\u03ef\u03f1\7\u00ce\2\2\u03f0\u03e8\3\2\2"+
		"\2\u03f0\u03eb\3\2\2\2\u03f1\u0087\3\2\2\2\u03f2\u03f3\t\4\2\2\u03f3\u0089"+
		"\3\2\2\2\u03f4\u0403\7\u00b1\2\2\u03f5\u0403\7\u00b2\2\2\u03f6\u0403\7"+
		"\u00b3\2\2\u03f7\u03f8\7\u00b3\2\2\u03f8\u03f9\7:\2\2\u03f9\u03fa\7\u00b3"+
		"\2\2\u03fa\u0403\7\u0098\2\2\u03fb\u0403\7\u00b4\2\2\u03fc\u0403\7\u00b5"+
		"\2\2\u03fd\u03fe\7\u00b5\2\2\u03fe\u03ff\7:\2\2\u03ff\u0400\7\u00b3\2"+
		"\2\u0400\u0403\7\u0098\2\2\u0401\u0403\7\u00b6\2\2\u0402\u03f4\3\2\2\2"+
		"\u0402\u03f5\3\2\2\2\u0402\u03f6\3\2\2\2\u0402\u03f7\3\2\2\2\u0402\u03fb"+
		"\3\2\2\2\u0402\u03fc\3\2\2\2\u0402\u03fd\3\2\2\2\u0402\u0401\3\2\2\2\u0403"+
		"\u008b\3\2\2\2\u0404\u0406\7\u009b\2\2\u0405\u0407\5z>\2\u0406\u0405\3"+
		"\2\2\2\u0406\u0407\3\2\2\2\u0407\u0412\3\2\2\2\u0408\u040a\7\u009c\2\2"+
		"\u0409\u040b\5z>\2\u040a\u0409\3\2\2\2\u040a\u040b\3\2\2\2\u040b\u0412"+
		"\3\2\2\2\u040c\u040d\7\u009b\2\2\u040d\u040f\7\u0095\2\2\u040e\u0410\5"+
		"z>\2\u040f\u040e\3\2\2\2\u040f\u0410\3\2\2\2\u0410\u0412\3\2\2\2\u0411"+
		"\u0404\3\2\2\2\u0411\u0408\3\2\2\2\u0411\u040c\3\2\2\2\u0412\u008d\3\2"+
		"\2\2\u0413\u0415\7\u00b8\2\2\u0414\u0416\5z>\2\u0415\u0414\3\2\2\2\u0415"+
		"\u0416\3\2\2\2\u0416\u0421\3\2\2\2\u0417\u0418\7\u00b8\2\2\u0418\u041a"+
		"\7\u0095\2\2\u0419\u041b\5z>\2\u041a\u0419\3\2\2\2\u041a\u041b\3\2\2\2"+
		"\u041b\u0421\3\2\2\2\u041c\u041e\7\u00b9\2\2\u041d\u041f\5z>\2\u041e\u041d"+
		"\3\2\2\2\u041e\u041f\3\2\2\2\u041f\u0421\3\2\2\2\u0420\u0413\3\2\2\2\u0420"+
		"\u0417\3\2\2\2\u0420\u041c\3\2\2\2\u0421\u008f\3\2\2\2\u0422\u0425\5\u0092"+
		"J\2\u0423\u0425\5\u0094K\2\u0424\u0422\3\2\2\2\u0424\u0423\3\2\2\2\u0425"+
		"\u0091\3\2\2\2\u0426\u0427\7\u00cd\2\2\u0427\u0428\5\u00c0a\2\u0428\u0429"+
		"\7\u00ce\2\2\u0429\u0093\3\2\2\2\u042a\u0432\5\u0096L\2\u042b\u0432\5"+
		"\u016a\u00b6\2\u042c\u0432\5\u009cO\2\u042d\u0432\5\u0170\u00b9\2\u042e"+
		"\u0432\5\u00a8U\2\u042f\u0432\5\u00ba^\2\u0430\u0432\5\u01a8\u00d5\2\u0431"+
		"\u042a\3\2\2\2\u0431\u042b\3\2\2\2\u0431\u042c\3\2\2\2\u0431\u042d\3\2"+
		"\2\2\u0431\u042e\3\2\2\2\u0431\u042f\3\2\2\2\u0431\u0430\3\2\2\2\u0432"+
		"\u0095\3\2\2\2\u0433\u0434\5b\62\2\u0434\u0097\3\2\2\2\u0435\u0436\t\5"+
		"\2\2\u0436\u0099\3\2\2\2\u0437\u0439\5\u00ceh\2\u0438\u0437\3\2\2\2\u0438"+
		"\u0439\3\2\2\2\u0439\u043a\3\2\2\2\u043a\u043b\5\u0098M\2\u043b\u009b"+
		"\3\2\2\2\u043c\u043d\5\u009eP\2\u043d\u009d\3\2\2\2\u043e\u043f\7F\2\2"+
		"\u043f\u0440\7\u00cd\2\2\u0440\u0441\7\u00d1\2\2\u0441\u0447\7\u00ce\2"+
		"\2\u0442\u0444\5\u00a0Q\2\u0443\u0445\5\u00a4S\2\u0444\u0443\3\2\2\2\u0444"+
		"\u0445\3\2\2\2\u0445\u0447\3\2\2\2\u0446\u043e\3\2\2\2\u0446\u0442\3\2"+
		"\2\2\u0447\u009f\3\2\2\2\u0448\u0449\5\u00a2R\2\u0449\u044b\7\u00cd\2"+
		"\2\u044a\u044c\5\u0168\u00b5\2\u044b\u044a\3\2\2\2\u044b\u044c\3\2\2\2"+
		"\u044c\u044d\3\2\2\2\u044d\u044e\5\u00c0a\2\u044e\u044f\7\u00ce\2\2\u044f"+
		"\u00a1\3\2\2\2\u0450\u0451\t\6\2\2\u0451\u00a3\3\2\2\2\u0452\u0453\7X"+
		"\2\2\u0453\u0454\7\u00cd\2\2\u0454\u0455\79\2\2\u0455\u0456\5\u0130\u0099"+
		"\2\u0456\u0457\7\u00ce\2\2\u0457\u00a5\3\2\2\2\u0458\u0459\7]\2\2\u0459"+
		"\u045a\7\u00cd\2\2\u045a\u045b\5\u016e\u00b8\2\u045b\u045c\7\u00ce\2\2"+
		"\u045c\u00a7\3\2\2\2\u045d\u045e\5\u00acW\2\u045e\u00a9\3\2\2\2\u045f"+
		"\u0460\7t\2\2\u0460\u0461\7\u00cd\2\2\u0461\u0462\5\u00c4c\2\u0462\u0463"+
		"\7\u00c6\2\2\u0463\u0464\5\u00eav\2\u0464\u0465\7\u00ce\2\2\u0465\u0472"+
		"\3\2\2\2\u0466\u0467\7D\2\2\u0467\u0468\7\u00cd\2\2\u0468\u046b\5\u00c4"+
		"c\2\u0469\u046a\7\u00c6\2\2\u046a\u046c\5\u00eav\2\u046b\u0469\3\2\2\2"+
		"\u046c\u046d\3\2\2\2\u046d\u046b\3\2\2\2\u046d\u046e\3\2\2\2\u046e\u046f"+
		"\3\2\2\2\u046f\u0470\7\u00ce\2\2\u0470\u0472\3\2\2\2\u0471\u045f\3\2\2"+
		"\2\u0471\u0466\3\2\2\2\u0472\u00ab\3\2\2\2\u0473\u0476\5\u00aeX\2\u0474"+
		"\u0476\5\u00b0Y\2\u0475\u0473\3\2\2\2\u0475\u0474\3\2\2\2\u0476\u00ad"+
		"\3\2\2\2\u0477\u0478\7\n\2\2\u0478\u047a\5\u00eav\2\u0479\u047b\5\u00b2"+
		"Z\2\u047a\u0479\3\2\2\2\u047b\u047c\3\2\2\2\u047c\u047a\3\2\2\2\u047c"+
		"\u047d\3\2\2\2\u047d\u047f\3\2\2\2\u047e\u0480\5\u00b6\\\2\u047f\u047e"+
		"\3\2\2\2\u047f\u0480\3\2\2\2\u0480\u0481\3\2\2\2\u0481\u0482\7\21\2\2"+
		"\u0482\u00af\3\2\2\2\u0483\u0485\7\n\2\2\u0484\u0486\5\u00b4[\2\u0485"+
		"\u0484\3\2\2\2\u0486\u0487\3\2\2\2\u0487\u0485\3\2\2\2\u0487\u0488\3\2"+
		"\2\2\u0488\u048a\3\2\2\2\u0489\u048b\5\u00b6\\\2\u048a\u0489\3\2\2\2\u048a"+
		"\u048b\3\2\2\2\u048b\u048c\3\2\2\2\u048c\u048d\7\21\2\2\u048d\u00b1\3"+
		"\2\2\2\u048e\u048f\78\2\2\u048f\u0490\5\u0130\u0099\2\u0490\u0491\7\60"+
		"\2\2\u0491\u0492\5\u00b8]\2\u0492\u00b3\3\2\2\2\u0493\u0494\78\2\2\u0494"+
		"\u0495\5\u0130\u0099\2\u0495\u0496\7\60\2\2\u0496\u0497\5\u00b8]\2\u0497"+
		"\u00b5\3\2\2\2\u0498\u0499\7\22\2\2\u0499\u049a\5\u00b8]\2\u049a\u00b7"+
		"\3\2\2\2\u049b\u049e\5\u00c0a\2\u049c\u049e\7&\2\2\u049d\u049b\3\2\2\2"+
		"\u049d\u049c\3\2\2\2\u049e\u00b9\3\2\2\2\u049f\u04a0\7\13\2\2\u04a0\u04a1"+
		"\7\u00cd\2\2\u04a1\u04a2\5\u00bc_\2\u04a2\u04a3\7\3\2\2\u04a3\u04a4\5"+
		"\u00be`\2\u04a4\u04a5\7\u00ce\2\2\u04a5\u00bb\3\2\2\2\u04a6\u04a7\5\u00c0"+
		"a\2\u04a7\u00bd\3\2\2\2\u04a8\u04a9\5r:\2\u04a9\u00bf\3\2\2\2\u04aa\u04ae"+
		"\5\u00c2b\2\u04ab\u04ae\5\u00fe\u0080\2\u04ac\u04ae\5\u00eav\2\u04ad\u04aa"+
		"\3\2\2\2\u04ad\u04ab\3\2\2\2\u04ad\u04ac\3\2\2\2\u04ae\u00c1\3\2\2\2\u04af"+
		"\u04b3\5\u00c4c\2\u04b0\u04b3\5\u00dan\2\u04b1\u04b3\7&\2\2\u04b2\u04af"+
		"\3\2\2\2\u04b2\u04b0\3\2\2\2\u04b2\u04b1\3\2\2\2\u04b3\u00c3\3\2\2\2\u04b4"+
		"\u04b9\5\u00c6d\2\u04b5\u04b6\t\7\2\2\u04b6\u04b8\5\u00c6d\2\u04b7\u04b5"+
		"\3\2\2\2\u04b8\u04bb\3\2\2\2\u04b9\u04b7\3\2\2\2\u04b9\u04ba\3\2\2\2\u04ba"+
		"\u00c5\3\2\2\2\u04bb\u04b9\3\2\2\2\u04bc\u04c1\5\u00c8e\2\u04bd\u04be"+
		"\t\b\2\2\u04be\u04c0\5\u00c8e\2\u04bf\u04bd\3\2\2\2\u04c0\u04c3\3\2\2"+
		"\2\u04c1\u04bf\3\2\2\2\u04c1\u04c2\3\2\2\2\u04c2\u00c7\3\2\2\2\u04c3\u04c1"+
		"\3\2\2\2\u04c4\u04c6\5\u00ceh\2\u04c5\u04c4\3\2\2\2\u04c5\u04c6\3\2\2"+
		"\2\u04c6\u04c7\3\2\2\2\u04c7\u04c8\5\u00ccg\2\u04c8\u00c9\3\2\2\2\u04c9"+
		"\u04ca\7\u00cd\2\2\u04ca\u04cf\5\u00c4c\2\u04cb\u04cc\7\u00c6\2\2\u04cc"+
		"\u04ce\5\u00c4c\2\u04cd\u04cb\3\2\2\2\u04ce\u04d1\3\2\2\2\u04cf\u04cd"+
		"\3\2\2\2\u04cf\u04d0\3\2\2\2\u04d0\u04d2\3\2\2\2\u04d1\u04cf\3\2\2\2\u04d2"+
		"\u04d3\7\u00ce\2\2\u04d3\u00cb\3\2\2\2\u04d4\u04d9\5\u0090I\2\u04d5\u04d6"+
		"\7\u00c1\2\2\u04d6\u04d8\5\u00be`\2\u04d7\u04d5\3\2\2\2\u04d8\u04db\3"+
		"\2\2\2\u04d9\u04d7\3\2\2\2\u04d9\u04da\3\2\2\2\u04da\u04de\3\2\2\2\u04db"+
		"\u04d9\3\2\2\2\u04dc\u04de\5\u00d0i\2\u04dd\u04d4\3\2\2\2\u04dd\u04dc"+
		"\3\2\2\2\u04de\u00cd\3\2\2\2\u04df\u04e0\t\7\2\2\u04e0\u00cf\3\2\2\2\u04e1"+
		"\u04e2\5\u00d2j\2\u04e2\u00d1\3\2\2\2\u04e3\u04e4\7W\2\2\u04e4\u04e5\7"+
		"\u00cd\2\2\u04e5\u04e6\5\u00d4k\2\u04e6\u04e7\7\26\2\2\u04e7\u04e8\5\u00d8"+
		"m\2\u04e8\u04e9\7\u00ce\2\2\u04e9\u00d3\3\2\2\2\u04ea\u04ee\5\u01a2\u00d2"+
		"\2\u04eb\u04ee\5\u00d6l\2\u04ec\u04ee\5\u01a6\u00d4\2\u04ed\u04ea\3\2"+
		"\2\2\u04ed\u04eb\3\2\2\2\u04ed\u04ec\3\2\2\2\u04ee\u00d5\3\2\2\2\u04ef"+
		"\u04f0\t\t\2\2\u04f0\u00d7\3\2\2\2\u04f1\u04f4\5\u016a\u00b6\2\u04f2\u04f4"+
		"\5f\64\2\u04f3\u04f1\3\2\2\2\u04f3\u04f2\3\2\2\2\u04f4\u00d9\3\2\2\2\u04f5"+
		"\u04f6\5\u00dco\2\u04f6\u00db\3\2\2\2\u04f7\u04fc\5\u00dep\2\u04f8\u04f9"+
		"\7\u00c7\2\2\u04f9\u04fb\5\u00dep\2\u04fa\u04f8\3\2\2\2\u04fb\u04fe\3"+
		"\2\2\2\u04fc\u04fa\3\2\2\2\u04fc\u04fd\3\2\2\2\u04fd\u00dd\3\2\2\2\u04fe"+
		"\u04fc\3\2\2\2\u04ff\u0500\5\u00e0q\2\u0500\u00df\3\2\2\2\u0501\u0504"+
		"\5\u0090I\2\u0502\u0504\5\u00e2r\2\u0503\u0501\3\2\2\2\u0503\u0502\3\2"+
		"\2\2\u0504\u00e1\3\2\2\2\u0505\u0506\5\u00e4s\2\u0506\u00e3\3\2\2\2\u0507"+
		"\u0508\7\u008f\2\2\u0508\u0509\7\u00cd\2\2\u0509\u050a\5\u00e6t\2\u050a"+
		"\u050b\7\u00ce\2\2\u050b\u00e5\3\2\2\2\u050c\u050e\5\u00e8u\2\u050d\u050c"+
		"\3\2\2\2\u050d\u050e\3\2\2\2\u050e\u0510\3\2\2\2\u050f\u0511\5\u00dco"+
		"\2\u0510\u050f\3\2\2\2\u0510\u0511\3\2\2\2\u0511\u0512\3\2\2\2\u0512\u0514"+
		"\7\26\2\2\u0513\u050d\3\2\2\2\u0513\u0514\3\2\2\2\u0514\u0515\3\2\2\2"+
		"\u0515\u051b\5\u00dco\2\u0516\u0517\5\u00dco\2\u0517\u0518\7\u00c6\2\2"+
		"\u0518\u0519\5\u00dco\2\u0519\u051b\3\2\2\2\u051a\u0513\3\2\2\2\u051a"+
		"\u0516\3\2\2\2\u051b\u00e7\3\2\2\2\u051c\u051d\t\n\2\2\u051d\u00e9\3\2"+
		"\2\2\u051e\u051f\5\u00ecw\2\u051f\u00eb\3\2\2\2\u0520\u0525\5\u00eex\2"+
		"\u0521\u0522\7)\2\2\u0522\u0524\5\u00ecw\2\u0523\u0521\3\2\2\2\u0524\u0527"+
		"\3\2\2\2\u0525\u0523\3\2\2\2\u0525\u0526\3\2\2\2\u0526\u00ed\3\2\2\2\u0527"+
		"\u0525\3\2\2\2\u0528\u052d\5\u00f0y\2\u0529\u052a\7\5\2\2\u052a\u052c"+
		"\5\u00eex\2\u052b\u0529\3\2\2\2\u052c\u052f\3\2\2\2\u052d\u052b\3\2\2"+
		"\2\u052d\u052e\3\2\2\2\u052e\u00ef\3\2\2\2\u052f\u052d\3\2\2\2\u0530\u0534"+
		"\5\u00f2z\2\u0531\u0532\7%\2\2\u0532\u0534\5\u00f2z\2\u0533\u0530\3\2"+
		"\2\2\u0533\u0531\3\2\2\2\u0534\u00f1\3\2\2\2\u0535\u0537\5\u00f8}\2\u0536"+
		"\u0538\5\u00f4{\2\u0537\u0536\3\2\2\2\u0537\u0538\3\2\2\2\u0538\u00f3"+
		"\3\2\2\2\u0539\u053b\7\36\2\2\u053a\u053c\7%\2\2\u053b\u053a\3\2\2\2\u053b"+
		"\u053c\3\2\2\2\u053c\u053d\3\2\2\2\u053d\u053e\5\u00f6|\2\u053e\u00f5"+
		"\3\2\2\2\u053f\u0540\t\3\2\2\u0540\u00f7\3\2\2\2\u0541\u0544\5\u0178\u00bd"+
		"\2\u0542\u0544\5\u00fa~\2\u0543\u0541\3\2\2\2\u0543\u0542\3\2\2\2\u0544"+
		"\u00f9\3\2\2\2\u0545\u0548\5\u00fc\177\2\u0546\u0548\5\u0094K\2\u0547"+
		"\u0545\3\2\2\2\u0547\u0546\3\2\2\2\u0548\u00fb\3\2\2\2\u0549\u054a\7\u00cd"+
		"\2\2\u054a\u054b\5\u00eav\2\u054b\u054c\7\u00ce\2\2\u054c\u00fd\3\2\2"+
		"\2\u054d\u0550\5\u0100\u0081\2\u054e\u0550\5\u0102\u0082\2\u054f\u054d"+
		"\3\2\2\2\u054f\u054e\3\2\2\2\u0550\u00ff\3\2\2\2\u0551\u0552\5\u0094K"+
		"\2\u0552\u0101\3\2\2\2\u0553\u0554\7&\2\2\u0554\u0103\3\2\2\2\u0555\u0559"+
		"\5\u0100\u0081\2\u0556\u0559\5\u0106\u0084\2\u0557\u0559\5\u0176\u00bc"+
		"\2\u0558\u0555\3\2\2\2\u0558\u0556\3\2\2\2\u0558\u0557\3\2\2\2\u0559\u0105"+
		"\3\2\2\2\u055a\u055d\5\u00c2b\2\u055b\u055d\5\u00fa~\2\u055c\u055a\3\2"+
		"\2\2\u055c\u055b\3\2\2\2\u055d\u0107\3\2\2\2\u055e\u0560\5\u010a\u0086"+
		"\2\u055f\u0561\5\u012e\u0098\2\u0560\u055f\3\2\2\2\u0560\u0561\3\2\2\2"+
		"\u0561\u0563\3\2\2\2\u0562\u0564\5\u0132\u009a\2\u0563\u0562\3\2\2\2\u0563"+
		"\u0564\3\2\2\2\u0564\u0566\3\2\2\2\u0565\u0567\5\u0142\u00a2\2\u0566\u0565"+
		"\3\2\2\2\u0566\u0567\3\2\2\2\u0567\u0569\3\2\2\2\u0568\u056a\5\u01b0\u00d9"+
		"\2\u0569\u0568\3\2\2\2\u0569\u056a\3\2\2\2\u056a\u056c\3\2\2\2\u056b\u056d"+
		"\5\u01b8\u00dd\2\u056c\u056b\3\2\2\2\u056c\u056d\3\2\2\2\u056d\u0109\3"+
		"\2\2\2\u056e\u056f\7\26\2\2\u056f\u0570\5\u010c\u0087\2\u0570\u010b\3"+
		"\2\2\2\u0571\u0576\5\u010e\u0088\2\u0572\u0573\7\u00c6\2\2\u0573\u0575"+
		"\5\u010e\u0088\2\u0574\u0572\3\2\2\2\u0575\u0578\3\2\2\2\u0576\u0574\3"+
		"\2\2\2\u0576\u0577\3\2\2\2\u0577\u010d\3\2\2\2\u0578\u0576\3\2\2\2\u0579"+
		"\u057c\5\u0110\u0089\2\u057a\u057c\5\u0128\u0095\2\u057b\u0579\3\2\2\2"+
		"\u057b\u057a\3\2\2\2\u057c\u010f\3\2\2\2\u057d\u057f\5\u0128\u0095\2\u057e"+
		"\u0580\5\u0112\u008a\2\u057f\u057e\3\2\2\2\u0580\u0581\3\2\2\2\u0581\u057f"+
		"\3\2\2\2\u0581\u0582\3\2\2\2\u0582\u0111\3\2\2\2\u0583\u0584\7\r\2\2\u0584"+
		"\u0585\7\37\2\2\u0585\u0597\5\u0128\u0095\2\u0586\u0588\5\u011c\u008f"+
		"\2\u0587\u0586\3\2\2\2\u0587\u0588\3\2\2\2\u0588\u0589\3\2\2\2\u0589\u058a"+
		"\7\37\2\2\u058a\u058b\5\u0128\u0095\2\u058b\u058c\5\u0122\u0092\2\u058c"+
		"\u0597\3\2\2\2\u058d\u058f\7$\2\2\u058e\u0590\5\u011c\u008f\2\u058f\u058e"+
		"\3\2\2\2\u058f\u0590\3\2\2\2\u0590\u0591\3\2\2\2\u0591\u0592\7\37\2\2"+
		"\u0592\u0597\5\u0128\u0095\2\u0593\u0594\7\63\2\2\u0594\u0595\7\37\2\2"+
		"\u0595\u0597\5\u0128\u0095\2\u0596\u0583\3\2\2\2\u0596\u0587\3\2\2\2\u0596"+
		"\u058d\3\2\2\2\u0596\u0593\3\2\2\2\u0597\u0113\3\2\2\2\u0598\u0599\7\r"+
		"\2\2\u0599\u059a\7\37\2\2\u059a\u059b\5\u0128\u0095\2\u059b\u0115\3\2"+
		"\2\2\u059c\u059e\5\u011c\u008f\2\u059d\u059c\3\2\2\2\u059d\u059e\3\2\2"+
		"\2\u059e\u059f\3\2\2\2\u059f\u05a0\7\37\2\2\u05a0\u05a1\5\u0128\u0095"+
		"\2\u05a1\u05a2\5\u0122\u0092\2\u05a2\u0117\3\2\2\2\u05a3\u05a5\7$\2\2"+
		"\u05a4\u05a6\5\u011c\u008f\2\u05a5\u05a4\3\2\2\2\u05a5\u05a6\3\2\2\2\u05a6"+
		"\u05a7\3\2\2\2\u05a7\u05a8\7\37\2\2\u05a8\u05a9\5\u0128\u0095\2\u05a9"+
		"\u0119\3\2\2\2\u05aa\u05ab\7\63\2\2\u05ab\u05ac\7\37\2\2\u05ac\u05ad\5"+
		"\u0128\u0095\2\u05ad\u011b\3\2\2\2\u05ae\u05b1\7\33\2\2\u05af\u05b1\5"+
		"\u011e\u0090\2\u05b0\u05ae\3\2\2\2\u05b0\u05af\3\2\2\2\u05b1\u011d\3\2"+
		"\2\2\u05b2\u05b4\5\u0120\u0091\2\u05b3\u05b5\7(\2\2\u05b4\u05b3\3\2\2"+
		"\2\u05b4\u05b5\3\2\2\2\u05b5\u011f\3\2\2\2\u05b6\u05b7\t\13\2\2\u05b7"+
		"\u0121\3\2\2\2\u05b8\u05bb\5\u0124\u0093\2\u05b9\u05bb\5\u0126\u0094\2"+
		"\u05ba\u05b8\3\2\2\2\u05ba\u05b9\3\2\2\2\u05bb\u0123\3\2\2\2\u05bc\u05bd"+
		"\7\'\2\2\u05bd\u05be\5\u0130\u0099\2\u05be\u0125\3\2\2\2\u05bf\u05c0\7"+
		"\66\2\2\u05c0\u05c1\7\u00cd\2\2\u05c1\u05c2\5\u016e\u00b8\2\u05c2\u05c3"+
		"\7\u00ce\2\2\u05c3\u0127\3\2\2\2\u05c4\u05c9\5\u0158\u00ad\2\u05c5\u05c7"+
		"\7\3\2\2\u05c6\u05c5\3\2\2\2\u05c6\u05c7\3\2\2\2\u05c7\u05c8\3\2\2\2\u05c8"+
		"\u05ca\5^\60\2\u05c9\u05c6\3\2\2\2\u05c9\u05ca\3\2\2\2\u05ca\u05cf\3\2"+
		"\2\2\u05cb\u05cc\7\u00cd\2\2\u05cc\u05cd\5\u012a\u0096\2\u05cd\u05ce\7"+
		"\u00ce\2\2\u05ce\u05d0\3\2\2\2\u05cf\u05cb\3\2\2\2\u05cf\u05d0\3\2\2\2"+
		"\u05d0\u05dd\3\2\2\2\u05d1\u05d3\5\u012c\u0097\2\u05d2\u05d4\7\3\2\2\u05d3"+
		"\u05d2\3\2\2\2\u05d3\u05d4\3\2\2\2\u05d4\u05d5\3\2\2\2\u05d5\u05da\5^"+
		"\60\2\u05d6\u05d7\7\u00cd\2\2\u05d7\u05d8\5\u012a\u0096\2\u05d8\u05d9"+
		"\7\u00ce\2\2\u05d9\u05db\3\2\2\2\u05da\u05d6\3\2\2\2\u05da\u05db\3\2\2"+
		"\2\u05db\u05dd\3\2\2\2\u05dc\u05c4\3\2\2\2\u05dc\u05d1\3\2\2\2\u05dd\u0129"+
		"\3\2\2\2\u05de\u05e3\5^\60\2\u05df\u05e0\7\u00c6\2\2\u05e0\u05e2\5^\60"+
		"\2\u05e1\u05df\3\2\2\2\u05e2\u05e5\3\2\2\2\u05e3\u05e1\3\2\2\2\u05e3\u05e4"+
		"\3\2\2\2\u05e4\u012b\3\2\2\2\u05e5\u05e3\3\2\2\2\u05e6\u05e7\5\u0174\u00bb"+
		"\2\u05e7\u012d\3\2\2\2\u05e8\u05e9\79\2\2\u05e9\u05ea\5\u0130\u0099\2"+
		"\u05ea\u012f\3\2\2\2\u05eb\u05ec\5\u00c0a\2\u05ec\u0131\3\2\2\2\u05ed"+
		"\u05ee\7\27\2\2\u05ee\u05ef\7@\2\2\u05ef\u05f0\5\u0134\u009b\2\u05f0\u0133"+
		"\3\2\2\2\u05f1\u05f6\5\u0136\u009c\2\u05f2\u05f3\7\u00c6\2\2\u05f3\u05f5"+
		"\5\u0136\u009c\2\u05f4\u05f2\3\2\2\2\u05f5\u05f8\3\2\2\2\u05f6\u05f4\3"+
		"\2\2\2\u05f6\u05f7\3\2\2\2\u05f7\u0135\3\2\2\2\u05f8\u05f6\3\2\2\2\u05f9"+
		"\u05fe\5\u013c\u009f\2\u05fa\u05fe\5\u013e\u00a0\2\u05fb\u05fe\5\u0140"+
		"\u00a1\2\u05fc\u05fe\5\u0138\u009d\2\u05fd\u05f9\3\2\2\2\u05fd\u05fa\3"+
		"\2\2\2\u05fd\u05fb\3\2\2\2\u05fd\u05fc\3\2\2\2\u05fe\u0137\3\2\2\2\u05ff"+
		"\u0605\5\u0104\u0083\2\u0600\u0601\7\u00cd\2\2\u0601\u0602\5\u0144\u00a3"+
		"\2\u0602\u0603\7\u00ce\2\2\u0603\u0605\3\2\2\2\u0604\u05ff\3\2\2\2\u0604"+
		"\u0600\3\2\2\2\u0605\u0139\3\2\2\2\u0606\u060b\5\u0138\u009d\2\u0607\u0608"+
		"\7\u00c6\2\2\u0608\u060a\5\u0138\u009d\2\u0609\u0607\3\2\2\2\u060a\u060d"+
		"\3\2\2\2\u060b\u0609\3\2\2\2\u060b\u060c\3\2\2\2\u060c\u013b\3\2\2\2\u060d"+
		"\u060b\3\2\2\2\u060e\u060f\7\177\2\2\u060f\u0610\7\u00cd\2\2\u0610\u0611"+
		"\5\u013a\u009e\2\u0611\u0612\7\u00ce\2\2\u0612\u013d\3\2\2\2\u0613\u0614"+
		"\7G\2\2\u0614\u0615\7\u00cd\2\2\u0615\u0616\5\u013a\u009e\2\u0616\u0617"+
		"\7\u00ce\2\2\u0617\u013f\3\2\2\2\u0618\u0619\7\u00cd\2\2\u0619\u061a\7"+
		"\u00ce\2\2\u061a\u0141\3\2\2\2\u061b\u061c\7\30\2\2\u061c\u061d\5\u00ea"+
		"v\2\u061d\u0143\3\2\2\2\u061e\u0623\5\u0104\u0083\2\u061f\u0620\7\u00c6"+
		"\2\2\u0620\u0622\5\u0104\u0083\2\u0621\u061f\3\2\2\2\u0622\u0625\3\2\2"+
		"\2\u0623\u0621\3\2\2\2\u0623\u0624\3\2\2\2\u0624\u0145\3\2\2\2\u0625\u0623"+
		"\3\2\2\2\u0626\u0627\5\u0148\u00a5\2\u0627\u0147\3\2\2\2\u0628\u062b\5"+
		"\u014a\u00a6\2\u0629\u062b\5\u0110\u0089\2\u062a\u0628\3\2\2\2\u062a\u0629"+
		"\3\2\2\2\u062b\u0149\3\2\2\2\u062c\u0635\5\u014e\u00a8\2\u062d\u062e\5"+
		"\u0110\u0089\2\u062e\u0630\t\f\2\2\u062f\u0631\t\r\2\2\u0630\u062f\3\2"+
		"\2\2\u0630\u0631\3\2\2\2\u0631\u0632\3\2\2\2\u0632\u0633\5\u014c\u00a7"+
		"\2\u0633\u0635\3\2\2\2\u0634\u062c\3\2\2\2\u0634\u062d\3\2\2\2\u0635\u063d"+
		"\3\2\2\2\u0636\u0638\t\f\2\2\u0637\u0639\t\r\2\2\u0638\u0637\3\2\2\2\u0638"+
		"\u0639\3\2\2\2\u0639\u063a\3\2\2\2\u063a\u063c\5\u014c\u00a7\2\u063b\u0636"+
		"\3\2\2\2\u063c\u063f\3\2\2\2\u063d\u063b\3\2\2\2\u063d\u063e\3\2\2\2\u063e"+
		"\u014b\3\2\2\2\u063f\u063d\3\2\2\2\u0640\u0643\5\u014e\u00a8\2\u0641\u0643"+
		"\5\u0110\u0089\2\u0642\u0640\3\2\2\2\u0642\u0641\3\2\2\2\u0643\u014d\3"+
		"\2\2\2\u0644\u064d\5\u0152\u00aa\2\u0645\u0646\5\u0110\u0089\2\u0646\u0648"+
		"\7\34\2\2\u0647\u0649\t\r\2\2\u0648\u0647\3\2\2\2\u0648\u0649\3\2\2\2"+
		"\u0649\u064a\3\2\2\2\u064a\u064b\5\u0150\u00a9\2\u064b\u064d\3\2\2\2\u064c"+
		"\u0644\3\2\2\2\u064c\u0645\3\2\2\2\u064d\u0655\3\2\2\2\u064e\u0650\7\34"+
		"\2\2\u064f\u0651\t\r\2\2\u0650\u064f\3\2\2\2\u0650\u0651\3\2\2\2\u0651"+
		"\u0652\3\2\2\2\u0652\u0654\5\u0150\u00a9\2\u0653\u064e\3\2\2\2\u0654\u0657"+
		"\3\2\2\2\u0655\u0653\3\2\2\2\u0655\u0656\3\2\2\2\u0656\u014f\3\2\2\2\u0657"+
		"\u0655\3\2\2\2\u0658\u065b\5\u0152\u00aa\2\u0659\u065b\5\u0110\u0089\2"+
		"\u065a\u0658\3\2\2\2\u065a\u0659\3\2\2\2\u065b\u0151\3\2\2\2\u065c\u0662"+
		"\5\u0154\u00ab\2\u065d\u065e\7\u00cd\2\2\u065e\u065f\5\u014a\u00a6\2\u065f"+
		"\u0660\7\u00ce\2\2\u0660\u0662\3\2\2\2\u0661\u065c\3\2\2\2\u0661\u065d"+
		"\3\2\2\2\u0662\u0153\3\2\2\2\u0663\u0666\5\u015e\u00b0\2\u0664\u0666\5"+
		"\u0156\u00ac\2\u0665\u0663\3\2\2\2\u0665\u0664\3\2\2\2\u0666\u0155\3\2"+
		"\2\2\u0667\u0668\7/\2\2\u0668\u0669\5\u0158\u00ad\2\u0669\u0157\3\2\2"+
		"\2\u066a\u066d\5\u015a\u00ae\2\u066b\u066d\5^\60\2\u066c\u066a\3\2\2\2"+
		"\u066c\u066b\3\2\2\2\u066d\u0159\3\2\2\2\u066e\u0675\5^\60\2\u066f\u0670"+
		"\7\u00d4\2\2\u0670\u0673\5^\60\2\u0671\u0672\7\u00d4\2\2\u0672\u0674\5"+
		"^\60\2\u0673\u0671\3\2\2\2\u0673\u0674\3\2\2\2\u0674\u0676\3\2\2\2\u0675"+
		"\u066f\3\2\2\2\u0675\u0676\3\2\2\2\u0676\u015b\3\2\2\2\u0677\u0678\5^"+
		"\60\2\u0678\u015d\3\2\2\2\u0679\u067b\7,\2\2\u067a\u067c\5\u0168\u00b5"+
		"\2\u067b\u067a\3\2\2\2\u067b\u067c\3\2\2\2\u067c\u067d\3\2\2\2\u067d\u067f"+
		"\5\u0160\u00b1\2\u067e\u0680\5\u0108\u0085\2\u067f\u067e\3\2\2\2\u067f"+
		"\u0680\3\2\2\2\u0680\u015f\3\2\2\2\u0681\u0686\5\u0162\u00b2\2\u0682\u0683"+
		"\7\u00c6\2\2\u0683\u0685\5\u0162\u00b2\2\u0684\u0682\3\2\2\2\u0685\u0688"+
		"\3\2\2\2\u0686\u0684\3\2\2\2\u0686\u0687\3\2\2\2\u0687\u0161\3\2\2\2\u0688"+
		"\u0686\3\2\2\2\u0689\u068c\5\u0164\u00b3\2\u068a\u068c\5\u0166\u00b4\2"+
		"\u068b\u0689\3\2\2\2\u068b\u068a\3\2\2\2\u068c\u0163\3\2\2\2\u068d\u068f"+
		"\5\u00c0a\2\u068e\u0690\5\u016c\u00b7\2\u068f\u068e\3\2\2\2\u068f\u0690"+
		"\3\2\2\2\u0690\u0165\3\2\2\2\u0691\u0692\5^\60\2\u0692\u0693\7\u00d4\2"+
		"\2\u0693\u0695\3\2\2\2\u0694\u0691\3\2\2\2\u0694\u0695\3\2\2\2\u0695\u0696"+
		"\3\2\2\2\u0696\u0697\7\u00d1\2\2\u0697\u0167\3\2\2\2\u0698\u0699\t\r\2"+
		"\2\u0699\u0169\3\2\2\2\u069a\u069b\5^\60\2\u069b\u069c\7\u00d4\2\2\u069c"+
		"\u069e\3\2\2\2\u069d\u069a\3\2\2\2\u069d\u069e\3\2\2\2\u069e\u069f\3\2"+
		"\2\2\u069f\u06a0\5^\60\2\u06a0\u06a1\7\u00d4\2\2\u06a1\u06a3\3\2\2\2\u06a2"+
		"\u069d\3\2\2\2\u06a2\u06a3\3\2\2\2\u06a3\u06a4\3\2\2\2\u06a4\u06a5\5^"+
		"\60\2\u06a5\u016b\3\2\2\2\u06a6\u06a8\7\3\2\2\u06a7\u06a6\3\2\2\2\u06a7"+
		"\u06a8\3\2\2\2\u06a8\u06a9\3\2\2\2\u06a9\u06aa\5^\60\2\u06aa\u016d\3\2"+
		"\2\2\u06ab\u06b0\5\u016a\u00b6\2\u06ac\u06ad\7\u00c6\2\2\u06ad\u06af\5"+
		"\u016a\u00b6\2\u06ae\u06ac\3\2\2\2\u06af\u06b2\3\2\2\2\u06b0\u06ae\3\2"+
		"\2\2\u06b0\u06b1\3\2\2\2\u06b1\u016f\3\2\2\2\u06b2\u06b0\3\2\2\2\u06b3"+
		"\u06b4\5\u0176\u00bc\2\u06b4\u0171\3\2\2\2\u06b5\u06b6\5\u0176\u00bc\2"+
		"\u06b6\u0173\3\2\2\2\u06b7\u06b8\5\u0176\u00bc\2\u06b8\u0175\3\2\2\2\u06b9"+
		"\u06ba\7\u00cd\2\2\u06ba\u06bb\5\u0146\u00a4\2\u06bb\u06bc\7\u00ce\2\2"+
		"\u06bc\u0177\3\2\2\2\u06bd\u06c4\5\u017a\u00be\2\u06be\u06c4\5\u0182\u00c2"+
		"\2\u06bf\u06c4\5\u0186\u00c4\2\u06c0\u06c4\5\u018c\u00c7\2\u06c1\u06c4"+
		"\5\u0194\u00cb\2\u06c2\u06c4\5\u019e\u00d0\2\u06c3\u06bd\3\2\2\2\u06c3"+
		"\u06be\3\2\2\2\u06c3\u06bf\3\2\2\2\u06c3\u06c0\3\2\2\2\u06c3\u06c1\3\2"+
		"\2\2\u06c3\u06c2\3\2\2\2\u06c4\u0179\3\2\2\2\u06c5\u06c6\5\u0104\u0083"+
		"\2\u06c6\u06c7\5\u017e\u00c0\2\u06c7\u06c8\5\u0104\u0083\2\u06c8\u017b"+
		"\3\2\2\2\u06c9\u06ca\5\u0104\u0083\2\u06ca\u06cb\5\u0180\u00c1\2\u06cb"+
		"\u06cc\5\u0104\u0083\2\u06cc\u017d\3\2\2\2\u06cd\u06ce\t\16\2\2\u06ce"+
		"\u017f\3\2\2\2\u06cf\u06d0\7\u00c3\2\2\u06d0\u0181\3\2\2\2\u06d1\u06d2"+
		"\5\u0104\u0083\2\u06d2\u06d3\5\u0184\u00c3\2\u06d3\u0183\3\2\2\2\u06d4"+
		"\u06d6\7%\2\2\u06d5\u06d4\3\2\2\2\u06d5\u06d6\3\2\2\2\u06d6\u06d7\3\2"+
		"\2\2\u06d7\u06d9\7?\2\2\u06d8\u06da\t\17\2\2\u06d9\u06d8\3\2\2\2\u06d9"+
		"\u06da\3\2\2\2\u06da\u06db\3\2\2\2\u06db\u06dc\5\u0104\u0083\2\u06dc\u06dd"+
		"\7\5\2\2\u06dd\u06de\5\u0104\u0083\2\u06de\u0185\3\2\2\2\u06df\u06e1\5"+
		"\u00c4c\2\u06e0\u06e2\7%\2\2\u06e1\u06e0\3\2\2\2\u06e1\u06e2\3\2\2\2\u06e2"+
		"\u06e3\3\2\2\2\u06e3\u06e4\7\32\2\2\u06e4\u06e5\5\u0188\u00c5\2\u06e5"+
		"\u0187\3\2\2\2\u06e6\u06ec\5\u0174\u00bb\2\u06e7\u06e8\7\u00cd\2\2\u06e8"+
		"\u06e9\5\u018a\u00c6\2\u06e9\u06ea\7\u00ce\2\2\u06ea\u06ec\3\2\2\2\u06eb"+
		"\u06e6\3\2\2\2\u06eb\u06e7\3\2\2\2\u06ec\u0189\3\2\2\2\u06ed\u06f2\5\u0104"+
		"\u0083\2\u06ee\u06ef\7\u00c6\2\2\u06ef\u06f1\5\u0104\u0083\2\u06f0\u06ee"+
		"\3\2\2\2\u06f1\u06f4\3\2\2\2\u06f2\u06f0\3\2\2\2\u06f2\u06f3\3\2\2\2\u06f3"+
		"\u018b\3\2\2\2\u06f4\u06f2\3\2\2\2\u06f5\u06f6\5\u0104\u0083\2\u06f6\u06f7"+
		"\5\u018e\u00c8\2\u06f7\u06f8\7\u00df\2\2\u06f8\u06fe\3\2\2\2\u06f9\u06fa"+
		"\5\u0104\u0083\2\u06fa\u06fb\5\u018e\u00c8\2\u06fb\u06fc\5\u0104\u0083"+
		"\2\u06fc\u06fe\3\2\2\2\u06fd\u06f5\3\2\2\2\u06fd\u06f9\3\2\2\2\u06fe\u018d"+
		"\3\2\2\2\u06ff\u0701\7%\2\2\u0700\u06ff\3\2\2\2\u0700\u0701\3\2\2\2\u0701"+
		"\u0702\3\2\2\2\u0702\u0705\5\u0190\u00c9\2\u0703\u0705\5\u0192\u00ca\2"+
		"\u0704\u0700\3\2\2\2\u0704\u0703\3\2\2\2\u0705\u018f\3\2\2\2\u0706\u070d"+
		"\7\"\2\2\u0707\u070d\7\31\2\2\u0708\u0709\7\u0084\2\2\u0709\u070d\7\u0090"+
		"\2\2\u070a\u070d\7}\2\2\u070b\u070d\7~\2\2\u070c\u0706\3\2\2\2\u070c\u0707"+
		"\3\2\2\2\u070c\u0708\3\2\2\2\u070c\u070a\3\2\2\2\u070c\u070b\3\2\2\2\u070d"+
		"\u0191\3\2\2\2\u070e\u070f\t\20\2\2\u070f\u0193\3\2\2\2\u0710\u0711\5"+
		"\u0104\u0083\2\u0711\u0713\7\36\2\2\u0712\u0714\7%\2\2\u0713\u0712\3\2"+
		"\2\2\u0713\u0714\3\2\2\2\u0714\u0715\3\2\2\2\u0715\u0716\7&\2\2\u0716"+
		"\u0195\3\2\2\2\u0717\u0718\5\u00c4c\2\u0718\u0719\5\u017e\u00c0\2\u0719"+
		"\u071a\5\u0198\u00cd\2\u071a\u071b\5\u0174\u00bb\2\u071b\u0197\3\2\2\2"+
		"\u071c\u071f\5\u019a\u00ce\2\u071d\u071f\5\u019c\u00cf\2\u071e\u071c\3"+
		"\2\2\2\u071e\u071d\3\2\2\2\u071f\u0199\3\2\2\2\u0720\u0721\7\4\2\2\u0721"+
		"\u019b\3\2\2\2\u0722\u0723\t\21\2\2\u0723\u019d\3\2\2\2\u0724\u0726\7"+
		"%\2\2\u0725\u0724\3\2\2\2\u0725\u0726\3\2\2\2\u0726\u0727\3\2\2\2\u0727"+
		"\u0728\7T\2\2\u0728\u0729\5\u0174\u00bb\2\u0729\u019f\3\2\2\2\u072a\u072b"+
		"\7\64\2\2\u072b\u072c\5\u0174\u00bb\2\u072c\u01a1\3\2\2\2\u072d\u0730"+
		"\5\u01a4\u00d3\2\u072e\u0730\7\u0082\2\2\u072f\u072d\3\2\2\2\u072f\u072e"+
		"\3\2\2\2\u0730\u01a3\3\2\2\2\u0731\u0732\t\22\2\2\u0732\u01a5\3\2\2\2"+
		"\u0733\u0734\t\23\2\2\u0734\u01a7\3\2\2\2\u0735\u0736\5\u01ac\u00d7\2"+
		"\u0736\u0738\7\u00cd\2\2\u0737\u0739\5\u01ae\u00d8\2\u0738\u0737\3\2\2"+
		"\2\u0738\u0739\3\2\2\2\u0739\u073a\3\2\2\2\u073a\u073b\7\u00ce\2\2\u073b"+
		"\u01a9\3\2\2\2\u073c\u073d\t\24\2\2\u073d\u01ab\3\2\2\2\u073e\u0741\5"+
		"^\60\2\u073f\u0741\5\u01aa\u00d6\2\u0740\u073e\3\2\2\2\u0740\u073f\3\2"+
		"\2\2\u0741\u01ad\3\2\2\2\u0742\u0747\5\u00c0a\2\u0743\u0744\7\u00c6\2"+
		"\2\u0744\u0746\5\u00c0a\2\u0745\u0743\3\2\2\2\u0746\u0749\3\2\2\2\u0747"+
		"\u0745\3\2\2\2\u0747\u0748\3\2\2\2\u0748\u01af\3\2\2\2\u0749\u0747\3\2"+
		"\2\2\u074a\u074b\7*\2\2\u074b\u074c\7@\2\2\u074c\u074d\5\u01b2\u00da\2"+
		"\u074d\u01b1\3\2\2\2\u074e\u0753\5\u01b4\u00db\2\u074f\u0750\7\u00c6\2"+
		"\2\u0750\u0752\5\u01b4\u00db\2\u0751\u074f\3\2\2\2\u0752\u0755\3\2\2\2"+
		"\u0753\u0751\3\2\2\2\u0753\u0754\3\2\2\2\u0754\u01b3\3\2\2\2\u0755\u0753"+
		"\3\2\2\2\u0756\u0758\5\u0104\u0083\2\u0757\u0759\5\u01b6\u00dc\2\u0758"+
		"\u0757\3\2\2\2\u0758\u0759\3\2\2\2\u0759\u075b\3\2\2\2\u075a\u075c\5\u01ba"+
		"\u00de\2\u075b\u075a\3\2\2\2\u075b\u075c\3\2\2\2\u075c\u01b5\3\2\2\2\u075d"+
		"\u075e\t\25\2\2\u075e\u01b7\3\2\2\2\u075f\u0760\7#\2\2\u0760\u0763\5\u00c4"+
		"c\2\u0761\u0762\7\u00c6\2\2\u0762\u0764\5\u00c4c\2\u0763\u0761\3\2\2\2"+
		"\u0763\u0764\3\2\2\2\u0764\u01b9\3\2\2\2\u0765\u0766\7&\2\2\u0766\u076a"+
		"\7Y\2\2\u0767\u0768\7&\2\2\u0768\u076a\7g\2\2\u0769\u0765\3\2\2\2\u0769"+
		"\u0767\3\2\2\2\u076a\u01bb\3\2\2\2\u076b\u076d\7b\2\2\u076c\u076e\7u\2"+
		"\2\u076d\u076c\3\2\2\2\u076d\u076e\3\2\2\2\u076e\u076f\3\2\2\2\u076f\u0770"+
		"\7\35\2\2\u0770\u0775\5\u015a\u00ae\2\u0771\u0772\7\u00cd\2\2\u0772\u0773"+
		"\5\u012a\u0096\2\u0773\u0774\7\u00ce\2\2\u0774\u0776\3\2\2\2\u0775\u0771"+
		"\3\2\2\2\u0775\u0776\3\2\2\2\u0776\u0777\3\2\2\2\u0777\u0778\5\u0146\u00a4"+
		"\2\u0778\u079a\3\2\2\2\u0779\u077b\7b\2\2\u077a\u077c\7u\2\2\u077b\u077a"+
		"\3\2\2\2\u077b\u077c\3\2\2\2\u077c\u077d\3\2\2\2\u077d\u077e\7\35\2\2"+
		"\u077e\u077f\7j\2\2\u077f\u0785\7\u00df\2\2\u0780\u0781\7\66\2\2\u0781"+
		"\u0783\5^\60\2\u0782\u0784\58\35\2\u0783\u0782\3\2\2\2\u0783\u0784\3\2"+
		"\2\2\u0784\u0786\3\2\2\2\u0785\u0780\3\2\2\2\u0785\u0786\3\2\2\2\u0786"+
		"\u0787\3\2\2\2\u0787\u079a\5\u0146\u00a4\2\u0788\u078a\7b\2\2\u0789\u078b"+
		"\7u\2\2\u078a\u0789\3\2\2\2\u078a\u078b\3\2\2\2\u078b\u078c\3\2\2\2\u078c"+
		"\u078d\7\35\2\2\u078d\u0792\5\u015a\u00ae\2\u078e\u078f\7\u00cd\2\2\u078f"+
		"\u0790\5\u012a\u0096\2\u0790\u0791\7\u00ce\2\2\u0791\u0793\3\2\2\2\u0792"+
		"\u078e\3\2\2\2\u0792\u0793\3\2\2\2\u0793\u0794\3\2\2\2\u0794\u0795\7\67"+
		"\2\2\u0795\u0796\7\u00cd\2\2\u0796\u0797\5\u018a\u00c6\2\u0797\u0798\7"+
		"\u00ce\2\2\u0798\u079a\3\2\2\2\u0799\u076b\3\2\2\2\u0799\u0779\3\2\2\2"+
		"\u0799\u0788\3\2\2\2\u079a\u01bd\3\2\2\2\u079b\u079c\7\65\2\2\u079c\u079d"+
		"\5\u010e\u0088\2\u079d\u079e\7\u0083\2\2\u079e\u07a0\5\u01c0\u00e1\2\u079f"+
		"\u07a1\5\u012e\u0098\2\u07a0\u079f\3\2\2\2\u07a0\u07a1\3\2\2\2\u07a1\u01bf"+
		"\3\2\2\2\u07a2\u07a7\5\u017c\u00bf\2\u07a3\u07a4\7\u00c6\2\2\u07a4\u07a6"+
		"\5\u017c\u00bf\2\u07a5\u07a3\3\2\2\2\u07a6\u07a9\3\2\2\2\u07a7\u07a5\3"+
		"\2\2\2\u07a7\u07a8\3\2\2\2\u07a8\u01c1\3\2\2\2\u07a9\u07a7\3\2\2\2\u07aa"+
		"\u07ab\7\20\2\2\u07ab\u07ad\5\u010a\u0086\2\u07ac\u07ae\5\u012e\u0098"+
		"\2\u07ad\u07ac\3\2\2\2\u07ad\u07ae\3\2\2\2\u07ae\u01c3\3\2\2\2\u07af\u07b0"+
		"\7=\2\2\u07b0\u07b1\7\u008a\2\2\u07b1\u07b2\5^\60\2\u07b2\u07b3\7j\2\2"+
		"\u07b3\u07b4\7\u00df\2\2\u07b4\u01c5\3\2\2\2\u07b5\u07b6\7=\2\2\u07b6"+
		"\u07b7\7/\2\2\u07b7\u07b8\5\u015a\u00ae\2\u07b8\u07b9\7\u0080\2\2\u07b9"+
		"\u07ba\7\u0090\2\2\u07ba\u07bb\5\u015a\u00ae\2\u07bb\u07e7\3\2\2\2\u07bc"+
		"\u07bd\7=\2\2\u07bd\u07be\7/\2\2\u07be\u07bf\5\u015a\u00ae\2\u07bf\u07c0"+
		"\7\u0080\2\2\u07c0\u07c1\7E\2\2\u07c1\u07c2\5\u015c\u00af\2\u07c2\u07c3"+
		"\7\u0090\2\2\u07c3\u07c4\5\u015c\u00af\2\u07c4\u07e7\3\2\2\2\u07c5\u07c6"+
		"\7=\2\2\u07c6\u07c7\7/\2\2\u07c7\u07c8\5\u015a\u00ae\2\u07c8\u07c9\7<"+
		"\2\2\u07c9\u07ca\7E\2\2\u07ca\u07cb\5 \21\2\u07cb\u07e7\3\2\2\2\u07cc"+
		"\u07cd\7=\2\2\u07cd\u07ce\7/\2\2\u07ce\u07cf\5\u015a\u00ae\2\u07cf\u07d0"+
		"\7=\2\2\u07d0\u07d1\7E\2\2\u07d1\u07d2\5 \21\2\u07d2\u07e7\3\2\2\2\u07d3"+
		"\u07d4\7=\2\2\u07d4\u07d5\7/\2\2\u07d5\u07d6\5\u015a\u00ae\2\u07d6\u07d7"+
		"\7P\2\2\u07d7\u07d8\7E\2\2\u07d8\u07d9\5\u015c\u00af\2\u07d9\u07e7\3\2"+
		"\2\2\u07da\u07db\7=\2\2\u07db\u07dc\7/\2\2\u07dc\u07dd\5\u015a\u00ae\2"+
		"\u07dd\u07de\7<\2\2\u07de\u07df\5&\24\2\u07df\u07e7\3\2\2\2\u07e0\u07e1"+
		"\7=\2\2\u07e1\u07e2\7/\2\2\u07e2\u07e3\5\u015a\u00ae\2\u07e3\u07e4\7P"+
		"\2\2\u07e4\u07e5\5&\24\2\u07e5\u07e7\3\2\2\2\u07e6\u07b5\3\2\2\2\u07e6"+
		"\u07bc\3\2\2\2\u07e6\u07c5\3\2\2\2\u07e6\u07cc\3\2\2\2\u07e6\u07d3\3\2"+
		"\2\2\u07e6\u07da\3\2\2\2\u07e6\u07e0\3\2\2\2\u07e7\u01c7\3\2\2\2\u00d5"+
		"\u01c9\u01cd\u01d7\u01de\u01e8\u01ec\u01f3\u01f9\u01fe\u0209\u021a\u0221"+
		"\u0224\u022c\u0232\u0235\u0238\u023c\u0241\u0246\u0249\u024c\u0251\u0259"+
		"\u0260\u026c\u0273\u027d\u02a6\u02ab\u02ba\u02cf\u02e0\u02ed\u02f1\u02f3"+
		"\u0300\u0307\u031f\u0326\u0336\u033a\u033f\u0345\u034a\u0350\u036b\u0371"+
		"\u0375\u037a\u037f\u0383\u0386\u038f\u0394\u0398\u039e\u03a4\u03a9\u03ad"+
		"\u03af\u03b3\u03b7\u03b9\u03bd\u03c1\u03c5\u03c9\u03d2\u03d8\u03da\u03de"+
		"\u03e6\u03f0\u0402\u0406\u040a\u040f\u0411\u0415\u041a\u041e\u0420\u0424"+
		"\u0431\u0438\u0444\u0446\u044b\u046d\u0471\u0475\u047c\u047f\u0487\u048a"+
		"\u049d\u04ad\u04b2\u04b9\u04c1\u04c5\u04cf\u04d9\u04dd\u04ed\u04f3\u04fc"+
		"\u0503\u050d\u0510\u0513\u051a\u0525\u052d\u0533\u0537\u053b\u0543\u0547"+
		"\u054f\u0558\u055c\u0560\u0563\u0566\u0569\u056c\u0576\u057b\u0581\u0587"+
		"\u058f\u0596\u059d\u05a5\u05b0\u05b4\u05ba\u05c6\u05c9\u05cf\u05d3\u05da"+
		"\u05dc\u05e3\u05f6\u05fd\u0604\u060b\u0623\u062a\u0630\u0634\u0638\u063d"+
		"\u0642\u0648\u064c\u0650\u0655\u065a\u0661\u0665\u066c\u0673\u0675\u067b"+
		"\u067f\u0686\u068b\u068f\u0694\u069d\u06a2\u06a7\u06b0\u06c3\u06d5\u06d9"+
		"\u06e1\u06eb\u06f2\u06fd\u0700\u0704\u070c\u0713\u071e\u0725\u072f\u0738"+
		"\u0740\u0747\u0753\u0758\u075b\u0763\u0769\u076d\u0775\u077b\u0783\u0785"+
		"\u078a\u0792\u0799\u07a0\u07a7\u07ad\u07e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}