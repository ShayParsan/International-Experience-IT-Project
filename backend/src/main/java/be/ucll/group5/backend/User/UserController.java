package be.ucll.group5.backend.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User Management", description = "APIs for managing users")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get all users", description = "Returns a list of all users in the system")
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @Operation(summary = "Get user by username", description = "Returns user details by username")
    @GetMapping("/{userName}")
    public User getUser(@PathVariable String userName) {
        return userService.getUser(userName);
    }

    @Operation(summary = "Add a new user", description = "Creates a new user")
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @Operation(summary = "Update user", description = "Updates an existing user by username")
    @PutMapping("/{userName}")
    public User updateUser(@PathVariable String userName, @RequestBody User user) {
        return userService.updateUser(userName, user);
    }

    @Operation(summary = "Delete user", description = "Deletes a user by username")
    @DeleteMapping("/{userName}")
    public void deleteUser(@PathVariable String userName) {
        userService.deleteUser(userName);
    }
}