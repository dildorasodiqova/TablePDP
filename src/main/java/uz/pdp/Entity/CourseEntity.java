package uz.pdp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CourseEntity extends BaseEntity {
    @Column(unique = true)
    private String courseName;
    private Integer modules; ///davomiyligini nechi oyligi beradi admin
    private Double price;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<ModuleEntity> module;
}
