package models;

public class Company {
    private String name;
    private int yearFound;

    public Company(String name, int yearFound) {
        this.name = name;
        this.yearFound = yearFound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearFound() {
        return yearFound;
    }

    public void setYearFound(int yearFound) {
        this.yearFound = yearFound;
    }
}
