package pp_rest_security.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pp_rest_security.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getListRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Transactional
    @Override
    public void addRole(Role role) {
        if (getRoleByName(role.getName()) == null) {
            entityManager.persist(role);
        }
    }

    @Override
    public Role getRoleByName(String role) {
        return entityManager.createQuery("select r from Role r", Role.class)
                .getResultStream()
                .filter(name -> name.getName().equals(role))
                .findAny()
                .orElse(null);
    }
}
