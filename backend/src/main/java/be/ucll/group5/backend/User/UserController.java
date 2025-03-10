package be.ucll.group5.backend.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService = new UserService();

    public UserController() {
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{userName}")
    public User getUser(String userName) {
        return userService.getUser(userName);
    }

    @PostMapping("/users")
    public User addUser(User user) {
        return userService.addUser(user);
    }

    @PutMapping("/users/{userName}")
    public User updateUser(String userName, User user) {
        return userService.updateUser(userName, user);
    }

    @DeleteMapping("/users/{userName}")
    public void deleteUser(String userName) {
        userService.deleteUser(userName);
    }
}
