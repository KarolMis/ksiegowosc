package models;

import java.io.Serializable;

public class Admin extends User implements Serializable {

    public Admin(String login, String password) {
        super(login,password);
    }
}
