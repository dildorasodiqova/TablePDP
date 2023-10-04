package uz.pdp.service.groupService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.DTO.requestDTO.GroupCreateDTO;
import uz.pdp.DTO.responceDTO.GroupResponseDTO;
import uz.pdp.Entity.GroupEntity;
import uz.pdp.repository.GroupRepository;
import uz.pdp.service.BaseService;
import uz.pdp.validator.AbstractValidator;

import java.util.Optional;
import java.util.UUID;

@Service

public class GroupServiceImpl extends BaseService<
        GroupEntity,
        UUID,
        GroupRepository,
        GroupResponseDTO,
        GroupCreateDTO,
        AbstractValidator<GroupEntity, GroupRepository>
        > implements GroupService{
    private final GroupRepository groupRepository ;
    public GroupServiceImpl(GroupRepository repository, AbstractValidator<GroupEntity, GroupRepository> validator, ModelMapper modelMapper, GroupRepository groupRepository) {
        super(repository, validator, modelMapper);
        this.groupRepository = groupRepository;
    }

    @Override
    protected GroupResponseDTO mapEntityToRes(GroupEntity entity) {
        return null;
    }

    @Override
    protected GroupEntity mapCRToEntity(GroupCreateDTO createReq) {
        return null;
    }

    @Override
    public Optional<GroupEntity> getGroup(UUID groupId) {

        return groupRepository.findById(groupId);
    }
}
