package groupProject.database.repository;

import groupProject.database.domain.entity.user.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserMessagesRepository extends JpaRepository<UserMessage ,Long> {
    @Query(value = "SELECT * FROM myproject.user_message u where u.user_id IN :user_ids", nativeQuery = true)
    public List<UserMessage> getListIdMessagesByUserId(List<Long> user_ids);
}
