package com.college.erp.controller;
import com.college.erp.model.Student;
import com.college.erp.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service){this.service=service;}
    @GetMapping public List<Student> getAll(){return service.getAll();}
    @GetMapping("/{id}") public ResponseEntity<Student> getById(@PathVariable Long id){
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public ResponseEntity<Student> create(@RequestBody Student item){return ResponseEntity.ok(service.create(item));}
    @PutMapping("/{id}") public ResponseEntity<Student> update(@PathVariable Long id,@RequestBody Student d){
        return service.update(id,d).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){
        return service.delete(id)?ResponseEntity.noContent().build():ResponseEntity.notFound().build();
    }
}
