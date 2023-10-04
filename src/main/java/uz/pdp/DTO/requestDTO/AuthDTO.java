package uz.pdp.DTO.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class AuthDTO {
    private String password;
    private String phoneNumber;

}
