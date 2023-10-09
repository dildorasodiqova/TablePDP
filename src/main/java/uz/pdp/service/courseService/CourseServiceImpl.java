package uz.pdp.service.courseService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.CourseCreateDTO;
import uz.pdp.DTO.responceDTO.CourseResponseDTO;
import uz.pdp.Entity.CourseEntity;
import uz.pdp.exception.DataNotFoundException;
import uz.pdp.repository.CourseRepository;
import uz.pdp.service.BaseService;
import uz.pdp.validator.CourseValidator;

import java.util.UUID;

@Service
public class CourseServiceImpl extends BaseService<
        CourseEntity,
        UUID,
        CourseRepository,
        CourseResponseDTO,
        CourseCreateDTO,
        CourseValidator
        > implements CourseService{

    public CourseServiceImpl(CourseRepository repository, ModelMapper modelMapper, CourseValidator validator) {
        super(repository, validator, modelMapper);
    }

    @Override
    protected CourseResponseDTO mapEntityToRes(CourseEntity entity) {
        return new CourseResponseDTO(entity.getId(), entity.getCourseName(),entity.getModules(), entity.getPrice());
    }

    @Override
    protected CourseEntity mapCRToEntity(CourseCreateDTO createReq) {
        return new CourseEntity(createReq.getCourseName(), createReq.getModules(), createReq.getPrice());
    }

    @Override
    public CourseEntity getByID(UUID id) {
        return  repository.findById(id).orElseThrow(()->new DataNotFoundException("Course not found"));
    }
}
