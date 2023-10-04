package uz.pdp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.Entity.enums.GroupStatus;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GroupEntity extends BaseEntity {
    @Column(unique = true)
    private String groupName;

    @Enumerated(EnumType.STRING)
    private GroupStatus groupStatus;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserEntity mentorId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CourseEntity course;

    private LocalDate startDate;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Module> module;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserEntity> students;
}
