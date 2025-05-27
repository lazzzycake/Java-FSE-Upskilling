public class Car {
  String make, model;
  int year;

  Car(String make, String model, int year) {
    this.make = make;
    this.model = model;
    this.year = year;
  }

  void displayDetails() {
    System.out.println(year + " " + make + " " + model);
  }

  public static void main(String[] args) {
    Car car1 = new Car("Toyota", "Camry", 2022);
    car1.displayDetails();

    Car car2 = new Car("Honda", "Civic", 2020);
    car2.displayDetails();
  }
}
