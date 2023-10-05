package uz.pdp.service.moduleService;

import uz.pdp.DTO.responceDTO.LessonResponseDTO;
import uz.pdp.Entity.LessonEntity;
import uz.pdp.repository.LessonRepository;

import java.util.List;
import java.util.UUID;

public interface ModuleService {
    List<LessonResponseDTO> getAllByModuleOfLesson(UUID moduleId);

}
