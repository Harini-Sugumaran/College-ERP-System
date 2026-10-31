package com.college.erp.model;
    import jakarta.persistence.*;
    @Entity @Table(name="students")
    public class Student {
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
        public Student(){}
        public Long getId(){return id;}
        private String name; @jakarta.persistence.Column(unique=true,nullable=false) private String email; private String department; private int year; private String phone;
public String getName(){return name;} public void setName(String v){name=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;}
public String getDepartment(){return department;} public void setDepartment(String v){department=v;} public int getYear(){return year;} public void setYear(int v){year=v;} public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
    }
