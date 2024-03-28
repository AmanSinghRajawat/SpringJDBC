package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	// Insert Record Method

	public int insert(Student student) {
		String query = "insert into student(rollNo, name, city) values(?,?,?)";
		int result = this.jdbcTemplate.update(query, student.getRollNo(), student.getName(), student.getCity());
		return result;
	}

	// Update Record Method

	public int update(Student student) {
		String query = "update student set name =? , city=? where rollNo=?";
		int update = jdbcTemplate.update(query, student.getName(), student.getCity(), student.getRollNo());
		return update;
	}

	// Delete Record Method

	public long delete(long rollNo) {
		String query = "delete from student where rollNo = ?";
		int delete = jdbcTemplate.update(query, rollNo);
		return delete;
	}

	// get Student by ID, Select Single Student by ID, We need RowMapper for select query.

	// RowMapper converts result set into Objects.

	public Student getStudentById(long rollNo) {
		String query = "select * from student where rollNo=?";
		RowMapper<Student> rowMapperImpl = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapperImpl, rollNo);
		return student;
	}

	// RowMapper using Anonymous class, Not Recommended, Because every time you have to implement 'mapRow' method.

//	public Student getStudentById(long rollNo) {
//		String query = "select * from student where rollNo=?";
//		Student student = (Student) this.jdbcTemplate.queryForObject(query, new RowMapper() {
//
//			@Override
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Student student = new Student();
//				student.setRollNo(rs.getLong(1));
//				student.setName(rs.getString(2));
//				student.setCity(rs.getString(3));
//				return student;
//			}
//
//		}, rollNo);
//		return student;
//	}

	// select all the students

	public List<Student> getAllStudent() {
		String query = "select * from student";
//		RowMapper<Student> rowMapperImpl = new RowMapperImpl();
		List<Student> student = jdbcTemplate.query(query, new RowMapperImpl());
		return student;
	}

	// jdbcTemplate Getter & Setter Method

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
