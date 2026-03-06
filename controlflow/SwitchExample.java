package controlflow;

public class SwitchExample {
    public static void main(String[] args) {

        // Switch with int
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Weekend");
        }

        // Switch with String
        String browser = "Chrome";
        switch (browser) {
            case "Chrome":
                System.out.println("Launching Chrome Browser");
                break;
            case "Firefox":
                System.out.println("Launching Firefox Browser");
                break;
            case "Edge":
                System.out.println("Launching Edge Browser");
                break;
            default:
                System.out.println("Browser not supported");
        }
    }
}