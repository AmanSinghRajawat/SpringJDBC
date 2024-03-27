package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDao {
	public int insert(Student student);

	public int update(Student student);

	public long delete(long rollNo);

	public Student getStudentById(long rollNo);

	public List<Student> getAllStudent();
}
