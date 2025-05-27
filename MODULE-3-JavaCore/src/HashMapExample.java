import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Adding entries
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // consume newline
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            studentMap.put(id, name);
        }

        // Retrieve by ID
        System.out.print("Enter student ID to search: ");
        int searchId = scanner.nextInt();
        String studentName = studentMap.get(searchId);
        if (studentName != null) {
            System.out.println("Student Name: " + studentName);
        } else {
            System.out.println("No student found with ID " + searchId);
        }
        scanner.close();
    }
}
