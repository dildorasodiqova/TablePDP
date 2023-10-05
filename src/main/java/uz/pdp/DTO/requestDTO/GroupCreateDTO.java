package uz.pdp.DTO.requestDTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.Entity.UserEntity;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupCreateDTO {
    @NotBlank(message = "Group name cannot be empty or blank")
    private String groupName;

    @NotNull(message = "Mentor cannot be empty or blank")
    private UUID mentorId;

    @NotNull(message = "Course cannot be empty or blank")
     private UUID courseId;

    @NotNull(message = "Start date cannot be empty or blank")
    private LocalDate startDate;

}
