package groupProject.database.controller;

import groupProject.database.dto.RoleDto;
import groupProject.database.model.ApiResponse;
import groupProject.database.service.serviceImp.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleServiceImp roleServiceImp;

    @PostMapping("create_role")
    public ResponseEntity<Object> create(String name){
        RoleDto roleDtoRes = roleServiceImp.create(name);
        ApiResponse newApiResponse;
        if (roleDtoRes == null){
           newApiResponse = new ApiResponse("not create role", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newApiResponse);
        }
        newApiResponse = new ApiResponse("success", roleDtoRes);
        return ResponseEntity.status(HttpStatus.OK).body(newApiResponse);
    }

    @GetMapping("get_role")
    public ResponseEntity<Object> getRole(String name){

       RoleDto roleDtoRes = roleServiceImp.getRoleByName(name);
       ApiResponse newApiResponse;
       if (roleDtoRes == null){
           newApiResponse = new ApiResponse("success", null);
           return ResponseEntity.status(HttpStatus.OK).body(newApiResponse);
       }
        newApiResponse = new ApiResponse("success", roleDtoRes);
        return ResponseEntity.status(HttpStatus.OK).body(newApiResponse);
    }
}
