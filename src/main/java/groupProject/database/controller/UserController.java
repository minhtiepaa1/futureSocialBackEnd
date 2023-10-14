package groupProject.database.controller;



import groupProject.database.domain.entity.ListSongs;
import groupProject.database.domain.entity.User;
import groupProject.database.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    // test return
    @GetMapping("/app")
    public String nameProject(){
        return "XIN CHAO";
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id ){
        return userService.findById(id);
    }
    @PostMapping("/user")
    public User createNew(User user){
        return userService.create(user);
    }
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, User user){
        return userService.update(id, user);
    }
    @DeleteMapping("/{id}")
    public void delete(Long id){
        userService.delete(id);
    }
    @GetMapping("/name")
    public User findUserByIdAndName(@PathParam(value = "id") Long id, @PathParam(value = "name") String name){
        return userService.findUserByIdAndName(id,name);
    }
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
