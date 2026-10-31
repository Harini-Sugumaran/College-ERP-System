package com.college.erp.service;
import com.college.erp.model.User;
import com.college.erp.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class UserService {
    private final UserRepository repository;
    public UserService(UserRepository repository){this.repository=repository;}
    public List<User> getAll(){return repository.findAll();}
    public Optional<User> getById(Long id){return repository.findById(id);}
    public User create(User item){return repository.save(item);}
    public Optional<User> update(Long id,User d){
        return repository.findById(id).map(existing->{existing.setUsername(d.getUsername()); existing.setPassword(d.getPassword()); existing.setRole(d.getRole()); return repository.save(existing);});
    }
    public boolean delete(Long id){if(!repository.existsById(id))return false; repository.deleteById(id); return true;}
}
