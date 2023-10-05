package uz.pdp.service.attendanceService;

import uz.pdp.DTO.requestDTO.GetAbsentStudents;
import uz.pdp.DTO.responceDTO.AttendanceResponseDTO;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.Entity.AttendanceEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface AttendanceService {
    List<AttendanceEntity> getByLessonId(UUID id);

    List<AttendanceResponseDTO> parse(List<AttendanceEntity> list1);

    ArrayList<AttendanceResponseDTO> getAbsentStudent(GetAbsentStudents getAbsentStudents);

}
