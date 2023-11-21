package com.sql.mappings.sql.mappings.controller;

import com.sql.mappings.sql.mappings.EmployeeRepo.InstructorDetailsRepo;
import com.sql.mappings.sql.mappings.EmployeeRepo.InstructorRepository;
import com.sql.mappings.sql.mappings.entity.Course;
import com.sql.mappings.sql.mappings.entity.DTO;
import com.sql.mappings.sql.mappings.entity.Instructor;
import com.sql.mappings.sql.mappings.entity.InstructorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private InstructorDetailsRepo instructorDetailsRepo;

    @PostMapping("/save")
    public Instructor createInstructor(@RequestBody DTO dto) {
//        instructorDetailsRepo.save(instructor.getInstructorDetail());
        InstructorDetails details = dto.getInstructorDetails();
        Course course = dto.getCourse();
         Instructor instructor = dto.getInstructor();
         System.out.println(course);
         instructor.setCourses((List<Course>) course);
         instructor.setInstructorDetail(details);

        return instructorRepository.save(instructor);
    }

}
