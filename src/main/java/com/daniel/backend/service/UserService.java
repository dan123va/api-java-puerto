package com.daniel.backend.service;

import java.util.Optional;
import com.daniel.backend.document.User;
import com.daniel.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(
            UserRepository  userRepository
    ) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public Optional<User> update(
        String id,
        User user
    ) {

        Optional<User> existingUser = userRepository.findById(id);

        if (!existingUser.isPresent()) {
            return Optional.empty();
        }

        User userToUpdate = existingUser.get();

        userToUpdate.setName(user.getName());
        userToUpdate.setPrice(user.getPrice());

        User updatedUser = userRepository.save(userToUpdate);

        return Optional.of(updatedUser);
    }

    public boolean deleteById(String id) {
        if (!userRepository.existsById(id)) {
            return false;
        }

        userRepository.deleteById(id);
        
        return true;
    }
}