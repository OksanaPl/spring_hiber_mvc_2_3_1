package web.repository;

import web.model.User;

import java.util.List;

public interface UserRepository {

    void addUser(String firstName, String lastName);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteById(Long id);

}

