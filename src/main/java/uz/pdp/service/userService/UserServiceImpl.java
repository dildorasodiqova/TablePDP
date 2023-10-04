package uz.pdp.service.userService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.UserCreateDTO;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.Entity.UserEntity;
import uz.pdp.repository.UserRepository;
import uz.pdp.service.BaseService;
import uz.pdp.validator.UserValidator;

import java.util.UUID;

@Service
public class UserServiceImpl extends BaseService<
        UserEntity,
        UUID,
        UserRepository,
        UserResponseDTO,
        UserCreateDTO,
        UserValidator
        > implements UserService{
    public UserServiceImpl(UserRepository repository, UserValidator validator, ModelMapper modelMapper) {
        super(repository, validator, modelMapper);
    }

    @Override
    protected UserResponseDTO mapEntityToRes(UserEntity entity) {
        return null;
    }

    @Override
    protected UserEntity mapCRToEntity(UserCreateDTO createReq) {
        return null;
    }
}
