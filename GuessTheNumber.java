import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 10;
        int maxRounds = 5;
        int score = 0;

        for (int round = 1; round <= maxRounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("Round " + round + " of " + maxRounds + ": Guess the number between 1 and 100");

            while (attempts < maxAttempts && !guessed) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    guessed = true;
                    int points = maxAttempts - attempts + 1;
                    score += points;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts. You earned " + points + " points.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("The number is higher. Try again.");
                } else {
                    System.out.println("The number is lower. Try again.");
                }
            }

            if (!guessed) {
                System.out.println("You've used all your attempts. The number was " + numberToGuess + ".");
            }
        }

        System.out.println("Game over! Your total score is: " + score);
        scanner.close();
    }
}
