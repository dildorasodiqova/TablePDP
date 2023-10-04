package uz.pdp.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import uz.pdp.Entity.GroupEntity;
import uz.pdp.exception.DataAlreadyExistsException;
import uz.pdp.repository.GroupRepository;

import java.util.Optional;

@Component
@Slf4j
public class GroupValidator extends AbstractValidator<GroupEntity, GroupRepository>{
    private final GroupRepository groupRepository;

    public GroupValidator(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void validate(GroupEntity entity) {
        log.info("validating" + entity.getClass().getName());
        Optional<GroupEntity> byGroupName = groupRepository.findByGroupName(entity.getGroupName());
        if (byGroupName.isPresent()){
            throw  new DataAlreadyExistsException("Group is already exist with name:" + byGroupName);
        }
        log.info("validated" + entity.getClass().getName());
    }
}
