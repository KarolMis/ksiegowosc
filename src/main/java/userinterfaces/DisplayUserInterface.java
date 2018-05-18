package userinterfaces;

import controllers.CompanyController;
import enums.State;
import exceptions.AccountantNotFoundException;
import exceptions.AdminNotFoundException;
import models.Accountant;
import models.AccountantRegistry;
import models.Admin;
import models.AdminRegistry;

import java.util.Scanner;



public class DisplayUserInterface {

    private State state = State.INIT;
    private Scanner scanner = new Scanner(System.in);


    public void runApp() {
        while (state != State.EXIT) {
            switch (state) {
                case INIT: {
                    startUserInterface();
                    state = init();
                    break;
                }

                case LOGGING_IN_AS_ACCOUNTANT: {
                    state = loggingAsAccountant();
                    break;
                }

                case LOGGING_IN_AS_ADMIN: {
                    state = loggingAsAdmin();
                    break;
                }

                case LOGGED_IN_AS_ACCOUNTANT: {
                    state = loggedAsAccountant();
                    break;
                }

                case LOGGED_IN_AS_ADMIN: {
                    state = loggedAsAdmin();
                    break;
                }
                case CREATING_COMPANY: {
                    state = creatingCompany();
                    break;
                }
            }
        }
    }

    private State init(){
        switch (scanner.nextInt()) {

            case 1:
                state = State.LOGGING_IN_AS_ADMIN;
                scanner.nextLine();
                break;

            case 2:
                state = State.LOGGING_IN_AS_ACCOUNTANT;
                scanner.nextLine();
                break;

            case 0:
                state = State.EXIT;
                scanner.nextLine();
                break;

            default:
                System.out.println("Zła odpowiedź");
                state = State.INIT;
                scanner.nextLine();
                break;
        }
        return state;

    }

    private State loggingAsAccountant() {
        System.out.println("Podaj login:");
        String login = scanner.nextLine();

        System.out.println("Podaj hasło:");
        String password = scanner.nextLine();

        try {
            Accountant currentAccountant = AccountantRegistry.getInstance().findAccountant(login, password);
            System.out.println("Dzień dobry " + currentAccountant.getLogin());
            state = State.LOGGED_IN_AS_ACCOUNTANT;

        } catch (AccountantNotFoundException e) {
            System.out.println("Zły login lub hasło");
            state = State.INIT;
        }
        return state;
    }

    private State loggingAsAdmin() {
        System.out.println("Podaj login:");
        String login = scanner.nextLine();

        System.out.println("Podaj hasło:");
        String password = scanner.nextLine();

        try {
            Admin currentAdmin = AdminRegistry.getInstance().findAdmin(login, password);
            System.out.println("Dzień dobry " + currentAdmin.getLogin());
            state = State.LOGGED_IN_AS_ADMIN;

        } catch (AdminNotFoundException e) {
            System.out.println("Zły login lub hasło");
            state = State.INIT;
        }
        return state;
    }

    private State loggedAsAccountant() {
        return State.LOGGED_IN_AS_ADMIN;
    }


    private State loggedAsAdmin() {
        System.out.println("Co chcesz zrobić?");
        System.out.println(" 1 - wypisać wszystkie firmy");
        System.out.println(" 2 - dodać firmę");
        System.out.println(" 0 - wyjść z programu");

        switch (scanner.nextInt()) {
            case 1:
                CompanyController.listCompanies();
                state = State.LOGGED_IN_AS_ADMIN;
                scanner.nextLine();
                break;

            case 2:
                state = State.CREATING_COMPANY;
                scanner.nextLine();
                break;

            case 0:
                state = State.EXIT;
                scanner.nextLine();
                break;

            default:
                System.out.println("Zła odpowiedź");
                state = State.INIT;
                scanner.nextLine();
                break;
        }
        return state;
    }

    private State creatingCompany() {
        System.out.println("Podaj nazwę nowej firmy:");
        String name = scanner.nextLine();

        System.out.println("Podaj rok założenia nowej firmy:");
        int yearFound = scanner.nextInt();
        scanner.nextLine();

        CompanyController.createCompany(name, yearFound);

        return State.LOGGED_IN_AS_ADMIN;
    }

    private void startUserInterface() {
        System.out.println("Dzień dobry, co chcesz zrobić?");
        System.out.println(" 1 - zalogować się jako admin");
        System.out.println(" 2 - zalogować się jako księgowy");
        System.out.println(" 0 - wyjść z programu");
    }
}
