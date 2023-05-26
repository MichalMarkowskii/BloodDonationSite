package com.example.stronahtml;

/**
 * Klasa User reprezentuje pojedynczego użytkownika i przechowuje informacje
 * o jego danych podawanych w procesie rejestracji.
 */

public class User {

    private static String firstName;
    private static String lastName;
    private static String email;
    private static String password;

    public User() {
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        User.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        User.lastName = lastName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }
}
