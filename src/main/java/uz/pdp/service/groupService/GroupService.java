package uz.pdp.service.groupService;

import org.springframework.http.ResponseEntity;
import uz.pdp.DTO.responceDTO.GroupResponseDTO;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.Entity.GroupEntity;
import uz.pdp.Entity.LessonEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



public interface GroupService {
    Optional<GroupEntity> getGroup(UUID groupId);
    List<UserResponseDTO> getAllByUsersOfGroup(UUID groupId);

    GroupEntity getById(UUID groupId);
    List<GroupResponseDTO> getByMentorId(UUID mentorId);

    String updateStatus(UUID groupId, String status);


//    GroupResponseDTO createLessonOfGroup(UUID , List<LessonEntity> );

//    Optional<GroupEntity> getById(UUID groupId);
}
