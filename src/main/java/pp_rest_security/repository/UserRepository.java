package pp_rest_security.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pp_rest_security.model.User;

import java.util.List;


@Repository
public interface UserRepository  {

    List<User> getAllUsers();

    User getUserById(long id);
    void create(User user);
    void saveUser(User user);

    void deleteById(long id);

 @Query("select p from User p join fetch p.roles where p.email = :email")
  User findUserByEmail(String email);
}
