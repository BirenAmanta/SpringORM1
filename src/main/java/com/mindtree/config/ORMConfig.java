package com.mindtree.config;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = { "com.mindtree.utility", "com.mindtree.repository", "com.mindtree.service",
		"com.mindtree.entity" })
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class ORMConfig {

	@Bean
	public EntityManagerFactory getFactory() {
		return Persistence.createEntityManagerFactory("data");
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory getFactory) {
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(getFactory);

		return tm;
	}

}
