package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.service.attendanceService.AttendanceServiceImpl;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceServiceImpl attendanceService ;

    @GetMapping("/get-didnt-come")
    public ArrayList<UserResponseDTO> getDidntComeUsers(@RequestParam UUID groupId){
        ArrayList<UserResponseDTO> userResponseDTOS = attendanceService.getDidntComeUsers(groupId);

        return userResponseDTOS ;

    }
}
