package info.thomasdau;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import java.util.Random;

@QuarkusMain
public class GameLoop implements QuarkusApplication {
    private Character character;
    private boolean gameRunning = true;
    private Random random = new Random();
    private int tickCount = 0;

    @Override
    public int run(String... args) throws Exception {
        character = new Character("Hero");
        character.startJob();
        System.out.println("Game started!");

        while (gameRunning) {
            Thread.sleep(1000);
            updateGame();
            renderGame();
            tickCount++;


            
            if (character.getJob().getLevel() >= 3 && character.getManager() == null && character.getStage() == 1) {
                character.transitionToManager();
            }

            if (character.getStage() == 2 && character.getManager().getLevel() >= 10) {
                    character.transitionToOwner();
                }

            if (character.getStage() == 3 && character.getOwner().getLevel() >= 10) {
                System.out.println("You Win! You hit level 10 and maxed out the current content!");
                gameRunning = false;
            }

        }
        return 0;
    }

    private void updateGame() {
        if (tickCount % 2 == 0 && random.nextDouble() < 0.8) {
            character.updateProgress();
        }
    }

    private void renderGame() {
        System.out.println("Rendering game...");
    }
}
