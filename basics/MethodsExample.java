package basics;

public class MethodsExample {

    public void greet() {
        System.out.println("Hello from method");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        MethodsExample obj = new MethodsExample();
        obj.greet();
        System.out.println(obj.add(5, 10));
    }
}
