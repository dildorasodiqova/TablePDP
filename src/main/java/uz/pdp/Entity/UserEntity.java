package uz.pdp.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.pdp.Entity.enums.Permission;
import uz.pdp.Entity.enums.UserRole;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static uz.pdp.Entity.enums.UserRole.USER;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserEntity extends BaseEntity implements UserDetails {
    private String name;
    private String surname;
    private String password;
    @Column(unique = true)
    private String phoneNumber;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private UserRole role = USER;
    @Enumerated(EnumType.STRING)
    private Set<Permission> permissions;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities =
                new HashSet<>(Set.of(new SimpleGrantedAuthority("ROLE_" + role.name())));
        if(permissions != null) {
            authorities.addAll(permissions.stream()
                    .map(permission -> new SimpleGrantedAuthority(permission.name()))
                    .toList());
        }
        return authorities;
    }

//    public String getPhoneNumber() {
//        return phoneNumber;
//    }

    @Override
    public String getUsername() {
        return phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return super.isActive.booleanValue();
    }

}
