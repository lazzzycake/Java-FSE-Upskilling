import java.util.Scanner;

public class SimpleCalculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the first number: ");
    double num1 = scanner.nextDouble();

    System.out.println("Enter the Second number: ");
    double num2 = scanner.nextDouble();

    System.out.println("Enter the Operator( +, -, *, /): ");
    char op = scanner.next().charAt(0);

    double result = 0;

    switch (op) {
      case '+':
        result=num1+num2;
        break;
      case '-':
        result=num1-num2;
        break;
      case '*':
        result= num1*num2;
        break;
      case '/':
        if (num2 !=0) {
          result=num1/num2;
        }
        else {
          System.out.println("Division error! Second number should be >0");
        }
        break;
      default:
        System.out.println("Invalid Operator");
        break;
    }
    System.out.println("Result: "+result);
    scanner.close();
  }
}
