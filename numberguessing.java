import java.util.Scanner;
import java.util,Scanner;


public class NumberGuessingGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int ROUNDS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + ROUNDS + " rounds to play.");

        for (int round = 1; round <= ROUNDS; round++) {
            System.out.println("\nRound " + round + ":");
            int numberToGuess = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess (between " + MIN_NUMBER + " and " + MAX_NUMBER + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the number correctly!");
                    guessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }

                System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was: " + numberToGuess);
            }

            int roundScore = calculateScore(attempts, guessedCorrectly);
            totalScore += roundScore;
            System.out.println("Round " + round + " score: " + roundScore);
        }

        System.out.println("\nGame Over!");
        System.out.println("Your total score: " + totalScore);
        scanner.close();
    }

    private static int calculateScore(int attempts, boolean guessedCorrectly) {
        if (!guessedCorrectly) {
            return 0;
        }
        // Score is inversely proportional to the number of attempts
        return MAX_ATTEMPTS - attempts + 1;
    }
}




       