package uz.pdp.service.attendanceService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.AttendanceCreateDTO;
import uz.pdp.DTO.responceDTO.AttendanceResponseDTO;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.Entity.AttendanceEntity;
import uz.pdp.Entity.GroupEntity;
import uz.pdp.Entity.UserEntity;
import uz.pdp.exception.DidNotComeAttendancesNotFound;
import uz.pdp.repository.AttendanceRepository;
import uz.pdp.service.BaseService;

import uz.pdp.service.groupService.GroupServiceImpl;
import uz.pdp.validator.AbstractValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class AttendanceServiceImpl extends BaseService<
        AttendanceEntity,
        UUID,
        AttendanceRepository,
        AttendanceResponseDTO,
        AttendanceCreateDTO,
        AbstractValidator<AttendanceEntity,AttendanceRepository>
        >implements AttendanceService{

    private final GroupServiceImpl groupService ;
    private final AttendanceRepository attendanceRepository ;

    public AttendanceServiceImpl(AttendanceRepository repository, ModelMapper modelMapper, GroupServiceImpl groupService, AttendanceRepository attendanceRepository) {
        super(repository, new AbstractValidator<AttendanceEntity, AttendanceRepository>() {
            @Override
            public void validate(AttendanceEntity entity) {
                super.validate(entity);
            }
        }, modelMapper);
        this.groupService = groupService;
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    protected AttendanceResponseDTO mapEntityToRes(AttendanceEntity entity) {
        return null;
    }

    @Override
    protected AttendanceEntity mapCRToEntity(AttendanceCreateDTO createReq) {
        return null;
    }

    @Override
    public ArrayList<UserResponseDTO> getDidntComeUsers(UUID groupId) {

        Optional<GroupEntity> group = groupService.getGroup(groupId);

        if (group.isPresent()){
            ArrayList<UserResponseDTO> userResponseDTOS = new ArrayList<>();
            ArrayList<UserEntity> didNotComeAttendancesByGroup = attendanceRepository.findUsersWithDidNotComeStatusByGroup(group.get());
            for (UserEntity userEntity : didNotComeAttendancesByGroup) {
                UserResponseDTO userResponseDTO = modelMapper.map(userEntity, UserResponseDTO.class);
                userResponseDTOS.add(userResponseDTO);
            }
            return userResponseDTOS ;

        }

        throw new DidNotComeAttendancesNotFound("Users not found");

    }

    @Override
    public List<AttendanceEntity> getByLessonId(UUID lessonId) {
        return attendanceRepository.findAllByLessonId(lessonId);
    }

    @Override
    public List<AttendanceResponseDTO> parse(List<AttendanceEntity> list1) {
        List<AttendanceResponseDTO> list = new ArrayList<>();
        for (AttendanceEntity attendance : list1) {
            list.add(new AttendanceResponseDTO(attendance.getId(), attendance.getUser().getId(),attendance.getUser().getName(), attendance.getLesson().getId(), attendance.getReason(), attendance.getGroup().getId(),attendance.getGroup().getGroupName(), attendance.getStatus().toString() ));
        }
        return list;
    }
}
