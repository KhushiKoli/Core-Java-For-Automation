package basics;

public class Operators {
    public static void main(String[] args) {
        int a = 10, b = 3;

        // Arithmetic
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulus: " + (a % b));

        // Relational
        System.out.println("a > b: " + (a > b));
        System.out.println("a == b: " + (a == b));

        // Logical
        System.out.println("a>5 && b<5: " + (a > 5 && b < 5));
        System.out.println("a>5 || b>5: " + (a > 5 || b > 5));

        // Increment/Decrement
        System.out.println("a++: " + a++);
        System.out.println("++a: " + (++a));
    }
}