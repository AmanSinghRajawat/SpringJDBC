package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;
	
	
	public int insert(Student student) {
		String query = "insert into student(rollNo, name, city) values(?,?,?)";
		int result = this.jdbcTemplate.update(query, student.getRollNo(), student.getName(), student.getCity() );
		return result;
	}
	
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
