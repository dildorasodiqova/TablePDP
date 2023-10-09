package uz.pdp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.Entity.LessonEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LessonRepository extends JpaRepository<LessonEntity, UUID> {
    List<LessonEntity> findLessonEntitiesByModuleNumber(Integer moduleNumber);

    @Query("SELECT l FROM lessons l " +
            "INNER JOIN l.group g " +
            "WHERE g.id = :groupId " +
            "AND l.moduleNumber = :moduleNumber " +
            "AND l.number = :lessonNumber " +
            "ORDER BY l.id DESC limit 1")
    Optional<LessonEntity> findLastLessonOfModule(@Param("groupId") UUID groupId,
                                  @Param("moduleNumber") int moduleNumber,
                                  @Param("lessonNumber") int lessonNumber);
}
