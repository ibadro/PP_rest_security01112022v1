package pp_rest_security.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pp_rest_security.model.User;
import pp_rest_security.service.RoleService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private RoleService roleService;

    public UserRepositoryImpl(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public List<User> getListUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public User getUserByEmail(String email) {
        return entityManager.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email).getSingleResult();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void updateUser(User newUser) {
        entityManager.merge(newUser);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));
    }
}
