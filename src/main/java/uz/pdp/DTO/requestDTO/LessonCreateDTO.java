package uz.pdp.DTO.requestDTO;

import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Module number cannot be empty or blank")
    private Integer moduleNumber;

    @NotNull(message = "Group cannot be empty or blank")
    private UUID groupId;

    private String lessonStatus;

    @NotNull(message = "Lesson number cannot be empty or blank")
    private  Integer number; /// nechinchi darsligi

}
