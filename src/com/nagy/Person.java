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



    public Person(String firstName, String lastName, int heightInInches, double weightInPounds, LocalDate dateOfBirth, boolean alive) {
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
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches) {
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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
}
