package com.college.erp.model;
    import jakarta.persistence.*;
    @Entity @Table(name="users")
    public class User {
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
        public User(){}
        public Long getId(){return id;}
        @jakarta.persistence.Column(unique=true,nullable=false) private String username; private String password; private String role;
public String getUsername(){return username;} public void setUsername(String v){username=v;} public String getPassword(){return password;} public void setPassword(String v){password=v;} public String getRole(){return role;} public void setRole(String v){role=v;}
    }
