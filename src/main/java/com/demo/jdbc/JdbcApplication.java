package com.demo.jdbc;

import com.demo.jdbc.dao.DAO;
import com.demo.jdbc.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JdbcApplication {


	private static DAO dao;

	public JdbcApplication(DAO dao) {
		this.dao=dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);

		System.out.println("\t Create Course --------------------\n");
		Course jsCourse=new Course("Javascript","js course","http:/learn-js");
		dao.create(jsCourse);

		System.out.println("\t Get One Course --------------------\n");
		Course foundCourse=dao.get(1).get();
		System.out.println("Course found : "+foundCourse);

		System.out.println("\t Update Course --------------------\n");
		Course updateCourse=dao.get(1).get();
		updateCourse.setTitle("Updated title : "+updateCourse.getTitle());
		dao.update(updateCourse,1);

		System.out.println("\t Delete Course --------------------\n");
		Course deleteCourse=dao.get(1).get();
		dao.delete(1);

		System.out.println("\t All Courses --------------------\n");
		List<Course> courses=dao.list();

		for(Course course:courses){
			System.out.println(course);
		}
	}

}
