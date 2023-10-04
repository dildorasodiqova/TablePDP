package uz.pdp.service.userService;

import uz.pdp.DTO.requestDTO.AuthDTO;
import uz.pdp.DTO.responceDTO.JwtResponse;

public interface UserService {
    JwtResponse signIn(AuthDTO dto);
}
