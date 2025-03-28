package info.thomasdau;

import java.util.ArrayList;
import java.util.List;

public class Company extends Progression{
    private List<Manager> managers;

    public Company(String name, double progressionRate) {
        super(name, progressionRate);
        this.managers = new ArrayList<>();
    }

    public void hireManager(Manager manager) {
        managers.add(manager);
        System.out.println(manager.getName() + " now works for " + name);
    }

    public void fireManager(Manager manager) {
        managers.remove(manager);
        System.out.println(manager.getName() + " has been fired from " + name);
    }

    public double getProficency(Character character) {
        double totalEfficiency = 0;
        if (managers != null) {
            for (Manager manager : managers) {
                totalEfficiency += manager.getProficency(character);
            }
        }
        return (totalEfficiency + character.getIntelligence());
    }

    // Getters and setters
    public List<Manager> getManagers() { return managers; }
}