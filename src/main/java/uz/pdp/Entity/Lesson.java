package uz.pdp.Entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "lessons")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Lesson extends BaseEntity{
    private LocalDate date; //// qaysi sanada bo'lishi
    private String topicName; //// mavzuni name si


}
