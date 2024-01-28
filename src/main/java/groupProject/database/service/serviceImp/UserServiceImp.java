package groupProject.database.service.serviceImp;

import groupProject.database.domain.entity.User;
import groupProject.database.domain.entity.role.Role;
import groupProject.database.dto.UserCreateDto;
import groupProject.database.dto.UserDto;
import groupProject.database.repository.RoleRepository;
import groupProject.database.repository.UserRepository;
import groupProject.database.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    public UserDto create(UserCreateDto userCreateDto) {
        User getUser = userRepository.findByUserName(userCreateDto.getUserName());
        if (userCreateDto.getEmail() == null || userCreateDto.getEmail().isEmpty() ||
                userCreateDto.getUserName() == null || userCreateDto.getUserName().isEmpty() ||
                userCreateDto.getAge() == null || userCreateDto.getAge() ==0 ||
                userCreateDto.getFullName() == null || userCreateDto.getFullName().isEmpty() ||
                userCreateDto.getPassWord() == null || getUser != null
        ) {
            return null;
        }
        User newUser = User.userCreateDtoToUser(userCreateDto);
        User userResponse = userRepository.save(newUser);

        return UserDto.convertToDto(userResponse);
    }

    @Override
    public User update(Long id, User user) {
        User getUser = userRepository.findById(id).orElse(null);
        if (getUser == null) {
            return null;
        }
        getUser.setEmail(user.getEmail());
        getUser.setUserName(user.getUserName());
        getUser.setFullName(user.getFullName());
        getUser.setPassWord(user.getPassWord());
        getUser.setAge(user.getAge());
        return userRepository.save(getUser);
    }

    @Override
    public void delete(Long id) {
        User getUser =  userRepository.findById(id).orElse(null);
        if (getUser != null) {
            userRepository.delete(getUser);
        }
    }

    @Override
    public UserDto findById(Long id) {
        User getUser = userRepository.findById(id).orElse(null);
        if (getUser == null) {
            return null;
        }
        UserDto userDto = UserDto.convertToDto(getUser);
        return userDto;
    }
    @Override
    public User findByUserName( String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.geAllUsers();
    }

    @Override
    public User findByUserNameAndPassWord(Long passWord, String userName){
        User getUser = userRepository.findByUserNameAndPassWord(passWord, userName);
        if (getUser == null){
            System.out.println("get user is null");
            return null;

        }
        return getUser;
    }

    @Override
    public UserDto setRole(String name, Long userId) {
        Role getRole = roleRepository.getRoleByName(name);
        User getUser = userRepository.findById(userId).orElse(null);

        if (getUser == null || getRole == null){
            return null;
        }
        Set<Role> getRoleSet = getUser.getRoleList();
        if (getRoleSet == null){
            getRoleSet = new HashSet<>();
        }
        getRoleSet.add(getRole);
        User userRes =  userRepository.save(getUser);
        UserDto userDto = UserDto.convertToDto(userRes);
        return userDto;
    }
}
