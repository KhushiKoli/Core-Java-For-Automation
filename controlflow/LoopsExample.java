package controlflow;

public class LoopsExample {
    public static void main(String[] args) {

        // For Loop
        System.out.println("--- For Loop ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }

        // While Loop
        System.out.println("--- While Loop ---");
        int i = 1;
        while (i <= 5) {
            System.out.println("While: " + i);
            i++;
        }

        // Do-While Loop
        System.out.println("--- Do-While Loop ---");
        int j = 1;
        do {
            System.out.println("Do-While: " + j);
            j++;
        } while (j <= 5);

        // For-Each Loop
        System.out.println("--- For-Each Loop ---");
        String[] browsers = {"Chrome", "Firefox", "Edge", "Safari"};
        for (String browser : browsers) {
            System.out.println("Browser: " + browser);
        }
    }
}