package uz.pdp.service.userService;

import uz.pdp.Entity.UserEntity;

import java.util.UUID;

import uz.pdp.DTO.requestDTO.AuthDTO;
import uz.pdp.DTO.responceDTO.JwtResponse;

public interface UserService {
    UserEntity getById(UUID id);
    JwtResponse signIn(AuthDTO dto);
}
