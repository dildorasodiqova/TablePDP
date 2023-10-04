package uz.pdp.DTO.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class SignUpDTO {
    @NotBlank(message = "Name cannot be empty or blank")
    private String name;

    @NotBlank(message = "Surname cannot be empty or blank")
    private String surname;

    @NotBlank(message = "PhoneNumber cannot be empty or blank")
    private String phoneNumber;

    @NotBlank(message = "Birthday cannot be empty or blank")
    private LocalDate birthday;
}
