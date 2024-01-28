package groupProject.database.controller;

import groupProject.database.domain.entity.messages.Messages;
import groupProject.database.model.ApiResponse;
import groupProject.database.service.serviceInterface.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {
    @Autowired
    MessagesService messagesService;
    @PostMapping("/user_messages")
    public ResponseEntity<Object> create(String message, @RequestParam(value = "person_id") Long person_id){

        Messages messagesRes = messagesService.create(message, person_id);
        if (messagesRes == null){
            return  ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("Not create message", null));
        }
        return new ResponseEntity<>(
                new ApiResponse("Success", messagesRes), HttpStatus.OK
        );
    }
    @GetMapping("/list_messages")
    public ResponseEntity<Object> getListMessages(@RequestParam(value = "user_id") Long user_id){

        List<Messages> messagesRes = messagesService.getMessagesByUserId(user_id);
        if (messagesRes == null){
            return  ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("Not create message", null));
        }
        return new ResponseEntity<>(
                new ApiResponse("Success", messagesRes), HttpStatus.OK
        );
    }
}
