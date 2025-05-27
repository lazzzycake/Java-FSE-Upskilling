public class PatternMatching {
    public static void checkObject(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("Integer with value: " + i);
            case String s -> System.out.println("String with value: " + s);
            case Double d -> System.out.println("Double with value: " + d);
            case null -> System.out.println("Object is null");
            default -> System.out.println("Unknown type: " + obj.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        checkObject(42);
        checkObject("hello");
        checkObject(3.14);
        checkObject(null);
        checkObject(true);
    }
}
