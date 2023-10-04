package uz.pdp.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "modules")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Module  extends BaseEntity{
    @Column(unique = true)
    private String moduleName;
//    @OneToMany( fetch = FetchType.EAGER)
//    private List<Lesson> lessons;

}
