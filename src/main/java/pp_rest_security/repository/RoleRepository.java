package pp_rest_security.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp_rest_security.model.Role;

import java.util.List;
import java.util.Set;


@Repository
public interface RoleRepository {

    Set<Role> findRoles(List<Long> roles);
    Set<Role> getByName(String name);
    List<Role> getRoles();

    void save(Role role);

    Set<Role> getById(Long id);
}

