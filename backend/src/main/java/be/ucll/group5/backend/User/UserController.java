package be.ucll.group5.backend.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/users")
@Api(value = "User Management System", description = "Operations pertaining to user in User Management System")
public class UserController {
    @Autowired
    private UserService userService = new UserService();

    public UserController() {
    }

    @ApiOperation(value = "View a list of available users", response = List.class)
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @ApiOperation(value = "Get a user by userName")
    @GetMapping("/{userName}")
    public User getUser(
            @ApiParam(value = "User name to retrieve user object", required = true) @PathVariable String userName) {
        return userService.getUser(userName);
    }

    @ApiOperation(value = "Add a user")
    @PostMapping
    public User addUser(
            @ApiParam(value = "User object to be added", required = true) @RequestBody User user) {
        return userService.addUser(user);
    }

    @ApiOperation(value = "Update a user")
    @PutMapping("/{userName}")
    public User updateUser(
            @ApiParam(value = "User name to update user object", required = true) @PathVariable String userName,
            @ApiParam(value = "Updated user object", required = true) @RequestBody User user) {
        return userService.updateUser(userName, user);
    }

    @ApiOperation(value = "Delete a user")
    @DeleteMapping("/{userName}")
    public void deleteUser(
            @ApiParam(value = "User name to delete user object", required = true) @PathVariable String userName) {
        userService.deleteUser(userName);
    }
}