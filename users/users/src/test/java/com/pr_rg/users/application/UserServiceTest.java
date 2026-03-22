package com.pr_rg.users.application;

import com.pr_rg.users.domain.model.users.User;
import com.pr_rg.users.infrastructure.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository; // Simulamos la interfaz del dominio

    @InjectMocks
    private UserService userService; // Inyectamos el mock en el servicio

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(1L, "Rafael Garcia", "rafa@example.com");
    }

    @Test
    void shouldSaveUserSuccessfully() {
        when(userRepository.save(any(User.class))).thenReturn(user);
        User savedUser = userService.createUser(user);
        assertNotNull(savedUser);
        assertEquals("Rafael Garcia", savedUser.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void shouldReturnAllUsers() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        List<User> users = userService.getAllUsers();
        assertFalse(users.isEmpty());
        assertEquals(1, users.size());
    }

    @Test
    void shouldFindUserById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Optional<User> foundUser = userService.getUserById(1L);
        assertTrue(foundUser.isPresent());
        assertEquals(user.getEmail(), foundUser.get().getEmail());
    }

    @Test
    void shouldDeleteUser() {
        userService.deleteUser(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }
}