package info.thomasdau;

import java.util.ArrayList;
import java.util.List;

public class Owner  extends Progression{
    private List<Company> companies;

    public Owner(String name, double progressRate) {
        super(name, progressRate);
        this.companies = new ArrayList<>();
    }

    public void addCompany(Company company) {
        companies.add(company);
        System.out.println("Now own " + name + "!");
    }

    public void dumpCompany(Company company) {
        companies.remove(company);
        System.out.println("Now disowned " + name + "!");
    }

    @Override
    public double getProficency(Character character) {
        double totalEfficiency = 0;
        if (companies != null) {
            for (Company company : companies) {
                totalEfficiency += company.getProficency(character);
            }
        }
        return (totalEfficiency + character.getIntelligence()) * progressRate;
    }

    public List<Company> getCompanies() { return companies; }
}
