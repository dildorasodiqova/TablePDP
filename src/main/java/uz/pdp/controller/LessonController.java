package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.service.lessonService.LessonServiceImpl;

import java.util.UUID;

@RestController
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {
    private final LessonServiceImpl lessonService;
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam UUID lessonId){
        lessonService.deleteById(lessonId);
        return ResponseEntity.ok("Successfully");
    }



}
