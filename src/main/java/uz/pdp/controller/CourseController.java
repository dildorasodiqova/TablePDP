package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.DTO.requestDTO.CourseCreateDTO;
import uz.pdp.DTO.responceDTO.CourseResponseDTO;
import uz.pdp.service.courseService.CourseServiceImpl;

import java.util.List;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private final CourseServiceImpl courseService;
    @PreAuthorize("hasRole('ADMIN') and hasAuthority('COURSE_CREATE')")
    @PostMapping
    public CourseResponseDTO create(@RequestBody CourseCreateDTO dto ) {
        return courseService.create(dto);
    }
    @PreAuthorize("hasRole('ADMIN') and hasAuthority('COURSE_READ') or hasRole('SUPER_ADMIN')")
    @GetMapping
    public List<CourseResponseDTO> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size
    ) {
        return courseService.getAll(page, size);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam UUID courseId){
        courseService.deleteById(courseId);
        return ResponseEntity.ok("Successfully");
    }
}

