package groupProject.database.service.serviceInterface;

import groupProject.database.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
User create(User user);
User update(Long id, User user);

void delete(Long id);
User findById(Long id);
User findUserByIdAndName(Long id, String name);
List<User> getAllUsers();
}

