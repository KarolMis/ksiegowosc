package views;

import models.Company;

import java.util.List;

public class CompanyView {
    public static void printCompanies(List<Company> companies) {
        for(Company company : companies) {
            System.out.println(company.getName() + " (rok założenia: " + company.getYearFound() + ")");
        }
    }
}
