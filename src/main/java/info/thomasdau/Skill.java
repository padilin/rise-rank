package info.thomasdau;

public class Skill {
    private String name;
    private String description;
    private int level;
    private double effectMultiplier;

    public Skill(String name, String description, double effectMultiplier) {
        this.name = name;
        this.description = description;
        this.level = 1;
        this.effectMultiplier = effectMultiplier;
    }

    public void levelUp() {
        level++;
        effectMultiplier += 0.1; // Example: Increase effect by 10% per level
        System.out.println(name + " leveled up to level " + level + "!");
    }

    // Getters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public double getEffectMultiplier() { return effectMultiplier; }
    public void getEffectMultiplier(double effectMultiplier) { this.effectMultiplier = effectMultiplier; }
}
