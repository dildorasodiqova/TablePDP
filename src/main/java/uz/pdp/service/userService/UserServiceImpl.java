package uz.pdp.service.userService;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.AuthDTO;
import uz.pdp.DTO.requestDTO.UserCreateDTO;
import uz.pdp.DTO.responceDTO.JwtResponse;
import uz.pdp.DTO.responceDTO.UserResponseDTO;
import uz.pdp.Entity.UserEntity;
import uz.pdp.exception.DataNotFoundException;
import uz.pdp.repository.UserRepository;
import uz.pdp.service.BaseService;
import uz.pdp.service.jwt.JwtService;
import uz.pdp.validator.UserValidator;

import java.util.ArrayList;
import java.util.List;
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
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository repository, UserValidator validator, ModelMapper modelMapper, PasswordEncoder passwordEncoder, JwtService jwtService) {
        super(repository, validator, modelMapper);
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userRepository = repository;
    }

    @Override
    protected UserResponseDTO mapEntityToRes(UserEntity entity) {
        return null;
    }

    @Override
    protected UserEntity mapCRToEntity(UserCreateDTO createReq) {
        return null;
    }

    @Override
    public UserEntity getById(UUID id) {
       return userRepository.findById(id).get();
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
    public List<UserResponseDTO> parse(List<UserEntity> list) {
        List<UserResponseDTO> list1 = new ArrayList<>();
        for (UserEntity user : list) {
            list1.add(new UserResponseDTO(user.getId(),user.getName(), user.getSurname(), user.getPhoneNumber(), user.getBirthday(), user.getRole().toString()));
        }
        return list1;
    }
}
