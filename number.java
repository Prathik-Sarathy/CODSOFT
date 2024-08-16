import java.util.*;
public class number 
{
    private static final int MAX_ATTEMPTS = 10;
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRounds = 0;
        int totalAttempts = 0;
        String playAgain = "y";
        while (playAgain.equalsIgnoreCase("y")) 
        {
            int attempts = playGame(scanner, random);
            totalRounds++;
            totalAttempts += attempts;
            double averageAttempts = (double) totalAttempts / totalRounds;
            System.out.printf("\nRound %d finished.%n", totalRounds);
            System.out.printf("Your average number of attempts per round: %.2f%n", averageAttempts);
            System.out.print("Do you want to play another round? (y/n): ");
            playAgain = scanner.nextLine();
        }
        System.out.printf("\nThanks for playing! You played %d rounds.%n", totalRounds);
        scanner.close();
    }
    private static int playGame(Scanner scanner, Random random) 
    {
        int numberToGuess = random.nextInt(100) + 1; 
        int attempts = 0;
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");
        while (attempts < MAX_ATTEMPTS) 
        {
            System.out.print("Enter your guess: ");
            int guess;
            try 
            {
                guess = Integer.parseInt(scanner.nextLine());
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input. Please enter an integer.");
                continue;
            }
            attempts++;
            if (guess < numberToGuess) 
            {
                System.out.println("Too low!");
            } 
            else if (guess > numberToGuess) 
            {
                System.out.println("Too high!");
            } 
            else 
            {
                System.out.printf("Congratulations! You guessed the number %d correctly in %d attempts.%n", numberToGuess, attempts);
                return attempts; 
            }
        }

        System.out.printf("Sorry, you've used all %d attempts. The number was %d.%n", MAX_ATTEMPTS, numberToGuess);
        return MAX_ATTEMPTS; 
    }
}
