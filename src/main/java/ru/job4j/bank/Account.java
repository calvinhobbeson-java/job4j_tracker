package ru.job4j.bank;

import java.util.Objects;

/**
 * Class describes functionality of account
 * @author Calvin Hobbeson
 * @version 1.0
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     * Constructor for account
     * @param requisite unique id of any account
     * @param balance amount of money on account
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Getter for a requisite
     * @return requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Setter for a requisite
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Getter for balance
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Getter for balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}