package controlflow;

public class BreakContinueExample {
    public static void main(String[] args) {

        // Break Example
        System.out.println("--- Break Example ---");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Loop stopped at: " + i);
                break;
            }
            System.out.println("i = " + i);
        }

        // Continue Example
        System.out.println("--- Continue Example ---");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Skip even numbers
            }
            System.out.println("Odd number: " + i);
        }

        // Nested Loop with Break
        System.out.println("--- Nested Loop ---");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.println("i=" + i + " j=" + j);
            }
        }
    }
}