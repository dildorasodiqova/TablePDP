package uz.pdp.service.lessonService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.LessonCreateDTO;
import uz.pdp.DTO.responceDTO.AttendanceResponseDTO;
import uz.pdp.DTO.responceDTO.LessonResponseDTO;
import uz.pdp.Entity.AttendanceEntity;
import uz.pdp.Entity.GroupEntity;
import uz.pdp.Entity.LessonEntity;
import uz.pdp.Entity.UserEntity;
import uz.pdp.Entity.enums.LessonStatus;
import uz.pdp.exception.DataNotFoundException;
import uz.pdp.repository.LessonRepository;
import uz.pdp.service.BaseService;
import uz.pdp.service.attendanceService.AttendanceServiceImpl;
import uz.pdp.service.groupService.GroupServiceImpl;
import uz.pdp.service.userService.UserServiceImpl;
import uz.pdp.validator.AbstractValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LessonServiceImpl extends BaseService<
        LessonEntity,
        UUID,
        LessonRepository,
        LessonResponseDTO,
        LessonCreateDTO,
        AbstractValidator<LessonEntity, LessonRepository>
        > implements LessonService {

    private final AttendanceServiceImpl attendanceService;
    private final GroupServiceImpl groupService;
    private final UserServiceImpl userService;

    public LessonServiceImpl(LessonRepository repository, ModelMapper modelMapper, AttendanceServiceImpl attendanceService, GroupServiceImpl groupService, LessonRepository lessonRepository1, UserServiceImpl userService) {
        super(repository, new AbstractValidator<LessonEntity, LessonRepository>(repository) {
            @Override
            public void validate(LessonEntity entity) {
                super.validate(entity);
            }
        }, modelMapper);
        this.attendanceService = attendanceService;
        this.groupService = groupService;

        this.userService = userService;
    }

    @Override
    protected LessonResponseDTO mapEntityToRes(LessonEntity entity) {
        List<AttendanceEntity> byLessonId = attendanceService.getByLessonId(entity.getId());
        List<AttendanceResponseDTO> parse = attendanceService.parse(byLessonId);
        return new LessonResponseDTO(entity.getId(),
                entity.getModuleNumber(),
                entity.getGroup().getId(),
                entity.getLessonStatus().toString(),
                entity.getNumber(),
                parse);
    }
///hatolik bor

    @Override
    protected LessonEntity mapCRToEntity(LessonCreateDTO createReq) {
        GroupEntity group = groupService.getById(createReq.getGroupId());
        List<UserEntity> students = group.getStudents();
//        List<AttendanceEntity> list = attendanceService.studentsOfAttendance(students);
        return new LessonEntity(createReq.getModuleNumber(), group,LessonStatus.CREATED, createReq.getNumber());
    }

    @Override
    public List<LessonResponseDTO> parse(List<LessonEntity> lessons) {
        List<LessonResponseDTO> list = new ArrayList<>();
        for (LessonEntity lesson : lessons) {
            List<AttendanceEntity> list1 = attendanceService.getByLessonId(lesson.getId());
            List<AttendanceResponseDTO> attList = attendanceService.parse(list1);
            list.add(new LessonResponseDTO(lesson.getId(), lesson.getModuleNumber(), lesson.getGroup().getId(), lesson.getLessonStatus().toString(), lesson.getNumber(), attList));
        }
        return list;
    }

    @Override
    public List<LessonEntity> findLessonEntitiesByModule_Id(Integer moduleNumber) {
        return repository.findLessonEntitiesByModuleNumber(moduleNumber);
    }

    @Override
    public List<LessonEntity> createLesson(UUID groupId) {
        GroupEntity group = groupService.getById(groupId);
        List<LessonEntity> lessonEntities = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            LessonEntity save = repository.save(new LessonEntity(1, group, LessonStatus.CREATED, i, new ArrayList<>()));
            lessonEntities.add(save);
        }
        return lessonEntities;
    }

    @Override
    public LessonResponseDTO updateStatus(UUID lessonId, String status) {
        LessonEntity lesson = repository.findById(lessonId).orElseThrow(() -> new DataNotFoundException("Lesson not found"));
        lesson.setLessonStatus(LessonStatus.valueOf(status.toUpperCase()));
        return mapEntityToRes(lesson);
    }

    @Override
    public String start(UUID lessonId) {
        LessonEntity lesson = repository.findById(lessonId).orElseThrow(() -> new DataNotFoundException("Lesson not found"));
        if (lesson.getNumber() == 1 ) {
            Boolean aBoolean = LastLessonOfModule(lesson.getModuleNumber() - 1, lesson.getGroup().getId(), 12);
            if (aBoolean){
                 lesson.setLessonStatus(LessonStatus.STARTED);
                 repository.save(lesson);
                return "Successfully";
            }else {
                return "Last lesson did not finished";
            }
        }else if (lesson.getNumber() < 12){
            Boolean aBoolean = LastLessonOfModule(lesson.getModuleNumber(), lesson.getGroup().getId(), lesson.getNumber() - 1);
            if (aBoolean){
                lesson.setLessonStatus(LessonStatus.STARTED);
                repository.save(lesson);
                return "Successfully";
            }else {
                return "Last lesson did not finished";
            }
        }
        return "No such digital lesson exists";
    }

    @Override
    public Boolean LastLessonOfModule(int moduleNumber, UUID groupId, int lessonNumber) {
        LessonEntity lesson = repository.findLastLessonOfModule(groupId, moduleNumber, lessonNumber).orElseThrow(() -> new DataNotFoundException("Lesson not found"));
        if (lesson.getLessonStatus() == LessonStatus.COMPLETED ){
          return true;
        }
        return false;
    }

    @Override
    public String finished(UUID lessonId) {
        LessonEntity lesson = repository.findById(lessonId).orElseThrow(() -> new DataNotFoundException("Lesson not found"));
        if (lesson.getLessonStatus() == LessonStatus.STARTED){
            lesson.setLessonStatus(LessonStatus.COMPLETED);
            return "Successfully";
        }
        return "The lesson must be started to finish the lesson";
    }
}
