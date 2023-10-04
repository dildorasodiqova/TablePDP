package uz.pdp.service.moduleService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.ModuleCreateDTO;
import uz.pdp.DTO.responceDTO.ModuleResponseDTO;
import uz.pdp.Entity.ModuleEntity;
import uz.pdp.repository.ModuleRepository;
import uz.pdp.service.BaseService;
import uz.pdp.validator.ModuleValidator;

import java.util.UUID;

@Service
public class ModuleServiceImpl extends BaseService<
        ModuleEntity,
        UUID,
        ModuleRepository,
        ModuleResponseDTO,
        ModuleCreateDTO,
        ModuleValidator
        > implements ModuleService{
    public ModuleServiceImpl(ModuleRepository repository, ModuleValidator validator, ModelMapper modelMapper) {
        super(repository, validator, modelMapper);
    }

    @Override
    protected ModuleResponseDTO mapEntityToRes(ModuleEntity entity) {
        return null;
    }

    @Override
    protected ModuleEntity mapCRToEntity(ModuleCreateDTO createReq) {
        return null;
    }
}
