package pp_rest_security.service;


import pp_rest_security.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getAllRoles();

    Set<Role> getRoleById(Long id);

    void addRole(Role role);
}
