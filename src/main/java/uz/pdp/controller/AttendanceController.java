package uz.pdp.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.DTO.requestDTO.GetAbsentStudents;
import uz.pdp.DTO.responceDTO.AttendanceResponseDTO;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.service.attendanceService.AttendanceServiceImpl;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendance")
public class AttendanceController {
    private final AttendanceServiceImpl attendanceService ;
    @PermitAll
    @GetMapping("/absent-students")
    public ArrayList<AttendanceResponseDTO> getDidntComeUsers(@RequestBody GetAbsentStudents getAbsentStudents){
        return attendanceService.getAbsentStudent(getAbsentStudents);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam UUID attendanceId){
        attendanceService.deleteById(attendanceId);
        return ResponseEntity.ok("Successfully");
    }


}
