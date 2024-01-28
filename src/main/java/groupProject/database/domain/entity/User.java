package groupProject.database.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import groupProject.database.domain.entity.role.Role;
import groupProject.database.domain.entity.user.UserMessage;
import groupProject.database.dto.UserCreateDto;
import groupProject.database.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "pass_word")
    private Long passWord;
    @Column(name = "age")
    private Long age;
    @Column(name = "email")
    private  String email;
    @CreationTimestamp
    private Timestamp createAt;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    @JsonIgnore
    private Set<Role> roleList = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "user", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<UserMessage> userMessageList;

    public static User convertToUser(UserDto userDto){
        return new ModelMapper().map(userDto, User.class);
    }
    public static User userCreateDtoToUser(UserCreateDto userCreateDto){
        return new ModelMapper().map(userCreateDto, User.class);
    }
}
