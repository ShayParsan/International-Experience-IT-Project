package be.ucll.group5.backend.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<User>();

    public UserRepository() {
        users.add(new User("user1", "password1", "user1@example.com", "FirstName1", "LastName1"));
        users.add(new User("user2", "password2", "user2@example.com", "FirstName2", "LastName2"));
        users.add(new User("user3", "password3", "user3@example.com", "FirstName3", "LastName3"));
        users.add(new User("user4", "password4", "user4@example.com", "FirstName4", "LastName4"));
        users.add(new User("user5", "password5", "user5@example.com", "FirstName5", "LastName5"));
        users.add(new User("user6", "password6", "user6@example.com", "FirstName6", "LastName6"));
        users.add(new User("user7", "password7", "user7@example.com", "FirstName7", "LastName7"));
        users.add(new User("user8", "password8", "user8@example.com", "FirstName8", "LastName8"));
        users.add(new User("user9", "password9", "user9@example.com", "FirstName9", "LastName9"));
        users.add(new User("user10", "password10", "user10@example.com", "FirstName10", "LastName10"));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void updateUser(String userName, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userName)) {
                users.set(i, user);
                return;
            }
        }
    }

    public void deleteUser(String userName) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userName)) {
                users.remove(i);
                return;
            }
        }
    }

}
