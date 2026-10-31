package com.college.erp.controller;
import com.college.erp.model.Course;
import com.college.erp.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;
    public CourseController(CourseService service){this.service=service;}
    @GetMapping public List<Course> getAll(){return service.getAll();}
    @GetMapping("/{id}") public ResponseEntity<Course> getById(@PathVariable Long id){
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public ResponseEntity<Course> create(@RequestBody Course item){return ResponseEntity.ok(service.create(item));}
    @PutMapping("/{id}") public ResponseEntity<Course> update(@PathVariable Long id,@RequestBody Course d){
        return service.update(id,d).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){
        return service.delete(id)?ResponseEntity.noContent().build():ResponseEntity.notFound().build();
    }
}
