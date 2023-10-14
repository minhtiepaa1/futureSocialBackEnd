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
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return null;
        }
        if (user.getName() == null || user.getName().isEmpty()) {
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
        getUser.setName(user.getName());
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
    public User findUserByIdAndName(Long id, String name) {
        return userRepository.findUserByIdAndName(id, name);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.geAllUsers();
    }
}
