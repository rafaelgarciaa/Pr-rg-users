package com.pr_rg.users.infrastructure.adapter;

import com.pr_rg.users.domain.model.User;
import com.pr_rg.users.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class UserRepositoryAdapter implements UserRepository {

    private final UserRepository jpaUserRepository;

    public UserRepositoryAdapter(UserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User save(User user) {
        return jpaUserRepository.save(user);
    }

    @Override
    public java.util.List<User> findAll() {
        return jpaUserRepository.findAll();
    }

    @Override
    public java.util.Optional<User> findById(Long id) {
        return jpaUserRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        jpaUserRepository.deleteById(id);
    }
}