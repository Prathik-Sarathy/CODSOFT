import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String playAgain = "yes";
        while (playAgain.equalsIgnoreCase("yes")) {
            System.out.print("Choose a difficulty level (1-5): ");
            int difficulty = scanner.nextInt();
            if (difficulty < 1 || difficulty > 5) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }
            int minValue = 1;
            int maxValue = 100;
            int attemptsLeft = difficulty;
            int numberToGuess = random.nextInt(maxValue - minValue + 1) + minValue;
            System.out.printf("Welcome to the Number Guessing Game! You have %d attempts to guess the number between %d and %d.%n", attemptsLeft, minValue, maxValue);
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                if (userGuess < numberToGuess) 
                {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number!");
                    break;
                }
                attemptsLeft--;
                System.out.printf("You have %d attempts left.%n", attemptsLeft);
            }
            if (attemptsLeft == 0) {
                System.out.printf("Sorry, you didn't guess the number. The correct number was %d.%n", numberToGuess);
            }
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
        }
        scanner.close();
    }
}