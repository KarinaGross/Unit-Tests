package hw3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class UserRepositoryTest {
    private UserRepository userRepository;
    private User user;

    @BeforeEach
    public void setup() {
        userRepository = new UserRepository();
        user = new User("admin", "12345");
    }

    @Test
    public void testAddUserWithCorrectCredentials() {
        boolean result = userRepository.addUser(user, "admin", "12345");

        assertThat(result).isTrue();
        assertThat(userRepository.getUsers()).contains(user);

    }

    @Test
    public void testAddUserWithIncorrectCredentials() {
        boolean result = userRepository.addUser(user, "wrongAdmin", "wrongPass");

        assertThat(result).isFalse();
        assertThat(userRepository.getUsers()).doesNotContain(user);
    }
}