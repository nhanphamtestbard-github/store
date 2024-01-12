package com.vn.store.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DBConfig {

	@Value("${application.datasource.driverClassName}")
	private String driverClass;

	@Value("${application.datasource.db}")
	private String db;

	@Value("${application.datasource.host}")
	private String host;

	@Value("${application.datasource.port}")
	private String port;

	@Value("${application.datasource.dbname}")
	private String dbname;

	@Value("${application.datasource.schema}")
	private String schema;

	@Value("${application.datasource.username}")
	private String username;

	@Value("${application.datasource.password}")
	private String password;

	private String getJdbcUrl() {
		return String.format("jdbc:%s://%s:%s/%s?currentSchema=%s", db, host, port, dbname, schema);
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		HikariConfig dataConfig = new HikariConfig();
		dataConfig.setJdbcUrl(getJdbcUrl());
		dataConfig.setUsername(username);
		dataConfig.setPassword(password);
		dataConfig.setDriverClassName(driverClass);

		return new HikariDataSource(dataConfig);
	}

//	@Bean(name = "transactionManager")
//	public DataSourceTransactionManager dataSourceTransactionManager() {
//		return new DataSourceTransactionManager(dataSource());
//	}
//
//	@Bean(name = "sqlSessionFactory")
//	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
//		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);
//
//		/* Set the mapper file location */
//		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//				.getResources("classpath:base/com/zhuoli/service/springboot/mybatis/config/repository/mapper/*.xml"));
//
//		/* Set entity class mapping rules: Underscore -> Hump */
//		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//		configuration.setMapUnderscoreToCamelCase(true);
//		sessionFactory.setConfiguration(configuration);
//		return sessionFactory.getObject();
//	}

}
