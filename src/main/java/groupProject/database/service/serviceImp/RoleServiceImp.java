package groupProject.database.service.serviceImp;

import groupProject.database.domain.entity.role.Role;
import groupProject.database.dto.RoleDto;
import groupProject.database.repository.RoleRepository;
import groupProject.database.service.serviceInterface.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Override
    public RoleDto getRoleByName(@RequestParam String name) {
        Role getRole = roleRepository.getRoleByName(name);
        if (getRole == null){
            return null;
        }
        RoleDto roleDtoRes = RoleDto.convertToDto(getRole);
        return roleDtoRes;
    }

    @Override
    public RoleDto create(String name) {
        Role getRole = roleRepository.getRoleByName(name);
        if (getRole != null){
            return null;
        }

        Role newRole = new Role();
        newRole.setName(name);
        Role roleRes = roleRepository.save(newRole);
        RoleDto roleDtoRes = RoleDto.convertToDto(roleRes);

        return roleDtoRes;
    }
}
