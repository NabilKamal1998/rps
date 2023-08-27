package game;

import java.util.Random;
public class DifficultyLevels {
    public static int chooseEasyDifficulty(Random random){
        return random.nextInt(3) + 1;
    }

    public static int chooseMediumDifficulty(int playerChoice, Random random){
        int randomChoice = random.nextInt(3) + 1;

        if(playerChoice == 1){
            return (randomChoice == 2) ? 2 : randomChoice;
        } else if (playerChoice == 2) {
            return (randomChoice == 3) ? 3 : randomChoice;
        } else {
            return (randomChoice == 1) ? 1 : randomChoice;
        }
    }

    public static int chooseHardDifficulty(int playerChoice, Random random){
        return random.nextInt(3) + 1;
    }
}
