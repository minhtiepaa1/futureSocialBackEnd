package groupProject.database.controller;



import groupProject.database.domain.entity.ListSongs;
import groupProject.database.domain.entity.User;
import groupProject.database.model.ApiResponse;
import groupProject.database.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.AbstractList;
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

    @GetMapping("/find_by_id")
    public ResponseEntity<Object> getUserById(@RequestParam(name="id") Long id ){
        User getuser = userService.findById(id);
        User listUser[] = new User[3];
        for (int i=0; i< 3; i++){
            listUser[i] = getuser;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("custom-header", "user");
        // not found, exactly other use AOP catch exception
        if (getuser == null){
//            return new ResponseEntity<>(
//                    null,headers,HttpStatus.OK
//            );
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("User not found",null));
        }
        return new ResponseEntity<>(
                new ApiResponse("Success", listUser), headers, HttpStatus.OK
        );

    }
    @PostMapping("/user_register")
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
    @GetMapping("/user_name")
    public User findUserByIdAndName( @PathParam(value = "user_name") String userName){
        return userService.findByUserName(userName);
    }
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/getInfoUserLogin")
    public User getInfoUser(@PathParam(value = "passWord") Long passWord, @PathParam(value = "userName")  String userName ){
        return userService.findByUserNameAndPassWord(passWord, userName);
    }
}
