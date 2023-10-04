package uz.pdp.service.groupService;

import uz.pdp.Entity.GroupEntity;

import java.util.Optional;
import java.util.UUID;



public interface GroupService {
    Optional<GroupEntity> getGroup(UUID groupId);
}
