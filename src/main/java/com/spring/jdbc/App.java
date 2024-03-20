package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


    // Run this App as Java Application.


        System.out.println( "Hello World!" );
        
        
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
//        JdbcTemplate jdbc = context.getBean("jdbcTemp", JdbcTemplate.class);
//        
//        //insert query  -> using values
//         String q1 = "insert into student values (333,'chaman', 'agra')";
//         //execute query
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
        
        Student student = new Student();
        
        student.setRollNo(999);
        student.setName("Satyam");
        student.setCity("Noida");
        
        int result = studentDao.insert(student);
        System.out.println("Result updated : "+result);
        
        
    }
}
