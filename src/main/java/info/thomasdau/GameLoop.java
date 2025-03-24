package info.thomasdau;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@QuarkusMain
public class GameLoop implements QuarkusApplication {
    private Character character;
    private Job job;
    private ScheduledExecutorService scheduler;
    private boolean gameRunning = true;
    private Random random = new Random();
    private int tickCount = 0;

    @Override
    public int run(String... args) throws Exception{
        System.out.println("Game started!");
        character = new Character("Hero");
        character.addItem(new Item("Basic Pickaxe", "A simple pickaxe", 1, 0, 0, 10));
        character.applyItemBonuses();
        job = new Job("Miner", 0.1);
        
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::updateGame, 1, 1, TimeUnit.SECONDS);

        while (gameRunning) {
            Thread.sleep(1000);
            renderGame();
            tickCount++;

            // Example
            if (job.getLevel() >= 2 ) {
                gameRunning = false;
                System.out.println("Game ended: Job Level reached 2.");
            }
        }

        scheduler.shutdown();
        return 0;
    }

    private void updateGame() {
        System.out.println("Job progress: " + job.getProgress());

        if (tickCount % 2 == 0 && random.nextDouble() < 0.8) {
            job.updateProgress(character);
        }
    }

    private void renderGame() {
        System.out.println("Rendering game...");
    }
}
