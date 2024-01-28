package groupProject.database.service.serviceImp;

import groupProject.database.domain.entity.User;
import groupProject.database.domain.entity.messages.Messages;
import groupProject.database.domain.entity.user.UserMessage;
import groupProject.database.repository.MessagesRepository;
import groupProject.database.repository.UserMessagesRepository;
import groupProject.database.repository.UserRepository;
import groupProject.database.service.serviceInterface.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesServiceImp implements MessagesService {
    @Autowired
    MessagesRepository messagesRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMessagesRepository userMessagesRepository;

    @Override
    public Messages create(String message, Long person_id){
        User getUser = userRepository.findById(person_id).orElse(null);
        if (message == null || getUser == null){
            return null;
        }
        Messages newMessages = new Messages();
        newMessages.setMessage(message);

        UserMessage newUserMessage = new UserMessage();
        newUserMessage.setMessages(newMessages);
        newUserMessage.setUser(getUser);

       Messages messagesRes = messagesRepository.save(newMessages);
       UserMessage userMessageRes = userMessagesRepository.save(newUserMessage);
       return messagesRes;
    }

    @Override
    public List<Messages> getMessagesByUserId(Long id) {
        return messagesRepository.findMessagesByUserId(id);
    }

}
