package groupProject.database.repository;

import groupProject.database.domain.entity.ListSongs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public  interface ListSongsRepository extends JpaRepository<ListSongs, Long> {
}
