package controllers;

import exceptions.AdminNotFoundException;
import models.AdminRegistry;

public class AdminController {

    public void addAdmin(String login, String password){
        AdminRegistry.getInstance().addAdmin(login, password);
    }

    public void removeAdmin(String login) throws AdminNotFoundException {
        AdminRegistry.getInstance().removeAdmin(login);
    }
}
