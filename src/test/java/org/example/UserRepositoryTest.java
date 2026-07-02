package org.example;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveAndFindUserById() {
        User user = new User("test@example.com", "password123");
        User saved = userRepository.save(user);
        assertNotNull(saved.getId(), "Saved User should have generated id");

        Optional<User> found = userRepository.findById(saved.getId());
        assertTrue(found.isPresent(), "User should be found by id");
        assertEquals("test@example.com", found.get().getEmail());
    }

    @Test
    void findByEmail() {
        User user = new User("john@example.com", "securePassword");
        userRepository.save(user);

        Optional<User> found = userRepository.findByEmail("john@example.com");
        assertTrue(found.isPresent(), "User should be found by email");
        assertEquals("john@example.com", found.get().getEmail());
    }
}

