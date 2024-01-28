package groupProject.database.repository;

import groupProject.database.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM myproject.users u WHERE u.user_name= :userName",
        nativeQuery = true
    )
    User findByUserName( String userName);
    @Query (value = "SELECT * FROM myproject.users", nativeQuery = true)
    List<User> geAllUsers();

    @Query(value = "SELECT * FROM myproject.users u WHERE u.user_name= :userName AND u.pass_word= :passWord",
    nativeQuery = true
    )
    User findByUserNameAndPassWord(Long passWord, String userName);

}