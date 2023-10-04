package uz.pdp.service.groupService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.GroupCreateDTO;
import uz.pdp.DTO.responceDTO.GroupResponseDTO;
import uz.pdp.Entity.CourseEntity;
import uz.pdp.Entity.GroupEntity;
import uz.pdp.Entity.UserEntity;
import uz.pdp.Entity.enums.GroupStatus;
import uz.pdp.repository.GroupRepository;
import uz.pdp.service.BaseService;
import uz.pdp.service.courseService.CourseServiceImpl;
import uz.pdp.service.userService.UserServiceImpl;
import uz.pdp.validator.AbstractValidator;

import java.util.Optional;
import java.util.UUID;

@Service
public class GroupServiceImpl extends BaseService<
        GroupEntity,
        UUID,
        GroupRepository,
        GroupResponseDTO,
        GroupCreateDTO,
        AbstractValidator<GroupEntity, GroupRepository>
        > implements GroupService{
    private final ModelMapper modelMapper;
    private final GroupRepository groupRepository;
    private  final UserServiceImpl userService;
    private final CourseServiceImpl courseService;
    public GroupServiceImpl(GroupRepository repository, ModelMapper modelMapper, ModelMapper modelMapper1, GroupRepository groupRepository, UserServiceImpl userService, CourseServiceImpl courseService) {
        super(repository, new AbstractValidator<GroupEntity, GroupRepository>() {
            @Override
            public void validate(GroupEntity entity) {
                super.validate(entity);
            }
        }, modelMapper);
        this.modelMapper = modelMapper1;
        this.groupRepository = groupRepository;
        this.userService = userService;
        this.courseService = courseService;
    }

    @Override
    protected GroupResponseDTO mapEntityToRes(GroupEntity group) {
       return new GroupResponseDTO(group.getId(), group.getGroupName(), group.getGroupStatus(), group.getMentor().getId(), group.getMentor().getName(),group.getCourse().getId(), group.getCourse().getCourseName(),group.getStartDate());
    public Optional<GroupEntity> getGroup(UUID groupId) {

        return groupRepository.findById(groupId);
    }
    protected GroupResponseDTO mapEntityToRes(GroupEntity entity) {
        return null;
    }

    @Override
    protected GroupEntity mapCRToEntity(GroupCreateDTO createReq) {
        UserEntity mentor = userService.getById(createReq.getMentorId());
        CourseEntity course = courseService.getByID(createReq.getCourseId());
        return new GroupEntity(createReq.getGroupName(), GroupStatus.NEW, mentor, course , createReq.getStartDate());
    }

}
