package models;

import exceptions.AdminNotFoundException;

import java.util.ArrayList;

public class AdminRegistry {
    private static AdminRegistry instance = null;

    private ArrayList<Admin> admins;

    public static AdminRegistry getInstance() {
       if(instance == null) {
            instance = new AdminRegistry();
       }
       return instance;
    }

    public AdminRegistry() {
        this.admins = new ArrayList<>();
        this.admins.add(new Admin("adam", "123"));
        this.admins.add(new Admin("ziutek", "456"));
    }


    public Admin findAdmin(String login, String password) throws AdminNotFoundException {
        for(Admin admin : admins) {
            if(admin.getLogin().equals(login) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        throw new AdminNotFoundException();
    }
}

