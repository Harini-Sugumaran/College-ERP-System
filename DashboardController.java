package com.college.erp.controller;
import com.college.erp.repository.*;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/dashboard")
public class DashboardController {
    private final StudentRepository students; private final TeacherRepository teachers;
    private final CourseRepository courses; private final AnnouncementRepository announcements;
    public DashboardController(StudentRepository s,TeacherRepository t,CourseRepository c,AnnouncementRepository a){
        students=s; teachers=t; courses=c; announcements=a;
    }
    @GetMapping("/summary")
    public Map<String,Long> summary(){
        return Map.of("students",students.count(),"teachers",teachers.count(),"courses",courses.count(),"announcements",announcements.count());
    }
}
