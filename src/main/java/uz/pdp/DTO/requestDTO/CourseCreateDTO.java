package uz.pdp.DTO.requestDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseCreateDTO {
    @NotBlank(message = "Course name cannot be empty or blank")
    private String courseName;

    @NotNull(message = "Duration cannot be empty or blank")
    private Integer modules; ///davomiyligini nechi oyligi beradi admin

    @NotNull(message = "Price cannot be empty or blank")
    private Double price;
}
