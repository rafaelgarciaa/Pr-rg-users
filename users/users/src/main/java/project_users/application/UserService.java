package project_users.application;

import project_users.domain.model.users.User;
import project_users.domain.model.usersDto.UserDTO;
import project_users.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepositoryPort;

    public UserService(UserRepository userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    public User createUser(UserDTO user) { return userRepositoryPort.save(user); }
    public List<User> getAllUsers() { return userRepositoryPort.findAll(); }
    public Optional<User> getUserById(Long id) { return userRepositoryPort.findById(id); }
    public void deleteUser(Long id) { userRepositoryPort.deleteById(id); }
}
