package uz.pdp.validator;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import uz.pdp.Entity.ModuleEntity;
import uz.pdp.repository.ModuleRepository;

@Component
@Slf4j
public class ModuleValidator extends AbstractValidator<ModuleEntity, ModuleRepository>{
    @Override
    public void validate(ModuleEntity entity) {
        super.validate(entity);
    }
}

