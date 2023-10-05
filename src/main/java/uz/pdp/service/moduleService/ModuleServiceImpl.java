package uz.pdp.service.moduleService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.ModuleCreateDTO;
import uz.pdp.DTO.responceDTO.LessonResponseDTO;
import uz.pdp.DTO.responceDTO.ModuleResponseDTO;
import uz.pdp.Entity.LessonEntity;
import uz.pdp.Entity.ModuleEntity;
import uz.pdp.repository.LessonRepository;
import uz.pdp.repository.ModuleRepository;
import uz.pdp.service.BaseService;
import uz.pdp.service.lessonService.LessonServiceImpl;
import uz.pdp.validator.ModuleValidator;

import java.util.List;
import java.util.UUID;

@Service
public class ModuleServiceImpl extends BaseService<
        ModuleEntity,
        UUID,
        ModuleRepository,
        ModuleResponseDTO,
        ModuleCreateDTO,
        ModuleValidator
        > implements ModuleService{
    private final ModelMapper modelMapper;
    private final ModuleRepository moduleRepository;
    private final LessonServiceImpl lessonService;
    public ModuleServiceImpl(ModuleRepository repository, ModuleValidator validator, ModelMapper modelMapper, ModelMapper modelMapper1, ModuleRepository moduleRepository, LessonServiceImpl lessonService) {
        super(repository, validator, modelMapper);
        this.modelMapper = modelMapper1;
        this.moduleRepository = moduleRepository;

        this.lessonService = lessonService;
    }

    @Override
    protected ModuleResponseDTO mapEntityToRes(ModuleEntity entity) {
        return modelMapper.map(entity, ModuleResponseDTO.class);

    }

    @Override
    protected ModuleEntity mapCRToEntity(ModuleCreateDTO createReq) {
        return new ModuleEntity(createReq.getModuleName());
    }

    @Override
    public List<LessonResponseDTO> getAllByModuleOfLesson(UUID moduleId) {
        List<LessonEntity> lessons = lessonService.findLessonEntitiesByModule_Id(moduleId);
        return lessonService.parse(lessons);
    }
}
