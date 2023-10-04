package uz.pdp.DTO.requestDTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.Entity.enums.UserRole;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateDTO {
    @NotBlank(message = "Name cannot be empty or blank")
    private String name;

    @NotBlank(message = "Surname cannot be empty or blank")
    private String surname;

    @NotBlank(message = "PhoneNumber cannot be empty or blank")
    private String phoneNumber;

    @NotBlank(message = "Birthday cannot be empty or blank")
    private LocalDate birthday;

}
