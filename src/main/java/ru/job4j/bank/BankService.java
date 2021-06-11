package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class describes functionality of a bank transaction service
 * @author Calvin Hobbeson
 * @version 1.0
 */

public class BankService {
    /**
     * A collection , Map type, has been used as a data storage
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Method adds user to a Map, if there is no such user
     * Method also adds an empty ArrayList for accounts, connected to specific user
     * @param user user that method adds
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Method finds a user by passport as a first step, then checks if user exist
     * Then method adds account to a ArrayList, if there is no such account
     * @param passport unique parameter of any user
     * @param account is account than any user can have
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accs = users.get(user);
            if (!accs.contains(account)) {
                accs.add(account);
            }
        }
    }

    /**
     * Method first gets key and value, then searching a user by passport
     * @param passport unique parameter of any user
     * @return user
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Method searches a user by passport,
     * finds his account list and search account there, then returns it
     * @param passport unique parameter of any user
     * @param requisite unique parameter of any account
     * @return account of a user
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accs = users.get(user);
            for (Account account : accs) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
            return result;
        }

    /**
     * Methoc transfers money from one account to another
     * @param srcPassport passport of a user, who transfers money
     * @param srcRequisite requisite of account, which is used to transfer money from
     * @param destPassport passport of a user, who gets the transfer money
     * @param destRequisite requisite of account, where money is transferred
     * @param amount amount of money we want to transfer
     * @return true if transfer was succesfull, or false if not
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount  = findByRequisite(srcPassport, srcRequisite);
        Account destAccount  = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}