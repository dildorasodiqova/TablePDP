package uz.pdp.service.userService;

import uz.pdp.DTO.requestDTO.UserCreateDTO;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.Entity.UserEntity;

import java.util.List;
import java.util.UUID;

import uz.pdp.DTO.requestDTO.AuthDTO;
import uz.pdp.DTO.responceDTO.JwtResponse;

public interface UserService {
    UserEntity getById(UUID id);
    JwtResponse signIn(AuthDTO dto);

    UserResponseDTO addUser(UserCreateDTO dto);

    String updateRole(UUID userId, String role);

    List<UserResponseDTO> getAllByRole(String role);

}
