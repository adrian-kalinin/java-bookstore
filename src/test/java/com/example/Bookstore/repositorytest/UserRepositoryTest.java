package com.example.Bookstore.repositorytest;

import com.example.Bookstore.model.User;
import com.example.Bookstore.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void createUser() {
        User user = new User("username", "password", "username@example.com", "USER");
        userRepository.save(user);

        List<User> foundUsers = userRepository.findAll();
        assertThat(foundUsers).hasSize(1);
    }

    @Test
    void deleteUser() {
        User user = new User("username", "password", "username@example.com", "USER");
        userRepository.save(user);
        userRepository.delete(user);

        List<User> foundUsers = userRepository.findAll();
        assertThat(foundUsers).hasSize(0);
    }

    @Test
    void findUserByUsername() {
        User user = new User("username", "password", "username@example.com", "USER");
        userRepository.save(user);

        User foundUser = userRepository.findByUsername("username");
        assertThat(foundUser).isEqualTo(user);
    }

    @Test
    void findUserByEmail() {
        User user = new User("username", "password", "username@example.com", "USER");
        userRepository.save(user);

        User foundUser = userRepository.findByEmail("username@example.com");
        assertThat(foundUser).isEqualTo(user);
    }

}
