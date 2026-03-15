package oops;

// Inheritance: child class acquires properties and methods of parent class

// Parent (Base) class
class Animal {
    String name;
    int    age;

    Animal(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    void eat()   { System.out.println(name + " is eating"); }
    void sleep() { System.out.println(name + " is sleeping"); }

    void display() {
        System.out.println("Animal -> Name: " + name + ", Age: " + age);
    }
}

// Child (Derived) class - inherits Animal
class Dog extends Animal {
    String breed;

    Dog(String name, int age, String breed) {
        super(name, age);  // calls Animal constructor
        this.breed = breed;
    }

    void bark() { System.out.println(name + " says: Woof!"); }

    // Method Overriding - redefining parent method in child
    @Override
    void display() {
        super.display();  // call parent display
        System.out.println("Dog  -> Breed: " + breed);
    }
}

// Multi-level inheritance
class GoldenRetriever extends Dog {

    GoldenRetriever(String name, int age) {
        super(name, age, "Golden Retriever");
    }

    void fetch() { System.out.println(name + " is fetching the ball!"); }
}

public class Inheritance {
    public static void main(String[] args) {
        Dog dog = new Dog("Rex", 3, "Labrador");
        dog.eat();      // inherited from Animal
        dog.bark();     // Dog's own method
        dog.display();  // overridden display

        System.out.println("---");

        GoldenRetriever gr = new GoldenRetriever("Buddy", 2);
        gr.eat();    // from Animal (2 levels up)
        gr.bark();   // from Dog
        gr.fetch();  // own method
        gr.display();
    }
}
