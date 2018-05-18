package models;

import java.io.Serializable;

public class Accountant extends User implements Serializable {

    public Accountant(String login, String password) {
        super(login, password);
    }
}
