package hw3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("admin", "12345");
    }

    @Test
    void testAuthenticationSuccess() {
        assertThat(user.authenticate("admin", "12345")).isTrue();
    }

    @Test
    void testAuthenticationWrongLogin() {
        assertThat(user.authenticate("user", "12345")).isFalse();
    }

    @Test
    void testAuthenticationWrongPassword() {
        assertThat(user.authenticate("admin", "password")).isFalse();
    }

    @Test
    void testAuthenticationWrongLoginAndPassword() {
        assertThat(user.authenticate("user", "password")).isFalse();
    }

}