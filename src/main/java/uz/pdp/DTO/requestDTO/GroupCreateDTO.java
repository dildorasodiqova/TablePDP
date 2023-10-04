package uz.pdp.DTO.requestDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import uz.pdp.Entity.UserEntity;
import uz.pdp.Entity.enums.GroupStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupCreateDTO {

    private String groupName;

    private UserEntity mentorId;

     private UUID courseId;

    private LocalDate startDate;

}
