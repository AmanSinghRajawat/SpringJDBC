package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
public class JavaConfig {

	@Bean(name = { "databaseConfigurationObject" })
	public DataSource getDataSource() {

		DriverManagerDataSource dataSourceObj = new DriverManagerDataSource();

		dataSourceObj.setDriverClassName("com.mysql.jdbc.Driver");
		dataSourceObj.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dataSourceObj.setUsername("root");
		dataSourceObj.setPassword("root");

		return dataSourceObj;
	}

	@Bean(name = { "jdbcTemplate" })
	public JdbcTemplate getJdbcTemplate() {

		JdbcTemplate jdbcTemp = new JdbcTemplate();
		jdbcTemp.setDataSource(getDataSource());

		return jdbcTemp;
	}

	@Bean(name = { "studentDao" })
	public StudentDao getStudentDao() {
		StudentDaoImpl studentDao = new StudentDaoImpl();
		studentDao.setJdbcTemplate(getJdbcTemplate());
		return studentDao;
	}

}
