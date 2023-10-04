package uz.pdp.service.userService;

import uz.pdp.Entity.UserEntity;

import java.util.UUID;

public interface UserService {
    UserEntity getById(UUID id);
}
