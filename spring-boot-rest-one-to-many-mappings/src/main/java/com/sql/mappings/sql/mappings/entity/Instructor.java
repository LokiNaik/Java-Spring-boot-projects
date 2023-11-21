package com.sql.mappings.sql.mappings.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetails instructorDetail;

    @OneToMany(cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    private List<Course> course;
    public List<Course> getCourses() {
        return course;
    }

    public void setCourses(List<Course> courses) {
        this.course = courses;
    }

    public Instructor()
    {
    }


    public InstructorDetails getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetails instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instructor(int id, String firstName, String lastName, String email, InstructorDetails instructorDetail, List<Course> course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.instructorDetail = instructorDetail;
        this.course = course;
    }
}
