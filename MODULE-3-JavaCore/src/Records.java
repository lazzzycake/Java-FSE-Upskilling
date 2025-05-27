import java.util.List;

public class Records {
    public record Person(String name, int age) {}

    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 17)
        );

        people.stream()
              .filter(p -> p.age() >= 18)
              .forEach(p -> System.out.println(p.name() + " is an adult."));
    }
}
