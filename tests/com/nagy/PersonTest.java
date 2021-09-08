package com.nagy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

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
    void getLastName() {
        assertEquals(Person.DEFAULT_LAST_NAME, person.getLastName());
    }

    @Test
    void getHeightInInches() {
        assertEquals(Person.DEFAULT_HEIGHT_IN_INCHES, person.getHeightInInches());
    }

    @Test
    void getWeightInPounds() {
        assertEquals(Person.DEFAULT_WEIGHT_IN_POUNDS, person.getWeightInPounds(), 0.0001);
    }

    @Test
    void getDateOfBirth() {
        assertEquals(Person.DEFAULT_DATE_OF_BIRTH, person.getDateOfBirth());
    }

    @Test
    void isAlive() {
        assertEquals(Person.DEFAULT_ALIVE, person.isAlive());
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

    @Test
    void setFirstNameMinLettersGood() {
//        is one char good?
        String newFirstName = buildString(Person.MIN_FIRST_NAME_LENGTH);
        person.setFirstName(newFirstName);
        assertEquals(newFirstName, person.getFirstName());
    }

    @Test
    void setFirstNameMaxLettersGood() {
        String newFirstName = buildString(Person.MAX_LAST_NAME_LENGTH);
        person.setFirstName(newFirstName);
        assertEquals(newFirstName, person.getFirstName());
    }


    @Test
    void setLastNameMinLettersGood() {
        String newLastName = buildString(Person.MIN_LAST_NAME_LENGTH);
        person.setLastName(newLastName);
        assertEquals(newLastName, person.getLastName());
    }

    @Test
    void setLastNameMaxLettersGood() {
        String newLastName = buildString(Person.MAX_LAST_NAME_LENGTH);
        person.setLastName(newLastName);
        assertEquals(newLastName, person.getLastName());
    }

    @Test
    void setHeightInInchesMinGood() {
        int newHeightInInches = Person.MIN_HEIGHT;
        person.setHeightInInches(newHeightInInches);
        assertEquals(newHeightInInches, person.getHeightInInches());

    }

    @Test
    void setHeightInInchesMaxGood() {
        int newHeightInInches = Person.MAX_HEIGHT;
        person.setHeightInInches(newHeightInInches);
        assertEquals(newHeightInInches, person.getHeightInInches());
    }

    @Test
    void setWeightInPoundsMinGood() {
        double newWeightInPounds = Person.MIN_WEIGHT;
        person.setWeightInPounds(newWeightInPounds);
        assertEquals(newWeightInPounds, person.getWeightInPounds());
    }

    @Test
    void setWeightInPoundsMaxGood() {
        double newWeightInPounds = Person.MAX_WEIGHT;
        person.setWeightInPounds(newWeightInPounds);
        assertEquals(newWeightInPounds, person.getWeightInPounds());
    }

    @Test
    void setDateOfBirthMinGood() {
        LocalDate newDateOfBirth = Person.MIN_DATE_OF_BIRTH;
        person.setDateOfBirth((newDateOfBirth));
        assertEquals(newDateOfBirth, person.getDateOfBirth());
    }

    @Test
    void setDateOfBirthInThePastGood() {
        LocalDate newDateOfBirth = Person.MIN_DATE_OF_BIRTH.minusDays(1);
        person.setDateOfBirth(newDateOfBirth);
        assertEquals(newDateOfBirth, person.getDateOfBirth());
    }

    @Test
    void setAlive() {
        boolean newAlive = false;
        person.setAlive(newAlive);
        assertEquals(newAlive, person.isAlive());
    }

    @Test
    void setDateOfBirthMaxBad() {
        LocalDate newDateOfBirth = Person.MIN_DATE_OF_BIRTH.plusDays(1);
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                person.setDateOfBirth(newDateOfBirth);
            }
        });
    }

    //    Helper Method to create names
    private String buildString(int length){
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i++){
            chars[i] = 'X';
        }
        return new String(chars);
    }

}
