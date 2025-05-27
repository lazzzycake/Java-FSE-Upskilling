import java.util.Scanner;

public class TypeCasting {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a double value:");
        double d = scanner.nextDouble();
        int i = (int) d; // explicit casting
        System.out.println("Double to int: " + i);


        System.out.println("Enter an int value");
        int j =scanner.nextInt();
        double k = j; // implicit casting
        System.out.println("Int to double: " + k);
        scanner.close();
    }
}
