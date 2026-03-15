package oops;

// Abstraction: hide implementation details, show only essential features

// Abstract class - cannot be instantiated directly ( we can't create an object directly that need to be inherit)
abstract class Vehicle {
    String brand;
    int    speed;

    Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // Abstract method - no body, must be implemented by subclass
    abstract void start();
    abstract void fuelType();

    // Concrete method - has body, inherited as-is
    void displayInfo() {
        System.out.println("Brand: " + brand + " | Speed: " + speed + " km/h");
    }
}

// Concrete class must implement ALL abstract methods
class Car extends Vehicle {

    Car(String brand, int speed) { super(brand, speed); }

    @Override
    void start()    { System.out.println(brand + " starts with ignition key"); }

    @Override
    void fuelType() { System.out.println(brand + " runs on Petrol/Diesel"); }
}

class ElectricBike extends Vehicle {

    ElectricBike(String brand, int speed) { super(brand, speed); }

    @Override
    void start()    { System.out.println(brand + " starts with push button"); }

    @Override
    void fuelType() { System.out.println(brand + " runs on Electricity"); }
}

public class Abstraction {
    public static void main(String[] args) {

        // Vehicle v = new Vehicle("X", 100);  // ❌ Cannot instantiate abstract class

        Vehicle car  = new Car("Toyota", 180);
        Vehicle bike = new ElectricBike("Ather", 120);

        car.start();       // Toyota starts with ignition key
        car.fuelType();    // Toyota runs on Petrol/Diesel
        car.displayInfo(); // Brand: Toyota | Speed: 180 km/h

        System.out.println("---");

        bike.start();
        bike.fuelType();
        bike.displayInfo();
    }
}
