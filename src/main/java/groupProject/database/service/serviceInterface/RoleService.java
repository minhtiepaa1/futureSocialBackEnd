package groupProject.database.service.serviceInterface;

import groupProject.database.dto.RoleDto;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    RoleDto getRoleByName(String name);
    RoleDto create(String name);


}
