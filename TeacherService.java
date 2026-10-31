package com.college.erp.service;
import com.college.erp.model.Teacher;
import com.college.erp.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class TeacherService {
    private final TeacherRepository repository;
    public TeacherService(TeacherRepository repository){this.repository=repository;}
    public List<Teacher> getAll(){return repository.findAll();}
    public Optional<Teacher> getById(Long id){return repository.findById(id);}
    public Teacher create(Teacher item){return repository.save(item);}
    public Optional<Teacher> update(Long id,Teacher d){
        return repository.findById(id).map(existing->{existing.setName(d.getName()); existing.setEmail(d.getEmail()); existing.setDepartment(d.getDepartment()); existing.setDesignation(d.getDesignation()); existing.setPhone(d.getPhone()); return repository.save(existing);});
    }
    public boolean delete(Long id){if(!repository.existsById(id))return false; repository.deleteById(id); return true;}
}
