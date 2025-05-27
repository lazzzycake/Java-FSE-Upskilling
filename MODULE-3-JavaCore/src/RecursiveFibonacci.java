import java.util.Scanner;

public class RecursiveFibonacci {

  public static int fibonacci(int n) {
    if (n < 0) return -1;         // Invalid input
    if (n <= 1) return n;         // Base cases: 0 or 1
    return fibonacci(n - 1) + fibonacci(n - 2); 
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a non-negative integer: ");
    
    int n = scanner.nextInt();

    if (n < 0) {
      System.out.println("Please enter a non-negative integer.");
    } else {
      int result = fibonacci(n);
      System.out.println("Fibonacci number at position " + n + " is " + result);
    }

    scanner.close();
  }
}
