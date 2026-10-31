package com.college.erp.controller;
import com.college.erp.model.Mark;
import com.college.erp.service.MarkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/marks")
public class MarkController {
    private final MarkService service;
    public MarkController(MarkService service){this.service=service;}
    @GetMapping public List<Mark> getAll(){return service.getAll();}
    @GetMapping("/{id}") public ResponseEntity<Mark> getById(@PathVariable Long id){
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public ResponseEntity<Mark> create(@RequestBody Mark item){return ResponseEntity.ok(service.create(item));}
    @PutMapping("/{id}") public ResponseEntity<Mark> update(@PathVariable Long id,@RequestBody Mark d){
        return service.update(id,d).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){
        return service.delete(id)?ResponseEntity.noContent().build():ResponseEntity.notFound().build();
    }
}
