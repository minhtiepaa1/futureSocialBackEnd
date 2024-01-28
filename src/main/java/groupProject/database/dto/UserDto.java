package groupProject.database.dto;

import groupProject.database.domain.entity.User;
import groupProject.database.domain.entity.role.Role;
import groupProject.database.domain.entity.user.UserMessage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String fullName;
    private String userName;
    private Long age;
    private Set<Role> roleSet;
    private List<UserMessage> userMessageList;
    public static UserDto convertToDto(User user){
        return new ModelMapper().map(user, UserDto.class);
    }
}
