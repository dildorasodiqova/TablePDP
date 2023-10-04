package uz.pdp.service.courseService;

import uz.pdp.Entity.CourseEntity;

import java.util.UUID;

public interface CourseService {
    CourseEntity getByID(UUID id);
}
