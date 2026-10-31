package com.college.erp.controller;
import com.college.erp.model.User;
import com.college.erp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service){this.service=service;}
    @GetMapping public List<User> getAll(){return service.getAll();}
    @GetMapping("/{id}") public ResponseEntity<User> getById(@PathVariable Long id){
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public ResponseEntity<User> create(@RequestBody User item){return ResponseEntity.ok(service.create(item));}
    @PutMapping("/{id}") public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User d){
        return service.update(id,d).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){
        return service.delete(id)?ResponseEntity.noContent().build():ResponseEntity.notFound().build();
    }
}
