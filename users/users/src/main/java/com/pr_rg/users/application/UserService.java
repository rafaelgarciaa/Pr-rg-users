package com.pr_rg.users.application;

import com.pr_rg.users.domain.model.User;
import com.pr_rg.users.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepositoryPort;

    public UserService(UserRepository userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    public User createUser(User user) { return userRepositoryPort.save(user); }
    public List<User> getAllUsers() { return userRepositoryPort.findAll(); }
    public Optional<User> getUserById(Long id) { return userRepositoryPort.findById(id); }
    public void deleteUser(Long id) { userRepositoryPort.deleteById(id); }
}
