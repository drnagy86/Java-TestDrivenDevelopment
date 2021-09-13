package com.nagy;

import java.time.LocalDate;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int heightInInches;
    private double weightInPounds;
    private LocalDate dateOfBirth;
    private boolean alive;

    // set up default, public and static for access, static so it can not be changed
    public static final String DEFAULT_FIRST_NAME = "John";
    public static final String DEFAULT_LAST_NAME = "Doe";
    public static final int DEFAULT_HEIGHT_IN_INCHES = 0;
    public static final double DEFAULT_WEIGHT_IN_POUNDS = 0;
    public static final LocalDate DEFAULT_DATE_OF_BIRTH = LocalDate.now();
    public static final boolean DEFAULT_ALIVE = true;

    //   Boundary Cases

    public static final int MIN_FIRST_NAME_LENGTH = 1;
    public static final int MAX_FIRST_NAME_LENGTH = 25;
    public static final int MIN_LAST_NAME_LENGTH = 1;
    public static final int MAX_LAST_NAME_LENGTH = 25;
    public static final int MIN_HEIGHT = 0;
    public static final int MAX_HEIGHT = 100;
    public static final double MIN_WEIGHT = 0;
    public static final double MAX_WEIGHT = 1000;
    public static final LocalDate MIN_DATE_OF_BIRTH = LocalDate.now();

    // String messages
    public static final String MSG_FIRST_NAME_NULL_ERROR = "The first name can not be null.";
    public static final String MSG_FIRST_NAME_NONE_ERROR = "The first name is required.";
    public static final String MSG_FIRST_NAME_LENGTH_ERROR = "The first name can not be longer than \" + MAX_FIRST_NAME_LENGTH\n" +
            "                    + \" characters.";



    public Person(String firstName, String lastName, int heightInInches, double weightInPounds, LocalDate dateOfBirth, boolean alive) {
        validateFirstName(firstName);
        validateLastName(lastName);
        validateHeightInInches(heightInInches);
        validateWeightInPounds(weightInPounds);
        validateDateOfBirth(dateOfBirth);

        this.firstName = firstName;
        this.lastName = lastName;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
        this.dateOfBirth = dateOfBirth;
        this.alive = alive;
    }

    public Person(){
        this(DEFAULT_FIRST_NAME,DEFAULT_LAST_NAME,DEFAULT_HEIGHT_IN_INCHES,DEFAULT_WEIGHT_IN_POUNDS,DEFAULT_DATE_OF_BIRTH,DEFAULT_ALIVE);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public int getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches) {
        validateHeightInInches(heightInInches);
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        validateWeightInPounds(weightInPounds);
        this.weightInPounds = weightInPounds;
    }

    public LocalDate getDateOfBirth() {
        validateDateOfBirth(dateOfBirth);
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        validateDateOfBirth(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", heightInInches=" + heightInInches +
                ", weightInPounds=" + weightInPounds +
                ", dateOfBirth=" + dateOfBirth +
                ", alive=" + alive +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        int result = this.lastName.compareToIgnoreCase(o.lastName);
        if(result == 0){
            return this.firstName.compareToIgnoreCase(o.firstName);
        }
        return result;
    }

    private void validateDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth.isAfter(MIN_DATE_OF_BIRTH)){
            throw new IllegalArgumentException("The date of birth cannot be in the future");
        }}

    private void validateFirstName(String firstName){
        if (firstName == null){
            throw new IllegalArgumentException(MSG_FIRST_NAME_NULL_ERROR);
        } else if (firstName.equals("")){
            throw new IllegalArgumentException(MSG_FIRST_NAME_NONE_ERROR);
        } else if (firstName.length() > MAX_FIRST_NAME_LENGTH){
            throw new IllegalArgumentException(MSG_FIRST_NAME_LENGTH_ERROR);
        }
    }

    private void validateLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("The last name cannot be null.");
        } else if (lastName.length() < MIN_LAST_NAME_LENGTH) {
            throw new IllegalArgumentException("The last name must be at least " + MIN_LAST_NAME_LENGTH + " characters in length.");
        } else if (lastName.length() > MAX_LAST_NAME_LENGTH) {
            throw new IllegalArgumentException("The last name cannot be more than " + MAX_FIRST_NAME_LENGTH + " characters in length.");
        }
    }
    private void validateHeightInInches(int heightInInches) {
        if (heightInInches < MIN_HEIGHT) {
            throw new IllegalArgumentException("The height in inches cannot be less than " + MIN_HEIGHT);
        } else if (heightInInches > MAX_HEIGHT) {
            throw new IllegalArgumentException("The height in inches cannot be greater than " + MAX_HEIGHT);
        }
    }
    private void validateWeightInPounds(double weightInPounds) {
        if (weightInPounds < MIN_WEIGHT) {
            throw new IllegalArgumentException("The weight in pounds cannot be less than " + MIN_WEIGHT);
        } else if (weightInPounds > MAX_WEIGHT) {
            throw new IllegalArgumentException("The weight in pounds cannot be greater than " + MAX_WEIGHT);
        }
    }



    }
