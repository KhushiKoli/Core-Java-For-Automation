
package basics;

//With method overloading, multiple methods can have the same name with different parameters:
//Multiple methods can have the same name as long as the number and/or type of parameters are different.
//Shows: polymorphism at compile time
public class MethodOverloadingExample {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        MethodOverloadingExample obj = new MethodOverloadingExample();
        System.out.println(obj.add(10, 20));
        System.out.println(obj.add(10.5, 5.5));
        System.out.println(obj.add(1, 2, 3));
    }
}
