package com.college.erp.model;
    import jakarta.persistence.*;
    @Entity @Table(name="attendances")
    public class Attendance {
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
        public Attendance(){}
        public Long getId(){return id;}
        private Long studentId; private Long courseId; private java.time.LocalDate date; private boolean present;
public Long getStudentId(){return studentId;} public void setStudentId(Long v){studentId=v;} public Long getCourseId(){return courseId;} public void setCourseId(Long v){courseId=v;} public java.time.LocalDate getDate(){return date;} public void setDate(java.time.LocalDate v){date=v;} public boolean isPresent(){return present;} public void setPresent(boolean v){present=v;}
    }
