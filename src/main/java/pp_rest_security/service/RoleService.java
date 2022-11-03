package pp_rest_security.service;


import pp_rest_security.model.Role;

import java.util.List;

public interface RoleService  {
    Role getRoleById(long id);

    List<Role> getRoles();
}
