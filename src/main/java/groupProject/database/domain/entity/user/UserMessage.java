package groupProject.database.domain.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import groupProject.database.domain.entity.User;
import groupProject.database.domain.entity.messages.Messages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class UserMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Long id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id")
    @JsonIgnore
    private Messages messages;

}

