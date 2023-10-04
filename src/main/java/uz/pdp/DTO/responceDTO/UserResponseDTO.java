package uz.pdp.DTO.responceDTO;

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
public class UserResponseDTO {
    private UUID userId;
    private String name;
    private String surname;
    private String phoneNumber;
    private LocalDate birthday;
    private String role;
}
