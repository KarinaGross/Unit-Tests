package hw3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CheckNumberTest {
    private CheckNumber checkNumber;

    @BeforeEach
    public void setUp() {
        checkNumber = new CheckNumber();
    }

    @Test
    void testNumIsOdd() {
        assertThat(checkNumber.evenOddNumber(2)).isTrue();
    }

    @Test
    void testNumIsNotOdd() {
        assertThat(checkNumber.evenOddNumber(3)).isFalse();
    }

    @Test
    void testNumInIntervalFrom25To100() {
        assertThat(checkNumber.numberInInterval(50)).isTrue();
    }

    @Test
    void testNumNotInIntervalFrom25To100() {
        assertThat(checkNumber.numberInInterval(20)).isFalse();
        assertThat(checkNumber.numberInInterval(25)).isFalse();
        assertThat(checkNumber.numberInInterval(100)).isFalse();
        assertThat(checkNumber.numberInInterval(150)).isFalse();
    }
}