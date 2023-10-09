package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.DTO.requestDTO.GroupCreateDTO;
import uz.pdp.DTO.responceDTO.CourseResponseDTO;
import uz.pdp.DTO.responceDTO.GroupResponseDTO;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.Entity.LessonEntity;
import uz.pdp.service.groupService.GroupServiceImpl;
import uz.pdp.service.lessonService.LessonServiceImpl;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {
    private final GroupServiceImpl groupService;
    private final LessonServiceImpl lessonService;
    @PreAuthorize("hasRole('ADMIN') and hasAuthority('GROUP_CREATE') or hasRole('SUPER_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<GroupResponseDTO> create(@RequestBody GroupCreateDTO groupCreateDTO) {
        GroupResponseDTO groupResponseDTO = groupService.create(groupCreateDTO);
        List<LessonEntity> lesson = lessonService.createLesson(groupResponseDTO.getGroupId());
//        GroupResponseDTO gr = groupService.createLessonOfGroup(groupResponseDTO.getGroupId(), lesson);
        return ResponseEntity.ok(groupResponseDTO);
    }
    @PreAuthorize("hasRole('ADMIN') and hasAuthority('GROUP_CREATE') or hasRole('SUPER_ADMIN')")
    @GetMapping("/getById")
    public ResponseEntity<GroupResponseDTO> getById (@RequestParam UUID groupId){
        return ResponseEntity.ok(groupService.findById(groupId));
    }
    @PreAuthorize("hasRole('ADMIN') and hasAuthority('GROUP_CREATE') or hasRole('SUPER_ADMIN')")
    @GetMapping("/getAllByGroupOfMentor")
    public ResponseEntity<List<GroupResponseDTO>> getGroupsOfMentor(@RequestParam UUID mentorId){
        return ResponseEntity.ok(groupService.getByMentorId(mentorId));
    }
    @PreAuthorize("hasRole('ADMIN') and hasAuthority('GROUP_CREATE') or hasRole('SUPER_ADMIN')")
    @GetMapping("/getUsersOfGroup")
    public ResponseEntity<List<UserResponseDTO>> getAllByUsersOfGroup(@RequestParam  UUID groupId){
        return ResponseEntity.ok(groupService.getAllByUsersOfGroup(groupId));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam UUID groupId){
        groupService.deleteById(groupId);
        return ResponseEntity.ok("Successfully");
    }


    @PutMapping("/updateGroup")
    public ResponseEntity<String > startGroup(@RequestParam UUID groupId, @RequestParam  String status){
         return ResponseEntity.ok(groupService.updateStatus(groupId, status));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<GroupResponseDTO>> getAll(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(groupService.getAll(page, size));
    }




}
