package oops;

// this  = refers to current class instance
// super = refers to parent class

class Person {
    String name;
    int    age;

    Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    void display() {
        System.out.println("Person -> Name: " + name + ", Age: " + age);
    }
}

class Employee extends Person {
    String company;
    double salary;

    // Using this() to chain constructors within same class
    Employee(String name, int age) {
        this(name, age, "Unknown", 0);  // calls 4-arg constructor below
    }

    Employee(String name, int age, String company, double salary) {
        super(name, age);          // 1. must be first line - calls Person constructor
        this.company = company;    // 2. this.field resolves ambiguity
        this.salary  = salary;
    }

    // this as method argument - passing current object
    void printSelf() {
        display(this);  // pass current object to a static helper
    }

    static void display(Employee e) {
        System.out.println("Displaying employee: " + e.name);
    }

    @Override
    void display() {
        super.display();  // call Person's display first
        System.out.println("Employee -> Company: " + company + ", Salary: $" + salary);
    }
}

public class ThisAndSuper {
    public static void main(String[] args) {

        Employee e1 = new Employee("Alice", 30, "Google", 120000);
        e1.display();
        // Person -> Name: Alice, Age: 30
        // Employee -> Company: Google, Salary: $120000.0

        System.out.println("---");

        Employee e2 = new Employee("Bob", 25);  // uses chained constructor
        e2.display();
        // Person -> Name: Bob, Age: 25
        // Employee -> Company: Unknown, Salary: $0.0

        System.out.println("---");

        e1.printSelf();  // Displaying employee: Alice
    }
}
