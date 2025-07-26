import java.util.Random;
import java.util.Scanner;

class NumberGuessGame {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        int secretNumber = randomGenerator.nextInt(100) + 1;

        System.out.println("Guess the number between 1 to 100");
        System.out.println("I've picked a number... it's your turn!");

        Scanner userInput = new Scanner(System.in);
        int differenceLimit = 15;
        int maxTries = 7;
        int currentTry = 0;
        boolean isGuessedCorrectly = false;

        while (currentTry < maxTries) {
            System.out.println("Attempt " + (currentTry + 1));
            System.out.print("Enter your guess: ");
            int userGuess = userInput.nextInt();
            currentTry++;

            if (userGuess == secretNumber) {
                System.out.println("You guessed it right!!!! 🎉");
                isGuessedCorrectly = true;
                break;
            } else if (userGuess > secretNumber + differenceLimit) {
                System.out.println("Too high! Try again.");
            } else if (userGuess > secretNumber) {
                System.out.println("A bit high! Try again.");
            } else if (userGuess < secretNumber - differenceLimit) {
                System.out.println("Too low! Try again.");
            } else if (userGuess < secretNumber) {
                System.out.println("A bit low! Try again.");
            }

            userInput.nextLine(); 
            System.out.print("Type 'exit' to quit or press Enter to continue: ");
            String userDecision = userInput.nextLine();
            if (userDecision.equalsIgnoreCase("exit")) {
                break;
            }
        }

        if (!isGuessedCorrectly) {
            System.out.println("Game over. The number was: " + secretNumber);
        }

        int finalScore = isGuessedCorrectly ? (maxTries - currentTry + 1) * 20 : 0;
        System.out.println("Your score: " + finalScore);

        userInput.close();
    }
}