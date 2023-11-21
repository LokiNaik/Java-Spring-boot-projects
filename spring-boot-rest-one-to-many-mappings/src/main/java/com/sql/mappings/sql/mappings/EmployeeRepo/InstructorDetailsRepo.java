package com.sql.mappings.sql.mappings.EmployeeRepo;

import com.sql.mappings.sql.mappings.entity.InstructorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailsRepo extends JpaRepository<InstructorDetails, Integer> {

}