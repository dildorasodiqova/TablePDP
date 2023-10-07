package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.DTO.requestDTO.UserCreateDTO;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.service.userService.UserServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    @PostMapping
    public UserResponseDTO addUser(UserCreateDTO dto) {
        return userService.addUser(dto);
    }
    @PutMapping
    public String updateRole(
            @RequestParam String role,
            @RequestParam UUID userId
            ) {
        return userService.updateRole(userId,role);
    }
    @GetMapping("get-all")
    public List<UserResponseDTO> getAll(
            @RequestParam(defaultValue = "USER") String role) {
        return userService.getAllByRole(role);
    }
}
