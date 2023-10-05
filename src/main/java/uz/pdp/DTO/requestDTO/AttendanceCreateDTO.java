package uz.pdp.DTO.requestDTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.Entity.AttendanceEntity;
import uz.pdp.Entity.GroupEntity;
import uz.pdp.Entity.enums.LessonStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttendanceCreateDTO {
    @NotNull(message = "StudentId cannot be empty or blank")
    private UUID studentId;

    @NotNull(message = "LessonId cannot be empty or blank")
    private UUID lessonId;

    private String reason;

    @NotNull(message = "GroupId cannot be empty or blank")
    private UUID groupId;

    @NotNull(message = "Status cannot be empty or blank")
    private String status;



}
