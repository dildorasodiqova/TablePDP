package uz.pdp.service.userService;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.AuthDTO;
import uz.pdp.DTO.requestDTO.SignUpDTO;
import uz.pdp.DTO.requestDTO.UserCreateDTO;
import uz.pdp.DTO.responceDTO.JwtResponse;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.Entity.UserEntity;
import uz.pdp.Entity.enums.Permission;
import uz.pdp.Entity.enums.UserRole;
import uz.pdp.exception.DataAlreadyExistsException;
import uz.pdp.exception.DataNotFoundException;
import uz.pdp.exception.MyValidationException;
import uz.pdp.repository.UserRepository;
import uz.pdp.service.BaseService;
import uz.pdp.service.jwt.JwtService;
import uz.pdp.validator.UserValidator;

import java.util.*;
import java.util.stream.Collectors;
import static uz.pdp.Entity.enums.UserRole.USER;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl extends BaseService<
        UserEntity,
        UUID,
        UserRepository,
        UserResponseDTO,
        SignUpDTO,
        UserValidator
        > implements UserService{
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public UserServiceImpl(UserRepository repository, UserValidator validator, ModelMapper modelMapper, PasswordEncoder passwordEncoder, JwtService jwtService) {
        super(repository, validator, modelMapper);
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    protected UserResponseDTO mapEntityToRes(UserEntity entity) {
        return new UserResponseDTO(entity.getId(), entity.getName(), entity.getSurname(), entity.getPhoneNumber(),entity.getBirthday(),entity.getRole().toString(),entity.getPermissions());
    }

    @Override
    protected UserEntity mapCRToEntity(SignUpDTO createReq) {
        return new UserEntity(createReq.getName(), createReq.getSurname(), passwordEncoder.encode(createReq.getPassword()), createReq.getPhoneNumber(), createReq.getBirthday(),USER,null);
    }

    @Override
    public UserEntity getById(UUID id) {
       return repository.findById(id).get();
    }

    @Override
    public JwtResponse signIn(AuthDTO dto) {
        UserEntity entity = repository.findByPhoneNumber(dto.getPhoneNumber())
                .orElseThrow(() -> new DataNotFoundException("User not found with phone number: " + dto.getPhoneNumber()));
        if(passwordEncoder.matches(dto.getPassword(), entity.getPassword())) {
            return new JwtResponse(jwtService.generateToken(entity));
        }
        throw new AuthenticationCredentialsNotFoundException("Password didn't match");
    }

    @Override
    public UserResponseDTO addUser(UserCreateDTO dto) {
        Optional<UserEntity> user = repository.findByPhoneNumber(dto.getPhoneNumber());
        if(user.isPresent()) {
            throw new DataAlreadyExistsException("User already exists");
        }
        UserEntity map = modelMapper.map(dto, UserEntity.class);
        setPermission(map,dto.getPermissions());
        map.setPassword(passwordEncoder.encode(map.getPassword()));
        repository.save(map);
        return mapEntityToRes(map);
    }

    private UserEntity setPermission(UserEntity user, Set<String> permissions) {
        Set<Permission> collect = permissions.stream()
                .map(permission -> {
                    Permission permissionEntity = Permission.valueOf(permission.toUpperCase());
                    if(!permissionEntity.getRole().equals(user.getRole().name())) {
                        throw new MyValidationException(
                                String.format("Wrong permission included: %s is not part of %s permissions",
                                        permissionEntity,user.getRole()));
                    }
                    return permissionEntity;
                })
                .collect(Collectors.toSet());
        user.setPermissions(collect);
        return user;
    }

    @Override
    public String updateRole(UUID userId, String role,Set<String> permissions) {
        UserEntity entity = repository.findById(userId)
                .orElseThrow(() -> new DataNotFoundException("User not found with id: " + userId));
        entity.setRole(UserRole.valueOf(role));
        setPermission(entity,permissions);
        repository.save(entity);
        return entity.getName() + "'s role updated";
    }

    @Override
    public List<UserResponseDTO> getAllByRole(String role) {
         return repository.getAllByRole(UserRole.valueOf(role)).stream()
                 .map(this::mapEntityToRes).toList();
      }
    public List<UserResponseDTO> parse(List<UserEntity> list) {
        List<UserResponseDTO> list1 = new ArrayList<>();
        for (UserEntity user : list) {
            list1.add(new UserResponseDTO(user.getId(),user.getName(), user.getSurname(), user.getPhoneNumber(), user.getBirthday(), user.getRole().toString(),user.getPermissions()));
        }
        return list1;
    }

    @Override
    public String deleteByIdUser(UUID userId) {
        UserEntity entity = repository.findById(userId)
                .orElseThrow(() -> new DataNotFoundException("User not found"));
        entity.setIsActive(false);
        repository.save(entity);
        return "User deleted";
    }
}
