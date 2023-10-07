package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN') and hasAuthority('USER_READ') or hasRole('SUPER_ADMIN')")
    @GetMapping("/get-all")
    public List<UserResponseDTO> getAll(
            @RequestParam(defaultValue = "USER") String role) {
        return userService.getAllByRole(role);
    }
}
