package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.Entity.Attendance;
import uz.pdp.Entity.Lesson;

import java.util.UUID;

@Repository
public interface LessonRepository  extends JpaRepository<Lesson, UUID> {
}
