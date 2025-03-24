package info.thomasdau;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class GameLoop implements QuarkusApplication {
    private Character character;
    private Job job;

    @Override
    public int run(String... args) throws Exception{
        System.out.println("Game started!");
        character = new Character("Hero");
        character.addItem(new Item("Basic Pickaxe", "A simple pickaxe", 1, 0, 0, 10));
        character.applyItemBonuses();
        job = new Job("Miner", 0.1);
        startGameLoop();
        return 0; // Normal Termination
    }

    private void startGameLoop() {
        while (true) {
            updateGame();
            renderGame();
            try{
                Thread.sleep(16); // ~60fps
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateGame() {
        job.updateProgress(character);
        System.out.println("Job progress: " + job.getProgress());
    }

    private void renderGame() {
        System.out.println("Rendering game...");
    }
}
