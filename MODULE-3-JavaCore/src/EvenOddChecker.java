import java.util.Scanner;
public class EvenOddChecker {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter a number: ");
    double num = scanner.nextDouble();

    if (num==1) {
      System.out.println("1 is neither odd nor even.");
    }
    else if (num%2==0) {
      System.out.println("The number is even.");
    }
    else {
      System.out.println("The number is odd.");
    }
    scanner.close();
  }
}