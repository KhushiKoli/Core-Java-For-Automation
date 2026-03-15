package oops;

// Java supports 4 types of inner/nested classes

public class InnerClasses {

    String outerField = "I am Outer";

    // ─── 1. Static Nested Class - doesn't need outer class instance ───
    static class StaticNested {
        void show() { System.out.println("Static Nested class"); }
    }

    // ─── 2. Inner Class (Non-static) - needs outer class instance ───
    class Inner {
        void show() {
            // can access outer class members
            System.out.println("Inner class | Outer field: " + outerField);
        }
    }

    // ─── 3. Local Class - defined inside a method ───
    void localClassDemo() {
        String localVar = "local variable";

        class Local {
            void show() {
                System.out.println("Local class | " + localVar);  // can access effectively final local vars
            }
        }
        new Local().show();
    }

    // ─── 4. Anonymous Class - one-time use, instantiated inline ───
    interface Greeting {
        void greet(String name);
    }

    public static void main(String[] args) {
        InnerClasses outer = new InnerClasses();

        // 1. Static nested - no outer instance needed
        StaticNested sn = new StaticNested();
        sn.show();

        // 2. Inner class - needs outer instance
        Inner inner = outer.new Inner();
        inner.show();

        // 3. Local class
        outer.localClassDemo();

        // 4. Anonymous class - implements interface on-the-fly
        Greeting morningGreet = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("Good Morning, " + name + "!");
            }
        };
        morningGreet.greet("Alice");

        // Same thing but shorter with Lambda (Java 8+) - functional interface
        Greeting eveningGreet = name -> System.out.println("Good Evening, " + name + "!");
        eveningGreet.greet("Bob");
    }
}
