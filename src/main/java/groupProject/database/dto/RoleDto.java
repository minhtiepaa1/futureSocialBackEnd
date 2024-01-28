package groupProject.database.dto;

import groupProject.database.domain.entity.User;
import groupProject.database.domain.entity.role.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class RoleDto {
    private String name;

    private Set<User> userList;
    public static RoleDto convertToDto(Role role){
        return new ModelMapper().map(role, RoleDto.class);
    }
    public static Set<RoleDto> convertToSetDto(Set<Role> roleSet){
        return roleSet.stream().map(role -> new ModelMapper().map(role, RoleDto.class)).collect(Collectors.toSet());
    }
}
