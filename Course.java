package com.college.erp.model;
    import jakarta.persistence.*;
    @Entity @Table(name="courses")
    public class Course {
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
        public Course(){}
        public Long getId(){return id;}
        private String code; private String name; private String department; private int credits; private Long teacherId;
public String getCode(){return code;} public void setCode(String v){code=v;} public String getName(){return name;} public void setName(String v){name=v;} public String getDepartment(){return department;} public void setDepartment(String v){department=v;} public int getCredits(){return credits;} public void setCredits(int v){credits=v;} public Long getTeacherId(){return teacherId;} public void setTeacherId(Long v){teacherId=v;}
    }
