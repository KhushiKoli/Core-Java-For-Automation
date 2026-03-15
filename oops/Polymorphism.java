package oops;

// Polymorphism: same method name, different behavior

// ─── 1. Compile-time Polymorphism: Method Overloading ───
class Calculator {

    // same method name, different parameters
    int    add(int a, int b)               { return a + b; }
    int    add(int a, int b, int c)        { return a + b + c; }
    double add(double a, double b)         { return a + b; }
    String add(String a, String b)         { return a + b; }  // string concat
}

// ─── 2. Runtime Polymorphism: Method Overriding ───
class Shape {
    void draw() { System.out.println("Drawing a Shape"); }
    double area() { return 0; }
}

class Circle extends Shape {
    double radius;
    Circle(double r) { this.radius = r; }

    @Override void draw()        { System.out.println("Drawing Circle"); }
    @Override double area()      { return Math.PI * radius * radius; }
}

class Rectangle extends Shape {
    double width, height;
    Rectangle(double w, double h) { this.width = w; this.height = h; }

    @Override void draw()        { System.out.println("Drawing Rectangle"); }
    @Override double area()      { return width * height; }
}

public class Polymorphism {
    public static void main(String[] args) {

        // Overloading
        Calculator calc = new Calculator();
        System.out.println(calc.add(2, 3));          // 5
        System.out.println(calc.add(1, 2, 3));       // 6
        System.out.println(calc.add(1.5, 2.5));      // 4.0
        System.out.println(calc.add("Hello", " World")); // Hello World

        System.out.println("---");

        // Runtime polymorphism - parent reference, child object
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(4, 6);

        // Which draw() is called is decided at RUNTIME (not compile time)
        Shape[] shapes = { s1, s2, new Circle(3) };
        for (Shape shape : shapes) {
            shape.draw();
            System.out.printf("Area: %.2f%n", shape.area());
        }
    }
}
