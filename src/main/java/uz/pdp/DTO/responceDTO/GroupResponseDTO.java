package uz.pdp.DTO.responceDTO;

import lombok.*;
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


    public GroupResponseDTO(UUID groupId, String groupName, GroupStatus groupStatus, UUID mentorId,  UUID courseId, LocalDate startDate) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupStatus = groupStatus;
        this.mentorId = mentorId;
        this.courseId = courseId;
        this.startDate = startDate;
    }
}
