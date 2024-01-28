package groupProject.database.dto;

import groupProject.database.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateDto {

    private String fullName;
    private String userName;
    private Long age;
    private Long passWord;
    private  String email;
    public static UserCreateDto convertToDto(User user){
        return new ModelMapper().map(user, UserCreateDto.class);
    }
}
