package pp_rest_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pp_rest_security.model.Role;
import pp_rest_security.repository.RoleRepository;

import java.util.List;
import java.util.Set;


@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> findRoles(List<Long> roles) {
        return roleRepository.findRoles(roles);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.getRoles();
    }
}
