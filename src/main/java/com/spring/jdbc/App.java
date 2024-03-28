package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

//Run this App as Java Application.

public class App {
	public static void main(String[] args) {

		// spring jdbc => JdbcTemplate Object
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

//        JdbcTemplate jdbc = context.getBean("jdbcTemp", JdbcTemplate.class);
//        
//        //insert query  -> using values
//         String q1 = "insert into student values (333,'chaman', 'agra')";
//         //fire query
//         int result1 = jdbc.update(q1);
//
//         System.out.println("update result1 "+result1);
//         
//         // insert query  ->  using question mark
//         String s2 = "insert into student values(?,?,?)";
//         
//         int result2 = jdbc.update(s2, 444,"rahul","delhi");
//         System.out.println("update result2 "+result2);

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//        Add Student Record

//		Student student = new Student();
//
//		student.setRollNo(786);
//		student.setName("Serul");
//		student.setCity("Mansoori");
//
//		int result = studentDao.insert(student);
//		System.out.println("Record Added : " + result);
//        

//        Update Student Record
//        
//        Student updateStudent = new Student();
//        
//        updateStudent.setRollNo(999);
//        updateStudent.setCity("Ajmer");
//        updateStudent.setName("Gullu");
//        
//        int update = studentDao.update(updateStudent);
//        System.out.println("Record "+updateStudent.getRollNo()+" updated : "+update);

		// Delete Method

//        long delete = studentDao.delete(11);
//        System.out.println("record deleted "+delete);
//        

		// get Student by ID

//		Student getStudentById = studentDao.getStudentById(888);
//		System.out.println("get student by ID : " + getStudentById);

		// get All the Students

		List<Student> students = studentDao.getAllStudent();

//		System.out.println("All Students : " + student);

		for (Student std : students) {
			System.out.println(std);
		}

	}
}
