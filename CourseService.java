package com.college.erp.service;
import com.college.erp.model.Course;
import com.college.erp.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class CourseService {
    private final CourseRepository repository;
    public CourseService(CourseRepository repository){this.repository=repository;}
    public List<Course> getAll(){return repository.findAll();}
    public Optional<Course> getById(Long id){return repository.findById(id);}
    public Course create(Course item){return repository.save(item);}
    public Optional<Course> update(Long id,Course d){
        return repository.findById(id).map(existing->{existing.setCode(d.getCode()); existing.setName(d.getName()); existing.setDepartment(d.getDepartment()); existing.setCredits(d.getCredits()); existing.setTeacherId(d.getTeacherId()); return repository.save(existing);});
    }
    public boolean delete(Long id){if(!repository.existsById(id))return false; repository.deleteById(id); return true;}
}
