# CODSOFT
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private Scanner scanner;
    private Random random;
    private List<Player> leaderboard;

    public NumberGame() {
        scanner = new Scanner(System.in);
        random = new Random();
        leaderboard = new ArrayList<>();
    }

    public static void main(String[] args) {
        NumberGame game = new NumberGame();
        game.start();
    }

    public void start() {
        boolean continuePlaying = true;

        while (continuePlaying) {
            System.out.println("==== Welcome to the Custom Number Guessing Game! ====");
            int maxAttempts = chooseDifficulty();
            int targetNumber = random.nextInt(100) + 1;
            boolean isCorrectGuess = playGame(maxAttempts, targetNumber);

            if (isCorrectGuess) {
                System.out.print("Congratulations! Please enter your name for the leaderboard: ");
                String playerName = scanner.next();
                leaderboard.add(new Player(playerName, maxAttempts));
                Collections.sort(leaderboard);
            }

            continuePlaying = askToPlayAgain();
        }

        displayLeaderboard();
        System.out.println("Thank you for playing! See you next time.");
    }

    private int chooseDifficulty() {
        int easyMaxAttempts = 10;
        int mediumMaxAttempts = 7;
        int hardMaxAttempts = 5;
        int difficulty = 0;

        while (difficulty == 0) {
            System.out.println("Choose your difficulty level:");
            System.out.println("1. Easy (" + easyMaxAttempts + " attempts)");
            System.out.println("2. Medium (" + mediumMaxAttempts + " attempts)");
            System.out.println("3. Hard (" + hardMaxAttempts + " attempts)");
            System.out.print("Enter your choice (1-3): ");
            
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        difficulty = easyMaxAttempts;
                        break;
                    case 2:
                        difficulty = mediumMaxAttempts;
                        break;
                    case 3:
                        difficulty = hardMaxAttempts;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                        break;
                }
            } else {
                System.out.print("Invalid input. Please enter a number between 1 and 3: ");
                scanner.next();
            }
        }
        return difficulty;
    }

    private boolean playGame(int maxAttempts, int targetNumber) {
        System.out.println("I have generated a number between 1 and 100. Try to guess it!");
        int attemptsUsed = 0;
        boolean guessedCorrectly = false;

        while (attemptsUsed < maxAttempts && !guessedCorrectly) {
            System.out.print("Attempt " + (attemptsUsed + 1) + ": Enter your guess: ");
            
            if (scanner.hasNextInt()) {
                int userGuess = scanner.nextInt();
                attemptsUsed++;

                if (userGuess < targetNumber) {
                    System.out.println("Too low!");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You've guessed the number in " + attemptsUsed + " attempts.");
                    guessedCorrectly = true;
                }
            } else {
                System.out.print("Invalid input. Please enter a valid number: ");
                scanner.next();
            }
        }

        if (!guessedCorrectly) {
            System.out.println("You've used all attempts. The correct number was " + targetNumber + ".");
        }

        return guessedCorrectly;
    }

    private boolean askToPlayAgain() {
        boolean validResponse = false;
        boolean playAgain = false;

        while (!validResponse) {
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (response.equals("yes")) {
                playAgain = true;
                validResponse = true;
            } else if (response.equals("no")) {
                validResponse = true;
            } else {
                System.out.println("Invalid response. Please enter 'yes' or 'no'.");
            }
        }

        return playAgain;
    }

    private void displayLeaderboard() {
        System.out.println("==== Leaderboard ====");
        for (Player player : leaderboard) {
            System.out.println(player);
        }
    }

    private class Player implements Comparable<Player> {
        String name;
        int attempts;

        Player(String name, int attempts) {
            this.name = name;
            this.attempts = attempts;
        }

        @Override
        public int compareTo(Player other) {
            return Integer.compare(this.attempts, other.attempts);
        }

        @Override
        public String toString() {
            return name + " - " + attempts + " attempts";
        }
    }
}

