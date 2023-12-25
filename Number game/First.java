import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame
{
    public static void main(String[] args) 
   {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int totalScore = 0;

        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Try to guess the number between " + minRange + " and " + maxRange);

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! Your guess is correct. It took you " + attempts + " attempts.");
                    totalScore += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Sorry, your guess is too low. Try again.");
                } else {
                    System.out.println("Sorry, your guess is too high. Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thank you for playing! Your total score is: " + totalScore);

        scanner.close();
    }
}