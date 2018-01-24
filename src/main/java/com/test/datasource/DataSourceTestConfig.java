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
//@MapperScan(basePackages = "com.test.mapper", sqlSessionFactoryRef = "testSqlSessionFactory")
//public class DataSourceTestConfig {
//
//	/**
//	 * 
//	 * @methodDesc: 功能描述:(配置test数据库)
//	 */
//	@Bean(name = "testDataSource")
//	@Primary //默认
//	@ConfigurationProperties(prefix = "spring.datasource.test")
//	public DataSource testDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	/**
//	 * 
//	 * @methodDesc: 功能描述:(test sql会话工厂)
//	 */
//	@Bean(name = "testSqlSessionFactory")
//	@Primary
//	public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource)
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
//	 * @methodDesc: 功能描述:(test 事物管理)
//	 */
//	@Bean(name = "testTransactionManager")
//	@Primary
//	public DataSourceTransactionManager testTransactionManager(@Qualifier("testDataSource") DataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//	}
//
//	@Bean(name = "testSqlSessionTemplate")
//	public SqlSessionTemplate testSqlSessionTemplate(
//			@Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}
//
//}
