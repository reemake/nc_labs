package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    Human person;

    @BeforeEach
    void setUp() { person = new Human(); }

    @Test
    void calcAgeTest() {
        person.setBirthday("1996-02-26");
        int expectedValue = 25;
        int actualValue = person.calcAge();

        assertEquals(expectedValue, actualValue);
    }
}