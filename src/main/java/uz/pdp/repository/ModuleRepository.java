package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.Entity.ModuleEntity;


import java.util.UUID;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, UUID> {
}
