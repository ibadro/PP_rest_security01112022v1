package pp_rest_security.repository;


import org.springframework.data.jpa.repository.Query;
import pp_rest_security.model.User;

import java.util.List;


public interface UserRepository {
    List<User> getListUsers();

    User getUserById(long id);

    void addUser(User user);

    void updateUser(User newUser);

    void deleteUser(long id);

    @Query("select p from User p join fetch p.roles where p.email = :email")
    User getUserByEmail(String email);
}