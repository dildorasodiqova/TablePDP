package uz.pdp.service.groupService;

import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.Entity.GroupEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



public interface GroupService {
    Optional<GroupEntity> getGroup(UUID groupId);
    List<UserResponseDTO> getAllByGroupOfUsers(UUID groupId);
}
