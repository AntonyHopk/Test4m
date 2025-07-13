package org.example.test4m.services;

import org.example.test4m.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    Optional<User> getUserByName(String name);

    User createUser(User user);

    User updateUser(Long id ,User user);

    void deleteUser(Long id);
}
