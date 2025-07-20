package org.example.test4m.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.test4m.entity.User;
import org.example.test4m.repositories.InMemoryUserRepository;
import org.example.test4m.repositories.UserRepository;
import org.example.test4m.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository inMemoryUserRepository;

    @Override
    public List<User> getAllUsers() {
        return inMemoryUserRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return inMemoryUserRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return null;
    }

    @Override
    public User createUser(User user) {
        user.setId(null);
        return inMemoryUserRepository.save(user);
    }

    @Override
    public User updateUser(Long id,User user) {
        Optional<User> userOptional = inMemoryUserRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User not found"+id);
        }
        user.setId(id);
        return inMemoryUserRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        inMemoryUserRepository.deleteById(id);
    }
}
