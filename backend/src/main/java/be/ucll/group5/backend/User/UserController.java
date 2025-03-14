package be.ucll.group5.backend.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService = new UserService();

    public UserController() {
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userName}")
    public User getUser(
            @PathVariable String userName) {
        return userService.getUser(userName);
    }

    @PostMapping
    public User addUser(User user) {
        return userService.addUser(user);
    }

    @PutMapping("/{userName}")
    public User updateUser(@PathVariable String userName, User user) {
        return userService.updateUser(userName, user);
    }

    @DeleteMapping("/{userName}")
    public void deleteUser(@PathVariable String userName) {
        userService.deleteUser(userName);
    }
}
