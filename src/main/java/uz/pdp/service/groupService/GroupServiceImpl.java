package uz.pdp.service.groupService;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.GroupCreateDTO;
import uz.pdp.DTO.responceDTO.GroupResponseDTO;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.Entity.CourseEntity;
import uz.pdp.Entity.GroupEntity;
import uz.pdp.Entity.UserEntity;
import uz.pdp.Entity.enums.GroupStatus;
import uz.pdp.exception.DataNotFoundException;
import uz.pdp.repository.GroupRepository;
import uz.pdp.service.BaseService;
import uz.pdp.service.courseService.CourseServiceImpl;
import uz.pdp.service.userService.UserServiceImpl;
import uz.pdp.validator.AbstractValidator;
import uz.pdp.validator.CourseValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GroupServiceImpl extends BaseService<
        GroupEntity,
        UUID,
        GroupRepository,
        GroupResponseDTO,
        GroupCreateDTO,
        AbstractValidator<GroupEntity,GroupRepository>
        > implements GroupService{
    private final ModelMapper modelMapper;
    private  final UserServiceImpl userService;
    private final CourseServiceImpl courseService;

    public GroupServiceImpl(GroupRepository repository, ModelMapper modelMapper, ModelMapper modelMapper1, UserServiceImpl userService, CourseServiceImpl courseService) {
        super(repository, new AbstractValidator<GroupEntity, GroupRepository>(repository) {
            @Override
            public void validate(GroupEntity entity) {
                super.validate(entity);
            }
        }, modelMapper);
        this.modelMapper = modelMapper1;
        this.userService = userService;
        this.courseService = courseService;
    }


    @Override
    protected GroupResponseDTO mapEntityToRes(GroupEntity group) {
        List<UserEntity> students = group.getStudents();
        List<UserResponseDTO> parse = userService.parse(students);
        return new GroupResponseDTO(
                group.getId(),
                group.getGroupName(),
                group.getGroupStatus(),
                group.getMentor().getId(),
                group.getCourse().getId(),
                group.getStartDate(),parse);
    }

    public Optional<GroupEntity> getGroup(UUID groupId) {
        return repository.findById(groupId);
    }

    @Override
    public List<UserResponseDTO> getAllByUsersOfGroup(UUID groupId) {
        GroupEntity group = repository.findById(groupId).orElseThrow(() -> new DataNotFoundException("Group not found"));
        List<UserEntity> students = group.getStudents();
       return userService.parse(students);
    }

    @Override
    public GroupEntity getById(UUID groupId) {
        return repository.findById(groupId).orElseThrow(() -> new DataNotFoundException("Group not found"));
    }

    @Override
    public List<GroupResponseDTO> getByMentorId(UUID mentorId) {
        List<GroupEntity> all = repository.findAllByMentorId(mentorId);
        return parse(all);

    }

    @Override
    public String updateStatus(UUID groupId, String status) {
        GroupEntity group = repository.findById(groupId).orElseThrow(() -> new DataNotFoundException("Group not found"));
        if (status.toUpperCase().equals(GroupStatus.PROCESS.toString()) && group.getGroupStatus().equals(GroupStatus.NEW)){
            group.setGroupStatus(GroupStatus.PROCESS);
            repository.save(group);
            return "Successfully";
        }
        else if (status.toUpperCase().equals(GroupStatus.REASON.toString()) && group.getGroupStatus().equals(GroupStatus.PROCESS)){
            group.setGroupStatus(GroupStatus.REASON);
            repository.save(group);
            repository.save(group);
            return "Successfully";
        }
        else if (status.toUpperCase().equals(GroupStatus.FINISHED.toString()) && group.getGroupStatus().equals(GroupStatus.PROCESS)){
            group.setGroupStatus(GroupStatus.FINISHED);
            repository.save(group);
            repository.save(group);
            return "Successfully";
        }
        return "It is impossible to do this";
    }



    public List<GroupResponseDTO> parse(List<GroupEntity> all){
        List<GroupResponseDTO> list = new ArrayList<>();
        for (GroupEntity group : all) {
            List<UserEntity> students = group.getStudents();
            List<UserResponseDTO> parse = userService.parse(students);
            list.add(new GroupResponseDTO(group.getId(), group.getGroupName(), group.getGroupStatus(), group.getMentor().getId(), group.getCourse().getId(), group.getStartDate(),parse ));
        }
        return list;
    }



    @Override
    protected GroupEntity mapCRToEntity(GroupCreateDTO createReq) {
        UserEntity mentor = userService.getById(createReq.getMentorId());
        CourseEntity course = courseService.getByID(createReq.getCourseId());
        return new GroupEntity(createReq.getGroupName(), GroupStatus.NEW, mentor, course , createReq.getStartDate());
    }

}
