package info.thomasdau;

public interface Upgradeable {
    double getProgress();
    void updateProgress(Character character);
    double getProficency(Character character);
}
