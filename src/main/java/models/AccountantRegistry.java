package models;

import exceptions.AccountantNotFoundException;

import java.util.ArrayList;

public class AccountantRegistry {
    private static AccountantRegistry instance = null;

    private ArrayList<Accountant> accountants;

    public static AccountantRegistry getInstance() {
        if(instance == null) {
            instance = new AccountantRegistry();
        }
        return instance;
    }

    private AccountantRegistry() {
        this.accountants = new ArrayList<>();
        this.accountants.add(new Accountant("marek", "123"));
        this.accountants.add(new Accountant("marcin", "456"));
    }


    public Accountant findAccountant(String login, String password) throws AccountantNotFoundException {
        for(Accountant accountant : accountants) {
            if(accountant.getLogin().equals(login) && accountant.getPassword().equals(password)) {
                return accountant;
            }
        }
        throw new AccountantNotFoundException();
    }

    public void addAccountant(String login, String password) {
        accountants.add(new Accountant(login, password));
    }

    public void removeAccountant(String login) throws AccountantNotFoundException {
        for(Accountant accountant : accountants) {
            if(accountant.getLogin().equals(login)){
                accountants.remove(accountant);
            }
        }
        throw new AccountantNotFoundException();
    }
}
