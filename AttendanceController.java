package com.college.erp.controller;
import com.college.erp.model.Attendance;
import com.college.erp.service.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/attendance")
public class AttendanceController {
    private final AttendanceService service;
    public AttendanceController(AttendanceService service){this.service=service;}
    @GetMapping public List<Attendance> getAll(){return service.getAll();}
    @GetMapping("/{id}") public ResponseEntity<Attendance> getById(@PathVariable Long id){
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public ResponseEntity<Attendance> create(@RequestBody Attendance item){return ResponseEntity.ok(service.create(item));}
    @PutMapping("/{id}") public ResponseEntity<Attendance> update(@PathVariable Long id,@RequestBody Attendance d){
        return service.update(id,d).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){
        return service.delete(id)?ResponseEntity.noContent().build():ResponseEntity.notFound().build();
    }
}
