package be.ucll.group5.backend.User;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new IllegalArgumentException("No users found");
        }
        return users;
    }

    public User getUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String userName, User user) {
        User existingUser = getUser(userName);
        user.setId(existingUser.getId()); // Ensure ID remains the same
        return userRepository.save(user);
    }

    public void deleteUser(String userName) {
        User user = getUser(userName);
        userRepository.delete(user);
    }
}