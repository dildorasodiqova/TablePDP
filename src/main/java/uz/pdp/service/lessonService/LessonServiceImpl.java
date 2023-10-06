package uz.pdp.service.lessonService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.LessonCreateDTO;
import uz.pdp.DTO.responceDTO.LessonResponseDTO;
import uz.pdp.Entity.BaseEntity;
import uz.pdp.Entity.LessonEntity;
import uz.pdp.repository.LessonRepository;
import uz.pdp.service.BaseService;
import uz.pdp.validator.AbstractValidator;

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
    public LessonServiceImpl(LessonRepository repository,  ModelMapper modelMapper) {
        super(repository, new AbstractValidator<LessonEntity, LessonRepository>(repository) {
            @Override
            public void validate(LessonEntity entity) {
                super.validate(entity);
            }
        }, modelMapper);
    }

    @Override
    protected LessonResponseDTO mapEntityToRes(LessonEntity entity) {
        return null;
    }

    @Override
    protected LessonEntity mapCRToEntity(LessonCreateDTO createReq) {
        return null;
    }
}
