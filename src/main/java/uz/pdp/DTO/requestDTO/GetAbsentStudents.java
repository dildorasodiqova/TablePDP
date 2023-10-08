package uz.pdp.DTO.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAbsentStudents {
    private UUID groupId ;
    private Integer moduleNum;
    private Integer lessonNum ;
}
