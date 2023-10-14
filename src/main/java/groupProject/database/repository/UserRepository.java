package groupProject.database.repository;

import groupProject.database.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM myproject.user_table u WHERE u.id= :id AND u.name= :name",
        nativeQuery = true
    )
    public User findUserByIdAndName( Long id, String name);
    @Query (value = "SELECT * FROM myproject.user_table", nativeQuery = true)
    public List<User> geAllUsers();

}