package uz.pdp.DTO.responceDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class UserResponseDTO extends MentorDTO{
    private UUID userId;
    private String name;
    private String surname;
    private String phoneNumber;
    private LocalDate birthday;
    private String role;
}
