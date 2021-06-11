package ru.job4j.bank;

import java.util.Objects;

/**
 * Class describes functionality of user
 * @author Calvin Hobbeson
 * @version 1.0
 */

public class User {
    private String passport;
    private String username;

    /**
     * Constructor for account
     * @param passport unique id of any user
     * @param username ame and surname of a user
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Getter for a passport
     * @return passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Setter for a passport
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Getter for a username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for a username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}