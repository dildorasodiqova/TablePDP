package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @PostMapping
    public CourseResponseDTO create(@RequestBody CourseCreateDTO dto ) {
        return courseService.create(dto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam UUID courseId){
        courseService.deleteById(courseId);
        return ResponseEntity.ok("Successfully");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CourseResponseDTO>> getAll(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(courseService.getAll(page, size));
    }

}
