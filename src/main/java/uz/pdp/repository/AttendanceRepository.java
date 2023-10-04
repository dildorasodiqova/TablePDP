package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.Entity.Attendance;

import java.util.UUID;
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, UUID> {
}
