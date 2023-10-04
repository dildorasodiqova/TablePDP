package uz.pdp.service.moduleService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.ModuleCreateDTO;
import uz.pdp.DTO.responceDTO.ModuleResponseDTO;
import uz.pdp.Entity.ModuleEntity;
import uz.pdp.repository.ModuleRepository;
import uz.pdp.service.BaseService;
import uz.pdp.validator.ModuleValidator;

import java.util.Optional;
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
    private final ModelMapper modelMapper;
    private final ModuleRepository moduleRepository;
    public ModuleServiceImpl(ModuleRepository repository, ModuleValidator validator, ModelMapper modelMapper, ModelMapper modelMapper1, ModuleRepository moduleRepository) {
        super(repository, validator, modelMapper);
        this.modelMapper = modelMapper1;
        this.moduleRepository = moduleRepository;
    }

    @Override
    protected ModuleResponseDTO mapEntityToRes(ModuleEntity entity) {
        return modelMapper.map(entity, ModuleResponseDTO.class);

    }

    @Override
    protected ModuleEntity mapCRToEntity(ModuleCreateDTO createReq) {
        return new ModuleEntity(createReq.getModuleName());
    }
}
