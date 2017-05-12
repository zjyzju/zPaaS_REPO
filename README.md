# zPaaS_REPO
一、工程说明

1、zPaaS：zPaaS技术平台的源码工程

2、zPaaS_distributedDb：zPaaS分布式关系数据库引擎

3、zPaaS_distributedTransaction：zPaaS分布式事务框架

4、zPaaS_service_template：基础zPaaS技术平台构建的服务端工程模板

5、zPaaS_web_template：基础zPaaS技术平台构建的web工程模板

二、功能说明

1、zPaaS包

（1）统一配置中心（基于Zookeeper）

（2）统一Session管理（基于Redis）

（3）统一缓存管理（基于Redis）

（4）统一普通文件管理（基于MongoDB、GridFS）

（5）统一机密文件管理（基于MongoDB、GridFS）

（6）统一交易日志管理（基于MongoDB）

（7）统一系统日志管理（基于Log4j、Kafka和MongoDB）

（8）消息生产和消费框架封装（基于Kafka）

（9）统一签名和签名验证管理（基于统一机密文件管理）

（10）规则引擎服务（基于Drools）

（11）分布式资源调度器（基于Zookeeper）

（12）本地缓存服务

（13）对称加密工具

（14）各种工具类 

2、zPaaS_distributedDb包：分布式数据库引擎

（1）支持多租户隔离

（2）支持分库分表

（3）支持读写分离

（4）支持常用SQL

（5）默认支持弱事务

（6）支持多分表/单分表查询

（7）支持路由配置

3、zPaaS_distributedTransaction：分布式事务框架

（1）保障性弱事务

（2）最终一致事务

四、技术平台介绍

  参见zPaaS_introduction.pdf
  
五、使用说明

  参见zPaaS_document.txt

