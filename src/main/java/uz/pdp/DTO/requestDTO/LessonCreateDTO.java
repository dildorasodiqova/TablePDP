package uz.pdp.DTO.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.Entity.Module;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonCreateDTO {
    private UUID moduleId;
    private LocalDate date; //// qaysi sanada bo'lishi
    private String topicName;
}
