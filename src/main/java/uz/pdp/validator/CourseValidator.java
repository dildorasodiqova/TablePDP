package uz.pdp.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import uz.pdp.Entity.CourseEntity;
import uz.pdp.exception.DataAlreadyExistsException;
import uz.pdp.repository.CourseRepository;

import java.util.Optional;

@Component
@Slf4j
public class CourseValidator extends AbstractValidator<CourseEntity, CourseRepository>{
    @Override
    public void validate(CourseEntity entity) {
        log.info("validating" + entity.getClass().getName());
        Optional<CourseEntity> courseName = repository.findByCourseName(entity.getCourseName());
        if(courseName.isPresent()) {
            throw new DataAlreadyExistsException("Course already exists with name: "+entity.getCourseName());
        }
        log.info("validated" + entity.getClass().getName());
    }

    public CourseValidator(CourseRepository repository) {
        super(repository);
    }
}
