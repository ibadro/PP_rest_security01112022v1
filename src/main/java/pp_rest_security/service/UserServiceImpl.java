package pp_rest_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public List<User> getListUsers() {
        return userRepository.getListUsers();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.addUser(user);
    }

    @Override
    public void updateUser(User newUser) {
        if (newUser.getPassword().equals("")) {
            newUser.setPassword(userRepository.getUserById(newUser.getId()).getPassword());
        } else {
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        }
        userRepository.updateUser(newUser);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.getUserByEmail(email);
    }
}
