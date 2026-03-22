package project_users.infrastructure.repository;

import project_users.domain.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import project_users.domain.model.usersDto.UserDTO;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    User save(UserDTO user);

    List<User> findAll();

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
