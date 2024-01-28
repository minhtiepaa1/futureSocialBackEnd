package groupProject.database.repository;

import groupProject.database.domain.entity.messages.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface MessagesRepository extends JpaRepository<Messages, Long> {
@Query(value = "SELECT * FROM myproject.messages_tb u WHERE u.user_id= :user_id",
nativeQuery = true)
List<Messages> findMessagesByUserId(Long user_id);
}
