package oops;

// Class = blueprint, Object = instance of the blueprint
public class ClassAndObject {

    // Instance variables (fields)
    String brand;
    int year;
    double price;

    // Constructor - called when object is created
    ClassAndObject(String brand, int year, double price) {
        this.brand = brand;
        this.year  = year;
        this.price = price;
    }

    // Instance method
    void displayInfo() {
        System.out.println("Brand: " + brand + " | Year: " + year + " | Price: $" + price);
    }

    public static void main(String[] args) {
        // Creating objects (instances)
        ClassAndObject car1 = new ClassAndObject("Toyota", 2022, 25000.0);
        ClassAndObject car2 = new ClassAndObject("Honda",  2023, 28000.0);

        car1.displayInfo();  // Brand: Toyota | Year: 2022 | Price: $25000.0
        car2.displayInfo();  // Brand: Honda  | Year: 2023 | Price: $28000.0

        // Accessing fields directly
        System.out.println("Car1 brand: " + car1.brand);
    }
}
