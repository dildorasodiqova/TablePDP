package uz.pdp.service.lessonService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.LessonCreateDTO;
import uz.pdp.DTO.responceDTO.LessonResponseDTO;
import uz.pdp.Entity.LessonEntity;
import uz.pdp.repository.LessonRepository;
import uz.pdp.service.BaseService;
import uz.pdp.validator.AbstractValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LessonServiceImpl extends BaseService<
        LessonEntity,
        UUID,
        LessonRepository,
        LessonResponseDTO,
        LessonCreateDTO,
        AbstractValidator<LessonEntity, LessonRepository>
        > implements LessonService{
    private final LessonRepository lessonRepository;
    public LessonServiceImpl(LessonRepository repository, ModelMapper modelMapper, LessonRepository lessonRepository) {
        super(repository, new AbstractValidator<LessonEntity, LessonRepository>() {
            @Override
            public void validate(LessonEntity entity) {
                super.validate(entity);
            }
        }, modelMapper);
        this.lessonRepository = lessonRepository;
    }

    @Override
    protected LessonResponseDTO mapEntityToRes(LessonEntity entity) {
        return null;
    }

    @Override
    protected LessonEntity mapCRToEntity(LessonCreateDTO createReq) {
        return null;
    }

    @Override
    public List<LessonResponseDTO> parse(List<LessonEntity> lessons) {
        List<LessonResponseDTO> list = new ArrayList<>();
        for (LessonEntity lesson : lessons) {
            list.add(new LessonResponseDTO(lesson.getId(),lesson.getModule().getModuleName(), lesson.getModule().getId(),lesson.getDate(), lesson.getTopicName()));
        }
        return list;
    }

    @Override
    public List<LessonEntity> findLessonEntitiesByModule_Id(UUID module_id) {
        return lessonRepository.findLessonEntitiesByModule_Id(module_id);
    }
}
