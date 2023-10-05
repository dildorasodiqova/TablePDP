package uz.pdp.service.attendanceService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.AttendanceCreateDTO;
import uz.pdp.DTO.requestDTO.GetAbsentStudents;
import uz.pdp.DTO.responceDTO.AttendanceResponseDTO;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.Entity.AttendanceEntity;
import uz.pdp.Entity.GroupEntity;
import uz.pdp.Entity.UserEntity;
import uz.pdp.exception.AbsentStudentsNotFound;
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
    public ArrayList<AttendanceResponseDTO> getAbsentStudent(GetAbsentStudents getAbsentStudents) {

        Optional<GroupEntity> group = groupService.getGroup(getAbsentStudents.getGroupId());
        Integer moduleNum = getAbsentStudents.getModuleNum();
        Integer lessonNum = getAbsentStudents.getLessonNum();

        ArrayList<AttendanceEntity> attendanceEntities = attendanceRepository.getAbsentStudents(group.get(), moduleNum , lessonNum);
        if (!attendanceEntities.isEmpty()){
            ArrayList<AttendanceResponseDTO> attendanceResponseDTOArrayList = new ArrayList<>();

            for (AttendanceEntity attendanceEntity : attendanceEntities) {
                AttendanceResponseDTO attendanceResponseDTO = new AttendanceResponseDTO(attendanceEntity.getUser().getId(),
                        attendanceEntity.getUser().getUsername(), attendanceEntity.getReason() , attendanceEntity.getStatus().toString());
                attendanceResponseDTOArrayList.add(attendanceResponseDTO);
            }
            return attendanceResponseDTOArrayList ;
        }
        throw new AbsentStudentsNotFound("Absent students not found !");
    }


    @Override
    public List<AttendanceEntity> getByLessonId(UUID lessonId) {
        return attendanceRepository.findAllByLessonId(lessonId);
    }

    @Override
    public List<AttendanceResponseDTO> parse(List<AttendanceEntity> list1) {
        List<AttendanceResponseDTO> list = new ArrayList<>();
        for (AttendanceEntity attendance : list1) {
            list.add(new AttendanceResponseDTO(attendance.getUser().getId(),
                    attendance.getUser().getUsername(),
                    attendance.getReason(),
                    attendance.getStatus().toString()));
        }
        return list;
    }
}
