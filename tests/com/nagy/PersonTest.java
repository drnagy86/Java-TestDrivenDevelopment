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
    // Test to see if the excpection is there
//    @Test
//    void setFirstNameNullBad() {
//        String newFirstName = null;
//        assertThrows(IllegalArgumentException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                person.setFirstName(newFirstName);
//            }
//        });
//    }

    // test to see if it is the correct message
    @Test
    void setFirstNameNullBad() {
        String newFirstName = null;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {

            public void execute() throws Throwable {
                person.setFirstName(newFirstName);
            }
        });
        String expected = Person.MSG_FIRST_NAME_NULL_ERROR;
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    // test to see if it is the correct message
    @Test
    void setFirstNameNoneBad() {
        String newFirstName = "";
//        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
//
//            public void execute() throws Throwable {
//                person.setFirstName(newFirstName);
//            }
//        });

        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> person.setFirstName(newFirstName));

        String expected = Person.MSG_FIRST_NAME_NONE_ERROR;
        String actual = exception1.getMessage();
        assertEquals(expected,actual);
    }

    // test to see if it is the correct message
    @Test
    void setFirstNameLengthBad() {
        String newFirstName = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {

            public void execute() throws Throwable {
                person.setFirstName(newFirstName);
            }
        });
        String expected = Person.MSG_FIRST_NAME_LENGTH_ERROR;
        String actual = exception.getMessage();
        assertEquals(expected,actual);
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

    // start super copy
    @Test
    void setLastNameNullBad() {
        String newLastName = null;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                person.setLastName(newLastName);
            }
        });
        String expectedMessage = "The last name cannot be null.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void setLastNameMinLettersBad() {
        String newLastName = buildString(Person.MIN_LAST_NAME_LENGTH - 1);
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                person.setLastName(newLastName);
            }
        });
        String expectedMessage = "The last name must be at least " + Person.MIN_LAST_NAME_LENGTH + " characters in length.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void setLastNameMaxLettersBad() {
        String newLastName = buildString(Person.MAX_LAST_NAME_LENGTH + 1);
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                person.setLastName(newLastName);
            }
        });
        String expectedMessage = "The last name cannot be more than " + Person.MAX_FIRST_NAME_LENGTH + " characters in length.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void setHeightInInchesMinBad() {
        int newHeightInInches = Person.MIN_HEIGHT - 1;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                person.setHeightInInches(newHeightInInches);
            }
        });
        String expectedMessage = "The height in inches cannot be less than " + Person.MIN_HEIGHT;
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void setHeightInInchesMaxBad() {
        int newHeightInInches = Person.MAX_HEIGHT + 1;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                person.setHeightInInches(newHeightInInches);
            }
        });
        String expectedMessage = "The height in inches cannot be greater than " + Person.MAX_HEIGHT;
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void setWeightInPoundsMinBad() {
        double newWeightInPounds = Person.MIN_WEIGHT - 1;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                person.setWeightInPounds(newWeightInPounds);
            }
        });
        String expectedMessage = "The weight in pounds cannot be less than " + Person.MIN_WEIGHT;
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void setWeightInPoundsMaxBad() {
        double newWeightInPounds = Person.MAX_WEIGHT + 1;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                person.setWeightInPounds(newWeightInPounds);
            }
        });
        String expectedMessage = "The weight in pounds cannot be greater than " + Person.MAX_WEIGHT;
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }



    // end super copy


    //    Helper Method to create names
    private String buildString(int length){
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i++){
            chars[i] = 'X';
        }
        return new String(chars);
    }

}
