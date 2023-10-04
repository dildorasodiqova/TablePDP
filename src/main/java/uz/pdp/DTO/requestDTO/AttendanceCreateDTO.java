package uz.pdp.DTO.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttendanceCreateDTO {
    private UUID userId;

    private UUID lessonId;

    private String reason;

    private UUID groupId;

    private String status;
}
