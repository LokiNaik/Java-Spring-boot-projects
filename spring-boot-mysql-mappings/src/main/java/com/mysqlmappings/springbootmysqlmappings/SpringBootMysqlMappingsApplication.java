package com.mysqlmappings.springbootmysqlmappings;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mysqlmappings.springbootmysqlmappings.DAO.InstructorDao;
import com.mysqlmappings.springbootmysqlmappings.entity.Course;
import com.mysqlmappings.springbootmysqlmappings.entity.Instructor;
import com.mysqlmappings.springbootmysqlmappings.entity.InstructorDetail;

@SpringBootApplication
public class SpringBootMysqlMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMysqlMappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDao instructorDao) {
		return runner -> {
			createInstructor(instructorDao);
			createInstructorDetails(instructorDao);
//			// InstructorDetails(instructorDao );
//			// deleteInstructorDetails(instructorDao);
			createCourse(instructorDao);
//			courseDetails(instructorDao);
		};
	}

	private void createInstructor(InstructorDao instructorDao) {
		Instructor tempInstructor = new Instructor("rohit", "mahajan", "rohit@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com", "gaming");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		instructorDao.save(tempInstructor);
	}

	private void createInstructorDetails(InstructorDao instructorDao) {
		Instructor tempInstructor = new Instructor("ashwini", "patil", "aswini@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com", "swimming");
		tempInstructorDetail.setInstructor(tempInstructor);
		instructorDao.saveDetails(tempInstructorDetail);
	}

	private Instructor InstructorDetails(InstructorDao instructorDao) {
		int id = 1;
		Instructor instructor = instructorDao.getInstructorById(id);
		System.out.println("first name : " + instructor.getFirstName());
		System.out.println("last name : " + instructor.getLastName());
		System.out.println("email : " + instructor.getEmail());
		return instructor;
	}

	private void deleteInstructorDetails(InstructorDao instructorDao) {
		int id = 5;
		instructorDao.deleteInstructorById(id);
	}

	private void createCourse(InstructorDao instructorDao) {
		Instructor instructor = new Instructor("rohit", "mahajan", "rohit@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com", "gaming");
		instructor.setInstructorDetail(tempInstructorDetail);
		// List<Course> courses = new ArrayList();
		// courses.add(new Course( "java"));
		// courses.add(new Course( "python"));
		Course course1 = new Course("java");
		Course course2 = new Course("python");
		// instructor.setCourses(courses);
		instructor.add(course1);
		instructor.add(course2);
		instructorDao.save(instructor);
	}

	private void courseDetails(InstructorDao instructorDao) {
		int id = 1;
		Instructor instructor = instructorDao.getInstructorById(id);
		List<Course> allCourses = instructorDao.findCourseByInstructorId(id);
		instructor.setCourses(allCourses);
		for (Course n : allCourses) {
			// System.out.println("instructor is " + n.getInstructor().getFirstName() +
			// n.getInstructor().getLastName());
			System.out.print("course id : " + n.getId());
			System.out.println(" course name : " + n.getTitle());
		}
	}

}
