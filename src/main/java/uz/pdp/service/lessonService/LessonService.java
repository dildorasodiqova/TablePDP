package uz.pdp.service.lessonService;

import uz.pdp.DTO.responceDTO.LessonResponseDTO;
import uz.pdp.Entity.LessonEntity;

import java.util.List;
import java.util.UUID;

public interface LessonService {
    List<LessonResponseDTO> parse(List<LessonEntity> lessons);
    List<LessonEntity> findLessonEntitiesByModule_Id(Integer moduleNumber);

    List<LessonEntity> createLesson(UUID groupId);
    LessonResponseDTO updateStatus(UUID lessonId, String status);

    String start(UUID lessonId);
    Boolean LastLessonOfModule(int i, UUID id, int lessonNumber);

    String finished(UUID lessonId);
}
