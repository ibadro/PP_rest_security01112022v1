package pp_rest_security.service;


import pp_rest_security.model.User;

import java.util.List;

public interface UserService {
    User findUserById(long id);

    List<User> getUsers();

    void saveUser(User user);

    void editUser(User user);

    void deleteById(long id);
    User findUserByEmail(String email);
}
