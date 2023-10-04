package uz.pdp.service.attendanceService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.AttendanceCreateDTO;
import uz.pdp.DTO.requestDTO.LessonCreateDTO;
import uz.pdp.DTO.responceDTO.AttendanceResponseDTO;
import uz.pdp.DTO.responceDTO.LessonResponseDTO;
import uz.pdp.Entity.AttendanceEntity;
import uz.pdp.repository.AttendanceRepository;
import uz.pdp.repository.LessonRepository;
import uz.pdp.service.BaseService;
import uz.pdp.validator.AbstractValidator;

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


    public AttendanceServiceImpl(AttendanceRepository repository, AbstractValidator<AttendanceEntity, AttendanceRepository> validator, ModelMapper modelMapper) {
        super(repository, validator, modelMapper);
    }

    @Override
    protected AttendanceResponseDTO mapEntityToRes(AttendanceEntity entity) {
        return null;
    }

    @Override
    protected AttendanceEntity mapCRToEntity(AttendanceCreateDTO createReq) {
        return null;
    }
}
