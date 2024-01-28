package groupProject.database.domain.entity.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import groupProject.database.domain.entity.User;
import groupProject.database.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "roleList", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnore
    private Set<User> userList = new HashSet<>();

    public static Role convertToRole(RoleDto roleDto){
        return new ModelMapper().map(roleDto, Role.class);
    }

    public static Set<Role> convertToSetRole(Set<RoleDto> roleDtoSet){
        return roleDtoSet.stream().map(roleDto -> new ModelMapper().map(roleDto, Role.class)).collect(Collectors.toSet());
    }
}
