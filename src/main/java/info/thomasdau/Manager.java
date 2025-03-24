package info.thomasdau;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private String name;
    private List<Worker> workers;
    private double teamProgress;
    private double teamProgressRate;

    public Manager(String name, double teamProgressRate) {
        this.name = name;
        this.workers = new ArrayList<>();
        this.teamProgress = 0;
        this.teamProgressRate = teamProgressRate;
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public void updateTeamProgress(Character character) {
        teamProgress += teamProgressRate * character.getIntelligence();
        System.out.println("Team progress: " + teamProgress);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Worker> getWorkers() { return workers; }

    public double getTeamProgress() { return teamProgress; }
    public void setTeamProgress(double teamProgress) { this.teamProgress = teamProgress; }
}
