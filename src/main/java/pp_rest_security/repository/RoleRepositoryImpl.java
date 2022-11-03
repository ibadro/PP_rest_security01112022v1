package pp_rest_security.repository;

import org.springframework.stereotype.Repository;
import pp_rest_security.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository {
    private EntityManager entityManager;


    @Override
    public Set<Role> findRoles(List<Long> roles) {
        String JPAql = "SELECT role FROM Role role";
        return entityManager.createQuery(JPAql, Role.class).getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Set<Role> getByName(String name) {
        String JPAql = "SELECT role FROM Role role WHERE role.name = :name";
        return entityManager.createQuery(JPAql, Role.class).setParameter("name", name)
                .getResultStream().collect(Collectors.toSet());
    }

    @Override
    public List<Role> getRoles() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    public  Set<Role> getById(Long id) {
        String JPAql = "SELECT role FROM Role role WHERE role.id = :id";
        return entityManager.createQuery(JPAql, Role.class).getResultStream().collect(Collectors.toSet());
    }
}
