package com.college.erp.controller;
import com.college.erp.model.Teacher;
import com.college.erp.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/teachers")
public class TeacherController {
    private final TeacherService service;
    public TeacherController(TeacherService service){this.service=service;}
    @GetMapping public List<Teacher> getAll(){return service.getAll();}
    @GetMapping("/{id}") public ResponseEntity<Teacher> getById(@PathVariable Long id){
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public ResponseEntity<Teacher> create(@RequestBody Teacher item){return ResponseEntity.ok(service.create(item));}
    @PutMapping("/{id}") public ResponseEntity<Teacher> update(@PathVariable Long id,@RequestBody Teacher d){
        return service.update(id,d).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){
        return service.delete(id)?ResponseEntity.noContent().build():ResponseEntity.notFound().build();
    }
}
