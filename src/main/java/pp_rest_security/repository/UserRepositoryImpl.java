package pp_rest_security.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pp_rest_security.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteById(long id) {
        String JPAql = "DELETE FROM User user WHERE user.id = :id";
        entityManager.createQuery(JPAql).setParameter("id", id).executeUpdate();
    }

    @Override
    public User findUserByEmail(String email) {
        String JPAql ="SELECT u from User u join fetch u.roles where u.email = :email";
        return entityManager.createQuery(JPAql, User.class).setParameter("email", email).getSingleResult();
    }
}
