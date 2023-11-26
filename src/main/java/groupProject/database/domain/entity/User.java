package groupProject.database.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "userTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String fullName;
    private String userName;
    private Long passWord;
    private Long age;
    @Column(name = "email")
    private  String email;
//    @OneToMany (mappedBy = "nameSong")
//    private List<ListSongs> listSongs;
}
