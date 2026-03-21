package com.pr_rg.users.infrastructure.repository;

import com.pr_rg.users.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
