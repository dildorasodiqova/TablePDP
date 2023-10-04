package uz.pdp.DTO.responceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonResponseDTO {
    private UUID lessonId;
    private String moduleName;
    private UUID moduleId;
    private LocalDate date; //// qaysi sanada bo'lishi
    private String topicName;
}
