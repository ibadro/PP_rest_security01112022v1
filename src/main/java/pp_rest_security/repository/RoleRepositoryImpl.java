package pp_rest_security.repository;

import org.springframework.stereotype.Repository;
import pp_rest_security.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Set<Role> findRoles(List<Long> roles) {
        TypedQuery<Role> query = entityManager.createQuery("SELECT r FROM Role r WHERE r.id IN :role", Role.class);
        query.setParameter("role", roles);
        return new HashSet<>(query.getResultList());
    }

    @Override
    public List<Role> getRoles() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }
}
