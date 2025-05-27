import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int numberToGuess = random.nextInt(100) + 1;
    int guess;

    System.out.println("Guess a number between 1 and 100:");

    do {
      guess = scanner.nextInt();
      if (guess > numberToGuess) {
        System.out.println("Too high! Try again:");
      } else if (guess < numberToGuess) {
        System.out.println("Too low! Try again:");
      }
    } while (guess != numberToGuess);

    System.out.println("Correct! You guessed the number.");
    scanner.close();
  }
}

