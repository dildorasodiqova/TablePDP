package uz.pdp.DTO.responceDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttendanceResponseDTO {


    private UUID userId;
    private String userName;
    private String reason;
    private String status;

}
