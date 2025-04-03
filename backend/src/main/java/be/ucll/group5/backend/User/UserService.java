package be.ucll.group5.backend.User;

import be.ucll.group5.backend.Reward.Reward;
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

    public User addUser(UserInput userInput) {
        if (userRepository.findByUserName(userInput.username()) != null) {
            throw new IllegalArgumentException("User already exists");
        }
        final var user = new User(
                userInput.username(),
                userInput.password(),
                userInput.email(),
                userInput.firstName(),
                userInput.lastName());

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

    public List<Reward> getUserRewards(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return user.getRewards();
    }
}
