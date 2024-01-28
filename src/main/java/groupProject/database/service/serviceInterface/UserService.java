package groupProject.database.service.serviceInterface;

import groupProject.database.domain.entity.User;
import groupProject.database.dto.UserCreateDto;
import groupProject.database.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
UserDto create(UserCreateDto userCreateDto);
User update(Long id, User user);
void delete(Long id);
UserDto findById(Long id);
User findByUserName(String userName);
List<User> getAllUsers();
User findByUserNameAndPassWord(Long passWord, String userName);
UserDto setRole(String name, Long userId);

}

