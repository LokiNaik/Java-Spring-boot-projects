package com.mysqlmappings.springbootmysqlmappings.DAO;

import java.util.List;

import com.mysqlmappings.springbootmysqlmappings.entity.Course;
import com.mysqlmappings.springbootmysqlmappings.entity.Instructor;
import com.mysqlmappings.springbootmysqlmappings.entity.InstructorDetail;

public interface InstructorDao {
    void save(Instructor instructor);

    void saveDetails(InstructorDetail instructorDetail);

    Instructor getInstructorById(int id);

    void deleteInstructorById(int id);


    List<Course> findCourseByInstructorId(int id);
}