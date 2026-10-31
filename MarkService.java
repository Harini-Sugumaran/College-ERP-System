package com.college.erp.service;
import com.college.erp.model.Mark;
import com.college.erp.repository.MarkRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class MarkService {
    private final MarkRepository repository;
    public MarkService(MarkRepository repository){this.repository=repository;}
    public List<Mark> getAll(){return repository.findAll();}
    public Optional<Mark> getById(Long id){return repository.findById(id);}
    public Mark create(Mark item){return repository.save(item);}
    public Optional<Mark> update(Long id,Mark d){
        return repository.findById(id).map(existing->{existing.setStudentId(d.getStudentId()); existing.setCourseId(d.getCourseId()); existing.setInternalMark(d.getInternalMark()); existing.setExamMark(d.getExamMark()); return repository.save(existing);});
    }
    public boolean delete(Long id){if(!repository.existsById(id))return false; repository.deleteById(id); return true;}
}
