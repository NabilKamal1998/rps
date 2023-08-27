import java.util.Scanner;
import java.util.Random;

import game.DifficultyLevels;
import game.Player;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Player humanPlayer = new Player("Player");
        Player computerPlayer = new Player("Computer");

        System.out.println("Rock Paper Scissors");

        while (true) {
            int difficultyChoice = chooseDifficulty(scanner);

            if (difficultyChoice == 4) {
                break;
            }

            while (humanPlayer.getHealth() > 0 && computerPlayer.getHealth() > 0) {
                int playerChoice = getPlayerChoice(scanner);

                int computerChoice;
                switch (difficultyChoice) {
                    case 1:
                        computerChoice = random.nextInt(3) + 1;
                        break;
                    case 2:
                        computerChoice = DifficultyLevels.chooseMediumDifficulty(playerChoice, random);
                        break;
                    case 3:
                        computerChoice = DifficultyLevels.chooseHardDifficulty(playerChoice, random);
                        break;
                    default:
                        System.out.println("Invalid difficulty choice");
                        continue;
                }

                humanPlayer.setChoice(playerChoice);
                computerPlayer.setChoice(computerChoice);

                displayChoices(playerChoice, computerChoice);
                int roundResult = determineRoundResult(playerChoice, computerChoice);
                updateScoresAndHealth(humanPlayer, computerPlayer, roundResult);

                displayScoresAndHealth(humanPlayer.getScore(), computerPlayer.getScore(), humanPlayer.getHealth(), computerPlayer.getHealth());
            }

            displayGameResult(humanPlayer.getHealth(), computerPlayer.getHealth());

            humanPlayer.resetScore();
            computerPlayer.resetScore();
            humanPlayer.resetHealth();
            computerPlayer.resetHealth();
        }
    }

    public static int chooseDifficulty(Scanner scanner) {
        System.out.println("Select difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.println("4. Exit");
        return scanner.nextInt();
    }

    public static int getPlayerChoice(Scanner scanner) {
        System.out.println("Choose your object:");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
        return scanner.nextInt();
    }

    public static void displayChoices(int playerChoice, int computerChoice) {
        System.out.println("Computer chose: " + getChoiceString(computerChoice));
        System.out.println("Player chose: " + getChoiceString(playerChoice));
    }

    public static int determineRoundResult(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            System.out.println("It's a tie! Try again!");
            return 0;
        } else if ((playerChoice == 1 && computerChoice == 3) || (playerChoice == 2 && computerChoice == 1) || (playerChoice == 3 && computerChoice == 2)) {
            System.out.println("You win! Go again");
            return 1;
        } else {
            System.out.println("Computer wins!");
            return -1;
        }
    }

    public static void updateScoresAndHealth(Player humanPlayer, Player computerPlayer, int roundResult) {
        if (roundResult == 1) {
            computerPlayer.setHealth(computerPlayer.getHealth() - 1); // Computer loses health
        } else if (roundResult == -1) {
            humanPlayer.setHealth(humanPlayer.getHealth() - 1); // Player loses health
        }
    }

    public static void displayScoresAndHealth(int playerScore, int computerScore, int playerHealth, int computerHealth) {
        System.out.println("Player Score: " + playerScore);
        System.out.println("Computer Score: " + computerScore);
        System.out.println("Player Health: " + playerHealth);
        System.out.println("Computer Health: " + computerHealth);
    }

    public static void displayGameResult(int playerHealth, int computerHealth) {
        if (playerHealth <= 0) {
            System.out.println("Game over! Computer wins!");
        } else if (computerHealth <= 0) {
            System.out.println("Game over! Player wins!");
        }
    }


    public static String getChoiceString(int choice) {
        switch (choice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Invalid choice";
        }
    }
}

