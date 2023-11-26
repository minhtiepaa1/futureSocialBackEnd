package groupProject.database.service.serviceImp;

import groupProject.database.domain.entity.User;
import groupProject.database.repository.UserRepository;
import groupProject.database.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;
    public User create(User user) {
        User getUser = userRepository.findByUserName(user.getUserName());
        if (user.getEmail() == null || user.getEmail().isEmpty() ||
                user.getUserName() == null || user.getUserName().isEmpty() ||
                user.getAge() == null || user.getAge() ==0 ||
                user.getFullName() == null || user.getFullName().isEmpty() ||
                user.getPassWord() == null || getUser == null
        ) {
            return null;
        }
        return userRepository.save(user);
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
    public User findById(Long id) {
        User getUser = userRepository.findById(id).orElse(null);
        if (getUser == null) {
            return null;
        }
        return getUser;
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
}
