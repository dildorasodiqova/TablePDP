package uz.pdp.DTO.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModuleCreateDTO {
    @NotBlank(message = "Module name cannot be empty or blank")
    private String moduleName;
}
