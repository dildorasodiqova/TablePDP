package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.DTO.requestDTO.GroupCreateDTO;
import uz.pdp.DTO.responceDTO.GroupResponseDTO;
import uz.pdp.Entity.LessonEntity;
import uz.pdp.service.groupService.GroupServiceImpl;
import uz.pdp.service.lessonService.LessonServiceImpl;

import java.security.Principal;
import java.util.List;

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
}
