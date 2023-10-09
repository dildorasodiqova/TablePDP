package uz.pdp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.Entity.enums.LessonStatus;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "lessons")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class LessonEntity extends BaseEntity{
    private Integer moduleNumber;
//
////    private LocalDate date; //// qaysi sanada bo'lishi
//
//    @Column(unique = true)
//    private String topicName; //// mavzuni name si

    @ManyToOne(fetch = FetchType.EAGER)
    private GroupEntity group;

    @Enumerated(EnumType.STRING)
    LessonStatus lessonStatus;

    private  Integer number;

    @OneToMany(fetch = FetchType.EAGER)
    List<AttendanceEntity> attendances;
}

