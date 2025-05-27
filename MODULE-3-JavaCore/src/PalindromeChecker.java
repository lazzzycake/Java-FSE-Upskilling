import java.util.Scanner;

public class PalindromeChecker {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String original = scanner.nextLine();

    String cleaned = original.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    String reversed = new StringBuilder(cleaned).reverse().toString();

    if (cleaned.equals(reversed)) {
      System.out.println("It's a palindrome!");
    } else {
      System.out.println("Not a palindrome.");
    }
    scanner.close();
  }
}
