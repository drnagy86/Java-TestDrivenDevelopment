package com.nagy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void getFirstName() {
        assertEquals(Person.DEFAULT_FIRST_NAME, person.getFirstName());
    }

    @Test
    void setFirstName() {
        fail("This test failed.");
    }

    @Test
    void getLastName() {
        assertEquals(Person.DEFAULT_LAST_NAME, person.getLastName());
    }

    @Test
    void setLastName() {
        fail("This test failed.");
    }

    @Test
    void getHeightInInches() {
        assertEquals(Person.DEFAULT_HEIGHT_IN_INCHES, person.getHeightInInches());
    }

    @Test
    void setHeightInInches() {
        fail("This test failed.");
    }

    @Test
    void getWeightInPounds() {
        assertEquals(Person.DEFAULT_WEIGHT_IN_POUNDS, person.getWeightInPounds(), 0.0001);
    }

    @Test
    void setWeightInPounds() {
        fail("This test failed.");
    }

    @Test
    void getDateOfBirth() {
        assertEquals(Person.DEFAULT_DATE_OF_BIRTH, person.getDateOfBirth());
    }

    @Test
    void setDateOfBirth() {
        fail("Failed");

    }

    @Test
    void isAlive() {
        assertEquals(Person.DEFAULT_ALIVE, person.isAlive());
    }

    @Test
    void setAlive() {
        fail("This test failed.");
    }

    @Test
    void testToString() {
        String expected = "Person{" +
                "firstName='" + Person.DEFAULT_FIRST_NAME + '\'' +
                ", lastName='" + Person.DEFAULT_LAST_NAME + '\'' +
                ", heightInInches=" + Person.DEFAULT_HEIGHT_IN_INCHES +
                ", weightInPounds=" + Person.DEFAULT_WEIGHT_IN_POUNDS +
                ", dateOfBirth=" + Person.DEFAULT_DATE_OF_BIRTH +
                ", alive=" + Person.DEFAULT_ALIVE +
                '}';

        assertEquals(
                expected,
                person.toString()
        );
    }

    @Test
    void compareToLastNameBeforeOther() {
        Person other = new Person();

//        Compare to Last name letter z
        other.setLastName("Z");
        int result = person.compareTo(other);
//        if the result is less than 0, true
        assertTrue(result < 0);
    }

    @Test
    void compareToLastNameAfterOther() {
        // person is John Doe
        // otherPerson is John A
        Person otherPerson = new Person();
        otherPerson.setLastName("A");
        int result = person.compareTo(otherPerson);
        assertTrue(result > 0);
    }

    @Test
    void compareToLastNameSame() {
        Person other = new Person();
        int result = person.compareTo(other);
        assertTrue((result == 0));
    }


    @Test
    void compareToLastNameSameFirstNameAfter() {
        Person other = new Person();
        other.setFirstName("Z");
        int result = person.compareTo(other);
        assertTrue((result < 0));
    }

    @Test
    void compareToLastNameSameFirstNameBefore() {
        Person other = new Person();
        other.setFirstName("A");
        int result = person.compareTo(other);
        assertTrue((result > 0));
    }

}
