package uz.pdp.DTO.responceDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttendanceResponseDTO {
    private UUID attId;

    private UUID userId;
    private String userName;

    private UUID lessonId;
    private String lessonName;

    private String reason;

    private UUID groupId;
    private String groupName;

    private String status;

}
