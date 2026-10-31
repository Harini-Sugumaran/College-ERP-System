package com.college.erp.controller;
import com.college.erp.model.Announcement;
import com.college.erp.service.AnnouncementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/announcements")
public class AnnouncementController {
    private final AnnouncementService service;
    public AnnouncementController(AnnouncementService service){this.service=service;}
    @GetMapping public List<Announcement> getAll(){return service.getAll();}
    @GetMapping("/{id}") public ResponseEntity<Announcement> getById(@PathVariable Long id){
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public ResponseEntity<Announcement> create(@RequestBody Announcement item){return ResponseEntity.ok(service.create(item));}
    @PutMapping("/{id}") public ResponseEntity<Announcement> update(@PathVariable Long id,@RequestBody Announcement d){
        return service.update(id,d).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){
        return service.delete(id)?ResponseEntity.noContent().build():ResponseEntity.notFound().build();
    }
}
