package uz.pdp.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import uz.pdp.Entity.UserEntity;
import uz.pdp.repository.UserRepository;
@Component
@Slf4j
public class UserValidator extends AbstractValidator<UserEntity, UserRepository>{
    private final UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UserEntity entity) {
        super.validate(entity);
    }



}
