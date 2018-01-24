//package com.test.datasource;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//@Configuration // 注册到springboot容器中
//@MapperScan(basePackages = "com.test01.mapper", sqlSessionFactoryRef = "test01SqlSessionFactory")
//public class DataSourceTest01Config {
//
//	/**
//	 * 
//	 * @methodDesc: 功能描述:(配置test01数据库)
//	 */
//	@Bean(name = "test01DataSource")
////	@Primary 
//	@ConfigurationProperties(prefix = "spring.datasource.test01")
//	public DataSource testDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	/**
//	 * 
//	 * @methodDesc: 功能描述:(test01 sql会话工厂)
//	 */
//	@Bean(name = "test01SqlSessionFactory")
////	@Primary
//	public SqlSessionFactory testSqlSessionFactory(@Qualifier("test01DataSource") DataSource dataSource)
//			throws Exception {
//		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//		bean.setDataSource(dataSource);
//		// bean.setMapperLocations(
//		// new
//		// PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
//		return bean.getObject();
//	}
//
//	/**
//	 * 
//	 * @methodDesc: 功能描述:(test01 事物管理)
//	 */
//	@Bean(name = "test01TransactionManager")
////	@Primary
//	public DataSourceTransactionManager testTransactionManager(@Qualifier("test01DataSource") DataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//	}
//
//	@Bean(name = "test01SqlSessionTemplate")
//	public SqlSessionTemplate testSqlSessionTemplate(
//			@Qualifier("test01SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}
//
//}
