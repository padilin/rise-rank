package info.thomasdau;

public abstract class Progression implements Upgradeable{
    protected String name;
    protected double progress;
    protected double progressRate;
    protected int level;
    protected int targetProgress;

    protected Progression(String name, double progressionRate) {
        this.name = name;
        this.progress = 0;
        this.progressRate = progressionRate;
        this.level = 1;
        this.targetProgress = 5;
    }

    public void levelUp() {
        level++;
        progress = 0;
        System.out.println(name + " leveld up to level " + level + "!");
    }

    public void updateProgress(Character character) {
        // Example intelligence causes exp rate
        progress += getProficency(character);
        if (progress >= targetProgress) {
            levelUp();
        }
        System.out.println(character.getName() + " - " + name + " progress: " + progress);
    }

    // Getters and setters
    public String getName() {return name;}
    public void setName(String name) { this.name = name; }
    
    public double getProgress() { return progress; }
    public void setProgress(double progress) { this.progress = progress; }
    
    public double getProgressRate() { return progressRate; }
    public void setProgressRate(double progressionRate) { this.progressRate = progressionRate; }
    
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    
    public int getTargetProgress() { return targetProgress; }
    public void setTargetProcess(int targetProgress) { this.targetProgress = targetProgress; }
}
