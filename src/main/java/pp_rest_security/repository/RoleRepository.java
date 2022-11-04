package pp_rest_security.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp_rest_security.model.Role;

import java.util.List;



public interface RoleRepository {
    List<Role> getListRoles();
    void addRole(Role role);
    Role getRoleByName(String role);
}