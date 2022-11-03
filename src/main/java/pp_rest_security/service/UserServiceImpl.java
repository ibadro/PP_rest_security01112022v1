package pp_rest_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pp_rest_security.model.User;
import pp_rest_security.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserById(long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userFromDb = userRepository.findUserByEmail(user.getEmail());
        if(userFromDb != null) {
            throw new RuntimeException("такой пользователь уже есть");
        }
        userRepository.saveUser(user);
    }

    @Override
    public void editUser(User user) {
        if (!user.getPassword().equals(userRepository.getUserById(user.getId()).getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.saveUser(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

}
