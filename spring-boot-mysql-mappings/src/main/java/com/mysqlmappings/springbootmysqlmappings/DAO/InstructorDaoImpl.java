package com.mysqlmappings.springbootmysqlmappings.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysqlmappings.springbootmysqlmappings.entity.Course;
import com.mysqlmappings.springbootmysqlmappings.entity.Instructor;
import com.mysqlmappings.springbootmysqlmappings.entity.InstructorDetail;

@Repository
public class InstructorDaoImpl implements InstructorDao {
    private EntityManager entitymanager;

    @Autowired
    public InstructorDaoImpl(EntityManager entitymanager) {
        super();
        this.entitymanager = entitymanager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entitymanager.persist(instructor);
    }

    @Override
    @Transactional
    public void saveDetails(InstructorDetail instructorDetail) {
        entitymanager.persist(instructorDetail);

    }

    @Override
    public Instructor getInstructorById(int id) {

    return entitymanager.find(Instructor.class , id);

    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        InstructorDetail instructorDetail = entitymanager.find(InstructorDetail.class , id);
        instructorDetail.getInstructor().setInstructorDetail(null);
         entitymanager.remove(instructorDetail);
         System.out.println("deleted sucessfully");
    }
      @Override
       public List<Course> findCourseByInstructorId(int id) {
        TypedQuery<Course> query=entitymanager.createQuery("from Course where instructor.id=:data", Course.class);
        query.setParameter("data", id);
        List<Course> courses=query.getResultList();
        return courses;
    }
}