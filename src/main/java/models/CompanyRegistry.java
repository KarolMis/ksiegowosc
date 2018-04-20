package models;

import java.util.ArrayList;
import java.util.List;

public class CompanyRegistry {
    private static CompanyRegistry instance = null;

        public static CompanyRegistry getInstance() {
            if(instance == null) {
                    instance = new CompanyRegistry();
            }
            return instance;
        }

        private ArrayList<Company> companies;

        public CompanyRegistry() {
            this.companies = new ArrayList<>();
            this.companies.add(new Company("Ziutex sp. z o.o.", 1990));
            this.companies.add(new Company("Krakbud s.j.", 1995));
        }

        public List<Company> getCompanies() {
            return this.companies;
        }

        public void add(Company company) {
            this.companies.add(company);
        }
}
