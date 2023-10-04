package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.Entity.AttendanceEntity;
import uz.pdp.Entity.GroupEntity;
import uz.pdp.Entity.UserEntity;

import java.util.ArrayList;
import java.util.UUID;
@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, UUID> {

    @Query("SELECT a.user FROM attendances a WHERE a.status = 'DIDNOTCOME' AND a.group = :group")
    ArrayList<UserEntity> findUsersWithDidNotComeStatusByGroup( GroupEntity group);
}
