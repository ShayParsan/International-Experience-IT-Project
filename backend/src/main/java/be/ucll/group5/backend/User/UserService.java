package be.ucll.group5.backend.User;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository = new UserRepository();

    public UserService() {
    }

    public List<User> getUsers() {
        if (userRepository.getUsers().isEmpty()) {
            throw new IllegalArgumentException("No users found");
        }
        return userRepository.getUsers();
    }

    public User getUser(String userName) {
        if (userRepository.getUser(userName) == null) {
            throw new IllegalArgumentException("User not found");

        }
        return userRepository.getUser(userName);
    }

    public User addUser(User user) {
        userRepository.addUser(user);
        return user;
    }

    public User updateUser(String userName, User user) {
        if (userRepository.getUser(userName) == null) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.updateUser(userName, user);
        return user;
    }

    public void deleteUser(String userName) {
        if (userRepository.getUser(userName) == null) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteUser(userName);
    }

}
