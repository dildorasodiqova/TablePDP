package uz.pdp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.Entity.enums.AttendanceStatus;

@Entity(name = "attendances")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AttendanceEntity extends BaseEntity{
    @OneToOne(fetch = FetchType.EAGER)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER)
    private LessonEntity lesson;

    @Column(columnDefinition = "text")
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status = AttendanceStatus.COME;

}
