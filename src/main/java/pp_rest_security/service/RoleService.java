package pp_rest_security.service;


import pp_rest_security.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService  {
    Set<Role> findRoles(List<Long> roles);
    List<Role> getAllRoles();
}
