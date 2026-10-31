package com.college.erp.model;
    import jakarta.persistence.*;
    @Entity @Table(name="teachers")
    public class Teacher {
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
        public Teacher(){}
        public Long getId(){return id;}
        private String name; @jakarta.persistence.Column(unique=true,nullable=false) private String email; private String department; private String designation; private String phone;
public String getName(){return name;} public void setName(String v){name=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;}
public String getDepartment(){return department;} public void setDepartment(String v){department=v;} public String getDesignation(){return designation;} public void setDesignation(String v){designation=v;} public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
    }
