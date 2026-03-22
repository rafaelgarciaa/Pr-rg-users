package project_users.application;

import project_users.domain.model.users.User;
import project_users.domain.model.usersDto.UserDTO;
import project_users.infrastructure.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User userEntity;
    private UserDTO userRequest;

    @BeforeEach
    void setUp() {
        userEntity = new User(1L, "Rafael Garcia", "rafa@example.com");
        userRequest = new UserDTO("Rafael Garcia", "rafa@example.com");
    }

    @Test
    void shouldSaveUserSuccessfully() {
        when(userRepository.save((UserDTO) any())).thenReturn(userEntity);
        User savedUser = userService.createUser(userRequest);
        assertNotNull(savedUser);
        assertEquals("Rafael Garcia", savedUser.getName());
        verify(userRepository, times(1)).save((UserDTO) any());
    }

    @Test
    void shouldReturnAllUsers() {
        when(userRepository.findAll()).thenReturn(Collections.singletonList(userEntity));

        List<User> users = userService.getAllUsers();

        assertFalse(users.isEmpty());
        assertEquals(1, users.size());
        assertEquals("Rafael Garcia", users.getFirst().getName());
    }

    @Test
    void shouldFindUserById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));

        Optional<User> foundUser = userService.getUserById(1L);

        assertTrue(foundUser.isPresent());
        assertEquals(userEntity.getEmail(), foundUser.get().getEmail());
    }

    @Test
    void shouldDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);

        userService.deleteUser(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }
}