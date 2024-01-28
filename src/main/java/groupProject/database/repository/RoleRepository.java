package groupProject.database.repository;

import groupProject.database.domain.entity.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "", nativeQuery = true)
    public Role getRoleByName(String name);
}
