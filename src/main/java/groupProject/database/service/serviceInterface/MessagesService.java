package groupProject.database.service.serviceInterface;

import groupProject.database.domain.entity.messages.Messages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessagesService {
    Messages create(String message, Long id_user);
    List<Messages> getMessagesByUserId(Long id);
}
