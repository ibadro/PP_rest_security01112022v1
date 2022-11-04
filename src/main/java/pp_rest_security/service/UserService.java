package pp_rest_security.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pp_rest_security.model.User;

import java.util.List;

public interface UserService {
    List<User> getListUsers();

    User getUserById(long id);

    User getUserByEmail(String email);

    void addUser(User user);

    void updateUser(User newUser);

    void deleteUser(long id);

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
