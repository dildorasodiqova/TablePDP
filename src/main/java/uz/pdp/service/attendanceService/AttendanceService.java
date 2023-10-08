package uz.pdp.service.attendanceService;

import uz.pdp.DTO.responceDTO.AttendanceResponseDTO;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.Entity.AttendanceEntity;
import uz.pdp.Entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface AttendanceService {
    List<AttendanceEntity> getByLessonId(UUID id);

    List<AttendanceResponseDTO> parse(List<AttendanceEntity> list1);

//    List<AttendanceEntity> studentsOfAttendance(List<UserEntity> students);

    ArrayList<AttendanceResponseDTO> getAbsentStudent(GetAbsentStudents getAbsentStudents);

}
