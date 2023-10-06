package uz.pdp.DTO.responceDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MentorDTO {
    @JsonIgnore
    private String experience;
}
