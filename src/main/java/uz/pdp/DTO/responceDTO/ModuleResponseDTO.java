package uz.pdp.DTO.responceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ModuleResponseDTO {
    private UUID moduleId;
    private String moduleName;
}
