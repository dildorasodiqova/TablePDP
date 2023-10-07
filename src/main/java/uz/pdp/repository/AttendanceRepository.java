package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.Entity.AttendanceEntity;
import uz.pdp.Entity.GroupEntity;
import uz.pdp.Entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, UUID> {
    @Query("SELECT a FROM AttendanceEntity a WHERE a.lesson.number = :lessonNum AND a.group = :group and a.lesson.moduleNumber = :moduleNum and a.status = : status" )
    ArrayList<AttendanceEntity> getAbsentStudents(@Param("group") GroupEntity group, @Param("moduleNum") Integer moduleNum, @Param("lessonNum") Integer lessonNum , @Param("status") String status);
    List<AttendanceEntity> findAllByLessonId(UUID lesson_id);


}
