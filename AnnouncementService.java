package com.college.erp.service;
import com.college.erp.model.Announcement;
import com.college.erp.repository.AnnouncementRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class AnnouncementService {
    private final AnnouncementRepository repository;
    public AnnouncementService(AnnouncementRepository repository){this.repository=repository;}
    public List<Announcement> getAll(){return repository.findAll();}
    public Optional<Announcement> getById(Long id){return repository.findById(id);}
    public Announcement create(Announcement item){return repository.save(item);}
    public Optional<Announcement> update(Long id,Announcement d){
        return repository.findById(id).map(existing->{existing.setTitle(d.getTitle()); existing.setMessage(d.getMessage()); existing.setAudience(d.getAudience()); return repository.save(existing);});
    }
    public boolean delete(Long id){if(!repository.existsById(id))return false; repository.deleteById(id); return true;}
}
