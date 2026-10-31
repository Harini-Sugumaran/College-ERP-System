package com.college.erp.model;
    import jakarta.persistence.*;
    @Entity @Table(name="announcements")
    public class Announcement {
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
        public Announcement(){}
        public Long getId(){return id;}
        private String title; @jakarta.persistence.Column(length=2000) private String message; private String audience; private java.time.LocalDateTime createdAt;
@jakarta.persistence.PrePersist public void prePersist(){if(createdAt==null)createdAt=java.time.LocalDateTime.now();}
public String getTitle(){return title;} public void setTitle(String v){title=v;} public String getMessage(){return message;} public void setMessage(String v){message=v;} public String getAudience(){return audience;} public void setAudience(String v){audience=v;} public java.time.LocalDateTime getCreatedAt(){return createdAt;}
    }
