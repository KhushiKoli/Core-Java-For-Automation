package oops;

// Interface: 100% abstraction - only abstract methods (until Java 8 default methods)

interface Flyable {
    int MAX_ALTITUDE = 10000; // implicitly public static final

    void fly();               // implicitly public abstract
    void land();

    // Default method (Java 8+) - has a body, optional to override
    default void status() {
        System.out.println("Flyable object is operational");
    }
}

interface Swimmable {
    void swim();

    default void status() {
        System.out.println("Swimmable object is operational");
    }
}

// A class can implement multiple interfaces (unlike extends, only one class)
class Duck implements Flyable, Swimmable {

    String name;
    Duck(String name) { this.name = name; }

    @Override public void fly()  { System.out.println(name + " is flying up to " + MAX_ALTITUDE + "m"); }
    @Override public void land() { System.out.println(name + " has landed"); }
    @Override public void swim() { System.out.println(name + " is swimming"); }

    // Must override conflicting default methods from multiple interfaces
    @Override
    public void status() {
        Flyable.super.status();    // explicitly call one
        System.out.println(name + " can both fly and swim!");
    }
}

// Interface extending another interface
interface Printable {
    void print();
}

interface Saveable extends Printable {
    void save();  // inherits print() too
}

class Document implements Saveable {
    String content;
    Document(String content) { this.content = content; }

    @Override public void print() { System.out.println("Printing: " + content); }
    @Override public void save()  { System.out.println("Saving: "   + content); }
}

public class Interfaces {
    public static void main(String[] args) {
        Duck duck = new Duck("Donald");
        duck.fly();
        duck.swim();
        duck.land();
        duck.status();

        System.out.println("---");

        // Interface as reference type (polymorphism)
        Flyable f = new Duck("Daffy");
        f.fly();
        // f.swim();  // ❌ Not accessible via Flyable reference

        System.out.println("---");

        Document doc = new Document("Java Notes");
        doc.print();
        doc.save();
    }
}
