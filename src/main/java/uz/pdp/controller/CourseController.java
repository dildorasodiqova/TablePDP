package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.DTO.requestDTO.CourseCreateDTO;
import uz.pdp.DTO.responceDTO.CourseResponseDTO;
import uz.pdp.service.courseService.CourseServiceImpl;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseServiceImpl courseService;
    @PostMapping
    public CourseResponseDTO create(@RequestBody CourseCreateDTO dto ) {
        return courseService.create(dto);
    }
}
