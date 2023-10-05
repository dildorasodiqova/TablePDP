package uz.pdp.DTO.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.Entity.AttendanceEntity;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonCreateDTO {
    private Integer moduleNumber;

    private LocalDate date; //// qaysi sanada bo'lishi

    private String topicName; //// mavzuni name si

    private UUID groupId;

    private String lessonStatus;

    private  Integer number; /// nechinchi darsligi

}
