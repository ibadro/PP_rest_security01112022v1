package pp_rest_security.service;


import pp_rest_security.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getListRoles();

    void addRole(Role role);

    Role getRoleByName(String role);
}