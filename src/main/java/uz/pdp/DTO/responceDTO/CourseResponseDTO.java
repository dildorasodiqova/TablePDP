package uz.pdp.DTO.responceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseResponseDTO {
    private UUID courseId;
    private String courseName;
    private Integer duration; ///davomiyligini nechi oyligi beradi admin
    private Double price;
//    private List<Module> module;
}
