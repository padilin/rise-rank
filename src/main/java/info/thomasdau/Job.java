package info.thomasdau;

public class Job {
    private String name;
    private int level;
    private double progress;
    private double progressRate;

    public Job(String name, double progressRate) {
        this.name = name;
        this.level = 1;
        this.progress = 0;
        this.progressRate = progressRate;
    }

    public void updateProgress(Character character) {
        // Example intelligence causes exp rate
        progress += progressRate * character.getIntelligence();
        if (progress >= 3) {
            levelUp();
        }
    }

    public void levelUp() {
        level++;
        progress = 0;
        System.out.println(name + " leveld up to level " + level + "!");
    }

    // Getters and setters
    public String getName() {return name;}
    public void setName(String name) { this.name = name; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public double getProgress() { return progress; }
    public void setProgress(double progress) {this.progress = progress; }

    public double getProgressRate() { return progressRate; }
    public void setProgressRate(double progressRate) {this.progressRate = progressRate; }
}
