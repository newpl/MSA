package com.news.user.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class DatabaseConfig {

	@Primary
	@Bean("dataSource")
	@ConfigurationProperties("spring.datasource.hikari")
	public DataSource dataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean
	public LiquibaseProperties liquibaseProperties() {
		return new LiquibaseProperties();
	}

	@Bean
	public SpringLiquibase liquibase(DataSource dataSource, LiquibaseProperties liquibaseProperties) {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setDataSource(dataSource);
		liquibase.setChangeLog(liquibaseProperties.getChangeLog());
		liquibase.setContexts(liquibaseProperties.getContexts());
		liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
		liquibase.setDropFirst(liquibaseProperties.isDropFirst());
		liquibase.setShouldRun(liquibaseProperties.isEnabled());

		return liquibase;
	}

}
