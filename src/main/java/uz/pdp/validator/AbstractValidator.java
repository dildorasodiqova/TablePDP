package uz.pdp.validator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@AllArgsConstructor
public abstract class AbstractValidator<E, REP extends JpaRepository> {
    protected  REP repository;
    public void validate (E entity) {
        log.info("validating" + entity.getClass().getName());
        log.info("validated" + entity.getClass().getName());
    }
}
