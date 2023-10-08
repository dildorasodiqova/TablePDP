package uz.pdp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.Entity.enums.GroupStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
    private UserEntity mentor;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CourseEntity course;

    private LocalDate startDate;
     private Integer groupModule;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Module> module;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserEntity> students;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Module> module;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserEntity> students;

    public GroupEntity( String groupName, GroupStatus groupStatus, UserEntity mentor, CourseEntity course, LocalDate startDate) {
        this.groupName = groupName;
        this.groupStatus = groupStatus;
        this.mentor = mentor;
        this.course = course;
        this.startDate = startDate;
    }
}
