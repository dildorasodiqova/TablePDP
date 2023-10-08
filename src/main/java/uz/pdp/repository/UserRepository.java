package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.Entity.UserEntity;
import uz.pdp.Entity.enums.UserRole;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByPhoneNumber(String phoneNumber);
    List<UserEntity> getAllByRole(UserRole role);
}
