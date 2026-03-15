package oops;

// static: belongs to class, not object
// final:  cannot be changed/overridden/extended

public class StaticAndFinal {

    // static variable - shared across ALL instances
    static int instanceCount = 0;
    String name;

    // static final = constant
    static final double PI = 3.14159;

    StaticAndFinal(String name) {
        this.name = name;
        instanceCount++;  // increments every time an object is created
    }

    // static method - can be called without creating an object
    static void showCount() {
        System.out.println("Total objects created: " + instanceCount);
    }

    // final method - cannot be overridden in subclass
    final void signature() {
        System.out.println("I am: " + name);
    }

    // static nested utility - utility-style usage
    static int square(int n) { return n * n; }

    public static void main(String[] args) {

        // static access: via class name (not object)
        System.out.println("PI = " + StaticAndFinal.PI);
        StaticAndFinal.showCount();   // Total objects created: 0

        StaticAndFinal a = new StaticAndFinal("Alpha");
        StaticAndFinal b = new StaticAndFinal("Beta");
        StaticAndFinal c = new StaticAndFinal("Gamma");

        StaticAndFinal.showCount();   // Total objects created: 3

        // All objects share the same instanceCount
        System.out.println(a.instanceCount);  // 3
        System.out.println(b.instanceCount);  // 3

        a.signature();
        System.out.println(StaticAndFinal.square(5));  // 25

        // final local variable
        final int MAX = 100;
        // MAX = 200;  // ❌ Cannot reassign final variable
        System.out.println("MAX = " + MAX);
    }
}

// final class - cannot be extended (e.g. String, Integer in Java are final)
final class Utility {
    static String greet(String name) { return "Hello, " + name + "!"; }
}

// class ExtendUtility extends Utility { }  // ❌ Cannot extend final class
