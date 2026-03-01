package basics;

public class TypeCastingExample {
    public static void main(String[] args) {
        // Widening - Automatic (small to large)
        int i = 100;
        long l = i;
        double d = l;
        System.out.println("Widening -> int to double: " + d);

        // Narrowing - Manual (large to small)
        double x = 9.78;
        int y = (int) x;
        System.out.println("Narrowing -> double to int: " + y);

        // char to int
        char ch = 'A';
        int ascii = ch;
        System.out.println("Char to int (ASCII): " + ascii);

        // int to char
        int code = 66;
        char letter = (char) code;
        System.out.println("Int to char: " + letter);
    }
}