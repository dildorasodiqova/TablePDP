package uz.pdp.service.attendanceService;

import uz.pdp.DTO.responceDTO.UserResponseDTO;

import java.util.ArrayList;
import java.util.UUID;

public interface AttendanceService {
    ArrayList<UserResponseDTO> getDidntComeUsers(UUID groupId);


}
