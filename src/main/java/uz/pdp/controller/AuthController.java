package uz.pdp.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.DTO.requestDTO.AuthDTO;
import uz.pdp.DTO.requestDTO.SignUpDTO;
import uz.pdp.DTO.requestDTO.UserCreateDTO;
import uz.pdp.DTO.responceDTO.JwtResponse;
import uz.pdp.service.userService.UserServiceImpl;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserServiceImpl userService;
    @PermitAll
    @PostMapping("/sign-up")
    public String auth (@RequestBody SignUpDTO dto) {
        userService.create(dto);
        return "Successfully signed up";
    }
    @PermitAll
    @PostMapping("/sign-in")
    public JwtResponse signIn (@RequestBody AuthDTO dto) {
        return userService.signIn(dto);
    }

}
