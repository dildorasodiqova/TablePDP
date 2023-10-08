package uz.pdp.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.DTO.requestDTO.GetAbsentStudents;
import uz.pdp.DTO.responceDTO.AttendanceResponseDTO;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.service.attendanceService.AttendanceServiceImpl;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceServiceImpl attendanceService ;
    @PermitAll
    @GetMapping("/absent-students")
    public ArrayList<AttendanceResponseDTO> getDidntComeUsers(@RequestBody GetAbsentStudents getAbsentStudents){
        return attendanceService.getAbsentStudent(getAbsentStudents);

    }


}
