package be.ucll.group5.backend.User;

import java.util.List;

public class UserController {
    private UserService userService = new UserService();

    public UserController() {
    }

    public List<User> getUsers() {
        return userService.getUsers();
    }

    public User getUser(String userName) {
        return userService.getUser(userName);
    }

    public User addUser(User user) {
        return userService.addUser(user);
    }

    public User updateUser(String userName, User user) {
        return userService.updateUser(userName, user);
    }

    public void deleteUser(String userName) {
        userService.deleteUser(userName);
    }
}
