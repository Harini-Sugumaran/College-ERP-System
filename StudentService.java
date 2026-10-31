package com.college.erp.service;
import com.college.erp.model.Student;
import com.college.erp.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository){this.repository=repository;}
    public List<Student> getAll(){return repository.findAll();}
    public Optional<Student> getById(Long id){return repository.findById(id);}
    public Student create(Student item){return repository.save(item);}
    public Optional<Student> update(Long id,Student d){
        return repository.findById(id).map(existing->{existing.setName(d.getName()); existing.setEmail(d.getEmail()); existing.setDepartment(d.getDepartment()); existing.setYear(d.getYear()); existing.setPhone(d.getPhone()); return repository.save(existing);});
    }
    public boolean delete(Long id){if(!repository.existsById(id))return false; repository.deleteById(id); return true;}
}
