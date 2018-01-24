package com.test.datasource;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import com.test.config.DBConfig;
import com.test.config.DBConfig1;
@Configuration
//basePackages 最好分开配置 如果放在同一个文件夹可能会报错
@MapperScan(basePackages = "com.test01.mapper", sqlSessionTemplateRef = "test01SqlSessionTemplate")
public class DSTest01Config {
		// 配置数据源
		@Bean(name = "test01DataSource")
		public DataSource test01DataSource(DBConfig1 test01Config) throws SQLException {
			MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
			mysqlXaDataSource.setUrl(test01Config.getUrl());
			mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
			mysqlXaDataSource.setPassword(test01Config.getPassword());
			mysqlXaDataSource.setUser(test01Config.getUsername());
			mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

			AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
			xaDataSource.setXaDataSource(mysqlXaDataSource);
			xaDataSource.setUniqueResourceName("test01DataSource");

			xaDataSource.setMinPoolSize(test01Config.getMinPoolSize());
			xaDataSource.setMaxPoolSize(test01Config.getMaxPoolSize());
			xaDataSource.setMaxLifetime(test01Config.getMaxLifetime());
			xaDataSource.setBorrowConnectionTimeout(test01Config.getBorrowConnectionTimeout());
			xaDataSource.setLoginTimeout(test01Config.getLoginTimeout());
			xaDataSource.setMaintenanceInterval(test01Config.getMaintenanceInterval());
			xaDataSource.setMaxIdleTime(test01Config.getMaxIdleTime());
			xaDataSource.setTestQuery(test01Config.getTestQuery());
			return xaDataSource;
		}

		@Bean(name = "test01SqlSessionFactory")
		public SqlSessionFactory test01SqlSessionFactory(@Qualifier("test01DataSource") DataSource dataSource)
				throws Exception {
			SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
			bean.setDataSource(dataSource);
			return bean.getObject();
		}

		@Bean(name = "test01SqlSessionTemplate")
		public SqlSessionTemplate test01SqlSessionTemplate(
				@Qualifier("test01SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
			return new SqlSessionTemplate(sqlSessionFactory);
		}
}
