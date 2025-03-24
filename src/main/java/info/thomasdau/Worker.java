package info.thomasdau;

public class Worker {
    private String name;
    private double efficiency;

    public Worker(String name, double efficiency) {
        this.name = name;
        this.efficiency = efficiency;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getEfficiency() { return efficiency; }
    public void setEfficiency(double efficiency) { this.efficiency = efficiency; }
}