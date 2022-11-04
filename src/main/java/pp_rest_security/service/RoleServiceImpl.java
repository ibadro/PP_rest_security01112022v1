package pp_rest_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pp_rest_security.model.Role;
import pp_rest_security.repository.RoleRepository;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getListRoles() {
        return roleRepository.getListRoles();
    }

    @Override
    public void addRole(Role role) {
        roleRepository.addRole(role);
    }

    @Override
    public Role getRoleByName(String role) {
        return roleRepository.getRoleByName(role);
    }

}
