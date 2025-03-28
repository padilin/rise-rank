package info.thomasdau;

public class Job extends Progression {

    public Job(String name, double progressRate) {
        super(name, progressRate);
    }

    @Override
    public double getProficency(Character character) {
        return character.getIntelligence() * progressRate * 5;
    }

}
