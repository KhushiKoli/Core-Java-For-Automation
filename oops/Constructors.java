package oops;

public class Constructors {

    String name;
    int    age;

    // 1. Default constructor (no args)
    Constructors() {
        this.name = "Unknown";
        this.age  = 0;
        System.out.println("Default constructor called");
    }

    // 2. Parameterized constructor
    Constructors(String name, int age) {
        this.name = name;
        this.age  = age;
        System.out.println("Parameterized constructor called");
    }

    // 3. Copy constructor - copies another object
    Constructors(Constructors other) {
        this.name = other.name;
        this.age  = other.age;
        System.out.println("Copy constructor called");
    }

    // 4. Constructor chaining using this()
    Constructors(String name) {
        this(name, 18);  // calls parameterized constructor
        System.out.println("Chained constructor called");
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Constructors p1 = new Constructors();             // default
        Constructors p2 = new Constructors("Alice", 30); // parameterized
        Constructors p3 = new Constructors(p2);          // copy of p2
        Constructors p4 = new Constructors("Bob");        // chained

        p1.display();  // Name: Unknown, Age: 0
        p2.display();  // Name: Alice,   Age: 30
        p3.display();  // Name: Alice,   Age: 30  (copy)
        p4.display();  // Name: Bob,     Age: 18  (chained default age)
    }
}
