package uz.pdp.DTO.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthDTO {
    @NotBlank(message = "Password cannot be empty or blank")
    private String password;

    @NotBlank(message = "PhoneNumber cannot be empty or blank")
    private String phoneNumber;

}
