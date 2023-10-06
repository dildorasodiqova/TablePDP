package uz.pdp.DTO.requestDTO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.Entity.enums.UserRole;

import java.time.LocalDate;
import java.util.Set;

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

    private String password;

    private String role;

    @NotBlank(message = "Birthday cannot be empty or blank")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthday;

    private Set<String> permissions;
}
