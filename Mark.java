package com.college.erp.model;
    import jakarta.persistence.*;
    @Entity @Table(name="marks")
    public class Mark {
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
        public Mark(){}
        public Long getId(){return id;}
        private Long studentId; private Long courseId; private double internalMark; private double examMark;
public Long getStudentId(){return studentId;} public void setStudentId(Long v){studentId=v;} public Long getCourseId(){return courseId;} public void setCourseId(Long v){courseId=v;} public double getInternalMark(){return internalMark;} public void setInternalMark(double v){internalMark=v;} public double getExamMark(){return examMark;} public void setExamMark(double v){examMark=v;}
    }
