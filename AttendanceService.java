package com.college.erp.service;
import com.college.erp.model.Attendance;
import com.college.erp.repository.AttendanceRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class AttendanceService {
    private final AttendanceRepository repository;
    public AttendanceService(AttendanceRepository repository){this.repository=repository;}
    public List<Attendance> getAll(){return repository.findAll();}
    public Optional<Attendance> getById(Long id){return repository.findById(id);}
    public Attendance create(Attendance item){return repository.save(item);}
    public Optional<Attendance> update(Long id,Attendance d){
        return repository.findById(id).map(existing->{existing.setStudentId(d.getStudentId()); existing.setCourseId(d.getCourseId()); existing.setDate(d.getDate()); existing.setPresent(d.isPresent()); return repository.save(existing);});
    }
    public boolean delete(Long id){if(!repository.existsById(id))return false; repository.deleteById(id); return true;}
}
