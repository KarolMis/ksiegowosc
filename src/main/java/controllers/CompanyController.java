package controllers;

import models.Company;
import models.CompanyRegistry;
import views.CompanyView;

public class CompanyController {
    public static void createCompany(String name, int yearFound) {
        CompanyRegistry.getInstance().add(new Company(name, yearFound));
    }

    public static void listCompanies() {
        CompanyView.printCompanies(CompanyRegistry.getInstance().getCompanies());
    }
}
