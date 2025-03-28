package info.thomasdau;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Progression {
    private List<Character> team;
    private List<Manager> leaders;

    public Manager(String name, double progressRate) {
        super(name, progressRate);
        this.team = new ArrayList<>();
        this.leaders = new ArrayList<>();
    }

    public void hireWorker(Character worker) {
        team.add(worker);
        System.out.println(worker.getName() + " hired!");
    }

    public void fireWorker(Character worker) {
        team.remove(worker);
        System.out.println(worker.getName() + " fired!");
    }

    public void hireLeader(Manager manager) {
        leaders.add(manager);
        System.out.println("Leader " + manager.getName() + " hired!");
    }

    public void fireLeader(Manager manager) {
        leaders.remove(manager);
        System.out.println("Leader " + manager.getName() + " fired!");
    }

    public void upgradeTeam(double upgradeRate) {
        progressRate += upgradeRate;
        System.out.println("Team upgraded! Progress rate: " + progressRate); 
    }

    @Override
    public double getProficency(Character character) {
        double totalEfficiency = 0;
        if (team != null) {
            for (Character worker : team) {
                totalEfficiency += worker.getIntelligence();
            }
        }
        if (leaders != null) {
            for (Manager leader : leaders) {
                totalEfficiency += leader.getProficency(character);
            }
        }
        return (totalEfficiency + character.getIntelligence()) * progressRate;
    }

    public List<Character> getTeam() { return team; }
}
