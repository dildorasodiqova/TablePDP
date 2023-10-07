package uz.pdp.DTO.responceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.Entity.enums.GroupStatus;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupResponseDTO {
    private UUID groupId;
    private String groupName;

    private GroupStatus groupStatus;

    private UUID mentorId;
//    private String mentorName;

    private UUID courseId;
//    private String courseName;

    private LocalDate startDate;
    private List<UserResponseDTO> students;/// buyerda studentlarni obkeb beradigan link boladi

}
