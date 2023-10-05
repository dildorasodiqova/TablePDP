package uz.pdp.service.lessonService;

import uz.pdp.DTO.responceDTO.LessonResponseDTO;
import uz.pdp.Entity.LessonEntity;

import java.util.List;
import java.util.UUID;

public interface LessonService {
    List<LessonResponseDTO> parse(List<LessonEntity> lessons);
    List<LessonEntity> findLessonEntitiesByModule_Id(UUID module_id);
}
