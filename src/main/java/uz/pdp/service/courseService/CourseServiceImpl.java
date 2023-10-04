package uz.pdp.service.courseService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.CourseCreateDTO;
import uz.pdp.DTO.responceDTO.CourseResponseDTO;
import uz.pdp.Entity.CourseEntity;
import uz.pdp.repository.CourseRepository;
import uz.pdp.service.BaseService;
import uz.pdp.validator.AbstractValidator;

import java.util.UUID;

@Service
public class CourseServiceImpl extends BaseService<
        CourseEntity,
        UUID,
        CourseRepository,
        CourseResponseDTO,
        CourseCreateDTO,
        AbstractValidator<CourseEntity, CourseRepository>
        > implements CourseService{
    public CourseServiceImpl(CourseRepository repository, AbstractValidator<CourseEntity, CourseRepository> validator, ModelMapper modelMapper) {
        super(repository, validator, modelMapper);
    }

    @Override
    protected CourseResponseDTO mapEntityToRes(CourseEntity entity) {
        return null;
    }

    @Override
    protected CourseEntity mapCRToEntity(CourseCreateDTO createReq) {
        return null;
    }
}
