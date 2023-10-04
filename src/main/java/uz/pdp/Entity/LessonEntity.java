package uz.pdp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "lessons")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class LessonEntity extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    private Module module;
    private LocalDate date; //// qaysi sanada bo'lishi
    private String topicName; //// mavzuni name si


}

