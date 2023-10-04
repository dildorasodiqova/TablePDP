package uz.pdp.validator;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import uz.pdp.Entity.ModuleEntity;
import uz.pdp.exception.DataAlreadyExistsException;
import uz.pdp.repository.ModuleRepository;

import java.util.Optional;

@Component
@Slf4j
public class ModuleValidator extends AbstractValidator<ModuleEntity, ModuleRepository>{
    private ModuleRepository moduleRepository;
    @Override
    public void validate(ModuleEntity entity) {
        log.info("validating" + entity.getClass().getName());
        Optional<ModuleEntity> name = moduleRepository.findByModuleName(entity.getModuleName());
        if (name.isPresent()){
            throw new DataAlreadyExistsException("Module is already exists with name: "+ name);
        }
        log.info("validated" + entity.getClass().getName());
    }

}

