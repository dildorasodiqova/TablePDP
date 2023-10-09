package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.DTO.responceDTO.GroupResponseDTO;
import uz.pdp.DTO.responceDTO.LessonResponseDTO;
import uz.pdp.service.lessonService.LessonServiceImpl;

import java.util.List;
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

    @GetMapping("/getById")
    public ResponseEntity<LessonResponseDTO> getById(@RequestParam UUID lessonId ){
        return ResponseEntity.ok(lessonService.findById(lessonId));
    }

    @PutMapping("/start")
    public ResponseEntity<String> start(@RequestParam UUID lessonId){
        lessonService.start(lessonId);
        return ResponseEntity.ok("Successfully");
    }


    @PutMapping("/finished")
    public ResponseEntity<String> finished(@RequestParam UUID lessonId){
        lessonService.finished(lessonId);
        return ResponseEntity.ok("Successfully");
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<LessonResponseDTO>> getAll(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(lessonService.getAll(page, size));
    }


}
