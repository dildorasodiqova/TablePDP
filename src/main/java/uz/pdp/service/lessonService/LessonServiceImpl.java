package uz.pdp.service.lessonService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.LessonCreateDTO;
import uz.pdp.DTO.responceDTO.AttendanceResponseDTO;
import uz.pdp.DTO.responceDTO.GroupResponseDTO;
import uz.pdp.DTO.responceDTO.LessonResponseDTO;
import uz.pdp.Entity.AttendanceEntity;
import uz.pdp.Entity.GroupEntity;
import uz.pdp.Entity.LessonEntity;
import uz.pdp.Entity.enums.LessonStatus;
import uz.pdp.repository.LessonRepository;
import uz.pdp.service.BaseService;
import uz.pdp.service.attendanceService.AttendanceServiceImpl;
import uz.pdp.service.groupService.GroupServiceImpl;
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
        > implements LessonService{

    private final AttendanceServiceImpl attendanceService;
    private final GroupServiceImpl groupService;
    public LessonServiceImpl(LessonRepository repository, ModelMapper modelMapper, LessonRepository lessonRepository, AttendanceServiceImpl attendanceService, GroupServiceImpl groupService) {
        super(repository, new AbstractValidator<LessonEntity, LessonRepository>() {
            @Override
            public void validate(LessonEntity entity) {
                super.validate(entity);
            }
        }, modelMapper);
        this.lessonRepository = lessonRepository;
        this.attendanceService = attendanceService;
        this.groupService = groupService;
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
                parse );
    }

    @Override
    protected LessonEntity mapCRToEntity(LessonCreateDTO createReq) {
//        GroupEntity group = groupService.getById(createReq.getGroupId());
//        attendanceService.getByLessonId(createReq)
//        return new LessonEntity(createReq.getModuleNumber(), group,LessonStatus.CREATED, createReq.getNumber(), );
        return null;
    }

    @Override
    public List<LessonResponseDTO> parse(List<LessonEntity> lessons) {
        List<LessonResponseDTO> list = new ArrayList<>();
        for (LessonEntity lesson : lessons) {
            List<AttendanceEntity> list1 =  attendanceService.getByLessonId(lesson.getId());
            List<AttendanceResponseDTO>  attList = attendanceService.parse(list1);
            list.add(new LessonResponseDTO(lesson.getId(), lesson.getModuleNumber(),  lesson.getGroup().getId(), lesson.getLessonStatus().toString(), lesson.getNumber(),attList ));
        }
        return list;
    }

    @Override
    public List<LessonEntity> findLessonEntitiesByModule_Id(Integer moduleNumber) {
        return lessonRepository.findLessonEntitiesByModuleNumber(moduleNumber);
    }

    @Override
    public List<LessonEntity> createLesson(UUID groupId) {
        GroupEntity group = groupService.getById(groupId);
        List<LessonEntity> lessonEntities = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            LessonEntity save = lessonRepository.save(new LessonEntity(1, group, LessonStatus.CREATED, i, new ArrayList<>()));
            lessonEntities.add(save);
        }
        return lessonEntities;
    }
}
